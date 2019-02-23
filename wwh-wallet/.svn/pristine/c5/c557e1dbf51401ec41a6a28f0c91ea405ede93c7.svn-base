package com.wwh.config;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import com.wwh.common.DynamicDataSource;
import com.wwh.enums.DatabaseType;

/**
 * 
 * @ClassName: DataBaseConfiguration
 * @Description: druid链接池数据源配置
 * @author: ranletian
 * @date: 2016年10月25日 上午11:39:05
 */
@Configuration
@EnableTransactionManagement
public class DataBaseConfiguration {

	@Bean
	@ConfigurationProperties(prefix = "wallet.spring.datasource")
	public DruidDataSource walletdataSource() throws Exception {
		return new DruidDataSource();
	}

	@Bean
	@ConfigurationProperties(prefix = "mall.spring.datasource")
	public DruidDataSource mallDataSource() throws Exception {
		return new DruidDataSource();
	}

	@Bean
	@Primary
	public DynamicDataSource dataSource(@Qualifier("walletdataSource") DruidDataSource walletdataSource,
			@Qualifier("mallDataSource") DruidDataSource mallDataSource) throws Exception {

		walletdataSource.setUsername(ConfigTools.decrypt(walletdataSource.getUsername()));
		walletdataSource.setPassword(ConfigTools.decrypt(walletdataSource.getPassword()));
		walletdataSource.setUrl(walletdataSource.getUrl()
				+ "?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&autoReconnect=true");

		mallDataSource.setUsername(ConfigTools.decrypt(mallDataSource.getUsername()));
		mallDataSource.setPassword(ConfigTools.decrypt(mallDataSource.getPassword()));
		mallDataSource.setUrl(mallDataSource.getUrl()
				+ "?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&autoReconnect=true");

		Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
		targetDataSources.put(DatabaseType.walletdataSource, walletdataSource);
		targetDataSources.put(DatabaseType.mallDataSource, mallDataSource);
		
		DynamicDataSource dataSource = new DynamicDataSource();
		dataSource.setTargetDataSources(targetDataSources);
		dataSource.setDefaultTargetDataSource(walletdataSource);
		return dataSource;
	}

	// 提供SqlSeesion
	@Bean
	public SqlSessionFactory sqlSessionFactoryBean(DynamicDataSource ds) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(ds);
		// 分页插件
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("reasonable", "true");
		properties.setProperty("supportMethodsArguments", "true");
		properties.setProperty("returnPageInfo", "check");
		properties.setProperty("params", "count=countSql");
		pageHelper.setProperties(properties);
		// 添加插件
		sqlSessionFactoryBean.setPlugins(new Interceptor[] { pageHelper });

		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setTypeAliasesPackage("com.wwh.vo");
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
		// 读取本包，子包所有.xml文件
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager(DynamicDataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}
