-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`PO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PO` (
  `idPO` INT NOT NULL AUTO_INCREMENT,
  `PO_name` VARCHAR(45) NOT NULL,
  `PO_email` VARCHAR(45) NOT NULL,
  `PO_projects` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Employee` (
  `idEmployee` INT NOT NULL AUTO_INCREMENT,
  `Employee_name` VARCHAR(45) NOT NULL,
  `Employee_emaill` VARCHAR(45) NOT NULL,
  `current_project` INT NOT NULL,
  `points_earned` INT NULL,
  PRIMARY KEY (`idEmployee`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Projects` (
  `idProjects` INT NOT NULL AUTO_INCREMENT,
  `Project_name` VARCHAR(45) NOT NULL,
  `Project_descript` MEDIUMTEXT NOT NULL,
  `creation_date` DATE NOT NULL,
  `current_status` VARCHAR(45) NOT NULL,
  `PO_idPO` INT NOT NULL,
  PRIMARY KEY (`idProjects`, `PO_idPO`),
  INDEX `fk_Projects_PO_idx` (`PO_idPO` ASC),
  CONSTRAINT `fk_Projects_PO`
    FOREIGN KEY (`PO_idPO`)
    REFERENCES `mydb`.`PO` (`idPO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Stories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Stories` (
  `idStories` INT primary key NOT NULL AUTO_INCREMENT,
  `Stories_name` VARCHAR(45) NOT NULL,
  `Stories_description` LONGTEXT NOT NULL,
  `creation_date` DATE NOT NULL,
  `points` VARCHAR(45) NULL,
  `due_date` VARCHAR(45) NULL,
  `Employee_idEmployee` INT NOT NULL,
  `Projects_idProjects` INT NOT NULL,
  `Projects_PO_idPO` INT NOT NULL);


-- -----------------------------------------------------
-- Table `mydb`.`WorkLog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`WorkLog` (
  `idWorkLog` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  `creation_date` VARCHAR(45) NULL,
  `Employee_idEmployee` INT NOT NULL,
  PRIMARY KEY (`idWorkLog`, `Employee_idEmployee`),
  INDEX `fk_WorkLog_Employee1_idx` (`Employee_idEmployee` ASC) ,
  CONSTRAINT `fk_WorkLog_Employee1`
    FOREIGN KEY (`Employee_idEmployee`)
    REFERENCES `mydb`.`Employee` (`idEmployee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

