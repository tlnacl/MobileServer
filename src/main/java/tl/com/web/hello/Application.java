package tl.com.web.hello;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;

import tl.com.web.hello.model.Customer;
import tl.com.web.hello.model.CustomerRepository;

@ComponentScan
@EnableAutoConfiguration
public class Application {
	private static AbstractApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        
        CustomerRepository repository = context.getBean(CustomerRepository.class);

        // save a couple of customers
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));
        
     // fetch all customers
        Iterable<Customer> customers = repository.findAll();
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        System.out.println();
    }
    
    public static AbstractApplicationContext getContext(){
    	return context;
    }

}
