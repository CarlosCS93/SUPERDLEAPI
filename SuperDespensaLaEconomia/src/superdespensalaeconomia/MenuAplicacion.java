package superdespensalaeconomia;

import Entidades.Inventario;
import Servicios.ServicioCliente;
import Servicios.ServicioInventario;
import Servicios.ServicioVenta;
import java.util.Scanner;

public class MenuAplicacion {

    private final Scanner scann = new Scanner(System.in).useDelimiter("\n");
    private boolean salida = false;

    public void menuAplicativo() throws Exception {

        ServicioInventario sdle = new ServicioInventario();
        ServicioVenta sdlev = new ServicioVenta();
        ServicioCliente sdlec = new ServicioCliente();

        do {

            System.out.println("SUPER DESPENSA LA ECONOMIA API");
            System.out.println("1. MODULO VENTA");
            System.out.println("2. MODULO COMPRAS");
            System.out.println("3. MODULO INVENTARIO");
            System.out.println("4. MODULO CLIENTES");
            System.out.println("5. MODULO PROVEEDORES");
            System.out.println("6. MODULO REGISTROS");
            System.out.println("7. SALIR");
            int opcion = scann.nextInt();
            switch (opcion) {
                case 1:
                    sdlev.transaccionVenta();
                    break;
                case 2:
                    break;
                case 3:
                    boolean salida2 = false;
                    do {
                        System.out.println("-----INVENTARIO-----");
                        System.out.println("1. CREAR PRODUCTO");
                        System.out.println("2. MODIFICAR PRODUCTO");
                        System.out.println("3. BUSCAR PRODUCTO");
                        System.out.println("4. ELIMINAR PRODUCTO");
                        System.out.println("5. SALIR");
                        int opcion2 = scann.nextInt();
                        switch (opcion2) {
                            case 1:
                                sdle.crearProductoNuevo();
                                break;
                            case 2:
                                sdle.modificarProducto();
                                break;
                            case 3:
                                System.out.println("INGRESE EL NOMBRE DEL PRODUCTO QUE DESEA BUSCAR");
                                String nombreProducto = scann.next();
                                Inventario producto = sdle.buscarProductoNombre(nombreProducto);
                                System.out.println("PRODUCTO: " + producto.toString());
                                break;
                            case 4:
                                System.out.println("INGRESE EL NOMBRE DEL PRODUCTO QUE DESEA ELIMINAR");
                                String nombreProducto2 = scann.next();
                                sdle.eliminarProductoPorNombre(nombreProducto2);
                                break;
                            case 5:
                                salida2 = true;
                        }
                    } while (!salida2);
                    break;
                case 4:
                    boolean salida3 = false;
                    do {
                        System.out.println("----- CLIENTES -----");
                        System.out.println("1. CREAR CLIENTE");
                        System.out.println("2. MODIFICAR CLIENTE");
                        System.out.println("3. BUSCAR CLIENTE");
                        System.out.println("4. ELIMINAR CLIENTE");
                        System.out.println("5. REGRESAR");
                        int opcion2 = scann.nextInt();
                        switch (opcion2) {
                            case 1:
                                sdlec.crearCliente();
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                System.out.println("Regresando al menu anterior ...");
                                salida3 = true;
                                
                        }
                    } while (!salida3);

                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    salida = true;
            }

        } while (!salida);

    }

}
