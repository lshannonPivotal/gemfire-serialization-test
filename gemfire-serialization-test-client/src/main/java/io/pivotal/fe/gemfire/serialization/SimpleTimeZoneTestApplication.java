package io.pivotal.fe.gemfire.serialization;

import io.pivotal.fe.gemfire.serialization.domain.Customer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SimpleTimeZone;
import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import com.gemstone.gemfire.cache.Region;

@SpringBootApplication
@ImportResource("classpath:gemfire-client-cache.xml")
public class SimpleTimeZoneTestApplication {
	
	 @Resource(name="customer")
	 private Region<String, Customer> region;

    public static void main(String[] args) {
        SpringApplication.run(SimpleTimeZoneTestApplication.class, args);
    }
    
    @Bean
    CommandLineRunner loadData() {
    	return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				Customer c = new Customer();
		    	c.setName("test");
		    	c.setSimpleTimeZone(new SimpleTimeZone(1, "EDT"));
		    	region.put("test", c);
		    	System.out.println("Put is complete");
		    	Customer result = region.get("test");
		    	System.out.println("The result back from Gemfire: " + result);
				System.out.println("\n Test Complete!\n");
			    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			    try {
					bufferedReader.readLine();
				} catch (IOException e) {}
			}
    		
    	};
    }
    
    
}
