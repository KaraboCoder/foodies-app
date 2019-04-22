/* Create db & primary user with minimal permissions */
CREATE DATABASE IF NOT EXISTS foodiesdev;
CREATE USER IF NOT EXISTS 'foodies' IDENTIFIED BY 'no-password';
-- TODO: Revise!!
GRANT ALL PRIVILEGES ON foodiesdev.* TO 'foodies';

/* Create user profile schema */
CREATE TABLE IF NOT EXISTS userprofiles(
    ID BIGINT(20) NOT NULL AUTO_INCREMENT ,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    PRIMARY KEY (ID)
);

/* Create recipe schema */
CREATE TABLE IF NOT EXISTS recipe(
    ID BIGINT(20) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Title VARCHAR(255) NOT NULL
);