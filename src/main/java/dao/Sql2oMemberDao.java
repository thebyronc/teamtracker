package dao;
import models.Member;
import models.Team;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;


public class Sql2oMemberDao implements MemberDao {
    private final Sql2o sql2o;

    public Sql2oMemberDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Member member) {
        String sql = "INSERT INTO members_three (teamId, memberName, email) VALUES (:teamId, :memberName, :email)";
        try(Connection con = sql2o.open()){
            int id = (int) con.createQuery(sql)
                    .bind(member)
                    .executeUpdate()
                    .getKey();
            member.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
    @Override
    public List<Member> getAllMemberByTeam(int teamId) {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM members_three WHERE teamId = :teamId")
                    .addParameter("teamId", teamId)
                    .executeAndFetch(Member.class);
        }
    }
    @Override
    public Member findById(int id) {
        try(Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM members_three WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Member.class);
        }
    }
    @Override
    public void clearAllMembers() {
        String sql = "DELETE from members_three";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
