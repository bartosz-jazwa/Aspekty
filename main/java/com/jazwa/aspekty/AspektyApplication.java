package com.jazwa.aspekty;

import com.jazwa.aspekty.model.Company;
import com.jazwa.aspekty.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AspektyApplication implements CommandLineRunner {

    @Autowired
    UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(AspektyApplication.class, args);
    }

    @Bean
    Company company(){
        return new Company(2L,3.21f,"Rzeszów");
    }

    @Bean
    Employee employee(){
        return new Employee("Bartek","Warszawska");
    }

    @Override
    public void run(String... args) throws Exception {
        //userService.getUpperName();
        //userService.error();
        //Company company= new Company();
        //Company cmp = company();
    }
}
