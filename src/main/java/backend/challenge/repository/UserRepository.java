package backend.challenge.repository;

import backend.challenge.entity.Customer;
import backend.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {


    @Query(value = "SELECT * from users  where customer_org_name = ?1", nativeQuery = true)
    List<User> findrelatedUser(String org_name);

    @Query("SELECT s from users s where s.email = ?1 and s.password = ?2")
    Optional<User> findUserByUserEmailAndPassword(String userEmail, String userPassword);


}
