create schema netflix;



CREATE TABLE IF NOT EXISTS `netflix`.`show` (
  `Id` INT NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `title` VARCHAR(200) NULL,
  `director` VARCHAR(200) NULL,
  `cast` VARCHAR(200) NULL,
  `country` VARCHAR(45) NULL,
  `dateAdded` VARCHAR(45) NULL,
  `releaseYear` VARCHAR(45) NULL,
  `rating` VARCHAR(45) NULL,
  `duration` VARCHAR(45) NULL,
  `listedIn` VARCHAR(45) NULL,
  `description` VARCHAR(200) NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC) VISIBLE)
ENGINE = InnoDB;


select show0_.show_id as show_id1_0_, show0_.cast as cast2_0_, show0_.country as country3_0_, show0_.date_added as date_add4_0_, show0_.description as descript5_0_, show0_.director as director6_0_, show0_.duration as duration7_0_, show0_.listed_in as listed_i8_0_, show0_.rating as rating9_0_, show0_.release_year as release10_0_, show0_.title as title11_0_, show0_.type as type12_0_ from `show` show0_;


alter table `show` add primary key(`show_id`);

ALTER TABLE `show`
modify column `description` varchar(500);

select * from `show` WHERE show_id='s3';

DESC `netflix`.`show`;
select * from `netflix`.`show`;
drop table `netflix`.`show`;
select * from `show` show0_ where show0_.type='TV Show' limit 3;

