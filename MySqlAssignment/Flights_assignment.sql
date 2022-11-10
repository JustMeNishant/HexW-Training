-- Schema flightdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema flightdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `flightdb` DEFAULT CHARACTER SET utf8 ;
USE `flightdb` ;

-- -----------------------------------------------------
-- Table `flightdb`.`Passenger`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flightdb`.`Passenger` (
  `passenger_id` VARCHAR(10) NOT NULL,
  `passenger_name` VARCHAR(20) NOT NULL,
  `passenger_email` VARCHAR(20) NOT NULL,
  `passenger_dob` DATE NOT NULL,
  PRIMARY KEY (`passenger_id`),
  UNIQUE INDEX `passenger_id_UNIQUE` (`passenger_id` ASC) )
ENGINE = InnoDB
COMMENT = '																			';


-- -----------------------------------------------------
-- Table `flightdb`.`Flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flightdb`.`Flight` (
  `flightid` VARCHAR(15) NOT NULL,
  `flightsource` VARCHAR(15) NOT NULL,
  `flightdest` VARCHAR(15) NOT NULL,
  `flightdate` DATE NOT NULL,
  `flightseat` VARCHAR(15) NULL,
  `ticketcost` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`flightid`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flightdb`.`Booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flightdb`.`Booking` (
  `booking_id` VARCHAR(15) NOT NULL,
  `flight_id` VARCHAR(15) NOT NULL,
  `bookdate` VARCHAR(15) NULL,
  PRIMARY KEY (`booking_id`, `flight_id`),
  INDEX `fk_Booking_Flight1_idx` (`flight_id` ASC) ,
  CONSTRAINT `fk_Booking_Flight1`
    FOREIGN KEY (`flight_id`)
    REFERENCES `flightdb`.`Flight` (`flightid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flightdb`.`Booking_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flightdb`.`Booking_details` (
  `passenger_id` VARCHAR(10) NOT NULL,
  `booking_id` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`passenger_id`, `booking_id`),
  INDEX `fk_Booking_details_Booking1_idx` (`booking_id` ASC) ,
  CONSTRAINT `fk_Booking_details_Passenger`
    FOREIGN KEY (`passenger_id`)
    REFERENCES `flightdb`.`Passenger` (`passenger_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Booking_details_Booking1`
    FOREIGN KEY (`booking_id`)
    REFERENCES `flightdb`.`Booking` (`booking_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

describe Flight;
describe Passenger;
describe Booking;
describe Booking_details;

insert into Passenger(passenger_id,passenger_name,passenger_email,passenger_dob)values('P0001','Ram','Ram@gmail.com','1980/12/01'),('P0002','Rajan','Rajan@gmail.com','1939/11/11'),('P0003','Smita','Smita@gmail.com','1988/02/06'),('P0004','Bhavan','Bhavan@gmail.com','1973/03/18'),('P0005','Sheela','Sheela@gmail.com','1976/05/09'),('P0006','Nethra','Nethra@gmail.com','1955/10/08');
insert into Flight(flightid,flightsource,flightdest,flightdate,flightseat,ticketcost)values ('F0001', 'Kolkata', 'Hyderabad', '2012/12/01', '100', '2000'),('F0002', 'Chennai', 'Hyderabad', '2012/12/02', '100', '3000'),('F0003', 'Pune', 'Kolkata', '2012/12/02', '100', '2500'),('F0004', 'Bangalore', 'Pune', '2012/11/18', '100', '2300'),('F0005', 'Hyderabad', 'Bangalore', '2012/04/09', '100', '2600'),('F0006', 'Pune', 'Hyderabad', '2012/08/08', '100', '3500'),('F0007', 'Pune', 'Kolkata', '2012/12/04', '100', '2900') ,('F0008', 'Kolkata', 'Hyderabad', '2012/12/06', '100', '3500');
insert into Booking(booking_id,flight_id,bookdate)values('B0001', 'F0001', '2012/12/01'),('B0002', 'F0004', '2012/12/02'),('B0003', 'F0005', '2012/12/03'),('B0004', 'F0003', '2012/12/04'),('B0005', 'F0001', '2012/12/02'),('B0006', 'F0004', '2012/12/02'),('B0007', 'F0003', '2016/12/02');
insert into Booking_details(booking_id,passenger_id)values('B0001','P0001'),('B0001','P0002'),('B0001','P0003'),('B0002','P0004'),('B0002','P0005'),('B0003','P0006'),('B0003', 'P0001'),('B0004','P0002'),('B0005','P0003');

select passenger_name from Passenger where passenger_name like '_e%';
select passenger_name,max(passenger_dob) as dob from Passenger order by passenger_dob desc;
select count(*) as Flights_from_Kolkata from Flight where flightsource=('Kolkata');
select distinct passenger_name, p.passenger_id from Passenger p, Booking_details b group by b.passenger_id having count(b.passenger_id )>1;