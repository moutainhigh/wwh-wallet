package com.wwh.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wwh.security.ShiroRealm;

/**
 * Shiro 配置
 * 
 * @author wwh
 *
 */
@Configuration
public class ShiroConfiguration extends DataBaseConfiguration {

	private static Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

	@Bean(name = "shiroRealm")
	public ShiroRealm getShiroRealm() {
		ShiroRealm sr = new ShiroRealm();
		return sr;
	}

	@Bean(name = "shiroEhcacheManager")
	public EhCacheManager getEhCacheManager() {
		EhCacheManager em = new EhCacheManager();
		em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
		return em;
	}

	@Bean(name = "lifecycleBeanPostProcessor")
	public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
		return new LifecycleBeanPostProcessor();
	}

	@Bean
	public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
		daap.setProxyTargetClass(true);
		return daap;
	}

	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager() {
		DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
		dwsm.setRealm(getShiroRealm());
		dwsm.setCacheManager(getEhCacheManager());
		return dwsm;
	}

	@Bean
	public AuthorizationAttributeSourceAdvisor getAuthorizationAttributeSourceAdvisor() {
		AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
		aasa.setSecurityManager(getDefaultWebSecurityManager());
		return new AuthorizationAttributeSourceAdvisor();
	}

	@Bean(name = "shiroFilter")
	public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(getDefaultWebSecurityManager());
		shiroFilterFactoryBean.setLoginUrl("/index");// unauthorized
		shiroFilterFactoryBean.setUnauthorizedUrl("/forbidden");
		shiroFilterFactoryBean.setSuccessUrl("/success");
		filterChainDefinitionMap.put("/regin", "anon");
		filterChainDefinitionMap.put("/index", "anon");
		filterChainDefinitionMap.put("/login", "anon");
		filterChainDefinitionMap.put("/", "anon");
		filterChainDefinitionMap.put("/validateCode", "anon");
		filterChainDefinitionMap.put("/wxlogin", "anon");
		filterChainDefinitionMap.put("/choosepayamount", "anon");
		filterChainDefinitionMap.put("/wenxinpay", "anon");
		filterChainDefinitionMap.put("/pages/con", "anon");
		filterChainDefinitionMap.put("/pages/loginwx", "anon");
		filterChainDefinitionMap.put("/createCode", "anon");
		filterChainDefinitionMap.put("/logout", "anon");
		filterChainDefinitionMap.put("/verifyToken", "anon");
		filterChainDefinitionMap.put("/disk/diskall", "anon");
		filterChainDefinitionMap.put("/pay/pre", "anon");
		filterChainDefinitionMap.put("/msg/sendMsg", "anon");
		filterChainDefinitionMap.put("/ttmsg/verifyMsg", "anon");
		filterChainDefinitionMap.put("/ttmsg/sendMsg", "anon");
		filterChainDefinitionMap.put("/msg/verifyMsg", "anon");
		filterChainDefinitionMap.put("/registerMember", "anon");
		filterChainDefinitionMap.put("/checkMobilePhoneExsits", "anon");
		filterChainDefinitionMap.put("/mweixin/toPay", "anon");
		filterChainDefinitionMap.put("/mweixin/wenxinpay", "anon");
		filterChainDefinitionMap.put("/modifyBasicUserInfo", "anon");

		filterChainDefinitionMap.put("/mobile/updatepassword/**", "anon");
		filterChainDefinitionMap.put("/mobile/getuserinfo/**", "anon");
		// 手机端微信支付接口
		filterChainDefinitionMap.put("/wx/mweixinpay", "anon");
		// 微信回调
		filterChainDefinitionMap.put("/wx/returnhuidiao", "anon");
		// 支付宝回调
		filterChainDefinitionMap.put("/alipay/alipaynotify", "anon");
		filterChainDefinitionMap.put("/withraw/getwithrawdetail/**", "anon");
		filterChainDefinitionMap.put("/disk/diskitem/**", "anon");
		filterChainDefinitionMap.put("/index/loggedon", "anon");
		filterChainDefinitionMap.put("/unionpay/BackRcvResponse", "anon");
		filterChainDefinitionMap.put("/unionpay/frontRcvResponse", "anon");
		filterChainDefinitionMap.put("/nonlanding", "anon");
		filterChainDefinitionMap.put("/toScore", "anon");
		filterChainDefinitionMap.put("/unauthorized", "anon");
		filterChainDefinitionMap.put("/forbidden", "anon");
		filterChainDefinitionMap.put("/**/api-docs/**", "anon");
		filterChainDefinitionMap.put("/static/**", "anon");
		filterChainDefinitionMap.put("/callback/**", "anon");
		filterChainDefinitionMap.put("/swagger/**", "anon");
		filterChainDefinitionMap.put("/css/**", "anon");
		filterChainDefinitionMap.put("/font/**", "anon");
		filterChainDefinitionMap.put("/images/**", "anon");
		filterChainDefinitionMap.put("/js/**", "anon");
		filterChainDefinitionMap.put("/pages/**", "anon");
		filterChainDefinitionMap.put("/**", "authc,user");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		return shiroFilterFactoryBean;
	}
}
