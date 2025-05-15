package ec.edu.ups.poo.clases;

import ec.edu.ups.poo.enums.EstadoSolicitud;
import ec.edu.ups.poo.interfaces.Calculable;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

public class SolicitudCompra implements Calculable{
    private String idSolicitud;
    private GregorianCalendar fecha;
    private EstadoSolicitud estado;
    private Empleado solicitante;
    private Empleado aprobador;
    private List<ItemSolicitud> items;

    //Constructor
    public SolicitudCompra() {
        this.items = new ArrayList<>();
    }
    public SolicitudCompra(String idSolicitud, GregorianCalendar fecha, Empleado solicitante) {
        this.idSolicitud = idSolicitud;
        this.fecha = fecha;
        this.solicitante = solicitante;
        this.estado = EstadoSolicitud.PENDIENTE;
        this.items = new ArrayList<>();
    }

    //Getters y setters
    public String getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(String idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }

    public Empleado getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Empleado solicitante) {
        this.solicitante = solicitante;
    }

    public Empleado getAprobador() {
        return aprobador;
    }

    public void setAprobador(Empleado aprobador) {
        this.aprobador = aprobador;
    }

    public List<ItemSolicitud> getItems() {
        return items;
    }

    //Metodo que agrega itemsSolicitud
    public void agregarItem(Producto producto, int cantidad) {
        ItemSolicitud item = new ItemSolicitud(producto, cantidad); // Se crea el ítem dentro de SolicitudCompra
        items.add(item);
    }

    //Metodo que calcula el total
    @Override
    public double calcularTotal() {
        double total = 0;
        for (ItemSolicitud item : items) {
            total += item.calcularTotal();
        }
        return total;
    }

    //Metodo que aprueba la solicitud
    public void aprobar(Empleado aprobador) {
        this.estado = EstadoSolicitud.APROBADA;
        this.aprobador = aprobador;
    }

    //Metodo que rechaza la solicitud
    public void rechazar(Empleado aprobador) {
        this.estado = EstadoSolicitud.RECHAZADA;
        this.aprobador = aprobador;
    }


}