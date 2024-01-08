DROP DATABASE IF EXISTS teaCollection;
CREATE DATABASE IF NOT EXISTS teaCollection;

USE teaCollection;

CREATE TABLE users (
    User_name VARCHAR(10) PRIMARY KEY,
    Password VARCHAR(155) NOT NULL,
    Email VARCHAR(100) NOT NULL
);

CREATE TABLE log_history (
    L_no VARCHAR(10) PRIMARY KEY,
    User_name VARCHAR(10) NOT NULL,
    Log_date DATE NOT NULL,
    Time_in TIME NOT NULL,
    Time_out TIME NOT NULL,
    CONSTRAINT FOREIGN KEY (User_name) REFERENCES users (User_name)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE employee (
    Emp_id VARCHAR(10) PRIMARY KEY,
    User_name VARCHAR(20) NOT NULL,
    First_name VARCHAR(20) NOT NULL,
    Last_name VARCHAR(20) NOT NULL,
    Job_role VARCHAR(10) NOT NULL,
    Contact_no VARCHAR(11) NOT NULL,
    Address VARCHAR(50) NOT NULL,
    Basic_Pay DOUBLE NOT NULL,
    CONSTRAINT FOREIGN KEY (User_name) REFERENCES users (User_name)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE salary (
    Sal_id VARCHAR(10) PRIMARY KEY,
    Emp_id VARCHAR(10) NOT NULL,
    Attendance_Pay INT NOT NULL,
    Total_payment INT NOT NULL,
    CONSTRAINT FOREIGN KEY (Emp_id) REFERENCES employee (Emp_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

create table attendance (
    Att_id varchar (4) primary key,
    Emp_id varchar (4),
    Time_in varchar (10),
    work_hours varchar (4),
    CONSTRAINT FOREIGN KEY (Emp_id) REFERENCES employee (Emp_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE tea_producer (
    Producer_id VARCHAR(10) PRIMARY KEY,
    User_name VARCHAR(10) NOT NULL,
    Name VARCHAR(20) NOT NULL,
    Address VARCHAR(50) NOT NULL,
    NIC VARCHAR(13) NOT NULL,
    Contact_no VARCHAR(11) NOT NULL,
    Join_date DATE NOT NULL,
    CONSTRAINT FOREIGN KEY (User_name) REFERENCES users (User_name)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE payment (
    Pay_id VARCHAR(10) PRIMARY KEY,
    Pay_method VARCHAR(20) NOT NULL,
    Description VARCHAR(50) NOT NULL,
    Total_pay DOUBLE NOT NULL
);

CREATE TABLE fertilizer_equipments (
    Eq_id VARCHAR(10) PRIMARY KEY,
    User_name VARCHAR(10) NOT NULL,
    Pay_id VARCHAR(10) NOT NULL,
    Name VARCHAR(10) NOT NULL,
    Description VARCHAR(20) NOT NULL,
    Unit_price INT NOT NULL,
    CONSTRAINT FOREIGN KEY (User_name) REFERENCES users (User_name)
    ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (Pay_id) REFERENCES payment (Pay_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE fertilizer_equipment_detail (
    Eq_id VARCHAR(10) PRIMARY KEY,
    Producer_id VARCHAR(10) NOT NULL,
    Pay_id VARCHAR(10) NOT NULL,
    Name VARCHAR(10) NOT NULL,
    Description VARCHAR(20) NOT NULL,
    Unit_price INT NOT NULL,
    CONSTRAINT FOREIGN KEY (Producer_id) REFERENCES tea_producer (Producer_id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (Pay_id) REFERENCES payment (Pay_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE tea (
    T_id VARCHAR(10) PRIMARY KEY,
    Weight DOUBLE NOT NULL,
    Type VARCHAR(10) NOT NULL,
    Monthly_pay_kilo DOUBLE NOT NULL,
    Description VARCHAR(50) NOT NULL,
    Pay_id VARCHAR(30) NOT NULL
);

alter table tea
    add constraint Pay_id
        foreign key (Pay_id) references payment (Pay_id);

CREATE TABLE tea_detail (
    T_id VARCHAR(10) NOT NULL,
    Producer_id VARCHAR(10) NOT NULL,
    Total DOUBLE NOT NULL,
    CONSTRAINT FOREIGN KEY (T_id) REFERENCES tea (T_id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (Producer_id) REFERENCES tea_producer (Producer_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE factory (
    Factory_id VARCHAR(10) PRIMARY KEY,
    User_name VARCHAR(10) NOT NULL,
    Name VARCHAR(10) NOT NULL,
    Address VARCHAR(10) NOT NULL,
    Joined_date DATE NOT NULL,
    Time_period TIME NOT NULL,
    CONSTRAINT FOREIGN KEY (User_name) REFERENCES users (User_name)
    ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE product_detail (
    T_id VARCHAR(10) NOT NULL,
    Factory_id VARCHAR(10) NOT NULL,
    Quality DOUBLE NOT NULL,
    CONSTRAINT FOREIGN KEY (T_id) REFERENCES tea (T_id)
    ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT FOREIGN KEY (Factory_id) REFERENCES factory (Factory_id)
    ON DELETE CASCADE ON UPDATE CASCADE
);

insert into users values ('pesala','1234','pesala@gmail.com');


