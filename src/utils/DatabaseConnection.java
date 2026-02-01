package assignment_3.utils;

import assignment_3.exception.DatabaseOperationException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class DatabaseConnection {

    private static final String PROPS_FILE = "app.properties";
    private static final Properties PROPS = loadProperties();

    private DatabaseConnection() {}

    public static Connection getConnection() {
        String url = require("db.url");
        String user = require("db.user");
        String password = PROPS.getProperty("db.password", "");
        String driver = PROPS.getProperty("db.driver", "org.postgresql.Driver");

        // Driver бар-жоғын тексеру (сендегі "No suitable driver" осыдан)
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            throw new DatabaseOperationException(
                    "PostgreSQL JDBC driver табылмады: " + driver +
                            ". postgresql-*.jar dependency ретінде қосылғанын тексер.",
                    e
            );
        }

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new DatabaseOperationException("DB connection failed: url=" + url + ", user=" + user, e);
        }
    }

    private static Properties loadProperties() {
        try (InputStream is = DatabaseConnection.class.getClassLoader().getResourceAsStream(PROPS_FILE)) {
            if (is == null) {
                throw new DatabaseOperationException("Файл табылмады: resources/" + PROPS_FILE);
            }
            Properties p = new Properties();
            p.load(is);
            return p;
        } catch (Exception e) {
            if (e instanceof DatabaseOperationException) throw (DatabaseOperationException) e;
            throw new DatabaseOperationException("app.properties оқу қатесі", e);
        }
    }

    private static String require(String key) {
        String val = PROPS.getProperty(key);
        if (val == null || val.isBlank()) {
            throw new DatabaseOperationException("app.properties ішінде '" + key + "' толтырылмаған");
        }
        return val.trim();
    }
}
