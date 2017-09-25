package services;

import utils.PropertiesHolder;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionService {
    public static Connection createConnection() {
        Connection connection = null;

        try {
            Class.forName(PropertiesHolder.getProperty("jdbc.driverClassName"));
            connection = DriverManager.getConnection(PropertiesHolder.getProperty("jdbc.url"),
                    PropertiesHolder.getProperty("jdbc.username"), PropertiesHolder.getProperty("jdbc.password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
