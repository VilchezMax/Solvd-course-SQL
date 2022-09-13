USE science_laboratory;

SELECT w.first_name , w.last_name , MAX(wage) AS 'Max Wage'
FROM workers w 
GROUP BY seniority_id  
HAVING AVG(w.wage) > 200;

SELECT e.name AS 'Experiment', s.name AS 'Substrate', t.id AS 'testsubjest ID'
FROM experiments e 
INNER JOIN substrates s ON e.substrate_id = s.id
INNER JOIN testsubjects t ON e.subject_id = t.id
INNER JOIN healthrisks h ON s.health_risk_id = h.id  AND t.health_risk_id = h.id 
GROUP BY subject_id  
HAVING COUNT(h.id)>1;

SELECT w2.first_name , w2.last_name , a.name , l.name 
FROM workersareas w 
LEFT JOIN areas a ON a.id = w.area_id 
INNER JOIN labwings l ON  a.wing_id = l.id 
RIGHT JOIN workers w2 ON w2.id = w.worker_id 
GROUP BY area_id  
HAVING COUNT(l.id)>2;


 