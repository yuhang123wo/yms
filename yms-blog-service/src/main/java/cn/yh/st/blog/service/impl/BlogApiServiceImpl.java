package cn.yh.st.blog.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yh.st.blog.api.service.BlogApiService;
import cn.yh.st.blog.dao.BArticleDao;
import cn.yh.st.blog.dao.BCategoryDao;
import cn.yh.st.blog.dao.BCommentDao;
import cn.yh.st.blog.dao.BContentDao;
import cn.yh.st.blog.dao.BGoodDao;
import cn.yh.st.blog.dao.BKeywordDao;
import cn.yh.st.blog.dao.BUserinfoDao;
import cn.yh.st.blog.domain.BArticle;
import cn.yh.st.blog.domain.BCategory;
import cn.yh.st.blog.domain.BComment;
import cn.yh.st.blog.domain.BContent;
import cn.yh.st.blog.domain.BGood;
import cn.yh.st.blog.domain.BKeyword;
import cn.yh.st.blog.domain.BUserinfo;
import cn.yh.st.common.exception.DefaultAutoHandledException;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("blogApiService")
public class BlogApiServiceImpl implements BlogApiService {
	@Resource
	private BGoodDao bGoodDao;
	@Resource
	private BArticleDao bArticleDao;
	@Resource
	private BKeywordDao bKeywordDao;
	@Resource
	private BContentDao bContentDao;
	@Resource
	private BCommentDao bCommentDao;
	@Resource
	private BUserinfoDao bUserinfoDao;
	@Resource
	private BCategoryDao bCategoryDao;

	@Override
	public int saveGood(BGood bGood) {
		return bGoodDao.insert(bGood);
	}

	@Override
	public BGood getBGoodByLast() {
		Example example = new Example(BGood.class);
		example.setOrderByClause("id desc");
		List<BGood> list = bGoodDao.selectByExample(example);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public PageInfo<BArticle> loadBArticlePageByParams(Map<String, Object> params, int pageNo,
			int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<BArticle> list = bArticleDao.listBArticleByParams(params);
		return new PageInfo<BArticle>(list);
	}

	@Override
	public PageInfo<BKeyword> loadBKeywordPageByParams(Map<String, Object> params, int pageNo,
			int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<BKeyword> list = bKeywordDao.listBKeywordByParams(params);
		return new PageInfo<BKeyword>(list);
	}

	@Override
	public BArticle getBArticleById(long id) {
		return bArticleDao.selectByPrimaryKey(id);
	}

	@Override
	public BContent getBContentById(long id) {
		return bContentDao.selectByPrimaryKey(id);
	}

	@Override
	public List<BComment> getBCommentByArticleId(long articleId) {
		BComment bComment = new BComment();
		bComment.setArticleId(articleId);
		return bCommentDao.select(bComment);
	}

	@Override
	public BUserinfo getBUserinfoByName(String name) {
		BUserinfo b = new BUserinfo();
		b.setUserAccount(name);
		return bUserinfoDao.selectOne(b);
	}

	@Override
	public PageInfo<BComment> getPageBCommentByArticleId(long articleId, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<BComment> list = this.getBCommentByArticleId(articleId);
		return new PageInfo<BComment>(list);
	}

	@Override
	public List<BKeyword> getAllKeyword() {
		return bKeywordDao.selectByExample(new Example(BKeyword.class));
	}

	@Override
	public List<BCategory> getAllCategory() {
		return bCategoryDao.selectByExample(new Example(BCategory.class));
	}

	@Override
	public int insertArticle(BArticle article) {
		return bArticleDao.insert(article);
	}

	@Override
	public int insertContent(BContent content) {
		return bContentDao.insert(content);
	}

	@Override
	public int insertArticleAndContent(String artContent, String title, long keyId, long categoryId) {
		BContent content = new BContent();
		content.setContent(artContent);
		int n = bContentDao.insert(content);
		if (n != 1) {
			throw new DefaultAutoHandledException("操作失败");
		}
		BArticle bArticle = new BArticle();
		bArticle.setAbstr("");
		bArticle.setTitle(title);
		BCategory bCategory = bCategoryDao.selectByPrimaryKey(keyId);
		if (bCategory != null) {
			bArticle.setCategoryId(categoryId);
			bArticle.setCategoryValue(bCategory.getChiName());
		}
		BKeyword bKeyword = bKeywordDao.selectByPrimaryKey(keyId);
		if (bKeyword != null) {
			bArticle.setKeyId(keyId);
			bArticle.setKeyValue(bKeyword.getValue());
		}
		bArticle.setContentId(content.getId());
		bArticle.setTop("");
		bArticle.setCreateTime(new Date());
		return bArticleDao.insert(bArticle);
	}
}
