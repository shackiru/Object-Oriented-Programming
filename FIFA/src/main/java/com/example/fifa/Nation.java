package com.example.fifa;

public class Nation
{
    private String nationTeam;
    private String coach;
    private String continent;
    public Nation()
    {

    }
    public Nation(String nationTeam, String coach, String continent)
    {
        this.nationTeam = nationTeam;
        this.coach = coach;
        this.continent = continent;
    }
    public String getNationTeam()
    {
        return nationTeam;
    }
    public void setNationTeam(String nationTeam)
    {
        this.nationTeam = nationTeam;
    }
    public String getCoach()
    {
        return coach;
    }
    public void setCoach(String coach)
    {
        this.coach = coach;
    }
    public String getContinent()
    {
        return continent;
    }
    public void setContinent(String continent)
    {
        this.continent = continent;
    }
}
