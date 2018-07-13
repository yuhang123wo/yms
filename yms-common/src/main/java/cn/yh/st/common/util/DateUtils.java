package cn.yh.st.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	/**
	 * yyyy/MM/dd
	 */
	public static final String PATTERN_A = "yyyy/MM/dd";

	/**
	 * 
	 * @param date
	 * @param pattern
	 * @return String
	 */
	public static String formatDate(Date date, String pattern) {
		return new SimpleDateFormat(pattern).format(date);
	}

}
