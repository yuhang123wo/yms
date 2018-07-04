package cn.yh.st.blog.domain;

import javax.persistence.Column;

import cn.yh.st.base.Entity;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2018-7-3 17:04:34
 */
public class BArtcount extends Entity {
	private static final long serialVersionUID = 1L;

	@Column(name = "click")
	private int click; // 点击量

	@Column(name = "comment")
	private int comment; // 评论量

	@Column(name = "article_id")
	private long articleId; // 文章ID

	public int getClick() {
		return this.click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	public int getComment() {
		return this.comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

	public long getArticleId() {
		return this.articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

}
