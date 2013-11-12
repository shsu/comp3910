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

    /** The em. */
    @PersistenceContext(unitName = "assignment2")
    EntityManager em;

    /**
     * Find.
     * 
     * @param id
     *            the id
     * @return the time sheet
     */
    public TimeSheet find(final int id) {
        return em.find(TimeSheet.class, id);
    }

    /**
     * Persist.
     * 
     * @param timeSheet
     *            the time sheet
     */
    public void persist(final TimeSheet timeSheet) {
        em.persist(timeSheet);
    }

    /**
     * Merge.
     * 
     * @param timeSheet
     *            the time sheet
     */
    public void merge(final TimeSheet timeSheet) {
        em.merge(timeSheet);
    }

    /**
     * Removes the.
     * 
     * @param timeSheet
     *            the time sheet
     */
    public void remove(final TimeSheet timeSheet) {
        em.remove(find(timeSheet.getTimeSheetID()));
    }

    /**
     * Gets the all.
     * 
     * @param employeeID
     *            the employee id
     * @param week
     *            the week
     * @param year
     *            the year
     * @return the all
     */
    public List<TimeSheet> getAll(final int employeeID, final int week,
            final int year) {
        TypedQuery<TimeSheet> query = em.createQuery(
                "select t from TimeSheet t where t.employeeID = " + employeeID
                        + " and t.week = " + week + " and t.year = " + year,
                TimeSheet.class);
        return query.getResultList();
    }

}
