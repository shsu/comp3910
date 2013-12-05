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

/**
 * Resource responsible for user related tasks such as authentication, profile, and logout.
 */
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
     * Returns HTTP 200 and returns user token if credentials are correct.
     * Returns HTTP 401 if credentials are not correct.
     *
     * @param user JSONObject
     * @return token
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
        obj.put("userID", userDao.findByUsername(user.getUsername()).getId());
        obj.put("token", userSession.generateToken(user.getId()));

        return obj.toString();
    }


    /**
     * Returns HTTP 201 and creates a unique new user.
     * Returns HTTP 400 if desired new user is invalid.
     * Returns HTTP 409 if desired new user already exists.
     *
     * @param user JSONObject
     * @return the new user details
     */
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

    /**
     * Returns HTTP 200 and user profile.
     * Returns HTTP 401 if token is not correct.
     *
     * @param token authorization
     * @return JSONObject of user details
     */
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

    /**
     * Returns HTTP 200 and logs out user.
     *
     * @param token to invalidate
     * @return if token was invalidated successfully or not
     */
    @GET
    @Path("logout")
    @Produces("application/json")
    public String logout(@HeaderParam("token") final String token) {
        JSONObject obj = new JSONObject();
        obj.put("success", userSession.clearToken(token));

        return obj.toString();
    }
}
