package dao;

import entity.Telefone;
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
public class TelefoneDAO extends MySQL {

    public boolean insert(Telefone telefone) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO telefone "
                            + "(numero, telefone_principal, tipo_telefone, idpessoa)  "
                            + "VALUES ( ?, ?, ?, ? )");
            ps.setString(1, telefone.getNumero());
            ps.setInt(2, telefone.getTelefonePrincipal());
            ps.setInt(3, telefone.getTipoFone());
            ps.setInt(4, telefone.getIdPessoa());

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

    public void delete(int id) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM telefone "
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

    public void deleteNumero(String numero) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("DELETE FROM telefone "
                    + "WHERE numero = ?");
            ps.setString(1, numero);

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

    public List<Telefone> listarTelefone(int id) {
        List<Telefone> listaTelefone = new ArrayList<>();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("SELECT tipo_telefone, numero, telefone_principal"
                            + " FROM telefone where idpessoa = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Telefone telefone = new Telefone();

                telefone.setTipoFone(rs.getInt("tipo_telefone"));
                telefone.setNumero(rs.getString("Numero"));
                telefone.setTelefonePrincipal(rs.getInt("telefone_principal"));

                listaTelefone.add(telefone);
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
        return listaTelefone;
    }

}
