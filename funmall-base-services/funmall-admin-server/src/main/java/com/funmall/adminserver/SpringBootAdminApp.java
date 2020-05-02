package com.funmall.adminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 服务监控
 *
 */

@EnableAdminServer
@SpringBootApplication
public class SpringBootAdminApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringBootAdminApp.class,args);
    }
}
