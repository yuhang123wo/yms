package cn.yh.st.base;

import cn.yh.st.common.entity.Entity;

public interface BaseService<T extends Entity> {

	/**
	 * 保存业务对象
	 * 
	 * @param model
	 * @throws Exception
	 */
	void save(T model);

}
