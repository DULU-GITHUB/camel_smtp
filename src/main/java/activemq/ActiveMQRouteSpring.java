package activemq;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.main.Main;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class ActiveMQRouteSpring extends RouteBuilder {
	
	ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
	
	
	@Bean
	public ConnectionFactory connectionFactory() {
		return connectionFactory;
	}
	
	public ConnectionFactory getConnectionFactory() {
		return connectionFactory;
	}

	public void setConnectionFactory(String connectionFactory) {
		//this.connectionFactory = connectionFactory;
	}

	

	@Override
	public void configure() throws Exception {
		
		 Main main = new Main();
	     main.enableHangupSupport();
	     main.bind("connectionFactory", connectionFactory);

		// TODO Auto-generated method stub
		
		//ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

		from("file:C:\\Users\\Manoranjan Gharai\\Desktop\\jenkin\\check1?noop=true").doTry()
		.process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				System.out.println("check1");
			}
		})
				.to("jms:queue:amqtest?connectionFactory=connectionFactory").doCatch(Exception.class)
				.process(new Processor() {
					public void process(Exchange exchange) throws Exception {
						System.out.println("handling ex");
						final Throwable ex = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
						System.out.println(ex.getMessage());
					}
				});
		// "file:C:\\Users\\Manoranjan
		// Gharai\\Desktop\\jenkin\\mcheck?noop=true"

	}

}
