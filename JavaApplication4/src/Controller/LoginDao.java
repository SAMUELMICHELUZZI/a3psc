/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Conexao.ConnectionFactory;
import Classes.Login;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Renan
 */
public class LoginDao {
    
    public void Logando(Login objetoLogin){
        Connection conn = null;
        PreparedStatement pstm = null;

        String sql = "Insert Into login (email_login, senha_login) values (?,?)";

        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1,objetoLogin.getEmail_login());
            pstm.setString(2,objetoLogin.getSenha_login());
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
    public boolean Logar (String email, String senha){           
        String sql = "Select * From login where email_login = ? and senha_login = ?";  
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        boolean retorno = false;
        
        try{
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, email);
            pstm.setString(2, senha);
            rset = pstm.executeQuery(sql);
            if(rset.next()) {
               retorno = true;
                
            } else {
                JOptionPane.showMessageDialog(null, " Usuario ou senha incorretos");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rset != null){
                    rset.close();                    
                }
                if(pstm != null){
                    pstm.close();                    
                }
                if(conn != null){
                    conn.close();                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }
        
        return retorno;
        
        
    }
    
    public List<Login> VisualizarLogin( Login ObjLogin) throws Exception {
        Connection conn= null;
        PreparedStatement pstm=null ;
        ResultSet rset = null;
        
        String sql = "Select * FROM login";
        
        List<Login> logins = new ArrayList<Login>();
        
        try {
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery(sql);
        
            while(rset.next()){
                Login loginPercorre = new Login();
                
                loginPercorre.setEmail_login(rset.getString("email_login"));
                loginPercorre.setSenha_login(rset.getString("senha_login"));
                logins.add(loginPercorre);    
            } 
            }catch (Exception e) {
                e.printStackTrace();
            }finally{
            try {
                if(rset != null){
                    rset.close();                    
                }
                if(pstm != null){
                    pstm.close();                    
                }
                if(conn != null){
                    conn.close();                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return logins;
    }

    
    public void atualizarLogin (Login objLogin)throws Exception{
        Connection conn= null;
        PreparedStatement pstm=null ;
        ResultSet rset = null;
  
        String sql = ("Update login set email_login=?, senha_login=? where cd_login=?");
        
        pstm.setString(1,objLogin.getEmail_login());
        pstm.setString(2,objLogin.getSenha_login());
       
        try{
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            rset = pstm.executeQuery(sql);
        
        }catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(rset != null){
                    rset.close();                    
                }
                if(pstm != null){
                    pstm.close();                    
                }
                if(conn != null){
                    conn.close();                    
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }    
    }
    
    public void deletarLoginByCd(String Cd)throws Exception{
        String sql = "delete from login where cd_login = ?";
        
        Connection conn= null;
        PreparedStatement pstm=null ;
        ResultSet rset = null;
        
        try{
            conn = ConnectionFactory.createConnectionToMySql();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1,Cd);
            pstm.execute();
        }catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                if(rset != null){
                    rset.close();                    
                }
                if(pstm != null){
                    pstm.close();                    
                }
                if(conn != null){
                    conn.close();                    
                }
            } catch (Exception e) {
            }
        }
    }
    
    public boolean testeLogin (String email, String senha){
        String sql = "SELECT * FROM login WHERE email_login = ? and senha_login = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        boolean teste = false;

// classe que vai recuperar os dados do banco
        ResultSet rset = null;

        try {

            conn = ConnectionFactory.createConnectionToMySql();

            pstm = (PreparedStatement) conn.prepareStatement(sql);

            pstm.setString(1, email);
            pstm.setString(2, senha);

            rset = pstm.executeQuery();

            if (rset.next()) {

                teste = true;

            }else{

                JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //fechar as conexões
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
        return teste;
    }
       
}
