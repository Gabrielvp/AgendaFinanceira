package entity;

import java.util.Date;

/**
 *
 * @author Homologação
 */
public class Debito {

    private int idDebito;
    private int fatura;
    private double total;
    private Date dtEmissao;
    private Date dtVencimento;

    public int getIdDebito() {
        return idDebito;
    }

    public void setIdDebito(int idDebito) {
        this.idDebito = idDebito;
    }

    public int getFatura() {
        return fatura;
    }

    public void setFatura(int fatura) {
        this.fatura = fatura;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(Date dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }
    
}
