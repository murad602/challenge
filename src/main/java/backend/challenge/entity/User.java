package backend.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class User {

    @Id
    @Column(name = "user_email")
    private String email;
    private String userName;
    private String surname;
    private String password;

    private String role;

    public String getRole() {
        return "USER";
    }

    public void setRole(String role) {
        this.role = "USER";
    }

    public User(String email, String userName, String surname, String password) {
        this.email = email;
        this.userName = userName;
        this.surname = surname;
        this.password = password;
        this.role = "USER";
    }

    @ManyToOne()
    private Customer customer;

    @ManyToMany(mappedBy = "tasksUsers")
    List<Task>tasks_users;


}
