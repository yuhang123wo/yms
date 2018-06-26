package cn.yh.st.cms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import cn.yh.st.base.Entity;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2018-6-8 16:39:28
 */
public class CmsUser extends Entity {
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "用户名必填")
	@Column(name = "username")
	private String username;

	@Column(name = "pwd")
	private String pwd;

	@NotEmpty(message = "真实名必填")
	@Column(name = "realname")
	private String realname;

	@Min(value=0,message="未设置状态")
	@Max(value=1,message="未设置状态")
	@Column(name = "state")
	private Integer state;

	@NotEmpty(message = "联系电话必填")
	@Column(name = "tel")
	private String tel;

	@NotEmpty(message = "qq必填")
	@Column(name = "qq")
	private String qq;

	@Column(name = "remark")
	private String remark;

	@Column(name = "update_time")
	private Date updateTime;

	@Column(name = "create_time")
	private Date createTime;

	public CmsUser() {
	}

	public CmsUser(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
