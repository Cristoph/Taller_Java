package Entity;

import java.util.Date;


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
    
    public int getMontoInteres(int monto) {
        return monto + ((this.interes * 100) / monto);
    }
    
    @Override
    public void doAbono(int monto){
        Historial hs;
        Date date = new Date();
        monto = getMontoInteres(monto);
        int saldo = super.getSaldo();
        saldo = saldo + monto;
        super.setSaldo(saldo);
        hs = new Historial(date, "Abono por Sistema", "Abono", monto, saldo);
        this.addHistorial(hs);
    }
    
    
}


