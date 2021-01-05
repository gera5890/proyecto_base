
package conexionSQL;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionSQL {
   
    Connection conectar = null;
    
    public Connection conexion(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar= (Connection) DriverManager.getConnection("jdbc:mysql://localhost/escuelabase","root","helloworld");
            JOptionPane.showMessageDialog(null, "Conexion exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE CONEXION " + e.getMessage());
        }
        return conectar;
    }
   
}