package com.funmall.commons.controller;

import com.funmall.commons.enums.MimeType;
import com.funmall.commons.error.SystemMessage;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public abstract class BaseController {

    public static final String CHARSET = "UTF-8";
    @Resource
    protected HttpSession session;
    //    protected Log logger = LogFactory.getLog(getClass());
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 编码文件名
     *
     * @param filename
     * @param request
     * @return
     */
    private static String encodeFilename(String filename, HttpServletRequest request) {
        /**
         * 获取客户端浏览器和操作系统信息
         * 在IE浏览器中得到的是：User-Agent=Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; Maxthon; Alexa Toolbar)
         * 在Firefox中得到的是：User-Agent=Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.7.10) Gecko/20050717 Firefox/1.0.6
         */
        String agent = request.getHeader("USER-AGENT");
        try {
            if ((agent != null) && (-1 != agent.indexOf("MSIE"))) {
                String newFileName = URLEncoder.encode(filename, "UTF-8");
                newFileName = StringUtils.replace(newFileName, "+", "%20");
                if (newFileName.length() > 150) {
                    newFileName = new String(filename.getBytes("GB2312"), "ISO8859-1");
                    newFileName = StringUtils.replace(newFileName, " ", "%20");
                }
                return newFileName;
            }
            if ((agent != null) && (-1 != agent.indexOf("Mozilla"))) {
                return new String(filename.getBytes("UTF-8"), "ISO8859-1");
            }
            return filename;
        } catch (Exception ex) {
            return filename;
        }
    }

    /**
     * 获取客户端Ip
     *
     * @return
     */
    protected String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 流预览
     *
     * @param input
     * @param mime
     * @param response
     * @throws IOException
     */
    protected void preview(InputStream input, MimeType mime, HttpServletResponse response) throws IOException {
        if (input == null) {
            return;
        }
        if (mime == MimeType.AUTO) {
            throw SystemMessage.NOT_SUPPORT_OPERATOR.exception("预览需要设置 mime 类型,无法自动获取");
        }

        response.setContentType(mime.getContentType());
        response.setHeader("Set-Cookie", "fileDownload=true; path=/");
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(input, output);
        output.flush();
    }

    /**
     * 下载流
     *
     * @param input
     * @param mime
     * @param fileName
     * @param response
     * @throws IOException
     */
    protected void download(InputStream input, MimeType mime, String fileName, HttpServletResponse response) throws IOException {
        if (input == null) {
            return;
        }
        boolean isAuto = false;
        if (mime == MimeType.AUTO) {
            String extension = FilenameUtils.getExtension(fileName);
            mime = MimeType.parseMIME(extension);
            isAuto = true;
        }
        response.setContentType(mime.getContentType());
        response.setHeader("Set-Cookie", "fileDownload=true; path=/");

        String suffix = mime.getSuffix();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String encodeFileName = encodeFilename(fileName, request);
        if (StringUtils.isNotBlank(suffix) && !isAuto) {
            encodeFileName += ("." + mime.getSuffix());
        }

        response.setHeader("Content-Disposition", "attachment;filename=\"" + encodeFileName + "\"");
        long length = input.available();
        if (length != -1 && length != 0) {
            response.setContentLength((int) length);
        }
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(input, output);
        output.flush();
    }


}
