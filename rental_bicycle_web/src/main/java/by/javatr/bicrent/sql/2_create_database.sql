CREATE DATABASE `rental_bicycle_web` DEFAULT CHARACTER SET utf8;

GRANT SELECT,INSERT,UPDATE,DELETE
ON `rental_bicycle_web`.*
TO MySQL57
IDENTIFIED BY 'admin';

GRANT SELECT,INSERT,UPDATE,DELETE
ON `rental_bicycle_web`.*
TO MySQL57@'%'
IDENTIFIED BY 'admin';