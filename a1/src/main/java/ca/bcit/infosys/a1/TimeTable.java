package ca.bcit.infosys.a1;

import ca.bcit.infosys.a1.access.TimeSheetManager;
import ca.bcit.infosys.a1.messages.MessagesHelper;
import ca.bcit.infosys.a1.model.TimeSheet;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * TimeTable CDI Bean.
 *
 * @author shsu
 * @version 0.2
 */
@SessionScoped
@Named("TimeTable")
public class TimeTable implements Serializable {

    /** The Constant MAXIMUM_HOURS_PER_DAY. */
    private static final int MAXIMUM_HOURS_PER_DAY = 24;

    /** The Constant MAXIMUM_TIMESHEETS. */
    private static final int MAXIMUM_TIMESHEETS = 50;

    /** The Constant WEEKS_IN_A_YEAR. */
    private static final int WEEKS_IN_A_YEAR = 52;

    /** The Constant DEFAULT_TIMESHEETS_TIMETABLE. */
    private static final int DEFAULT_TIMESHEETS_TIMETABLE = 5;

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

    /** The empty time table alert. */
    private boolean emptyTimeTableAlert;

    /** The saved successful notify. */
    private boolean savedSuccessfulNotify;

    /**
     * Instantiates a new time table.
     */
    public TimeTable() {
        timeTable = new ArrayList<TimeSheet>(MAXIMUM_TIMESHEETS);
    }

    /**
     * Adds the time table row.
     *
     * @return the string
     */
    public String addTimeTableRow() {
        TimeSheet newRow = new TimeSheet(userSession.getCurrentLoggedInUser()
                .getEmployeeID(), currentWeek,
                currentYear, "");
        timeTable.add(newRow);
        timeSheetManager.persist(newRow);
        return null;
    }

