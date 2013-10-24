package ca.bcit.infosys.a1;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
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
@SessionScoped
@Named("TimeTable")
public class TimeTable implements Serializable {

    /** The time sheet manager. */
    @Inject
    private TimeSheetManager timeSheetManager;

    /** The user session. */
    @Inject
    private UserSession userSession;

    /** The time table. */
    private List<TimeSheet> timeTable;

    /** The current week. */
    private int currentWeek;

    /** The current year. */
    private int currentYear;

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
        timeTable = new ArrayList<TimeSheet>(50);
    }

    /**
     * Populate sample data.
     */
    @PostConstruct
    public void populateSampleData() {
        Random random = new Random();
        for (int i = 43; i < 50; i++) {
            for (int j = 1; j <= 3; j++) {
                timeSheetManager.getDataSource().add(
                        new TimeSheet(1, random.nextInt(10), "A"
                                + random.nextInt(9999), i, 2013));
                timeSheetManager.getDataSource().add(
                        new TimeSheet(2, random.nextInt(10), "A"
                                + random.nextInt(9999), i, 2013));
            }
        }
    }

    /**
     * Refresh time table.
     */
    public String refreshTimeTable() {
        persistTimeTable();
        timeTable.clear();
        resetTotalHours();

        if (currentWeek == 0 || currentYear == 0) {
            setDateAsToday();
        }

        for (TimeSheet timeSheet : timeSheetManager.getDataSource()) {
            if (timeSheet.getEmployeeID() == userSession.getEmployeeID()
                    && timeSheet.getWeek() == currentWeek) {
                timeTable.add(timeSheet);
                addTotalHours(timeSheet);
            }
        }
        return null;
    }

    /**
     * Reset total hours.
     */
    public void resetTotalHours() {
        satTotal = sunTotal = monTotal = tueTotal = wedTotal = thuTotal = friTotal = 0;
    }

    /**
     * Adds the total hours.
     *
     * @param toAdd
     *            the to add
     */
    public void addTotalHours(final TimeSheet toAdd) {
        satTotal += toAdd.getSat();
        sunTotal += toAdd.getSun();
        monTotal += toAdd.getMon();
        tueTotal += toAdd.getTue();
        wedTotal += toAdd.getWed();
        thuTotal += toAdd.getThu();
        friTotal += toAdd.getFri();
    }

    /**
     * Persist time table.
     */
    public void persistTimeTable() {
        timeSheetManager.getDataSource().removeAll(timeTable);
        timeSheetManager.getDataSource().addAll(timeTable);
    }

    /**
     * Adds the time table row.
     *
     * @param employeeID
     *            the employee id
     * @return the string
     */
    public String addTimeTableRow() {
        timeTable.add(new TimeSheet(userSession.getEmployeeID(), currentWeek,
                currentYear));
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
        timeTable.remove(toDelete);
        timeSheetManager.getDataSource().remove(toDelete);
        return null;
    }

    /**
     * Sets the date as today.
     */
    void setDateAsToday() {
        currentWeek = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        currentYear = Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * Gets the week ending.
     *
     * @return the week ending
     */
    public String getWeekEnding() {
        SimpleDateFormat f = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, currentYear);
        c.set(Calendar.WEEK_OF_YEAR, currentWeek);
        c.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

        return f.format(c.getTime());
    }

    /**
     * Gets the time table.
     *
     * @return the time table
     */
    public List<TimeSheet> getTimeTable() {
        refreshTimeTable();
        return timeTable;
    }

    /**
     * Sets the time table.
     *
     * @param timeTable
     *            the new time table
     */
    public void setTimeTable(final List<TimeSheet> timeTable) {
        this.timeTable = timeTable;
        persistTimeTable();
    }

    /**
     * Gets the current week.
     *
     * @return the current week
     */
    public int getCurrentWeek() {
        return currentWeek;
    }

    /**
     * Sets the current week.
     *
     * @param currentWeek
     *            the new current week
     */
    public void setCurrentWeek(final int currentWeek) {
        this.currentWeek = currentWeek;
    }

    /**
     * Gets the current year.
     *
     * @return the current year
     */
    public int getCurrentYear() {
        return currentYear;
    }

    /**
     * Sets the current year.
     *
     * @param currentYear
     *            the new current year
     */
    public void setCurrentYear(final int currentYear) {
        this.currentYear = currentYear;
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
