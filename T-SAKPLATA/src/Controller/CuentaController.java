package Controller;

import Data.DBFake;
import Entity.Cliente;
import Entity.Cuenta;
import java.util.ArrayList;




public class CuentaController {
    private ArrayList<Cuenta> allCuenta = new ArrayList();
    
        public CuentaController(){
        DBFake dbfake = new DBFake();
        this.setAllCuenta(dbfake.getAllCuenta());
    }
    
    private void setAllCuenta(ArrayList<Cuenta> allCuenta) {
        this.allCuenta = allCuenta;
    }
    
    public ArrayList<Cuenta> getAllCuenta() {
        return allCuenta;
    }

    public Cuenta getCuentabyRut(String rut) {
        Cuenta cuenta = null;
        for(Cuenta c : this.allCuenta){
            if(c.getCliente().getRut().equals(rut)){
                cuenta = c;
                break;
            }
        }
        return cuenta;
    }
    
    /*public ArrayList<String> getDataforSearch() {
        ArrayList<String> arrayToSearch = new ArrayList<>();
        for(Cliente c : this.allCuenta){
            arrayToSearch.add(c.getRut()); // agregar Pnombre Papellido nemro cuents si tiene
        }
        
        return arrayToSearch;
    }*/

    /*public Cliente getClientebyRut(String rut) {
        Cliente cliente = null;
        for(Cliente c : this.allCliente){
            if(c.getRut().equals(rut)){
                cliente = c;
                break;
            }
        }
        return cliente;
    }*/
}
