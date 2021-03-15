/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Controladores.EmpleadosJpaController;
import Controladores.ProductosJpaController;
import Controladores.UsuariosJpaController;
import Controladores.exceptions.IllegalOrphanException;
import Controladores.exceptions.NonexistentEntityException;
import Entidades.Empleados;
import Entidades.Productos;
import Entidades.Usuarios;
import Visual.RegistroEmpleados;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ricardo Avalos
 */
public class AdminOpciones extends javax.swing.JFrame {

    private final EmpleadosJpaController empCon = new EmpleadosJpaController();
    private Empleados emp = new Empleados();
    private final ProductosJpaController mercanciaCon = new ProductosJpaController();
    private Usuarios us = new Usuarios();
    private final UsuariosJpaController usCon = new UsuariosJpaController();
    private static String idSesion;
    private static boolean result;

    public static String getIdSesion() {
        return idSesion;
    }

    public static void setIdSesion(String idSesion) {
        AdminOpciones.idSesion = idSesion;
    }

    
    
    public DefaultTableModel cargarTablaEmpleados (JTable tabla){
        
        limpiarTablaEmpleados();
        
        EmpleadosJpaController empleado = new EmpleadosJpaController();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        List<Empleados> lista = new LinkedList();
        lista = empleado.findEmpleadosEntities();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        
        for (int i = 0; i < lista.size(); i++) {
           
         
	 Object[] datosRegistro

			 = {

	lista.get(i).getId(),

	lista.get(i).getNombre(),
        
        dateFormat.format(lista.get(i).getNacimiento()),

	lista.get(i).getPuesto(),

	lista.get(i).getSexo(),
        
        lista.get(i).getId()

	
};

	

        model.addRow(datosRegistro);
        
        }

	return model;
        
    }
    
    public DefaultTableModel cargarTablaUsuarios (JTable tabla){
        
        limpiarTablaUsuarios();
        
        UsuariosJpaController usuario = new UsuariosJpaController();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        List<Usuarios> lista = new LinkedList();
        lista = usuario.findUsuariosEntities();
        
        for (int i = 0; i < lista.size(); i++) {
           
         
	 Object[] datosRegistro

			 = {

	lista.get(i).getIdEmp().getId(),
                             
        lista.get(i).getIdEmp().getNombre(),

	lista.get(i).getIdUsuario(),

	lista.get(i).getNivel()

	
};

	

        model.addRow(datosRegistro);
        
        }

	return model;
        
    }
    
