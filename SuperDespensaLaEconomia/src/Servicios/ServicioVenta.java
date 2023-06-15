package Servicios;

import Entidades.Inventario;
import Entidades.Ventas;
import Persistencia.VentasDAO;
import java.util.Date;
import java.util.Scanner;

public class ServicioVenta {
    
    private final VentasDAO VDAO;
    private final Scanner scann = new Scanner(System.in).useDelimiter("\n");
    private static final Ventas venta = new Ventas();
    
    public ServicioVenta() {
        this.VDAO = new VentasDAO();
        
    }
    
    public void transaccionVenta() throws Exception {
        
        System.out.println("TRANSACCION ---> VENTA");
        System.out.print("PRODUCTO: ");
        String nombreProducto = scann.next();
        Inventario producto = buscarNombreProducto(nombreProducto);
        System.out.println("CANTIDAD DEL PRODUCTO");
        int cantidad = scann.nextInt();
        
        if (fechaVenta() && confirmarTranssacion(producto)) {
            ventaMismoProducto(producto, cantidad);
        } else {
            crearVenta(producto, cantidad);
        }
        
    }
    
    public boolean fechaVenta() {
        Date auxiliar = new Date();
        return !auxiliar.equals(venta.getFecha());
        
    }
    
    public Inventario buscarNombreProducto(String nombreProducto) throws Exception {
        ServicioInventario sdle = new ServicioInventario();
        return sdle.buscarProductoNombre(nombreProducto);
    }
    
    public void modificacionProducto(Inventario producto) throws Exception {
        ServicioInventario sdle = new ServicioInventario();
        sdle.modificacionGeneralProducto(producto);
    }
    
    public void crearVenta(Inventario producto, int cantidad) throws Exception {
        
        if (cantidadStockProducto(producto)) {
            
            venta.setFecha(new Date());
            venta.setCantidadVentas(cantidad);
            producto.setCantidad(producto.getCantidad() - venta.getCantidadVentas());
            modificacionProducto(producto);
            venta.setVentasTotales(venta.getCantidadVentas() * producto.getPrecio_venta());
            System.out.println("VALOR TOTAL $" + venta.getVentasTotales());
            venta.setProducto(producto);
            VDAO.crearTransaccionVenta(venta);
            
        } else if (producto.getCantidad() == 0) {
            System.out.println("Stock del producto en 0");
        } else {
            System.out.println("Cantidad de producto supera el stock en inventario");
        }
    }
    
    public void ventaMismoProducto(Inventario producto, int cantidad) throws Exception {
        
        if (cantidadStockProducto(producto)) {
            double auxiliar = venta.getVentasTotales();
            
            venta.setCantidadVentas(cantidad);
            producto.setCantidad(producto.getCantidad() - venta.getCantidadVentas());
            modificacionProducto(producto);
            venta.setVentasTotales(venta.getCantidadVentas() * producto.getPrecio_venta());
            System.out.println("VALOR TOTAL $" + venta.getVentasTotales());
            venta.setProducto(producto);
            venta.setVentasTotales(venta.getVentasTotales() + auxiliar);
            VDAO.modificador(venta);
            
        } else if (producto.getCantidad() == 0) {
            System.out.println("Stock del producto en 0");
        } else {
            System.out.println("Cantidad de producto supera el stock en inventario");
        }
    }
    
    public boolean confirmarTranssacion(Inventario producto) {
        
        try {
            return producto.getCodigo() == venta.getProducto().getCodigo();
            
        } catch (NullPointerException nu) {
            return Boolean.FALSE;
            
        }
        
    }
    
    public boolean cantidadStockProducto(Inventario producto) {
        
        return producto.getCantidad() >= venta.getCantidadVentas();
    }
    
}