    /**
     * Delete time table row.
     *
     * @param toDelete the to delete
     * @return the string
     */
    public String deleteTimeTableRow(final TimeSheet toDelete) {
        timeTable.remove(toDelete);
        timeSheetManager.remove(toDelete);
        return null;
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
     * Gets the fri total.
     *
     * @return the fri total
     */
    public double getFriTotal() {
        return friTotal;
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
     * Gets the thu total.
     *
     * @return the thu total
     */
    public double getThuTotal() {
        return thuTotal;
    }

    /**
     * Gets the time table.
     *
     * @return the time table
     */
    public List<TimeSheet> getTimeTable() {
        savedSuccessfulNotify = false;
        emptyTimeTableAlert = false;
        return timeTable;
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
     * Gets the weekday total hours.
     *
     * @return the weekday total
     */
    public double getWeekdayTotal() {
        return monTotal + tueTotal + wedTotal + thuTotal + friTotal;
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
     * Checks if is empty time table alert.
     *
     * @return true, if is empty time table alert
     */
    public boolean isEmptyTimeTableAlert() {
        return emptyTimeTableAlert;
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
     * Checks if is saved successful notify.
     *
     * @return true, if is saved successful notify
     */
    public boolean isSavedSuccessfulNotify() {
        return savedSuccessfulNotify;
    }

    /**
     * Navigate to next week.
     *
     * @return the string
     */
    public String nextWeek() {
        if (currentWeek < WEEKS_IN_A_YEAR && currentWeek < getWeekOfYear()) {
            currentWeek++;
        }
        refreshTimeTable();

        return null;
    }

    /**
     * Persist time table.
     *
     * @return the string
     */
    public String persistTimeTable() {

        if (validateProjectNumberWorkPackage(timeTable)
                && validateTotalHours(timeTable)) {
            for (TimeSheet displayedOnTimeTable : timeTable) {
                timeSheetManager.merge(displayedOnTimeTable);
            }
            savedSuccessfulNotify = true;
            refreshTimeTable();
        } else if (!validateTotalHours(timeTable)) {
            FacesContext error = FacesContext.getCurrentInstance();
            error.addMessage(
                    null,
                    new FacesMessage(MessagesHelper.getMessages(
                            "nonRealisticWorkingHours", error.getViewRoot()
                                    .getLocale())));
        } else {
            FacesContext error = FacesContext.getCurrentInstance();
            error.addMessage(null,
                    new FacesMessage(MessagesHelper.getMessages(
                            "projectNumberWorkPackageValidationFailed", error
                                    .getViewRoot().getLocale())));
        }

        return null;
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
     * Sets the time table.
     *
     * @param timeTable the new time table
     */
    public void setTimeTable(final List<TimeSheet> timeTable) {
        this.timeTable = timeTable;
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
     * Adds the total hours.
     *
     * @param toAdd the to add
     */
    private void addTotalHours(final TimeSheet toAdd) {
        satTotal += toAdd.getSat();
        sunTotal += toAdd.getSun();
        monTotal += toAdd.getMon();
        tueTotal += toAdd.getTue();
        wedTotal += toAdd.getWed();
        thuTotal += toAdd.getThu();
        friTotal += toAdd.getFri();
    }

    /**
     * Gets the week of year.
     *
     * @return the week of year
     */
    private int getWeekOfYear() {
        return Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
    }

    /**
     * Gets the year.
     *
     * @return the year
     */
    private int getYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * Refresh time table.
     */
    private void refreshTimeTable() {
        timeTable.clear();
        resetTotalHours();

        for (TimeSheet timeSheet : timeSheetManager.getAll(userSession
                .getCurrentLoggedInUser().getEmployeeID(), currentWeek,
                currentYear)) {
            timeTable.add(timeSheet);
            addTotalHours(timeSheet);
        }

        // only fill in blank timesheets when current week is today/future.
        if (timeTable.size() <= 0) {
            if (!isPresentOrFuture()) {
                emptyTimeTableAlert = true;
            } else {
                for (int i = 1; i <= DEFAULT_TIMESHEETS_TIMETABLE; i++) {
                    addTimeTableRow();
                }
            }
        }
    }

    /**
     * Reset total hours.
     */
    private void resetTotalHours() {
        satTotal = 0;
        sunTotal = 0;
        monTotal = 0;
        tueTotal = 0;
        wedTotal = 0;
        thuTotal = 0;
        friTotal = 0;
    }

    /**
     * Validate Unique Project Number and Work Package.
     *
     * @param toValidate list of timesheets.
     * @return false if duplicates found else return true.
     */
    private boolean validateProjectNumberWorkPackage(List<TimeSheet> toValidate) {
        Set<String> temporaryValidationSet = new HashSet<String>();

        for (TimeSheet timeSheet : toValidate) {
            if (!temporaryValidationSet.add(timeSheet.getProjectNumber()
                    + timeSheet.getWorkPackage())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Validate total hours.
     *
     * @param toValidate the to validate
     * @return true, if successful
     */
    private boolean validateTotalHours(List<TimeSheet> toValidate) {
        int validateSatTotal = 0;
        int validateSunTotal = 0;
        int validateMonTotal = 0;
        int validateTueTotal = 0;
        int validateWedTotal = 0;
        int validateThuTotal = 0;
        int validateFriTotal = 0;

        for (TimeSheet timeSheet : toValidate) {
            validateSatTotal += timeSheet.getSat();
            validateSunTotal += timeSheet.getSun();
            validateMonTotal += timeSheet.getMon();
            validateTueTotal += timeSheet.getTue();
            validateWedTotal += timeSheet.getWed();
            validateThuTotal += timeSheet.getThu();
            validateFriTotal += timeSheet.getFri();

            if (validateSatTotal > MAXIMUM_HOURS_PER_DAY
                    || validateSunTotal > MAXIMUM_HOURS_PER_DAY
                    || validateMonTotal > MAXIMUM_HOURS_PER_DAY
                    || validateTueTotal > MAXIMUM_HOURS_PER_DAY
                    || validateWedTotal > MAXIMUM_HOURS_PER_DAY
                    || validateThuTotal > MAXIMUM_HOURS_PER_DAY
                    || validateFriTotal > MAXIMUM_HOURS_PER_DAY) {
                return false;
            }
        }

        return true;
    }
}
