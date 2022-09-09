USE science_laboratory;
SELECT * FROM 

UPDATE tools 
	SET tools.name = 'Tweezer'
	WHERE tools.name = 'Tweezers';

UPDATE samples
	SET samples.name = 'Head hair'
	WHERE samples.id = 3;
	
UPDATE classes 
	SET classes.name = REPLACE(classes.name,'Bacteriophage','Phage')
	WHERE classes.id = 13;
	
UPDATE workers 
	SET workers.wage = (SELECT workers.wage 
						FROM workers 
						WHERE workers.wage>1000
						ORDER BY RAND()
						LIMIT 1)
	WHERE workers.id = 1;

UPDATE workers 
	SET workers.first_name ='Marcelo', workers.last_name ='Gallardo', workers .email ='elmuñe@madrid.com'
	WHERE workers.id_number = '38789372';
	
