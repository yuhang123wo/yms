package cn.yh.st.common.util;

public class ResultMsg {

	private int code;
	public static final int CODE_SUCCESS = 0;
	public static final int CODE_FAIL = -1;
	private String msg;
	private Object data;
	public static final String ERROR_OPERATOR = "操作失败";

	public static ResultMsg success() {
		ResultMsg m = new ResultMsg();
		m.setCode(CODE_SUCCESS);
		return m;
	}

	public static ResultMsg success(Object data) {
		ResultMsg m = new ResultMsg();
		m.setCode(CODE_SUCCESS);
		m.setData(data);
		return m;
	}

	public static ResultMsg fail(String msg) {
		ResultMsg m = new ResultMsg();
		m.setCode(CODE_FAIL);
		m.setMsg(msg);
		return m;
	}

	public static ResultMsg failOperator() {
		ResultMsg m = new ResultMsg();
		m.setCode(CODE_FAIL);
		m.setMsg(ERROR_OPERATOR);
		return m;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
