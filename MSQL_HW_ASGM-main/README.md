Flight DB:
Queries:
select passenger_name from Passenger where passenger_name like '_e%';
select passenger_name,max(passenger_dob) as dob from Passenger order by passenger_dob desc;
select count(*) as Flights_from_Kolkata from Flight where flightsource=('Kolkata');
select distinct passenger_name, p.passenger_id from Passenger p, Booking_details b group by b.passenger_id having count(b.passenger_id )>1;


Hospital DB:
Queries:
select p.name , a.admission_date from PATIENT_MASTER p , ROOM_ALLOCATION a where p.pid = a.pid AND month(a.admission_date) = 01 ;
select * from PATIENT_MASTER where Disease!= 'Asthma' && Gender= 'F';
SELECT COUNT(CASE WHEN UPPER(Gender) = 'M' THEN 1 END) Male,COUNT(CASE WHEN UPPER(Gender) = 'F' THEN 1 END) Female,COUNT(CASE WHEN Gender IS NULL THEN 1 END) 'Not Assigned' FROM PATIENT_MASTER;
select  PATIENT_MASTER.pid,name,PATIENT_MASTER.doctor_id,doctor_name,ROOM_ALLOCATION.room_no,room_type,admission_date from  ROOM_ALLOCATION,PATIENT_MASTER, DOCTOR_MASTER,ROOM_MASTER where PATIENT_MASTER.pid=ROOM_ALLOCATION.pid and PATIENT_MASTER.doctor_id=DOCTOR_MASTER.doctor_id and ROOM_ALLOCATION.room_no=ROOM_MASTER.room_no;
select room_no from ROOM_MASTER where room_no not in (select r.room_no  from ROOM_MASTER r,ROOM_ALLOCATION ra ,PATIENT_MASTER p where p.pid=ra.pid and r.room_no=ra.room_no );
select distinct ra.room_no, r.room_type from ROOM_ALLOCATION ra,ROOM_MASTER r group by r.room_no having count(r.room_no)>1 and ra.room_no=r.room_no;
