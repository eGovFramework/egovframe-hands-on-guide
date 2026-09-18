package lab;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomerServiceApp {
	public static void main(String[] args) {
		String configLocation = "classpath*:META-INF/spring/context-*.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		CustomerService customerXML=(CustomerService)context.getBean("customerXML");
		log.debug("[XML]");
		log.debug("NAME={}", customerXML.getCustomerName("1"));
		log.debug("GRADE={}", customerXML.getCustomerGrade("1"));
		
		CustomerService customerAnnotation = (CustomerService)context.getBean("customer");
		
		log.debug("[Annotation]");
		log.debug("NAME={}", customerAnnotation.getCustomerName("2"));
		log.debug("GRADE={}", customerAnnotation.getCustomerGrade("2"));
	}
}
