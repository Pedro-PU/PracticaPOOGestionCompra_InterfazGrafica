package ec.edu.ups.poo.ventanasSolicitudes;

import ec.edu.ups.poo.clases.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class VentanaSolicitudCompra extends Frame {

    private TextField txtIdSolicitud, txtFecha, txtCodigoProducto, txtCantidad;
    private TextArea areaProductosAgregados;
    private List<Producto> productos;
    private List<ProductoAlimento> productosAlimento;
    private List<ProductoTecnologia> productosTecnologia;
    private List<SolicitudCompra> solicitudes;
    private List<ItemSolicitud> items;
    private Empleado empleadoActual;
    private Frame ventanaAnterior;

    public VentanaSolicitudCompra(Empleado solicitante, List<Producto> productos, List<SolicitudCompra> solicitudes,
                                  Frame ventanaAnterior) {
        this.ventanaAnterior = ventanaAnterior;
        this.productos = productos;
        this.solicitudes = solicitudes;
        this.items = new ArrayList<>();
        this.empleadoActual = solicitante;

        setTitle("Crear Solicitud de Compra");
        setSize(1500, 800);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setResizable(false);

        Color azul = new Color(87, 124, 178);

        // Título
        Label titulo = new Label("CREAR SOLICITUD DE COMPRA", Label.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 50));
        titulo.setForeground(Color.white);
        Panel panelSuperior = new Panel(new GridLayout(2,1));
        Panel panelSuperior2 = new Panel(new FlowLayout(FlowLayout.CENTER));
        panelSuperior.setPreferredSize(new Dimension(1500, 230));
        panelSuperior.setBackground(azul);
        panelSuperior.add(titulo);
        panelSuperior2.setBackground(Color.white);
        panelSuperior.add(panelSuperior2);
        add(panelSuperior, BorderLayout.NORTH);

        // Panel central
        Panel panelCentral = new Panel(new GridLayout(6, 1, 10, 10));

        // Panel ID
        Panel panelID = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label lblId = new Label("ID de Solicitud:");
        lblId.setFont(new Font("Arial", Font.PLAIN, 18));
        lblId.setPreferredSize(new Dimension(400, 30));
        txtIdSolicitud = new TextField();
        txtIdSolicitud.setFont(new Font("Arial", Font.PLAIN, 18));
        txtIdSolicitud.setPreferredSize(new Dimension(400, 30));
        panelID.add(lblId);
        panelID.add(txtIdSolicitud);

        // Panel Fecha
        Panel panelFecha = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label lblFecha = new Label("Fecha (yyyy-mm-dd):");
        lblFecha.setFont(new Font("Arial", Font.PLAIN, 18));
        lblFecha.setPreferredSize(new Dimension(400, 30));
        txtFecha = new TextField();
        txtFecha.setFont(new Font("Arial", Font.PLAIN, 18));
        txtFecha.setPreferredSize(new Dimension(400, 30));
        panelFecha.add(lblFecha);
        panelFecha.add(txtFecha);

        // Panel Código Producto
        Panel panelCodigo = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label lblCodigo = new Label("Código del Producto:");
        lblCodigo.setFont(new Font("Arial", Font.PLAIN, 18));
        lblCodigo.setPreferredSize(new Dimension(400, 30));
        txtCodigoProducto = new TextField();
        txtCodigoProducto.setFont(new Font("Arial", Font.PLAIN, 18));
        txtCodigoProducto.setPreferredSize(new Dimension(400, 30));
        panelCodigo.add(lblCodigo);
        panelCodigo.add(txtCodigoProducto);

        // Panel Cantidad
        Panel panelCantidad = new Panel(new FlowLayout(FlowLayout.CENTER));
        Label lblCantidad = new Label("Cantidad:");
        lblCantidad.setFont(new Font("Arial", Font.PLAIN, 18));
        lblCantidad.setPreferredSize(new Dimension(400, 30));
        txtCantidad = new TextField();
        txtCantidad.setFont(new Font("Arial", Font.PLAIN, 18));
        txtCantidad.setPreferredSize(new Dimension(400, 30));
        panelCantidad.add(lblCantidad);
        panelCantidad.add(txtCantidad);

        // Panel Botones
        Panel panelBotones = new Panel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        Button btnAgregar = new Button("Agregar Producto");
        btnAgregar.setFont(new Font("Arial", Font.PLAIN, 18));
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarItem();
            }
        });
        Button btnFinalizar = new Button("Finalizar Solicitud");
        btnFinalizar.setFont(new Font("Arial", Font.PLAIN, 18));
        btnFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarSolicitud();
            }
        });

        Button btnVolver = new Button("Volver");
        btnVolver.setFont(new Font("Arial", Font.PLAIN, 18));
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAnterior.setVisible(true);
                dispose();
            }
        });
        panelBotones.add(btnAgregar);
        panelBotones.add(btnFinalizar);
        panelBotones.add(btnVolver);

        panelCentral.add(panelID);
        panelCentral.add(panelFecha);
        panelCentral.add(panelCodigo);
        panelCentral.add(panelCantidad);
        panelCentral.add(panelBotones);

        add(panelCentral, BorderLayout.CENTER);

        // Área inferior
        areaProductosAgregados = new TextArea();
        areaProductosAgregados.setFont(new Font("Arial", Font.PLAIN, 16));
        areaProductosAgregados.setEditable(false);
        add(areaProductosAgregados, BorderLayout.SOUTH);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (ventanaAnterior != null) {
                    ventanaAnterior.setVisible(true);
                }
                dispose();
            }
        });

        setVisible(true);
    }

    private void agregarItem() {
        String codigo = txtCodigoProducto.getText().trim();
        String cantidadTexto = txtCantidad.getText().trim();

        if (codigo.isEmpty() || cantidadTexto.isEmpty()) {
            areaProductosAgregados.append("Debe ingresar código y cantidad.\n");
            return;
        }

        boolean esNumero = cantidadTexto.matches("\\d+");
        if (!esNumero) {
            areaProductosAgregados.append("Cantidad inválida (debe ser número).\n");
            return;
        }

        int cantidad = Integer.parseInt(cantidadTexto);
        Producto producto = buscarProducto(codigo);

        if (producto == null) {
            areaProductosAgregados.append("Producto no encontrado.\n");
            return;
        }

        ItemSolicitud item = new ItemSolicitud(producto, cantidad);
        items.add(item);
        areaProductosAgregados.append("Agregado: " + producto.getNombre() + " x " + cantidad + "\n");

        txtCodigoProducto.setText("");
        txtCantidad.setText("");
    }

    private void finalizarSolicitud() {
        String id = txtIdSolicitud.getText().trim();
        String fechaTexto = txtFecha.getText().trim();

        if (id.isEmpty() || fechaTexto.isEmpty()) {
            areaProductosAgregados.append("Debe ingresar ID y fecha.\n");
            return;
        }

        String[] partesFecha = fechaTexto.split("-");
        if (partesFecha.length != 3) {
            areaProductosAgregados.append("Formato de fecha inválido. Use yyyy-mm-dd.\n");
            return;
        }

        boolean fechaValida = true;
        for (String parte : partesFecha) {
            for (int i = 0; i < parte.length(); i++) {
                if (!Character.isDigit(parte.charAt(i))) {
                    fechaValida = false;
                    break;
                }
            }
            if (!fechaValida) break;
        }

        if (!fechaValida) {
            areaProductosAgregados.append("Fecha inválida. Use solo números.\n");
            return;
        }

        int anio = Integer.parseInt(partesFecha[0]);
        int mes = Integer.parseInt(partesFecha[1]) - 1;
        int dia = Integer.parseInt(partesFecha[2]);

        GregorianCalendar fecha = new GregorianCalendar(anio, mes, dia);

        SolicitudCompra solicitud = empleadoActual.crearSolicitud(id, fecha, items);
        solicitudes.add(solicitud);

        areaProductosAgregados.append("Solicitud creada. Total: $" + solicitud.calcularTotal() + "\n");

        txtIdSolicitud.setText("");
        txtFecha.setText("");
        items = new ArrayList<>();
    }

    private Producto buscarProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }
}
