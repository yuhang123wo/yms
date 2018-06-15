package cn.yh.st.cms.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yh.st.cms.exception.UserNotExistException;
import cn.yh.st.cms.shiro.UsernamePasswordCaptchaToken;
import cn.yh.st.common.util.StringUtil;

@Controller
public class LoginController {

	private static final String LOGIN_SUCCESS_URL = "index";
	private static final String LOGIN_FAIL_URL = "login";
	private static final String PARAMS_TAG = "errorMsg";

	/**
	 * 
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping("login")
	public String login(HttpServletRequest request, Model model) {
		String username = ServletRequestUtils.getStringParameter(request, "username", "");
		String password = ServletRequestUtils.getStringParameter(request, "password", "");
		if (StringUtil.isEmpty(username)) {
			model.addAttribute(PARAMS_TAG, "用户名不能为空");
			return LOGIN_FAIL_URL;
		}
		if (StringUtil.isEmpty(password)) {
			model.addAttribute(PARAMS_TAG, "密码不能为空");
			return LOGIN_FAIL_URL;
		}
		Subject subject = SecurityUtils.getSubject();
		if (!subject.isAuthenticated()) {
			try {
				UsernamePasswordCaptchaToken token = new UsernamePasswordCaptchaToken(username,
						password.toCharArray(), "");
				token.setRememberMe(true);
				subject.login(token);
				return LOGIN_SUCCESS_URL;
			} catch (UserNotExistException e) {
				model.addAttribute(PARAMS_TAG, "用户不存在");
				e.printStackTrace();
			} catch (AuthenticationException e) {
				model.addAttribute(PARAMS_TAG, "用户名密码错误");
				e.printStackTrace();
			} catch (Exception e) {
				model.addAttribute(PARAMS_TAG, "系统异常稍后再试");
				e.printStackTrace();
			}
			return LOGIN_FAIL_URL;

		}
		return LOGIN_SUCCESS_URL;
	}
}
