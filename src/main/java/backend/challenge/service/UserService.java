package backend.challenge.service;
import backend.challenge.entity.Customer;
import backend.challenge.entity.User;
import backend.challenge.repository.CustomerRepository;
import backend.challenge.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final CustomerRepository customerRepository;

    public UserService(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }
    public List<User> getUser() {
        return userRepository.findAll();
    }

    public List<User> getRelatedUser(String organizationName) {
        return userRepository.findrelatedUser(organizationName);
    }

    public void registerUser(User user){
        userRepository.save(user);
    }

    public Optional<Customer> getCustomerbyOrgName(String email){
        return  customerRepository.findCustomerByCustomerEmail(email);
    }
    public Optional<User> findUserbyEmailAndPassword2(String userEmail, String userPassword){
        return userRepository.findUserByUserEmailAndPassword(
                userEmail, userPassword);
    }

    public Optional<User> findUserbyEmailAndPassword(String userEmail, String userPassword){
        return userRepository.findUserByUserEmailAndPassword(userEmail, userPassword);

    }
}
