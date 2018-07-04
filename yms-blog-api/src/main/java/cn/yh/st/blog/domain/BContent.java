package cn.yh.st.blog.domain;

import javax.persistence.Column;

import cn.yh.st.base.Entity;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2018-7-3 17:04:34
 */
public class BContent extends Entity {
	private static final long serialVersionUID = 1L;

	@Column(name = "content")
	private String content; // 内容

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
