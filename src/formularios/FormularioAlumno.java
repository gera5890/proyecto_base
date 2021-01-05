
package formularios;


import conexionSQL.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormularioAlumno extends javax.swing.JFrame {
    
    ConexionSQL cc = new ConexionSQL();
    Connection con =cc.conexion();

    
    public FormularioAlumno() {
        initComponents();
        mostrarDatos();
        
        
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(getBackground());
    }
    
    public void insertarDatos(){
        
        try {
            String SQL = "insert into ALUMNOS (ID_MATRICULA, NOMBRE_ALUMNO,APELLIDO_P,APELLIDO_M,CORREO,TELEFONO,DOMICILIO,SEXO) values (?,?,?,?,?,?,?,?)" ;
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setInt(1, Integer.parseInt(txtMatricula.getText()));
            pst.setString(2, txtNombre.getText());
            pst.setString(3, txtPaterno.getText());
            pst.setString(4, txtMaterno.getText());
            pst.setString(5, txtCorreo.getText());
            pst.setString(6, txtTelefono.getText());
            pst.setString(7, txtDomicilio.getText());
            
            int sexo = cbSexo.getSelectedIndex();
            pst.setString(8, cbSexo.getItemAt(sexo));
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE REGISTRO" + e);
        }
    }
    
    public void limpiarCajas(){
        txtMatricula.setText("");
        txtNombre.setText("");
        txtPaterno.setText("");
        txtMaterno.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtDomicilio.setText("");
        cbSexo.setSelectedItem(null);
        
    }
    
    public void mostrarDatos(){
        String [] titulos = {"Matricula      ","Nombre","Apellido_p", "Apellido_m","Correo","Telefono","Domicilio","Sexo"};
        String [] registros = new String[8];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL ="select * from ALUMNOS";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                registros[0]=rs.getString("ID_MATRICULA");
                registros[1]=rs.getString("NOMBRE_ALUMNO");
                registros[2]=rs.getString("APELLIDO_P");
                registros[3]=rs.getString("APELLIDO_M");
                registros[4]=rs.getString("CORREO");
                registros[5]=rs.getString("TELEFONO");
                registros[6]=rs.getString("DOMICILIO");
                registros[7]=rs.getString("SEXO");
                
                modelo.addRow(registros);
                
            }
            tablaAlumnos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL MOSTRAR DATOS" +  e);
        }
        
       
      
        
    }
    public void actualizarDatos(){
        
        try {
            String SQL = "update ALUMNOS set ID_MATRICULA=?, NOMBRE_ALUMNO=?,APELLIDO_P=?,APELLIDO_M=?,CORREO=?,TELEFONO=?,DOMICILIO=?,SEXO=? where ID_MATRICULA=?" ;
            
            int filaSeleccionada=tablaAlumnos.getSelectedRow();
            String dao =(String)tablaAlumnos.getValueAt(filaSeleccionada, 0);
            
            PreparedStatement pst = con.prepareStatement(SQL);
            
            pst.setInt(1, Integer.parseInt(txtMatricula.getText()));
            pst.setString(2, txtNombre.getText());
            pst.setString(3, txtPaterno.getText());
            pst.setString(4, txtMaterno.getText());
            pst.setString(5, txtCorreo.getText());
            pst.setString(6, txtTelefono.getText());
            pst.setString(7, txtDomicilio.getText());
            
            
            int sexo = cbSexo.getSelectedIndex();
            pst.setString(8, cbSexo.getItemAt(sexo));
            
            pst.setString(9, dao);
            
            pst.execute();
            JOptionPane.showMessageDialog(null, "Registro Editado de manera exitosa");
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR DE EDICION" + e);
        }
    }
    
    public void filtrarDatos(String valor){
        String [] titulos = {"Matricula","Nombre","Apellido_p", "Apellido_m","Correo","Telefono","Domicilio","Sexo"};
        String [] registros = new String[8];
        
        DefaultTableModel modelo = new DefaultTableModel(null, titulos);
        
        String SQL ="select * from ALUMNOS where ID_MATRICULA  like '%"+valor+"%' ";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            
            while(rs.next()){
                registros[0]=rs.getString("ID_MATRICULA");
                registros[1]=rs.getString("NOMBRE_ALUMNO");
                registros[2]=rs.getString("APELLIDO_P");
                registros[3]=rs.getString("APELLIDO_M");
                registros[4]=rs.getString("CORREO");
                registros[5]=rs.getString("TELEFONO");
                registros[6]=rs.getString("DOMICILIO");
                registros[7]=rs.getString("SEXO");
                
                modelo.addRow(registros);
                
            }
            tablaAlumnos.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL MOSTRAR DATOS" +  e);
        }       
    }
    
    //Vamos al boton actualizar, action, action performed y mandamos metodo
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtPaterno = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDomicilio = new javax.swing.JTextField();
        cbSexo = new javax.swing.JComboBox<>();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnMaterias = new javax.swing.JButton();
        btnMaestros = new javax.swing.JButton();
        btnEstatus = new javax.swing.JButton();
        btnTutores = new javax.swing.JButton();
        btnCalificacion = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Matricula:");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido Paterno:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellido Materno:");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Correo:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Teléfono:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Domicilio:");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Sexo:");

        txtMatricula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatriculaActionPerformed(evt);
            }
        });

        cbSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer" }));
        cbSexo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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

        jLabel10.setFont(new java.awt.Font("Lucida Bright", 3, 21)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Registro de Alumnos UPVM");

        btnMaterias.setForeground(new java.awt.Color(0, 0, 0));
        btnMaterias.setText("Materias");
        btnMaterias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMateriasActionPerformed(evt);
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

        btnTutores.setForeground(new java.awt.Color(0, 0, 0));
        btnTutores.setText("Tutores");
        btnTutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutoresActionPerformed(evt);
            }
        });

        btnCalificacion.setForeground(new java.awt.Color(0, 0, 0));
        btnCalificacion.setText("Calificaciones");
        btnCalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalificacionActionPerformed(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Consultas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel8)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(65, 65, 65)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtCorreo))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMaterno))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPaterno))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNombre))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnCalificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnTutores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEstatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnMaestros, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel10)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel10)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDomicilio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMaestros, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTutores, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setText("Busqueda:");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaAlumnos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tablaAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaAlumnos.setMaximumSize(new java.awt.Dimension(3000, 3000));
        tablaAlumnos.setMinimumSize(new java.awt.Dimension(3000, 3000));
        tablaAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAlumnosMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tablaAlumnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMatriculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatriculaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatriculaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarCajas();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        insertarDatos();
        limpiarCajas();
        mostrarDatos();
    }//GEN-LAST:event_btnGuardarActionPerformed
