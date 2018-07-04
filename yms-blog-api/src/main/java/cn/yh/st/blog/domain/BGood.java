package cn.yh.st.blog.domain;

import java.util.Date;

import javax.persistence.Column;

import cn.yh.st.base.Entity;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2018-7-3 17:04:34
 */
public class BGood extends Entity {
	private static final long serialVersionUID = 1L;

	@Column(name = "chi_content")
	private String chiContent;

	@Column(name = "eng_content")
	private String engContent;

	@Column(name = "create_time")
	private Date createTime;

	@Column(name = "author")
	private String author;

	public String getChiContent() {
		return this.chiContent;
	}

	public void setChiContent(String chiContent) {
		this.chiContent = chiContent;
	}

	public String getEngContent() {
		return this.engContent;
	}

	public void setEngContent(String engContent) {
		this.engContent = engContent;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
