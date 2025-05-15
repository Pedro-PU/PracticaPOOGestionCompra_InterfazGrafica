package ec.edu.ups.poo.clases;

import ec.edu.ups.poo.enums.EstadoSolicitud;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Empleado extends Persona {
    private String cedula;
    private String cargo;
    private Departamento departamento;
    private List<SolicitudCompra> solicitudes;

    //Constructor
    public Empleado() {
        this.solicitudes = new ArrayList<>();
    }
    public Empleado(String idPersona, String nombre, String correo, String cedula, String cargo, Departamento departamento) {
        super(idPersona, nombre, correo);
        this.cedula = cedula;
        this.cargo = cargo;
        this.departamento = departamento;
        this.solicitudes = new ArrayList<>();
    }

    //Getter y setters
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<SolicitudCompra> getSolicitudes() {
        return solicitudes;
    }
    public void setSolicitudes(List<SolicitudCompra> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public SolicitudCompra crearSolicitud(String idSolicitud, GregorianCalendar fecha, List<ItemSolicitud> items) {
        SolicitudCompra solicitud = new SolicitudCompra(idSolicitud, fecha, this);
        for (ItemSolicitud item : items) {
            // Extrae el producto y la cantidad para agregar el ítem correctamente
            solicitud.agregarItem(item.getProducto(), item.getCantidad());
        }
        this.solicitudes.add(solicitud);// Guarda la solicitud en el historial del empleado
        return solicitud;
    }

    public void aceptaSolicitud(SolicitudCompra solicitud) {
        if(solicitud.getEstado() == EstadoSolicitud.PENDIENTE){
            solicitud.aprobar(this);
            System.out.println("Solicitud aprovada");
        } else {
            System.out.println("La solicitud ya fue aprobada o rechazada.");
        }
    }

    public void rechazarSolicitud(SolicitudCompra solicitud) {
        if(solicitud.getEstado() == EstadoSolicitud.PENDIENTE){
            solicitud.rechazar(this);
            System.out.println("Solicitud rechazada");
        } else {
            System.out.println("La solicitud ya fue aprobada o rechazada.");
        }
    }

    //toString
    @Override
    public String toString() {
        return getNombre() + " - " + cargo + " ( " + departamento.getNombre() + ")";
    }
}