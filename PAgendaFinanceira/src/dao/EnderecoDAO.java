package dao;

import entity.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ricardonene
 */
public class EnderecoDAO extends MySQL {

    public boolean insert(Endereco endereco) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO endereco "
                            + "(rua, numero, cep, cidade, uf, ponto_referencia, idPessoa, bairro, tipo_Endereco, endereco_principal)  "
                            + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");

            ps.setString(1, endereco.getRua());
            ps.setInt(2, endereco.getNumero());
            ps.setString(3, endereco.getCep());
            ps.setString(4, endereco.getCidade());
            ps.setString(5, endereco.getUf());
            ps.setString(6, endereco.getpReferencia());
            ps.setInt(7, endereco.getIdPessoa());
            ps.setString(8, endereco.getBairro());
            ps.setInt(9, endereco.getTipoEndereco());
            ps.setInt(10, endereco.getPrincipal());

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

    public List<Endereco> listarEndereco(int id) {
        List<Endereco> listaEndereco = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT endereco.rua, endereco.numero, endereco.cep, endereco.cidade, "
                            + " endereco.bairro, endereco.uf, endereco.ponto_referencia"
                            + " FROM endereco where idpessoa = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Endereco endereco = new Endereco();
                endereco.setRua(rs.getString("Rua"));
                endereco.setNumero(rs.getInt("Numero"));
                endereco.setCep(rs.getString("Cep"));
                endereco.setCidade(rs.getString("Cidade"));
                endereco.setBairro(rs.getString("Bairro"));
                endereco.setUf(rs.getString("UF"));
                endereco.setpReferencia(rs.getString("Ponto_referencia"));

                listaEndereco.add(endereco);
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
        return listaEndereco;
    }
    
        public void delete(int id) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM endereco "
                    + "WHERE idPessoa = ?");
            ps.setInt(1, id);

            ps.execute();
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
    }


    /*public FContratado getFuncionarioById(int id) {
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
