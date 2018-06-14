package cn.yh.st.cms.domain;

import javax.persistence.Column;

import cn.yh.st.common.entity.Entity;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2018-6-8 16:39:28
 */
public class CmsAuth extends Entity {
	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "type")
	private Integer type;

	@Column(name = "p_id")
	private Long pId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

}
