package cn.yh.st.cms.vo;

public class BasePageParams {

	private Integer pageNo;
	private Integer pageSize;

	public Integer getPageNo() {
		if (pageNo == null || pageNo.intValue() <= 0) {
			this.pageNo = 1;
			return 1;
		}
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		if (pageSize == null || pageSize.intValue() <= 0) {
			this.pageSize = 20;
			return 20;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
