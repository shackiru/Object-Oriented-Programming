package com.example.school;

public class Score
{
    protected Student student;
    protected String course;
    protected double score;


    public Score()
    {

    }

    public Score(Student student, String course, double score)
    {
        this.student = student;
        this.course = course;
        this.score = score;
    }

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public String getCourse()
    {
        return course;
    }

    public void setCourse(String course)
    {
        this.course = course;
    }

    public double getScore()
    {
        return score;
    }

    public void setScore(double score)
    {
        this.score = score;
    }
}
