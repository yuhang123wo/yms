package cn.yh.st.blog.agent.web;

import javax.annotation.Resource;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yh.st.blog.api.service.BlogApiService;

@Controller
@RequestMapping("blog")
public class BlogController {

	@Resource
	private BlogApiService blogApiService;

	/**
	 * 
	 * @return String
	 */
	@RequestMapping("submitArticle")
	public String submitArticle(@RequestParam("artContent") String artContent, String title,
			String keyId, String categoryId) {
		blogApiService.insertArticleAndContent(artContent, title, NumberUtils.toLong(keyId),
				NumberUtils.toLong(categoryId));
		return "redirect:/index";
	}
}
