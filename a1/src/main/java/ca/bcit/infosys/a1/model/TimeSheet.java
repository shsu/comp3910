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

    private int timeSheetID;
    private int employeeID;
    private int week;
    private int year;
    private int projectNumber;
    private String workPackage;
    private double sat;
    private double sun;
    private double mon;
    private double tue;
    private double wed;
    private double thu;
    private double fri;
    private String notes;

    public TimeSheet() {
    }

    public TimeSheet(final int employeeID, final int week, final int year) {
        super();
        this.employeeID = employeeID;
        this.week = week;
        this.year = year;
    }

    public TimeSheet(int employeeID, int week, int year, int projectNumber, String workPackage, double hours) {
        this.employeeID = employeeID;
        this.week = week;
        this.year = year;
        this.projectNumber = projectNumber;
        this.workPackage = workPackage;
        this.mon = hours;
        this.tue = hours;
        this.wed = hours;
        this.thu = hours;
        this.fri = hours;
    }

    @Id
    @GeneratedValue
    @Column(name = "timeSheetID", nullable = false, length = 10)
    public int getTimeSheetID() {
        return timeSheetID;
    }

    public void setTimeSheetID(int timeSheetID) {
        this.timeSheetID = timeSheetID;
    }

    @Basic
    @Column(name = "employeeID", nullable = false, length = 10)
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Basic
    @Column(name = "week", nullable = false, length = 2)
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Basic
    @Column(name = "year", nullable = false, length = 4)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Basic
    @Column(name = "projectNumber", nullable = false, length = 10)
    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    //TODO: Verify work package requirements.
    @Basic
    @Column(name = "workPackage", nullable = false, length = 5)
    public String getWorkPackage() {
        return workPackage;
    }

    public void setWorkPackage(String workPackage) {
        this.workPackage = workPackage;
    }

    @Basic
    @Column(name = "sat", nullable = true, length = 2)
    public double getSat() {
        return sat;
    }

    public void setSat(double sat) {
        this.sat = sat;
    }

    @Basic
    @Column(name = "sun", nullable = true, length = 2)
    public double getSun() {
        return sun;
    }

    public void setSun(double sun) {
        this.sun = sun;
    }

    @Basic
    @Column(name = "mon", nullable = true, length = 2)
    public double getMon() {
        return mon;
    }

    public void setMon(double mon) {
        this.mon = mon;
    }

    @Basic
    @Column(name = "tue", nullable = true, length = 2)
    public double getTue() {
        return tue;
    }

    public void setTue(double tue) {
        this.tue = tue;
    }

    @Basic
    @Column(name = "wed", nullable = true, length = 2)
    public double getWed() {
        return wed;
    }

    public void setWed(double wed) {
        this.wed = wed;
    }

    @Basic
    @Column(name = "thu", nullable = true, length = 2)
    public double getThu() {
        return thu;
    }

    public void setThu(double thu) {
        this.thu = thu;
    }

    @Basic
    @Column(name = "fri", nullable = true, length = 2)
    public double getFri() {
        return fri;
    }

    public void setFri(double fri) {
        this.fri = fri;
    }

    @Basic
    @Column(name = "notes", nullable = true, length = 200)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
