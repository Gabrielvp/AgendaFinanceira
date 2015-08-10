package entity;

/**
 *
 * @author Homologação
 */
public class Telefone {

    private int idTelefone;
    private int idPessoa;
    private String numero;
    private int tipoFone;
    private int telefonePrincipal;

    @Override
    public String toString() {
        return  numero + "- " + EnumTipoFone.CELULAR.getEnumPorCodigo(tipoFone + 1);
    }

    
    
    public int getTelefonePrincipal() {
        return telefonePrincipal;
    }

    public void setTelefonePrincipal(int telefonePrincipal) {
        this.telefonePrincipal = telefonePrincipal;
    }


    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getTipoFone() {
        return tipoFone;
    }

    public void setTipoFone(int tipoFone) {
        this.tipoFone = tipoFone;
    }

    public int getIdTelefone() {
        return idTelefone;
    }

    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
