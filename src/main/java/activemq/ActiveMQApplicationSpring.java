package activemq;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

//@SpringBootApplication
public class ActiveMQApplicationSpring {
	public static void main(String[] args) {

		//ApplicationContext ctx1=SpringApplication.run(ActiveMQApplicationSpring.class, args);
		//System.out.println(ctx1.getBean(ConnectionFactory.class));
		ActiveMQRouteSpring routeBuilder = new ActiveMQRouteSpring();
		CamelContext ctx = new DefaultCamelContext();
		//ctx.getRegistry().

		// configure jms component
		/*ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		ctx.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
*/
		try {
			ctx.addRoutes(routeBuilder);
			ctx.start();
			Thread.sleep(5 * 60 * 1000);
			ctx.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
