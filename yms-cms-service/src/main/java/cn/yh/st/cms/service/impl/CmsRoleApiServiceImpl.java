package cn.yh.st.cms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yh.st.cms.api.service.CmsRoleApiService;
import cn.yh.st.cms.dao.CmsAuthDao;
import cn.yh.st.cms.dao.CmsRoleAuthDao;
import cn.yh.st.cms.dao.CmsRoleDao;
import cn.yh.st.cms.domain.CmsRole;
import cn.yh.st.cms.domain.CmsRoleAuth;
import cn.yh.st.common.exception.DefaultAutoHandledException;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("cmsRoleApiService")
public class CmsRoleApiServiceImpl implements CmsRoleApiService {

	@Resource
	private CmsRoleDao cmsRoleDao;
	@Resource
	private CmsAuthDao cmsAuthDao;
	@Resource
	private CmsRoleAuthDao cmsRoleAuthDao;

	@Override
	public PageInfo<CmsRole> queryPageByMap(Map<String, Object> map, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		Example example = new Example(CmsRole.class);
		if (map.get("name") != null) {
			example.createCriteria().andLike("name", map.get("name").toString());
		}
		List<CmsRole> list = cmsRoleDao.selectByExample(example);
		return new PageInfo<CmsRole>(list);
	}

	@Override
	public CmsRole queryById(long id) {
		return cmsRoleDao.selectByPrimaryKey(id);
	}

	@Override
	public int insertOrUpdate(CmsRole cmsRole) {
		if (cmsRole == null)
			throw new DefaultAutoHandledException("操作信息为空");
		if (cmsRole.getId() != null && cmsRole.getId() > 0) {
			cmsRoleDao.updateByPrimaryKey(cmsRole);
		} else {
			cmsRoleDao.insert(cmsRole);
		}

		if (cn.yh.st.common.util.StringUtil.isEmpty(cmsRole.getAuthIds())) {
			return 1;
		}
		// 先删除权限
		cmsRoleAuthDao.delRoleAuthByRoleId(cmsRole.getId());
		String[] arrayAuth = cmsRole.getAuthIds().split("\\,");
		for (int i = 0; i < arrayAuth.length; i++) {
			cmsRoleAuthDao.insert(new CmsRoleAuth(cmsRole.getId(), Long.parseLong(arrayAuth[i])));
		}
		return 1;
	}

	@Override
	public List<Long> listAuthByRoleId(long roleId) {
		return cmsAuthDao.listAuthByRoleId(roleId);
	}
}
