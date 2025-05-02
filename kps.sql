DROP TABLE semester;
DROP TABLE student;
DROP TABLE teacher;
DROP TABLE subject;
DROP TABLE grade;




CREATE DATABASE kps;
USE kps;


CREATE TABLE semester(
    ID int IDENTITY(1,1) NOT NULL,
    Name varchar(50) DEFAULT NULL
);

CREATE TABLE student(
    ID int IDENTITY(1,1) NOT NULL,
    Name varchar(50) NOT NULL,
    Surname varchar(50) NOT NULL,
    Phone_Number varchar(20)NOT NULL,
    Email_Address varchar(60) NOT NULL,
    Account_ID varchar(9) NOT NULL,
    Password varchar(100) DEFAULT NULL,
    Semester_ID_FK int DEFAULT NULL

);

CREATE TABLE teacher(
    ID int IDENTITY(1,1) NOT NULL,
    Name varchar(50) NOT NULL,
    Email_Address varchar(60) NOT NULL,
    Surname varchar(50) NOT NULL,
    Phone_Number int NOT NULL
);
CREATE TABLE subject(
    ID int IDENTITY(1,1) NOT NULL,
    Name varchar(50) NOT NULL,
    Description varchar(300) NULL,
    Teacher_ID_FK int DEFAULT NULL,
    Semester_ID_FK int DEFAULT NULL
);


CREATE TABLE grade(
    ID int IDENTITY(1,1) NOT NULL,
    Total_Grade float DEFAULT NULL,
    Subject_ID_FK int NOT NULL,
    Student_ID_FK int NOT NULL,
    Grade_Date Date NOT NULL
);

ALTER TABLE semester ADD PRIMARY KEY(ID);
ALTER TABLE student ADD PRIMARY KEY(ID);
ALTER TABLE teacher ADD PRIMARY KEY(ID);
ALTER TABLE subject ADD PRIMARY KEY(ID);
ALTER TABLE grade ADD PRIMARY KEY(ID);

ALTER TABLE student ADD FOREIGN KEY(Semester_ID_FK) REFERENCES semester(ID);
ALTER TABLE subject ADD FOREIGN KEY(Teacher_ID_FK) REFERENCES teacher(ID);
ALTER TABLE subject ADD FOREIGN KEY(Semester_ID_FK) REFERENCES semester(ID);
ALTER TABLE grade ADD FOREIGN KEY(Subject_ID_FK) REFERENCES subject(ID);
ALTER TABLE grade ADD FOREIGN KEY(Student_ID_FK) REFERENCES student(ID);

INSERT INTO semester(Name)VALUES
('freshman'),
(NULL),
('whatever'),
('test');

INSERT INTO student(Name, Surname, Phone_Number, Email_Address, Account_ID, Password, Semester_ID_FK) VALUES 
('Cesar', 'Larrea', '0911637191', 'Cesar@tucorreo.com','413854653', 'culo1', 1),
('Crhistian', 'Mendez', '0911637190', 'Crhistian@tucorreo.com','413854893', 'culo2', 2),
('Casias', 'Garcia', '0911630901', 'Casias@tucorreo.com','413854990', 'culo3', 3),
('Erick', 'Perez', '52215547', 'Erick@tucorreo.com','413854890', 'perro0te', 1),
('Daniel', 'Sanchez', '48150674', 'Daniel@tucorreo.com','413854892', 'duende', 1),
('Christopher', 'Valevergue', '99887744', 'Christopher@perro.com','41884383', '413854776', 2);


INSERT INTO teacher(Name, Surname, Email_Address, Phone_Number) VALUES
('Chu', 'Liou', '128022@o365.tku.edu.tw', '0937079905'),
('Feng', 'Chang', 'fc.chang@gms.tku.edu.tw', '8989789879'),
('Hung', 'Fuyi', 'fuyihung@mail.tku.edu.tw', '1241212123');

INSERT INTO subject(Name, Description, Teacher_ID_FK, Semester_ID_FK) VALUES 
('IntroductionToComputers', 'Introduction To Computers course', 3, 1),
('ProbabilityAndStatistics', 'Probability And Statistics course', 1, 2),
('AdvancedProgramming', 'Advanced Programming course', 2, 3);

INSERT INTO grade(Total_Grade, Subject_ID_FK, Student_ID_FK, Grade_Date) VALUES
--Student 1
(40.2, 1, 1, '2004-09-27'),
(62.8, 2, 1, '2006-08-19'),
--Student 2 
(70.2, 1, 2, '2008-08-19'),
(45.1, 3, 2, '2014-08-19'),
--Student 3
(90.4, 1, 3, '2002-08-19'),
(95.9, 2, 3, '2009-08-19');




