package Entity;
import java.util.ArrayList;
import java.util.Date;


public class CuentaCorriente extends Cuenta {
    private int lineaCredito;
    private final int maxlineaCredito = 500000;
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
    
    @Override
    public void doAbono(int monto){
        Historial hs;
        Date date = new Date();
        
        if(this.lineaCredito < this.maxlineaCredito){ //abonar a linea
            int diffLC = this.maxlineaCredito - this.lineaCredito;
            if(monto <= diffLC){ //abono solo a linea
                this.lineaCredito = this.lineaCredito + monto;
                hs = new Historial(date, "Linea Credito", "Abono", monto, this.lineaCredito);
                this.addHistorial(hs);
            }else{ //abono a linea a max + abono a saldo
                this.lineaCredito = this.maxlineaCredito;
                hs = new Historial(date, "Linea Credito", "Abono", diffLC, this.lineaCredito);
                this.addHistorial(hs);
                super.setSaldo((monto - diffLC));
                hs = new Historial(date, "Abono por Sistema", "Abono", (monto - diffLC), super.getSaldo());
                this.addHistorial(hs);
            }
           
        }else{ // abono a solo saldo
            super.setSaldo((super.getSaldo() + monto));
            hs = new Historial(date, "Abono por Sistema", "Abono", monto, super.getSaldo());
            this.addHistorial(hs);
        }
    }
    
    public int doCargaR(int monto){ //armar una forma mas simple, muchas vueltas
        Historial hs;
        Date date = new Date();
        if((super.getSaldo() + this.lineaCredito) < monto ){ //supera el max(saldo + lineac)
            return -1;
        }else{ //se puede hacer el giro
            if((super.getSaldo() - monto) >= 0){ //alcanza con saldo
                super.setSaldo(super.getSaldo() - monto);
                hs = new Historial(date, "Carga por Sistema", "Carga", monto, super.getSaldo());
                this.addHistorial(hs);
                System.out.println("aaaaaa");
            }else{ //no alcanza con solo saldo, se descuenta saldo y el resto a lineac
                int diff = super.getSaldo() - monto;
                hs = new Historial(date, "Carga por Sistema", "Carga",(monto + diff) , 0);
                super.setSaldo(0);
                this.addHistorial(hs);
                this.lineaCredito = lineaCredito + diff;
                hs = new Historial(date, "Linea Credito", "Carga", (diff * -1), this.lineaCredito);
                this.addHistorial(hs);
            }
        }
        return 0;
    }  
}

