package cn.yh.st.cms.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.yh.st.cms.api.service.CmsRoleApiService;
import cn.yh.st.cms.api.service.CmsUserApiService;
import cn.yh.st.cms.domain.CmsRole;
import cn.yh.st.cms.domain.CmsUser;
import cn.yh.st.cms.util.ObjectToMap;
import cn.yh.st.cms.vo.RoleParam;
import cn.yh.st.cms.vo.UserParam;
import cn.yh.st.common.util.ResultMsg;
import cn.yh.st.common.util.ValidateUtil;

import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("sys")
public class CmsSysController {

	@Resource
	private CmsUserApiService cmsUserApiService;
	@Resource
	private CmsRoleApiService cmsRoleApiService;

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

	/**
	 * 编辑页面
	 * 
	 * @return String
	 */
	@RequestMapping("userDetailIndex/{id}")
	public String userDetailIndex(@PathVariable(name = "id") long id, Model model) {
		model.addAttribute("userModel", cmsUserApiService.getCmsUserById(id));
		return "sys/user-detail";
	}

	/**
	 * 
	 * @param cmsUser
	 * @return ResultMsg
	 */
	@RequestMapping("updateUserInfo")
	@ResponseBody
	public ResultMsg updateUserInfo(CmsUser cmsUser) {
		ValidateUtil.validate(cmsUser);
		int n = cmsUserApiService.updateUserInfo(cmsUser);
		if (n == 1) {
			return ResultMsg.success();
		}
		return ResultMsg.failOperator();

	}

	/**
	 * 
	 */
	@RequestMapping("roleIndex")
	public String roleIndex() {
		return "sys/role-list";
	}

	/**
	 * 角色列表
	 */
	@PostMapping(value = "roleDataList")
	@ResponseBody
	public ResultMsg roleDataList(RoleParam params) {
		PageInfo<CmsRole> list = cmsRoleApiService.queryPageByMap(ObjectToMap.getMap(params),
				params.getPageNo(), params.getPageSize());
		return ResultMsg.success(list);
	}
}
