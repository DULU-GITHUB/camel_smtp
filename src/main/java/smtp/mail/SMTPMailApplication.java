package smtp.mail;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

public class SMTPMailApplication {
	 public static void main(String[] args) {
	        SMTPMailRouter routeBuilder = new SMTPMailRouter();
	        CamelContext ctx = new DefaultCamelContext();
	        try {
	            ctx.addRoutes(routeBuilder);
	            ctx.start();
	            Thread.sleep(5 * 60 * 1000);
	            ctx.stop();
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
}
