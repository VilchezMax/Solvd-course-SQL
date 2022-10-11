package db.models;


public enum Entities { //Worker is the class with complete data.
    ANALYSIS(db.models.Analysis.class),
    AREA(db.models.Area.class),
    CLASS(db.models.Class.class),
    EXPERIMENT(db.models.Experiment.class),
    HEALTHRISK(db.models.HealthRisk.class),
    KINGDOM(db.models.Kingdom.class),
    LABWING(db.models.LabWing.class),
    ROLE(db.models.Role.class),
    SAMPLE(db.models.Sample.class),
    SENIORITY(db.models.Seniority.class),
    SUBSTRATE(db.models.Substrate.class),
    TESTSUBJECT(db.models.TestSubject.class),
    TOOL(db.models.Tool.class),
    WORKER(db.models.Worker.class);

    java.lang.Class clazz;


    private Entities(java.lang.Class clazz) {
        this.clazz = clazz;
    }

    public java.lang.Class getClassValue() {
        return clazz;
    }

    @Override
    public String toString() {
        return clazz.getName();
    }
}


