package ca.bcit.infosys.a3.server.domain;

import javax.persistence.*;

@Entity
@Table(name = "Questions")
public class Question {
    private int id;
    private int week;
    private int questionNumber;
    private String question;
    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private Character answer;

    public Question() {
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
    @Column(name = "week", nullable = false, length = 2)
    public int getWeek() {
        return week;
    }

    public void setWeek(byte week) {
        this.week = week;
    }

    @Basic
    @Column(name = "questionNumber", nullable = false, length = 2)
    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(byte questionNumber) {
        this.questionNumber = questionNumber;
    }

    @Basic
    @Column(name = "question", nullable = false, length = 300)
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Basic
    @Column(name = "choiceA", nullable = false, length = 300)
    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    @Basic
    @Column(name = "choiceB", nullable = false, length = 300)
    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    @Basic
    @Column(name = "choiceC", nullable = true, length = 300)
    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    @Basic
    @Column(name = "choiceD", nullable = true, length = 300)
    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    @Basic
    @Column(name = "correctAnswer", nullable = false, length = 1)
    public Character getAnswer() {
        return answer;
    }

    public void setAnswer(Character answer) {
        this.answer = answer;
    }
}
