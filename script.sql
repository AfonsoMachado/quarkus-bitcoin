-- CREATE DATABASE quarkus_crud;
-- SHOW DATABASES;
-- USE quarkus_crud;

CREATE TABLE IF NOT EXISTS `user` (
	`id` int NOT NULL AUTO_INCREMENT,
	`createdAt` TIMESTAMP,
	`updatedAt` TIMESTAMP,
	`name` VARCHAR(50) NOT NULL,
	`document` VARCHAR(14) NOT NULL,
	`username` VARCHAR(50) NOT NULL,
	`password` VARCHAR(100) NOT NULL,
	`role` VARCHAR(55) NOT NULL,
	PRIMARY KEY(`id`)) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS `purchase` (
	`id` int NOT NULL AUTO_INCREMENT,
	`createdAt` TIMESTAMP,
	`updatedAt` TIMESTAMP,
	`price` decimal(6,2) NOT NULL,
	`order_type` VARCHAR(20) NOT NULL,
	`status` VARCHAR(30) NOT NULL,
	`user_id` int NOT NULL,
	PRIMARY KEY (`id`),
	FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)) ENGINE=InnoDB;