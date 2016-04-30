package EntityDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Data.DBConnect;
import Entity.Cliente;
import java.sql.Date;
import java.sql.Statement;

public class ClienteDAO {

    private final DBConnect dbConnect;
    private PreparedStatement stmt;
    private Connection conn = null;

    private static final String FIND_ALL = "SELECT * FROM Clientes";
    private static final String FIND_BY_RUT = "SELECT * FROM Clientes WHERE rut=?";
    private static final String DELETE = "DELETE FROM Clientes WHERE rut=?";
    //private static final String FIND_BY_NAME = "SELECT * FROM Clientes WHERE name=?";
    //private static final String INSERT = "INSERT INTO Clientes() VALUES()";
    //private static final String UPDATE = "UPDATE Clientes SET";
    private static final String UPDATE_TipoCuenta = "UPDATE Clientes SET tipoCuenta=? WHERE rut=?";
    private static final String INSERT_OR_UPDATE = "INSERT INTO Clientes "
            + "(rut, nombres, apellidos, fechaNac, domicilio, fono, mail) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?) "
            + "ON DUPLICATE KEY UPDATE "
            + "rut=VALUES(rut),"
            + "nombres=VALUES(nombres),"
            + "apellidos=VALUES(apellidos),"
            + "fechaNac=VALUES(fechaNac),"
            + "domicilio=VALUES(domicilio),"
            + "fono=VALUES(fono),"
            + "mail=VALUES(mail)";

    public ClienteDAO() {
        this.dbConnect = new DBConnect();

    }

    public ArrayList<Cliente> findAll() {
        conn = dbConnect.getConnection();
        ArrayList<Cliente> list = new ArrayList<Cliente>();

        try {
            stmt = conn.prepareStatement(FIND_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setRut(rs.getString("rut"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setFechaNac(rs.getDate("fechaNac"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setFono(rs.getInt("fono"));
                cliente.setMail(rs.getString("mail"));
                cliente.setTipoCuenta(rs.getString("tipoCuenta"));

                list.add(cliente);
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            dbConnect.close(conn);
            dbConnect.close(stmt);
        }

        return list;
    }

    public Cliente getClientebyRut(String rut) {
        conn = dbConnect.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(FIND_BY_RUT);
            stmt.setString(1, rut);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setRut(rs.getString("rut"));
                cliente.setNombres(rs.getString("nombres"));
                cliente.setApellidos(rs.getString("apellidos"));
                cliente.setFechaNac(rs.getDate("fechaNac"));
                cliente.setDomicilio(rs.getString("domicilio"));
                cliente.setFono(rs.getInt("fono"));
                cliente.setMail(rs.getString("mail"));
                cliente.setTipoCuenta(rs.getString("tipoCuenta"));
                return cliente;
            } else {
                return null;
            }
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            dbConnect.close(conn);
            dbConnect.close(stmt);
        }
    }

    public Cliente insert_or_update(Cliente cliente) {
        conn = dbConnect.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(INSERT_OR_UPDATE, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, cliente.getRut());
            stmt.setString(2, cliente.getNombres());
            stmt.setString(3, cliente.getApellidos());

            Date dsql = new Date(cliente.getFechaNac().getTime());
            stmt.setDate(4, dsql);

            stmt.setString(5, cliente.getDomicilio());
            stmt.setString(6, cliente.getFono());
            stmt.setString(7, cliente.getMail());

            int a = stmt.executeUpdate();
            System.out.println(a);
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                cliente.setRut(rs.getString(1));
            }
            System.out.println(cliente.getNombres());
            return cliente;
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            dbConnect.close(conn);
            dbConnect.close(stmt);
        }
    }

    public void delete(String rut) {
        conn = dbConnect.getConnection();  //OK - comentado para pruebas
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(DELETE);
            stmt.setString(1, rut);
            //return stmt.executeUpdate();
            stmt.executeUpdate();
        } catch (SQLException e) {
            // e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            dbConnect.close(conn);
            dbConnect.close(stmt);
        }
    }

    // field tidoCuenta se debe eliminar, considerar cambio en logica de view.
    public void update_tipoCuenta(Cliente cliente) {
        conn = dbConnect.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(UPDATE_TipoCuenta);
            stmt.setString(1, cliente.getTipoCuenta());
            stmt.setString(2, cliente.getRut());
            System.out.println("update tipo");
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
