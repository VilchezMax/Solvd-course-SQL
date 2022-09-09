USE science_laboratory;


INSERT INTO roles (name) 
		   VALUES ('Scientist'),
		  		  ('Assistant');

INSERT INTO seniorities (name) 
			     VALUES ('Trainee'),
			            ('Junior'),
			            ('SemiSenior'),
			            ('Senior'),
			            ('Principal');
			          
INSERT INTO healthrisks (name) 
				  VALUES('Safe'),
				        ('Radiation'),
				        ('Trauma'),
				        ('Infection'),
				        ('Poison');
				       
INSERT INTO kingdoms (name) 
			   VALUES('Animal'),
			  		 ('Plant'),
			  		 ('Fungi'),
			  		 ('Monera'),
			  		 ('Protista'),
			  		 ('Virus');
			  		
INSERT INTO labwings (name) 
			   VALUES('North'),
			  		 ('South'),
			  		 ('East'),
			  		 ('West');
				  						       
INSERT INTO classes (name, kingdom_id) 
			  VALUES('Bacteria', 5),
			  		('Mammal', 1),
			  		('Amphibian', 1),
			  		('Reptile', 1),
			  		('Fish', 1),
			  		('Bird', 1),
			  		('Yeast', 3),
			  		('Hyphae', 3),
			  		('Algae', 4),
			  		('Digitalis', 2),
			  		('Yerbamate', 2),
			  		('Virus', 6),
			  		('Bacteriophage', 6);
			  	
INSERT INTO substrates (name,health_risk_id)
			   VALUES('Iodine-131', 2),
			  		 ('Thallium-201', 2),
			  		 ('Glucose', 1),
			  		 ('Sodium chloride', 1),
			  		 ('Monoclonal antibodies', 1);

INSERT INTO workers (role_id,seniority_id,first_name,last_name,id_number,email,wage,phd) 
			 VALUES(2,3,'Maximiliano','Vilchez',38789372,'maximiliano@vilchez.com',300,0),
				   (2,2,'Viktoria','Legakis',12345678,'viktoria@legakis.com',200,0),
				   (2,1,'Nahuel','Sanabria',12345178,'noel@sanabria.com',100,0),
				   (2,4,'Julian','Schirmer',12345878,'julian@schirmer.com',400,0),
				   (1,1,'Minanda','Castolo',12356678,'castolo@pes.com',800,0),
				   (1,5,'Lionel Andres','Messi',10101010,'lio10@hotmail.com',1000,1),
				   (1,4,'Rene','Favaloro',1244565,'rene@favaloro.edu',8000,1),
				   (1,2,'Rosalind','Franklin',1111118,'la_rosalinda@franklin.com',10000,1);
			  		
INSERT INTO areas (wing_id,name,description)
			   VALUES(1, 'Animal Testing', 'All workers allowed'),
			  		 (1, 'Plant Testing', 'All workers allowed'),
			  		 (2, 'Human Testing', 'All workers allowed'),
			  		 (3, 'Bacteria Testing', 'Only Scientists allowed'),
			  		 (4, 'Fungi Testing', 'Only phd allowed');
		 
INSERT INTO tools (name) 
		   VALUES('Tweezers'),
		  	     ('Syringe'),
		  	     ('Urine cup'),
		  	     ('Stool cup'),
		  	     ('Scalpel');

INSERT INTO samples (name,tool_id)
			 VALUES('Urine', 3),
			       ('Blood', 2),
			       ('Hair', 1),
			       ('Stool', 4),
			       ('Muscle fiber', 5);
			      
INSERT INTO analyses (title,sample_id)
			  VALUES('Urine test', 1),
			 		('Common blood count', 2),
			 		('Deep blood test', 2),
			 		('Immune response', 2),
			 		('Calcium score' ,2),
			 		('Cancer marker', 2),
			 		('Hormone levels', 2),
			 		('Drugs', 3),
			 		('Vascular EcoDoppler', null),
			 		('Anaerobic gut flora ', 4),
			 		('Hydrogen espiration test', null),
			 		('Lactate blood concentration', 2),
			 		('Biopsy',5);
			 	
