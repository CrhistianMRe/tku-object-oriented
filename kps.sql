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

CREATE TABLE account(
    ID int IDENTITY(1,1) NOT NULL,
    Account_Number varchar(9) NOT NULL,
    Password varchar(100) DEFAULT NULL
);


CREATE TABLE student(
    ID int IDENTITY(1,1) NOT NULL,
    Name varchar(50) NOT NULL,
    Surname varchar(50) NOT NULL,
    Phone_Number varchar(20)NOT NULL,
    Email_Address varchar(60) NOT NULL,
    Semester_ID_FK int NULL,
    Account_ID_FK int NULL

);

CREATE TABLE teacher(
    ID int IDENTITY(1,1) NOT NULL,
    Name varchar(50) NOT NULL,
    Surname varchar(50) NOT NULL,
    Email_Address varchar(60) NOT NULL,
    Phone_Number varchar (20)NOT NULL,
    Account_ID_FK int NULL
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
ALTER TABLE account ADD PRIMARY KEY(ID);
ALTER TABLE semester ADD PRIMARY KEY(ID);
ALTER TABLE student ADD PRIMARY KEY(ID);
ALTER TABLE teacher ADD PRIMARY KEY(ID);
ALTER TABLE subject ADD PRIMARY KEY(ID);
ALTER TABLE grade ADD PRIMARY KEY(ID);

ALTER TABLE student ADD FOREIGN KEY(Account_ID_FK) REFERENCES account(ID);
ALTER TABLE teacher ADD FOREIGN KEY(Account_ID_FK) REFERENCES account(ID);
ALTER TABLE student ADD FOREIGN KEY(Semester_ID_FK) REFERENCES semester(ID);
ALTER TABLE subject ADD FOREIGN KEY(Teacher_ID_FK) REFERENCES teacher(ID);
ALTER TABLE subject ADD FOREIGN KEY(Semester_ID_FK) REFERENCES semester(ID);
ALTER TABLE grade ADD FOREIGN KEY(Subject_ID_FK) REFERENCES subject(ID);
ALTER TABLE grade ADD FOREIGN KEY(Student_ID_FK) REFERENCES student(ID);

- Semestres
INSERT INTO semester(Name) VALUES
('freshman'),
(NULL),
('whatever'),
('test');


--Semester
INSERT INTO kps.dbo.semester (Name) VALUES
	 (N'freshman'),
	 (NULL),
	 (N'whatever'),
	 (N'test');
--Accounts
INSERT INTO kps.dbo.account (Account_Number,Password) VALUES
	 (N'413854653',N'pass1'),
	 (N'413854893',N'pass2'),
	 (N'413854990',N'pass3'),
	 (N'413854890',N'pass4'),
	 (N'413854892',N'duende'),
	 (N'41884383',N'413854776'),
	 (N'128022001',N'profchu'),
	 (N'128022002',N'proffeng'),
	 (N'128022003',N'profhung'),
	 (N'1',N'1');
--Student
INSERT INTO kps.dbo.student (Name,Surname,Phone_Number,Email_Address,Semester_ID_FK,Account_ID_FK) VALUES
	 (N'Cesar',N'Larrea',N'0911637191',N'Cesar@tucorreo.com',1,1),
	 (N'Crhistian',N'Mendez',N'0911637190',N'Crhistian@tucorreo.com',2,2),
	 (N'Casias',N'Garcia',N'0911630901',N'Casias@tucorreo.com',3,3),
	 (N'Erick',N'Perez',N'52215547',N'Erick@tucorreo.com',1,4),
	 (N'Daniel',N'Sanchez',N'48150674',N'Daniel@tucorreo.com',1,5),
	 (N'Christopher',N'Valevergue',N'99887744',N'Christopher@perro.com',2,6);
--Teacher
INSERT INTO kps.dbo.teacher (Name,Surname,Email_Address,Phone_Number,Account_ID_FK) VALUES
	 (N'Chu',N'Liou',N'128022@o365.tku.edu.tw',N'0937079905',7),
	 (N'Feng',N'Chang',N'fc.chang@gms.tku.edu.tw',N'8989789879',8),
	 (N'Hung',N'Fuyi',N'fuyihung@mail.tku.edu.tw',N'1241212123',9),
	 (N'Crhistian',N'Mendez',N'test@gmail.com',N'3231231212',10);
--Subject
INSERT INTO kps.dbo.subject (Name,Description,Teacher_ID_FK,Semester_ID_FK) VALUES
	 (N'IntroductionToComputers',N'Introduction To Computers course',3,1),
	 (N'ProbabilityAndStatistics',N'Probability And Statistics course',1,2),
	 (N'AdvancedProgramming',N'Advanced Programming course',2,3),
	 (N'MongoDB',N'A MongoDB course',4,3),
	 (N'ComputerArchitecture',N'Basic computer architecture principles',1,1),
	 (N'DigitalLogic',N'Digital logic circuits and systems',1,2),
	 (N'LinearAlgebra',N'Linear algebra for engineers',2,3),
	 (N'CalculusI',N'Introduction to Calculus',2,1),
	 (N'ObjectOrientedProgramming',N'OOP in Java and Python',3,2),
	 (N'DataStructures',N'Fundamentals of data structures',3,3);
INSERT INTO kps.dbo.subject (Name,Description,Teacher_ID_FK,Semester_ID_FK) VALUES
	 (N'NoSQLDatabases',N'Advanced NoSQL concepts beyond MongoDB',4,4),
	 (N'CloudComputing',N'Introduction to cloud platforms and services',4,1);
--Grades
INSERT INTO kps.dbo.grade (Total_Grade,Subject_ID_FK,Student_ID_FK,Grade_Date) VALUES
	 (40.2,1,1,'2004-09-27'),
	 (62.8,2,1,'2006-08-19'),
	 (70.2,1,2,'2008-08-19'),
	 (45.1,3,2,'2014-08-19'),
	 (90.4,1,3,'2002-08-19'),
	 (95.9,2,3,'2009-08-19'),
	 (55.0,4,1,'2018-09-21'),
	 (21.4,4,4,'2011-09-02'),
	 (87.0,4,2,'2022-02-01'),
	 (85.0,5,1,'2023-09-15');
INSERT INTO kps.dbo.grade (Total_Grade,Subject_ID_FK,Student_ID_FK,Grade_Date) VALUES
	 (75.0,5,2,'2023-09-16'),
	 (92.0,5,3,'2023-09-17'),
	 (65.0,5,4,'2023-09-18'),
	 (70.0,5,5,'2023-09-19'),
	 (80.0,5,6,'2023-09-20'),
	 (90.0,6,1,'2023-10-01'),
	 (82.0,6,2,'2023-10-02'),
	 (76.5,6,3,'2023-10-03'),
	 (88.0,6,4,'2023-10-04'),
	 (70.5,6,5,'2023-10-05');
INSERT INTO kps.dbo.grade (Total_Grade,Subject_ID_FK,Student_ID_FK,Grade_Date) VALUES
	 (79.0,6,6,'2023-10-06'),
	 (78.5,7,1,'2023-10-10'),
	 (83.0,7,2,'2023-10-11'),
	 (91.0,7,3,'2023-10-12'),
	 (69.0,7,4,'2023-10-13'),
	 (72.5,7,5,'2023-10-14'),
	 (88.0,7,6,'2023-10-15'),
	 (85.5,8,1,'2023-11-01'),
	 (79.0,8,2,'2023-11-02'),
	 (91.5,8,3,'2023-11-03');
INSERT INTO kps.dbo.grade (Total_Grade,Subject_ID_FK,Student_ID_FK,Grade_Date) VALUES
	 (67.0,8,4,'2023-11-04'),
	 (73.5,8,5,'2023-11-05'),
	 (82.0,8,6,'2023-11-06'),
	 (88.0,9,1,'2023-11-10'),
	 (76.5,9,2,'2023-11-11'),
	 (95.0,9,3,'2023-11-12'),
	 (79.0,9,4,'2023-11-13'),
	 (72.0,9,5,'2023-11-14'),
	 (85.0,9,6,'2023-11-15'),
	 (92.0,10,1,'2023-11-20');
INSERT INTO kps.dbo.grade (Total_Grade,Subject_ID_FK,Student_ID_FK,Grade_Date) VALUES
	 (80.0,10,2,'2023-11-21'),
	 (89.5,10,3,'2023-11-22'),
	 (75.0,10,4,'2023-11-23'),
	 (68.0,10,5,'2023-11-24'),
	 (90.0,10,6,'2023-11-25'),
	 (91.0,11,1,'2023-12-01'),
	 (79.0,11,2,'2023-12-02'),
	 (84.5,11,3,'2023-12-03'),
	 (72.0,11,4,'2023-12-04'),
	 (88.0,11,5,'2023-12-05');
INSERT INTO kps.dbo.grade (Total_Grade,Subject_ID_FK,Student_ID_FK,Grade_Date) VALUES
	 (100.0,11,6,'2023-12-06'),
	 (86.5,12,1,'2023-12-10'),
	 (78.0,12,2,'2023-12-11'),
	 (92.5,12,3,'2023-12-12'),
	 (70.0,12,4,'2023-12-13'),
	 (80.0,12,5,'2023-12-14'),
	 (95.0,12,6,'2023-12-15');
