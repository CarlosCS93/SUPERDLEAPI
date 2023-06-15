
package Entidades;


public class Persona {
    
    private long id;
    private String nombre;
    private String apellido;
    private long numeroTelefono;
    private String direccion;
    private String correoElectronico;
    
    
    public Persona (){
        
    }

    public Persona(long id, String nombre, String apellido, long numeroTelefono, String direccion, String correoElectronico) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(long numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", numeroTelefono=" + numeroTelefono + ", direccion=" + direccion + ", correoElectronico=" + correoElectronico + '}';
    }
    
    
    
}
