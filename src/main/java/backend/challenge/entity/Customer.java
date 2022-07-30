package backend.challenge.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table

public class Customer {

    @Id
    @Column(name = "org_name")
    private String organizationName;
    private String phoneNumber;
    private String address;
    private String customerName;

    private String customerEmail;
    @Size(min = 6)
    private String customerPassword;
    private String role;


    public Customer(String organizationName, String phoneNumber, String address, String customerName, String customerEmail, String customerPassword) {
        this.organizationName = organizationName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.role = "ADMIN";
    }

    public Customer(String organizationName) {
        this.organizationName = organizationName;
    }

    @OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
            @JoinColumn(name = "cu_fk", referencedColumnName = "org_name")
    List<User> listUsers;

}
