package db.models;

import javax.security.auth.Subject;

public class Experiment {
    private Long id;
    private String name;
    private Subject subject;
    private Substrate substrate;
}
