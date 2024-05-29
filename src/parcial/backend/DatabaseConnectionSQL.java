package parcial.backend;

public class DatabaseConnectionSQL {

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

        private static final Logger logger = Logger.getLogger(DatabaseConnectionSQL.class.getName());
        private static final String URL = "jdbc:mysql://localhost:3306/clinica_veterinaria";
        private static final String USER = "root";
        private static final String PASSWORD = "password";

        private static Connection connection;

        static {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                logger.info("Conexión a la base de datos establecida con éxito.");
            } catch (SQLException e) {
                logger.severe("Error al conectar a la base de datos: " + e.getMessage());
            }
        }

        public static Connection getConnection() {
            return connection;
        }
    }

