package ec.edu.ups.poo.clases;

public class Persona {
    private String idPersona;
    private String nombre;
    private String correo;

    //Constructor
    public Persona() {
    }

    public Persona(String idPersona, String nombre, String correo) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.correo = correo;
    }

    //Getters y Setters
    public String getIdPersona() {
        return idPersona;
    }
    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //toString
    @Override
    public String toString() {
        return "Persona{" +
                "idPersona='" + idPersona + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
