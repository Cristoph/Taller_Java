package Entity;


public class CuentaAhorro extends Cuenta {
    private int interes;

    public CuentaAhorro(int interes) {
        this.interes = interes;
    }

    public CuentaAhorro(int interes, int idCuenta, int saldo, boolean estado, String tipoCta, Cliente cliente) {
        super(idCuenta, saldo, estado, tipoCta, cliente);
        this.interes = interes;
    }

    public CuentaAhorro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }
    
    @Override
    public int getSaldo() {
        return super.getSaldo() + ((this.interes * 100) / super.getSaldo());
    }
    
}
