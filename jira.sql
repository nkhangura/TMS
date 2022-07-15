-- MySQL Workbench Forward Engineering
-- -----------------------------------------------------
-- Schema jira
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema jira
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `jira` DEFAULT CHARACTER SET utf8 ;
USE `jira` ;

-- -----------------------------------------------------
-- Table `jira`.`PO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jira`.`PO` (
  `idPO` INT NOT NULL AUTO_INCREMENT,
  `PO_name` VARCHAR(45) NOT NULL,
  `PO_email` VARCHAR(45) NOT NULL,
  `PO_projects` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPO`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jira`.`Employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jira`.`Employee` (
  `idEmployee` INT NOT NULL AUTO_INCREMENT,
  `Employee_name` VARCHAR(45) NOT NULL,
  `Employee_emaill` VARCHAR(45) NOT NULL,
  `current_project` INT NOT NULL,
  `points_earned` INT NULL,
  PRIMARY KEY (`idEmployee`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jira`.`Projects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jira`.`Projects` (
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
    REFERENCES `jira`.`PO` (`idPO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jira`.`Stories`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jira`.`Stories` (
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
-- Table `jira`.`WorkLog`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jira`.`WorkLog` (
  `idWorkLog` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL,
  `creation_date` VARCHAR(45) NULL,
  `Employee_idEmployee` INT NOT NULL,
  PRIMARY KEY (`idWorkLog`, `Employee_idEmployee`),
  INDEX `fk_WorkLog_Employee1_idx` (`Employee_idEmployee` ASC),
  CONSTRAINT `fk_WorkLog_Employee1`
    FOREIGN KEY (`Employee_idEmployee`)
    REFERENCES `jira`.`Employee` (`idEmployee`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;





-- -------------------------------------------------------
-- Sample Data
-- -------------------------------------------------------

INSERT INTO `jira`.`Employee` (
  `idEmployee`, `Employee_name`, `Employee_emaill`, `current_project`, `points_earned`)
  VALUES (1, "harry potter", "harry@hogwarts.com", 123, 15);
  
INSERT INTO `jira`.`Employee` (
  `idEmployee`, `Employee_name`, `Employee_emaill`, `current_project`, `points_earned`)
  VALUES (2, "ron weasley", "ron@hogwarts.com", 456, 10);  
  
  INSERT INTO `jira`.`Employee` (
  `idEmployee`, `Employee_name`, `Employee_emaill`, `current_project`, `points_earned`)
  VALUES (3, "hermione granger", "hermione@hogwarts.com", 789, 20);
  
  INSERT INTO `jira`.`PO` (
  `idPO`, `PO_name`, `PO_email`, `PO_projects`)
  VALUES (4, "dumbledore", "dumbledore@hogwarts.com", "myProject");

INSERT INTO `jira`.`PO` (
  `idPO`, `PO_name`, `PO_email`, `PO_projects`)
  VALUES (5, "snape", "snape@hogwarts.com", "Potions");
  
  INSERT INTO `jira`.`PO` (
  `idPO`, `PO_name`, `PO_email`, `PO_projects`)
  VALUES (6, "hagrid", "hagrid@hogwarts.com", "yourAWizard");
  
 INSERT INTO `jira`.`Projects` (
  `idProjects`,`Project_name`,`Project_descript`,`creation_date`,`current_status`,`PO_idPO`)
  VALUES (123, "myProject", "Destroy Horcruxes", 01/01/2022, "open", 4);
  
   INSERT INTO `jira`.`Projects` (
  `idProjects`,`Project_name`,`Project_descript`,`creation_date`,`current_status`,`PO_idPO`)
  VALUES (456, "Potions", "Brew Potions", 05/01/2022, "open", 5);
  
   INSERT INTO `jira`.`Projects` (
  `idProjects`,`Project_name`,`Project_descript`,`creation_date`,`current_status`,`PO_idPO`)
  VALUES (789, "yourAWizard", "Discover who is a wizard", 11/10/2022, "open", 6);
  
SELECT * From Employee WHERE idEmployee =1;

select * from PO;

select * from Employee;




