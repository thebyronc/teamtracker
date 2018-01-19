package dao;
import models.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class Sql2oTeamDaoTest {

    private Sql2oTeamDao teamDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        teamDao = new Sql2oTeamDao(sql2o);

        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingTeamSetsId() throws Exception {
        Team team = setupNewTeam();
        int originalTeamId = team.getId();
        teamDao.add(team);
        assertNotEquals(originalTeamId, team.getId());
    }

    @Test
    public void updateChangesTeamName() throws Exception {
        String initialTeamName = "Team 1";
        ArrayList<String> members = new ArrayList<>(Arrays.asList("Member 1","Member 2"));
        Team team = new Team(initialTeamName, members, "Team Description Example 1");
        teamDao.add(team);

        teamDao.update(team.getId(), "Mocha", members, "Team Description Example 1");
        Team updatedAnimal = teamDao.findById(team.getId());
        assertNotEquals(initialTeamName, updatedAnimal.getTeamName());
    }


    public Team setupNewTeam() {
        ArrayList<String> members = new ArrayList<>(Arrays.asList("Member 1","Member 2"));
        return new Team("Team 1", members, "Team Description Example 1");
    }


}


