
package com.fxb.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;



@SpringBootApplication
@EnableScheduling
public class BlogAdminApplication extends SpringBootServletInitializer
{
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder)
  {
    return builder.sources(new Class[] { BlogAdminApplication.class });
  }

  public static void main(String[] args) {
    SpringApplication.run(BlogAdminApplication.class, args);
  }
}
/**
 * 程序启动类
 *
 * @author  
 * @version 1.0
 * @website  
 * @date 2018/4/24 14:37
 * @since 1.0
 *//*
@SpringBootApplication
@ServletComponentScan
public class BlogAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogAdminApplication.class, args);
    }
}
*/