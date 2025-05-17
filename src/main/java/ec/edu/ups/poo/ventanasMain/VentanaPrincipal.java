package ec.edu.ups.poo.ventanasMain;

import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends Frame {

    public VentanaPrincipal() {
        setTitle("GESTIÓN DE COMPRAS");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Título superior
        Label titulo = new Label("DEPARTAMENTO", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 64));
        add(titulo, BorderLayout.NORTH);

        // Panel central con botones
        Panel panelCentral = new Panel(new GridLayout(2, 1, 10, 10));
        panelCentral.setBackground(Color.WHITE);
        panelCentral.setFont(new Font("Arial", Font.PLAIN, 16));

        // Analista
        Panel filaAnalista = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        Label lblAnalista = new Label("Analista de Compras");
        lblAnalista.setFont(new Font("Arial", Font.PLAIN, 18));
        Button btnAnalista = new Button("Seleccionar");
        btnAnalista.setFont(new Font("Arial", Font.PLAIN, 14));
        btnAnalista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaAnalistaCompras Va = new VentanaAnalistaCompras();
                setVisible(false);
            }
        });
        filaAnalista.add(lblAnalista);
        filaAnalista.add(btnAnalista);

        // Gerente
        Panel filaGerente = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        Label lblGerente = new Label("Gerente de Compras");
        lblGerente.setFont(new Font("Arial", Font.PLAIN, 18));
        Button btnGerente = new Button("Seleccionar");
        btnGerente.setFont(new Font("Arial", Font.PLAIN, 14));
        btnGerente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaGerenteCompras Vg = new VentanaGerenteCompras();
                setVisible(false);
            }
        });

        filaGerente.add(lblGerente);
        filaGerente.add(btnGerente);

        // Agregar las filas al panel central
        panelCentral.add(filaAnalista);
        panelCentral.add(filaGerente);

        // Agregar panel central al centro
        add(panelCentral, BorderLayout.CENTER);

        // Pie de página
        Label autores = new Label("Pedro Pesántez, Jonnathan Saavedra, Mathias Añazco", Label.CENTER);
        autores.setFont(new Font("Arial", Font.ITALIC, 12));
        add(autores, BorderLayout.SOUTH);

        // Evitar que la ventana sea redimensionada
        setResizable(false);

        // Cerrar correctamente
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }
}