package com.wwh.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wwh.common.ResultMsg;
import com.wwh.service.IMemberService;
import com.wwh.service.IUserService;
import com.wwh.service.IUserTokenService;
import com.wwh.util.DESUtils;
import com.wwh.util.HttpRequestUtil;
import com.wwh.util.MD5Utils;
import com.wwh.util.ReturnConstant;
import com.wwh.util.SignUtil;
import com.wwh.util.StringUtils;
import com.wwh.util.UUidUtil;
import com.wwh.vo.UserTokenVO;
import com.wwh.vo.UserVO;
import com.wwh.vo.WalletVO;

import net.sf.json.JSONObject;

/**
 * 
 * @author wwh
 *
 */
@Controller
public class ShiroController {

    private static final Logger logger = LoggerFactory.getLogger(ShiroController.class);

	@Autowired
	private IUserService userService; 
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private IUserTokenService userTokenService;
	
	@Autowired
	private WalletVO walletVO; 
	
	private static final String roleName ="MEMBER";
	
	//推荐商家 商家入驻   我的订单   我的关注  我的购物车数量  top5推荐 
	private String [] walletDoUrl = {"seller/userRecomed.do","seller/register.do","member/center.do","member/center.do","memberShopingCar/queryMemberShopingCar.do","noredirect","RecommendSeller.do"};

	
	/**
	 * 登陆
	 * @param vo
	 * @param request
	 * @param redirectAttributes
	 * @return
	 */
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public ResultMsg<Object> userLogin(@RequestBody UserVO vo,HttpServletRequest request, RedirectAttributes redirectAttributes){
    		ResultMsg<Object> rs = new ResultMsg<Object>();
    	try {
    		String username = vo.getUserName();
	    	String password = vo.getPassword();
	    	String userName = username;
	    	Map<String,Object> queryLoginParm = new HashMap<String,Object>();
	    	queryLoginParm.put("userName", userName);
	    	List<Map<String,Object>> un  = userService.queryUserIdByLogin(queryLoginParm);
	    	username = un.size() > 0 ? String.valueOf(un.get(0).get("userId")):"";
	        UsernamePasswordToken token = new UsernamePasswordToken(username, MD5Utils.encryptMD5(password));
	        Subject currentUser = SecurityUtils.getSubject();  
            token.setRememberMe(true);
//            InetAddress addr = InetAddress.getLocalHost();
//            token.setHost(addr.getHostAddress().toString());
            currentUser.login(token);
            long uId = 0;
    		uId = StringUtils.isEmpty(username) ? uId :Long.parseLong(username);
            UserVO user = userService.getUserRole(uId);
            Set<String> rolesName = user.getRolesName();
            boolean isMember = rolesName.contains(roleName);
            if(isMember){
            	List<Map<String,Object>> list =  memberService.getMemberById(uId);
            	if(list.size() > 0){
            		Map<String,Object> data = list.get(0);
            		data.remove("password");
            		rs.setData(data);
            	}
            }
            rs.setReturnCode(ReturnConstant.RETURN_CODE_200);
            rs.setReturnMsg(ReturnConstant.RETURN_MSG_900);
        }//catch(UnknownHostException e){
//        	e.printStackTrace();
//        }
    	catch(LockedAccountException lae){
        	rs.setReturnCode(ReturnConstant.RETURN_CODE_901);
            rs.setReturnMsg(ReturnConstant.RETURN_MSG_901); 
        }catch(ExcessiveAttemptsException eae){  
        	rs.setReturnCode(ReturnConstant.RETURN_CODE_902);
            rs.setReturnMsg(ReturnConstant.RETURN_MSG_902);  
        }catch(AuthenticationException ae){  
        	rs.setReturnCode(ReturnConstant.RETURN_CODE_903);
            rs.setReturnMsg(ReturnConstant.RETURN_MSG_903);  
        }
        return rs;
    }

