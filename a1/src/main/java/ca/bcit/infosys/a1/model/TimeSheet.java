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
    private Double fri;
    private Double mon;
    private String notes;
    private int projectNumber;
    private Double sat;
    private Double sun;
    private Double thu;
    private Double tue;
    private Double wed;
    private int week;
    private String workPackage;
    private int year;

    public TimeSheet() {
    }

    public TimeSheet(final int employeeID, final int week, final int year) {
        super();
        this.employeeID = employeeID;
        this.week = week;
        this.year = year;
    }

    @Id
    @Column(name = "timeSheetID", nullable = false)
    public int getTimeSheetID() {
        return timeSheetID;
    }

    public void setTimeSheetID(int timeSheetID) {
        this.timeSheetID = timeSheetID;
    }

    @Basic
    @Column(name = "employeeID", nullable = false)
    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Basic
    @Column(name = "fri")
    public Double getFri() {
        return fri;
    }

    public void setFri(Double fri) {
        this.fri = fri;
    }

    @Basic
    @Column(name = "mon")
    public Double getMon() {
        return mon;
    }

    public void setMon(Double mon) {
        this.mon = mon;
    }

    @Basic
    @Column(name = "notes", length = 200)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "projectNumber", nullable = false)
    public int getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(int projectNumber) {
        this.projectNumber = projectNumber;
    }

    @Basic
    @Column(name = "sat")
    public Double getSat() {
        return sat;
    }

    public void setSat(Double sat) {
        this.sat = sat;
    }

    @Basic
    @Column(name = "sun")
    public Double getSun() {
        return sun;
    }

    public void setSun(Double sun) {
        this.sun = sun;
    }

    @Basic
    @Column(name = "thu")
    public Double getThu() {
        return thu;
    }

    public void setThu(Double thu) {
        this.thu = thu;
    }

    @Basic
    @Column(name = "tue")
    public Double getTue() {
        return tue;
    }

    public void setTue(Double tue) {
        this.tue = tue;
    }

    @Basic
    @Column(name = "wed")
    public Double getWed() {
        return wed;
    }

    public void setWed(Double wed) {
        this.wed = wed;
    }

    @Basic
    @Column(name = "week", nullable = false)
    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Basic
    @Column(name = "workPackage", nullable = false)
    public String getWorkPackage() {
        return workPackage;
    }

    public void setWorkPackage(String workPackage) {
        this.workPackage = workPackage;
    }

    @Basic
    @Column(name = "year", nullable = false)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeSheet that = (TimeSheet) o;

        if (employeeID != that.employeeID) return false;
        if (projectNumber != that.projectNumber) return false;
        if (timeSheetID != that.timeSheetID) return false;
        if (week != that.week) return false;
        if (year != that.year) return false;
        if (fri != null ? !fri.equals(that.fri) : that.fri != null) return false;
        if (mon != null ? !mon.equals(that.mon) : that.mon != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (sat != null ? !sat.equals(that.sat) : that.sat != null) return false;
        if (sun != null ? !sun.equals(that.sun) : that.sun != null) return false;
        if (thu != null ? !thu.equals(that.thu) : that.thu != null) return false;
        if (tue != null ? !tue.equals(that.tue) : that.tue != null) return false;
        if (wed != null ? !wed.equals(that.wed) : that.wed != null) return false;
        if (workPackage != null ? !workPackage.equals(that.workPackage) : that.workPackage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = timeSheetID;
        result = 31 * result + employeeID;
        result = 31 * result + (fri != null ? fri.hashCode() : 0);
        result = 31 * result + (mon != null ? mon.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + projectNumber;
        result = 31 * result + (sat != null ? sat.hashCode() : 0);
        result = 31 * result + (sun != null ? sun.hashCode() : 0);
        result = 31 * result + (thu != null ? thu.hashCode() : 0);
        result = 31 * result + (tue != null ? tue.hashCode() : 0);
        result = 31 * result + (wed != null ? wed.hashCode() : 0);
        result = 31 * result + week;
        result = 31 * result + (workPackage != null ? workPackage.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }
}
