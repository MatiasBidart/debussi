package com.debussi.commandline;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DatabaseConnection {
    @Value("${spring.datasource.url}")
    private String dbHost;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Value("${spring.datasource.driver-class-name}")
    private String dbDriver;

    public Connection connect() {
        Connection connection = null;

        try {
            // Registrar el driver de PostgreSQL
            Class.forName(dbDriver);

            // Establecer la conexión
            connection = DriverManager.getConnection(dbHost, dbUser, dbPassword);

            System.out.println("Conexión exitosa a PostgreSQL");

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado: " + e.getMessage());
        }

        return connection;
    }

    public void testConnection() {
        try (Connection conn = connect()) {
            if (conn != null) {
                System.out.println("La conexión está activa.");
            } else {
                System.out.println("La conexión no se pudo establecer.");
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}
