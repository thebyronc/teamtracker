package models;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private ArrayList<String> members;
    private String description;
    private boolean published;
    private static ArrayList<Team> instances = new ArrayList<>();
    private int id;

    public Team(String teamName, ArrayList<String> members, String description){
        this.teamName = teamName;
        this.members = members;
        this.description = description;
        this.published = false;
        instances.add(this);
        this.id = instances.size();
    }
    public String getTeamName() {
        return teamName;
    }
    public ArrayList<String> getMembers() {
        return members;
    }
    public String getDescription() {
        return description;
    }
    public int getID() {
        return id;
    }
    public void update(String teamName) {
        this.teamName = teamName;
    }
    public static ArrayList<Team> getAll(){
        return instances;
    }
}
