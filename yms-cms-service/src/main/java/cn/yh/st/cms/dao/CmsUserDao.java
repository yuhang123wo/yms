package cn.yh.st.cms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Update;

import cn.yh.st.base.MyBatisRepository;
import cn.yh.st.cms.domain.CmsUser;

import com.github.abel533.mapper.Mapper;

@MyBatisRepository
public interface CmsUserDao extends Mapper<CmsUser> {

	List<CmsUser> listCmsUserByParams(Map<String, Object> map);

	@Update("update cms_user set realname=#{realname},tel=#{tel},qq=#{qq},state=#{state},remark=#{remark} where id=#{id}")
	int updateUserInfo(CmsUser cmsuer);
}
