package cn.yh.st.cms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import cn.yh.st.base.Entity;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2018-6-8 16:39:28
 */
public class CmsRole extends Entity {
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "不能为空")
	@Column(name = "role_name")
	private String roleName;

	@Min(value=0,message="未设置状态")
	@Max(value=1,message="未设置状态")
	@Column(name = "state")
	private Integer state;

	@Column(name = "create_time")
	private Date createTime;

	private String authIds;

	public String getAuthIds() {
		return authIds;
	}

	public void setAuthIds(String authIds) {
		this.authIds = authIds;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
