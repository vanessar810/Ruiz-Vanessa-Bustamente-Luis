package parcial.backend;

import java.util.List;

public interface VeterinarioDAOInterface {
    void guardarVeterinario(Veterinario veterinario);
    List<Veterinario> listarVeterinarios();
}
