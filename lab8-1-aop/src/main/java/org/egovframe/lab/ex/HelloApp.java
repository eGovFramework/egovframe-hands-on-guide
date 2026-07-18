package org.egovframe.lab.ex;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloApp {

	public static void main(String[] args) throws Exception {
		String configLocation = "classpath*:META-INF/spring/context-*.xml"; 
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		HelloService helloService = (HelloService)context.getBean("helloService");
		
		log.debug("RESULT={}", helloService.sayHello("Nice to meet you!"));
		helloService.sayError();
	}
}
