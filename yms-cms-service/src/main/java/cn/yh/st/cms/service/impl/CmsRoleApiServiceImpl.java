package cn.yh.st.cms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yh.st.cms.api.service.CmsRoleApiService;
import cn.yh.st.cms.dao.CmsRoleDao;
import cn.yh.st.cms.domain.CmsRole;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service("cmsRoleApiService")
public class CmsRoleApiServiceImpl implements CmsRoleApiService {

	@Resource
	private CmsRoleDao cmsRoleDao;

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

}
