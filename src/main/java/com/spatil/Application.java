package com.spatil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spatil.beans.User;
import com.spatil.service.UserService;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application 
{
    public static void main( String[] args )
    {
    		ApplicationContext appContext = SpringApplication.run(Application.class, args);
    		UserService userService = appContext.getBean(UserService.class);
    		
    		User user = new User("sunilp@gmail.com", "sunil");  		
    		//userService.saveUser(user);
    		
    		//user.setEmail("sunilp@gmail.com");
    		user.setId(1);
    		userService.updateUser(user);
    		
    		System.out.println("User is updated..");
    }
}
