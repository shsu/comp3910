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
    private String password;
    private boolean superUser;
    private String username;

    public User() {
    }

    public User(final String username, final String password, final boolean superUser) {
        super();
        this.username = username;
        this.password = password;
        this.superUser = superUser;
    }

    @Id
    @Column(name = "employeeID", nullable = false)
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Basic
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "superUser", nullable = false)
    public boolean isSuperUser() {
        return superUser;
    }

    public void setSuperUser(boolean superUser) {
        this.superUser = superUser;
    }

    @Basic
    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (employeeID != that.employeeID) return false;
        if (superUser != that.superUser) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = employeeID;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (superUser ? 1 : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
