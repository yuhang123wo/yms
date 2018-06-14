package cn.yh.st.cms.domain;

import javax.persistence.Column;

import cn.yh.st.common.entity.Entity;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2018-6-8 16:39:28
 */
public class CmsUserRole extends Entity {
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "role_id")
	private Long roleId;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

}
