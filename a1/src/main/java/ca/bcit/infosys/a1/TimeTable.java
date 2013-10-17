package ca.bcit.infosys.a1;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ca.bcit.infosys.a1.access.TimeSheetManager;
import ca.bcit.infosys.a1.model.TimeSheet;

/**
 * TimeTable CDI Bean.
 *
 * @author shsu
 * @version 0.1
 */
@ConversationScoped
@Named("TimeTable")
public class TimeTable implements Serializable {

    /** The conversation. */
    @Inject
    private Conversation conversation;

    /** The time sheet manager. */
    @Inject
    private TimeSheetManager timeSheetManager;

    /** The sat total. */
    private double satTotal;

    /** The sun total. */
    private double sunTotal;

    /** The mon total. */
    private double monTotal;

    /** The tue total. */
    private double tueTotal;

    /** The wed total. */
    private double wedTotal;

    /** The thu total. */
    private double thuTotal;

    /** The fri total. */
    private double friTotal;

    /**
     * Instantiates a new time table.
     */
    public TimeTable() {
        timeSheetManager.setDataSource(new ArrayList<TimeSheet>());
    }

    /**
     * Gets the time sheets.
     *
     * @return the time sheets
     */
    public List<TimeSheet> getTimeSheets() {
        return timeSheetManager.getDataSource();
    }

    /**
     * Sets the time sheets.
     *
     * @param timeSheets
     *            the new time sheets
     */
    public void setTimeSheets(final List<TimeSheet> timeSheets) {
        timeSheetManager.setDataSource(timeSheets);
    }

    /**
     * Show timesheet or not.
     *
     * @param employeeID
     *            the employee id
     * @param year
     *            the year
     * @param week
     *            the week
     * @return true, if successful
     */
    public boolean show(final int employeeID, final int year, final int week) {
        return true;
    }

    /**
     * Adds the time table row.
     *
     * @param employeeID
     *            the employee id
     * @return the string
     */
    public String addTimeTableRow(final int employeeID) {
        getTimeSheets().add(new TimeSheet(employeeID));

        return null;
    }

    /**
     * Delete time table row.
     *
     * @param toDelete
     *            the to delete
     * @return the string
     */
    public String deleteTimeTableRow(final TimeSheet toDelete) {
        getTimeSheets().remove(toDelete);

        return null;
    }

    /**
     * Refresh total hours.
     */
    public void refreshTotalHours() {

    }

    /**
     * Calculate week ending based on year and week.
     *
     * @param year
     *            the year
     * @param week
     *            the week
     * @return the string
     */
    public String calculateWeekEnding(final int year, final int week) {
        SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.WEEK_OF_YEAR, week);
        c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

        return f.format(c.getTime());
    }

    /**
     * Gets the sat total.
     *
     * @return the sat total
     */
    public double getSatTotal() {
        return satTotal;
    }

    /**
     * Gets the sun total.
     *
     * @return the sun total
     */
    public double getSunTotal() {
        return sunTotal;
    }

    /**
     * Gets the mon total.
     *
     * @return the mon total
     */
    public double getMonTotal() {
        return monTotal;
    }

    /**
     * Gets the tue total.
     *
     * @return the tue total
     */
    public double getTueTotal() {
        return tueTotal;
    }

    /**
     * Gets the wed total.
     *
     * @return the wed total
     */
    public double getWedTotal() {
        return wedTotal;
    }

    /**
     * Gets the thu total.
     *
     * @return the thu total
     */
    public double getThuTotal() {
        return thuTotal;
    }

    /**
     * Gets the fri total.
     *
     * @return the fri total
     */
    public double getFriTotal() {
        return friTotal;
    }

}
