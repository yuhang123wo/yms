package cn.yh.st.blog.domain;

import javax.persistence.Column;

import cn.yh.st.base.Entity;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2018-7-3 17:04:34
 */
public class BKeyword extends Entity {
	private static final long serialVersionUID = 1L;
	@Column(name = "value")
	private String value; // 关键字

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
