package ec.edu.ups.poo.ventanas;

import ec.edu.ups.poo.ventanasMain.VentanaGerenteCompras;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaProducto extends Frame {

    public VentanaProducto() {
        setTitle("Productos");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);

        // Título
        Label titulo = new Label("PRODUCTOS", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 64));
        add(titulo, BorderLayout.NORTH);

        // Panel Central
        Panel panelCentral = new Panel(new GridLayout(2, 1, 10, 10));

        // Panel para la opción "Producto Alimentos"
        Panel panelAlimentos = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Etiqueta Producto Alimentos
        Label etiquetaAlimentos = new Label("Producto Alimentos");
        etiquetaAlimentos.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaAlimentos.setPreferredSize(new Dimension(400, 30));

        // Botón Producto Alimentos
        Button botonAlimentos = new Button("Seleccionar");
        botonAlimentos.setFont(new Font("Arial", Font.PLAIN, 14));

        botonAlimentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaProductoAlimento ventanaProductoAlimento = new VentanaProductoAlimento(); // Abre la ventana específica para alimentos
                dispose(); // Oculta la ventana actual
            }
        });

        // Agregar etiqueta y botón al panel
        panelAlimentos.add(etiquetaAlimentos);
        panelAlimentos.add(botonAlimentos);
        panelCentral.add(panelAlimentos);

        // Panel para la opción "Producto Tecnología"
        Panel panelTecnologia = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Etiqueta Producto Tecnología
        Label etiquetaTecnologia = new Label("Producto Tecnología");
        etiquetaTecnologia.setFont(new Font("Arial", Font.PLAIN, 18));
        etiquetaTecnologia.setPreferredSize(new Dimension(400, 30));

        // Botón Producto Tecnología
        Button botonTecnologia = new Button("Seleccionar");
        botonTecnologia.setFont(new Font("Arial", Font.PLAIN, 14));

        botonTecnologia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Oculta la ventana actual
                VentanaProductoTecnologia ventanaProductoTecnologia = new VentanaProductoTecnologia();
                dispose();
            }
        });

        // Agregar etiqueta y botón al panel
        panelTecnologia.add(etiquetaTecnologia);
        panelTecnologia.add(botonTecnologia);
        panelCentral.add(panelTecnologia);

        // Agregar el panel central
        add(panelCentral, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                VentanaGerenteCompras ventanaGerente = new VentanaGerenteCompras();
                dispose();
            }
        });


        // Mostrar la ventana
        setVisible(true);
    }
}