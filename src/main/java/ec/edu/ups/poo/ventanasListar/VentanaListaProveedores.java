package ec.edu.ups.poo.ventanasListar;

import ec.edu.ups.poo.clases.Proveedor;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class VentanaListaProveedores extends Frame {
    private TextArea textArea;
    private List<Proveedor> proveedores;

    public VentanaListaProveedores(List<Proveedor> proveedores) {
        this.proveedores = proveedores;
        Color azul = new Color(87, 124, 178);

        Label titulo = new Label("LISTA DE PROVEEDORES", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 30));
        titulo.setForeground(Color.white);
        setSize(400, 220);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Panel superior
        Panel panelSuperior = new Panel(new GridLayout(2,1));
        Panel panelSuperior2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelSuperior.setBackground(azul);
        panelSuperior2.setBackground(Color.white);
        panelSuperior.add(panelSuperior2);
        add(panelSuperior);

        // Crear TextArea para mostrar proveedores
        textArea = new TextArea(10, 40);
        textArea.setEditable(false);
        add(textArea);
        mostrarProveedores();

        setVisible(true);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    private void mostrarProveedores() {
        if (proveedores.isEmpty()) {
            textArea.setText("No hay proveedores registrados.");
            return;
        }

        StringBuilder lista = new StringBuilder();
        for (Proveedor proveedor : proveedores) {
            lista.append("ID: ").append(proveedor.getIdPersona()).append(" | ")
                    .append("Nombre: ").append(proveedor.getNombre()).append(" | ")
                    .append("Rubro: ").append(proveedor.getRubro()).append("\n");
        }

        textArea.setText(lista.toString());
    }
}
