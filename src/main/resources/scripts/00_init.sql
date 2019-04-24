/* Create db & primary user with minimal permissions */
--NOTE: You need to be logged in as root!!
CREATE DATABASE IF NOT EXISTS foodiesdev;
CREATE USER IF NOT EXISTS 'foodies' IDENTIFIED BY 'no-password';
GRANT ALL PRIVILEGES ON foodiesdev.* TO 'foodies';