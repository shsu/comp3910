package ca.bcit.infosys.a1.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * TimeSheet Model.
 *
 * @author shsu
 * @version 0.2
 */
@Entity
@Table(name = "TimeSheets")
public class TimeSheet implements Serializable {

    /** The Constant MAXIMUM_NOTE_LENGTH. */
    private static final int MAXIMUM_NOTE_LENGTH = 200;

    /** The time sheet id. */
    private int timeSheetID;

    /** The employee id. */
    private int employeeID;

    /** The week. */
    private int week;

    /** The year. */
    private int year;

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

    /**
     * Instantiates a new time sheet.
     */
    public TimeSheet() {
    }

    /**
     * Instantiates a new time sheet.
     * 
     * @param employeeID
     *            the employee id
     * @param week
     *            the week
     * @param year
     *            the year
     * @param workPackage
     *            the work package
     */
    public TimeSheet(int employeeID, int week, int year, String workPackage) {
        this.employeeID = employeeID;
        this.week = week;
        this.year = year;
        this.workPackage = workPackage;
    }

    /**
     * Gets the time sheet id.
     * 
     * @return the time sheet id
     */
    @Id
    @GeneratedValue
    @Column(name = "timeSheetID", nullable = false)
    public int getTimeSheetID() {
        return timeSheetID;
    }

    /**
     * Sets the time sheet id.
     * 
     * @param timeSheetID
     *            the new time sheet id
     */
    public void setTimeSheetID(int timeSheetID) {
        this.timeSheetID = timeSheetID;
    }

    /**
     * Gets the employee id.
     * 
     * @return the employee id
     */
    @Basic
    @Column(name = "employeeID", nullable = false)
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Sets the employee id.
     * 
     * @param employeeID
     *            the new employee id
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Gets the week.
     * 
     * @return the week
     */
    @Basic
    @Column(name = "week", nullable = false, length = 2)
    public int getWeek() {
        return week;
    }

    /**
     * Sets the week.
     * 
     * @param week
     *            the new week
     */
    public void setWeek(int week) {
        this.week = week;
    }

    /**
     * Gets the year.
     * 
     * @return the year
     */
    @Basic
    @Column(name = "year", nullable = false, length = 4)
    public int getYear() {
        return year;
    }

    /**
     * Sets the year.
     * 
     * @param year
     *            the new year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the project number.
     * 
     * @return the project number
     */
    @Basic
    @Column(name = "projectNumber", nullable = false)
    public int getProjectNumber() {
        return projectNumber;
    }

    /**
     * Sets the project number.
     * 
     * @param projectNumber
     *            the new project number
     */
    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    /**
     * Gets the work package.
     * 
     * @return the work package
     */
    @Basic
    @Column(name = "workPackage", nullable = false, length = 5)
    public String getWorkPackage() {
        return workPackage;
    }

    /**
     * Sets the work package.
     * 
     * @param workPackage
     *            the new work package
     */
    public void setWorkPackage(String workPackage) {
        this.workPackage = workPackage;
    }

    /**
     * Gets the sat.
     * 
     * @return the sat
     */
    @Basic
    @Column(name = "sat", nullable = false, length = 2)
    public double getSat() {
        return sat;
    }

    /**
     * Sets the sat.
     * 
     * @param sat
     *            the new sat
     */
    public void setSat(double sat) {
        this.sat = sat;
    }

    /**
     * Gets the sun.
     * 
     * @return the sun
     */
    @Basic
    @Column(name = "sun", nullable = false, length = 2)
    public double getSun() {
        return sun;
    }

    /**
     * Sets the sun.
     * 
     * @param sun
     *            the new sun
     */
    public void setSun(double sun) {
        this.sun = sun;
    }

    /**
     * Gets the mon.
     * 
     * @return the mon
     */
    @Basic
    @Column(name = "mon", nullable = false, length = 2)
    public double getMon() {
        return mon;
    }

    /**
     * Sets the mon.
     * 
     * @param mon
     *            the new mon
     */
    public void setMon(double mon) {
        this.mon = mon;
    }

    /**
     * Gets the tue.
     * 
     * @return the tue
     */
    @Basic
    @Column(name = "tue", nullable = false, length = 2)
    public double getTue() {
        return tue;
    }

    /**
     * Sets the tue.
     * 
     * @param tue
     *            the new tue
     */
    public void setTue(double tue) {
        this.tue = tue;
    }

    /**
     * Gets the wed.
     * 
     * @return the wed
     */
    @Basic
    @Column(name = "wed", nullable = false, length = 2)
    public double getWed() {
        return wed;
    }

    /**
     * Sets the wed.
     * 
     * @param wed
     *            the new wed
     */
    public void setWed(double wed) {
        this.wed = wed;
    }

    /**
     * Gets the thu.
     * 
     * @return the thu
     */
    @Basic
    @Column(name = "thu", nullable = false, length = 2)
    public double getThu() {
        return thu;
    }

    /**
     * Sets the thu.
     * 
     * @param thu
     *            the new thu
     */
    public void setThu(double thu) {
        this.thu = thu;
    }

    /**
     * Gets the fri.
     * 
     * @return the fri
     */
    @Basic
    @Column(name = "fri", nullable = false, length = 2)
    public double getFri() {
        return fri;
    }

    /**
     * Sets the fri.
     * 
     * @param fri
     *            the new fri
     */
    public void setFri(double fri) {
        this.fri = fri;
    }

    /**
     * Gets the notes.
     * 
     * @return the notes
     */
    @Basic
    @Column(name = "notes", nullable = true, length = MAXIMUM_NOTE_LENGTH)
    public String getNotes() {
        return notes;
    }

    /**
     * Sets the notes.
     * 
     * @param notes
     *            the new notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
