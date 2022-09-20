USE science_laboratory;


ALTER TABLE workers 
	ADD published_articles TINYINT DEFAULT 0;

ALTER TABLE testsubjects 
	ADD alias VARCHAR(39);

ALTER TABLE testsubjects 
	DROP COLUMN alias;

ALTER TABLE workers
	MODIFY COLUMN published_articles INTEGER DEFAULT 0;

ALTER TABLE workers
	ADD birth_date DATE NOT NULL DEFAULT '1970-01-01'
	AFTER id_number;



	