package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String nCedula;
    @Column
    private String nombre;
    private String apellido;
    private String numeroTelefono;
    private String direccion;
    private String correoElectronico;

    public Cliente() {
    }

    public Cliente(String nCedula, String nombre, String apellido, String numeroTelefono, String direccion, String correoElectronico) {
        this.nCedula = nCedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
    }

    public String getnCedula() {
        return nCedula;
    }

    public void setnCedula(String nCedula) {
        this.nCedula = nCedula;
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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
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
    public int hashCode() {
        int hash = 0;
        hash += (nCedula != null ? nCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.nCedula == null && other.nCedula != null) || (this.nCedula != null && !this.nCedula.equals(other.nCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nCedula=" + nCedula + ", nombre=" + nombre + ", apellido=" + apellido + ", numeroTelefono=" + numeroTelefono + ", direccion=" + direccion + ", correoElectronico=" + correoElectronico + '}';
    }

}
