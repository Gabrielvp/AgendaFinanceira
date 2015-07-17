package entity;

/**
 *
 * @author Homologação
 */
public class Telefone {

    private int idTelefone;
    private int idPessoa;
    private String numero;
    private EnumTipoFone tipoFone;

    @Override
    public String toString() {
        return numero + " - " + tipoFone.getDescricao();
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public EnumTipoFone getTipoFone() {
        return tipoFone;
    }

    public void setTipoFone(EnumTipoFone tipoFone) {
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
