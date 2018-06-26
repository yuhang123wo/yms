package cn.yh.st.cms.api.service;

import java.util.Map;

import cn.yh.st.cms.domain.CmsRole;

import com.github.pagehelper.PageInfo;

public interface CmsRoleApiService {

	
	PageInfo<CmsRole> queryPageByMap(Map<String, Object> map, int pageNo, int pageSize);
}
