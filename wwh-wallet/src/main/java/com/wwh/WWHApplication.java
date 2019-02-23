package com.wwh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.wwh.vo.WalletVO;

@MapperScan("com.wwh.dao")
@SpringBootApplication
@ServletComponentScan
@EnableConfigurationProperties(WalletVO.class)
@EnableScheduling
public class WWHApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WWHApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(WWHApplication.class, args);
	}
}
