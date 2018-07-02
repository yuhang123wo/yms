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
public class BBlog extends Entity {
	private static final long serialVersionUID = 1L;

	@Column(name = "blog_title")
	private String blogTitle;

	@Column(name = "blog_text")
	private String blogText;

	@Column(name = "blog_visit")
	private int blogVisit;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "blog_pv")
	private int blogPv;

	@Column(name = "create_time")
	private Date createTime;

	public String getBlogTitle() {
		return this.blogTitle;
	}

	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}

	public String getBlogText() {
		return this.blogText;
	}

	public void setBlogText(String blogText) {
		this.blogText = blogText;
	}

	public int getBlogVisit() {
		return this.blogVisit;
	}

	public void setBlogVisit(int blogVisit) {
		this.blogVisit = blogVisit;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBlogPv() {
		return this.blogPv;
	}

	public void setBlogPv(int blogPv) {
		this.blogPv = blogPv;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
