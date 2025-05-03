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

-- Cuentas de estudiantes
INSERT INTO account(Account_Number, Password) VALUES
('413854653', 'culo1'),
('413854893', 'culo2'),
('413854990', 'culo3'),
('413854890', 'perro0te'),
('413854892', 'duende'),
('41884383',  '413854776');

-- Estudiantes
INSERT INTO student(Name, Surname, Phone_Number, Email_Address, Semester_ID_FK, Account_ID_FK) VALUES 
('Cesar', 'Larrea', '0911637191', 'Cesar@tucorreo.com', 1, 1),
('Crhistian', 'Mendez', '0911637190', 'Crhistian@tucorreo.com', 2, 2),
('Casias', 'Garcia', '0911630901', 'Casias@tucorreo.com', 3, 3),
('Erick', 'Perez', '52215547', 'Erick@tucorreo.com', 1, 4),
('Daniel', 'Sanchez', '48150674', 'Daniel@tucorreo.com', 1, 5),
('Christopher', 'Valevergue', '99887744', 'Christopher@perro.com', 2, 6);

-- Cuentas de profesores
INSERT INTO account(Account_Number, Password) VALUES
('128022001', 'profchu'),
('128022002', 'proffeng'),
('128022003', 'profhung');

-- Profesores
INSERT INTO teacher(Name, Surname, Email_Address, Phone_Number, Account_ID_FK) VALUES
('Chu', 'Liou', '128022@o365.tku.edu.tw', '0937079905', 7),
('Feng', 'Chang', 'fc.chang@gms.tku.edu.tw', '8989789879', 8),
('Hung', 'Fuyi', 'fuyihung@mail.tku.edu.tw', '1241212123', 9);

-- Materias
INSERT INTO subject(Name, Description, Teacher_ID_FK, Semester_ID_FK) VALUES 
('IntroductionToComputers', 'Introduction To Computers course', 3, 1),
('ProbabilityAndStatistics', 'Probability And Statistics course', 1, 2),
('AdvancedProgramming', 'Advanced Programming course', 2, 3);

-- Notas
INSERT INTO grade(Total_Grade, Subject_ID_FK, Student_ID_FK, Grade_Date) VALUES
-- Estudiante 1
(40.2, 1, 1, '2004-09-27'),
(62.8, 2, 1, '2006-08-19'),
-- Estudiante 2 
(70.2, 1, 2, '2008-08-19'),
(45.1, 3, 2, '2014-08-19'),
-- Estudiante 3
(90.4, 1, 3, '2002-08-19'),
(95.9, 2, 3, '2009-08-19');




