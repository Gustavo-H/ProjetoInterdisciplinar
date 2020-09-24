--DROP TABLES

DROP TABLE IF EXISTS RENTAL;
DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS CAR;
DROP TABLE IF EXISTS CLIENT;
DROP TABLE IF EXISTS ADDRESS;
DROP TABLE IF EXISTS EMPLOYEE;

--CREATE TABLES

CREATE TABLE EMPLOYEE (
    id SERIAL, 
    name VARCHAR(200),
    serial VARCHAR(20), 
    cpf VARCHAR(14),
    role INT(1),
    is_deleted INT DEFAULT 0,
    deleted_date DATETIME,
    deleted_by INT,
    PRIMARY KEY (ID));
ALTER TABLE EMPLOYEE
ADD FOREIGN KEY (deleted_by) 
REFERENCES EMPLOYEE(ID);

CREATE TABLE USER (
    id SERIAL,
    login VARCHAR(20), 
    password VARCHAR(20),
    owner_id INT, 
    type INT(1),
    is_deleted INT DEFAULT 0,
    deleted_date DATETIME,
    deleted_by INT,
    PRIMARY KEY (ID));
ALTER TABLE USER
ADD FOREIGN KEY (deleted_by) 
REFERENCES EMPLOYEE(ID);


CREATE TABLE CAR(
    id SERIAL,
    car_plate VARCHAR(10),
    model VARCHAR(50),
    brand INT,
    color INT,
    group_id INT,
    year INT,
    is_deleted INT DEFAULT 0,
    deleted_date DATETIME,
    deleted_by INT,
    PRIMARY KEY (ID));

ALTER TABLE CAR
ADD FOREIGN KEY (deleted_by) 
REFERENCES EMPLOYEE(ID);


CREATE TABLE ADDRESS (
    id SERIAL,
    street VARCHAR(100),
    number INT, 
    neighborhood VARCHAR(80),
    city VARCHAR(30), 
    state VARCHAR(20), 
    complement VARCHAR(50),
    PRIMARY KEY (ID));


CREATE TABLE CLIENT (
    id SERIAL, 
    name VARCHAR(200),
    cpf VARCHAR(14),
    rg VARCHAR(15),
    birthday VARCHAR(10), 
    address INT,
    contact VARCHAR(15),
    email VARCHAR(100),
    is_deleted INT DEFAULT 0,
    deleted_date DATETIME,
    deleted_by INT,
    PRIMARY KEY (ID));      
ALTER TABLE CLIENT
ADD FOREIGN KEY (deleted_by) 
REFERENCES EMPLOYEE(ID);

ALTER TABLE CLIENT
ADD FOREIGN KEY (address) 
REFERENCES ADDRESS(ID);


CREATE TABLE RENTAL (
    id SERIAL,
    client_id INT,
    employee_id INT,
    car_id INT, 
    dateWithdrawal DATETIME,
    expectedReturnDate DATETIME,
    effectiveReturnDate DATETIME,
    PRIMARY KEY (ID));
ALTER TABLE RENTAL
ADD FOREIGN KEY (client_id) 
REFERENCES CLIENT(ID);

ALTER TABLE RENTAL
ADD FOREIGN KEY (employee_id) 
REFERENCES EMPLOYEE(ID);

ALTER TABLE RENTAL
ADD FOREIGN KEY (car_id) 
REFERENCES CAR(ID);

--INITIAL CHARGE

INSERT INTO CAR(car_plate, model, brand, color, group_id, year) VALUES('AAA-1111', 'VW-Fusca 1.5', 1, 2, 3, 1980);

INSERT INTO ADDRESS (street, number, neighborhood, city, state, complement) VALUES ('Rua de teste', 1000, 'Vila de Teste', 'Teste', 'SP', 'Bloco AAA Apartamento 222');
INSERT INTO CLIENT(name, cpf, rg, birthday, address, contact, email) VALUES('João da Silva', '123.456.789-10', '12.345.678', '01/01/2020', 1, '55112233445566', 'joao123@gmail.com');

INSERT INTO USER(login, password, owner_id, type) VALUES('admin', 'admin', 1, 1);

INSERT INTO EMPLOYEE(name, serial, cpf, role) VALUES('Gustavo Henrique', '001976', '123.456.789-10', 2);


