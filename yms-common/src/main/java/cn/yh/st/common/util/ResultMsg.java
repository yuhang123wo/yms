package cn.yh.st.common.util;

public class ResultMsg {

	private int code;
	private static final int CODE_SUCCESS = 0;
	private static final int CODE_FAIL = -1;
	private String msg;
	private Object data;

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
