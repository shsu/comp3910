package ca.bcit.infosys.a1.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User Model.
 *
 * @author shsu
 * @version 0.2
 */
@Entity
@Table(name = "Users")
public class User implements Serializable {

    private int employeeID;
    private String username;
    private String password;
    private boolean superUser;

    public User() {
    }

    public User(final String username, final String password, final boolean superUser) {
        super();
        this.username = username;
        this.password = password;
        this.superUser = superUser;
    }

    @Id
    @GeneratedValue
    @Column(name = "employeeID", nullable = false)
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Basic
    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "superUser", nullable = false)
    public boolean isSuperUser() {
        return superUser;
    }

    public void setSuperUser(boolean superUser) {
        this.superUser = superUser;
    }
}
