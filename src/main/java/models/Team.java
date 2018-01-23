package models;

import java.util.ArrayList;
import java.util.Objects;

public class Team {
    private String teamName;

    private String description;
    private int id;

    public Team(String teamName, String description){
        this.teamName = teamName;
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

    public String getDescription() {
        return description;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team)) return false;
        Team team = (Team) o;
        return getId() == team.getId() &&
                Objects.equals(getTeamName(), team.getTeamName()) &&
                Objects.equals(getDescription(), team.getDescription());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getTeamName(), getDescription(), getId());
    }
}
