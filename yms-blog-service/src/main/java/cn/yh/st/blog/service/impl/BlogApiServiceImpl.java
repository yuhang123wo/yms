package cn.yh.st.blog.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.yh.st.blog.api.service.BlogApiService;
import cn.yh.st.blog.dao.BGoodDao;
import cn.yh.st.blog.domain.BGood;

@Service("blogApiService")
public class BlogApiServiceImpl implements BlogApiService {
	@Resource
	private BGoodDao bGoodDao;

	@Override
	public int saveGood(BGood bGood) {
		return bGoodDao.insert(bGood);
	}

}
