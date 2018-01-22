package dao;

import models.Team;

import models.Member;
import java.util.List;

public interface MemberDao {

    //create
    void add(Member member);

    //read
    List<Member> getAllMemberByTeam(int teamId);
    Member findById(int id);

    //update
    void update(int id, String name, String email);

    //delete
    void deleteById(int id);
    void deleteAllMemberByTeam(int teamId);
    void clearAllMembers();

}
