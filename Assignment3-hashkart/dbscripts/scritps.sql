-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hashkart
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hashkart
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hashkart` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hashkart` ;

-- -----------------------------------------------------
-- Table `hashkart`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hashkart`.`user` (
  `id` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `contact` BIGINT NOT NULL,
  `security_question` VARCHAR(255) NOT NULL,
  `answer` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hashkart`.`bill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hashkart`.`bill` (
  `b_id` INT NOT NULL AUTO_INCREMENT,
  `purchase_date` DATE NOT NULL,
  `total_amount` INT NOT NULL,
  `discount_percent` INT NOT NULL,
  `payment_status` VARCHAR(45) NOT NULL,
  `User_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`b_id`),
  UNIQUE INDEX `b_id_UNIQUE` (`b_id` ASC) VISIBLE,
  INDEX `fk_Bill_User1_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_Bill_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `hashkart`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hashkart`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hashkart`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Category` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hashkart`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hashkart`.`product` (
  `pt_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `pt_type` VARCHAR(255) NULL DEFAULT NULL,
  `price_per_quantity` INT NOT NULL,
  `quantity_available` INT NOT NULL,
  `rating` INT NOT NULL,
  `brand` VARCHAR(45) NULL DEFAULT NULL,
  `Category_id` INT NOT NULL,
  PRIMARY KEY (`pt_id`),
  UNIQUE INDEX `id_UNIQUE` (`pt_id` ASC) VISIBLE,
  INDEX `fk_Product_Category_idx` (`Category_id` ASC) VISIBLE,
  CONSTRAINT `fk_Product_Category`
    FOREIGN KEY (`Category_id`)
    REFERENCES `hashkart`.`category` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hashkart`.`bill_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hashkart`.`bill_details` (
  `b_d_id` INT NOT NULL AUTO_INCREMENT,
  `Bill_b_id` INT NOT NULL,
  `Product_pt_id` INT NOT NULL,
  `purchased_quantity` INT NOT NULL,
  PRIMARY KEY (`b_d_id`),
  UNIQUE INDEX `b_d_id_UNIQUE` (`b_d_id` ASC) VISIBLE,
  INDEX `fk_Bill_Details_Product1_idx` (`Product_pt_id` ASC) VISIBLE,
  INDEX `fk_Bill_Details_Bill1_idx` (`Bill_b_id` ASC) VISIBLE,
  CONSTRAINT `fk_Bill_Details_Bill1`
    FOREIGN KEY (`Bill_b_id`)
    REFERENCES `hashkart`.`bill` (`b_id`),
  CONSTRAINT `fk_Bill_Details_Product1`
    FOREIGN KEY (`Product_pt_id`)
    REFERENCES `hashkart`.`product` (`pt_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hashkart`.`cart`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hashkart`.`cart` (
  `cart_id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NOT NULL,
  `Product_id` INT NOT NULL,
  `User_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cart_id`),
  UNIQUE INDEX `id_UNIQUE` (`cart_id` ASC) VISIBLE,
  INDEX `fk_Cart_Product1_idx` (`Product_id` ASC) VISIBLE,
  INDEX `fk_Cart_User1_idx` (`User_id` ASC) VISIBLE,
  CONSTRAINT `fk_Cart_Product1`
    FOREIGN KEY (`Product_id`)
    REFERENCES `hashkart`.`product` (`pt_id`),
  CONSTRAINT `fk_Cart_User1`
    FOREIGN KEY (`User_id`)
    REFERENCES `hashkart`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
