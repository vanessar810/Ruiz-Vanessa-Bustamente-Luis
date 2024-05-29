package parcial.backend;

public class Veterinario {
        private Integer numeroLicencia;
        private String nombre;
        private String apellido;
        private String especialidad;

        // Getters y setters
        public Integer getNumeroLicencia() {
            return numeroLicencia;
        }

        public void setNumeroLicencia(Integer numeroLicencia) {
            this.numeroLicencia = numeroLicencia;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public String getEspecialidad() {
            return especialidad;
        }

        public void setEspecialidad(String especialidad) {
            this.especialidad = especialidad;
        }

    @Override
    public String toString() {
        return "Veterinario " +
                ", numeroLicencia=" + numeroLicencia +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", especialidad=" + especialidad;
    }
}
