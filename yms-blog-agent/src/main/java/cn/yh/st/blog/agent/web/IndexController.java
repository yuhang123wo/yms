package cn.yh.st.blog.agent.web;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yh.st.blog.api.service.BlogApiService;

/**
 * 博客主页
 * 
 * @author yuhang
 * @Date 2018年7月2日
 * @desc
 */

@Controller
public class IndexController {

	@Resource
	private BlogApiService blogApiService;

	@RequestMapping("index")
	public String index(Model model) {
		model.addAttribute("news", blogApiService.getBGoodByLast());
		model.addAttribute("articles",
				blogApiService.loadBArticlePageByParams(new HashMap<String, Object>(), 1, 10).getList());
		model.addAttribute("keywords",
				blogApiService.loadBKeywordPageByParams(new HashMap<String, Object>(), 1, 5).getList());
		return "index";
	}
}
