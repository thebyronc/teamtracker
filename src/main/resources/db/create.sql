SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS teams_two (
  id int PRIMARY KEY auto_increment,
  teamname VARCHAR,
  description VARCHAR
);

CREATE TABLE IF NOT EXISTS members_three (
  id int PRIMARY KEY auto_increment,
  teamId int,
  name VARCHAR,
  email VARCHAR
);


