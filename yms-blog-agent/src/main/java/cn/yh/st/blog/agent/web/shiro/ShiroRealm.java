package cn.yh.st.blog.agent.web.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.yh.st.blog.agent.exception.UserNotExistException;
import cn.yh.st.blog.api.service.BlogApiService;
import cn.yh.st.blog.domain.BUserinfo;

public class ShiroRealm extends AuthorizingRealm {

	private BlogApiService blogApiService;
	
	
	

	public BlogApiService getBlogApiService() {
		return blogApiService;
	}

	public void setBlogApiService(BlogApiService blogApiService) {
		this.blogApiService = blogApiService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) authcToken;
		BUserinfo cmsUser = blogApiService.getBUserinfoByName(token.getUsername());
		if (cmsUser == null) {
			throw new UserNotExistException();
		}
		AuthenticationInfo info = new SimpleAuthenticationInfo(cmsUser, cmsUser.getUserPassword(),
				getName());
		return info;
	}
}
