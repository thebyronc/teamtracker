package dao;
import models.Member;
import models.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;
import static org.junit.Assert.*;
import org.sql2o.Connection;

public class Sql2oMemberDaoTest {
    private Sql2oMemberDao memberDao;
    private Sql2oTeamDao teamDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        memberDao = new Sql2oMemberDao(sql2o);
        teamDao = new Sql2oTeamDao(sql2o);

        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingMemberSetsIdToTeam() throws Exception {
        Team team = setupNewTeam();
        Member member = new Member(team.getId(),"Byron", "thebyronc@gmail.com");
        assertEquals(team.getId(), member.getTeamId());
    }
    @Test
    public void membersCanBeFoundById() {
        Team team = setupNewTeam();
        Member member = new Member(team.getId(), "Byron", "thebyronc@gmail.com");
        int originalMemberId = member.getId();
        memberDao.add(member);
        assertNotEquals(originalMemberId, member.getId());
    }

    public Team setupNewTeam() {
        return new Team("Team 1", "One guy", "Team Description Example 1");
    }
}