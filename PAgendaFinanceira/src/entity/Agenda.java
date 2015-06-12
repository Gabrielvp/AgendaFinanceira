package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gabriel1
 */
public class Agenda {

    private int idAgenda;
    private int idPessoa;
    private Pessoa pessoa;
    private Date data;
    private Date hora;
    private Date date;
    private String descricao;
    private String dia;
    private List<Telefone> listaTelefones;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public List<Telefone> getListaTelefones() {
        return listaTelefones;
    }

    public void setListaTelefones(List<Telefone> listaTelefones) {
        this.listaTelefones = listaTelefones;
    }

    public Agenda() {

        listaTelefones = new ArrayList<>();
    }

    public List<Telefone> mostrarTelefone() {
        return listaTelefones;
    }

    public void addTelefone(Telefone telefone) {
        listaTelefones.add(telefone);
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
