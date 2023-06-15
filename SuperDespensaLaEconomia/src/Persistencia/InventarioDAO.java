package Persistencia;

import Entidades.Inventario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventarioDAO extends DAO<Inventario> {

    public void agregarProducto() {

        Scanner scann = new Scanner(System.in).useDelimiter("\n");

        try {
            Inventario producto = new Inventario();
            System.out.println("INGRESE EL CODIGO DEL NUEVO PRODUCTO");
            producto.setCodigo(scann.nextInt());
            System.out.println("INGRESE EL NOMBRE DEL PRODUCTO");
            producto.setNombre_producto(scann.next());
            System.out.println("INGRESE LA CANTIDAD DE PRODUCTO");
            producto.setCantidad(scann.nextInt());
            System.out.println("INGRESE EL PRECIO DE COMPRA");
            producto.setPrecio_compra(scann.nextDouble());
            System.out.println("INGRESE EL PRECIO DE VENTA");
            producto.setPrecio_venta(scann.nextDouble());
            System.out.println("INGRESE A QUE CATEGORIA CORRESPONDE EL PRODUCTO");
            producto.setCategoria(scann.next());
            super.guardar(producto);
        } catch (Exception e) {
            throw e;

        }

    }

    public Inventario buscarProductoPorNombre(String nombre_producto) throws Exception {

        try {
            conectarBase();
            Inventario producto = (Inventario) em.createQuery("SELECT i FROM Inventario i WHERE i.nombre_producto = :nombre_producto").
                    setParameter("nombre_producto", nombre_producto).
                    getSingleResult();
            if (producto != null) {
                desconectarBase();
                return producto;
            } else {
                System.out.println("Error: El Nombre del Producto no puede estar vacio");
                desconectarBase();
                return null;
            }
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Inventario buscarProductoPorCodigo(int codigo) {

        Inventario producto = em.find(Inventario.class, codigo);

        return producto;
    }

    public void modificarProducto(Inventario producto) throws Exception {
        try {
            if (producto != null) {
                super.modificar(producto);
            } else {
                throw new Exception("Error: El Producto no puede estar vacio");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProductoPorNombre(Inventario producto) throws Exception {

        try {
            if (producto != null) {
                super.eliminar(producto);
            } else {
                throw new Exception("Error: El Producto no puede estar vacio");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    
            

}
