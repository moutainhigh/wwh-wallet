package com.wwh.security;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wwh.service.IUserService;
import com.wwh.util.StringUtils;
import com.wwh.vo.UserVO;

/**
 * ShiroRealm
 * @author wwh
 *
 */
public class ShiroRealm extends AuthorizingRealm{
	
	private static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
	private static final String CURRENT_USER = "CURRENT_USER";
	
	
	@Autowired
	private IUserService userService; 
	
	//@Autowired
	//private IMemberService memberService;
	
	// 权限
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String userId = "";
        Subject currentUser = SecurityUtils.getSubject();
		if (null != currentUser) {
			try {
                Session session = currentUser.getSession();
                if (null != session) {
                	userId = (String) session.getAttribute(CURRENT_USER);
                }
            } catch (InvalidSessionException e) {
                logger.error(e.toString());
            }
		}
		long uId = 0;
		uId = StringUtils.isEmpty(userId) ? uId :Long.parseLong(userId);
        UserVO sysUser = userService.getUserRole(uId);
        info.addRoles(sysUser.getRolesName());
        Map<String,Object> map = new HashMap<String,Object>();
		map.put("ids", sysUser.getRolesId());
		List<Map<String,Object>> list = userService.getRolePrivilege(map);
		Set<String> set = new HashSet<String>();
		for(Map<String,Object> lt :list){
			set.add(String.valueOf(lt.get("privilegeName")));
		}
		info.addStringPermissions(set);
		info.addStringPermission("user");
        return info;
    }

    // 登录验证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
        throws AuthenticationException {
		UsernamePasswordToken token=(UsernamePasswordToken) authcToken;
		logger.info("验证当前Subject时获取到token为：" + ReflectionToStringBuilder.toString(token, ToStringStyle.MULTI_LINE_STYLE)); 
		String loginName = token.getUsername();
		long userId = 0; 
		userId = StringUtils.isEmpty(loginName) ? userId :Long.parseLong(loginName);
		StringBuilder sb = new StringBuilder(100);
		for (int i = 0; i < token.getPassword().length; i++) {
			sb.append(token.getPassword()[i]);
		}
		try {
				UserVO user = userService.getUserRole(userId);
				if(user != null){
					if (user.getPassword().equals(sb.toString())) {
						Subject currentUser = SecurityUtils.getSubject();
						logger.info("当前Subject为："+currentUser);
						if (null != currentUser) {
							Session session = currentUser.getSession();
							logger.info("当前session为："+session);
							if (null != session) {
								session.setAttribute(CURRENT_USER, userId);
								logger.info("登录验证成功："+userId);
							}
						}
						//saveSession(user.getUserId());
						AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getUserId(), user.getPassword(),
								user.getUserName());
						return authcInfo;
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }

    /** 保存session */
//    private void saveSession(String account) {
//        // 踢出用户
//        sysSessionService.deleteByAccount(account);
//        SysSession record = new SysSession();
//        record.setAccount(account);
//        Subject currentUser = SecurityUtils.getSubject();
//        Session session = currentUser.getSession();
//        record.setSessionId(session.getId().toString());
//        String host = (String)session.getAttribute("HOST");
//        record.setIp(StringUtils.isBlank(host) ? session.getHost() : host);
//        record.setStartTime(session.getStartTimestamp());
//        sysSessionService.update(record);
//    }
}

