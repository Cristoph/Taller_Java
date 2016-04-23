package Entity;


public class CuentaJoven extends Cuenta{
     

    public CuentaJoven() {
    }

    public CuentaJoven(int idCuenta, int saldo, boolean estado, String tipoCta, Cliente cliente) {
        super(idCuenta, saldo, estado, tipoCta, cliente);
    }
    
}
