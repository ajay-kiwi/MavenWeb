--
-- USER INFORMATION
--

CREATE TABLE users (
  id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  -- login information
  username VARCHAR(255) NOT NULL,
  displayname VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL, 
  -- password is SHA256-hashed
  password CHAR(64) NOT NULL,
  -- time information
  joinedAt BIGINT NOT NULL,
  -- profile information
  bio varchar(255),
  -- KiwiTech: 1 for email confirmed, 0 for not confirm
  emailConfirm TINYINT(1) NOT NULL DEFAULT 0, 
  regToken varchar(255) NOT NULL,
  forgotToken varchar(255) NULL,
  about varchar(500) NULL,
  loginstatus int(1) NOT NULL DEFAULT 0,
  currentlogin varchar(10) NULL, 
);
CREATE UNIQUE INDEX users_username ON users (username);
CREATE UNIQUE INDEX users_email ON users (email);

--
-- FILE IMPORT DATA
--

CREATE TABLE file_imports (
  id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  userId BIGINT NOT NULL,
  importedAt BIGINT NOT NULL,
  filename VARCHAR(2048) NOT NULL,
  name VARCHAR(255),
  prettyName VARCHAR(255),
  description TEXT,
  FOREIGN KEY (userId) REFERENCES users (id)
);
CREATE INDEX file_imports_userId_name ON file_imports (userId, name);
CREATE INDEX file_imports_userId_importedAt ON file_imports (userId, importedAt);

CREATE TABLE file_import_data (
  id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
  fileImportId BIGINT NOT NULL,
  t BIGINT NOT NULL,
  timezoneId SMALLINT NOT NULL,
  timeSource TINYINT NOT NULL,
  location POINT,
  body BLOB,
  FOREIGN KEY (fileImportId) REFERENCES file_imports (id)
);
CREATE INDEX file_import_data_fileImportId_t ON file_import_data (fileImportId, t);


CREATE TABLE persistent_logins (
	username VARCHAR(64) NULL DEFAULT NULL,
	series VARCHAR(64) NOT NULL DEFAULT '',
	token VARCHAR(64) NULL DEFAULT NULL,
	last_used TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (series)
);

CREATE TABLE user_social (
  id int(11) NOT NULL AUTO_INCREMENT,
  userId int(11) NOT NULL,
  socialUserId int(11) NOT NULL,
  name varchar(255) NOT NULL,
  url varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  socialstatus int(1) NOT NULL DEFAULT 0,
  loginstatus int(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

CREATE TABLE interests (
	interest_id int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	interest_name VARCHAR(25) NOT NULL
);

CREATE TABLE user_interests (
	u_id int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,
	user_id int(11) NOT NULL,
	interest_id int(11) NOT NULL,
	FOREIGN KEY (interest_id) REFERENCES  interests(interest_id)
);

INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (1, 'Happiness');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (2, 'Energy');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (3, 'productivity');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (4, 'mood');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (5, 'mindfullness');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (6, 'glutenfree');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (7, 'weightloss');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (8, 'sleep');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (9, 'sugar');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (10, 'strength');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (11, 'location');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (12, 'work');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (13, 'goals');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (14, 'food');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (15, 'ibs');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (16, 'running');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (17, 'socialmedia');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (18, 'memory');
INSERT INTO `interests` (`interest_id`, `interest_name`) VALUES (19, 'health');



