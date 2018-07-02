package cn.yh.st.blog.domain;

import javax.persistence.Column;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2018-7-2 16:34:03
 */
public class BBlogLabel {
	@Column(name = "blog_id")
	private long blogId;

	@Column(name = "label_id")
	private long labelId;

	public long getBlogId() {
		return this.blogId;
	}

	public void setBlogId(long blogId) {
		this.blogId = blogId;
	}

	public long getLabelId() {
		return this.labelId;
	}

	public void setLabelId(long labelId) {
		this.labelId = labelId;
	}

}
