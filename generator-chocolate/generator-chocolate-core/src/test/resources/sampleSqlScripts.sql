DROP TABLE IF EXISTS user;
CREATE TABLE user (
  id VARCHAR (64) NOT NULL,
  user_name VARCHAR (1024) NOT NULL ,
  age INT,
  sex BIT,
  birthDay DATE,
  PRIMARY KEY(id)
);