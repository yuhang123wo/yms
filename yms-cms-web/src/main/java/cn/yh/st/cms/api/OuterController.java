package cn.yh.st.cms.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "test接口")
public class OuterController {

	@RequestMapping(value = "/listCompound")
	@ResponseBody
	@ApiResponses(value = {})
	@ApiOperation(httpMethod = "GET", value = "个人信息")
	// swagger 当前接口注解
	public String listCompound(
			@ApiParam(required = true, name = "start", value = "start") int start, int limit,
			@ApiParam(required = false, name = "userName", value = "名称模糊查询") String userName) {
		return userName;
	}
}
