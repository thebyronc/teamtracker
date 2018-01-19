package dao;

import models.Team;

import java.util.ArrayList;
import java.util.List;

public interface TeamDao {
    //CREATE
    void add (Team team);

    //READ
    List<Team> getAll();
    Team findById(int id);

    //UPDATE
    void update(int id, String name, String members, String description);

    //DELETE
    void deleteById(int id);
    void clearAllTeams();
}
