/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import conexionSQL.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormularioMaterias extends javax.swing.JFrame {

    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion();
    
    public FormularioMaterias() {
        initComponents();
        mostrarDatos();
        
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(getBackground());
    }
    
    public void insertarDatos(){
        try {
            String SQL = "insert into MATERIAS (ID_MATERIA, NOMBRE_MATERIA) values (?,?)";
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setInt(1,Integer.parseInt(txtIdmateria.getText()));
            pst.setString(2, txtNombremateria.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE REGISTRO" + e.getMessage());
        }
    }
    
    public void limpiarCajas(){
        txtIdmateria.setText("");
        txtNombremateria.setText("");
    }
    
    public void mostrarDatos(){
        String [] titulos = {"Id Materia", "Nombre Materia"};
        String [] registros = new String [2];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select *from MATERIAS";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            while(rs.next()){
                registros[0]=rs.getString("ID_MATERIA");
                registros[1]=rs.getString("NOMBRE_MATERIA");
                
                modelo.addRow(registros);
            }
            tablaMaterias.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL MOSTRAR DATOS" + e.getMessage());
        }
    }
    
    public void actualizarDatos(){
        try {
            String SQL = "update MATERIAS set ID_MATERIA=?,NOMBRE_MATERIA=? where ID_MATERIA=?";
            int filaSeleccionada = tablaMaterias.getSelectedRow();
            String dao = (String)tablaMaterias.getValueAt(filaSeleccionada, 0);
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setInt(1, Integer.parseInt(txtIdmateria.getText()));
            pst.setString(2, txtNombremateria.getText());
            
            pst.setString(3, dao);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado de manera exitosa" );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE ECICION" + e.getMessage());
        }
    }
     public void filtrarDatos(String valor){
        String [] titulos = {"Id Materia", "Nombre Materia"};
        String [] registros = new String [2];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select *from MATERIAS where NOMBRE_MATERIA like '%"+valor+"%' ";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs =st.executeQuery(SQL);
            while(rs.next()){
                registros[0]=rs.getString("ID_MATERIA");
                registros[1]=rs.getString("NOMBRE_MATERIA");
                
                modelo.addRow(registros);
            }
            tablaMaterias.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL MOSTRAR DATOS" + e.getMessage());
        }
    }
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdmateria = new javax.swing.JTextField();
        txtNombremateria = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnMaestros = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnMaterias = new javax.swing.JButton();
        btnAlumnos = new javax.swing.JButton();
        btnEstatus = new javax.swing.JButton();
        btnCali = new javax.swing.JButton();
        btnConsultas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMaterias = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID Materia:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre Materia:");

        txtIdmateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdmateriaActionPerformed(evt);
            }
        });

        btnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setText("Actualizar");
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnMaestros.setForeground(new java.awt.Color(0, 0, 0));
        btnMaestros.setText("Maestros");
        btnMaestros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMaestros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaestrosActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Registro Materias UPVM");

        btnMaterias.setForeground(new java.awt.Color(0, 0, 0));
        btnMaterias.setText("Materias");
        btnMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMateriasActionPerformed(evt);
            }
        });

        btnAlumnos.setForeground(new java.awt.Color(0, 0, 0));
        btnAlumnos.setText("Alumnos");
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });

        btnEstatus.setForeground(new java.awt.Color(0, 0, 0));
        btnEstatus.setText("Estatus");
        btnEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstatusActionPerformed(evt);
            }
        });

        btnCali.setForeground(new java.awt.Color(0, 0, 0));
        btnCali.setText("Calificacion");
        btnCali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaliActionPerformed(evt);
            }
        });

        btnConsultas.setForeground(new java.awt.Color(0, 0, 0));
        btnConsultas.setText("Consultas");
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdmateria, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombremateria, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnActualizar))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(btnMaterias)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnCali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnMaestros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel4)
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdmateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombremateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaestros, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(btnAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCali, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tablaMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaMaterias.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaMaterias.setMaximumSize(new java.awt.Dimension(2500, 2500));
        tablaMaterias.setMinimumSize(new java.awt.Dimension(2500, 2500));
        tablaMaterias.setName(""); // NOI18N
        tablaMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMateriasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMaterias);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Buscar:");

        txtBuscar2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscar2KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtBuscar2))
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdmateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdmateriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdmateriaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCajas();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        insertarDatos();
        limpiarCajas();
        mostrarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarDatos();
        limpiarCajas();
        mostrarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtBuscar2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscar2KeyReleased
        filtrarDatos(txtBuscar2.getText());
    }//GEN-LAST:event_txtBuscar2KeyReleased

    private void tablaMateriasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMateriasMouseClicked
        int filaSeleccionada = tablaMaterias.rowAtPoint(evt.getPoint());
        
        txtIdmateria.setText(tablaMaterias.getValueAt(filaSeleccionada, 0).toString());
        txtNombremateria.setText(tablaMaterias.getValueAt(filaSeleccionada, 1).toString());
    }//GEN-LAST:event_tablaMateriasMouseClicked

    private void btnMaestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaestrosActionPerformed
        FormularioMaestros fra= new FormularioMaestros();
        fra.setVisible(true);
        fra.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMaestrosActionPerformed

    private void btnMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMateriasActionPerformed
        FormularioMaterias fma = new FormularioMaterias();
        fma.setVisible(true);
        fma.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMateriasActionPerformed

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        FormularioAlumno fa = new FormularioAlumno();
        fa.setVisible(true);
        fa.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAlumnosActionPerformed

    private void btnEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstatusActionPerformed
        FormularioEstatus fe =new FormularioEstatus();
        fe.setVisible(true);
        fe.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEstatusActionPerformed

    private void btnCaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaliActionPerformed
        // TODO add your handling code here:
        FormularioCalificaciones fc = new FormularioCalificaciones();
        fc.setVisible(true);
        fc.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnCaliActionPerformed

    private void btnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasActionPerformed
        FormularioDatosCalificacion fd = new FormularioDatosCalificacion();
        fd.setVisible(true);
        fd.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnConsultasActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioMaterias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioMaterias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnCali;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnEstatus;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMaestros;
    private javax.swing.JButton btnMaterias;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMaterias;
    private javax.swing.JTextField txtBuscar2;
    private javax.swing.JTextField txtIdmateria;
    private javax.swing.JTextField txtNombremateria;
    // End of variables declaration//GEN-END:variables
}
