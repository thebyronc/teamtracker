package dao;

import org.junit.After;
import org.junit.Before;
import org.sql2o.Sql2o;

import java.sql.Connection;

import static org.junit.Assert.*;

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

        //keep connection open through entire test so it does not get erased
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
    }
}