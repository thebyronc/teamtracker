package models;

import java.util.ArrayList;
import java.util.Objects;

public class Team {
    private String teamName;
    private ArrayList<String> members;
    private String description;
    private boolean published;
    private int id;

    public Team(String teamName, ArrayList<String> members, String description){
        this.teamName = teamName;
        this.members = members;
        this.description = description;
        this.published = false;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public String getTeamName() {
        return teamName;
    }
    public String getMembers() {
        String results = "";
        for(String eachMember:members){
            results += "<li>" + eachMember + "</li>";
        }
        return results;
    }
    public int getMemberCount(){
        return members.size();
    }
    public String getDescription() {
        return description;
    }

    public void update(String teamName) {
        this.teamName = teamName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return published == team.published &&
                id == team.id &&
                Objects.equals(teamName, team.teamName) &&
                Objects.equals(members, team.members) &&
                Objects.equals(description, team.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teamName, members, description, published, id);
    }
}
