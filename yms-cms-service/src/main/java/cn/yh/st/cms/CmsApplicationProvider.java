package cn.yh.st.cms;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CmsApplicationProvider {

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"classpath:applicationContext.xml");
			context.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		synchronized (CmsApplicationProvider.class) {
			try {
				CmsApplicationProvider.class.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
