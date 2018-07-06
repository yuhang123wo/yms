package cn.yh.st.blog.agent.task;

import java.util.Date;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.yh.st.blog.api.service.BlogApiService;
import cn.yh.st.blog.domain.BGood;
import cn.yh.st.common.jsoup.JsoupUtil;

@Component
public class NewsTask {

	@Autowired
	private BlogApiService blogApiService;

	@Scheduled(cron = "0 0 7 * * ?")
	public void processGetNewsTask() {
		System.out.println("开始");
		try {
			blogApiService.saveGood(getNewsTop());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("结束");
	}

	/**
	 * 获取今日头条
	 * 
	 * void
	 * 
	 * @throws Exception
	 */
	public static BGood getNewsTop() throws Exception {

		String url = "http://sports.sina.com.cn/nba/";
		Document doc = JsoupUtil.getDocumentByGet(url, null);
		Element el = doc.getElementsByClass("news-list-b").get(0);
		Element tt = el.getElementsByTag("h3").get(0);
		Element data = tt.getElementsByTag("a").get(0);

		BGood bGood = new BGood();
		bGood.setChiContent(data.html());// 标题
		bGood.setEngContent(getContent(data.attr("href")));
		bGood.setCreateTime(new Date());
		return bGood;

	}

	private static String getContent(String url) throws Exception {
		StringBuilder sb = new StringBuilder();
		Document doc = JsoupUtil.getDocumentByGet(url, null);
		Element el = doc.getElementsByClass("article").get(0);
		Elements els = el.getElementsByTag("p");
		for (int i = 0; i < els.size(); i++) {
			sb.append(els.get(i).text());
		}
		return sb.toString();
	}

	public static void main(String[] args) throws Exception {
		getNewsTop();
	}
}
