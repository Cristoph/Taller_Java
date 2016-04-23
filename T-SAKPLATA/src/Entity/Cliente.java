package Entity;
import java.util.Date;


public class Cliente {
    private String rut;
    private String nombres;
    private String apellidos;
    private Date fechaNac;
    private String domicilio;
    private int fono;
    private String mail;
    private String tipoCuenta;
    private CuentaAhorro cuentaAhorro;
    private CuentaCorriente cuentaCorriente;
    private CuentaJoven cuentaJoven;
    
    public Cliente(){
    }

    public Cliente(String rut, String nombres, String apellidos, Date fechaNac, String domicilio, int fono, String mail) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.domicilio = domicilio;
        this.fono = fono;
        this.mail = mail;
    }

    /* ------------------------------------------------------ */
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getFono() {
        return Integer.toString(fono);
    }

    public void setFono(int fono) {
        this.fono = fono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    /* ------------------------------------------------------ */
    
    public String getPrimerNombre() {
        return this.getNombres().split(" ")[0];
    }
    
    public String getPrimerApellido() {
        return this.getApellidos().split(" ")[0];
    }

    public CuentaAhorro getCuentaAhorro() {
        return cuentaAhorro;
    }

    public void setCuentaAhorro(CuentaAhorro cuantaAhorro) {
        this.cuentaAhorro = cuantaAhorro;
    }

    public CuentaCorriente getCuentaCorriente() {
        return cuentaCorriente;
    }

    public void setCuentaCorriente(CuentaCorriente cuantaCorriente) {
        this.cuentaCorriente = cuantaCorriente;
    }

    public CuentaJoven getCuentaJoven() {
        return cuentaJoven;
    }

    public void setCuentaJoven(CuentaJoven cuenaJoven) {
        this.cuentaJoven = cuenaJoven;
    }
    /* ------------------------------------------------------ */

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

     
}
