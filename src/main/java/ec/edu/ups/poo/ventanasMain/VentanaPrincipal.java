package ec.edu.ups.poo.ventanasMain;

import java.awt.*;
import java.awt.event.*;
import ec.edu.ups.poo.clases.*;
import java.util.List;

public class VentanaPrincipal extends Frame {
    private Empleado empleadoAnalista;
    private Empleado empleadoGerente;
    private List<Producto> productos;
    private List<SolicitudCompra> solicitudes;
    private List<Proveedor> proveedores;
    private List<ProductoAlimento> productosAlimento;
    private List<ProductoTecnologia> productosTecnologia;

    public VentanaPrincipal(Empleado empleadoAnalista, Empleado empleadoGerente,
                            List<Producto> productos, List<SolicitudCompra> solicitudes,
                            List<Proveedor> proveedores, List<ProductoAlimento> productosAlimento,
                            List<ProductoTecnologia> productosTecnologia) {

        this.empleadoAnalista = empleadoAnalista;
        this.empleadoGerente = empleadoGerente;
        this.productos = productos;
        this.solicitudes = solicitudes;
        this.proveedores = proveedores;
        this.productosAlimento = productosAlimento;
        this.productosTecnologia = productosTecnologia;

        Color azul = new Color(87, 124, 178);

        setTitle("GESTIÓN DE COMPRAS");
        setSize(1500, 800);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Título superior
        Label titulo = new Label("DEPARTAMENTO", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 64));
        titulo.setForeground(Color.white);
        Panel panelTitulo = new Panel(new GridLayout(2,1));
        Panel panelTitulo2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelTitulo2.setBackground(Color.white);
        panelTitulo.setPreferredSize(new Dimension(1500, 270));
        panelTitulo.setBackground(azul);
        panelTitulo.add(titulo);
        panelTitulo.add(panelTitulo2);
        add(panelTitulo, BorderLayout.NORTH);

        // Panel central con botones
        Panel panelCentral = new Panel(new GridLayout(2, 1, 10, 10));
        panelCentral.setBackground(Color.WHITE);
        panelCentral.setFont(new Font("Arial", Font.PLAIN, 16));

        // Analista
        Panel filaAnalista = new Panel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        Label lblAnalista = new Label("Analista de compras");
        Label lblSolicitud = new Label("SOLICITUDES");
        lblSolicitud.setFont(new Font("Arial", Font.BOLD, 18));
        lblAnalista.setFont(new Font("Arial", Font.PLAIN, 15));
        lblAnalista.setForeground(Color.lightGray);
        Button btnAnalista = new Button("Seleccionar");
        btnAnalista.setFont(new Font("Arial", Font.PLAIN, 14));
        btnAnalista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaAnalistaCompras(VentanaPrincipal.this, empleadoAnalista, productos, solicitudes);
                setVisible(false);
            }
        });
        filaAnalista.add(lblSolicitud);
        filaAnalista.add(lblAnalista);
        filaAnalista.add(btnAnalista);

        // Gerente
        Panel filaGerente = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        Label lblGerente = new Label("Gerente de compras");
        Label lblGerencia = new Label("GERENCIA");
        lblGerencia.setFont(new Font("Arial", Font.BOLD, 18));
        lblGerente.setFont(new Font("Arial", Font.PLAIN, 15));
        lblGerente.setForeground(Color.lightGray);
        Button btnGerente = new Button("Seleccionar");
        btnGerente.setFont(new Font("Arial", Font.PLAIN, 14));
        btnGerente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VentanaGerenteCompras(VentanaPrincipal.this, empleadoGerente, productos, solicitudes,
                        proveedores, productosAlimento, productosTecnologia);
                setVisible(false);
            }
        });
        filaGerente.add(lblGerencia);
        filaGerente.add(lblGerente);
        filaGerente.add(btnGerente);

        // Agregar las filas al panel central
        panelCentral.add(filaAnalista);
        panelCentral.add(filaGerente);

        // Agregar panel central al centro
        add(panelCentral, BorderLayout.CENTER);

        // Pie de página
        Panel pie = new Panel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Label autores = new Label("Desarrollado por: Pedro Pesántez, Jonnathan Saavedra y Mathias Añazco", Label.CENTER);
        autores.setFont(new Font("Arial", Font.ITALIC, 12));
        autores.setBackground(Color.lightGray);
        pie.add(autores);
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
