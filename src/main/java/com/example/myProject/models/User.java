package com.example.myProject.models;
import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Double totalBalance;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Expense> expenses;

    public User(String firstName, String lastName, Double totalBalance, String email){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.totalBalance = totalBalance;
    }
}