    /**
     * 钱包跳转商城
     * @return
     */
    @SuppressWarnings("deprecation")
	@RequestMapping(value="/createToken",method=RequestMethod.POST)
    @ResponseBody
    public ResultMsg<Object> createToken(HttpServletRequest request,HttpServletResponse rep){
    	ResultMsg<Object> rs = new ResultMsg<Object>();
    	rs.setReturnCode("0");
		rs.setReturnMsg("created token fail");
    	logger.info("进入createToken1*******************");
    	String urlinx = request.getParameter("urlinx");
    	urlinx = urlinx == null || "".equals(urlinx) ? "0" : urlinx;
    	//String reUrl = "";
    	String userId = request.getSession().getAttribute("CURRENT_USER").toString();
    	String url = walletVO.getNonlandingUrl();
    	long uId = 0;
		uId = StringUtils.isEmpty(userId) ? uId :Long.parseLong(userId);
    	String token = UUidUtil.getId();
    	List<UserTokenVO> list =  userTokenService.queryUserTokenByUserId(uId);
    	if(list.size() > 0){
    		Map<String,Object> map = new HashMap<String,Object>();
        	map.put("userId", uId);
        	map.put("token", token);
    		map.put("flag", "Y");
    		userTokenService.verifyUserToken(map);
    	}else{
        	UserTokenVO userTokenVO = new UserTokenVO();
        	userTokenVO.setUserId(uId);
        	userTokenVO.setToken(token);
        	userTokenService.addUserToken(userTokenVO);
    	}
    	try {
    		String[] signFields = new String[]{"memberId","token","url","data"};
    		Map<String, Object> map = new HashMap<String, Object>();
    		String memberId = DESUtils.getEncryptString(userId);
    		String action = DESUtils.getEncryptString(walletDoUrl[Integer.parseInt(urlinx)]);
    		JSONObject jsonObj = new JSONObject();
    		jsonObj.put("data", DESUtils.getEncryptString("data"));
    		map.put("memberId", memberId);
    		map.put("token", token);
    		map.put("url", action);
    		map.put("data", jsonObj);
    		logger.info("进入createToken2*******************"+map);
    		String sign = SignUtil.sign(signFields, map);
			//reUrl ="memberId="+URLEncoder.encode(memberId)+"&token="+token+"&url="+URLEncoder.encode(URLEncoder.encode(action))+"&data="+URLEncoder.encode(data)+"&sign="+sign;
			//String result = HttpRequestUtil.doPost(url,reUrl);
			rs.setReturnCode("1");
			Map<String,Object> returnVal = new HashMap<String,Object>();
			returnVal.put("walletUrl", url);
			returnVal.put("memberId", URLEncoder.encode(URLEncoder.encode(memberId)));
			returnVal.put("token", token);
			returnVal.put("url", URLEncoder.encode(URLEncoder.encode(action)));
			JSONObject jsonObj1 = new JSONObject();
    		jsonObj1.put("data", URLEncoder.encode(URLEncoder.encode(DESUtils.getEncryptString("data"))));
			returnVal.put("data",jsonObj1.toString());
			returnVal.put("sign", sign);
			rs.setData(returnVal);
			rs.setReturnMsg("created token success");
			logger.info("进入createToken3*******************"+rs);
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	return rs;
    }
    
    /**
     * 钱包跳转商城验证
     * @return
     */
    @RequestMapping(value="/verifyToken",method=RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings("deprecation")
    public ResultMsg<Object> verifyToken(HttpServletRequest req,HttpServletResponse rep){
    	String memberId = req.getParameter("memberId");
    	String token = req.getParameter("token");
    	String userId = memberId;
    	logger.info("进入verifyToken1*******************memberId="+userId+"token="+token);
    	try {
			userId = DESUtils.getDecryptString(URLDecoder.decode(userId));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	long uId = 0;
		uId = StringUtils.isEmpty(userId) ? uId :Long.parseLong(userId);
		List<UserTokenVO> list =  userTokenService.queryUserTokenByUserId(uId);
		logger.info("进入verifyToken2*******************"+list.size());
		ResultMsg<Object> rs = new ResultMsg<Object>();
		if(list.size() > 0){
			UserTokenVO utvo = list.get(0);
			if(utvo.getToken().equals(token)){
				String timeOutFlag = utvo.getTimeOutFlag();
				if("0".equals(timeOutFlag)){
					rs.setReturnCode("0");
					rs.setReturnMsg("verify token timeOut");
				}else{
					Map<String,Object> map = new HashMap<String,Object>();
			    	map.put("userId", uId);
					map.put("flag", "N");
					int count = userTokenService.verifyUserToken(map);
					if(count > 0){
						rs.setReturnCode("1");
						rs.setReturnMsg("verify token success");
					}else{
						rs.setReturnCode("0");
						rs.setReturnMsg("verify token fail");
					}
				}
			}else{
				rs.setReturnCode("0");
				rs.setReturnMsg("verify token fail");
			}
		}
		logger.info("进入verifyToken3*******************rs"+rs.getReturnCode()+"="+rs.getReturnMsg()+"="+rs.getReturnCode());
    	return rs;
    }
    
    /**
     * 商城商品详情点击充值跳转到积分页面 
     * @param vo
     * @param rep
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value="/toScore",method=RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings({ "deprecation", "unchecked" })
    public ResultMsg<Object> toScore(HttpServletRequest req,HttpServletResponse rep) throws ServletException{
    		setHeader(rep);
    	    logger.info("进入toScore*******************");
    	    String[] signFields = new String[]{"memberId","token","url","data"};
    		ResultMsg<Object> rs = new ResultMsg<Object>();
			String memberId = URLDecoder.decode(req.getParameter("memberId"));
    		String tokenId = req.getParameter("token");
    		String action = URLDecoder.decode(req.getParameter("url"));
    		String sign = req.getParameter("sign");
    		String isRegister = req.getParameter("isRegister");//注册标志 Y：不用做登陆操作
    		if(isRegister != null){
    			isRegister = URLDecoder.decode(isRegister);
    		}else{
    			isRegister = "";
    		}
    		String accpetDate = req.getParameter("data");
    		try {
				accpetDate  = accpetDate == null ? "{\"data\":"+URLEncoder.encode(URLEncoder.encode(DESUtils.getEncryptString("data")))+"}" : accpetDate;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
    		logger.info("进入toScore2*******************"+accpetDate);
    		JSONObject dataJson = JSONObject.fromObject(accpetDate);
    		Iterator<String>  it = dataJson.keySet().iterator();
    	    while(it.hasNext()){
    	    	String key = it.next();
    	    	String value =URLDecoder.decode(dataJson.getString(key));
    	    	dataJson.put(key, value);
    	    }
    	    String reqData = dataJson.toString();
    		Map<String, Object> map = new HashMap<String, Object>();
    		map.put("memberId", memberId);
    		map.put("token", tokenId);
    		map.put("url", action);
    		map.put("data", reqData);
    		logger.info("进入toScore3*******************"+map);
    		boolean isSign = SignUtil.verify(signFields, map, sign);
    		logger.info("isSign :"+isSign);
    		if(isSign){
	    		String postUrl = walletVO.getVerifyTokenUrl();
	    		String result = HttpRequestUtil.doPost(postUrl,"memberId="+URLEncoder.encode(URLEncoder.encode(memberId))+"&token="+tokenId);
	    		JSONObject jsonResult = JSONObject.fromObject(result);
	    		String returnCode = jsonResult.getString("code");
	    		logger.info("returnCode :"+returnCode);
	    		if("1".equals(returnCode)){
		    		try{
		    			long uId = 0;
		    			if(!"Y".equals(DESUtils.getDecryptString(isRegister))){
			        		uId = StringUtils.isEmpty(memberId) ? uId :Long.parseLong(DESUtils.getDecryptString(memberId));
			        		UserVO user = userService.getUserRole(uId);
			        		if(user == null){
			        			rs.setReturnCode("0");
			                    rs.setReturnMsg("user not exist");
				                return rs;
			        		}
			    	    	String password = user.getPassword();
			    	        UsernamePasswordToken token = new UsernamePasswordToken(String.valueOf(uId),password);
			    	        Subject currentUser = SecurityUtils.getSubject();  
			                token.setRememberMe(true);
		//                	InetAddress addr = InetAddress.getLocalHost();
		//               	token.setHost(addr.getHostAddress().toString());
			                currentUser.login(token);
		                	List<Map<String,Object>> list =  memberService.getMemberById(uId);
		                	if(list.size() > 0){
		                		Map<String,Object> data = list.get(0);
		                		data.remove("password");
		                		rs.setData(data);
		                		rs.setReturnCode(ReturnConstant.RETURN_CODE_200);
				                rs.setReturnMsg(ReturnConstant.RETURN_MSG_900);
		                	}else{
		                		rs.setReturnCode("0");
				                rs.setReturnMsg("user not exist");
		                	}
		    			}    
		                action = DESUtils.getDecryptString(action);
		                //req.setAttribute("data", reqData);
		                logger.info("invoking method start"+action+",uId="+uId+"code="+rs.getReturnCode()+"msg="+rs.getReturnMsg());
						//req.getRequestDispatcher(action).forward(req, rep);
						rep.sendRedirect(action);
						return null;
		            }//catch(UnknownHostException e){
	//            	e.printStackTrace();
	//            }
		        	catch(LockedAccountException lae){
		            	rs.setReturnCode(ReturnConstant.RETURN_CODE_901);
		                rs.setReturnMsg(ReturnConstant.RETURN_MSG_901); 
		            }catch(ExcessiveAttemptsException eae){  
		            	rs.setReturnCode(ReturnConstant.RETURN_CODE_902);
		                rs.setReturnMsg(ReturnConstant.RETURN_MSG_902);  
		            }catch(AuthenticationException ae){  
		            	rs.setReturnCode(ReturnConstant.RETURN_CODE_903);
		                rs.setReturnMsg(ReturnConstant.RETURN_MSG_903);  
		            }catch (ServletException e) {
						e.printStackTrace();
					}catch (IOException e) {
						e.printStackTrace();
					}catch (Exception e) {
						e.printStackTrace();
					}
	    		}else if("0".equals(returnCode)){
	    			try {
						req.getRequestDispatcher("/index").forward(req, rep);
					} catch (ServletException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
	    		}else{
	    			try {
	    				if("token is verifyed.".equals(jsonResult.getString("msg"))){
	    					req.getRequestDispatcher("/index").forward(req, rep);
	    					
	    					return null;
	    				}
	    				else{
							rs.setReturnCode(jsonResult.getString("code"));
			                rs.setReturnMsg(jsonResult.getString("msg"));
	    				}
					} catch (IOException e) {
						e.printStackTrace();
					}
	    		}
    		}else{
    			rs.setReturnCode("0");
                rs.setReturnMsg("sign was fail");
    		}
    		logger.info("进入toScore4*******************rs"+rs);
        return rs;
    }
    /**
     * 商城跳转钱包
     * @param vo
     * @param rep
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value="/nonlanding",method=RequestMethod.POST)
    @ResponseBody
    @SuppressWarnings({ "deprecation", "unchecked" })
    public ResultMsg<Object> nonlanding(HttpServletRequest req,HttpServletResponse rep){
		setHeader(rep);
	    logger.info("进入nonlanding1*******************");
	    String[] signFields = new String[]{"memberId","token","url","data"};
		ResultMsg<Object> rs = new ResultMsg<Object>();
		String memberId = URLDecoder.decode(req.getParameter("memberId"));
		String tokenId = req.getParameter("token");
		String action = URLDecoder.decode(req.getParameter("url"));
		String sign = req.getParameter("sign");
		String isRegister = req.getParameter("isRegister");//注册标志 Y：不用做登陆操作
		if(isRegister != null){
			isRegister = URLDecoder.decode(isRegister);
		}else{
			isRegister = "";
		}
		String accpetDate = req.getParameter("data");
		try {
			accpetDate  = accpetDate == null ? "{\"data\":"+URLEncoder.encode(URLEncoder.encode(DESUtils.getEncryptString("data")))+"}" : accpetDate;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		logger.info("进入nonlanding2*******************"+accpetDate);
		JSONObject dataJson = JSONObject.fromObject(accpetDate);
		Iterator<String>  it = dataJson.keySet().iterator();
	    while(it.hasNext()){
	    	String key = it.next();
	    	String value =URLDecoder.decode(dataJson.getString(key));
	    	dataJson.put(key, value);
	    }
	    String reqData = dataJson.toString();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("memberId", memberId);
		map.put("token", tokenId);
		map.put("url", action);
		map.put("data", reqData);
		logger.info("进入nonlanding3*******************"+map);
		boolean isSign = SignUtil.verify(signFields, map, sign);
		logger.info("isSign :"+isSign);
		if(isSign){
    		String postUrl = walletVO.getVerifyTokenUrl();
    		String result = HttpRequestUtil.doPost(postUrl,"memberId="+URLEncoder.encode(URLEncoder.encode(memberId))+"&token="+tokenId);
    		JSONObject jsonResult = JSONObject.fromObject(result);
    		String returnCode = jsonResult.getString("code");
    		logger.info("returnCode :"+returnCode);
    		if("1".equals(returnCode)){
	    		try{
	    			long uId = 0;
	    			if(!"Y".equals(DESUtils.getDecryptString(isRegister))){
		        		uId = StringUtils.isEmpty(memberId) ? uId :Long.parseLong(DESUtils.getDecryptString(memberId));
		        		UserVO user = userService.getUserRole(uId);
		        		if(user == null){
		        			rs.setReturnCode("0");
		                    rs.setReturnMsg("user not exist");
			                return rs;
		        		}
		    	    	String password = user.getPassword();
		    	        UsernamePasswordToken token = new UsernamePasswordToken(String.valueOf(uId),password);
		    	        Subject currentUser = SecurityUtils.getSubject();  
		                token.setRememberMe(true);
	//                	InetAddress addr = InetAddress.getLocalHost();
	//               	token.setHost(addr.getHostAddress().toString());
		                currentUser.login(token);
	                	List<Map<String,Object>> list =  memberService.getMemberById(uId);
	                	if(list.size() > 0){
	                		Map<String,Object> data = list.get(0);
	                		data.remove("password");
	                		rs.setData(data);
	                		rs.setReturnCode(ReturnConstant.RETURN_CODE_200);
			                rs.setReturnMsg(ReturnConstant.RETURN_MSG_900);
	                	}else{
	                		rs.setReturnCode("0");
			                rs.setReturnMsg("user not exist");
	                	}
	    			}    
	                action = DESUtils.getDecryptString(action);
	                //req.setAttribute("data", reqData);
	                logger.info("invoking method start"+action+",uId="+uId+"code="+rs.getReturnCode()+"msg="+rs.getReturnMsg());
					req.getRequestDispatcher(action).forward(req, rep);
					return null;
	            }//catch(UnknownHostException e){
//            	e.printStackTrace();
//            }
	        	catch(LockedAccountException lae){
	            	rs.setReturnCode(ReturnConstant.RETURN_CODE_901);
	                rs.setReturnMsg(ReturnConstant.RETURN_MSG_901); 
	            }catch(ExcessiveAttemptsException eae){  
	            	rs.setReturnCode(ReturnConstant.RETURN_CODE_902);
	                rs.setReturnMsg(ReturnConstant.RETURN_MSG_902);  
	            }catch(AuthenticationException ae){  
	            	rs.setReturnCode(ReturnConstant.RETURN_CODE_903);
	                rs.setReturnMsg(ReturnConstant.RETURN_MSG_903);  
	            }catch (ServletException e) {
					e.printStackTrace();
				}catch (IOException e) {
					e.printStackTrace();
				}catch (Exception e) {
					e.printStackTrace();
				}
    		}else if("0".equals(returnCode)){
    			try {
					req.getRequestDispatcher("/index").forward(req, rep);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}else{
    			try {
    				if("token is verifyed.".equals(jsonResult.getString("msg"))){
    					req.getRequestDispatcher("/index").forward(req, rep);
    					return null;
    				}
    				else{
						rs.setReturnCode(jsonResult.getString("code"));
		                rs.setReturnMsg(jsonResult.getString("msg"));
    				}
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
    		}
		}else{
			rs.setReturnCode("0");
            rs.setReturnMsg("sign was fail");
		}
		logger.info("进入nonlanding4*******************rs"+rs);
    return rs;
}
    
    @RequestMapping(value="/noRedirect",method=RequestMethod.POST)
    @ResponseBody
    public ResultMsg<Object> noRedirect(HttpServletRequest req,HttpServletResponse rep){
    	String walletUrl = req.getParameter("walletUrl");
    	String data = req.getParameter("data");
    	String memberId = req.getParameter("memberId");
    	String sign = req.getParameter("sign");
    	String token = req.getParameter("token");
    	String url = req.getParameter("url");
    	ResultMsg<Object> rs = new ResultMsg<Object>();
    	String result = HttpRequestUtil.doPost(walletUrl,"data="+data+"&memberId="+memberId+"&sign="+sign+"&token="+token+"&url="+url);
		JSONObject jsonResult = JSONObject.fromObject(result);
		Object dataObj = jsonResult.get("data");
		if(!"null".equals(dataObj.toString()) ){
			rs.setData(dataObj);
		}else{
			rs.setData("nodata");
		}
		rs.setReturnCode(jsonResult.getString("code"));
		rs.setReturnMsg(jsonResult.getString("msg"));
		return rs;
    }
    
    // 没有登录
    @ResponseBody
    @GetMapping("/unauthorized")  
    public ResultMsg<String> unauthorized(HttpServletRequest request,HttpServletResponse response){ 
        ResultMsg<String> rs = new ResultMsg<String>();
		Object obj = request.getSession().getAttribute("CURRENT_USER");
		if (obj != null) {
			rs.setData(obj.toString());
	        rs.setReturnCode(ReturnConstant.RETURN_CODE_200);
	        rs.setReturnMsg(ReturnConstant.RETURN_MSG_200);
		} else {
	        rs.setReturnCode(ReturnConstant.RETURN_CODE_401);
	        rs.setReturnMsg(ReturnConstant.RETURN_MSG_401);
		}
        return rs;
    }
    
    // 没有权限
    @ResponseBody
    @GetMapping("/forbidden")  
    public ResultMsg<String> forbidden(){ 
        ResultMsg<String> rs = new ResultMsg<String>();
        rs.setReturnCode(ReturnConstant.RETURN_CODE_403);
        rs.setReturnMsg(ReturnConstant.RETURN_MSG_403);
        return rs;
    }
    
    /**
     * 退出
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/logout",method=RequestMethod.POST)  
    public ResultMsg<String> userLogout(){ 
        SecurityUtils.getSubject().logout();
        ResultMsg<String> rs = new ResultMsg<String>();
        rs.setReturnCode(ReturnConstant.RETURN_CODE_200);
        rs.setReturnMsg(ReturnConstant.RETURN_MSG_200);
        return rs;
    }
    
    /**
     * 手机号码校验
     * @param vo
     * @param request
     * @return
     */
    @RequestMapping(value="/checkMobilePhoneExsits",method=RequestMethod.POST)
    @ResponseBody
    public ResultMsg<Object> checkMobilePhoneExsits(String mobilePhone,HttpServletRequest request){
    	ResultMsg<Object> rs = new ResultMsg<Object>();
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("mobilePhone", mobilePhone);
    	List<Map<String,Object>> list =  userService.checkMobilePhoneExsits(map);
    	if(list.size() > 0){
    		rs.setReturnCode(ReturnConstant.RETURN_STATUS_FAIL);
	        rs.setReturnMsg("已注册");
    	}else{
    		rs.setReturnCode(ReturnConstant.RETURN_STATUS_SUCCESS);
	        rs.setReturnMsg(ReturnConstant.RETURN_MSG_200);
    	}
    	return rs;
    }

    @RequestMapping("/403")
    public String unauthorizedRole(){
        logger.info("------没有权限-------");
        return "403";
    }

    @RequestMapping("/user")
    public String getUserList(Map<String, Object> model){
        model.put("userList", userService.getUserRole(1));
        return "user";
    }

    @RequestMapping("/user/edit/{userid}")
    public String getUserList(@PathVariable int userid){
        logger.info("------进入用户信息修改-------");
        return "user_edit";
    }
    
    private void setHeader(HttpServletResponse rep){
		rep.setHeader("Access-Control-Allow-Origin","*");
		rep.setHeader("Access-Control-Allow-Methods"," POST");
		rep.setHeader("Access-Control-Max-Age", "1000");
	}
}
