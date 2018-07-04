package cn.yh.st.blog.domain;

import javax.persistence.Column;

import cn.yh.st.base.Entity;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2018-7-3 17:04:34
 */
public class BCategory extends Entity {
	private static final long serialVersionUID = 1L;

	@Column(name = "chi_name")
	private String chiName; // 类别名称

	public String getChiName() {
		return this.chiName;
	}

	public void setChiName(String chiName) {
		this.chiName = chiName;
	}

}
