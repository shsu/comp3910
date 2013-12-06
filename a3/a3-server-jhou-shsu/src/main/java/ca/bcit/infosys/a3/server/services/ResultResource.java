package ca.bcit.infosys.a3.server.services;

import ca.bcit.infosys.a3.server.access.ResultDao;
import ca.bcit.infosys.a3.server.domain.Result;
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
import java.net.URI;
import java.util.List;
import java.util.Set;

/**
 * Resource responsible for storing quiz results, retriving them, and calculating averages.
 */
@RequestScoped
@Path("/results")
public class ResultResource implements Serializable {

    @EJB
    private ResultDao resultDao;

    @Inject
    private UserSession userSession;

    /**
     * Returns HTTP 200 and a JSON Object of the result for week specified.
     * Returns HTTP 401 if token is not correct.
     * Returns HTTP 404 if no results exists in the database for user.
     *
     * @param token authentication
     * @param week  of quiz
     * @return JSONObject result
     */
    @GET
    @Path("{week}")
    @Produces("application/json")
    public Result getResult(@HeaderParam("token") final String token, @PathParam("week") final int week) {
        Integer userID = userSession.verifyTokenAndReturnUserID(token);

        Result result = resultDao.getResultForWeek(userID, week);
        if (result == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return result;
    }

    /**
     * Returns HTTP 200 and a JSON Array of the results for all quizzes taken so far.
     * Returns HTTP 401 if token is not correct.
     * Returns HTTP 404 if no results exists in the database for user.
     *
     * @param token authentication
     * @return JSONArray of results
     */
    @GET
    @Produces("application/json")
    public List<Result> getResults(@HeaderParam("token") final String token) {
        Integer userID = userSession.verifyTokenAndReturnUserID(token);

        List<Result> results = resultDao.getAll(userID);
        if (results.isEmpty()) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return results;
    }

    /**
     * Returns HTTP 200 and JSON Object with a cumulative average based on the results for all quizzes taken so far.
     * Returns HTTP 401 if token is not correct.
     * Returns HTTP 404 if no results exists in the database for user.
     *
     * @param token
     * @return the cumulative average score
     */
    @GET
    @Path("average")
    @Produces("application/json")
    public String getResultsAverage(@HeaderParam("token") final String token) {
        Integer userID = userSession.verifyTokenAndReturnUserID(token);

        List<Result> results = resultDao.getAll(userID);
        if (results.isEmpty()) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        int score = 0;
        int totalPossibleScore = 0;

        for (Result result : results) {
            score += result.getScore();
            totalPossibleScore += result.getTotalPossibleScore();
        }

        JSONObject outputJSON = new JSONObject();
        outputJSON.put("cumulativeAverage", ((double) score / totalPossibleScore));

        return outputJSON.toString();
    }

    /**
     * Returns HTTP 201 and creates a unique new record for quiz week specified.
     * Returns HTTP 400 if new record is invalid.
     * Returns HTTP 401 if token is not correct.
     * Returns HTTP 409 if new record already exists.
     *
     * @param token authentication
     * @param week  of quiz
     * @return JSONObject
     */
    @POST
    @Path("{week}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response saveResult(@HeaderParam("token") final String token, @PathParam("week") final int week, final Result result) {
        Integer userID = userSession.verifyTokenAndReturnUserID(token);

        if (resultDao.getResultForWeek(userID, week) != null) {
            throw new WebApplicationException(Response.Status.CONFLICT);
        }

        Result newResult = new Result(userID, week, result.getScore(), result.getTotalPossibleScore());
        Set<ConstraintViolation<Result>> constraintViolations = ValidationHelper.getValidator().validate(newResult);

        if (constraintViolations.size() > 0) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        resultDao.create(newResult);

        return Response.status(Response.Status.CREATED).entity(newResult).build();
    }


    /**
     * Returns HTTP 200 and deletes all quiz records for user.
     * Returns HTTP 401 if token is not correct.
     * Returns HTTP 404 if no results exists in the database for user.
     *
     * @param token authentication
     * @return success
     */
    @DELETE
    @Path("all")
    public String clearAllResults(@HeaderParam("token") final String token) {
        Integer userID = userSession.verifyTokenAndReturnUserID(token);

        List<Result> results = resultDao.getAll(userID);

        if (results.isEmpty()) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        for (Result result : results) {
            resultDao.delete(result);
        }

        JSONObject outputJSON = new JSONObject();
        outputJSON.put("success", true);

        return outputJSON.toString();
    }
}
