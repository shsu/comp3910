CREATE DATABASE IF NOT EXISTS a3server;
CREATE USER 'a3server'@'localhost' IDENTIFIED BY 'a3server';
GRANT ALL ON a3server.* TO 'a3server'@'localhost';