package cn.yh.st.cms.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

import cn.yh.st.common.util.MD5;

/**
 * 
 * @author yh
 * @Date 2017年10月27日
 * @desc
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {

	private static final String PWD_PRFIX = "Yu!peng";

	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) authcToken;
		Object accountCredentials = getCredentials(info);
		try {
			String password = String.valueOf(token.getPassword());
			return equals(MD5.md5Encode(PWD_PRFIX + password+PWD_PRFIX), accountCredentials);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(MD5.md5Encode(PWD_PRFIX + "1" + PWD_PRFIX));
	}
}
