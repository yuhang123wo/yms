package cn.yh.st.cms.web;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;

import cn.yh.st.cms.api.service.CmsUserApiService;
import cn.yh.st.cms.domain.CmsUser;
import cn.yh.st.cms.util.ObjectToMap;
import cn.yh.st.cms.vo.UserParam;
import cn.yh.st.common.util.ResultMsg;

@Controller
@RequestMapping("sys")
public class CmsSysController {

	@Resource
	private CmsUserApiService cmsUserApiService;

	/**
	 * 用户列表视图
	 * 
	 * @return String
	 */
	@GetMapping(value = "userIndex")
	public String userIndex() {
		return "sys/user-list";
	}

	/**
	 * 用户列表数据
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return ResultMsg
	 */
	@PostMapping(value = "userDataList")
	@ResponseBody
	public ResultMsg userDataList(UserParam params) {
		PageInfo<CmsUser> list = cmsUserApiService.queryPageByMap(ObjectToMap.getMap(params),
				params.getPageNo(), params.getPageSize());
		return ResultMsg.success(list);
	}
}