//enviar datos a la tabla al hacer click, click derecho en tabla, eventos y mouse click
    private void tablaAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAlumnosMouseClicked
        int filaSeleccionada = tablaAlumnos.rowAtPoint(evt.getPoint());
        
        txtMatricula.setText(tablaAlumnos.getValueAt(filaSeleccionada,0 ).toString());
        txtNombre.setText(tablaAlumnos.getValueAt(filaSeleccionada,1 ).toString());
        txtPaterno.setText(tablaAlumnos.getValueAt(filaSeleccionada,2 ).toString());
        txtMaterno.setText(tablaAlumnos.getValueAt(filaSeleccionada,3 ).toString());
        txtCorreo.setText(tablaAlumnos.getValueAt(filaSeleccionada,4 ).toString());
        txtTelefono.setText(tablaAlumnos.getValueAt(filaSeleccionada,5 ).toString());
        txtDomicilio.setText(tablaAlumnos.getValueAt(filaSeleccionada,6 ).toString());
        cbSexo.setSelectedItem(tablaAlumnos.getValueAt(filaSeleccionada, 7));
        
        
    }//GEN-LAST:event_tablaAlumnosMouseClicked

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarDatos();
        limpiarCajas();
        mostrarDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        filtrarDatos(txtBuscar.getText());
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMateriasActionPerformed
       FormularioMaterias fra = new FormularioMaterias();
       fra.setVisible(true);
       fra.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMateriasActionPerformed

    private void btnMaestrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaestrosActionPerformed
        FormularioMaestros fm = new FormularioMaestros();
       fm.setVisible(true);
       fm.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMaestrosActionPerformed

    private void btnEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstatusActionPerformed
        FormularioEstatus fe = new FormularioEstatus();
        fe.setVisible(true);
        fe.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEstatusActionPerformed

    private void btnTutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutoresActionPerformed
        FormularioTutores ft = new FormularioTutores();
        ft.setVisible(true);
        ft.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnTutoresActionPerformed

    private void btnCalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalificacionActionPerformed
        FormularioCalificaciones fc = new FormularioCalificaciones();
        fc.setVisible(true);
        fc.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCalificacionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FormularioDatosCalificacion fc = new FormularioDatosCalificacion();
        fc.setVisible(true);
        fc.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(FormularioAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioAlumno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioAlumno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCalificacion;
    private javax.swing.JButton btnEstatus;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMaestros;
    private javax.swing.JButton btnMaterias;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnTutores;
    private javax.swing.JComboBox<String> cbSexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable tablaAlumnos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDomicilio;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
