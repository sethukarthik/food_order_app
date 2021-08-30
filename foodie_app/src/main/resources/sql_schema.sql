create database if not exists spring_demo;

use spring_demo;

DROP TABLE IF EXISTS `spring_demo`.`user`;

CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `full_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `password` varchar(40) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL,
  `account_inactive` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`) /*!80000 INVISIBLE */
);

insert into user(id, full_name, email, mobile, password) values(1, "SethuKarthik", "sethu@gmail.com", "+919566841129", "123456");
insert into user(id, full_name, email, mobile, password) values(2, "ShriNagaKali", "shri@gmail.com", "+918666841129", "123456");
insert into user(id, full_name, email, mobile, password) values(3, "NirmalKumar", "nirmal@gmail.com", "+917866841129", "123456");
insert into user(id, full_name, email, mobile, password) values(4, "Nageswaran", "nagesh@gmail.com", "+916666841129", "123456");

select * from user;
commit;