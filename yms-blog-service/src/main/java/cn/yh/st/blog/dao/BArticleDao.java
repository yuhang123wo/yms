package cn.yh.st.blog.dao;

import java.util.List;
import java.util.Map;

import com.github.abel533.mapper.Mapper;

import cn.yh.st.base.MyBatisRepository;
import cn.yh.st.blog.domain.BArticle;

@MyBatisRepository
public interface BArticleDao extends Mapper<BArticle> {

	List<BArticle> listBArticleByParams(Map<String, Object> params);
}
