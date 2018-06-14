package cn.yh.st.cms.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yh.st.cms.api.service.CmsUserApiService;
import cn.yh.st.cms.dao.CmsUserDao;
import cn.yh.st.cms.domain.CmsUser;

@Service("cmsUserApiService")
public class CmsUserServiceImpl implements CmsUserApiService {
	@Resource
	private CmsUserDao cmsUserDao;

	@Override
	public CmsUser getCmsUserByName(String userName) {
		return cmsUserDao.selectOne(new CmsUser(userName));
	}

}
