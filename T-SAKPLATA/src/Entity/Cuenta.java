package Entity;


public class Cuenta  {
    private int idCuenta;
    private int saldo;
    private boolean estado;
    private String tipoCta;
    private Cliente cliente;
    
    //---------- constructor ----------//
    public Cuenta(){
        
    }
    
    public Cuenta(int idCuenta, int saldo, boolean estado, String tipoCta, Cliente cliente) {
        this.idCuenta = idCuenta;
        this.saldo = saldo;
        this.estado = estado;
        this.tipoCta = tipoCta;
        this.cliente = cliente;
    }
    public String getIdCuenta(){
        return Integer.toString(idCuenta);
    }

    public void setIdCuenta(int idCuenta) {    
        this.idCuenta = idCuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public boolean isEstado() {
        return estado;
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

    
    
    
    
    
    

    
    

}
