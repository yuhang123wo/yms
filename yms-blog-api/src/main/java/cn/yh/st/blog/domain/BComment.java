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
public class BComment extends Entity {
	private static final long serialVersionUID = 1L;

	@Column(name = "father_id")
	private int fatherId;

	@Column(name = "blog_id")
	private int blogId;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "content")
	private String content;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "have_reply")
	private int haveReply;

	public int getFatherId() {
		return this.fatherId;
	}

	public void setFatherId(int fatherId) {
		this.fatherId = fatherId;
	}

	public int getBlogId() {
		return this.blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getHaveReply() {
		return this.haveReply;
	}

	public void setHaveReply(int haveReply) {
		this.haveReply = haveReply;
	}

}
