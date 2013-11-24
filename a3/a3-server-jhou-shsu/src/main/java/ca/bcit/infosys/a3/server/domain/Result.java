package ca.bcit.infosys.a3.server.domain;

import javax.persistence.*;

//TODO: validation

@Entity
@Table(name = "Results")
public class Result {
    private int id;
    private int userID;
    private int week;
    private int score;
    private int totalPossibleScore;

    public Result() {
    }

    public Result(int userID, int week, int score, int totalPossibleScore) {
        this.userID = userID;
        this.week = week;
        this.score = score;
        this.totalPossibleScore = totalPossibleScore;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userID", nullable = false)
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Basic
    @Column(name = "week", nullable = false, length = 2)
    public int getWeek() {
        return week;
    }

    public void setWeek(byte week) {
        this.week = week;
    }

    @Basic
    @Column(name = "score", nullable = false, length = 4)
    public int getScore() {
        return score;
    }

    public void setScore(byte score) {
        this.score = score;
    }

    @Basic
    @Column(name = "totalPossibleScore", nullable = false, length = 4)
    public int getTotalPossibleScore() {
        return totalPossibleScore;
    }

    public void setTotalPossibleScore(short totalPossibleScore) {
        this.totalPossibleScore = totalPossibleScore;
    }
}
