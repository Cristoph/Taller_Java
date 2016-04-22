package Data;

import Entity.Cheque;
import Entity.Cliente;
import Entity.Cuenta;
import Entity.CuentaAhorro;
import Entity.CuentaCorriente;
import Entity.CuentaJoven;
import Entity.Historial;
import java.util.ArrayList;
import java.util.Date;


public class DBFake {
    private ArrayList<Cliente> allCliente = new ArrayList();
    private ArrayList<Cuenta> allCuenta = new ArrayList(); //deberia cambiarlo a String[] guardar id solamente
    private ArrayList<Historial> allHistoriale = new ArrayList();
    private ArrayList<Cheque> allCheque = new ArrayList();

    public DBFake() {
        this.generateALLData();
    }

    public ArrayList<Cliente> getAllCliente() {
        return allCliente;
    }

    public ArrayList<Cuenta> getAllCuenta() {
        return allCuenta;
    }

    public ArrayList<Historial> getAllHistoriale() {
        return allHistoriale;
    }

    public ArrayList<Cheque> getAllCheque() {
        return allCheque;
    }
    
    // ############# simulate DB data ####################### //
    private void generateALLData(){
        System.out.println("---------- generate DATA ----------");
        //------------------------------------------------------------------        
        Date date = new Date("22/3/1983");
        Cliente cliente = new Cliente("15.232.234-5","Juan Antonio","Perez Moya",date,"Calle Una #2323",543223216,"juanperez@gmail.com");
        CuentaAhorro cuenta = new CuentaAhorro(1001,540000,true,"Ahorro",cliente);
        this.allCliente.add(cliente);
        this.allCuenta.add(cuenta);

        //------------------------------------------------------------------        
        date = new Date("19/4/1985");
        cliente = new Cliente("14.223.232-1","Mario Andres","Faundez Vidal",date,"Av Matta #222",943223972,"mafaund@gmail.com");
        cuenta = new CuentaAhorro(1002,130300,false,"Ahorro",cliente);
        this.allCliente.add(cliente);
        this.allCuenta.add(cuenta);

        //------------------------------------------------------------------        
        date = new Date("12/8/1972");
        cliente = new Cliente("8.123.232-7","Ana Maria","Gonzalez Herrera",date,"Providencia #321",834764522,"ama@werd.cl");
        CuentaCorriente cuentac = new CuentaCorriente(1003,200450,true,"Corriente",cliente);
        this.allCliente.add(cliente);
        this.allCuenta.add(cuentac);

        //------------------------------------------------------------------        
        date = new Date("19/4/1980");
        cliente = new Cliente("10.113.783-6","Marco Alejandro","Silva Negrete",date,"Los Olivos #562",634996672,"marcosilva@hotmail.com");
        this.allCliente.add(cliente);
        // sin cuenta

        //------------------------------------------------------------------        
        date = new Date("1/11/1998");
        cliente = new Cliente("17.821.862-8","Ignacio Francisco","Briones Pacheco",date,"La Avenida #567",582374659,"ifbp@asdf.cl");
        CuentaJoven cuentaj = new CuentaJoven(1004,64000,true,"Joven",cliente);
        this.allCliente.add(cliente);
        this.allCuenta.add(cuentaj);
        
        //------------------------------------------------------------------        
    }
    
  
    
    
}
