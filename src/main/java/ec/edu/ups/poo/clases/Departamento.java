package ec.edu.ups.poo.clases;

public class Departamento {
    private String id;
    private String nombre;

    //Constructor
    public Departamento(){}
    public Departamento(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    //Getters y setter
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