INSERT INTO testsubjects (name,class_id,health_risk_id) 
				  VALUES ('Human', 2, 1),
				         ('Mouse', 2, 1),
				         ('Rat', 2, 1),
				         ('Frog', 3, 1), 
				         ('Escherichia Choli', 1, 4),
				         ('Salmon', 5, 1),
				         ('Candida Albicans', 7, 4),
				         ('Candida Parapsilosis', 7, 4),
				         ('Digitalis Purpurea',10, 5),
				         ('Taragui', 11, 1),
				         ('MonkeyPox', 12, 4),
				         ('T7 Phage', 13, 1),
				         ('T4 Phage', 13, 1),
				         ('Blue-green algae', 9, 4),
				         ('Pigeon', 6, 1),
				         ('Cobra snake', 4, 5),
				         ('Bull frog', 3, 5);	 

INSERT INTO experiments (name,subject_id,substrate_id) 
				  VALUES('Fatigue resistance in Humans and Lactate treshold',1,3),
				 		('Fatigue resistance in Mice and Lactate treshold',2,3),
				 		('Fatigue resistance in Rats and Lactate treshold',3,3),
				 		('Fatigue resistance in Amphibians and Lactate treshold',4,3),
				 		('Fatigue resistance in Fish and Lactate treshold',6,3),
				 		('Fatigue resistance in Birds and Lactate treshold',6,3),
				 		('Anaerobic growth in presence of sugars and oxigen deprivation',15,3),
				 		('Phague proliferation on anaerobic colonies',12,5),
				 		('Venom snake diffusion speed in diabetic blood',13,3),
				 		('Fungi growth in presence of sugars and oxigen deprivation',7,3),
				 		('Type I and II fiber dominance in Bariloche Salmon',6,5),
				 		('Radiation treatment in folicullar thyroid adenocarcinoma',1,1),
				 		('Chronic low radiation exposure on QA Automation Engineers',1,2),
				 		('Monkeypox virus reaction to Justin Bieber music',11,5);

-- INTERMEDIATE TABLES		
 
INSERT INTO workersareas (worker_id,area_id) 
				   VALUES(1,1),(1,2),(1,3),
				   	     (2,1),(2,2),(2,3),
					     (3,1),(3,2),(3,3),
					     (4,1),(4,2),(4,3),
					     (5,1),(5,2),(5,3),(5,4),
					     (6,1),(6,2),(6,3),(6,4),(6,5),
					     (7,1),(7,2),(7,3),(7,4),(7,5),
					     (8,1),(8,2),(8,3),(8,4),(8,5);	
				 	
INSERT INTO experimentsanalyses(experiment_id,analysis_id) 
						VALUES (1,5),(1,12),
							   (2,5),(2,12),
							   (3,5),(3,12),
							   (4,5),(4,12),
							   (5,5),(5,12),
							   (6,5),(6,12),
							   (7,11),(7,10),
							   (8,4),
							   (9,9),(9,12),(9,5),(9,4),(9,3),
							   (10,1),(10,3),(10,4),
							   (11,13),
							   (12,1),(12,3),(12,4),(12,5),(12,6),(12,7),
							   (13,7),(13,4),(13,6);

INSERT INTO workersexperiments(worker_id,experiment_id) 
						VALUES(6,10),(7,10),(8,10),
							  (6,7),(7,7),(8,7),(5,7),
							  (6,8),(7,8),(8,8),(5,8),
							  (6,14),(7,14),(8,14),(5,14),
							  (1,1),(2,1),(3,1),
							  (1,9),(2,9),(3,9),(4,9),
							  (5,2),(6,2),(7,2),(1,2),
							  (2,3),(8,3),(7,3),(4,3),
							  (2,4),(3,4),
							  (5,5),(6,5),
							  (7,6),(1,6),(5,6),
							  (4,11),
							  (3,12),(1,12),
							  (2,13),(4,13),(6,13);
						
-- SELECT w.id,w2.id,w2.first_name ,a.id ,a.name, a.description  FROM workersareas w
-- INNER JOIN workers w2 ON w2.id = w.worker_id 
-- INNER JOIN areas a ON w.area_id = a.id ;

