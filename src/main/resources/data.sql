-- insert user table values
INSERT INTO USER (ID, EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, ROLE, SSN, USER_NAME) VALUES
	(101, 'mike@test.com', 'Mike', 'Vas', 'admin', 'ssn101', 'mvas'),
	(102, 'micky@test.com', 'Micky', 'Test', 'admin', 'ssn102', 'mtest'),
	(103, 'luda@test.com', 'Luda', 'Chic', 'user', 'ssn103', 'lchi');
	
--insert orders table values
INSERT INTO orders VALUES (2001, 'order11', 101);
INSERT INTO orders VALUES (2002, 'order12', 101);
INSERT INTO orders VALUES (2003, 'order13', 101);
INSERT INTO orders VALUES (2004, 'order14', 102);
INSERT INTO orders VALUES (2005, 'order15', 102);
INSERT INTO orders VALUES (2006, 'order16', 103);

-- insert employees table values
INSERT INTO employees Values (201, 'Dept01', '2017-08-25', '2020-01-25T09:00:46.883', '2020-01-25T17:05:12.23', 'Test One', 35000); 
INSERT INTO employees Values (202, 'Dept02', '2018-10-01', '2020-01-25T07:30:12.883', '2020-01-25T15:45:46.23', 'Test Two', 40000);
INSERT INTO employees Values (203, 'Dept01', '2019-12-30', '2020-01-25T08:15:12.883', '2020-01-25T16:30:06.23', 'Test Three', 45000);


