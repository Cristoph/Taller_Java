package Data;

import Entity.Cheque;
import Entity.Cliente;
import EntityDAO.ClienteDAO;
import Entity.CuentaAhorro;
import Entity.CuentaCorriente;
import Entity.CuentaJoven;
import Entity.Historial;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class DBFake {

    private ArrayList<Cliente> allClientes = new ArrayList();
    private ArrayList<CuentaAhorro> allCuentasAhorro = new ArrayList();
    private ArrayList<CuentaCorriente> allCuentasCorriente = new ArrayList();
    private ArrayList<CuentaJoven> allCuentasJoven = new ArrayList();

    public DBFake() {
        this.generateALLData();
    }

    public ArrayList<Cliente> getAllClientes() {
        return allClientes;
    }

    public ArrayList<CuentaAhorro> getAllCuentasAhorro() {
        return allCuentasAhorro;
    }

    public ArrayList<CuentaCorriente> getAllCuentasCorriente() {
        return allCuentasCorriente;
    }

    public ArrayList<CuentaJoven> getAllCuentasJoven() {
        return allCuentasJoven;
    }

    /* ############# simulate DB data ####################### */
    private void generateALLData() {
        Cliente cliente;
        CuentaAhorro ctaAhorro;
        CuentaCorriente ctaCorriente;
        CuentaJoven ctaJoven;
        Historial historial;
        Cheque cheque;
        ClienteDAO clienteDAO = new ClienteDAO();
        int interes = 10;

        //############ cambiar los cliente de array a insert con dao.
        System.out.println("---------- generate DATA - start ----------");
        //------------------------------------------------------------------
        Date date = new Date("22/3/1983");
        cliente = new Cliente("15.232.234-5", "Juan Antonio", "Perez Moya", date, "Calle Una #2323", 543223216, "juanperez@gmail.com");
        clienteDAO.insert_or_update(cliente);
        ctaAhorro = new CuentaAhorro(interes, 1001, 250000, true, "Cuenta Ahorro", cliente);
        cliente.setTipoCuenta("Ahorro");
        clienteDAO.update_tipoCuenta(cliente);
        historial = new Historial(date, "Transferecia", "Abono", 12000, 212000);
        ctaAhorro.addHistorial(historial);
        historial = new Historial(date, "Transferecia", "Carga", 1000, 211000);
        ctaAhorro.addHistorial(historial);
        //this.allClientes.add(cliente);
        this.allCuentasAhorro.add(ctaAhorro);
        //------------------------------------------------------------------
        date = new Date("19/4/1985");
        cliente = new Cliente("14.223.232-1", "Mario Andres", "Faundez Vidal", date, "Av Matta #222", 943223972, "mafaund@gmail.com");
        clienteDAO.insert_or_update(cliente);
        ctaAhorro = new CuentaAhorro(interes, 1002, 130300, false, "Cuenta Ahorro", cliente);
        cliente.setTipoCuenta("Ahorro");
        clienteDAO.update_tipoCuenta(cliente);
        historial = new Historial(date, "Compra", "Carga", 12000, 118300);
        ctaAhorro.addHistorial(historial);
        //this.allClientes.add(cliente);
        this.allCuentasAhorro.add(ctaAhorro);
        //------------------------------------------------------------------
        date = new Date("12/8/1972");
        cliente = new Cliente("8.123.232-7", "Ana Maria", "Gonzalez Herrera", date, "Providencia #321", 834764522, "ama@werd.cl");
        clienteDAO.insert_or_update(cliente);
        ctaCorriente = new CuentaCorriente(500000, 1003, 200450, true, "Cuenta Corriente", cliente);
        cliente.setTipoCuenta("Corriente");
        clienteDAO.update_tipoCuenta(cliente);
        historial = new Historial(date, "Transferecia", "Carga", 1000, 199450);
        ctaCorriente.addHistorial(historial);
        cheque = new Cheque(date, 1, 200000, "Juan Perez");
        ctaCorriente.addCheque(cheque);
        //this.allClientes.add(cliente);

        this.allCuentasCorriente.add(ctaCorriente);
        //------------------------------------------------------------------
        date = new Date("19/4/1980");
        cliente = new Cliente("10.113.783-6", "Marco Alejandro", "Silva Negrete", date, "Los Olivos #562", 634996672, "marcosilva@hotmail.com");
        clienteDAO.insert_or_update(cliente);
        cliente.setTipoCuenta("no");
        clienteDAO.update_tipoCuenta(cliente);
        //this.allClientes.add(cliente);
        clienteDAO.insert_or_update(cliente);
        // sin cuenta
        //------------------------------------------------------------------
        date = new Date("1/11/1998");
        cliente = new Cliente("17.821.862-8", "Ignacio Francisco", "Briones Pacheco", date, "La Avenida #567", 582374659, "ifbp@asdf.cl");
        clienteDAO.insert_or_update(cliente);
        ctaJoven = new CuentaJoven(1004, 64000, true, "Joven", cliente);
        cliente.setTipoCuenta("Joven");
        clienteDAO.update_tipoCuenta(cliente);
        //this.allClientes.add(cliente);
        this.allCuentasJoven.add(ctaJoven);
        //------------------------------------------------------------------
        System.out.println("---------- generate DATA - end ----------");

    }

    public static void truncate_table() {
        DBConnect dbConnect = new DBConnect();
        PreparedStatement stmt = null;
        Connection conn = null;
        conn = dbConnect.getConnection();
        try {
            stmt = conn.prepareStatement("truncate Clientes");
            stmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            dbConnect.close(conn);
            dbConnect.close(stmt);
        }
    }

}
