package db.connection;

public enum Connections {
    LOCAL("com.mysql.cj.jdbc.Driver",
            "science_laboratory",
            "root",
            "",
            "jdbc:mysql",
            "localhost:8888/",
            "?useUnicode=true&use"
                    + "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
                    + "serverTimezone=UTC"),

    REMOTE("remote.Driver",
            "remote_remote",
            "remote",
            "remote123",
            "https",
            "remote:3306",
            "?remote1&remote2"
    );

    private String driver;
    private String dbName;
    private String user;
    private String password;
    private String protocol;
    private String host;
    private String properties;


    Connections(String driver, String dbName, String user, String password, String protocol, String host, String properties) {
        this.driver = driver;
        this.dbName = dbName;
        this.user = user;
        this.password = password;
        this.protocol = protocol;
        this.host = host;
        this.properties = properties;
    }

    public String getDriver() {
        return driver;
    }

    public String getDbName() {
        return dbName;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHost() {
        return host;
    }

    public String getProperties() {
        return properties;
    }


    public String getURL() {
        return this.protocol + "://" + this.host + this.dbName + this.properties;
    }

    public String getURLWithCredentials() {
        return this.protocol + "://" + this.host + this.dbName
                + "?user=" + user
                + "&password=" + password;
    }
}
