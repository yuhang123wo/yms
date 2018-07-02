package cn.yh.st.blog.domain;

import javax.persistence.Column;

import cn.yh.st.base.Entity;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2018-7-2 16:34:03
 */
public class BPlace extends Entity {
	private static final long serialVersionUID = 1L;

	@Column(name = "province")
	private String province;

	@Column(name = "city")
	private String city;

	@Column(name = "area")
	private String area;

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
