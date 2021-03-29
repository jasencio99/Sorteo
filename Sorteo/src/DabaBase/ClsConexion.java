package DabaBase;

import java.sql.*;

/**
 *
 * @author JRA
 */
public class ClsConexion {
    
    public Connection conexion;
    private final String servidor_conexion = "jdbc:mysql://localhost:3306/adivina";
    static private final String usuario = "root";
    static private final String clave = "jra45122";
    
    public void AbrirConexion() {
        try {
            conexion = (Connection) DriverManager.getConnection(servidor_conexion, usuario, clave);
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }

    public void CerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Error:" + ex.getMessage());
        }
    }
    
    
}
