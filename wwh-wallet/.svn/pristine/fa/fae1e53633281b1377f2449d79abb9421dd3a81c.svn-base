package com.wwh.config;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

/**
 * 
 * @ClassName: BeetlConfiguration 
 * @Description: Beetl模板配置
 * @author: ranletian
 * @date: 2016年10月25日 上午11:38:43
 */
@Configuration
public class BeetlConfiguration {
	
	private static Logger logger = LogManager.getLogger(BeetlConfiguration.class);

	@Bean(initMethod = "init", name = "beetlConfig")
	public static BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
		BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
		ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
		try {
			// WebAppResourceLoader 配置root路径是关键
			WebAppResourceLoader webAppResourceLoader = new WebAppResourceLoader(patternResolver.getResource("classpath:/static/pages/").getFile().getPath());
			beetlGroupUtilConfiguration.setResourceLoader(webAppResourceLoader);
			// 读取配置文件信息
			beetlGroupUtilConfiguration.setConfigFileResource(patternResolver.getResource("classpath:/beetl.properties"));
		} catch (IOException e) {
			logger.error("getBeetlGroupUtilConfiguration error",e);
		}
		return beetlGroupUtilConfiguration;
	}

	@Bean(name = "beetlViewResolver")
	public static BeetlSpringViewResolver getBeetlSpringViewResolver(
			@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
		BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
		beetlSpringViewResolver.setPrefix("/");
		beetlSpringViewResolver.setSuffix(".html");
		beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
		beetlSpringViewResolver.setOrder(0);
		beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
		return beetlSpringViewResolver;
	}
}
