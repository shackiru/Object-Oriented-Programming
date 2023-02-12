package com.example.schoolsl;

public class Score
{
    protected Student student;
    protected Subject subject;
    protected double score;

    public Student getStudent()
    {
        return student;
    }

    public void setStudent(Student student)
    {
        this.student = student;
    }

    public Subject getSubject()
    {
        return subject;
    }

    public void setSubject(Subject subject)
    {
        this.subject = subject;
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
