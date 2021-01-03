/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import clases.*;
import java.awt.Image;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Manu
 */
public class PanelHistorialProductos extends javax.swing.JPanel {

    /**
     * Creates new form HistorialBusquedaProductos
     */
    
    
    private VentanaPrincipal ventanaPrincipal;
    ArrayList <Producto> productosComprados;
    ArrayList <Producto> productosVendidos;
    ListIterator <Producto> liComprados;
    ListIterator <Producto> liVendidos;
   
    
    
         
    public PanelHistorialProductos(VentanaPrincipal ventanaPrincipal) {
        initComponents();
        this.ventanaPrincipal = ventanaPrincipal;
        siguienteButton.setEnabled(false);
        anteriorButton.setEnabled(false); 
        compradorLabel.setVisible(false);
        compradorTextField.setVisible(false);
        Image imagen = new ImageIcon("fondoJavapop.png").getImage();
        ImageIcon imgRedim = new ImageIcon(imagen.getScaledInstance(742,431, Image.SCALE_SMOOTH));
        jLabel5.setIcon(imgRedim);
        Image imagenSiguiente = new ImageIcon("siguiente.png").getImage();
        ImageIcon imgRedimSiguiente = new ImageIcon(imagenSiguiente.getScaledInstance(85,70
                , Image.SCALE_SMOOTH));
        siguienteButton.setText("");
        siguienteButton.setIcon(imgRedimSiguiente);
        Image imagenAnterior = new ImageIcon("anterior.png").getImage();
        ImageIcon imgRedimAnterior = new ImageIcon(imagenAnterior.getScaledInstance(85,70
                , Image.SCALE_SMOOTH));
        anteriorButton.setText("");
        anteriorButton.setIcon(imgRedimAnterior);
        this.revalidate();
        this.repaint();
        this.updateUI();
        
    }

