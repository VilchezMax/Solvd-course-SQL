package db.jdbc;

public enum Connections {
    LOCAL("src/main/resources/db.properties"),
    REMOTE("src/main/resources/remotedb.properties");

    Connections(String s) {
    }

    private String propertiesPath;

    public String getPropertiesPath() {
        return propertiesPath;
    }
}


