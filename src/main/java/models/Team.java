package models;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private String[] members;
    private String description;
    private static ArrayList<Team> instances = new ArrayList<>();
    private int id;

    public Team(String teamName, String[] members, String description){
        this.teamName = teamName;
        this.members = members;
        this.description = description;
        this.id = instances.size();
    }
    public String getTeamName() {
        return teamName;
    }
    public String[] getMembers() {
        return null;
    }
}
