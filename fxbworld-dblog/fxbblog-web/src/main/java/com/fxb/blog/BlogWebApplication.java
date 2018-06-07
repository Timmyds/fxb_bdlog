
package com.fxb.blog;

import com.fxb.blog.business.consts.DateConst;
import com.fxb.blog.util.DateUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

/**
 * 程序启动类
 *
 * @author  
 * @website  
 * @version 1.0
 * @date 2018/4/18 11:48
 * @since 1.0
 */
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class BlogWebApplication implements ApplicationRunner {

	private static final Logger LOG = LoggerFactory.getLogger(BlogWebApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BlogWebApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments applicationArguments) {
		LOG.info("博客部署完成，当前时间：" + DateUtil.date2Str(new Date(), DateConst.YYYY_MM_DD_HH_MM_SS_EN));
	}
}
