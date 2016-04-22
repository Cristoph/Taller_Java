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
public class Cheque {
    private int numero;
    private int monto;
    private String destinatario;

    public Cheque(){
    }
    
    public Cheque(int numero, int monto, String destinatario) {
        this.numero = numero;
        this.monto = monto;
        this.destinatario = destinatario;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

   

}
