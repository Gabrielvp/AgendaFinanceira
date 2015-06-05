package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gabriel1
 */
public class Agenda {

    private Pessoa pessoa;
    private Date data;
    private Date hora;
    private String descricao;
    private List<Telefone> listaTelefones;
    
    public Agenda(){
        
        listaTelefones = new ArrayList<>();
    }

    public void addTelefone (Telefone telefone){
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
