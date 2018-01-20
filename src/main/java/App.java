import dao.Sql2oMemberDao;
import models.Member;
import models.Team;
import dao.Sql2oTeamDao;
import dao.TeamDao;

import java.util.*;

import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static java.lang.Integer.parseInt;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        staticFileLocation("/public");

        String connectionString = "jdbc:h2:~/teamTracker.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        Sql2oTeamDao teamDao = new Sql2oTeamDao(sql2o);
        Sql2oMemberDao memberDao = new Sql2oMemberDao(sql2o);

        get("/about", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "about.hbs");
        }, new HandlebarsTemplateEngine());

        // DELETE
        get("/teams/delete", (req, res) -> { //delete all teams
            Map<String, Object> model = new HashMap<>();
            teamDao.clearAllTeams();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        // CREATE

        get("/teams/new", (req, res) -> { //show create new team form
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "team-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/new", (request, response) -> { //process new team form
            Map<String, Object> model = new HashMap<>();
            String teamName = request.queryParams("teamName");
            String description = request.queryParams("description");
            Team newTeam = new Team(teamName, description);
            teamDao.add(newTeam);
            model.put("teams", newTeam);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/members/new", (req, res) -> { //show a form to create a member
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "member-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/members/new", (request, response) -> { //process new member form
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String email = request.queryParams("email");
            String teamId = request.queryParams("teamId");
            Member newMember = new Member(parseInt(teamId), name, email);
            memberDao.add(newMember);
            model.put("members", newMember);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        // READ

        get("/", (req, res) -> { //show all teams
            Map<String, Object> model = new HashMap<>();
            List<Team> teams = teamDao.getAll();
            model.put("teams", teams);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id", (req, res) -> { //show an individual team
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToFind = parseInt(req.params("id"));
            Team foundTeam = teamDao.findById(idOfTeamToFind);
            model.put("team", foundTeam);
            return new ModelAndView(model, "team-detail.hbs");
        }, new HandlebarsTemplateEngine());

        // UPDATE

        get("/teams/:id/update", (req, res) -> { //show a form to update team name
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToEdit = parseInt(req.params("id"));
            Team editTeam = teamDao.findById(idOfTeamToEdit);
            model.put("editTeam", editTeam);
            return new ModelAndView(model, "team-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id/update", (req, res) -> { //process a form to update team name
            Map<String, Object> model = new HashMap<>();
            String newTeamName = req.queryParams("teamName");
            String newDescription = req.queryParams("description");
            int idOfTeamToEdit = parseInt(req.params("id"));
            Team editTeam = teamDao.findById(idOfTeamToEdit);
            teamDao.update(idOfTeamToEdit, newTeamName, newDescription);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());




    }
}
