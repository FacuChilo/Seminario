public class Propietario extends Persona {
    private String telefono;

    public Propietario(String nombre, String apellido, String telefono) {
        super(nombre, apellido);
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Propietario: " + super.toString() + " - Teléfono: " + telefono;
    }
}
