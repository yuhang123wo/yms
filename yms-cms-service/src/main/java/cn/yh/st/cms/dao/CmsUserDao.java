package cn.yh.st.cms.dao;

import java.util.List;
import java.util.Map;

import cn.yh.st.base.MyBatisRepository;
import cn.yh.st.cms.domain.CmsUser;

import com.github.abel533.mapper.Mapper;

@MyBatisRepository
public interface CmsUserDao extends Mapper<CmsUser> {

	List<CmsUser> listCmsUserByParams(Map<String, Object> map);
}
