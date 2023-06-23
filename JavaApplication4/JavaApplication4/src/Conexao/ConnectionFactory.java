/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexao;
import java.sql.*;
/**
 *
 * @author samue
 */
public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/127.0.0.1:3306/youneedy";
    
    public static Connection createConnetionToMySql() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection; 
    }
    
    public static void main( String[] args) throws Exception{
        Connection con=createConnetionToMySql();
        if(con !=null){
            System.out.println("CONEXAO COM PROBLEMA");
            con.close();
        }
        
    }
}
