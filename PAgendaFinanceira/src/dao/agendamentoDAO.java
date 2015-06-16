package dao;

import entity.Agenda;
import entity.Pessoa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.management.Query;
import view.Agendamento;

/**
 *
 * @author ricardonene
 */
public class agendamentoDAO extends MySQL {

    SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
    java.util.Date d = new java.util.Date();
    java.sql.Date dt = new java.sql.Date(d.getTime());

    public boolean insert(Agenda agenda) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO agendamento "
                            + "(data, hora, descricao, idPessoa, dia)  "
                            + "VALUES ( ?, ?, ?, ?, ? )");
            ps.setString(1, sdfD.format(agenda.getData()));
            ps.setString(2, sdfH.format(agenda.getHora()));
            ps.setString(3, agenda.getDescricao());
            ps.setInt(4, agenda.getIdPessoa());
            ps.setString(5, agenda.getDia());

            ps.execute();
            ps.close();
            return true;

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    }

    /*public boolean update(FContratado funcionario) {
     Connection c = this.getConnection();
     try {
     PreparedStatement ps = c.prepareStatement("UPDATE funcionario "
     + " SET matricula = ?, nome = ?, rua = ?, numero = ?, bairro = ?, cep = ?, uf = ?, "
     + " fone_residencial = ?, fone_celular = ?, salario = ?, funcao = ?, setor = ? "
     + " WHERE id_funcionario = ?");
     ps.setInt(1, funcionario.getMatricula());
     ps.setString(2, funcionario.getNome());
     ps.setString(3, funcionario.getRua());
     ps.setInt(4, funcionario.getNumero());
     ps.setString(5, funcionario.getBairro());
     ps.setString(6, funcionario.getCep());
     ps.setString(7, funcionario.getUf());
     ps.setString(8, funcionario.getResidencial());
     ps.setString(9, funcionario.getCelular());
     ps.setDouble(10, funcionario.getSalario());
     ps.setInt(11, funcionario.getFuncao().getCodigo());
     ps.setInt(12, funcionario.getSetor().getCodigo());
     ps.setInt(13, funcionario.getId_funcionario());

     ps.execute();

     ps.close();
     return true;

     } catch (SQLException ex) {
     ex.printStackTrace();
     } finally {
     try {
     c.close();
     } catch (SQLException ex) {
     ex.printStackTrace();
     }
     }
     return false;
     }

     public boolean delete(int id) {
     Connection c = this.getConnection();
     try {
     PreparedStatement ps
     = c.prepareStatement("DELETE FROM funcionario "
     + "WHERE id_funcionario = ?");
     ps.setInt(1, id);

     ps.execute();

     ps.close();
     return true;

     } catch (SQLException ex) {
     ex.printStackTrace();
     } finally {
     try {
     c.close();
     } catch (SQLException ex) {
     ex.printStackTrace();
     }
     }
     return false;
     }*/
    public List<Agenda> listarAgendamentos(Date data) {
        List<Agenda> lista = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT agendamento.hora, agendamento.descricao, pessoa.nome"
                            + " FROM agendamento INNER JOIN pessoa on"
                            + " pessoa.idPessoa = agendamento.idPessoa WHERE data = ?");
            ps.setDate(1, data);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Agenda agenda = new Agenda();
                Pessoa pessoa = new Pessoa();
                agenda.setDescricao(rs.getString("Descricao"));
                agenda.setHora(rs.getTime("Hora"));
                pessoa.setNome(rs.getString("Nome"));

                agenda.setPessoa(pessoa);
                lista.add(agenda);

            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }

    /* public FContratado getFuncionarioById(int id) {
     Connection c = this.getConnection();
     FContratado funcionario = null;
     try {
     PreparedStatement ps = c.prepareStatement("SELECT id_funcionario, "
     + "matricula, nome "
     + "FROM funcionario WHERE id_funcionario = ?");
     ps.setInt(1, id);
     ResultSet rs = ps.executeQuery();
     while (rs.next()) {

     funcionario = new FContratado();
     funcionario.setId_funcionario(rs.getInt("id_funcionario"));
     funcionario.setMatricula(rs.getInt("matricula"));
     funcionario.setNome(rs.getString("nome"));
     funcionario.setRua(rs.getString("rua"));
     funcionario.setNumero(rs.getInt("numero"));

     }
     rs.close();
     ps.close();
     return funcionario;
     } catch (SQLException ex) {
     ex.printStackTrace();
     } finally {
     try {
     c.close();
     } catch (SQLException ex) {
     ex.printStackTrace();
     }
     }
     return null;
     }
     */
}
