
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    private int cantidadVentas;
    private double ventasTotales;
    
    @OneToOne
    private Inventario producto;

    public Ventas() {
    }

    public Ventas(Long id, Date fecha, int cantidadVentas, double ventasTotales, Inventario producto) {
        this.id = id;
        this.fecha = fecha;
        this.cantidadVentas = cantidadVentas;
        this.ventasTotales = ventasTotales;
        this.producto = producto;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public double getVentasTotales() {
        return ventasTotales;
    }

    public void setVentasTotales(double ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

    public Inventario getProducto() {
        return producto;
    }

    public void setProducto(Inventario producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ventas{" + "id=" + id + ", fecha=" + fecha + ", cantidadVentas=" + cantidadVentas + ", ventasTotales=" + ventasTotales + ", producto=" + producto + '}';
    }

    
    
}
