/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Conexao.ConnectionFactory;
import java.sql.*;
import Classes.Mensagem;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samue
 */
public class MensagemDao {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rset;

    public void cadastrarMsg(Mensagem objetoMsg){
        Connection conn = null;
        PreparedStatement pstm = null;

        String sql = "Insert Into mensagem (msg_texto) values (?)";

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1,objetoMsg.getTexto());
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

    public List<Mensagem> VisualizarMsg(Mensagem ObjMsg) throws Exception {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        String sql = "Select * FROM ong";

        List<Mensagem> msgs = new ArrayList<Mensagem>();

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery(sql);

            while (rset.next()) {
                Mensagem msgPercorre = new Mensagem();

                msgPercorre.setTexto(rset.getString("msg_texto"));
                msgs.add(msgPercorre);
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
        return msgs;
    }

    public void atualizarMsg(Mensagem objMsg) throws Exception {
        String sql = ("Update mensagem set msg_texto=? where cd_msg=?");

        pstm.setString(1, objMsg.getTexto());
        pstm.setInt(2, objMsg.getCod_msg());

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

    public void deletarMsgByCd(String Cd) throws Exception {
        String sql = "delete from mensagem where cd_msg = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, Cd);
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
