USE science_laboratory;

SELECT w.first_name , r.name 
FROM workers w 
LEFT JOIN roles r ON w.role_id = r.id ;


SELECT w.first_name, w.last_name ,w.wage  , s.name AS 'seniority'
FROM workers w 
RIGHT JOIN seniorities s  ON w.seniority_id  = s.id 
ORDER BY wage;


SELECT a.title AS 'Analysis', s.name AS 'Sample', t.name AS 'Tool'
FROM analyses a 
RIGHT JOIN samples s ON a.sample_id = s.id 
RIGHT JOIN tools t ON s.tool_id = t.id ;


SELECT ts.name AS 'Hazards', hr.name AS 'Health risk'
FROM testsubjects ts
INNER JOIN healthrisks hr ON ts.health_risk_id = hr.id 

UNION ALL 

SELECT s.name, h.name 
FROM substrates s 
INNER JOIN healthrisks h ON h.id = s.health_risk_id ;

