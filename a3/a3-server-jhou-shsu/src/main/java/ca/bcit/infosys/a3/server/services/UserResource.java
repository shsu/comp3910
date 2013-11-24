package ca.bcit.infosys.a3.server.services;

import ca.bcit.infosys.a3.server.access.UserDao;
import ca.bcit.infosys.a3.server.domain.User;
import ca.bcit.infosys.a3.server.logic.UserSession;
import org.json.simple.JSONObject;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.Serializable;

//TODO: Validate inputs such as week range.

@RequestScoped
@Path("/user")
public class UserResource implements Serializable {

    @EJB
    UserDao userDao;

    @Inject
    UserSession userSession;

    public UserResource() {
    }

    /**
     * Authenticates the user and return a string token.
     * If user is already logged in, do something!
     */
    @POST
    @Path("authenticate")
    @Consumes("application/json")
    @Produces("application/json")
    public String authenticateUser(User user) {
        if (userSession.getToken() == null) {
            user = userDao.authenticate(user.getUsername(), user.getPassword());
            if (user == null) {
                throw new WebApplicationException(Response.Status.UNAUTHORIZED);
            }
            userSession.setUserID(user.getId());
            userSession.generateToken();
        }

        JSONObject obj = new JSONObject();
        obj.put("token", userSession.getToken());

        return obj.toJSONString();
    }

    @POST
    @Path("register")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createUser(final User user) {
        if (userDao.findByUsername(user.getUsername()) != null) {
            throw new WebApplicationException(Response.Status.CONFLICT);
        }
        userDao.create(new User(user.getUsername(), user.getPassword(), user.getStudentNumber(), user.getFirstName(), user.getLastName()));

        return Response.status(Response.Status.CREATED).entity(userDao.findByUsername(user.getUsername())).build();
    }

    @GET
    @Path("profile")
    @Produces("application/json")
    public User getUser(@HeaderParam("token") final String token) {
        if (!userSession.verifyToken(token)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        return userDao.read(userSession.getUserID());
    }

    @GET
    @Path("logout")
    @Produces("application/json")
    public String logout() {
        userSession.setUserID(0);
        userSession.clearToken();

        JSONObject obj = new JSONObject();
        obj.put("loggedOut", true);

        return obj.toJSONString();
    }
}
