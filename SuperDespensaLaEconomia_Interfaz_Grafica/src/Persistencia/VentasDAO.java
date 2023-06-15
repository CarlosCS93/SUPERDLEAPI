package Persistencia;

import Entidades.Ventas;

public class VentasDAO extends DAO<Ventas> {
    
    public void crearTransaccionVenta(Ventas venta) {
        
        super.guardar(venta);
    }

    public void modificador(Ventas venta) {
        super.modificar(venta);
    }
    
}
