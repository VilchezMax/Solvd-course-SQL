USE science_laboratory;

DROP VIEW IF EXISTS vw_BigJoinWorkerTables;

CREATE VIEW vw_BigJoinWorkerTables AS
SELECT 
	lw.name AS 'Wing',
	ar.name AS 'Area',
	ar.description AS 'Activity',
	w.first_name AS 'First name',
	w.last_name AS 'Last name',
	id_number AS 'ID Number',
	rls.name AS 'Role',
	sty.name AS 'Seniority',
	w.email AS 'Email',
	w.wage AS 'Monthly Wage'
FROM 
	Workers w 
INNER JOIN Roles rls ON (w.role_id = rls.id) 
INNER JOIN Seniorities sty ON (w.seniority_id = sty.id) 
INNER JOIN workersareas w2  ON (w.id = w2.worker_id) 
INNER JOIN areas ar ON (ar.id = w2.area_id) 
INNER JOIN labwings lw ON (lw.id  = ar.wing_id)
ORDER BY lw.id DESC;

SELECT * FROM vw_BigJoinWorkerTables;




DROP VIEW IF EXISTS vw_BigJoinExperimentTables;

CREATE VIEW vw_BigJoinExperimentTables AS
SELECT
	e.name AS 'Experiment',
	a.title AS 'Analysis', 
	t2.name AS 'Test Subject',
	c.name AS 'Taxonomic class',
	k.name AS 'Taxonomic kingdom',
	s.name AS 'Sample needed',
	t.name AS 'Tool required',
	s2.name AS 'Substrate',
	h.name AS 'health risk'
	
FROM
	experiments e 
INNER JOIN experimentsanalyses e2 ON e2.experiment_id = e.id
INNER JOIN substrates s2 ON e.substrate_id = s2.id 
INNER JOIN testsubjects t2 ON e.subject_id = t2.id
INNER JOIN classes c ON t2.class_id = c.id 
INNER JOIN kingdoms k ON c.kingdom_id  = k.id 
INNER JOIN healthrisks h ON (t2.health_risk_id = h.id)  OR (s2.health_risk_id = h.id) 
INNER JOIN analyses a ON e2.analysis_id = a.id 
INNER JOIN samples s  ON a.sample_id = s.id 
INNER JOIN tools t  ON s.tool_id = t.id;

SELECT * FROM vw_BigJoinExperimentTables;

