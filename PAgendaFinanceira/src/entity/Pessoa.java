package entity;

import java.util.ArrayList;
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
    private List<Telefone> listaTelefone;
    private List<Endereco> listaEndereco;

    public List<Endereco> getListaEndereco() {
        return listaEndereco;
    }

    public void setListaEndereco(List<Endereco> listaEndereco) {
        this.listaEndereco = listaEndereco;
    }

    public void addEndereco(Endereco endereco) {
        this.listaEndereco.add(endereco);
    }
    public void deletaEndereco(Endereco endereco) {
        this.listaEndereco.remove(endereco);
    }

    public List<Endereco> mostrarEndereco() {
        return listaEndereco;
    }

    public Pessoa() {
        listaTelefone = new ArrayList<>();
        listaEndereco = new ArrayList<>();
    }

    public List<Telefone> getListaTelefone() {
        return listaTelefone;
    }

    public void setListaTelefone(List<Telefone> listaTelefone) {
        this.listaTelefone = listaTelefone;
    }

    @Override
    public String toString() {
        return idPessoa + nome;
    }

    public void addTelefone(Telefone telefone) {
        this.listaTelefone.add(telefone);
    }
    public void removeTelefone(Telefone telefone) {
        this.listaTelefone.remove(telefone);
    }

    public List<Telefone> mostrarTelefone() {
        return listaTelefone;
    }

    public void excluirTelefone(Telefone telefone) {
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
