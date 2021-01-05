
package formularios;

import conexionSQL.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormularioCalificaciones extends javax.swing.JFrame {
    
    ConexionSQL cc = new ConexionSQL();
    Connection con = cc.conexion();
    
    public FormularioCalificaciones() {
        initComponents();
        mostrarDatos();
    }
    
    public void insertarDatos(){
        
        try {
            String SQL = "insert into ALUMNO_CALIFICACION (ID_ALUMNO_CALIFICACION, FK_ID_MATRICULA, FK_ID_MATERIA, FK_ID_MAESTRO, FK_ID_ESTATUS, FK_ID_TUTOR, CALIFICACION, CICLO) values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setInt(1, Integer.parseInt(txtIdCali.getText()));
            pst.setInt(2, Integer.parseInt(txtIdMatricula.getText()));
            pst.setInt(3, Integer.parseInt(txtIdMateria.getText()));
            pst.setInt(4, Integer.parseInt(txtIdMaestro.getText()));
            pst.setInt(5, Integer.parseInt(txtIdEstatus.getText()));
            pst.setInt(6, Integer.parseInt(txtIdTutor.getText()));
            pst.setInt(7, Integer.parseInt(txtCalificacion.getText()));
            pst.setString(8, txtCiclo.getText());
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro exitoso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE REGISTRO " + e.getMessage());
        }
    }
    
    public void limpiarCajas(){
        txtIdCali.setText("");
        txtIdMateria.setText("");
        txtIdMaestro.setText("");
        txtIdEstatus.setText("");
        txtIdTutor.setText("");
        txtCiclo.setText("");
        txtCalificacion.setText("");
        txtIdMatricula.setText("");
    }
    
    public void mostrarDatos(){
        String [] titulos = {"ID alumno calificacion","ID Matricula","ID Materia","ID Maestro","ID Estatus","ID Tutor","Calificacion", "Ciclo"};
        String [] registros = new String[8];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String SQL = "select * from  ALUMNO_CALIFICACION";
        
        try {
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                registros[0]= rs.getString("ID_ALUMNO_CALIFICACION");
                registros[1]= rs.getString("FK_ID_MATRICULA");
                registros[2]=rs.getString("FK_ID_MATERIA");
                registros[3]=rs.getString("FK_ID_MAESTRO");
                registros[4]=rs.getString("FK_ID_ESTATUS");
                registros[5]=rs.getString("FK_ID_TUTOR");
                registros[6]=rs.getString("CALIFICACION");
                registros[7]=rs.getString("CICLO");
                
                modelo.addRow(registros);
            }
            tablaCalificaciones.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL MOSTRAR DATOS " + e.getMessage());
        }
    }
    
    public void actualizarDatos(){
        
        try {
            
            String SQL = "update   ALUMNO_CALIFICACION set ID_ALUMNO_CALIFICACION=?, FK_ID_MATRICULA=?, FK_ID_MATERIA=?, FK_ID_MAESTRO=?, FK_ID_ESTATUS=?, FK_ID_TUTOR=?, CALIFICACION=?, CICLO=?";
            
            int filaSeleccionada=tablaCalificaciones.getSelectedRow();
            String dao=(String)tablaCalificaciones.getValueAt(filaSeleccionada, 0);
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setInt(1, Integer.parseInt(txtIdCali.getText()));
            pst.setInt(2, Integer.parseInt(txtIdMatricula.getText()));
            pst.setInt(3, Integer.parseInt(txtIdMateria.getText()));
            pst.setInt(4, Integer.parseInt(txtIdMaestro.getText()));
            pst.setInt(5, Integer.parseInt(txtIdEstatus.getText()));
            pst.setInt(6, Integer.parseInt(txtIdTutor.getText()));
            pst.setInt(7, Integer.parseInt(txtCalificacion.getText()));
            pst.setString(8, txtCiclo.getText());
            
            pst.setString(9, dao);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro editado de manera exitosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE EDICION " + e.getMessage());
        }
    }
    
    public void filtrarDatos(String valor){
        String [] titulos = {"ID alumno calificacion","ID Matricula","ID Materia","ID Maestro","ID Estatus","ID Tutor","Calificacion", "Ciclo"};
        String [] registros = new String[8];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        String SQL = "select * from  ALUMNO_CALIFICACION where ID_ALUMNOS_CALIFICACION like '%"+valor+"%' ";
        
        try {
            Statement st =con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                registros[0]= rs.getString("ID_ALUMNO_CALIFICACION");
                registros[1]= rs.getString("FK_ID_MATRICULA");
                registros[2]=rs.getString("FK_ID_MATERIA");
                registros[3]=rs.getString("FK_ID_MAESTRO");
                registros[4]=rs.getString("FK_ID_ESTATUS");
                registros[5]=rs.getString("FK_ID_TUTOR");
                registros[6]=rs.getString("CALIFICACION");
                registros[7]=rs.getString("CICLO");
                
                modelo.addRow(registros);
            }
            tablaCalificaciones.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL MOSTRAR DATOS " + e.getMessage());
        }
    }
    
    public void eliminarRegistro(){
        int filaSeleccionada=tablaCalificaciones.getSelectedRow();
        
        try {
            String SQL = "delete from ALUMNO_CALIFICACION where ID_ALUMNO_CALIFICACION =" +tablaCalificaciones.getValueAt(filaSeleccionada,0 );
            
            Statement st=con.createStatement();
            
            int n = st.executeUpdate(SQL);
            if(n>=0){
                JOptionPane.showMessageDialog(null, "Registro eliminado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL BORRAR REGISTRO " + e.getMessage());
        }
    }
    
    
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIdCali = new javax.swing.JTextField();
        txtIdMatricula = new javax.swing.JTextField();
        txtIdMateria = new javax.swing.JTextField();
        txtIdMaestro = new javax.swing.JTextField();
        txtIdEstatus = new javax.swing.JTextField();
        txtIdTutor = new javax.swing.JTextField();
        txtCalificacion = new javax.swing.JTextField();
        txtCiclo = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnConsultas = new javax.swing.JButton();
        btnAlumnos = new javax.swing.JButton();
        btnMaestros = new javax.swing.JButton();
        btnMaterias = new javax.swing.JButton();
        btnTutores = new javax.swing.JButton();
        btnEstatus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCalificaciones = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Registro Calificaciones");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("ID Alumno Calificacion:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("ID Matricula:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("ID Materia:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("ID Maestro:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("ID Estatus:");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("ID Tutor:");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Calificacion:");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Ciclo:");

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

        btnBorrar.setForeground(new java.awt.Color(0, 0, 0));
        btnBorrar.setText("Borrar");
        btnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnConsultas.setForeground(new java.awt.Color(0, 0, 0));
        btnConsultas.setText("Consultas");
        btnConsultas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });

        btnAlumnos.setForeground(new java.awt.Color(0, 0, 0));
        btnAlumnos.setText("Alumnos");
        btnAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
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

        btnMaterias.setForeground(new java.awt.Color(0, 0, 0));
        btnMaterias.setText("Materias");
        btnMaterias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMateriasActionPerformed(evt);
            }
        });

        btnTutores.setForeground(new java.awt.Color(0, 0, 0));
        btnTutores.setText("Tutores");
        btnTutores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutoresActionPerformed(evt);
            }
        });

        btnEstatus.setForeground(new java.awt.Color(0, 0, 0));
        btnEstatus.setText("Estatus");
        btnEstatus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdCali)
                            .addComponent(txtIdMatricula)
                            .addComponent(txtIdMateria)
                            .addComponent(txtIdMaestro)
                            .addComponent(txtIdEstatus)
                            .addComponent(txtIdTutor)
                            .addComponent(txtCalificacion)
                            .addComponent(txtCiclo, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnMaestros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnMaterias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTutores, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnConsultas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdCali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIdMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIdMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtIdMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtIdTutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMaterias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnMaestros, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTutores, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68))
        );

        tablaCalificaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaCalificaciones.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaCalificaciones.setMinimumSize(new java.awt.Dimension(600, 600));
        tablaCalificaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaCalificacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaCalificaciones);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Buscar:");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar)))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        
    }//GEN-LAST:event_txtBuscarActionPerformed

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

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        filtrarDatos(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void tablaCalificacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaCalificacionesMouseClicked
        int filaSeleccionada = tablaCalificaciones.rowAtPoint(evt.getPoint());
        
        txtIdCali.setText(tablaCalificaciones.getValueAt(filaSeleccionada, 0).toString());
        txtIdMatricula.setText(tablaCalificaciones.getValueAt(filaSeleccionada, 1).toString());
        txtIdMateria.setText(tablaCalificaciones.getValueAt(filaSeleccionada, 2).toString());
        txtIdMaestro.setText(tablaCalificaciones.getValueAt(filaSeleccionada, 3).toString());
        txtIdEstatus.setText(tablaCalificaciones.getValueAt(filaSeleccionada, 4).toString());
        txtIdTutor.setText(tablaCalificaciones.getValueAt(filaSeleccionada, 5).toString());
        txtCalificacion.setText(tablaCalificaciones.getValueAt(filaSeleccionada, 6).toString());
        txtCiclo.setText(tablaCalificaciones.getValueAt(filaSeleccionada, 7).toString());
    }//GEN-LAST:event_tablaCalificacionesMouseClicked

    private void btnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasActionPerformed
        FormularioDatosCalificacion fd = new FormularioDatosCalificacion();
        fd.setVisible(true);
        fd.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnConsultasActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        eliminarRegistro();
        mostrarDatos();
        limpiarCajas();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        FormularioAlumno fa = new FormularioAlumno();
        fa.setVisible(true);
        fa.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnAlumnosActionPerformed

    private void btnMaestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaestrosActionPerformed
        FormularioMaestros fm = new FormularioMaestros();
        fm.setVisible(true);
        fm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMaestrosActionPerformed

    private void btnMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMateriasActionPerformed
        FormularioMaterias fma = new FormularioMaterias();
        fma.setVisible(true);
        fma.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMateriasActionPerformed

    private void btnTutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutoresActionPerformed
        FormularioTutores ft = new FormularioTutores();
        ft.setVisible(true);
        ft.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnTutoresActionPerformed

    private void btnEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstatusActionPerformed
        FormularioEstatus fe = new FormularioEstatus();
        fe.setVisible(true);
        fe.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEstatusActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioCalificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioCalificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioCalificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioCalificaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioCalificaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnEstatus;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMaestros;
    private javax.swing.JButton btnMaterias;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnTutores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaCalificaciones;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCalificacion;
    private javax.swing.JTextField txtCiclo;
    private javax.swing.JTextField txtIdCali;
    private javax.swing.JTextField txtIdEstatus;
    private javax.swing.JTextField txtIdMaestro;
    private javax.swing.JTextField txtIdMateria;
    private javax.swing.JTextField txtIdMatricula;
    private javax.swing.JTextField txtIdTutor;
    // End of variables declaration//GEN-END:variables
}
