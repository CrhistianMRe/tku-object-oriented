SELECT account.Account_Number, student.Name, student.Surname, subject.Name AS subjectName, semester.Name AS semesterName, teacher.Name AS teacherName, grade.Total_Score
    FROM account INNER JOIN student ON student.Account_ID_FK = account.ID 
    INNER JOIN semester ON student.Semester_ID_FK = semester.ID 
    INNER JOIN grade ON grade.Student_ID_FK = student.ID 
    INNER JOIN subject ON grade.Subject_ID_FK = subject.ID 
    INNER JOIN teacher ON subject.Teacher_ID_FK = teacher.ID
    WHERE account.Account=?;
