package cn.yh.st.base;


public interface BaseService<T extends Entity> {

	/**
	 * 保存业务对象
	 * 
	 * @param model
	 * @throws Exception
	 */
	void save(T model);

}
