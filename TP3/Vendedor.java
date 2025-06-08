public class Vendedor extends Persona {
    private String email;

    public Vendedor(String nombre, String apellido, String email) {
        super(nombre, apellido);
        this.email = email;
    }

    @Override
    public String toString() {
        return "Vendedor: " + super.toString() + " - Email: " + email;
    }
}
