package com.novel.web.boss.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.novel.web.boss.entity.UserPO;
import com.novel.web.boss.service.PermissionService;
import com.novel.web.boss.service.UserService;
import com.novel.web.boss.vo.PermissionVO;

/**
 * 登陆
 * 
 * @author Administrator
 *
 */
@Controller
public class LoginController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	PermissionService permissionService;
	@Autowired
	UserService userService;

	@RequestMapping({ "/", "index" })
	public String index() {
		return "index";
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "username", required = true) String userName,
			@RequestParam(value = "password", required = true) String password, RedirectAttributes redirectAttributes) {
		UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
		// 获取当前的Subject
		Subject currentUser = SecurityUtils.getSubject();
		try {
			// 在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
			// 每个Realm都能在必要时对提交的AuthenticationTokens作出反应
			// 所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
			LOGGER.info("对用户[" + userName + "]进行登录验证..验证开始");
			currentUser.login(token);
			LOGGER.info("对用户[" + userName + "]进行登录验证..验证通过");
			return "index";
		} catch (UnknownAccountException uae) {
			LOGGER.info("对用户[" + userName + "]进行登录验证..验证未通过,未知账户");
			redirectAttributes.addFlashAttribute("message", "未知账户");
		} catch (IncorrectCredentialsException ice) {
			LOGGER.info("对用户[" + userName + "]进行登录验证..验证未通过,错误的凭证");
			redirectAttributes.addFlashAttribute("message", "密码不正确");
		} catch (LockedAccountException lae) {
			LOGGER.info("对用户[" + userName + "]进行登录验证..验证未通过,账户已锁定");
			redirectAttributes.addFlashAttribute("message", "账户已锁定");
		} catch (ExcessiveAttemptsException eae) {
			LOGGER.info("对用户[" + userName + "]进行登录验证..验证未通过,错误次数过多");
			redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数过多");
		} catch (AuthenticationException ae) {
			// 通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
			LOGGER.info("对用户[" + userName + "]进行登录验证..验证未通过,堆栈轨迹如下");
			ae.printStackTrace();
			redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
		}
		// 验证不成功
			return "login";
	}

	@RequestMapping("logout")
	public String logout() {
		Subject currentUser = SecurityUtils.getSubject();
		try {
			currentUser.logout();
		} catch (AuthenticationException e) {
			e.printStackTrace();
		}
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("error", "登出成功");
		LOGGER.info("登出成功！！！");
		return "login";
	}

	/**
	 * 加载菜单
	 * 
	 * @return
	 * 
	 * @return
	 */
	@RequestMapping("loadmenu")
	@ResponseBody
	public Map<String, Object> loadMenu() {
		Map<String, Object> map=new HashMap<String, Object>();
		Subject User = SecurityUtils.getSubject();
		User.isAuthenticated();
		String userName = (String) User.getPrincipal();
		map.put("error", "成功");
		UserPO user = userService.findByPhone(userName);
		List<PermissionVO> level1list = new ArrayList<PermissionVO>();
		List<PermissionVO> list = new ArrayList<PermissionVO>();
		List<PermissionVO> per1list2 = permissionService.findPerInfoByUserName(userName);
		for (PermissionVO po : per1list2) {
			if (po.getPerUpperId() == null) {
				level1list.add(po);
			}
			for (PermissionVO vo : per1list2) {
				if (po.getId().equals(vo.getPerUpperId())) {
					list.add(vo);
				}
				po.setPerList(list);
			}
			list = new ArrayList<PermissionVO>();
		}
		map.put("level1list", level1list);// 菜单
		map.put("userName", user.getUserName());// 姓名
		return map;
	}

}
