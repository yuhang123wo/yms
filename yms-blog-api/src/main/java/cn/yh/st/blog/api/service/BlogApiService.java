package cn.yh.st.blog.api.service;

import java.util.List;
import java.util.Map;

import cn.yh.st.blog.domain.BArticle;
import cn.yh.st.blog.domain.BCategory;
import cn.yh.st.blog.domain.BComment;
import cn.yh.st.blog.domain.BContent;
import cn.yh.st.blog.domain.BGood;
import cn.yh.st.blog.domain.BKeyword;
import cn.yh.st.blog.domain.BUserinfo;

import com.github.pagehelper.PageInfo;

public interface BlogApiService {

	/**
	 * 插入每日文章
	 * 
	 * @param bArticle
	 * @return int
	 */
	int saveGood(BGood bGood);

	/**
	 * 取最新一条记录
	 * 
	 * @return BGood
	 */
	BGood getBGoodByLast();

	/**
	 * 分页查询论坛文章
	 * 
	 * @param params
	 * @param pageNo
	 * @param pageSize
	 * @return PageInfo<BArticle>
	 */
	PageInfo<BArticle> loadBArticlePageByParams(Map<String, Object> params, int pageNo, int pageSize);

	/**
	 * 
	 * @param params
	 * @param pageNo
	 * @param pageSize
	 * @return PageInfo<BKeyword>
	 */
	PageInfo<BKeyword> loadBKeywordPageByParams(Map<String, Object> params, int pageNo, int pageSize);

	/**
	 * 
	 * @return BArticle
	 */
	BArticle getBArticleById(long id);

	/**
	 * 
	 * @param articleId
	 * @return BContent
	 */
	BContent getBContentById(long id);

	/**
	 * 
	 * @param articleId
	 * @return BComment
	 */
	List<BComment> getBCommentByArticleId(long articleId);

	/**
	 * 根据用户名取用户
	 * 
	 * @param name
	 * @return BUserinfo
	 */
	BUserinfo getBUserinfoByName(String name);

	/**
	 * 
	 * @param articleId
	 * @param pageNo
	 * @param pageSize
	 * @return PageInfo<BComment>
	 */
	PageInfo<BComment> getPageBCommentByArticleId(long articleId, int pageNo, int pageSize);

	/**
	 * 取所有关键词
	 * 
	 * @return List<BKeyword>
	 */

	List<BKeyword> getAllKeyword();

	/**
	 * 取所有分类
	 * 
	 * @return List<BCategory>
	 */
	List<BCategory> getAllCategory();

	/**
	 * 插入文章
	 * 
	 * @param article
	 * @return int
	 */
	int insertArticle(BArticle article);

	/**
	 * 插入content
	 * 
	 * @param content
	 * @return int
	 */
	int insertContent(BContent content);

	/**
	 * 
	 * @param artContent
	 * @param title
	 * @param keyId
	 * @param categoryId
	 * @return int
	 */
	int insertArticleAndContent(String artContent, String title, long keyId, long categoryId);
}
