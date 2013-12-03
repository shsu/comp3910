package ca.bcit.infosys.a3.server.services;

import ca.bcit.infosys.a3.server.access.UserDao;
import ca.bcit.infosys.a3.server.domain.User;
import ca.bcit.infosys.a3.server.logic.UserSession;
import ca.bcit.infosys.a3.server.validation.ValidationHelper;
import org.json.JSONObject;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.Set;

@RequestScoped
@Path("/user")
public class UserResource implements Serializable {

    @EJB
    private UserDao userDao;

    @Inject
    private UserSession userSession;

    public UserResource() {
    }

    /**
     * Authenticates the user and return a string token.
     * If user is already logged in, return string token.
     */
    @POST
    @Path("authenticate")
    @Consumes("application/json")
    @Produces("application/json")
    public String authenticateUser(User user) {

        user = userDao.authenticate(user.getUsername(), user.getPassword());
        if (user == null) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        JSONObject obj = new JSONObject();
        obj.put("userID", userDao.findByUsername(user.getUsername()));
        obj.put("token", userSession.generateToken(user.getId()));

        return obj.toString();
    }

    @POST
    @Path("register")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createUser(final User user) {
        if (userDao.findByUsername(user.getUsername()) != null) {
            throw new WebApplicationException(Response.Status.CONFLICT);
        }

        User newUser = new User(user.getUsername(), user.getPassword(), user.getStudentNumber(), user.getFirstName(), user.getLastName());

        Set<ConstraintViolation<User>> constraintViolations = ValidationHelper.getValidator().validate(newUser);

        if (constraintViolations.size() > 0) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        userDao.create(newUser);

        return Response.status(Response.Status.CREATED).entity(userDao.findByUsername(user.getUsername())).build();
    }

    @GET
    @Path("profile")
    @Produces("application/json")
    public User getUser(@HeaderParam("token") final String token) {
        Integer userID = userSession.verifyTokenAndReturnUserID(token);

        if (userID == null) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        return userDao.read(userID);
    }

    @GET
    @Path("logout")
    @Produces("application/json")
    public String logout(@HeaderParam("token") final String token) {
        JSONObject obj = new JSONObject();
        obj.put("success", userSession.clearToken(token));

        return obj.toString();
    }
}
