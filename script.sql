-- CREATE DATABASE bitcoin;
-- SHOW DATABASES;
-- USE bitcoin;

CREATE TABLE IF NOT EXISTS `user` (
	`id` int NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`document` VARCHAR(14) NOT NULL,
	`username` VARCHAR(50) NOT NULL,
	`password` VARCHAR(100) NOT NULL,
	PRIMARY KEY(`id`)) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `order` (
	`id` int NOT NULL AUTO_INCREMENT,
	`price` decimal(6,2) NOT NULL,
	`type` VARCHAR(20) NOT NULL,
	`date` datetime NOT NULL,
	`status` VARCHAR(30) NOT NULL,
	`user_id` int NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)) ENGINE=InnoDB;