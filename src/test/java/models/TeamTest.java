package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void NewTeamObjectIsCreatedCorrectly_true() throws Exception {
        String[] members = {"Member 1", "Member 2"};
        Team team = new Team("TestName", members, "Test Description");
        assertEquals(true, team instanceof Team);
    }

    @Test
    public void TeamInitiatesWithName_true() {
        String[] members = {"Member 1", "Member 2"};
        Team team = new Team("TestName", members, "Test Description");
        assertEquals("TestName", team.getTeamName());
    }

    @Test
    public void TeamInitiatesWithMembers_true() {
        String[] members = {"Member 1", "Member 2"};
        Team team = new Team("TestName", members, "Test Description");
        assertArrayEquals(members, team.getMembers());
    }

}