package io.pivotal.fe.gemfire.serialization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:gemfire-cache.xml")
public class GemfireSerializationTestServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GemfireSerializationTestServerApplication.class, args);
    }
    
    @Bean
    CommandLineRunner loadData() {
    	return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				System.out.println("\n Press Enter To Stop The Server.\n");
			    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			    try {
					bufferedReader.readLine();
				} catch (IOException e) {}
			}
    		
    	};
    }
}
