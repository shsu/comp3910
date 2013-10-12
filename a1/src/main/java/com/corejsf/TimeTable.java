package com.corejsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

// TODO: Auto-generated Javadoc
/**
 * TimeTable CDI Bean.
 *
 * @author shsu
 * @version 0.1
 */
@ApplicationScoped
@Named("TimeTable")
public class TimeTable implements Serializable {

    /** The display. */
    private final List<TimeSheetBean> timeTable = new ArrayList<TimeSheetBean>();

    /** The new time sheets to be inserted. */
    private List<TimeSheetBean> newTimeSheets = new ArrayList<TimeSheetBean>();

    /** The users. */
    @Inject
    private UserBean users;

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
     * Gets the time table.
     *
     * @return the time table
     */
    public List<TimeSheetBean> getTimeTable() {
        return timeTable;
    }

    /**
     * Gets the new time sheets.
     *
     * @return the new time sheets
     */
    public List<TimeSheetBean> getNewTimeSheets() {
        return newTimeSheets;
    }

    /**
     * Sets the new time sheets.
     *
     * @param newTimeSheets
     *            the new new time sheets
     */
    public void setNewTimeSheets(final List<TimeSheetBean> newTimeSheets) {
        this.newTimeSheets = newTimeSheets;
    }

    /**
     * Gets the users.
     *
     * @return the users
     */
    public UserBean getUsers() {
        return users;
    }

    /**
     * Sets the users.
     *
     * @param users
     *            the new users
     */
    public void setUsers(final UserBean users) {
        this.users = users;
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
     * Sets the sat total.
     * 
     * @param satTotal
     *            the new sat total
     */
    public void setSatTotal(final double satTotal) {
        this.satTotal = satTotal;
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
     * Sets the sun total.
     * 
     * @param sunTotal
     *            the new sun total
     */
    public void setSunTotal(final double sunTotal) {
        this.sunTotal = sunTotal;
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
     * Sets the mon total.
     * 
     * @param monTotal
     *            the new mon total
     */
    public void setMonTotal(final double monTotal) {
        this.monTotal = monTotal;
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
     * Sets the tue total.
     * 
     * @param tueTotal
     *            the new tue total
     */
    public void setTueTotal(final double tueTotal) {
        this.tueTotal = tueTotal;
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
     * Sets the wed total.
     * 
     * @param wedTotal
     *            the new wed total
     */
    public void setWedTotal(final double wedTotal) {
        this.wedTotal = wedTotal;
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
     * Sets the thu total.
     * 
     * @param thuTotal
     *            the new thu total
     */
    public void setThuTotal(final double thuTotal) {
        this.thuTotal = thuTotal;
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
     * Sets the fri total.
     * 
     * @param friTotal
     *            the new fri total
     */
    public void setFriTotal(final double friTotal) {
        this.friTotal = friTotal;
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
        return null;
    }

    /**
     * Populate time table with filtered data.
     *
     * @param year
     *            the year
     * @param week
     *            the week
     */
    public void populateTimeTableWithFilteredData(final int year, final int week) {
        timeTable.clear();
        newTimeSheets.clear();

        // by picking rows out of the main database, we may run into a problem
        // when saving it back in. UNLESS WE REMOVE IT THEN STUFF IT BACK IN
        // DURING SAVE.
        for (TimeSheetBean userTimeSheet : users.getUserTimeSheets()) {
            if ((userTimeSheet.getWeek() == week)
                    && (userTimeSheet.getYear()) == year) {
                satTotal += userTimeSheet.getHours().getSat();
                sunTotal += userTimeSheet.getHours().getSat();
                monTotal += userTimeSheet.getHours().getSat();
                tueTotal += userTimeSheet.getHours().getSat();
                wedTotal += userTimeSheet.getHours().getSat();
                thuTotal += userTimeSheet.getHours().getSat();
                friTotal += userTimeSheet.getHours().getSat();
                timeTable.add(userTimeSheet);
            }
        }

    }

    /**
     * Adds a new time table row.
     */
    public void addTimeTableRow() {
        newTimeSheets.add(new TimeSheetBean());
    }

    /**
     * Save time table. Currently only allows saving of new time sheets.
     */
    public void saveTimeTable() {
        // add logic to save existing ones in addition to new ones.

        for (TimeSheetBean newTimeSheet : newTimeSheets) {
            users.getUserTimeSheets().add(newTimeSheet);
        }
    }

}
