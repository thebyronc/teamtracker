package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TeamTest {
    public Team setupNewTeam() {
        ArrayList<String> members = new ArrayList<>();
        members.add("Member 1");
        members.add("Member 2");
        Team team = new Team("TestName", members, "Test Description");
        return team;
    }
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Team.clearAllTeams();
    }

    @Test
    public void NewTeamObjectIsCreatedCorrectly_true() throws Exception {
        ArrayList<String> members = new ArrayList<>();
        members.add("Member 1");
        members.add("Member 2");
        Team team = new Team("TestName", members, "Test Description");
        assertEquals(true, team instanceof Team);
    }

    @Test
    public void TeamInitiatesWithName_true() {
        ArrayList<String> members = new ArrayList<>();
        members.add("Member 1");
        members.add("Member 2");
        Team team = new Team("TestName", members, "Test Description");
        assertEquals("TestName", team.getTeamName());
    }

    @Test
    public void TeamInitiatesWithMembers_true() {
        ArrayList<String> members = new ArrayList<>();
        members.add("Member 1");
        members.add("Member 2");
        Team team = new Team("TestName", members, "Test Description");
        assertEquals(members, team.getMembers());
    }

    @Test
    public void TeamInitiatesWithDescription_true() {
        ArrayList<String> members = new ArrayList<>();
        members.add("Member 1");
        members.add("Member 2");
        Team team = new Team("TestName", members, "Test Description");
        assertEquals("Test Description", team.getDescription());
    }

    @Test
    public void updateChangesPostContent() throws Exception {
        Team team = setupNewTeam();
        String oldTeam = team.getTeamName();
        int formerId = team.getId();
        team.update("New Name");
        assertEquals(formerId, team.getId());
        assertNotEquals(oldTeam, team.getTeamName());
    }

}