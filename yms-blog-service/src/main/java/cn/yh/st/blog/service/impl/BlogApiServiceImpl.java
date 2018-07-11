package cn.yh.st.blog.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yh.st.blog.api.service.BlogApiService;
import cn.yh.st.blog.dao.BArticleDao;
import cn.yh.st.blog.dao.BCommentDao;
import cn.yh.st.blog.dao.BContentDao;
import cn.yh.st.blog.dao.BGoodDao;
import cn.yh.st.blog.dao.BKeywordDao;
import cn.yh.st.blog.dao.BUserinfoDao;
import cn.yh.st.blog.domain.BArticle;
import cn.yh.st.blog.domain.BComment;
import cn.yh.st.blog.domain.BContent;
import cn.yh.st.blog.domain.BGood;
import cn.yh.st.blog.domain.BKeyword;
import cn.yh.st.blog.domain.BUserinfo;

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
}
