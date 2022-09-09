USE science_laboratory;


ALTER TABLE workers 
	ADD published_articles TINYINT DEFAULT 0;

ALTER TABLE testsubjects 
	ADD alias VARCHAR(39);

ALTER TABLE testsubjects 
	DROP COLUMN alias;

ALTER TABLE workers
	MODIFY COLUMN published_articles INTEGER DEFAULT 0;


	