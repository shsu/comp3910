package ca.bcit.infosys.a1.model;

import javax.inject.Inject;

/**
 * TimeSheet Model.
 *
 * @author shsu
 * @version 0.1
 */
public class TimeSheet {

    /** The employee id. */
    private int employeeID;

    /** The project. */
    private int project;

    /** The work package. */
    private String workPackage;

    /** The hours. */
    @Inject
    private Hours hours;

    /** The notes. */
    private String notes;

    /** The week. */
    private int week;

    /** The year. */
    private int year;

    /**
     * Instantiates a new time sheet bean.
     *
     * @param employeeID
     *            the employee id
     */
    public TimeSheet(final int employeeID) {
        super();
        this.employeeID = employeeID;
    }

    /**
     * Gets the employee id.
     *
     * @return the employee id
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Sets the employee id.
     *
     * @param employeeID
     *            the new employee id
     */
    public void setEmployeeID(final int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Gets the project.
     *
     * @return the project
     */
    public int getProject() {
        return project;
    }

    /**
     * Sets the project.
     *
     * @param project
     *            the new project
     */
    public void setProject(final int project) {
        this.project = project;
    }

    /**
     * Gets the work package.
     *
     * @return the work package
     */
    public String getWorkPackage() {
        return workPackage;
    }

    /**
     * Sets the work package.
     *
     * @param workPackage
     *            the new work package
     */
    public void setWorkPackage(final String workPackage) {
        this.workPackage = workPackage;
    }

    /**
     * Gets the hours.
     *
     * @return the hours
     */
    public Hours getHours() {
        return hours;
    }

    /**
     * Sets the hours.
     *
     * @param hours
     *            the new hours
     */
    public void setHours(final Hours hours) {
        this.hours = hours;
    }

    /**
     * Gets the notes.
     *
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the notes.
     *
     * @param notes
     *            the new notes
     */
    public void setNotes(final String notes) {
        this.notes = notes;
    }

    /**
     * Gets the week.
     *
     * @return the week
     */
    public int getWeek() {
        return week;
    }

    /**
     * Sets the week.
     *
     * @param week
     *            the new week
     */
    public void setWeek(final int week) {
        this.week = week;
    }

    /**
     * Gets the year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year.
     *
     * @param year
     *            the new year
     */
    public void setYear(final int year) {
        this.year = year;
    }

}
