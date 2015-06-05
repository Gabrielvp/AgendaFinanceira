package entity;

/**
 *
 * @author Homologação
 */
public class Endereco {
    
    private int idEndereco;
    private String rua;
    private int numero;
    private String cep;
    private String cidade;
    private String uf;
    private String pReferencia;

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getpReferencia() {
        return pReferencia;
    }

    public void setpReferencia(String pReferencia) {
        this.pReferencia = pReferencia;
    }
    
    
}
