package jordanacostashaniasem15;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection cn = null;
        
        try {
            DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
            cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","30251847SHA");
            System.out.println("Obteniendo la conexión");
            }
        catch (Exception e) {
            System.out.println("Error de conexión \n "+e.toString());
        }
        //cerrando la conexión
        try {
            cn.close();
            System.out.println("Cerrando la conexión");
            } 
        catch (SQLException e) {
            System.out.println("Error de cierre" + e.toString());
        }
    }    
}
