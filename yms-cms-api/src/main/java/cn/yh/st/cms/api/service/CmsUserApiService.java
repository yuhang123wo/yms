package cn.yh.st.cms.api.service;

import java.util.Map;

import cn.yh.st.cms.domain.CmsUser;

import com.github.pagehelper.PageInfo;

public interface CmsUserApiService {

	CmsUser getCmsUserByName(String userName);

	PageInfo<CmsUser> queryPageByMap(Map<String, Object> map, int pageNo, int pageSize);

}
