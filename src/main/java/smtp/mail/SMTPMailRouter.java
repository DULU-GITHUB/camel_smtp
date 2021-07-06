package smtp.mail;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class SMTPMailRouter extends RouteBuilder{

	@Override
	public void configure() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("This is mail check 1 application");
		
		/*from("file:C:\\Users\\Manoranjan Gharai\\Desktop\\jenkin\\mcheck1").doTry().setHeader("subject", simple("camel smtp mail check"))
		.setHeader("to", simple("manoranjangharai@gmail.com"))
		.process(
				new Processor(){
					public void process(Exchange arg) throws Exception {
						// TODO Auto-generated method stub
						System.out.println("processing get request1");
						System.out.println(arg.getIn().getBody(String.class));
						
					}
					
					
				})
		.to("smtps://smtp.gmail.com:465?username=g6.manoranjan@gmail.com&password=setsetgo")
		.process(
				new Processor(){
					public void process(Exchange arg) throws Exception {
						// TODO Auto-generated method stub
						System.out.println("processing get request");
						System.out.println(arg.getIn().getBody(String.class));
						
					}
					
					
				});
		*/
		
		//"file:C:\\Users\\Manoranjan Gharai\\Desktop\\jenkin\\check1"
		//"smtp://smtp.gmail.com:465?username=manoranjangharai@gmail.com&password=setsetgo"
		
		
		
		
		from("file:C:\\Users\\Manoranjan Gharai\\Desktop\\jenkin\\mcheck?noop=true").doTry().setHeader("subject", simple("JavaInUse Invitation111"))
					.setHeader("to", simple("manoranjangharai@gmail.com"))
					.to("smtps://smtp.gmail.com:465?username=g6.manoranjan@gmail.com&password=setsetgo")
					. doCatch(Exception.class).process(new Processor() {

		                public void process(Exchange exchange) throws Exception {
		                    System.out.println("handling ex");
		                    final Throwable ex = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Throwable.class);
		                    System.out.println(ex.getMessage());
		                }
		            });
		
		
		System.out.println("This is mail check 2 application");
	}

}
