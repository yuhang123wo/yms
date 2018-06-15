package cn.yh.st.cms.domain;

import javax.persistence.Column;

import cn.yh.st.base.Entity;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2018-6-8 16:39:28
 */
public class CmsRoleAuth extends Entity {
	private static final long serialVersionUID = 1L;

	@Column(name = "role_id")
	private Long roleId;

	@Column(name = "auth_id")
	private Long authId;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getAuthId() {
		return authId;
	}

	public void setAuthId(Long authId) {
		this.authId = authId;
	}
}
