
package formularios;

import conexionSQL.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormularioEstatus extends javax.swing.JFrame {
    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion();
    
    public FormularioEstatus() {
        initComponents();
        mostrarDatos();
        
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(getBackground());
    }
    public void insertarDatos(){
        
        try {
            String SQL = "insert into ESTATUS (ID_ESTATUS, NOMBRE_ESTATUS) values (?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setInt(1, Integer.parseInt(txtIdEstatus.getText()));
            pst.setString(2, txtEstatus.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Resgitro exitoso");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR EN EL REGISTRO " + e.getMessage());
        }
    }
    
    public void limpiarCajas(){
        txtIdEstatus.setText("");
        txtEstatus.setText("");
    }
    
    public void mostrarDatos(){
        String [] titulos = {"ID Estatus", "Estatus"};
        String [] registros = new String [2];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL = "select * from  ESTATUS";
        
        try {
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                registros [0] = rs.getString("ID_ESTATUS");
                registros [1] = rs.getString("NOMBRE_ESTATUS");
                
                modelo.addRow(registros);
            }
            tablaEstatus.setModel(modelo);
        } catch (Exception e) {
        }
    }
    
    public void actualizarDatos(){
        try {
            String SQL = "update ESTATUS set ID_ESTATUS=?,NOMBRE_ESTATUS=? where ID_ESTATUS=?";
            int filaSeleccionada = tablaEstatus.getSelectedRow();
            String dao =(String)tablaEstatus.getValueAt(filaSeleccionada, 0);
            
            PreparedStatement pst = con.prepareStatement(SQL);
            pst.setString(1, txtIdEstatus.getText());
            pst.setString(2, txtEstatus.getText());
            
            pst.setString(3, dao);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado de manera exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE EDICION " + e.getMessage());
        }
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtEstatus = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIdEstatus = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnTutores = new javax.swing.JButton();
        btnMaterias = new javax.swing.JButton();
        btnAlumnos = new javax.swing.JButton();
        btnMaestros = new javax.swing.JButton();
        btnEstatus = new javax.swing.JButton();
        btnConsultas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEstatus = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Estatus:");

        txtIdEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEstatusActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("ID Estatus:");

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Estatus");

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

        btnTutores.setForeground(new java.awt.Color(0, 0, 0));
        btnTutores.setText("Tutores");
        btnTutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutoresActionPerformed(evt);
            }
        });

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

        btnMaestros.setForeground(new java.awt.Color(0, 0, 0));
        btnMaestros.setText("Maestros");
        btnMaestros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaestrosActionPerformed(evt);
            }
        });

        btnEstatus.setForeground(new java.awt.Color(0, 0, 0));
        btnEstatus.setText("Estatus");
        btnEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstatusActionPerformed(evt);
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
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(btnMaterias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(txtEstatus))
                        .addContainerGap(143, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMaestros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTutores, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(btnEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(19, 19, 19))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIdEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(btnTutores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMaterias, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(btnAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMaestros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        tablaEstatus.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaEstatus.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaEstatus.setMinimumSize(new java.awt.Dimension(600, 64));
        jScrollPane1.setViewportView(tablaEstatus);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEstatusActionPerformed
        
    }//GEN-LAST:event_txtIdEstatusActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        insertarDatos();
        limpiarCajas();
        mostrarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCajas();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarDatos();
        limpiarCajas();
        mostrarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnTutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutoresActionPerformed
        FormularioTutores fra = new FormularioTutores();
        fra.setVisible(true);
        fra.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnTutoresActionPerformed

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        // TODO add your handling code here:
        FormularioAlumno fa = new FormularioAlumno();
        fa.setVisible(true);
        fa.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAlumnosActionPerformed

    private void btnMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMateriasActionPerformed
        // TODO add your handling code here:
        FormularioMaterias fm = new FormularioMaterias();
        fm.setVisible(true);
        fm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMateriasActionPerformed

    private void btnMaestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaestrosActionPerformed
        // TODO add your handling code here:
        FormularioMaestros fma = new FormularioMaestros();
        fma.setVisible(true);
        fma.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMaestrosActionPerformed

    private void btnEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstatusActionPerformed
        // TODO add your handling code here:
        FormularioEstatus fe = new FormularioEstatus();
        fe.setVisible(true);
        fe.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEstatusActionPerformed

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
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioEstatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnEstatus;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMaestros;
    private javax.swing.JButton btnMaterias;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnTutores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEstatus;
    private javax.swing.JTextField txtEstatus;
    private javax.swing.JTextField txtIdEstatus;
    // End of variables declaration//GEN-END:variables
}
