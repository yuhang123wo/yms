package cn.yh.st.cms.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.yh.st.common.util.ResultMsg;

@RestController
@RequestMapping("api")
@Api(tags = "test接口")
public class OuterController {

	@RequestMapping("listCoup")
	@ApiOperation(value = "教程", httpMethod = "POST", notes = "教程")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "province", required = false, value = "省", paramType = "query", dataType = "String"),
			@ApiImplicitParam(name = "city", required = false, value = "市", paramType = "query", dataType = "String"), })
	public ResultMsg listCompound(String province, String city) {
		return ResultMsg.success();
	}

	@RequestMapping("testModel")
	@ApiOperation(value = "testModel", httpMethod = "POST", notes = "testModel")
	public ResultMsg testModel(TestModel model) {
		return ResultMsg.success();
	}
}
