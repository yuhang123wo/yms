package cn.yh.st.blog.agent.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 博客主页
 * 
 * @author yuhang
 * @Date 2018年7月2日
 * @desc
 */

@Controller
public class IndexController {

	@RequestMapping("index")
	public String index() {
		return "index";
	}
}
