package quartz;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

//@SpringBootApplication
public class QuartzApplication {
	public static void main(String[] args) throws Exception {
		/*AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-camel.xml");
        ctx.start();*/
		CamelContext ctx= new DefaultCamelContext();
		ctx.addRoutes(new QuartzRoute());
		ctx.start();
        System.out.println("Application context started");
        try {
            Thread.sleep(5 * 60 * 1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
       
	}

}
