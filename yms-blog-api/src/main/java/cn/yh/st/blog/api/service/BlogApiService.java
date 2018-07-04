package cn.yh.st.blog.api.service;

import cn.yh.st.blog.domain.BGood;

public interface BlogApiService {

	/**
	 * 插入每日文章
	 * 
	 * @param bArticle
	 * @return int
	 */
	int saveGood(BGood bGood);
}
