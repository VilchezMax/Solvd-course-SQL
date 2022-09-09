# DIAGRAM

![](https://github.com/VilchezMax/Solvd-course-SQL/blob/main/Science_Laboratory_DER.png)

**Science laboratory** 
Scientists and laboratory assistants who work with different expreriments and analysis
Task: Make text description of your DB entities and relationships



In the Science laboratory there are many entities but the main ones are:

- **Workers**:
	They have Roles (Scientist,Assistant) and a Seniority (Trainee,Jr,Sr,etc) with 1:1 relations on each table.
	They also can work in many areas, so as there are many Areas for Many workers, a WorkersAreas junction table is created.
	Also the Area has a 1:1 with LabWing table which specifies the location in the lab (North wing,South Wing,etc).
	Workers can also work in many experiments and Experiments can have many workers, so a WorkersExperiments bridge table is created.

- **Experiments**:
	They have 1 specific substrate per experiment(1:1) which can have a specific HealthRisk(1:1) associated
	(i.e. Iodine-131 is radioactive).
	Also an experiment can involve a subject testing which can be a human , rat, Streptococcus,etc. 
	These testSubject have a specific Class(Mammal,Amphibian,etc) (1:1) and each subect can carry 
	a specific HealthRisk too(1:1) (i.e. Bacteria can be infectious).
	Also each class corresponds to a Kingdom (Animal,Eukariot,Fungi,Plant)
	
- **Analyses**:
	This is a separate entity but can be a part of an experiment too, so as an experminet can have many analisis
	and an analysis can be a part of many experiments, an intermediate table ExperimentsAnalyses is formed.
	Every analisis has a Sample (M:1) to analyze and each sample has a Tool (1:1) for its obtaining.






# RELATIONS


|                           |  Relation |                 |
| :---                      |   :----:  |          ---:   |
| Workers.role_id           | M:1       | Roles.id        |
| Workers.seniority_id      | M:1       | Seniorities.id  |
| LabWings.id               | M:1       | Areas.wing_id   |
| Experiments.subject_id    | M:1       | TestSubjects.id |
| Experiments.substrate_id  | M:1       | Substrates.id   |
| Substrate.health_risk_id  | M:1       | HealthRisks.id  |
| TestSubject.health_risk_id| M:1       | HealthRisks.id  |
| TestSubject.class_id      | M:1       | Class.id        |
| Classes.kingdom_id        | M:1       | Kingdoms.id     |
| Classes.health_risk_id    | M:1       | HealthRisks.id  |
| Analyses.sample_id        | M:1       | Samples.id      |
| Samples.tool_id           | 1:1       | Tools.id        |


## INTERMEDIATE TABLES 


+ ### WorkersExperiments

|             |  Relation   |               |
| :---        |    :----:   |          ---: |
| WorkersExperiments.worker_id     | M:1 | Workers.id     |
| WorkersExperiments.experiment_id | M:1 | Experiments.id |

+ ### WorkersAreas

|             |  Relation   |               |
| :---        |    :----:   |          ---: |
| WorkersAreas.worker_id | M:1 | Workers.id |
| WorkersAreas.area_id   | M:1 | Areas.id   |

+ ### ExperimentsAnalyses

|             |  Relation   |               |
| :---        |    :----:   |          ---: |
| ExperimentsAnalyses.experiment_id | M:1 | Experiments.id |
| ExperimentsAnalyses.analysis_id   | M:1 | Analyses.id    |


