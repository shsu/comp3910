package ca.bcit.infosys.a3.server.services;

import ca.bcit.infosys.a3.server.access.QuestionDao;
import ca.bcit.infosys.a3.server.access.ResultDao;
import ca.bcit.infosys.a3.server.domain.Result;
import ca.bcit.infosys.a3.server.logic.UserSession;
import ca.bcit.infosys.a3.server.validation.ValidationHelper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
    QuestionDao questionDao;

    @EJB
    ResultDao resultDao;

    @Inject
    UserSession userSession;

    @GET
    @Produces("application/json")
    public String getResult(@HeaderParam("token") final String token) {
        if (!userSession.verifyToken(token)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        List<Result> results = resultDao.getAll(userSession.getUserID());
        if (results.isEmpty()) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        JSONObject outputJSON = new JSONObject();

        int score = 0;
        int totalPossibleScore = 0;
        JSONArray userQuizResults = new JSONArray();

        for (Result result : results) {
            score += result.getScore();
            totalPossibleScore += result.getTotalPossibleScore();

            JSONObject quizResult = new JSONObject();
            quizResult.put("week", result.getWeek());
            quizResult.put("score", result.getScore());
            quizResult.put("totalPossibleScore", result.getTotalPossibleScore());
            userQuizResults.add(quizResult);
        }

        outputJSON.put("cumulativeAverage", score / totalPossibleScore);
        outputJSON.put("results", userQuizResults);

        return outputJSON.toJSONString();
    }

    @PUT
    @Path("save")
    @Consumes("application/json")
    public Response saveResult(@HeaderParam("token") final String token, Result result) {
        if (!userSession.verifyToken(token)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        if (resultDao.getResultForWeek(userSession.getUserID(), result.getWeek()) != null) {
            throw new WebApplicationException(Response.Status.CONFLICT);
        }

        Result newResult = new Result(userSession.getUserID(), result.getWeek(), result.getScore(), result.getTotalPossibleScore());
        Set<ConstraintViolation<Result>> constraintViolations = ValidationHelper.getValidator().validate(newResult);

        if (constraintViolations.size() > 0) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        resultDao.create(newResult);

        return Response.created(URI.create("/results")).build();
    }
}
