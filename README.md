////////////********* Создание необходимых таблиц *********///////////

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


////************* Добавление данных в таблицы *************/////////

Passport passport = new Passport(
LocalDate.now().toString(),
LocalDate.now().toString(),
"Viktoria",
"Demchuk",
SexType.MALE,
"Belarus",
Date.valueOf("1999-05-10")
);

            Passenger passenger = new Passenger(
                    LocalDate.now().toString(),
                    LocalDate.now().toString(),
                    "no",
                    21.3d
            );

            Airline airline = new Airline(
                    LocalDate.now().toString(),
                    LocalDate.now().toString(),
                    "Belavia",
                    "BRU",
                    AirlineType.INTERNATIONAL
            );

            Aircraft aircraft = new Aircraft(
                    LocalDate.now().toString(),
                    LocalDate.now().toString(),
                    "Boeing",
                    "737-800",
                    "2384XC7"
            );

            FlightInfo flightInfo = new FlightInfo(
                    LocalDate.now().toString(),
                    LocalDate.now().toString(),
                    "22012025TH",
                    Date.valueOf("2025-01-22"),
                    Time.valueOf("20:06:00"),
                    Date.valueOf("2025-01-23"),
                    Time.valueOf("02:12:00")
            );

            Ticket ticket = new Ticket(
                    LocalDate.now().toString(),
                    LocalDate.now().toString(),
                    "432FS195"
            );

            Service service = new Service(
                    LocalDate.now().toString(),
                    LocalDate.now().toString(),
                    "Upgrade to business",
                    100.0d
            );

            passenger.addService(service);
            passenger.addTicket(ticket);
            passport.addTicket(ticket);
            aircraft.addFlightInfoToAircraft(flightInfo);
            airline.addAircraft(aircraft);
            airline.addService(service);
            airline.addFlight(flightInfo);
            flightInfo.addTicket(ticket);
            service.addAirline(airline);
            service.addPassenger(passenger);
            passenger.setPassport(passport);

            session.save(passport);
            session.save(airline);
            session.save(aircraft);
            session.save(flightInfo);
            session.save(ticket);
            session.save(service);
            session.save(passenger);