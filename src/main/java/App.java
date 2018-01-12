import models.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //get: show create new team form
        get("/teams/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "team-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new team form
        post("/teams/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<>();
            ArrayList<String> members = new ArrayList<>();

            String teamName = request.queryParams("teamName");
            String member = request.queryParams("members");
            members.add(member);
            String description = request.queryParams("description");
            Team newTeam = new Team(teamName, members, description);

            model.put("teams", newTeam);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show all teams
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Team> teams = Team.getAll();
            model.put("teams", teams);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
