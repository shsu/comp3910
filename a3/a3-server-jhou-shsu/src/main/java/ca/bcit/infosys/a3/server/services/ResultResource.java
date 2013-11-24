package ca.bcit.infosys.a3.server.services;

import ca.bcit.infosys.a3.server.access.QuestionDao;
import ca.bcit.infosys.a3.server.access.ResultDao;
import ca.bcit.infosys.a3.server.domain.Result;
import ca.bcit.infosys.a3.server.logic.UserSession;
import org.json.simple.JSONObject;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.List;

@RequestScoped
@Path("/results")
public class ResultResource implements Serializable {

    @EJB
    QuestionDao questionDao;

    @EJB
    ResultDao resultDao;

    @Inject
    UserSession userSession;

    @POST
    @Path("average")
    @Produces("application/json")
    public String getAverage(@HeaderParam("token") final String token) {
        if (!userSession.verifyToken(token)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        List<Result> results = resultDao.getAll(userSession.getUserID());
        if (results == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        int score = 0;
        int totalPossibleScore = 0;

        for (Result result : results) {
            score += result.getScore();
            totalPossibleScore += result.getTotalPossibleScore();
        }

        JSONObject obj = new JSONObject();
        obj.put("cumulativeAverage", score / totalPossibleScore);
        obj.put("cumulativeScore", score);
        obj.put("totalPossibleScore", totalPossibleScore);

        return obj.toJSONString();
    }

    @POST
    @Path("{week}")
    @Produces("application/json")
    public String getResult(@HeaderParam("token") final String token, @PathParam("week") final int week) {
        if (!userSession.verifyToken(token)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        Result result = resultDao.getResultForWeek(userSession.getUserID(), week);
        if (result == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        JSONObject obj = new JSONObject();
        obj.put("score", result.getScore());
        obj.put("totalPossibleScore", result.getTotalPossibleScore());

        return obj.toJSONString();
    }
}
