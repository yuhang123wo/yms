package cn.yh.st.cms.util;

import org.apache.shiro.SecurityUtils;

public class UserUtil {

	/**
	 * 取用户
	 * 
	 * @return ShiroUser
	 */
	public static ShiroUser getUser() {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user;
	}
}
