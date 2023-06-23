/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Conexao.ConnectionFactory;
import java.sql.*;
import Classes.Ong;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samue
 */
public class OngDao {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rset;

    public void cadastrarOng(Ong objOng) throws Exception {
        String sql = "Insert Into ong (email_ong, nome_ong, nome_resp, endereço_ong, senha_ong) values ( ?,?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, objOng.getEmail());
            pstm.setString(2, objOng.getNome());
            pstm.setString(3, objOng.getNomeResponsavel());
            pstm.setString(4, objOng.getEndereco());
            pstm.setString(5, objOng.getSenha());
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Ong> VisualizarOng(){
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        String sql = "Select * FROM ong";

        List<Ong> ongs = new ArrayList<Ong>();

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery(sql);

            while (rset.next()) {
                Ong ongPercorre = new Ong();

                ongPercorre.setEmail(rset.getString("email_ong"));
                ongPercorre.setEndereco(rset.getString("endereço_ong"));
                ongPercorre.setNome(rset.getString("nome_ong"));
                ongPercorre.setNomeResponsavel(rset.getString("nome_resp"));
                ongPercorre.setSenha(rset.getString("senha_ong"));

                ongs.add(ongPercorre);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ongs;
    }

    public void atualizarOng(Ong objOng) throws Exception {
        String sql = ("Update ong set email_ong=?, endereço_ong=?, nome_ong=?,nome_resp=?, senha_ong=? where cd_ong=?");

        pstm.setString(1, objOng.getEmail());
        pstm.setString(2, objOng.getEndereco());
        pstm.setString(3, objOng.getNome());
        pstm.setString(4, objOng.getNomeResponsavel());
        pstm.setString(5, objOng.getSenha());
        pstm.setInt(6, objOng.getCod_ong());

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void deletarOngByEmail(String Email) throws Exception {
        String sql = "delete from ong where email_ong = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, Email);
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
