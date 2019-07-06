CREATE DATABASE `rental_bicycle_web` DEFAULT CHARACTER SET utf8;

GRANT SELECT,INSERT,UPDATE,DELETE
ON `rental_bicycle_web`.*
TO library_user@localhost
IDENTIFIED BY 'library_password';

GRANT SELECT,INSERT,UPDATE,DELETE
ON `rental_bicycle_web`.*
TO library_user@'%'
IDENTIFIED BY 'library_password';