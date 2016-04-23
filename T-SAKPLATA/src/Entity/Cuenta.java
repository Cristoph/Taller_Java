package Entity;
import java.util.ArrayList;


public class Cuenta  {
    private int idCuenta;
    private int saldo;
    private boolean estado;
    private String tipoCta;
    private Cliente cliente;
    private ArrayList<Historial> historial = new ArrayList();
    
    public Cuenta(){    
    }
    
    public Cuenta(int idCuenta, int saldo, boolean estado, String tipoCta, Cliente cliente) {
        this.idCuenta = idCuenta;
        this.saldo = saldo;
        this.estado = estado;
        this.tipoCta = tipoCta;
        this.cliente = cliente;
    }
    
    /* ------------------------------------------------------ */
    public int getIdCuenta() {
        return idCuenta;
    }

    public String getIdCuentaToString() {
        return Integer.toString(idCuenta);
    }
    
    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getSaldo() {
        return saldo;
    }
    
    public String getSaldoToString() {
        return Integer.toString(saldo);
    }
    
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    
    public boolean isEstado() {
        return estado;
    }
    
    public String getEstado() {
        String std = (this.estado) ? "Activa" : "Cerrada"; 
        return std;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getTipoCta() {
        return tipoCta;
    }

    public void setTipoCta(String tipoCta) {
        this.tipoCta = tipoCta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Historial> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<Historial> historial) {
        this.historial = historial;
    }
    
    public void addHistorial(Historial historial){
        this.historial.add(historial);
    }
    
    /* ------------------------------------------------------ */
    public void doAbono(int monto){
        this.saldo = this.saldo + monto;
    }
    
    public void doCarga(int monto){
        this.saldo = this.saldo - monto;
    }
    
    public void doAbrirCerrar(){
        this.estado = !this.estado;
    }
    
    
    
     
    

}

// #########################################################################

    /*
        public String getEstado() {
        String estado = (this.estado) ? "Activa" : "Cerrada"; 
        return estado;
    }
    
  
//---------- outt?? controller?? ----------//
    public int deposito(int idCuenta, int saldo, int monto) {
        this.idCuenta=idCuenta;
        saldo=this.saldo+monto;
        return saldo;
    }
    
    public int retiro(int idCuenta,int saldo,int monto){
        this.idCuenta=idCuenta;
        if(monto > this.saldo){
        saldo=this.saldo-monto;
        }else{
            System.out.println("el monto es mayor que el saldo");
        }
        return saldo;
    }
    */
    