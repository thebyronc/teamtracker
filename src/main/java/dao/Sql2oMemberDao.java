package dao;

import org.sql2o.Sql2o;

import java.lang.reflect.Member;

public class Sql2oMemberDao implements MemberDao {
    private final Sql2o sql2o;

    public Sql2oMemberDao(Sql2o sql2o){
        this.sql2o = sql2o;
    }

    @Override
    public void add(Member member) {

    }



}
