package cn.yh.st.blog.agent.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yh.st.blog.agent.exception.UserNotExistException;
import cn.yh.st.blog.agent.web.shiro.UsernamePasswordCaptchaToken;
import cn.yh.st.common.util.ResultMsg;
import cn.yh.st.common.util.StringUtil;

@Controller
public class LoginController {

	/**
	 * 
	 * @param request
	 * @param model
	 * @return String
	 */
	@PostMapping("login")
	@ResponseBody
	public ResultMsg login(HttpServletRequest request) {
		String username = ServletRequestUtils.getStringParameter(request, "username", "");
		String password = ServletRequestUtils.getStringParameter(request, "password", "");
		Subject subject = SecurityUtils.getSubject();
		if (!subject.isAuthenticated()) {
			if (StringUtil.isEmpty(username)) {
				return ResultMsg.fail("用户名不能为空");
			}
			if (StringUtil.isEmpty(password)) {
				return ResultMsg.fail("密码不能为空");
			}
			try {
				UsernamePasswordCaptchaToken token = new UsernamePasswordCaptchaToken(username,
						password.toCharArray(), "");
				/* token.setRememberMe(true); */
				subject.login(token);
				return ResultMsg.success();
			} catch (UserNotExistException e) {
				e.printStackTrace();
				return ResultMsg.fail("用户不存在");
			} catch (AuthenticationException e) {
				e.printStackTrace();
				return ResultMsg.fail("用户名密码错误");
			} catch (Exception e) {
				e.printStackTrace();
				return ResultMsg.fail("系统异常稍后再试");
			}

		}
		return ResultMsg.success();
	}

	@GetMapping("login")
	public String login() {
		return "redirect:/index";
	}

	/**
	 * 
	 * @return String
	 */
	@RequestMapping("toLogin")
	public String toLogin(Model model) {
		return "login";
	}
}
