CREATE TABLE passports(
id varchar not null primary key,
first_name varchar(30),
last_name varchar(30),
sex varchar(10),
nationality varchar(50),
date_of_birth date
);

CREATE TABLE passengers(
id varchar not null primary key,
allergy varchar(100),
ammount_of_bagage float,
passport_id varchar,
foreign key (passport_id) references passports(id)
);

CREATE TABLE airlines(
id varchar not null primary key,
airline_name varchar(50),
airline_code varchar(20),
airline_type varchar(50)
);

CREATE TABLE aircrafts(
id varchar not null primary key,
aircraft_brand varchar(30),
model varchar(20),
registration_number varchar(50),
airline_id varchar,
foreign key (airline_id) references airlines(id)
);

create table flights_info(
id varchar not null primary key,
flight_number varchar(20),
date_of_departure date,
time_of_departure time,
date_of_arrival date,
time_of_arrival time,
airline_id varchar,
aircraft_id varchar,
foreign key (airline_id) references airlines(id),
foreign key (aircraft_id) references aircrafts(id)
);

create table tickets(
id varchar not null primary key,
ticket_number varchar,
passenger_id varchar,
flight_info_id varchar,
passport_id varchar,
foreign key (passenger_id) references passengers(id),
foreign key (flight_info_id) references flights_info(id),
foreign key (passport_id) references passports(id)
);

create table services(
id varchar not null primary key,
service_description varchar(100),
price float
);

create table airline_service(
airline_id varchar,
service_id varchar,
foreign key (airline_id) references airlines(id),
foreign key (service_id) references services(id)
);

create table passenger_service(
passenger_id varchar,
service_id varchar,
foreign key (passenger_id) references passengers(id),
foreign key (service_id) references services(id)
)



SELECT * FROM passports;
SELECT * FROM aircrafts;
SELECT * FROM airlines;
SELECT * FROM flights_info;
SELECT * FROM passengers;
SELECT * FROM services;
SELECT * FROM tickets;
SELECT * FROM airline_service;
SELECT * FROM passenger_service;