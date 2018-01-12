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
        String[] members = {"test", "test"};
        Team team = new Team("test", members, "test");
        assertEquals(true, team instanceof Team);
    }
    @Test
    public void TeamInitiatesWithName_true() {
        String[] members = {"test", "test"};
        Team team = new Team("test", members, "test");
        assertEquals("test", team.getTeamName());
    }

}