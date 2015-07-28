package dao;

import entity.Documento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ricardonene
 */
public class DocumentoDAO extends MySQL {

    public boolean insert(Documento documento) {
        Connection c = this.getConnection();
        try {
            PreparedStatement ps
                    = c.prepareStatement("INSERT INTO documento "
                            + "(cpf, rg, idpessoa )  "
                            + "VALUES ( ?, ?, ? )");
            ps.setString(1, documento.getCpf());
            ps.setString(2, documento.getRg());
            ps.setInt(3, documento.getIdPessoa());

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
            PreparedStatement ps = c.prepareStatement("DELETE FROM documento "
                    + "WHERE idDocumento = ?");
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

    public void update(Documento documento, int id) {

        Connection c = this.getConnection();

        try {

            PreparedStatement ps = c.prepareStatement("UPDATE documento "
                    + "Set cpf = ?, rg = ? "
                    + "WHERE iddocumento = ? ");

            ps.setString(1, documento.getCpf());
            ps.setString(2, documento.getRg());
            ps.setInt(3, id);

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

    public Documento selecionarDocumento(int id) {
        Documento documento = new Documento();
        Connection c = this.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT cpf, rg "
                    + "FROM documento "
                    + "WHERE idPessoa = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                documento.setCpf(rs.getString("cpf"));
                documento.setRg(rs.getString("rg"));

                return documento;
            }
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
        return null;
    }

}
