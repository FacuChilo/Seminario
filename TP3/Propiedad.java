public class Propiedad {
    private String direccion;
    private String ciudad;
    private Vendedor vendedor;
    private Propietario propietario;
    private double precio;

    public Propiedad(String direccion, String ciudad, double precio, Vendedor vendedor, Propietario propietario) {
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.precio = precio;
        this.vendedor = vendedor;
        this.propietario = propietario;
    }

    @Override
    public String toString() {
        return "Propiedad en " + direccion + ", " + ciudad + " - $" + precio +
                "\n  " + vendedor +
                "\n  " + propietario;
    }
}
