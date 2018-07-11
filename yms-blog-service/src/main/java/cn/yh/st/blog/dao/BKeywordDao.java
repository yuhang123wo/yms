package cn.yh.st.blog.dao;

import java.util.List;
import java.util.Map;

import cn.yh.st.base.MyBatisRepository;
import cn.yh.st.blog.domain.BKeyword;

import com.github.abel533.mapper.Mapper;

@MyBatisRepository
public interface BKeywordDao extends Mapper<BKeyword> {

	List<BKeyword> listBKeywordByParams(Map<String, Object> params);
}
