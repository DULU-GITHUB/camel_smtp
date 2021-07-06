package activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ActiveMQApplication {
	public static void main(String[] args) {

		/*ActiveMQRoute routeBuilder = new ActiveMQRoute();
		CamelContext ctx = new DefaultCamelContext();
*/
		// configure jms component
		/*ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
*/
		ApplicationContext ctx1=new ClassPathXmlApplicationContext("camel-context.xml");
		try {
			/*ctx.addRoutes(routeBuilder);
			ctx.start();*/
			Thread.sleep(5 * 60 * 1000);
			//ctx.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
