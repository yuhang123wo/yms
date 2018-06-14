package cn.yh.st.common.util;


public class StringUtil {
	/**
	 * 是否为空
	 * 
	 * @param str
	 * @return
	 * @author yuhang
	 */
	public static boolean isNotEmpty(String str) {
		if (null != str && !"".equals(str.trim())) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(String str) {
		return !isNotEmpty(str);
	}

	/**
	 * 过滤特定字符串
	 * 
	 * @param str
	 * @param filter
	 * @return
	 * @author yuhang
	 */
	public static String filterString(String str, String filter) {
		return str.replace(filter, "");
	}

	/**
	 * 添加模糊查询条件
	 * 
	 * @date 2016年4月29日
	 * @author yuhang
	 */
	public static String addLike(String str) {
		if (isNotEmpty(str)) {
			return "%" + str.trim() + "%";
		} else {
			return null;
		}
	}

	/**
	 * 去除去空字符串
	 * 
	 * @date 2016年5月9日
	 * @author yuhang
	 */
	public static String trimString(String str) {
		if (isNotEmpty(str)) {
			return str.trim();
		}
		return null;
	}
}
