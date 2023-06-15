
package Persistencia;

import Entidades.Cliente;
import Entidades.Inventario;
import java.util.Scanner;


public class ClienteDAO extends DAO<Cliente>{
    
    public void crearCliente() {

        Scanner scann = new Scanner(System.in).useDelimiter("\n");

        try {
            Cliente nuevoCliente = new Cliente();
            System.out.print("CEDULA O RUC: ");
            nuevoCliente.setnCedula(scann.nextLong());
            System.out.print("NOMBRES: ");
            nuevoCliente.setNombre(scann.next());
            System.out.print("APELLIDOS: ");
            nuevoCliente.setApellido(scann.next());
            System.out.print("TELEFONO / CECLULAR");
            nuevoCliente.setNumeroTelefono(scann.nextLong());
            System.out.print("DIRECCION: ");
            nuevoCliente.setDireccion(scann.next());
            System.out.print("CORREO ELECTRONICO: ");
            nuevoCliente.setCorreoElectronico(scann.next());
            super.guardar(nuevoCliente);
        } catch (Exception e) {
            throw e;

        }

    }

    public Cliente buscarProductoPorNombre(String nombre) throws Exception {

        try {
            conectarBase();
            Cliente cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c WHERE c.nombre = :nombre").
                    setParameter("nombre", nombre).
                    getSingleResult();
            if (cliente != null) {
                desconectarBase();
                return cliente;
            } else {
                System.out.println("Error: El Nombre del Cliente no puede estar vacio");
                desconectarBase();
                return null;
            }
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Cliente buscarClientePorIdentificacion (Long nCedula) {

        Cliente cliente = em.find(Cliente.class, nCedula);

        return cliente;
    }

    public void modificarProducto(Cliente cliente) throws Exception {
        try {
            if (cliente != null) {
                super.modificar(cliente);
            } else {
                throw new Exception("Error: El Cliente no puede estar vacio");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarClientePorNombre(Cliente cliente) throws Exception {

        try {
            if (cliente!= null) {
                super.eliminar(cliente);
            } else {
                throw new Exception("Error: El Cliente no puede estar vacio");
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    
}
