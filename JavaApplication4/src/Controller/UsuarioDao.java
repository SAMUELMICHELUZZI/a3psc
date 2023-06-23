/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Conexao.ConnectionFactory;
import java.sql.*;
import Classes.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samue
 */
public class UsuarioDao {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rset;

    public void cadastrarUsuario(Usuario objUsuario) throws Exception {
        String sql = "Insert Into usuario (email_usuario, endereço_usuario, nome_usuario, senha_usuario) values ( ?,?,?,?)";
        
        Connection conn = null;         
        PreparedStatement pstm = null;
        
        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, objUsuario.getEmail());
            pstm.setString(2, objUsuario.getEndereco());
            pstm.setString(3, objUsuario.getNome());
            pstm.setString(4, objUsuario.getSenha());
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

    public List<Usuario> VisualizarUsuario(Usuario ObjUsuario) throws Exception {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        String sql = "Select * FROM usuario";

        List<Usuario> usuarios = new ArrayList<Usuario>();

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery(sql);

            while (rset.next()) {
                Usuario usuarioPercorre = new Usuario();

                usuarioPercorre.setEmail(rset.getString("email_usuario"));
                usuarioPercorre.setEndereco(rset.getString("endereço_usuario"));
                usuarioPercorre.setNome(rset.getString("nome_usuario"));
                usuarioPercorre.setSenha(rset.getString("senha_usuario"));

                usuarios.add(usuarioPercorre);
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
        return usuarios;
    }

    public void atualizarUsuario(Usuario objUsuario) throws Exception {
        String sql = ("Update usuario set email_usuario=?, endereço_usuario=?, nome_usuario=?, senha_usuario=? where cd_usuario=?");

        pstm.setString(1, objUsuario.getEmail());
        pstm.setString(2, objUsuario.getEndereco());
        pstm.setString(3, objUsuario.getNome());
        pstm.setString(4, objUsuario.getSenha());
        pstm.setInt(5, objUsuario.getCod_usuario());

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

    public void deletarUsuarioByEmail(String Email) throws Exception {
        String sql = "delete from usuario where email_usuario = ?";

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
