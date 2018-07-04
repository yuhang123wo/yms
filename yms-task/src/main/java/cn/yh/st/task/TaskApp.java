package cn.yh.st.task;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.yh.st.task.blog.NewsTask;

public class TaskApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml",
				"applicationContext-task.xml");
		NewsTask t = (NewsTask) ctx.getBean("newsTask");
		t.processGetNewsTask();
	}
}
