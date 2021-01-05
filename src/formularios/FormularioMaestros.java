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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gerardo
 */
public class FormularioMaestros extends javax.swing.JFrame {

    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion();
    
    
    public FormularioMaestros() {
        initComponents();
        mostrarDatos();
        
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(getBackground());
    }
    
    public void insertarDatos(){
        try {
            String SQL = "insert into MAESTROS (ID_MAESTRO, NOMBRE_MAESTRO, APELLIDO_P, APELLIDO_M, TELEFONO, CORREO) values(?,?,?,?,?,?)";
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setInt(1, Integer.parseInt(txtIdMaestro.getText()));
            pst.setString(2, txtNombre.getText());
            pst.setString(3, txtApellidoP.getText());
            pst.setString(4, txtApellidoM.getText());
            pst.setString(5, txtTelefono.getText());
            pst.setString(6, txtCorreo.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE REGISTRO " + e.getMessage());
        }
    }
    
    public void limpiarCajas(){
        txtIdMaestro.setText("");
        txtNombre.setText("");
        txtApellidoP.setText("");
        txtApellidoM.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }
    
    public void mostrarDatos(){
        String [] titulos = {"ID maestro","Nombre","Apellido Paterno","Apellido Materno","Telefono","Correo"};
        String [] registros = new String[7];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select * from MAESTROS ";
        
        try {
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                registros[0]= rs.getString("ID_MAESTRO");
                registros[1] = rs.getString("NOMBRE_MAESTRO");
                registros[2] = rs.getString("APELLIDO_P");
                registros[3] = rs.getString("APELLIDO_M");
                registros[4] = rs.getString("TELEFONO");
                registros[5] = rs.getString("CORREO");
                
                modelo.addRow(registros);
            }
            tablaMaestros.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS DATOS "+  e.getMessage());
        }
    }
    
    public void actualizarDatos(){
        try {
            String SQL = "update MAESTROS set ID_MAESTRO=?, NOMBRE_MAESTRO=?,APELLIDO_P=?,APELLIDO_M=?,TELEFONO=?,CORREO=?";
            
            int filaSeleccionada = tablaMaestros.getSelectedRow();
            String dao = (String)tablaMaestros.getValueAt(filaSeleccionada, 0);
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setInt(1, Integer.parseInt(txtIdMaestro.getText()));
            pst.setString(2, txtNombre.getText());
            pst.setString(3, txtApellidoP.getText());
            pst.setString(4, txtApellidoM.getText());
            pst.setString(5, txtTelefono.getText());
            pst.setString(6, txtCorreo.getText());
            
            pst.setString(7, dao);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado de manera exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE EDICION" + e.getMessage());
        }
    }
    
    public void filtrarDatos(String valor){
        String [] titulos = {"ID maestro","Nombre","Apellido Paterno","Apellido Materno","Telefono","Correo"};
        String [] registros = new String[7];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select * from MAESTROS where NOMBRE_MAESTRO like '%"+valor+"%' ";
        
        try {
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                registros[0]= rs.getString("ID_MAESTRO");
                registros[1] = rs.getString("NOMBRE");
                registros[2] = rs.getString("APELLIDO_P");
                registros[3] = rs.getString("APELLIDO_M");
                registros[4] = rs.getString("TELEFONO");
                registros[5] = rs.getString("CORREO");
                
                modelo.addRow(registros);
            }
            tablaMaestros.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS DATOS "+  e.getMessage());
        }
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtIdMaestro = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnStatus = new javax.swing.JButton();
        btnAlumno = new javax.swing.JButton();
        btnCali = new javax.swing.JButton();
        btnMaestros = new javax.swing.JButton();
        btnConsultas = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnMaterias = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMaestros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setForeground(new java.awt.Color(0, 204, 204));

        jLabel8.setFont(new java.awt.Font("Lucida Bright", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Registro de personal docente UPVM");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("ID Maestro:");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Nombre:");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Apellido paterno:");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Apellido Materno:");

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Teléfono:");

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Correo:");

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        btnGuardar.setForeground(new java.awt.Color(0, 0, 0));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setForeground(new java.awt.Color(0, 0, 0));
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnStatus.setForeground(new java.awt.Color(0, 0, 0));
        btnStatus.setText("Estatus");
        btnStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusActionPerformed(evt);
            }
        });

        btnAlumno.setForeground(new java.awt.Color(0, 0, 0));
        btnAlumno.setText("Alumnos");
        btnAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnoActionPerformed(evt);
            }
        });

        btnCali.setForeground(new java.awt.Color(0, 0, 0));
        btnCali.setText("Calificacion");
        btnCali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaliActionPerformed(evt);
            }
        });

        btnMaestros.setForeground(new java.awt.Color(0, 0, 0));
        btnMaestros.setText("Maestros");
        btnMaestros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaestrosActionPerformed(evt);
            }
        });

        btnConsultas.setForeground(new java.awt.Color(0, 0, 0));
        btnConsultas.setText("Consultas");
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });

        btnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnMaterias.setForeground(new java.awt.Color(0, 0, 0));
        btnMaterias.setText("Materias");
        btnMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMateriasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnCali))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMaestros)
                            .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdMaestro, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                    .addComponent(txtNombre)
                    .addComponent(txtApellidoP)
                    .addComponent(txtApellidoM)
                    .addComponent(txtTelefono)
                    .addComponent(txtCorreo))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(71, 71, 71))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtIdMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnStatus)
                    .addComponent(btnNuevo))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlumno)
                    .addComponent(btnCali)
                    .addComponent(btnMaestros)
                    .addComponent(btnMaterias))
                .addGap(18, 18, 18)
                .addComponent(btnConsultas)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tablaMaestros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaMaestros.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaMaestros.setMinimumSize(new java.awt.Dimension(600, 300));
        tablaMaestros.setPreferredSize(new java.awt.Dimension(600, 64));
        tablaMaestros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMaestrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaMaestros);

        jLabel1.setText("Buscar:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarDatos();
        limpiarCajas();
        mostrarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCajas();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        insertarDatos();
        limpiarCajas();
        mostrarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tablaMaestrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMaestrosMouseClicked
        int filaSeleccionada = tablaMaestros.rowAtPoint(evt.getPoint());
    }//GEN-LAST:event_tablaMaestrosMouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        filtrarDatos(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusActionPerformed
       FormularioEstatus fra = new FormularioEstatus();
       fra.setVisible(true);
       fra.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnStatusActionPerformed

    private void btnMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMateriasActionPerformed
        FormularioMaterias fm = new FormularioMaterias();
        fm.setVisible(true);
        fm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMateriasActionPerformed

    private void btnAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnoActionPerformed
        FormularioAlumno fa = new FormularioAlumno();
        fa.setVisible(true);
        fa.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAlumnoActionPerformed

    private void btnCaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaliActionPerformed
        FormularioCalificaciones fc = new FormularioCalificaciones();
        fc.setVisible(true);
        fc.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCaliActionPerformed

    private void btnMaestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaestrosActionPerformed
        FormularioMaestros fma = new FormularioMaestros();
        fma.setVisible(true);
        fma.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMaestrosActionPerformed

    private void btnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(FormularioMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioMaestros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioMaestros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAlumno;
    private javax.swing.JButton btnCali;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMaestros;
    private javax.swing.JButton btnMaterias;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMaestros;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtIdMaestro;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
