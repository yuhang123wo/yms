package cn.yh.st.cms.api.service;

import java.util.List;
import java.util.Map;

import cn.yh.st.cms.domain.CmsAuth;
import cn.yh.st.cms.domain.CmsUser;

import com.github.pagehelper.PageInfo;

public interface CmsUserApiService {

	/**
	 * 根据用户名获取信息
	 * 
	 * @param userName
	 * @return CmsUser
	 */
	CmsUser getCmsUserByName(String userName);

	/**
	 * 分页查询用户信息
	 * 
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return PageInfo<CmsUser>
	 */
	PageInfo<CmsUser> queryPageByMap(Map<String, Object> map, int pageNo, int pageSize);

	/**
	 * 根据ID查询用户信息
	 * 
	 * @param userId
	 * @return CmsUser
	 */
	CmsUser getCmsUserById(long userId);

	/**
	 * 更新用户信息
	 * 
	 * @param cmsUser
	 * @return int
	 */
	int updateUserInfo(CmsUser cmsUser);

	/**
	 * 取所有权限
	 * 
	 * @return List<CmsAuth>
	 */
	List<CmsAuth> findAuthAll();

}
