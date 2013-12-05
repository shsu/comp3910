package ca.bcit.infosys.a3.server.services;

import ca.bcit.infosys.a3.server.access.QuestionDao;
import ca.bcit.infosys.a3.server.access.ResultDao;
import ca.bcit.infosys.a3.server.domain.Question;
import ca.bcit.infosys.a3.server.logic.UserSession;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.util.List;

/**
 * Resource responsible for generating questions for quizzes.
 */
@RequestScoped
@Path("/quiz")
public class QuizResource implements Serializable {

    @EJB
    private QuestionDao questionDao;

    @EJB
    private ResultDao resultDao;

    @Inject
    private UserSession userSession;

    /**
     * Returns HTTP 200 and JSON Array of questions for the specified quiz.
     * Returns HTTP 401 if token is not correct.
     * Returns HTTP 404 if quiz not found.
     *
     * @param token authorization
     * @param week of quiz
     * @return JSONArray of the specified quiz.
     */
    @GET
    @Path("{week}")
    @Produces("application/json")
    public List<Question> getQuizForWeek(@HeaderParam("token") final String token, @PathParam("week") int week) {
        Integer userID = userSession.verifyTokenAndReturnUserID(token);

        List<Question> questions = questionDao.getAllForWeek(week);

        if (questions.isEmpty()) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return questions;
    }

    /**
     * Returns HTTP 200 and JSON Array of questions for the next quiz.
     * Returns HTTP 401 if token is not correct.
     * Returns HTTP 404 if quiz not found.
     *
     * @param token authorization
     * @return JSONArray of the next quiz.
     */
    @GET
    @Path("next")
    @Produces("application/json")
    public List<Question> getNextQuiz(@HeaderParam("token") final String token) {
        Integer userID = userSession.verifyTokenAndReturnUserID(token);

        int nextQuizWeek = resultDao.getNextQuizWeek(userID);

        List<Question> questions = questionDao.getAllForWeek(nextQuizWeek);

        if (questions.isEmpty()) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return questions;
    }

}
