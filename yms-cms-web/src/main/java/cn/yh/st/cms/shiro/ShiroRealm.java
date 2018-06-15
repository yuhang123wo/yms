package cn.yh.st.cms.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import cn.yh.st.cms.api.service.CmsUserApiService;
import cn.yh.st.cms.domain.CmsUser;
import cn.yh.st.cms.exception.UserNotExistException;

public class ShiroRealm extends AuthorizingRealm {

	private CmsUserApiService cmsUserApiService;

	public CmsUserApiService getCmsUserApiService() {
		return cmsUserApiService;
	}

	public void setCmsUserApiService(CmsUserApiService cmsUserApiService) {
		this.cmsUserApiService = cmsUserApiService;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
			throws AuthenticationException {
		UsernamePasswordCaptchaToken token = (UsernamePasswordCaptchaToken) authcToken;
		CmsUser cmsUser = cmsUserApiService.getCmsUserByName(token.getUsername());
		if (cmsUser == null) {
			throw new UserNotExistException();
		}
		AuthenticationInfo info = new SimpleAuthenticationInfo(cmsUser, cmsUser.getPwd(), getName());
		return info;
	}

}
