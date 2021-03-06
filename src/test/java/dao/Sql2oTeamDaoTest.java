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
    public void existingTeamCanBeFoundById() throws Exception {
        Team team = setupNewTeam();
        teamDao.add(team);
        Team foundTeam = teamDao.findById(team.getId());
        assertEquals(team.getTeamName(), foundTeam.getTeamName());
    }

    @Test
    public void updateChangesTeamName() throws Exception {
        String initialTeamName = "Team 1";
        Team team = new Team(initialTeamName,"Team Description Example 1");
        teamDao.add(team);
        teamDao.update(team.getId(), "Mocha", "Team Description Example 1");
        Team updatedAnimal = teamDao.findById(team.getId());
        assertNotEquals(initialTeamName, updatedAnimal.getTeamName());
    }

    @Test
    public void deleteTeamById () throws Exception {
        Team team = setupNewTeam();
        teamDao.add(team);
        teamDao.deleteById(team.getId());
        assertEquals(0, teamDao.getAll().size());
    }

    @Test
    public void clearAllTeams() throws Exception {
        Team team = setupNewTeam();
        teamDao.add(team);
        teamDao.clearAllTeams();
        assertEquals(0, teamDao.getAll().size());
    }

    public Team setupNewTeam() {
        return new Team("Team 1",  "Team Description Example 1");
    }


}


