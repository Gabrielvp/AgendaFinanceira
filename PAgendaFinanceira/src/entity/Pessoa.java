package entity;

import java.util.List;

/**
 *
 * @author Homologação
 */
public class Pessoa {

    private int idPessoa;
    private String nome;
    private String email;
    private boolean completo;
    private Documento documento;
    private Endereco endereco;
    private Telefone telefone;
    private List<Telefone> listaTelefone;

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public List<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(List<Telefone> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    @Override
    public String toString(){
        return idPessoa + nome;
    }
    
    public void addTelefone (Telefone telefone){
        listaTelefone.add(telefone);
    }
    
    public List<Telefone> mostrarTelefone(Telefone telefone){
        return listaTelefone;
    }
    
    public void excluirTelefone(Telefone telefone){
        listaTelefone.remove(telefone);
    }
    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public boolean isCompleto() {
        return completo;
    }

    public void setCompleto(boolean completo) {
        this.completo = completo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
