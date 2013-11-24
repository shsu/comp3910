package ca.bcit.infosys.a3.server.services;

import ca.bcit.infosys.a3.server.access.QuestionDao;
import ca.bcit.infosys.a3.server.access.ResultDao;
import ca.bcit.infosys.a3.server.domain.Question;
import ca.bcit.infosys.a3.server.domain.Result;
import ca.bcit.infosys.a3.server.logic.UserSession;
import org.json.simple.JSONObject;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Path("/quiz")
public class QuizResource implements Serializable {

    @EJB
    QuestionDao questionDao;

    @EJB
    ResultDao resultDao;

    @Inject
    UserSession userSession;

    @GET
    @Path("{week}")
    @Produces("application/json")
    public List<Question> getQuizNoAnswers(@HeaderParam("token") final String token, @PathParam("week") int week) {
        if (!userSession.verifyToken(token)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        List<Question> questions = new ArrayList<Question>();

        for (Question question : questionDao.getAllForWeek(week)) {
            question.setAnswer(null);
            questions.add(question);
        }

        if (questions.isEmpty()) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return questions;
    }

    @PUT
    @Path("{week}/mark")
    @Consumes("application/json")
    @Produces("application/json")
    public String markQuiz(@HeaderParam("token") final String token, @PathParam("week") int week, List<Character> results) {
        if (!userSession.verifyToken(token)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        List<Question> answerKey = questionDao.getAllForWeek(week);
        short score = 0;

        try {
            for (short i = 0; i < results.size(); i++) {
                if (results.get(i) == answerKey.get(i).getAnswer()) {
                    score++;
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }

        resultDao.update(new Result(userSession.getUserID(), week, score, answerKey.size()));

        Result result = resultDao.getResultForWeek(userSession.getUserID(), week);
        JSONObject obj = new JSONObject();
        obj.put("marked", true);

        return obj.toJSONString();
    }

}
