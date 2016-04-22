package Controller;

import Data.DBFake;
import Entity.Cliente;
import java.util.ArrayList;


public class ClienteController {
    private ArrayList<Cliente> allCliente = new ArrayList();
    
    public ClienteController(){
        DBFake dbfake = new DBFake();
        this.setAllCliente(dbfake.getAllCliente());
    }

    private void setAllCliente(ArrayList<Cliente> allCliente) {
        this.allCliente = allCliente;
    }
    
    public ArrayList<Cliente> getAllCliente() {
        return allCliente;
    }

    public ArrayList<String> getDataforSearch() {
        ArrayList<String> arrayToSearch = new ArrayList<>();
        for(Cliente c : this.allCliente){
            arrayToSearch.add(c.getRut()); // agregar Pnombre Papellido nemro cuents si tiene
        }
        
        return arrayToSearch;
    }

    public Cliente getClientebyRut(String rut) {
        Cliente cliente = null;
        for(Cliente c : this.allCliente){
            if(c.getRut().equals(rut)){
                cliente = c;
                break;
            }
        }
        return cliente;
    }

    
    
    
    
    
    
    
    
    
    
}
