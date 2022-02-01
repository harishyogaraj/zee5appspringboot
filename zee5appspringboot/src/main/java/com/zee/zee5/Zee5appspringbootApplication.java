package com.zee.zee5;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5.dto.Register;
import com.zee.zee5.repository.UserRepository;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=
				SpringApplication.run(Zee5appspringbootApplication.class, args);
		
		DataSource dataSource=applicationContext.getBean(DataSource.class);
		System.out.println(dataSource!=null);
		
		
		
		UserRepository userRepository=applicationContext.getBean(UserRepository.class);

		Register register;
		try {
			register = new Register("pavan4", "harish", "y", "pavan4@gmail.com","12345678");
			System.out.println(userRepository.addUser(register));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		applicationContext.close();
	}

}
