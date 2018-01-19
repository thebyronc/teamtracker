package models;

import java.util.ArrayList;
import java.util.Objects;

public class Team {
    private String teamName;
    private String members;
    private String description;
    private int id;

    public Team(String teamName, String members, String description){
        this.teamName = teamName;
        this.members = members;
        this.description = description;
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
        return members;
    }

    public String getDescription() {
        return description;
    }

//    public void update(String teamName) {
//        this.teamName = teamName;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return id == team.id &&
                Objects.equals(teamName, team.teamName) &&
                Objects.equals(members, team.members) &&
                Objects.equals(description, team.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(teamName, members, description, id);
    }
}
