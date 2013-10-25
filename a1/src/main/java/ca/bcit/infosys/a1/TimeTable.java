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

    /** The recycle bin. */
    private final List<TimeSheet> recycleBin;

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

    /** The empty time table alert. */
    private boolean emptyTimeTableAlert;

    /**
     * Instantiates a new time table.
     */
    public TimeTable() {
        timeTable = new ArrayList<TimeSheet>(50);
        recycleBin = new ArrayList<TimeSheet>(50);

    }

    /**
     * Populate time table.
     */
    @PostConstruct
    public void initialSetUp() {
        populateSampleData();
        thisWeek();
    }

    /**
     * Populate sample data.
     */
    public void populateSampleData() {
        Random random = new Random();
        for (int i = 2; i < 10; i++) {
            for (int j = 1; j <= 3; j++) {
                timeSheetManager.getDataSource().add(
                        new TimeSheet(1, random.nextInt(10), "A"
                                + random.nextInt(9999), getWeekOfYear() - i,
                                2013, random.nextInt(9), random.nextInt(9),
                                random.nextInt(9), random.nextInt(9), random
                                        .nextInt(9)));
                timeSheetManager.getDataSource().add(
                        new TimeSheet(2, random.nextInt(10), "A"
                                + random.nextInt(9999), getWeekOfYear() - i,
                                2013, random.nextInt(9), random.nextInt(9),
                                random.nextInt(9), random.nextInt(9), random
                                        .nextInt(9)));
            }
        }
    }

    /**
     * Navigate to previous week.
     *
     * @return the string
     */
    public String previousWeek() {
        if (currentWeek > 1) {
            currentWeek--;
        }

        refreshTimeTable();

        return null;
    }

    /**
     * Navigate to this week.
     *
     * @return the string
     */
    public String thisWeek() {
        currentWeek = getWeekOfYear();
        currentYear = getYear();
        refreshTimeTable();

        return null;
    }

    /**
     * Navigate to next week.
     *
     * @return the string
     */
    public String nextWeek() {
        if (currentWeek < 52 && currentWeek < getWeekOfYear()) {
            currentWeek++;
        }
        refreshTimeTable();

        return null;
    }

    /**
     * Refresh time table with new data set.
     *
     * @return the string
     */
    public String refreshTimeTable() {
        timeTable.clear();
        recycleBin.clear();
        resetTotalHours();
        emptyTimeTableAlert = false;

        for (TimeSheet timeSheet : timeSheetManager.getDataSource()) {
            if (timeSheet.getEmployeeID() == userSession.getEmployeeID()
                    && timeSheet.getWeek() == currentWeek
                    && timeSheet.getYear() == currentYear) {
                timeTable.add(timeSheet);
                addTotalHours(timeSheet);
            }
        }

        // only fill in blank timesheets when current week is today/future.
        if (timeTable.size() <= 0) {
            for (int i = 1; i <= 5; i++) {
                addTimeTableRow();
            }

            if (!isPresentOrFuture()) {
                emptyTimeTableAlert = true;
            }
        }

        return null;
    }

    /**
     * Persist time table.
     */
    public void persistTimeTable() {
        timeSheetManager.getDataSource().removeAll(recycleBin);
        recycleBin.clear();
        timeSheetManager.getDataSource().removeAll(timeTable);
        timeSheetManager.getDataSource().addAll(timeTable);
    }

    /**
     * Adds the time table row.
     *
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
        recycleBin.add(toDelete);
        return null;
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
     * Gets the weekday total hours.
     *
     * @return the weekday total
     */
    public double getWeekdayTotal() {
        return monTotal + tueTotal + wedTotal + thuTotal + friTotal;
    }

    /**
     * Checks if is present or future.
     *
     * @return true, if is present or future
     */
    public boolean isPresentOrFuture() {
        return currentWeek >= getWeekOfYear();
    }

    /**
     * Gets the week of year.
     *
     * @return the week of year
     */
    public int getWeekOfYear() {
        return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * Gets the year.
     *
     * @return the year
     */
    public int getYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * Gets the time table.
     *
     * @return the time table
     */
    public List<TimeSheet> getTimeTable() {
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
     * Gets the current year.
     *
     * @return the current year
     */
    public int getCurrentYear() {
        return currentYear;
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

    public boolean isEmptyTimeTableAlert() {
        return emptyTimeTableAlert;
    }

    public void setEmptyTimeTableAlert(final boolean emptyTimeTableAlert) {
        this.emptyTimeTableAlert = emptyTimeTableAlert;
    }

}
