package cn.yh.st.task.blog;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import cn.yh.st.blog.api.service.BlogApiService;
import cn.yh.st.blog.domain.BGood;

/**
 * 博客类相关task
 * 
 * @author yuhang
 * @Date 2018年7月3日
 * @desc
 */
public class NewsTask {

	@Autowired
	private BlogApiService blogApiService;

	public void processGetNewsTask() {
		System.out.println("开始");
		BGood bGood = new BGood();
		bGood.setAuthor("adfads");
		bGood.setChiContent("abc");
		bGood.setEngContent("123242");
		blogApiService.saveGood(bGood);
		System.out.println("结束");
	}
}
