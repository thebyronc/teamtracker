SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS teams (
  id int PRIMARY KEY auto_increment,
  teamname VARCHAR,
  description VARCHAR
);

CREATE TABLE IF NOT EXISTS members (
  id int PRIMARY KEY auto_increment,
  memberName VARCHAR,
  email VARCHAR,
  teamId int
);


