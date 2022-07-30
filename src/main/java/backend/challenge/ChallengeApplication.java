package backend.challenge;

import backend.challenge.entity.Customer;
import backend.challenge.entity.User;
import backend.challenge.repository.CustomerRepository;
import backend.challenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;

import javax.validation.constraints.Email;
import java.util.List;

@SpringBootApplication
public class ChallengeApplication {

//	@Autowired
//	private JavaMailSend javaMailSend;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
		}

//	@Bean
//	CommandLineRunner commandLineRunner(CustomerRepository repository, UserRepository userRepository) {
//		return args -> {
//			Customer murad = new Customer("MuradMMC", "+994559140793", "Ramana",
//					"Murad_39",
//					"mabdullayev@gmail.com",
//					"murad602");
//			Customer ali = new Customer("AliMMC", "+99455123456", "Baki",
//					"ali414",
//					"aliyev@gmail.com",
//					"ali414");
//
//			User user1 = new User("murad@gmail.com",
//					"murad", "abdullayev", "12345");
//			User user2 = new User("mura2d@gmail.com",
//					"murad2", "abdull2ayev", "123245");
//			userRepository.saveAll(List.of(user1, user2));
//
//			repository.saveAll(List.of(murad, ali));
//		};
//
//	}
//	@EventListener(ApplicationReadyEvent.class)
//	public void mailSend(){
//		javaMailSend.mailSend("mdabdullayev2021@ada.edu.az",
//				"Salam Test",
//				"netersen?");
//	}
}
