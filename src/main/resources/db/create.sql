SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS teams (
  id int PRIMARY KEY auto_increment,
  teamname VARCHAR,
  description VARCHAR,
  members VARCHAR,
);

