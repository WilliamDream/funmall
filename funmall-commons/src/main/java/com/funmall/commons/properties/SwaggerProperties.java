package com.funmall.commons.properties;

import lombok.Data;

/**
 * @Author: WilliamDream
 * @Description:
 */
@Data
public class SwaggerProperties {

    private String title;

    private String description;

    private String version = "1.0";

    private String license = "Apache License 2.0";

    private String licenseUrl = "http://www.apache.org/licenses/LICENSE-2.0";

    private String contactName = "无痕";

    private String contactUrl = "http://williamdream.com";

    private String contactEmail = "3339642010@qq.com";

}
