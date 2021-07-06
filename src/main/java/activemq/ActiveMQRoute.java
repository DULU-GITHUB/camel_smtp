package activemq;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class ActiveMQRoute extends RouteBuilder {
	
	/*ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
	
	
	public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}*/

	public void setConnectionFactory(String connectionFactory) {
		//this.connectionFactory = connectionFactory;
	}

	

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		
		from("{{route1}}").doTry()
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				System.out.println("check1, ActiveMQRoute class");
			}
		})
				.to("{{route2}}").doCatch(Exception.class)
				.process(new Processor() {
					public void process(Exchange exchange) throws Exception {
						System.out.println("handling ex");
						final Throwable ex = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
						System.out.println(ex.getMessage());
					}
				});
	
		
		/*from("direct:in")
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				System.out.println("check1: @ direct:in");
			}
		});*/
	}

}
