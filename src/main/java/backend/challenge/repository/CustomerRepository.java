package backend.challenge.repository;

import backend.challenge.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

//    @Query("SELECT s from Customer s where s.email = ?1")
    Optional<Customer> findCustomerByCustomerEmail(String email);

    @Query("Select s from Customer s where s.organizationName = ?1")
    Optional<Customer> findCustomerByOrganizationName(String organizationName);

    @Query("SELECT s from Customer s where s.customerEmail = ?1 and s.customerPassword = ?2")
    Optional<Customer> findCustomerByUserNameAndUserPassword(String customerEmail, String customerPassword);
}
