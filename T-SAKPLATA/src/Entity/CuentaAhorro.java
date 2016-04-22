/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author MattoU
 */
public class CuentaAhorro extends Cuenta {
    private int interes;

    public CuentaAhorro(int interes) {
    }

    public CuentaAhorro(int idCuenta, int saldo, boolean estado, String tipoCta, Cliente cliente) {
        super(idCuenta, saldo, estado, tipoCta, cliente);
        this.interes = 10;
    }
       
    public int getInteres() {
        return interes;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    

    
    
    
}
