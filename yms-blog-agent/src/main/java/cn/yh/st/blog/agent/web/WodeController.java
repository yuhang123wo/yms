package cn.yh.st.blog.agent.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.yh.st.blog.api.service.BlogApiService;

@Controller
@RequestMapping("wode")
public class WodeController {

	@Resource
	private BlogApiService blogApiService;

	@RequestMapping("index")
	public String toIndex(Model model) {
		model.addAttribute("listCategory", blogApiService.getAllCategory());
		model.addAttribute("listKeyword", blogApiService.getAllKeyword());
		return "links";
	}
}