    public void limpiarTablaEmpleados(){
        
        jtEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Fecha", "Puesto", "Sexo"
            }
        ));
        
    }
    
    public void limpiarTablaUsuarios(){
        
        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID de empleado", "Nombre de empleado", "ID de usuario", "Nivel de acceso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
    }
    
    
    public void limpiar(){
        txtNombre.setText("");
        dcFecha.setDate(null);
        cmbPuesto.setSelectedItem("Vendendor");
        radFem.setSelected(false);
        radMas.setSelected(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    public void mostrar(int status){
        if(status == 1){
            passContraU.setEchoChar((char)(0));
            result = true;
        }
    }
    
    
    public AdminOpciones() {
        initComponents();
        cargarTablaEmpleados(jtEmpleados);
        cargarTablaUsuarios(jtUsuarios);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpUsuarios = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombreU = new javax.swing.JTextField();
        txtNivelUsuario = new javax.swing.JTextField();
        txtIDusuario = new javax.swing.JTextField();
        txtIDempleado = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        btnEditarContra = new javax.swing.JButton();
        passContraU = new javax.swing.JPasswordField();
        jpEmpleados = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        radMas = new javax.swing.JRadioButton();
        radFem = new javax.swing.JRadioButton();
        cmbPuesto = new javax.swing.JComboBox<>();
        btnAnadir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtEmpleados = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        cmbSeccion = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cmbTipoProducto = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        cmbMarca = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtIDproducto = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(690, 610));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jpUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpUsuariosMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Nombre del empleado:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("ID de usuario:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("ID de empleado");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Nivel de acceso:");

        txtNombreU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombreU.setEnabled(false);

        txtNivelUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNivelUsuario.setToolTipText("");
        txtNivelUsuario.setEnabled(false);

        txtIDusuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIDusuario.setEnabled(false);

        txtIDempleado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtIDempleado.setEnabled(false);

        jtUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID de empleado", "Nombre de empleado", "ID de usuario", "Nivel de acceso"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtUsuariosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtUsuarios);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Contraseña:");

        btnMostrar.setText("Mostrar contraseña");
        btnMostrar.setEnabled(false);
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });

        btnEditarContra.setText("Editar contraseña");
        btnEditarContra.setEnabled(false);

        passContraU.setEditable(false);
        passContraU.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jpUsuariosLayout = new javax.swing.GroupLayout(jpUsuarios);
        jpUsuarios.setLayout(jpUsuariosLayout);
        jpUsuariosLayout.setHorizontalGroup(
            jpUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuariosLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jpUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpUsuariosLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(60, 60, 60)
                        .addComponent(txtIDempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jLabel7)
                        .addGap(45, 45, 45)
                        .addComponent(txtIDusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpUsuariosLayout.createSequentialGroup()
                        .addGroup(jpUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jpUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passContraU, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(txtNombreU))
                        .addGap(60, 60, 60)
                        .addGroup(jpUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpUsuariosLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(33, 33, 33)
                                .addComponent(txtNivelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpUsuariosLayout.createSequentialGroup()
                                .addComponent(btnMostrar)
                                .addGap(6, 6, 6)
                                .addComponent(btnEditarContra))))))
        );
        jpUsuariosLayout.setVerticalGroup(
            jpUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpUsuariosLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jpUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtIDempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtIDusuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtNombreU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtNivelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMostrar)
                    .addComponent(btnEditarContra)
                    .addGroup(jpUsuariosLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel11))
                    .addComponent(passContraU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Usuarios", jpUsuarios);

        jpEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEmpleadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpEmpleadosMouseEntered(evt);
            }
        });
        jpEmpleados.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Sexo:");
        jpEmpleados.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 98, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Puesto:");
        jpEmpleados.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 130, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jpEmpleados.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 30, 216, -1));

        radMas.setText("Masculino");
        jpEmpleados.add(radMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 97, -1, -1));

        radFem.setText("Femenino");
        jpEmpleados.add(radFem, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 97, -1, -1));

        cmbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Gerente", "Administrador" }));
        cmbPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPuestoActionPerformed(evt);
            }
        });
        jpEmpleados.add(cmbPuesto, new org.netbeans.lib.awtextra.AbsoluteConstraints(289, 130, 131, -1));

        btnAnadir.setText("Añadir");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });
        jpEmpleados.add(btnAnadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 129, -1, -1));

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jtEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Fecha", "Puesto", "Sexo"
            }
        ));
        jtEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtEmpleadosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jtEmpleadosMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jtEmpleados);

        jpEmpleados.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 170, 550, 188));

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jpEmpleados.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 384, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jpEmpleados.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 384, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre completo: ");
        jpEmpleados.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 30, -1, -1));

        dcFecha.setDateFormatString("dd/MM/yy");
        jpEmpleados.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(328, 67, 173, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Fecha de nacimiento (dd/mm/aa):");
        jpEmpleados.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 60, -1, 27));
        jpEmpleados.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, -40, -1, -1));

        jTabbedPane1.addTab("Empleados", jpEmpleados);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Categoria:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Color");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Seccion:");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("ID (Generado):");

        txtColor.setText("Blanco");

        cmbSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer", "Niño", "Niña", "Accesorios" }));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Nombre del producto:");

        cmbTipoProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tenis", "Balon", "Guantes", "Playeras", "Chamarras", "Mochilas", " ", " " }));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        cmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nike", "Jordan", "Adidas", "Under Armor", "Puma", "Everlast" }));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Cantidad a ingresar:");

        txtNombreProducto.setText("AirForce1");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Precio unitario:");

        txtIDproducto.setEditable(false);
        txtIDproducto.setText("M-NIKE-Airforce1-Blanco");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Marca:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(btnRegistrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel16)
                            .addComponent(jLabel8)
                            .addComponent(jLabel17)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12)
                            .addComponent(jLabel20))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cmbTipoProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbSeccion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNombreProducto)
                                .addComponent(txtIDproducto)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(72, 72, 72))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(txtIDproducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(32, 32, 32)
                .addComponent(btnRegistrar)
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Alta de productos", jPanel2);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 650, 470));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("interDeportes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 11, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed

        emp.setNombre(txtNombre.getText());
        emp.setNacimiento(dcFecha.getDate());
        char seccion;
        seccion = (radFem.isSelected())?'F':'M';
        emp.setSexo(seccion);
        emp.setPuesto(cmbPuesto.getSelectedItem().toString());
        List<Empleados> lista = empCon.findEmpleadosEntities();
        empCon.create(emp);
        if(empCon.equals(lista)){
            JOptionPane.showMessageDialog(this, "Error al añadir empleado");
        }else{
            JOptionPane.showMessageDialog(this, "Empleado añadido exitosamente");
            limpiar();
            cargarTablaEmpleados(jtEmpleados);
        }

    }//GEN-LAST:event_btnAnadirActionPerformed

    private void jtEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEmpleadosMouseClicked
        int id = (int)(jtEmpleados.getValueAt(jtEmpleados.getSelectedRow(), 0));
        txtNombre.setText(empCon.findEmpleados(id).getNombre());
        dcFecha.setDate(empCon.findEmpleados(id).getNacimiento());
        String seccion = (empCon.findEmpleados(id).getSexo().equals('M'))?"Masculino":"Femenino";
        if (seccion.equals("Masculino")){
            radMas.setSelected(true);
        }else{
            radFem.setSelected(true);
        }
        cmbPuesto.setSelectedItem(empCon.findEmpleados(id).getPuesto());

        btnEditar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_jtEmpleadosMouseClicked

    private void jtEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEmpleadosMouseEntered

    }//GEN-LAST:event_jtEmpleadosMouseEntered

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        emp.setId((int)(jtEmpleados.getValueAt(jtEmpleados.getSelectedRow(), 0)));
        emp.setNombre(txtNombre.getText());
        emp.setNacimiento(dcFecha.getDate());
        char seccion;
        seccion = (radFem.isSelected())?'F':'M';
        emp.setSexo(seccion);
        emp.setPuesto(cmbPuesto.getSelectedItem().toString());
        List<Empleados> lista = empCon.findEmpleadosEntities();
 
        try {
            empCon.edit(emp);
            
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(RegistroEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(RegistroEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }

        if(empCon.equals(lista)){
            JOptionPane.showMessageDialog(this, "Error al editar empleado");
        }else{
            JOptionPane.showMessageDialog(this, "Empleado editado exitosamente");
            limpiar();
            cargarTablaEmpleados(jtEmpleados);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        try {
            empCon.destroy((int)jtEmpleados.getValueAt(jtEmpleados.getSelectedRow(), 0));
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(RegistroEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(RegistroEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Empleados> lista = empCon.findEmpleadosEntities();

        if(empCon.equals(lista)){
            JOptionPane.showMessageDialog(this, "Error al eliminar empleado");
        }else{
            JOptionPane.showMessageDialog(this, "Empleado eliminado exitosamente");
            limpiar();
            cargarTablaEmpleados(jtEmpleados);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        new Autenticacion(this, rootPaneCheckingEnabled).setVisible(true);
        if(result){
            passContraU.setEchoChar((char)0);
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void cmbPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPuestoActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        Productos mercancia = new Productos();
        boolean conv = false;
        mercancia.setCategoria(cmbTipoProducto.getSelectedItem().toString());
        mercancia.setColor(txtColor.getText());
        mercancia.setMarca((String)cmbMarca.getSelectedItem());
        mercancia.setNombre(txtNombreProducto.getText());
        char seccion = ("Hombre".equals((String)cmbSeccion.getSelectedItem()))?'M':'F';
        mercancia.setSeccion(seccion);
        
        try {
            mercancia.setCantidad(Integer.parseInt(txtCantidad.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e);
            conv = true;
        }
        
        try {
            mercancia.setPrecio(Float.parseFloat(txtPrecio.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e);
            conv = true;
        }
        
        
        mercancia.setId(mercancia.getSeccion()+"-"+mercancia.getMarca()+"-"+mercancia.getNombre()+"-"+mercancia.getColor());
        txtIDproducto.setText(mercancia.getId());

        if (conv == false){
            
            try {
                mercanciaCon.create(mercancia);
                
            } catch (Exception ex) {
                Logger.getLogger(AdminOpciones.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this,"Error al guardar");
            }
            JOptionPane.showMessageDialog(this,"Datos guardados");
            txtPrecio.setText("");
            txtColor.setText("");
            txtNombreProducto.setText("");
            txtCantidad.setText("");
        }else{
            
        }


    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jtUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuariosMouseClicked
        int fila = jtUsuarios.getSelectedRow();
        
        us = usCon.findUsuarios(jtUsuarios.getValueAt(fila, 2).toString());
        txtIDempleado.setText(us.getIdEmp().getId().toString());
        txtNombreU.setText(us.getIdEmp().getNombre());
        passContraU.setText(us.getContra());
        txtIDusuario.setText(us.getIdUsuario());
        txtNivelUsuario.setText(String.valueOf(us.getNivel()));
        
        btnMostrar.setEnabled(true);
        btnEditarContra.setEnabled(true);
    }//GEN-LAST:event_jtUsuariosMouseClicked

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jpEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEmpleadosMouseClicked
        
    }//GEN-LAST:event_jpEmpleadosMouseClicked

    private void jpEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEmpleadosMouseEntered
        
    }//GEN-LAST:event_jpEmpleadosMouseEntered

    private void jpUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpUsuariosMouseExited
        Timer tiempo = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                passContraU.setEchoChar('*');
                tiempo.cancel();
            }
        };
        tiempo.schedule(tarea, 10000, 1);
        
    }//GEN-LAST:event_jpUsuariosMouseExited

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
            java.util.logging.Logger.getLogger(AdminOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminOpciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminOpciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditarContra;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JComboBox<String> cmbPuesto;
    private javax.swing.JComboBox<String> cmbSeccion;
    private javax.swing.JComboBox<String> cmbTipoProducto;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jpEmpleados;
    private javax.swing.JPanel jpUsuarios;
    private javax.swing.JTable jtEmpleados;
    private javax.swing.JTable jtUsuarios;
    private javax.swing.JPasswordField passContraU;
    private javax.swing.JRadioButton radFem;
    private javax.swing.JRadioButton radMas;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtIDempleado;
    private javax.swing.JTextField txtIDproducto;
    private javax.swing.JTextField txtIDusuario;
    private javax.swing.JTextField txtNivelUsuario;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtNombreU;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
}
