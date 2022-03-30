package com.infytel.calldetails.infitelcalldetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.infytel.calldetails.infitelcalldetails.*")
public class InfitelCalldetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfitelCalldetailsApplication.class, args);
	}

}
