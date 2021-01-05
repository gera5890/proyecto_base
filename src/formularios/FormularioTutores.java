
package formularios;

import conexionSQL.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormularioTutores extends javax.swing.JFrame {
    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion();
  
    public FormularioTutores() {
        initComponents();
        mostrarDatos();
        
         this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(getBackground());
    }
    
    public void insertarDatos(){
        try {
            String SQL = "insert into TUTORES (ID_TUTOR, NOMBRE_TUTOR, APELLIDO_P, APELLIDO_M, TELEFONO, CORREO) values (?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setInt(1, Integer.parseInt(txtIdTutor.getText()));
            pst.setString(2, txtNombre.getText());
            pst.setString(3, txtApellidoP.getText());
            pst.setString(4, txtApellidoM.getText());
            pst.setString(5, txtTelefono.getText());
            pst.setString(6, txtCorreo.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE REGISTRO" + e.getMessage());
        }
    }
    
    public void limpiarCajas(){
        txtIdTutor.setText("");
        txtNombre.setText("");
        txtApellidoP.setText("");
        txtApellidoM.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }
    
    public void mostrarDatos(){
        String [] titulos = {"ID tutor","Nombre", "Apellido Paterno", "Apellido Materno", "Telefono", "Correo"};
        String [] registros = new String [7];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select * from TUTORES";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                registros[0] = rs.getString("ID_TUTOR");
                registros[1] = rs.getString("NOMBRE_TUTOR");
                registros[2]=rs.getString("APELLIDO_P");
                registros[3]=rs.getString("APELLIDO_M");
                registros[4]=rs.getString("TELEFONO");
                registros[5]=rs.getString("CORREO");
                
                modelo.addRow(registros);
            }
            tablaTutor.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL MOSTRAR NDATOS " + e.getMessage());
        }
    }
    
    public void actualizarDatos(){
        try {
            String SQL = "update TUTORES set ID_TUTOR=?, NOMBRE_TUTOR=?, APELLIDO_P=?, APELLIDO_M=?, TELEFONO=?, CORREO=? where ID_TUTOR=?";
            
            int filaSeleccionada = tablaTutor.getSelectedRow();
            String dao =(String)tablaTutor.getValueAt(filaSeleccionada, 0);
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setInt(1, Integer.parseInt(txtIdTutor.getText()));
            pst.setString(2, txtNombre.getText());
            pst.setString(3, txtApellidoP.getText());
            pst.setString(4, txtApellidoM.getText());
            pst.setString(5, txtTelefono.getText());
            pst.setString(6, txtCorreo.getText());
            
            pst.setString(7, dao);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado de manera exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE EDICION " + e.getMessage());
        }
    }
    
    public void filtrarDatos(String valor){
        String [] titulos = {"ID tutor","Nombre","Apellido Paterno","Apellido Materno", "Telefono","Correo"};
        String [] registros = new String[6];
        
        DefaultTableModel modelo = new DefaultTableModel(null,titulos);
        
        String SQL ="select *from TUTORES where ID_TUTOR like '%"+valor+"%' ";
        
        try {
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                registros[0]=rs.getString("ID_TUTOR");
                registros[1]=rs.getString("NOMBRE_TUTOR");
                registros[2]=rs.getString("APELLIDO_P");
                registros[3]=rs.getString("APELLIDO_M");
                registros[4]=rs.getString("TELEFONO");
                registros[5]=rs.getString("CORREO");
                
                modelo.addRow(registros);
            }
            tablaTutor.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL MOSTRAR DATOS " +  e.getMessage());
        }
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIdTutor = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellidoP = new javax.swing.JTextField();
        txtApellidoM = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnCalificaciones = new javax.swing.JButton();
        btnEstatus = new javax.swing.JButton();
        btnMateria = new javax.swing.JButton();
        btnMaestros = new javax.swing.JButton();
        btnAlumnos = new javax.swing.JButton();
        btnConsultas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTutor = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Resgistro Tutores");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID Tutor:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellido Paterno:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Apellido Materno:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Teléfono:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Correo:");

        btnNuevo.setForeground(new java.awt.Color(0, 0, 0));
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
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

        btnCalificaciones.setForeground(new java.awt.Color(0, 0, 0));
        btnCalificaciones.setText("Calificaciones");
        btnCalificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalificacionesActionPerformed(evt);
            }
        });

        btnEstatus.setForeground(new java.awt.Color(0, 0, 0));
        btnEstatus.setText("Estatus");
        btnEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstatusActionPerformed(evt);
            }
        });

        btnMateria.setForeground(new java.awt.Color(0, 0, 0));
        btnMateria.setText("Materias");
        btnMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMateriaActionPerformed(evt);
            }
        });

        btnMaestros.setForeground(new java.awt.Color(0, 0, 0));
        btnMaestros.setText("Maestros");
        btnMaestros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaestrosActionPerformed(evt);
            }
        });

        btnAlumnos.setForeground(new java.awt.Color(0, 0, 0));
        btnAlumnos.setText("Alumnos");
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });

        btnConsultas.setForeground(new java.awt.Color(0, 0, 0));
        btnConsultas.setText("Consultas");
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(182, 182, 182))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCorreo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidoM))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtApellidoP))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdTutor, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnMateria, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnMaestros, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCalificaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtApellidoP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellidoM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar)
                    .addComponent(btnCalificaciones))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEstatus)
                    .addComponent(btnMateria)
                    .addComponent(btnMaestros)
                    .addComponent(btnAlumnos))
                .addGap(18, 18, 18)
                .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablaTutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaTutor.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaTutor.setMinimumSize(new java.awt.Dimension(600, 600));
        tablaTutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaTutorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaTutor);

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Buscar:");

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
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 87, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCajas();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        insertarDatos();
        limpiarCajas();
        mostrarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void tablaTutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaTutorMouseClicked
        int filaSeleccionada = tablaTutor.rowAtPoint(evt.getPoint());
        
        txtIdTutor.setText(tablaTutor.getValueAt(filaSeleccionada, 0).toString());
        txtNombre.setText(tablaTutor.getValueAt(filaSeleccionada, 1).toString());
        txtApellidoP.setText(tablaTutor.getValueAt(filaSeleccionada, 2).toString());
        txtApellidoM.setText(tablaTutor.getValueAt(filaSeleccionada, 3).toString());
        txtTelefono.setText(tablaTutor.getValueAt(filaSeleccionada, 4).toString());
        txtCorreo.setText(tablaTutor.getValueAt(filaSeleccionada, 5).toString());
    }//GEN-LAST:event_tablaTutorMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarDatos();
        limpiarCajas();
        mostrarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        filtrarDatos(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnCalificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalificacionesActionPerformed
        FormularioCalificaciones fc = new FormularioCalificaciones();
        fc.setVisible(true);
        fc.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCalificacionesActionPerformed

    private void btnEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstatusActionPerformed
        FormularioEstatus fe = new FormularioEstatus();
        fe.setVisible(true);
        fe.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEstatusActionPerformed

    private void btnMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMateriaActionPerformed
        // TODO add your handling code here:
        FormularioMaterias fm = new FormularioMaterias();
        fm.setVisible(true);
        fm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMateriaActionPerformed

    private void btnMaestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaestrosActionPerformed
        // TODO add your handling code here:
        FormularioMaestros fma = new FormularioMaestros();
        fma.setVisible(true);
        fma.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMaestrosActionPerformed

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        // TODO add your handling code here:
        FormularioAlumno fa = new FormularioAlumno();
        fa.setVisible(true);
        fa.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAlumnosActionPerformed

    private void btnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasActionPerformed
        FormularioDatosCalificacion fd = new FormularioDatosCalificacion();
        fd.setVisible(true);
        fd.setLocationRelativeTo(null);
        
    }//GEN-LAST:event_btnConsultasActionPerformed

   
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
            java.util.logging.Logger.getLogger(FormularioTutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioTutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioTutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioTutores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioTutores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnCalificaciones;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnEstatus;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMaestros;
    private javax.swing.JButton btnMateria;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTutor;
    private javax.swing.JTextField txtApellidoM;
    private javax.swing.JTextField txtApellidoP;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtIdTutor;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
