package db.models;

public class TestSubject {
    private Long id;
    private String name;
    private Class clazz;
    private HealthRisk healthRisk;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public HealthRisk getHealthRisk() {
        return healthRisk;
    }

    public void setHealthRisk(HealthRisk healthRisk) {
        this.healthRisk = healthRisk;
    }
}
