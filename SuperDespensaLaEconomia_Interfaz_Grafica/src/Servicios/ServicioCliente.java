
package Servicios;

import Entidades.Cliente;
import Persistencia.ClienteDAO;
import java.util.Scanner;


public class ServicioCliente {
    
    private final ClienteDAO CDAO;
    private final Scanner scann = new Scanner(System.in).useDelimiter("\n");
    
    
    public ServicioCliente() {
        this.CDAO = new ClienteDAO();
        
    }
    
    public void crearCliente (Cliente nuCliente){
        CDAO.crearCliente(nuCliente);
    }
    
}
