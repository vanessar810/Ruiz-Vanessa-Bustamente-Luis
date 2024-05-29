package parcial.backend;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class VeterinarioDAO implements VeterinarioDAOInterface {
    private static final Logger logger = Logger.getLogger(VeterinarioDAO.class.getName());
    private Connection connection;

    public VeterinarioDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void guardarVeterinario(Veterinario veterinario) {
        String query = "INSERT INTO veterinarios (numero_licencia, nombre, apellido, especialidad) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.Integer(1, veterinario.getNumeroLicencia());
            statement.setString(2, veterinario.getNombre());
            statement.setString(3, veterinario.getApellido());
            statement.setString(4, veterinario.getEspecialidad());
            statement.executeUpdate();
            logger.info("Veterinario guardado con éxito: " + veterinario.getNumeroLicencia());
        } catch (SQLException e) {
            logger.severe("Error guardando veterinario: " + e.getMessage());
        }
    }

    public List<Veterinario> listarVeterinarios() {
        List<Veterinario> veterinarios = new ArrayList<>();
        String query = "SELECT * FROM veterinarios";
        try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Veterinario veterinario = new Veterinario();
                veterinario.setNumeroLicencia(resultSet.getInteger("numero_licencia"));
                veterinario.setNombre(resultSet.getString("nombre"));
                veterinario.setApellido(resultSet.getString("apellido"));
                veterinario.setEspecialidad(resultSet.getString("especialidad"));
                veterinarios.add(veterinario);
            }
            logger.info("Veterinarios listados con éxito");
        } catch (SQLException e) {
            logger.severe("Error listando veterinarios: " + e.getMessage());
        }
        return veterinarios;
    }
}
