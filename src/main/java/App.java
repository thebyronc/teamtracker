import models.Team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/about", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "about.hbs");
        }, new HandlebarsTemplateEngine());


        // CREATE

        get("/teams/new", (req, res) -> { //show create new team form
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "team-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/new", (request, response) -> { //process new team form
            Map<String, Object> model = new HashMap<>();
            String teamName = request.queryParams("teamName");
            String member = request.queryParams("members");
            ArrayList<String> members = new ArrayList<>(Arrays.asList(member.split(",")));
            String description = request.queryParams("description");
            Team newTeam = new Team(teamName, members, description);

            model.put("teams", newTeam);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        // READ

//        get("/", (req, res) -> { //show all teams
//            Map<String, Object> model = new HashMap<>();
//            ArrayList<Team> teams = Team.getAll();
//            model.put("teams", teams);
//            return new ModelAndView(model, "index.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        get("/teams/:id", (req, res) -> { //show an individual team
//            Map<String, Object> model = new HashMap<>();
//            int idOfTeamToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
//            Team foundTeam = Team.findById(idOfTeamToFind); //use it to find post
//            model.put("team", foundTeam); //add it to model for template to display
//            return new ModelAndView(model, "team-detail.hbs"); //individual post page.
//        }, new HandlebarsTemplateEngine());
//
//        // UPDATE
//
//        get("/teams/:id/update", (req, res) -> { //show a form to update team name
//            Map<String, Object> model = new HashMap<>();
//            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
//            Team editTeam = Team.findById(idOfTeamToEdit);
//            model.put("editTeam", editTeam);
//            return new ModelAndView(model, "team-form.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("/teams/:id/update", (req, res) -> { //process a form to update team name
//            Map<String, Object> model = new HashMap<>();
//            String newTeamName = req.queryParams("teamName");
//            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
//            Team editPost = Team.findById(idOfTeamToEdit);
//            editPost.update(newTeamName); //don’t forget me
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());

        // DELETE














    }
}
