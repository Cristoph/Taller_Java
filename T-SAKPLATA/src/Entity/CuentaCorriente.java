package Entity;
import java.util.ArrayList;


public class CuentaCorriente extends Cuenta {
    private int lineaCredito;
    private ArrayList<Cheque> cheques = new ArrayList<>();

    public CuentaCorriente() {
    }

    public CuentaCorriente(int lineaCredito, int idCuenta, int saldo, boolean estado, String tipoCta, Cliente cliente) {
        super(idCuenta, saldo, estado, tipoCta, cliente);
        this.lineaCredito = lineaCredito;
    }
    
    /* ------------------------------------------------------ */
    public int getLineaCredito() {
        return lineaCredito;
    }
    
    public String getLineaCreditoToString() {
        return Integer.toString(lineaCredito);
    }
    
    public void setLineaCredito(int lineaCredito) {
        this.lineaCredito = lineaCredito;
    }
    
    public ArrayList<Cheque> getCheques() {
        return cheques;
    }

    public void setCheques(ArrayList<Cheque> cheques) {
        this.cheques = cheques;
    }
    
    public void addCheque(Cheque cheque){
        this.cheques.add(cheque);
    }


    
}

