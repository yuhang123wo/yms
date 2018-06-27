package cn.yh.st.cms.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TestModel", description = "用户")
public class TestModel {
	@ApiModelProperty(value = "userName", required = true)
	private String userName;
	@ApiModelProperty(value = "pwd", required = true)
	private String pwd;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
