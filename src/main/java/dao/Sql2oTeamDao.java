package dao;

import models.Team;
import org.sql2o.Sql2o;
import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.ArrayList;
import java.util.List;

public class Sql2oTeamDao implements TeamDao {
    private final Sql2o sql2o;

    public Sql2oTeamDao(Sql2o sql2o){
        this.sql2o = sql2o; //making the sql2o object available everywhere so we can call methods in it
    }

    @Override
    public void add(Team team) {
        String sql = "INSERT INTO teams (teamName, members, description) VALUES (:teamName, :members, :description)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql)
                    .bind(team)
//                    .addParameter("teamName", team.getTeamName())
//                    .addParameter("members", team.getMembers())
//                    .addParameter("description", team.getDescription())
//                    .addColumnMapping("TEAMNAME", "teamName")
//                    .addColumnMapping("MEMBERS", "members")
//                    .addColumnMapping("DESCRIPTION", "description")
                    .executeUpdate()
                    .getKey();
            team.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public List<Team> getAll(){
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM teams") //raw sql
                    .executeAndFetch(Team.class); //fetch a list
        }
    }
    @Override
    public Team findById(int id){
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM teams WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Team.class);
        }
    }

    @Override
    public void update(int id, String teamName, ArrayList<String> members, String description) {
        String sql = "UPDATE teams Set (teamName, members, description) = (:teamName, :members, :description) WHERE id=:id";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("teamName", teamName)
                    .addParameter("members", members)
                    .addParameter("description", description)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "Delete from teams WHERE id=:id";
        try(Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void clearAllTeams() {
        String sql = "DELETE from teams";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

}
