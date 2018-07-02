package cn.yh.st.blog.domain;

import java.util.Date;

import javax.persistence.Column;

import cn.yh.st.base.Entity;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2018-7-2 16:34:03
 */
public class BFans extends Entity {
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private long userId;

	@Column(name = "noticer_id")
	private long noticerId;

	@Column(name = "create_time")
	private Date createTime;

	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getNoticerId() {
		return this.noticerId;
	}

	public void setNoticerId(long noticerId) {
		this.noticerId = noticerId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
