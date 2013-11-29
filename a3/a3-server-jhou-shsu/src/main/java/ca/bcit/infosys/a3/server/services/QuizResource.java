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

@RequestScoped
@Path("/quiz")
public class QuizResource implements Serializable {

    @EJB
    private QuestionDao questionDao;

    @EJB
    private ResultDao resultDao;

    @Inject
    private UserSession userSession;

    @GET
    @Path("{week}")
    @Produces("application/json")
    public List<Question> getQuizForWeek(@HeaderParam("token") final String token, @PathParam("week") int week) {
        if (!userSession.verifyToken(token)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        List<Question> questions = questionDao.getAllForWeek(week);

        if (questions.isEmpty()) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return questions;
    }


    @GET
    @Path("next")
    @Produces("application/json")
    public List<Question> getNextQuiz(@HeaderParam("token") final String token) {
        if (!userSession.verifyToken(token)) {
            throw new WebApplicationException(Response.Status.UNAUTHORIZED);
        }

        int nextQuizWeek = resultDao.getNextQuizWeek(userSession.getUserID());

        List<Question> questions = questionDao.getAllForWeek(nextQuizWeek);

        if (questions.isEmpty()) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return questions;
    }

}
