/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;


public class CuentaCorriente extends Cuenta {
    private int lineaCredito;
    private ArrayList<Cheque> misCheques = new ArrayList<>();
    
    public CuentaCorriente(){
    }

    public CuentaCorriente(int idCuenta, int saldo, boolean estado, String tipoCta, Cliente cliente) {
        super(idCuenta, saldo, estado, tipoCta, cliente);
        this.lineaCredito = 500000;
    }

    
    public void setLineaCredito() {
        this.lineaCredito = 500000;
    }
    public void agregarCheque(Cheque cheque){
        this.misCheques.add(cheque);
    }

    public int getLineaCredito() {
        return lineaCredito;
    }

    public ArrayList<Cheque> getMisCheques() {
        return misCheques;
    }

    public void setMisCheques(ArrayList<Cheque> misCheques) {
        this.misCheques = misCheques;
    }

    
    
    
    
    
    
}

