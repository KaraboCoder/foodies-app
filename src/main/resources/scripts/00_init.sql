/* Create db & primary user with minimal permissions */
CREATE DATABASE IF NOT EXISTS foodiesdev;
CREATE USER IF NOT EXISTS 'foodies' IDENTIFIED BY 'no-password';
-- TODO: Revise!!
GRANT ALL PRIVILEGES ON foodiesdev.* TO 'foodies';