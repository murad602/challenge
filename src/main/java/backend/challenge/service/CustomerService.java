package backend.challenge.service;

import backend.challenge.entity.Customer;
import backend.challenge.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public void registerCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Optional<Customer> findUserbyEmailAndName(String customerEmail, String customerPassword){
       return customerRepository.findCustomerByUserNameAndUserPassword(
               customerEmail, customerPassword);
    }

    public Optional<Customer> findCustomerByOrgName(String organizationName){
        return customerRepository.findCustomerByOrganizationName(organizationName);
    }
}
