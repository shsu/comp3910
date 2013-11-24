package ca.bcit.infosys.a3.server.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//TODO: validation

@Entity
@Table(name = "Users")
public class User {

    private int id;
    private String username;
    private String password;
    private String studentNumber;
    private String firstName;
    private String lastName;

    public User() {
    }

    public User(String username, String password, String studentNumber, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    @Min(1)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 20)
    @NotNull
    @NotBlank
    @Size(max = 20)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 20)
    @NotNull
    @NotBlank
    @Size(max = 20)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "studentNumber", nullable = false, length = 10)
    @NotNull
    @NotBlank
    @Size(max = 10)
    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    @Basic
    @Column(name = "firstName", nullable = false, length = 30)
    @NotNull
    @NotBlank
    @Size(max = 30)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName", nullable = false, length = 30)
    @NotNull
    @NotBlank
    @Size(max = 30)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
