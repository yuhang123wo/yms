package cn.yh.st.cms.dao;

import org.apache.ibatis.annotations.Delete;

import com.github.abel533.mapper.Mapper;

import cn.yh.st.base.MyBatisRepository;
import cn.yh.st.cms.domain.CmsRoleAuth;

@MyBatisRepository
public interface CmsRoleAuthDao extends Mapper<CmsRoleAuth>{

	@Delete("delete from cms_role_auth where role_id=#{roleId}")
	int delRoleAuthByRoleId(long roleId);
	
}
