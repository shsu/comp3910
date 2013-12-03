package ca.bcit.infosys.a3.server.logic;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
public class UserSession implements Serializable {

    private Map<String, Integer> tokensForAuthenticatedUserID;

    private static final boolean TEST_MODE = false;

    private static final int TEST_USER_ID = 1;

    public static final String TEST_TOKEN = "test";

    public UserSession() {
        tokensForAuthenticatedUserID = new HashMap<String, Integer>();
        if (TEST_MODE) {
            tokensForAuthenticatedUserID.put(TEST_TOKEN, TEST_USER_ID);
        }
    }

    public boolean clearToken(String tokenToBeClearerd) {
        Integer userID = tokensForAuthenticatedUserID.remove(tokenToBeClearerd);

        if (userID != null) {
            return true;
        }
        return false;
    }

    public String generateToken(final int userID) {
        String token = UUID.randomUUID().toString().replaceAll("-", "");
        tokensForAuthenticatedUserID.put(token, userID);

        return token;
    }

    public Integer verifyTokenAndReturnUserID(String tokenToBeVerified) throws WebApplicationException {
        if (tokenToBeVerified != null) {

            Integer userID = tokensForAuthenticatedUserID.get(tokenToBeVerified);
            if (userID != null) {
                return userID;
            }

        }
        throw new WebApplicationException(Response.Status.UNAUTHORIZED);
    }
}
