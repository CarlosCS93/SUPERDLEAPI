package Entidades;

import java.io.Serializable;
import java.util.Scanner;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class Inventario implements Serializable {

    @Id
    private Integer codigo;

    private String nombre_producto;
    private int cantidad;
    private double precio_compra;
    private double precio_venta;
    private String categoria;

    public Inventario() {

    }

    public Inventario(Integer codigo, String nombre_producto, int cantidad, double precio_compra, double precio_venta, String categoria) {
        this.codigo = codigo;
        this.nombre_producto = nombre_producto;
        this.cantidad = cantidad;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.categoria = categoria;

    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Inventario{" + "codigo=" + codigo + ", nombre_producto=" + nombre_producto + ", cantidad=" + cantidad + ", precio_compra=" + precio_compra + ", precio_venta=" + precio_venta + ", categoria=" + categoria + '}';
    }

}
