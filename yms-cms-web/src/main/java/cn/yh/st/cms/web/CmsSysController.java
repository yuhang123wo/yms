package cn.yh.st.cms.web;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.yh.st.cms.api.service.CmsUserApiService;
import cn.yh.st.cms.domain.CmsUser;
import cn.yh.st.common.util.ResultMsg;

@Controller
@RequestMapping("sys")
public class CmsSysController {

	@Resource
	private CmsUserApiService cmsUserApiService;

	@GetMapping(value = "userIndex")
	public String userIndex() {
		return "sys/user-list";
	}

	@PostMapping(value = "userDataList")
	@ResponseBody
	public ResultMsg userDataList() {
		PageInfo<CmsUser> list = cmsUserApiService.queryPageByMap(new HashMap<String, Object>(), 1,
				1);
		return ResultMsg.success(list);
	}
}
