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
public class BArticle extends Entity {
	private static final long serialVersionUID = 1L;

	@Column(name = "content_id")
	private long contentId; // 内容ID

	@Column(name = "title")
	private String title; // 标题

	@Column(name = "abstr")
	private String abstr; // 描述

	@Column(name = "category_id")
	private long categoryId; // 类别

	@Column(name = "category_value")
	private String categoryValue;

	@Column(name = "img_url")
	private String imgUrl; // 图片地址

	@Column(name = "top")
	private String top; // 1为热门文章

	@Column(name = "key_id")
	private long keyId; // 关键字

	@Column(name = "key_value")
	private String keyValue;

	@Column(name = "create_time")
	private Date createTime; // 创建日期

	public long getContentId() {
		return this.contentId;
	}

	public void setContentId(long contentId) {
		this.contentId = contentId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAbstr() {
		return this.abstr;
	}

	public void setAbstr(String abstr) {
		this.abstr = abstr;
	}

	public long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryValue() {
		return this.categoryValue;
	}

	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getTop() {
		return this.top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	public long getKeyId() {
		return keyId;
	}

	public void setKeyId(long keyId) {
		this.keyId = keyId;
	}

	public String getKeyValue() {
		return this.keyValue;
	}

	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
