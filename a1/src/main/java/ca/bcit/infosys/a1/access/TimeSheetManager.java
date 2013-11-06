package ca.bcit.infosys.a1.access;

import ca.bcit.infosys.a1.model.TimeSheet;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

/**
 * Handles CRUD actions for TimeSheet class.
 *
 * @author shsu
 * @version 0.2
 */
@SessionScoped
@Stateful
public class TimeSheetManager implements Serializable {
    @PersistenceContext(unitName = "assignment2")
    EntityManager em;

    public TimeSheet find(final int id) {
        return em.find(TimeSheet.class, id);
    }

    public void persist(final TimeSheet timeSheet) {
        em.persist(timeSheet);
    }

    public void merge(final TimeSheet timeSheet) {
        em.merge(timeSheet);
    }

    public void remove(final TimeSheet timeSheet) {
        em.remove(find(timeSheet.getTimeSheetID()));
    }

    public void removeAll() {
        for (TimeSheet timeSheet : getAll()) {
            em.remove(timeSheet);
        }
    }

    public List<TimeSheet> getAll() {
        TypedQuery<TimeSheet> query = em.createQuery("select t from TimeSheet t", TimeSheet.class);
        return query.getResultList();
    }

}
