package models;

import java.util.Objects;

public class Members {
    private String name;
    private String email;
    private int teamId;

    public Members(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Members)) return false;
        Members members = (Members) o;
        return teamId == members.teamId &&
                Objects.equals(getName(), members.getName()) &&
                Objects.equals(getEmail(), members.getEmail());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getEmail(), teamId);
    }
}
