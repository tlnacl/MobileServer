package tl.com.web.hello;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tl.com.web.hello.model.Customer;
import tl.com.web.hello.model.CustomerRepository;
import tl.com.web.hello.rest.Greeting;

@Controller
public class GreetingController {
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @RequestMapping("/rest/greeting")
    public @ResponseBody List<Customer> greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name) {
    	CustomerRepository repository = Application.getContext().getBean(CustomerRepository.class);
    	
    	// fetch customers by last name
        List<Customer> bauers = repository.findByLastName("Bauer");
        System.out.println("Customer found with findByLastName('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Customer bauer : bauers) {
            System.out.println(bauer);
        }
        return bauers;    
        }
    
//    @RequestMapping("/rest/greeting")
//    public 

}
