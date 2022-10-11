package db.jdbc;

public enum Connections {
    LOCAL("src/main/resources/db.properties"),
    REMOTE("src/main/resources/remotedb.properties");

    private String propertiesPath;

    Connections(String s) {
        this.propertiesPath = s;
    }

    public String value() {
        return this.propertiesPath;
    }
}


