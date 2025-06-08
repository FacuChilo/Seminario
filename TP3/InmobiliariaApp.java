import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InmobiliariaApp {
    static ArrayList<Propiedad> propiedades = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InmobiliariaApp().crearGUI());
    }

    private void crearGUI() {
        JFrame frame = new JFrame("Inmobiliaria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnAgregar = new JButton("Agregar propiedad");
        JButton btnVer = new JButton("Ver propiedades");
        JButton btnSalir = new JButton("Salir");

        panel.add(btnAgregar);
        panel.add(btnVer);
        panel.add(btnSalir);

        frame.add(panel);
        frame.setVisible(true);

        btnAgregar.addActionListener(e -> mostrarFormularioPropiedad(frame));
        btnVer.addActionListener(e -> mostrarPropiedades(frame));
        btnSalir.addActionListener(e -> {
            frame.dispose();
            System.exit(0);
        });
    }

    private void mostrarFormularioPropiedad(JFrame padre) {
        JDialog dialog = new JDialog(padre, "Agregar propiedad", true);
        dialog.setSize(400, 450);
        dialog.setLocationRelativeTo(padre);
        dialog.setLayout(new GridLayout(11, 2, 5, 5));

        JTextField direccionField = new JTextField();
        JTextField ciudadField = new JTextField();
        JTextField precioField = new JTextField();

        JTextField vNombreField = new JTextField();
        JTextField vApellidoField = new JTextField();
        JTextField emailField = new JTextField();

        JTextField pNombreField = new JTextField();
        JTextField pApellidoField = new JTextField();
        JTextField telefonoField = new JTextField();

        dialog.add(new JLabel("Dirección:"));
        dialog.add(direccionField);
        dialog.add(new JLabel("Ciudad:"));
        dialog.add(ciudadField);
        dialog.add(new JLabel("Precio:"));
        dialog.add(precioField);

        dialog.add(new JLabel("Datos del vendedor"));
        dialog.add(new JLabel("")); // espacio

        dialog.add(new JLabel("Nombre:"));
        dialog.add(vNombreField);
        dialog.add(new JLabel("Apellido:"));
        dialog.add(vApellidoField);
        dialog.add(new JLabel("Email:"));
        dialog.add(emailField);

        dialog.add(new JLabel("Datos del propietario"));
        dialog.add(new JLabel("")); // espacio

        dialog.add(new JLabel("Nombre:"));
        dialog.add(pNombreField);
        dialog.add(new JLabel("Apellido:"));
        dialog.add(pApellidoField);
        dialog.add(new JLabel("Teléfono:"));
        dialog.add(telefonoField);

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        dialog.add(btnGuardar);
        dialog.add(btnCancelar);

        btnGuardar.addActionListener(e -> {
            try {
                String direccion = direccionField.getText().trim();
                String ciudad = ciudadField.getText().trim();
                double precio = Double.parseDouble(precioField.getText().trim());

                String vNombre = vNombreField.getText().trim();
                String vApellido = vApellidoField.getText().trim();
                String email = emailField.getText().trim();

                String pNombre = pNombreField.getText().trim();
                String pApellido = pApellidoField.getText().trim();
                String telefono = telefonoField.getText().trim();

                if (direccion.isEmpty() || ciudad.isEmpty() || vNombre.isEmpty() || vApellido.isEmpty() ||
                    email.isEmpty() || pNombre.isEmpty() || pApellido.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(dialog, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Vendedor vendedor = new Vendedor(vNombre, vApellido, email);
                Propietario propietario = new Propietario(pNombre, pApellido, telefono);
                Propiedad propiedad = new Propiedad(direccion, ciudad, precio, vendedor, propietario);

                propiedades.add(propiedad);
                JOptionPane.showMessageDialog(dialog, "Propiedad agregada correctamente.");
                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "El precio debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnCancelar.addActionListener(e -> dialog.dispose());

        dialog.setVisible(true);
    }

    private void mostrarPropiedades(JFrame padre) {
        if (propiedades.isEmpty()) {
            JOptionPane.showMessageDialog(padre, "No hay propiedades registradas.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (Propiedad p : propiedades) {
            sb.append(p.toString()).append("\n\n");
        }

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JDialog dialog = new JDialog(padre, "Propiedades", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(padre);
        dialog.setLayout(new BorderLayout());
        dialog.add(scrollPane, BorderLayout.CENTER);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> dialog.dispose());
        dialog.add(btnCerrar, BorderLayout.SOUTH);

        dialog.setVisible(true);
    }
}
