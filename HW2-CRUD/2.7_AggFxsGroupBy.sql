USE science_laboratory;

SELECT c.name AS 'Class', COUNT(ts.id) AS 'N° of Test Subjects'
FROM testsubjects ts
INNER JOIN classes c ON c.id = ts.class_id 
GROUP BY ts.class_id;


SELECT r.name AS 'Role', MAX(wage) AS 'Max wage'
FROM workers
INNER JOIN roles r ON workers.role_id = r.id 
GROUP BY role_id;

SELECT r.name AS 'Role', SUM(phd) AS 'N° PhD Scientists'
FROM workers w
INNER JOIN roles r ON w.role_id = r.id 
GROUP BY role_id;

SELECT 
	CASE
		WHEN w.phd = 0 THEN 'No'
		WHEN w.phd = 1 THEN 'Yes'
	END
	AS 'Has PhD',
	ROUND(AVG(wage),0) AS 'Average wage' 
FROM workers w
GROUP BY w.phd ;
