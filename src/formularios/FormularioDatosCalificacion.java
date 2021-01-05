
package formularios;

import conexionSQL.ConexionSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormularioDatosCalificacion extends javax.swing.JFrame {
    
    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion();
    
    public FormularioDatosCalificacion() {
        initComponents();
        mostarDatos();
    }
    
    public void mostarDatos(){
        String [] titulos = {"Matricula","Nombre Alumno", "Apellido Paterno", "Apellido Materno", "Nombre Maestro","Nombre Materia", "Calificacion","Ciclo"};
        String [] registros = new String[8];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select * from Vista_nueva";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                registros[0]= rs.getString("ID_MATRICULA");
                registros[1] = rs.getString("NOMBRE_ALUMNO");
                registros[2]= rs.getString("APELLIDO_P");
                registros[3]= rs.getString("APELLIDO_M");
                registros[4]=rs.getString("NOMBRE_MAESTRO");
                registros[5]= rs.getString("NOMBRE_MATERIA");
                registros[6] = rs.getString("CALIFICACION");
                registros[7]= rs.getString("CICLO");
                
                modelo.addRow(registros);
                
            }
            tablaDatos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL MOSTRAR DATOS " + e.getMessage());
        }
    }
    
    public void filtrarDatos(String valor){
         String [] titulos = {"Matricula","Nombre Alumno", "Apellido Paterno", "Apellido Materno", "Nombre Maestro","Nombre Materia", "Calificacion","Ciclo"};
        String [] registros = new String[8];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select * from Vista_nueva where ID_MATRICULA like '%"+valor+"%' ";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                registros[0]= rs.getString("ID_MATRICULA");
                registros[1] = rs.getString("NOMBRE_ALUMNO");
                registros[2]= rs.getString("APELLIDO_P");
                registros[3]= rs.getString("APELLIDO_M");
                registros[4]=rs.getString("NOMBRE_MAESTRO");
                registros[5]= rs.getString("NOMBRE_MATERIA");
                registros[6] = rs.getString("CALIFICACION");
                registros[7]= rs.getString("CICLO");
                
                modelo.addRow(registros);
                
            }
            tablaDatos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL MOSTRAR DATOS " + e.getMessage());
        }
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaDatos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaDatos.setMinimumSize(new java.awt.Dimension(600, 600));
        jScrollPane1.setViewportView(tablaDatos);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        filtrarDatos(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioDatosCalificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioDatosCalificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioDatosCalificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioDatosCalificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioDatosCalificacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
