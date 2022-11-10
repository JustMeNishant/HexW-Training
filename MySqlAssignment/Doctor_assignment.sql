CREATE SCHEMA IF NOT EXISTS `hospital_2000080620` DEFAULT CHARACTER SET utf8 ;
USE `hospital_2000080620` ;

-- -----------------------------------------------------
-- Table `hospital_2000080620`.`DOCTOR_MASTER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital_2000080620`.`DOCTOR_MASTER` (
  `doctor_id` VARCHAR(5) NOT NULL,
  `doctor_name` VARCHAR(15) NOT NULL,
  `Dept` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`doctor_id`),
  UNIQUE INDEX `doctor_id_UNIQUE` (`doctor_id` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_2000080620`.`ROOM_MASTER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital_2000080620`.`ROOM_MASTER` (
  `room_no` VARCHAR(15) NOT NULL,
  `room_type` VARCHAR(45) NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`room_no`),
  UNIQUE INDEX `room_no_UNIQUE` (`room_no` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_2000080620`.`PATIENT_MASTER`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital_2000080620`.`PATIENT_MASTER` (
  `pid` VARCHAR(15) NOT NULL,
  `name` VARCHAR(45) NULL,
  `age` INT NULL,
  `Weight` INT NULL,
  `Gender` VARCHAR(10) NULL,
  `Address` VARCHAR(45) NULL,
  `phoneno` VARCHAR(10) NULL,
  `Disease` VARCHAR(45) NULL,
  `doctor_id` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`pid`, `doctor_id`),
  INDEX `fk_PATIENT_MASTER_idx` (`doctor_id` ASC) ,
  CONSTRAINT `fk_PATIENT_MASTER`
    FOREIGN KEY (`doctor_id`)
    REFERENCES `hospital_2000080620`.`DOCTOR_MASTER` (`doctor_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `hospital_2000080620`.`ROOM_ALLOCATION`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hospital_2000080620`.`ROOM_ALLOCATION` (
  `room_no` VARCHAR(15) NOT NULL,
  `pid` VARCHAR(15) NOT NULL,
  `admission_date` DATE NULL,
  `Release_date` DATE NULL,
  PRIMARY KEY (`room_no`, `pid`),
  INDEX `fk_ROOM_ALLOCATION_idx` (`pid` ASC) ,
  CONSTRAINT `fk_ROOM_ALLOCATION_ROOM_MASTER1`
    FOREIGN KEY (`room_no`)
    REFERENCES `hospital_2000080620`.`ROOM_MASTER` (`room_no`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ROOM_ALLOCATION_PATIENT_MASTER1`
    FOREIGN KEY (`pid`)
    REFERENCES `hospital_2000080620`.`PATIENT_MASTER` (`pid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;





insert into DOCTOR_MASTER(doctor_id,doctor_name,Dept)values('D0001','Ram','ENT'),('D0002','Rajan','ENT'),('D0003','Smita','Eye'),('D0004','Bhavan','Surgery'),('D0005','Sheela','Surgery');
select * from DOCTOR_MASTER;
describe DOCTOR_MASTER;

insert into ROOM_MASTER(room_no,room_type,status)values('R0001','AC','occupied'),('R0002',	'Suite','vacant'),('R0003','NonAC',	'vacant'),('R0004','NonAC',	'occupied'),('R0005','AC','vacant'),('R0006','AC','occupied');
select * from ROOM_MASTER;
describe ROOM_MASTER;

describe PATIENT_MASTER;
insert into PATIENT_MASTER(pid,name,age,Weight,Gender,Address,phoneno,Disease,doctor_id)values('P0001', 'Gita', 35, 65, 'F', 'Chennai', '9867145678', 'Eye Infection', 'D0003'),('P0002', 'Ashish', 40, 70, 'M', 'Delhi', '9845675678', 'Asthma', 'D0003'),('P0003', 'Radha', 25, 60, 'F', 'Chennai', '9867166678', 'Pain in heart', 'D0005'),('P0004', 'Chandra', 28, 55, 'F', 'Bangalore', '9978675567', 'Asthma', 'D0001'),('P0005', 'Goyal', 42, 65, 'M', 'Delhi', '8967533223', 'Pain in Stomach', 'D0004');
select * from PATIENT_MASTER;

describe ROOM_ALLOCATION;
insert into ROOM_ALLOCATION(room_no,pid,admission_date,Release_date)values('R0001','P0001','15/10/16','26/10/16'),('R0002','P0002','15/11/16','26/11/16'),('R0002','P0003','01/12/16','30/12/16'),('R0004','P0001','01/01/17','30/01/17');
select * from ROOM_ALLOCATION;


-- Quries to obtain results --

select * from PATIENT_MASTER pm,ROOM_ALLOCATION ra where pm.pid =ra.pid and month(ra.admission_date) = 1;

select * from PATIENT_MASTER where Disease!= 'Asthma' && Gender= 'F';

select gender,count(Gender) as Patient_Count from PATIENT_MASTER group by(gender);
SELECT COUNT(CASE WHEN UPPER(Gender) = 'M' THEN 1 END) Male,COUNT(CASE WHEN UPPER(Gender) = 'F' THEN 1 END) Female,COUNT(CASE WHEN Gender IS NULL THEN 1 END) 'Not Assigned' FROM PATIENT_MASTER;

select  PATIENT_MASTER.pid,name,PATIENT_MASTER.doctor_id,doctor_name,ROOM_ALLOCATION.room_no,room_type,admission_date from  ROOM_ALLOCATION,PATIENT_MASTER, DOCTOR_MASTER,ROOM_MASTER where PATIENT_MASTER.pid=ROOM_ALLOCATION.pid and PATIENT_MASTER.doctor_id=DOCTOR_MASTER.doctor_id and ROOM_ALLOCATION.room_no=ROOM_MASTER.room_no;

select room_no from ROOM_MASTER where room_no not in (select r.room_no  from ROOM_MASTER r,ROOM_ALLOCATION ra ,PATIENT_MASTER p where p.pid=ra.pid and r.room_no=ra.room_no );
select room_no as Unallocated_rooms from ROOM_MASTER where room_no not in (select room_no from ROOM_ALLOCATION);

select room_no,count(room_no) from ROOM_ALLOCATION group by(room_no);
select * from ROOM_MASTER rm,ROOM_ALLOCATION ra where rm.room_no = ra.room_no and count(room_no) >1;