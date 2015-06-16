package dao;

import entity.Agenda;
import entity.Endereco;
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
public class EnderecoDAO extends MySQL {

    SimpleDateFormat sdfD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdfH = new SimpleDateFormat("HH:mm");
    java.util.Date d = new java.util.Date();
    java.sql.Date dt = new java.sql.Date(d.getTime());
        
    public boolean insert(Endereco endereco) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO endereco "
                            + "(rua, numero, cep, cidade, uf, ponto_referencia, idPessoa, baiRro)  "
                            + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )");
            ps.setString(1, endereco.getRua());
            ps.setInt(2, endereco.getNumero());
            ps.setString(3, endereco.getCep());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getUf());
            ps.setString(6, endereco.getpReferencia());
            ps.setInt(7, endereco.getIdPessoa());
            ps.setString(8, endereco.getBairro());

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
     }

     public List<Funcionario> listarFuncionarios() {
     List<Funcionario> lista = new ArrayList<Funcionario>();
     Connection c = this.getConnection();
     try {
     PreparedStatement ps
     = c.prepareStatement("SELECT id_funcionario, matricula, nome, rua, numero, bairro,"
     + " cep, uf, fone_residencial, fone_celular, salario, setor, funcao "
     + "FROM funcionario WHERE tipo = 1");
     ResultSet rs = ps.executeQuery();
     while (rs.next()) {

     FContratado funcionario = new FContratado();
     funcionario.setId_funcionario(rs.getInt("id_funcionario"));
     funcionario.setMatricula(rs.getInt("Matricula"));
     funcionario.setNome(rs.getString("Nome"));
     funcionario.setRua(rs.getString("Rua"));
     funcionario.setNumero(rs.getInt("Numero"));
     funcionario.setBairro(rs.getString("Bairro"));
     funcionario.setCep(rs.getString("Cep"));
     funcionario.setUf(rs.getString("Uf"));
     funcionario.setResidencial(rs.getString("fone_residencial"));
     funcionario.setCelular(rs.getString("fone_celular"));
     funcionario.setSalario(rs.getDouble("salario"));
     funcionario.setSetor(EnumSetor.ADMINISTRATIVO.getEnumSetorPorCodigo(rs.getInt("setor")));
     funcionario.setFuncao(EnumFuncao.ANALISTA.getEnumPorCodigo(rs.getInt("funcao")));

     lista.add(funcionario);
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

     public FContratado getFuncionarioById(int id) {
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