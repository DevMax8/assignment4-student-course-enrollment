package assignment_3.utils;

import assignment_3.exception.DatabaseOperationException;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    private static Properties loadProps() {
        try (InputStream in = DatabaseConnection.class.getClassLoader().getResourceAsStream("app.properties")) {
            if (in == null) throw new DatabaseOperationException("app.properties not found in resources (classpath)");
            Properties props = new Properties();
            props.load(in);
            return props;
        } catch (Exception e) {
            throw new DatabaseOperationException("Cannot load app.properties", e);
        }
    }

    public static Connection getConnection() {
        try {
            Properties p = loadProps();
            String url = p.getProperty("db.url");
            String user = p.getProperty("db.user");
            String pass = p.getProperty("db.password");
            return DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            throw new DatabaseOperationException("DB connection failed: " + e.getMessage(), e);
        }
    }
}
