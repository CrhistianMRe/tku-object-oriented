SELECT account.Account_Number, student.Name, student.Surname, grade.Total_Grade, grade.Grade_Date
FROM grade INNER JOIN student ON grade.Student_ID_FK = student.ID 
    INNER JOIN subject ON grade.Subject_ID_FK = subject.ID
    INNER JOIN account ON student.Account_ID_FK = account.ID
    WHERE subject.Name ='NoSqlDatabases';
