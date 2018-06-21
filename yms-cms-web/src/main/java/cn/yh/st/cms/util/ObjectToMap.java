package cn.yh.st.cms.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import cn.yh.st.cms.vo.UserParam;

public class ObjectToMap {

	/**
	 * 对象转map
	 * 
	 * @param obj
	 * @return Map<String,Object>
	 */
	public static Map<String, Object> getMap(Object obj) {
		Field[] fields = obj.getClass().getDeclaredFields();
		Map<String, Object> map = new HashMap<String, Object>();
		for (int i = 0; i < fields.length; i++) {
			String name = fields[i].getName();
			fields[i].setAccessible(true);
			// 获取属性值
			try {
				Object value = fields[i].get(obj);
				if (value != null)
					map.put(name, value);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}

		}
		return map;

	}

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		UserParam u = new UserParam();
		u.setUserName("2");
		ObjectToMap.getMap(u);
	}
}
