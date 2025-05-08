SELECT student.ID AS Student_ID, teacher.ID AS Teacher_ID
FROM account 
left join student on student.Account_ID_FK = account.ID
left join teacher on teacher.Account_ID_FK = account.ID
WHERE account.ID = 1;
