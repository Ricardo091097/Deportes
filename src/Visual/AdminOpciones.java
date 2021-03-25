/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visual;

import Controladores.DetallesVentaJpaController;
import Controladores.EmpleadosJpaController;
import Controladores.ProductosJpaController;
import Controladores.ProvedoresJpaController;
import Controladores.UsuariosJpaController;
import Controladores.VentasJpaController;
import Controladores.exceptions.IllegalOrphanException;
import Controladores.exceptions.NonexistentEntityException;
import Controladores.exceptions.PreexistingEntityException;
import Entidades.DetallesVenta;
import Entidades.Empleados;
import Entidades.Productos;
import Entidades.Provedores;
import Entidades.Usuarios;
import Entidades.Ventas;
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
    public static Productos pro = new Productos();

    public static String getIdSesion() {
        return idSesion;
    }

    public static void setIdSesion(String idSesion) {
        AdminOpciones.idSesion = idSesion;
    }

    
    public void cargarTablaEmpleados (JTable tabla){
        
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

	tabla.setModel(model);
        
    }
    
    public void cargarTablaUsuarios (JTable tabla){
        
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

	tabla.setModel(model);
        
    }
    
    public void cargarTablaExistencias (){
        
        limpiarTablaExistencias();
        
        DefaultTableModel model = (DefaultTableModel) jtExistencias.getModel();
        ProductosJpaController merca = new ProductosJpaController();
        List<Productos> lista = new LinkedList();
        lista = merca.findProductosEntities();
        
        for (int i = 0; i < lista.size(); i++) {
           
         
	 Object[] datosRegistro

			 = {

	lista.get(i).getId(),
                             
        lista.get(i).getSeccion(),

	lista.get(i).getCategoria(),

	lista.get(i).getMarca(),
        
        lista.get(i).getNombre(),
        
        lista.get(i).getColor(),
        
        lista.get(i).getPrecio(),
        
        lista.get(i).getCantidad()

	
        };

	

        model.addRow(datosRegistro);
        
        }

	jtExistencias.setModel(model);
        
    }
    
    public void cargarTablaProvedores (){
        
        limpiarTablaExistencias();
        
        DefaultTableModel model = (DefaultTableModel) jtTablaProvedores.getModel();
        ProvedoresJpaController provedor = new ProvedoresJpaController();
        List<Provedores> lista = new LinkedList();
        lista = provedor.findProvedoresEntities();
        
        for (int i = 0; i < lista.size(); i++) {
           
         
	 Object[] datosRegistro

			 = {

	lista.get(i).getId(),
                             
        lista.get(i).getNombre(),

	lista.get(i).getTelefono(),

	lista.get(i).getCorreo(),
        
        lista.get(i).getNombrecontacto()
        
	
        };

	

        model.addRow(datosRegistro);
        
        }

	jtTablaProvedores.setModel(model);
        
    }
    
    public void cargarTablaVentas (JTable tabla){
        
        limpiarTablaVentas();
        
        VentasJpaController ventas = new VentasJpaController();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        List<Ventas> lista = new LinkedList();
        lista = ventas.findVentasEntities();
        
        for (int i = 0; i < lista.size(); i++) {
           
         
	 Object[] datosRegistro

			 = {

	lista.get(i).getNoVenta(),

	lista.get(i).getIdVendedor().getIdEmp().getNombre(),

	lista.get(i).getTotal(),

	lista.get(i).getFecha()
        

	
};

	

        model.addRow(datosRegistro);
        
        }

	tabla.setModel(model);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeportesPU");
        EntityManager em = emf.createEntityManager();
        Query consulta = em.createNamedQuery("Ventas.countAllTotal");
        List resultado = consulta.getResultList();
        txtVentasTotales.setText(String.valueOf(resultado.get(0)));
        
    }
    
    public void cargarTablaDetalles (List<DetallesVenta> lista){
        
        jtDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Precio unitario", "Cantidad", "Sub-total"
            }
        ));
        
        UsuariosJpaController usuario = new UsuariosJpaController();
        DefaultTableModel model = (DefaultTableModel) jtDetalleVenta.getModel();
        float sub = 0;
        
        for (int i = 0; i < lista.size(); i++) {
           
         sub = lista.get(i).getCantidad()*lista.get(i).getProductos().getPrecio();
         
	 Object[] datosRegistro

			 = {

	lista.get(i).getProductos().getNombre(),
                             
        lista.get(i).getProductos().getPrecio(),

	lista.get(i).getCantidad(),

	sub

	
        };

	

        model.addRow(datosRegistro);
        
        }

	jtDetalleVenta.setModel(model);
        
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
    
    public void limpiarTablaExistencias(){
        jtExistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "ID", "Seccion", "Categoria", "Marca", "Nombre", "Color", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
    }
    
    public void limpiarTablaVentas(){
        
        jtVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                
            },
            new String [] {
                "No", "Vendedor", "Total", "Fecha"
            }
        ){
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
    }
    
    public void limpiarEmpleados(){
        txtNombre.setText("");
        dcFecha.setDate(null);
        cmbPuesto.setSelectedItem("Vendendor");
        radFem.setSelected(false);
        radMas.setSelected(false);
        btnEditar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }
    
    public void limpiarUsuarios(){
        txtIDusuario.setText("");
        passContraU.setText("");
        cmbIDempleado.setSelectedIndex(0);
    }
    
    public void mostrar(int status){
        if(status == 1){
            passContraU.setEchoChar((char)(0));
            result = true;
        }
    }
    
    public void cargarComboBox(){
        List<Empleados> lista = empCon.findEmpleadosEntities();
        String dato = null;
        for (Empleados empleados : lista) {
            dato = String.valueOf(empleados.getId())+" - "+empleados.getNombre();
            cmbIDempleado.addItem(dato);
        }
        
    }
      
    public AdminOpciones() {
        initComponents();
        cargarTablaEmpleados(jtEmpleados);
        cargarTablaUsuarios(jtUsuarios);
        cargarTablaExistencias();
        cargarTablaVentas(jtVentas);
        cargarComboBox();
        cargarTablaProvedores();
        jlabelErrorU.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpUsuarios = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtIDusuario = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtUsuarios = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        btnMostrar = new javax.swing.JButton();
        passContraU = new javax.swing.JPasswordField();
        btnEditarUsuario = new javax.swing.JButton();
        btnEliminarUusario = new javax.swing.JButton();
        btnCrearUsuario = new javax.swing.JButton();
        cmbIDempleado = new javax.swing.JComboBox<>();
        jlabelErrorU = new javax.swing.JLabel();
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
        txtColor = new javax.swing.JTextField();
        cmbSeccion = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        btnRegistrar = new javax.swing.JButton();
        cmbMarca = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        spinCantidad = new com.toedter.components.JSpinField();
        jPanel3 = new javax.swing.JPanel();
        txtIdInventarioEditar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnEditarInventario = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtExistencias = new javax.swing.JTable();
        btnEliminarInventario = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtDetalleVenta = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtNoVenta = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jtVentas = new javax.swing.JTable();
        txtVendedor = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtVentasTotales = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jtTablaProvedores = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtNombreProvedor = new javax.swing.JTextField();
        txtTelefonoProvedor = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtNombreContactoProvedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(780, 640));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jpUsuarios.setMinimumSize(new java.awt.Dimension(650, 443));
        jpUsuarios.setPreferredSize(new java.awt.Dimension(650, 443));
        jpUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jpUsuariosMouseExited(evt);
            }
        });
        jpUsuarios.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("ID de usuario:");
        jpUsuarios.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("ID de empleado:");
        jpUsuarios.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, -1, -1));

        txtIDusuario.setEditable(false);
        txtIDusuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jpUsuarios.add(txtIDusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 119, -1));

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

        jpUsuarios.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 37, 585, 235));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Contraseña:");
        jpUsuarios.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 341, -1, -1));

        btnMostrar.setText("Mostrar contraseña");
        btnMostrar.setEnabled(false);
        btnMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarActionPerformed(evt);
            }
        });
        jpUsuarios.add(btnMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 130, -1));

        passContraU.setEditable(false);
        passContraU.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jpUsuarios.add(passContraU, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 119, -1));

        btnEditarUsuario.setText("Editar usuario");
        btnEditarUsuario.setEnabled(false);
        btnEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarUsuarioActionPerformed(evt);
            }
        });
        jpUsuarios.add(btnEditarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, -1, -1));

        btnEliminarUusario.setText("Eliminar usuario");
        btnEliminarUusario.setEnabled(false);
        jpUsuarios.add(btnEliminarUusario, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, -1, -1));

        btnCrearUsuario.setText("Crear nuevo usuario");
        jpUsuarios.add(btnCrearUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 140, -1));

        cmbIDempleado.setPreferredSize(new java.awt.Dimension(119, 22));
        cmbIDempleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbIDempleadoItemStateChanged(evt);
            }
        });
        jpUsuarios.add(cmbIDempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, -1, -1));

        jlabelErrorU.setForeground(new java.awt.Color(255, 0, 0));
        jlabelErrorU.setText("Ya existe un usuario con el ID de empleado seleccionado");
        jpUsuarios.add(jlabelErrorU, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 341, -1, -1));

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

        buttonGroup1.add(radMas);
        radMas.setText("Masculino");
        jpEmpleados.add(radMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 97, -1, -1));

        buttonGroup1.add(radFem);
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

        txtColor.setText("Blanco");

        cmbSeccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hombre", "Mujer", "Niño", "Niña", "Accesorios" }));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Nombre del producto:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tenis", "Balon", "Guantes", "Playeras", "Chamarras", "Mochilas", " ", " " }));

        btnRegistrar.setText("Guardar");
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

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Marca:");

        spinCantidad.setMinimum(0);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(141, 141, 141)
                        .addComponent(cmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(130, 130, 130)
                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(152, 152, 152)
                        .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(57, 57, 57)
                        .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(161, 161, 161)
                        .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(102, 102, 102)
                        .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(72, 72, 72)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrar)
                            .addComponent(spinCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(79, 79, 79))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(cmbSeccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(spinCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addGap(78, 78, 78))
        );

        jTabbedPane1.addTab("Alta de productos", jPanel2);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("ID:");

        btnEditarInventario.setText("Editar");
        btnEditarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarInventarioActionPerformed(evt);
            }
        });

        jtExistencias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Seccion", "Categoria", "Marca", "Nombre", "Color", "Precio", "Cantidad"
            }
        ));
        jtExistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtExistenciasMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jtExistencias);

        jScrollPane3.setViewportView(jScrollPane5);

        btnEliminarInventario.setText("Eliminar");
        btnEliminarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdInventarioEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(btnEliminarInventario))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtIdInventarioEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarInventario)
                    .addComponent(btnEliminarInventario))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Editar inventario", jPanel3);

        jtDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Precio unitario", "Cantidad", "Sub-total"
            }
        ));
        jScrollPane4.setViewportView(jtDetalleVenta);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Numero de venta");

        txtNoVenta.setEditable(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Vendedor");

        jtVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Ricardo", "1000", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "Vendedor", "Total", "Fecha"
            }
        ));
        jtVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtVentasMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jtVentas);

        txtVendedor.setEditable(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Ventas totales:");

        txtVentasTotales.setEditable(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel21.setText("Detalle de venta");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(68, 68, 68)
                                        .addComponent(txtVentasTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(57, 57, 57))
                    .addComponent(jSeparator1))
                .addGap(95, 95, 95))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(txtVentasTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("Registro de ventas", jPanel6);

        jtTablaProvedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Telefono", "Correo", "Nombre de contacto"
            }
        ));
        jtTablaProvedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaProvedoresMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jtTablaProvedores);
        if (jtTablaProvedores.getColumnModel().getColumnCount() > 0) {
            jtTablaProvedores.getColumnModel().getColumn(0).setResizable(false);
            jtTablaProvedores.getColumnModel().getColumn(0).setPreferredWidth(7);
            jtTablaProvedores.getColumnModel().getColumn(1).setPreferredWidth(10);
            jtTablaProvedores.getColumnModel().getColumn(2).setPreferredWidth(15);
            jtTablaProvedores.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Telefono: ");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Nombre:");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Correo:");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Nombre de contacto:");

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");

        jButton3.setText("Eliminar");

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(132, 132, 132)
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombreContactoProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefonoProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(60, 60, 60)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtNombreProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefonoProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtNombreContactoProvedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Provedores", jPanel5);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 650, 470));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel1.setText("interDeportes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked

    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void btnEliminarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInventarioActionPerformed
        String mensaje = "Producto eliminado.";
        int fila = jtExistencias.getSelectedRow();
        try {
            mercanciaCon.destroy((int)jtExistencias.getValueAt(fila, 0));
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AdminOpciones.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = "Error al eliminar producto";
        }
        JOptionPane.showMessageDialog(this, mensaje);
        cargarTablaExistencias();
    }//GEN-LAST:event_btnEliminarInventarioActionPerformed

    private void jtExistenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtExistenciasMouseClicked
        int fila = jtExistencias.getSelectedRow();
        txtIdInventarioEditar.setText((String)jtExistencias.getValueAt(fila, 4));
    }//GEN-LAST:event_jtExistenciasMouseClicked

    private void btnEditarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarInventarioActionPerformed

        ProductosJpaController mercaCon = new ProductosJpaController();
        int fila = jtExistencias.getSelectedRow();
        Productos merca = mercaCon.findProductos((int)jtExistencias.getValueAt(fila, 0));
        pro = merca;

        new EditarInventario(this, true).setVisible(true);
        txtIdInventarioEditar.setText("");
        cargarTablaExistencias();
    }//GEN-LAST:event_btnEditarInventarioActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed

        Productos mercancia = new Productos();
        boolean conv = false;
        mercancia.setCategoria(cmbCategoria.getSelectedItem().toString());
        mercancia.setColor(txtColor.getText());
        mercancia.setMarca((String)cmbMarca.getSelectedItem());
        mercancia.setNombre(txtNombreProducto.getText());
        char seccion = ("Hombre".equals((String)cmbSeccion.getSelectedItem()))?'M':'F';
        mercancia.setSeccion(seccion);
        mercancia.setCantidad(spinCantidad.getValue());

        try {
            mercancia.setPrecio(Float.parseFloat(txtPrecio.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e);
            conv = true;
        }

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
            spinCantidad.setValue(0);
            cargarTablaExistencias();
        }else{
            JOptionPane.showMessageDialog(this, "Debe ingresar únicamente numeros en la sección de precio");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jpEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEmpleadosMouseEntered

    }//GEN-LAST:event_jpEmpleadosMouseEntered

    private void jpEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEmpleadosMouseClicked

    }//GEN-LAST:event_jpEmpleadosMouseClicked

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
            limpiarEmpleados();
            cargarTablaEmpleados(jtEmpleados);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            limpiarEmpleados();
            cargarTablaEmpleados(jtEmpleados);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jtEmpleadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtEmpleadosMouseEntered

    }//GEN-LAST:event_jtEmpleadosMouseEntered

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
            limpiarEmpleados();
            cargarTablaEmpleados(jtEmpleados);
        }
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void cmbPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPuestoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPuestoActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void jpUsuariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpUsuariosMouseExited
        Timer tiempo = new Timer();
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                passContraU.setEchoChar('*');
                tiempo.cancel();
            }
        };
        if (result){
            tiempo.schedule(tarea, 5000, 1);
            result = false;
        }

    }//GEN-LAST:event_jpUsuariosMouseExited

    private void cmbIDempleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbIDempleadoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbIDempleadoItemStateChanged

    private void btnEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarUsuarioActionPerformed
        boolean mensaje = true;
        String cadena = cmbIDempleado.getSelectedItem().toString();
        int id = Integer.parseInt(cadena.substring(0, 1));
        us.setIdEmp(new Empleados(id));
        us.setContra(String.valueOf(passContraU.getPassword()));
        if(empCon.findEmpleados(id).getPuesto().equals("Admin")){
            us.setNivel(1);
        }else{
            us.setNivel(2);
        }
        us.setIdUsuario(txtIDusuario.getText());

        try {
            usCon.edit(us);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(AdminOpciones.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = false;
        } catch (Exception ex) {
            Logger.getLogger(AdminOpciones.class.getName()).log(Level.SEVERE, null, ex);
            mensaje = false;
        }
        if(mensaje){
            JOptionPane.showMessageDialog(this, "Usuario editado correctamente");
            cargarTablaUsuarios(jtUsuarios);
        }else{
            JOptionPane.showMessageDialog(this, "Error al editar usuario");
            if(passContraU == null){

            }else{
                jlabelErrorU.setVisible(true);
            }
        }

    }//GEN-LAST:event_btnEditarUsuarioActionPerformed

    private void btnMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarActionPerformed
        new Autenticacion(this, rootPaneCheckingEnabled).setVisible(true);
        if(result){
            passContraU.setEchoChar((char)0);
        }
    }//GEN-LAST:event_btnMostrarActionPerformed

    private void jtUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtUsuariosMouseClicked
        int fila = jtUsuarios.getSelectedRow();
        us = usCon.findUsuarios(jtUsuarios.getValueAt(fila, 2).toString());
        passContraU.setText(us.getContra());
        txtIDusuario.setText(us.getIdUsuario());
        String combo = us.getIdEmp().getId() +" - "+us.getIdEmp().getNombre();
        cmbIDempleado.setSelectedItem(combo);

        btnMostrar.setEnabled(true);
        btnEditarUsuario.setEnabled(true);
        btnEliminarUusario.setEnabled(true);
        passContraU.setEditable(true);

    }//GEN-LAST:event_jtUsuariosMouseClicked

    private void jtVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtVentasMouseClicked
        //        Funciones para tomar la fila seleccionada de la tabla
        int fila = jtVentas.getSelectedRow();
        VentasJpaController ventCon = new VentasJpaController();
        Ventas venta = ventCon.findVentas((int)jtVentas.getValueAt(fila, 0));
        DetallesVentaJpaController nuevo = new DetallesVentaJpaController();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DeportesPU");
        
        EntityManager em = emf.createEntityManager();
        
        Query consulta = em.createNamedQuery("DetallesVenta.findByNoVenta");
        
        consulta.setParameter("noVenta", (int)jtVentas.getValueAt(fila, 0));
        
        List<DetallesVenta> lista = consulta.getResultList();
        
        cargarTablaDetalles(lista);
        
        txtNoVenta.setText(String.valueOf(lista.get(0).getVentas().getNoVenta()));
        txtVendedor.setText(lista.get(0).getVentas().getIdVendedor().getIdEmp().getNombre());
        
    }//GEN-LAST:event_jtVentasMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void jtTablaProvedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaProvedoresMouseClicked
        int fila = jtTablaProvedores.getSelectedRow();
        txtNombreProvedor.setText((String)jtTablaProvedores.getValueAt(fila, 1));
        txtTelefonoProvedor.setText((String)jtTablaProvedores.getValueAt(fila, 2));
        txtCorreo.setText((String)jtTablaProvedores.getValueAt(fila, 3));
        txtNombreContactoProvedor.setText((String)jtTablaProvedores.getValueAt(fila, 4));
    }//GEN-LAST:event_jtTablaProvedoresMouseClicked

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
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEditarInventario;
    private javax.swing.JButton btnEditarUsuario;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarInventario;
    private javax.swing.JButton btnEliminarUusario;
    private javax.swing.JButton btnMostrar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbIDempleado;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JComboBox<String> cmbPuesto;
    private javax.swing.JComboBox<String> cmbSeccion;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jlabelErrorU;
    private javax.swing.JPanel jpEmpleados;
    private javax.swing.JPanel jpUsuarios;
    private javax.swing.JTable jtDetalleVenta;
    private javax.swing.JTable jtEmpleados;
    private javax.swing.JTable jtExistencias;
    private javax.swing.JTable jtTablaProvedores;
    private javax.swing.JTable jtUsuarios;
    private javax.swing.JTable jtVentas;
    private javax.swing.JPasswordField passContraU;
    private javax.swing.JRadioButton radFem;
    private javax.swing.JRadioButton radMas;
    private com.toedter.components.JSpinField spinCantidad;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtIDusuario;
    private javax.swing.JTextField txtIdInventarioEditar;
    private javax.swing.JTextField txtNoVenta;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreContactoProvedor;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtNombreProvedor;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTelefonoProvedor;
    private javax.swing.JTextField txtVendedor;
    private javax.swing.JTextField txtVentasTotales;
    // End of variables declaration//GEN-END:variables
}
