import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.sql.*;
import java.util.List;

public class VeterinarioDAOTest {
    private static Connection connection;
    private VeterinarioDAO veterinarioDAO;

    @BeforeAll
    public static void setupDatabase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinica_veterinaria", "root", "password");
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS veterinarios (numero_licencia VARCHAR(50) NOT NULL PRIMARY KEY, nombre VARCHAR(100) NOT NULL, apellido VARCHAR(100) NOT NULL, especialidad VARCHAR(100) NOT NULL)");
    }

    @BeforeEach
    public void setup() {
        veterinarioDAO = new VeterinarioDAO(connection);
    }

    @Test
    public void testGuardarYListarVeterinario() {
        Veterinario vet1 = new Veterinario();
        vet1.setNumeroLicencia("12345");
        vet1.setNombre("Juan");
        vet1.setApellido("Pérez");
        vet1.setEspecialidad("Cirugía");

        Veterinario vet2 = new Veterinario();
        vet2.setNumeroLicencia("67890");
        vet2.setNombre("Ana");
        vet2.setApellido("García");
        vet2.setEspecialidad("Dermatología");

        veterinarioDAO.guardarVeterinario(vet1);
        veterinarioDAO.guardarVeterinario(vet2);

        List<Veterinario> veterinarios = veterinarioDAO.listarVeterinarios();
        assertEquals(2, veterinarios.size());

        Veterinario retrievedVet1 = veterinarios.get(0);
        assertEquals("12345", retrievedVet1.getNumeroLicencia());
        assertEquals("Juan", retrievedVet1.getNombre());
        assertEquals("Pérez", retrievedVet1.getApellido());
        assertEquals("Cirugía", retrievedVet1.getEspecialidad());

        Veterinario retrievedVet2 = veterinarios.get(1);
        assertEquals("67890", retrievedVet2.getNumeroLicencia());
        assertEquals("Ana", retrievedVet2.getNombre());
        assertEquals("García", retrievedVet2.getApellido());
        assertEquals("Dermatología", retrievedVet2.getEspecialidad());
    }

    @AfterAll
    public static void tearDownDatabase() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE veterinarios");
        connection.close();
    }
}

