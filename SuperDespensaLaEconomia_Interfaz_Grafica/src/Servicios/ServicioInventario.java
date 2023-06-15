package Servicios;

import Entidades.Inventario;
import Persistencia.InventarioDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServicioInventario {

    private final InventarioDAO DAO;

    public ServicioInventario() {
        this.DAO = new InventarioDAO();
    }

    public void crearProductoNuevo() {
        DAO.agregarProducto();
    }

    public Inventario buscarProductoNombre(String nombre_Producto) throws Exception {
        return DAO.buscarProductoPorNombre(nombre_Producto);
    }

    public void modificacionGeneralProducto(Inventario producto) throws Exception {

        DAO.modificarProducto(producto);
    }

    public void modificarProducto() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean salida = false;
        try {
            do {
                System.out.println("MODIFICACION DE PRODUCTOS");
                System.out.println("CRITERIOS DE BUSQUEDA: ");
                System.out.println("1. NOMBRE DEL PRODUCTO");
                System.out.println("2. CODIGO DEL PRODUCTO");
                System.out.println("3. SALIR");
                int opcion = leer.nextInt();
                switch (opcion) {
                    case 1:

                        System.out.println("INGRESE EL NOMBRE DEL PRODUCTO QUE SE MODIFICARA");
                        String nombreProducto = leer.next();
                        try {
                            if (!nombreProducto.equals("")) {
                                boolean salida2 = false;
                                Inventario producto = DAO.buscarProductoPorNombre(nombreProducto);
                                do {

                                    System.out.println("SELECCIONE QUE PARAMETRO DESEA MODIFICAR");
                                    
                                    System.out.println("1.CATEGORIA DEL PRODUCTO");
                                    System.out.println("2.CODIGO");
                                    System.out.println("3.NOMBRE DEL PRODUCTO");
                                    System.out.println("4.PRECIO DE COMPRA");
                                    System.out.println("5.PRECIO DE VENTA");
                                    System.out.println("6. SALIR");
                                    int opcion2 = leer.nextInt();

                                    switch (opcion2) {
                                        
                                        case 1:
                                            System.out.println("Ingrese la categoria");
                                            String newcategoria = leer.next();
                                            producto.setCategoria(newcategoria);
                                            DAO.modificarProducto(producto);
                                            break;
                                        case 2:
                                            System.out.println("Ingrese el nuevo codigo");
                                            int newcodigo = leer.nextInt();
                                            producto.setCodigo(newcodigo);
                                            DAO.modificarProducto(producto);
                                            break;
                                        case 3:
                                            System.out.println("Ingrese el nuevo nombre del producto");
                                            String newnombre = leer.next();
                                            producto.setNombre_producto(newnombre);
                                            DAO.modificarProducto(producto);
                                            break;
                                        case 4:
                                            System.out.println("Ingrese el nuevo precio de compra");
                                            double newprecioc = leer.nextDouble();
                                            producto.setPrecio_compra(newprecioc);
                                            DAO.modificarProducto(producto);
                                            break;
                                        case 5:
                                            System.out.println("Ingrese el nuevo precio de venta");
                                            double newpreciov = leer.nextDouble();
                                            producto.setPrecio_venta(newpreciov);
                                            DAO.modificarProducto(producto);
                                            break;
                                        case 6:
                                            System.out.println("Regresando al menu anterior ....");
                                            salida2 = true;
                                            break;
                                    }
                                } while (salida2 != true);
                            } else {
                                System.out.println("Nombre de producto incorrecto o no existe en la base de datos");
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                        break;
                    case 2:
                        System.out.println("INGRESE EL CODIGO DEL PRODUCTO");
                        int codigoProducto = leer.nextInt();
                        try {
                            if (codigoProducto != 0) {
                                boolean salida3 = false;
                                Inventario producto = DAO.buscarProductoPorCodigo(codigoProducto);
                                producto.toString();
                                do {

                                    System.out.println("SELECCIONE QUE PARAMETRO DESEA MODIFICAR");
                                    
                                    System.out.println("1.CATEGORIA DEL PRODUCTO");
                                    System.out.println("2.CODIGO");
                                    System.out.println("3.NOMBRE DEL PRODUCTO");
                                    System.out.println("4.PRECIO DE COMPRA");
                                    System.out.println("5.PRECIO DE VENTA");
                                    System.out.println("6. SALIR");
                                    int opcion2 = leer.nextInt();

                                    switch (opcion2) {
                                        
                                        case 1:
                                            System.out.println("Ingrese la categoria");
                                            String newcategoria = leer.next();
                                            producto.setCategoria(newcategoria);
                                            DAO.modificarProducto(producto);
                                            break;
                                        case 2:
                                            System.out.println("Ingrese el nuevo codigo");
                                            int newcodigo = leer.nextInt();
                                            producto.setCodigo(newcodigo);
                                            DAO.modificarProducto(producto);
                                            break;
                                        case 3:
                                            System.out.println("Ingrese el nuevo nombre del producto");
                                            String newnombre = leer.next();
                                            producto.setNombre_producto(newnombre);
                                            DAO.modificarProducto(producto);
                                            break;
                                        case 4:
                                            System.out.println("Ingrese el nuevo precio de compra");
                                            double newprecioc = leer.nextDouble();
                                            producto.setPrecio_compra(newprecioc);
                                            DAO.modificarProducto(producto);
                                            break;
                                        case 5:
                                            System.out.println("Ingrese el nuevo precio de venta");
                                            double newpreciov = leer.nextDouble();
                                            producto.setPrecio_venta(newpreciov);
                                            DAO.modificarProducto(producto);
                                            break;
                                        case 6:
                                            System.out.println("Regresando al menu anterior ....");
                                            salida3 = true;
                                            break;
                                    }

                                } while (salida3 != true);

                            } else {
                                System.out.println("Codigo del producto incorrecto o no existe en la base de datos");
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                        break;
                    case 3:
                        System.out.println("Regresando al menu principal ....");
                        salida = true;

                }
            } while (salida != true);

        } catch (Exception e) {
            throw e;
        }

    }

    public void eliminarProductoPorNombre(String nombreProducto) throws Exception {
        try {
            if (!nombreProducto.equals("")) {
                Inventario producto = DAO.buscarProductoPorNombre(nombreProducto);
                if (producto == null) {
                    System.out.println("-Eliminar: No existe el producto ingresado");
                } else {
                    DAO.eliminarProductoPorNombre(producto);
                    System.out.println("-Eliminar Producto: ");
                    System.out.println(" || " + producto.toString());
                }
            } else {
                System.out.println("El nombre no puede estar vacio");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    

}
