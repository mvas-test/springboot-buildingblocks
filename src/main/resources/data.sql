INSERT INTO USER (ID, EMAIL_ADDRESS, FIRST_NAME, LAST_NAME, ROLE, SSN, USER_NAME) VALUES
	(101, 'mike@test.com', 'Mike', 'Vas', 'admin', 'ssn101', 'mvas'),
	(102, 'micky@test.com', 'Micky', 'Test', 'admin', 'ssn102', 'mtest'),
	(103, 'luda@test.com', 'Luda', 'Chic', 'user', 'ssn103', 'lchi');
	
INSERT INTO orders VALUES (2001, 'order11', 101);
INSERT INTO orders VALUES (2002, 'order12', 101);
INSERT INTO orders VALUES (2003, 'order13', 101);
INSERT INTO orders VALUES (2004, 'order14', 102);
INSERT INTO orders VALUES (2005, 'order15', 102);
INSERT INTO orders VALUES (2006, 'order16', 103);