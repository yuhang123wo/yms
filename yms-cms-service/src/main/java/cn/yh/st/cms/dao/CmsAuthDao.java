package cn.yh.st.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.github.abel533.mapper.Mapper;

import cn.yh.st.base.MyBatisRepository;
import cn.yh.st.cms.domain.CmsAuth;

@MyBatisRepository
public interface CmsAuthDao extends Mapper<CmsAuth> {

	@Select("select auth_id from cms_role_auth where role_id=#{roleId}")
	List<Long> listAuthByRoleId(@Param("roleId") long roleId);
}
