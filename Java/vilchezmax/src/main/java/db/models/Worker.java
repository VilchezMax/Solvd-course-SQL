package db.models;

public class Worker {
    private Long id;
    private Role role;
    private Seniority seniority;
    private String firstName;
    private String lastName;
    private Long idNumber;
    private String email;
    private Long wage;
    private boolean phd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Seniority getSeniority() {
        return seniority;
    }

    public void setSeniority(Seniority seniority) {
        this.seniority = seniority;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(Long idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getWage() {
        return wage;
    }

    public void setWage(Long wage) {
        this.wage = wage;
    }

    public boolean isPhd() {
        return phd;
    }

    public void setPhd(boolean phd) {
        this.phd = phd;
    }
}
