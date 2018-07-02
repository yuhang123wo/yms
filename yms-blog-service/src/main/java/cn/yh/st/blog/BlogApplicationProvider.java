package cn.yh.st.blog;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BlogApplicationProvider {
	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
					"classpath:applicationContext.xml");
			context.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		synchronized (BlogApplicationProvider.class) {
			try {
				BlogApplicationProvider.class.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
