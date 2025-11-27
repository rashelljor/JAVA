
package Ejem1_JDBC;

import java.sql.*;

public class Main {
  
    
    public static void main(String[] args) {
        Connection cn = null;
        
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","oracle");
            System.out.println("Obteniendo la conexión");
            }
        catch (Exception e) {
            System.out.println("Error de conexiÃ³n \n "+e.toString());
        }
        //cerrando la conexiÃ³n
        try {
            cn.close();
            System.out.println("Cerrando la conexiÃ³n");
            } 
        catch (SQLException e) {
            System.out.println("Error de cierre" + e.toString());
        }
    }
}
            