    public VentanaPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public void recorrerListaComprados(){
        Cliente cliente = (Cliente) ventanaPrincipal.getUsuarioLoggeado();
        //Objetenemos el arraylist de la busqueda anterior
        ArrayList <Producto> productosCompra = cliente.getProductosComprados();
        
        //Creamos el iterador de la lista
        
        if(productosCompra.size()>0){
            liComprados = productosCompra.listIterator();
        }else{
            JOptionPane.showMessageDialog(null,"No ha comprado productos", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    
    
    public void vaciar(){
        compradorTextField.setText("");
        vendedorTextField.setText("");
        estadoTextField.setText("");
        tituloTextField.setText("");
        precioTextField.setText("");
        descripcionTextArea.setText("");
        jLabel2.setIcon(null);
    }
    



        
    public void recorrerListaVendidos(){
        Cliente cliente = (Cliente) ventanaPrincipal.getUsuarioLoggeado();
        //Objetenemos el arraylist de la busqueda anterior
        ArrayList <Producto> productosVenta = cliente.getProductosVendidos();;
        //Creamos el iterador de la lista
        
        if(productosVenta.size()>0){
            liVendidos = productosVenta.listIterator();
        }else{
            JOptionPane.showMessageDialog(null,"No ha vendido productos", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        
    }
        
    
    public void setImagen(Producto producto){
        
        ImageIcon imagen =producto.getFotografia();
        ImageIcon imgredim= new ImageIcon(imagen.getImage().getScaledInstance(jLabel2.getWidth(),jLabel2.getHeight()
                , Image.SCALE_SMOOTH));
        jLabel2.setIcon(imgredim);
        
        
    }
        
    /**
     * 
     * Metodo el cual rellena la informacion del producto comprado en los distintos TextField
     * 
     * 
     * @param producto 
     */   
        
    public void rellenarInfoComprados(Producto producto){
        vendedorTextField.setText(producto.getVendedor().getNombre());
        estadoTextField.setText(producto.getEstado().toString());
        tituloTextField.setText(producto.getTitulo());
        precioTextField.setText(String.valueOf(producto.getPrecio()));
        descripcionTextArea.setText(producto.getDescripcion());
        setImagen(producto);
    }
    
    /**
     * 
     * Metodo el cual rellena la informacion del producto vendido en los distintos TextField
     * 
     * 
     * @param producto 
     */
    
    public void rellenarInfoVendidos(Producto producto){
        compradorTextField.setText(producto.getComprador().getNombre());
        estadoTextField.setText(producto.getEstado().toString());
        tituloTextField.setText(producto.getTitulo());
        precioTextField.setText(String.valueOf(producto.getPrecio())+"€");
        descripcionTextArea.setText(producto.getDescripcion());
        setImagen(producto);
    }
    
    
    /**
     * 
     * 
     * Metodo el cual actualiza la situacion de los botones cuando nos encontramos en los
     * productos vendidos
     */
    public void actualizarVendidos(){
            anteriorButton.setEnabled(false);
            siguienteButton.setEnabled(false);  
            if(liVendidos.hasPrevious() && liVendidos.hasNext()){
                anteriorButton.setEnabled(true);
                siguienteButton.setEnabled(true);   
            }
            if(liVendidos.hasNext() && !liVendidos.hasPrevious()){
                siguienteButton.setEnabled(true);
                anteriorButton.setEnabled(false);
            }
            if(liVendidos.hasPrevious() && !liVendidos.hasNext()){
                anteriorButton.setEnabled(true);
                siguienteButton.setEnabled(false);
            }
            
        siguienteButton.revalidate();
        siguienteButton.repaint();
        siguienteButton.updateUI(); 
        anteriorButton.revalidate();
        anteriorButton.repaint();
        anteriorButton.updateUI();
    }
    /**
     * 
     * Metodo el cual actualiza la situacion de los botones cuando nos encontramos en los
     * productos comprados
     * 
     * 
     */
    public void actualizarComprados(){
            anteriorButton.setEnabled(false);
            siguienteButton.setEnabled(false);  
            if(liComprados.hasPrevious() && liComprados.hasNext()){
                anteriorButton.setEnabled(true);
                siguienteButton.setEnabled(true);   
            }
            if(liComprados.hasNext() && !liComprados.hasPrevious()){
                siguienteButton.setEnabled(true);
                anteriorButton.setEnabled(false);
            }
            if(liComprados.hasPrevious() && !liComprados.hasNext()){
                anteriorButton.setEnabled(true);
                siguienteButton.setEnabled(false);
            }
            
        siguienteButton.revalidate();
        siguienteButton.repaint();
        siguienteButton.updateUI(); 
        anteriorButton.revalidate();
        anteriorButton.repaint();
        anteriorButton.updateUI();
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estadoTextField = new javax.swing.JTextField();
        vendedorTextField = new javax.swing.JTextField();
        vendedorLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tituloTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        precioTextField = new javax.swing.JTextField();
        descripcionLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionTextArea = new javax.swing.JTextArea();
        estadoLabel = new javax.swing.JLabel();
        historialComboBox = new javax.swing.JComboBox<>();
        anteriorButton = new javax.swing.JButton();
        siguienteButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        compradorLabel = new javax.swing.JLabel();
        compradorTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(742, 431));
        setPreferredSize(new java.awt.Dimension(742, 431));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        estadoTextField.setEditable(false);
        estadoTextField.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        add(estadoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 170, 31));

        vendedorTextField.setEditable(false);
        vendedorTextField.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        add(vendedorTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 170, 31));

        vendedorLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        vendedorLabel.setForeground(new java.awt.Color(51, 255, 204));
        vendedorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vendedorLabel.setText("Vendedor:");
        add(vendedorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 100, 31));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 255, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Título:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 100, 31));

