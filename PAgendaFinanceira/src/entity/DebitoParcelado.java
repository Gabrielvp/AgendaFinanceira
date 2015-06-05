package entity;

import java.util.Date;

/**
 *
 * @author Homologação
 */
public class DebitoParcelado {

    private int idDebitoParcelado;
    private int parcelas;
    private double valorParcela;
    private Date dtEntrada;
    private int intervalo;
    private Date vencimento;

    public int getIdDebitoParcelado() {
        return idDebitoParcelado;
    }

    public void setIdDebitoParcelado(int idDebitoParcelado) {
        this.idDebitoParcelado = idDebitoParcelado;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public Date getDtEntrada() {
        return dtEntrada;
    }

    public void setDtEntrada(Date dtEntrada) {
        this.dtEntrada = dtEntrada;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }
    
}
