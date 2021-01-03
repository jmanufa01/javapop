/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import clases.Producto;
import clases.UtilidadJavaPop;
import clases.Venta;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Manu
 */
public class VentanaInfoProducto extends javax.swing.JFrame {

    /**
     * Creates new form VentanaInfoProducto
     */
    
    private PanelVentas panelVentas;
    
    
    public VentanaInfoProducto(PanelVentas panelVentas) {
        initComponents();
        this.panelVentas = panelVentas;
        Venta venta = UtilidadJavaPop.getVentas().get(panelVentas.getVentasList().getSelectedIndex());
        Image imagen = new ImageIcon("fondoJavapop.png").getImage();
        ImageIcon imgRedim = new ImageIcon(imagen.getScaledInstance(jLabel1.getWidth(),jLabel1.getHeight(), Image.SCALE_SMOOTH));
        jLabel1.setIcon(imgRedim);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
        rellenarInfo(venta.getProducto());
        this.revalidate();
        this.repaint();
    }

    public PanelVentas getPanelVentas() {
        return panelVentas;
    }

    public void setPanelVentas(PanelVentas panelVentas) {
        this.panelVentas = panelVentas;
    }
    
    
    
    
    
    
    public void rellenarInfo(Producto producto){
        tituloTextField1.setText(producto.getTitulo());
        precioTextField1.setText(String.valueOf(producto.getPrecio()));
        descripcionTextArea.setText(producto.getDescripcion());
        estadoTextField.setText(producto.getEstado().toString());
        categoriaTextField.setText(producto.toStringCategoria());
        ImageIcon imagen = producto.getFotografia();
        ImageIcon imagenRedim = new ImageIcon(imagen.getImage().getScaledInstance(jLabel10.getWidth(), jLabel10.getHeight(),
                Image.SCALE_SMOOTH));
        jLabel10.setIcon(imagenRedim);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        categoriaTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        estadoTextField = new javax.swing.JTextField();
        precioTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tituloTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descripcionTextArea = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("JavaPop");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        categoriaTextField.setEditable(false);
        categoriaTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        categoriaTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(categoriaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 140, 30));

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 255, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Categoría:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 120, 30));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 255, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Estado:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, 30));

        estadoTextField.setEditable(false);
        estadoTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        estadoTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        estadoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(estadoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 140, 30));

        precioTextField1.setEditable(false);
        precioTextField1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        precioTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(precioTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 60, 30));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 255, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Precio:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, 30));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Título:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 120, 20));

        tituloTextField1.setEditable(false);
        tituloTextField1.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        tituloTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        getContentPane().add(tituloTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 140, 30));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Información del producto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 180, 20));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descripción:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 60, 120, 30));

        descripcionTextArea.setEditable(false);
        descripcionTextArea.setColumns(20);
        descripcionTextArea.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        descripcionTextArea.setLineWrap(true);
        descripcionTextArea.setRows(5);
        descripcionTextArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(descripcionTextArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 170, 80));

        jLabel10.setText("jLabel10");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 200, 130));

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 255, 204));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Imagen del Producto");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, 200, 20));

        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 410));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void estadoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoTextFieldActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField categoriaTextField;
    private javax.swing.JTextArea descripcionTextArea;
    private javax.swing.JTextField estadoTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField precioTextField1;
    private javax.swing.JTextField tituloTextField1;
    // End of variables declaration//GEN-END:variables
}