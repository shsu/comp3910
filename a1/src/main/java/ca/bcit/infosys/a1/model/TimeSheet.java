package ca.bcit.infosys.a1.model;

/**
 * TimeSheet Model.
 *
 * @author shsu
 * @version 0.1
 */
public class TimeSheet {

    /** The employee id. */
    private int employeeID;

    /** The project number. */
    private int projectNumber;

    /** The work package. */
    private String workPackage;

    /** The sat. */
    private double sat;

    /** The sun. */
    private double sun;

    /** The mon. */
    private double mon;

    /** The tue. */
    private double tue;

    /** The wed. */
    private double wed;

    /** The thu. */
    private double thu;

    /** The fri. */
    private double fri;

    /** The notes. */
    private String notes;

    /** The week. */
    private int week;

    /** The year. */
    private int year;

    /**
     * Instantiates a new time sheet.
     *
     * @param employeeID
     *            the employee id
     * @param week
     *            the week
     * @param year
     *            the year
     */
    public TimeSheet(final int employeeID, final int week, final int year) {
        super();
        this.employeeID = employeeID;
        this.week = week;
        this.year = year;
    }

    /**
     * Instantiates a new time sheet.
     *
     * @param employeeID
     *            the employee id
     * @param projectNumber
     *            the project number
     * @param workPackage
     *            the work package
     * @param week
     *            the week
     * @param year
     *            the year
     */
    public TimeSheet(final int employeeID, final int projectNumber,
            final String workPackage, final int week, final int year) {
        super();
        this.employeeID = employeeID;
        this.projectNumber = projectNumber;
        this.workPackage = workPackage;
        this.week = week;
        this.year = year;
    }

    /**
     * Gets the total.
     *
     * @return the total
     */
    public double getTotal() {
        return sat + sun + mon + tue + wed + thu + fri;
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
     * Gets the project number.
     *
     * @return the project number
     */
    public int getProjectNumber() {
        return projectNumber;
    }

    /**
     * Sets the project number.
     *
     * @param projectNumber
     *            the new project number
     */
    public void setProjectNumber(final int projectNumber) {
        this.projectNumber = projectNumber;
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
     * Gets the sat.
     *
     * @return the sat
     */
    public double getSat() {
        return sat;
    }

    /**
     * Sets the sat.
     *
     * @param sat
     *            the new sat
     */
    public void setSat(final double sat) {
        this.sat = sat;
    }

    /**
     * Gets the sun.
     *
     * @return the sun
     */
    public double getSun() {
        return sun;
    }

    /**
     * Sets the sun.
     *
     * @param sun
     *            the new sun
     */
    public void setSun(final double sun) {
        this.sun = sun;
    }

    /**
     * Gets the mon.
     *
     * @return the mon
     */
    public double getMon() {
        return mon;
    }

    /**
     * Sets the mon.
     *
     * @param mon
     *            the new mon
     */
    public void setMon(final double mon) {
        this.mon = mon;
    }

    /**
     * Gets the tue.
     *
     * @return the tue
     */
    public double getTue() {
        return tue;
    }

    /**
     * Sets the tue.
     *
     * @param tue
     *            the new tue
     */
    public void setTue(final double tue) {
        this.tue = tue;
    }

    /**
     * Gets the wed.
     *
     * @return the wed
     */
    public double getWed() {
        return wed;
    }

    /**
     * Sets the wed.
     *
     * @param wed
     *            the new wed
     */
    public void setWed(final double wed) {
        this.wed = wed;
    }

    /**
     * Gets the thu.
     *
     * @return the thu
     */
    public double getThu() {
        return thu;
    }

    /**
     * Sets the thu.
     *
     * @param thu
     *            the new thu
     */
    public void setThu(final double thu) {
        this.thu = thu;
    }

    /**
     * Gets the fri.
     *
     * @return the fri
     */
    public double getFri() {
        return fri;
    }

    /**
     * Sets the fri.
     *
     * @param fri
     *            the new fri
     */
    public void setFri(final double fri) {
        this.fri = fri;
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
