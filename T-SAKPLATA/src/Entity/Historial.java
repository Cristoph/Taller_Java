package Entity;
import java.util.Date;


public class Historial {
    private Date fecha;
    private String glosa;
    private String tipo;
    private int monto;
    private int saldo;
    
    public Historial(){
        
    }

    public Historial(Date fecha, String glosa, String tipo, int monto, int saldo) {
        this.fecha = fecha;
        this.glosa = glosa;
        this.tipo = tipo;
        this.monto = monto;
        this.saldo = saldo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    

}
