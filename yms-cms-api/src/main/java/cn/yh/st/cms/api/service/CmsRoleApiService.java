package cn.yh.st.cms.api.service;

import java.util.List;
import java.util.Map;

import cn.yh.st.cms.domain.CmsRole;

import com.github.pagehelper.PageInfo;

public interface CmsRoleApiService {
	/**
	 * 
	 * @param map
	 * @param pageNo
	 * @param pageSize
	 * @return PageInfo<CmsRole>
	 */
	PageInfo<CmsRole> queryPageByMap(Map<String, Object> map, int pageNo, int pageSize);

	/**
	 * 
	 * @param id
	 * @return CmsRole
	 */
	CmsRole queryById(long id);

	/**
	 * 
	 * @param cmsRole
	 * @return int
	 */
	int insertOrUpdate(CmsRole cmsRole);

	/**
	 * 取角色权限
	 * 
	 * @param roleId
	 * @return List<Long>
	 */
	List<Long> listAuthByRoleId(long roleId);
}
