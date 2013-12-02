package ca.bcit.infosys.a3.server.logic;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.UUID;

/**
 * Created by shsu on 11/21/2013.
 */
@SessionScoped
public class UserSession implements Serializable {

    private int userID;

    private String token;

    private static final boolean TEST_MODE = false;

    private static final int TEST_USER_ID = 1;

    public static final String TEST_TOKEN = "test";

    public UserSession() {
        if (TEST_MODE) {
            userID = TEST_USER_ID;
            token = TEST_TOKEN;
        }
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getToken() {
        return token;
    }

    public void clearToken() {
        this.token = null;
    }

    public void generateToken() {
        this.token = UUID.randomUUID().toString().replaceAll("-", "");
    }

    public boolean verifyToken(String tokenToBeVerified) {
        return (this.token != null && tokenToBeVerified != null && this.token.equals(tokenToBeVerified));
    }

}
