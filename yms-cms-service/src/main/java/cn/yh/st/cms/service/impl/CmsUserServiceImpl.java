package cn.yh.st.cms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yh.st.cms.api.service.CmsUserApiService;
import cn.yh.st.cms.dao.CmsUserDao;
import cn.yh.st.cms.domain.CmsUser;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("cmsUserApiService")
public class CmsUserServiceImpl implements CmsUserApiService {
	@Resource
	private CmsUserDao cmsUserDao;

	@Override
	public CmsUser getCmsUserByName(String userName) {
		return cmsUserDao.selectOne(new CmsUser(userName));
	}

	@Override
	public PageInfo<CmsUser> queryPageByMap(Map<String, Object> map, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		List<CmsUser> list = cmsUserDao.listCmsUserByParams(map);
		return new PageInfo<CmsUser>(list);
	}

}
