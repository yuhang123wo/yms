package cn.yh.st.base;

import cn.yh.st.common.entity.Entity;
import cn.yh.st.common.util.ReflectionHelper;

import com.github.abel533.mapper.Mapper;

public abstract class BaseServiceImpl<T extends Entity> implements BaseService<T> {
	protected Class<T> clazz;

	public BaseServiceImpl() {
		clazz = ReflectionHelper.getClassGenricType(getClass());
	}

	/**
	 * dao 层实现类
	 */
	public abstract Mapper<T> getDao();

	@Override
	public void save(T t) {
		this.getDao().insert(t);
	}

}
