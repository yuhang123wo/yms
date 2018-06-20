package cn.yh.st.cms.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sys")
public class CmsSysController {

	@GetMapping(value = "userIndex")
	public String userIndex() {
		return "sys/user-list";
	}
}