        tituloTextField.setEditable(false);
        tituloTextField.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        add(tituloTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 166, 31));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Precio:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 100, 31));

        precioTextField.setEditable(false);
        precioTextField.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        add(precioTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 70, 31));

        descripcionLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        descripcionLabel.setForeground(new java.awt.Color(51, 255, 204));
        descripcionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descripcionLabel.setText("Descripción:");
        add(descripcionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 120, 31));

        descripcionTextArea.setEditable(false);
        descripcionTextArea.setColumns(20);
        descripcionTextArea.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        descripcionTextArea.setLineWrap(true);
        descripcionTextArea.setRows(5);
        descripcionTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(descripcionTextArea);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, 76));

        estadoLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        estadoLabel.setForeground(new java.awt.Color(51, 255, 204));
        estadoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        estadoLabel.setText("Estado:");
        add(estadoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 100, 31));

        historialComboBox.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        historialComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productos Vendidos", "Productos Comprados" }));
        historialComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historialComboBoxActionPerformed(evt);
            }
        });
        add(historialComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 170, -1));

        anteriorButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        anteriorButton.setText("Anterior");
        anteriorButton.setMaximumSize(new java.awt.Dimension(85, 70));
        anteriorButton.setMinimumSize(new java.awt.Dimension(85, 70));
        anteriorButton.setPreferredSize(new java.awt.Dimension(85, 70));
        anteriorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorButtonActionPerformed(evt);
            }
        });
        add(anteriorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 347, -1, -1));

        siguienteButton.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        siguienteButton.setText("Siguiente");
        siguienteButton.setMaximumSize(new java.awt.Dimension(85, 70));
        siguienteButton.setMinimumSize(new java.awt.Dimension(85, 70));
        siguienteButton.setPreferredSize(new java.awt.Dimension(85, 70));
        siguienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteButtonActionPerformed(evt);
            }
        });
        add(siguienteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 347, -1, -1));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HISTORIAL");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 180, 30));

        jLabel2.setText("jLabel2");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.setMaximumSize(new java.awt.Dimension(470, 260));
        jLabel2.setMinimumSize(new java.awt.Dimension(470, 260));
        jLabel2.setPreferredSize(new java.awt.Dimension(470, 260));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, 170, 110));
        jLabel2.getAccessibleContext().setAccessibleDescription("");

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Foto Producto");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 170, -1));

        compradorLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        compradorLabel.setForeground(new java.awt.Color(51, 255, 204));
        compradorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        compradorLabel.setText("Comprador:");
        add(compradorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 100, 31));

        compradorTextField.setEditable(false);
        compradorTextField.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        add(compradorTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 170, 31));

        jLabel5.setText("jLabel5");
        jLabel5.setMaximumSize(new java.awt.Dimension(742, 431));
        jLabel5.setMinimumSize(new java.awt.Dimension(742, 431));
        jLabel5.setPreferredSize(new java.awt.Dimension(742, 431));
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 742, 431));
    }// </editor-fold>//GEN-END:initComponents

    private void historialComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historialComboBoxActionPerformed
        
        
        siguienteButton.setEnabled(false);
        anteriorButton.setEnabled(false);
        compradorLabel.setVisible(false);
        compradorTextField.setVisible(false);
        vendedorTextField.setVisible(false);
        vendedorLabel.setVisible(false);
        if(historialComboBox.getSelectedIndex() == 0){
            recorrerListaVendidos();
            vaciar();
            compradorLabel.setVisible(true);
            compradorTextField.setVisible(true);
            if(liVendidos.hasNext()){
                Producto producto = liVendidos.next();
                rellenarInfoVendidos(producto);
                siguienteButton.setEnabled(true);
                actualizarVendidos();
            } 
        }
        if(historialComboBox.getSelectedIndex() == 1){
            recorrerListaComprados();
            vaciar();
            vendedorLabel.setVisible(true);
            vendedorTextField.setVisible(true);
            if(liComprados.hasNext()){
                Producto producto = liComprados.next();
                rellenarInfoComprados(producto);
                siguienteButton.setEnabled(true);
                actualizarComprados();
            }
        }
    }//GEN-LAST:event_historialComboBoxActionPerformed

    private void siguienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteButtonActionPerformed
        if(historialComboBox.getSelectedIndex() == 0){
            if(liVendidos.hasNext()){
                Producto producto = liVendidos.next();
                rellenarInfoVendidos(producto);
                actualizarVendidos();
            }else{
                siguienteButton.setEnabled(false);
                this.revalidate();
                this.repaint();
                this.updateUI();
            }
        }
        if(historialComboBox.getSelectedIndex() == 1){
            if(liComprados.hasNext()){
                Producto producto = liComprados.next();
                rellenarInfoComprados(producto);
                actualizarComprados();
            }else{
                siguienteButton.setEnabled(false);
                this.revalidate();
                this.repaint();
                this.updateUI();
            } 
            
        }
    }//GEN-LAST:event_siguienteButtonActionPerformed

    private void anteriorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorButtonActionPerformed

        if(historialComboBox.getSelectedIndex() == 0){
            if(liVendidos.hasPrevious()){
                Producto producto = liVendidos.previous();
                rellenarInfoVendidos(producto);
                actualizarVendidos();
            }else{
                anteriorButton.setEnabled(false);
                this.revalidate();
                this.repaint();
                this.updateUI();
            }
        }
        if(historialComboBox.getSelectedIndex() == 1){
            if(liComprados.hasPrevious()){
                Producto producto = liComprados.previous();
                rellenarInfoComprados(producto);
                actualizarComprados();
            }else{
                anteriorButton.setEnabled(false);
                this.revalidate();
                this.repaint();
                this.updateUI();
            } 
            
        }
    }//GEN-LAST:event_anteriorButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anteriorButton;
    private javax.swing.JLabel compradorLabel;
    private javax.swing.JTextField compradorTextField;
    private javax.swing.JLabel descripcionLabel;
    private javax.swing.JTextArea descripcionTextArea;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JTextField estadoTextField;
    private javax.swing.JComboBox<String> historialComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField precioTextField;
    private javax.swing.JButton siguienteButton;
    private javax.swing.JTextField tituloTextField;
    private javax.swing.JLabel vendedorLabel;
    private javax.swing.JTextField vendedorTextField;
    // End of variables declaration//GEN-END:variables
}
