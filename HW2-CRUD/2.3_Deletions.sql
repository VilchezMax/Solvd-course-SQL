USE science_laboratory;

-- INSERTS FOR DELETABLE DATA

INSERT INTO samples VALUES (7,'sample',4);

INSERT INTO tools VALUES (9,'deletable');


DELETE FROM  samples
	   WHERE id = 7;
	  
DELETE from tools 
	   WHERE id > 5;}
	   
DELETE FROM workers 
	   WHERE wage > 100000 OR role_id=10;

	  
CREATE TABLE deletable( id INTEGER NOT NULL PRIMARY KEY);

DELETE FROM deletable; -- NEVER DO THIS WITHOUT WHERE CLAUSE
	   