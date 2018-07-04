package cn.yh.st.blog.agent.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.yh.st.blog.api.service.BlogApiService;
import cn.yh.st.blog.domain.BGood;
@Component
public class NewsTask {

	@Autowired
	private BlogApiService blogApiService;

	@Scheduled(cron = "0 0/1 * * * ?")
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
