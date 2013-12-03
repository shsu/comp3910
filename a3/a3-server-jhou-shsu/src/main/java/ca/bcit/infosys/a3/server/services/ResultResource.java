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

@RequestScoped
@Path("/results")
public class ResultResource implements Serializable {

    @EJB
    private ResultDao resultDao;

    @Inject
    private UserSession userSession;

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

    @POST
    @Path("{week}")
    @Consumes("application/json")
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

        return Response.created(URI.create("/results")).status(Response.Status.CREATED).entity(newResult).build();
    }

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
