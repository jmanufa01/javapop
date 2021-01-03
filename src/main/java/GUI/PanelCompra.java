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
import javax.swing.JPanel;

/**
 *
 * @author Manu
 */
public class PanelCompra extends javax.swing.JPanel {

    
    private VentanaPrincipal ventanaPrincipal;
    private Cliente comprador;
    private Cliente vendedor;
    private Producto productoActual;
    private PanelBusqueda panelBusqueda;
    private ListIterator<Producto> li;
    
    
    public PanelCompra(VentanaPrincipal ventanaPrincipal , PanelBusqueda panelBusqueda) {
        initComponents();
        this.ventanaPrincipal = ventanaPrincipal;
        this.panelBusqueda = panelBusqueda;
        this.comprador = (Cliente) ventanaPrincipal.getUsuarioLoggeado();
        recorrerLista();
        
        Image imagen = new ImageIcon("fondoJavapop.png").getImage();
        ImageIcon imgRedim = new ImageIcon(imagen.getScaledInstance(742, 431, Image.SCALE_SMOOTH));
        jLabel2.setIcon(imgRedim);  
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
    }

    public PanelBusqueda getPanelBusqueda() {
        return panelBusqueda;
    }

    public void setPanelBusqueda(PanelBusqueda panelBusqueda) {
        this.panelBusqueda = panelBusqueda;
    }

    public Producto getProductoActual() {
        return productoActual;
    }

    public void setProductoActual(Producto productoActual) {
        this.productoActual = productoActual;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public VentanaPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }
    
    
    
    /**
     * 
     * Metodo el cual recorre el ArrayList auxiliar de la busqueda realizada
     * 
     * 
     * 
     */
    
    public void recorrerLista(){
        
        //Objetenemos el arraylist de la busqueda anterior
        ArrayList <Producto> busqueda = panelBusqueda.getBusqueda();
        //Creamos el iterador de la lista
        li = busqueda.listIterator();
        siguienteButton.setEnabled(false);
        anteriorButton.setEnabled(false);
        if(busqueda.size()>0){
            comprarButton.setEnabled(true);
            if(li.hasNext()){
                Producto producto = li.next();
                rellenarInfo(producto);
                this.productoActual = producto;
                actualizar();
                anteriorButton.setEnabled(false);
            }
        }
    }
    /**
     * 
     * Metodo el cual rellena los datos del producto en los diferentes TextField
     * 
     * 
     * 
     * @param producto 
     */
    
    public void rellenarInfo(Producto producto){
        vendedorTextField.setText(producto.getVendedor().getNombre());
        estadoTextField.setText(producto.getEstado().toString());
        tituloTextField.setText(producto.getTitulo());
        precioTextField.setText(String.valueOf(producto.getPrecio())+"€");
        descripcionTextArea.setText(producto.getDescripcion());
        ImageIcon imagen =producto.getFotografia();
        ImageIcon imgredim= new ImageIcon(imagen.getImage().getScaledInstance(260,140, Image.SCALE_SMOOTH));
        jLabel1.setIcon(imgredim);
    }
    
    public void actualizar(){
            anteriorButton.setEnabled(false);
            siguienteButton.setEnabled(false);  
            if(li.hasPrevious() && li.hasNext()){
                anteriorButton.setEnabled(true);
                siguienteButton.setEnabled(true);   
            }
            if(li.hasNext() && !li.hasPrevious()){
                siguienteButton.setEnabled(true);
                anteriorButton.setEnabled(false);
            }
            if(li.hasPrevious() && !li.hasNext()){
                anteriorButton.setEnabled(true);
                siguienteButton.setEnabled(false);
            }  
        this.revalidate();
        this.repaint();
        this.updateUI();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        siguienteButton = new javax.swing.JButton();
        comprarButton = new javax.swing.JButton();
        anteriorButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descripcionTextArea = new javax.swing.JTextArea();
        descripcionLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        precioTextField = new javax.swing.JTextField();
        tituloTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        vendedorTextField = new javax.swing.JTextField();
        estadoTextField = new javax.swing.JTextField();
        estadoLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(742, 431));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        siguienteButton.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        siguienteButton.setText("Siguiente");
        siguienteButton.setMaximumSize(new java.awt.Dimension(85, 70));
        siguienteButton.setMinimumSize(new java.awt.Dimension(85, 70));
        siguienteButton.setPreferredSize(new java.awt.Dimension(85, 70));
        siguienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteButtonActionPerformed(evt);
            }
        });
        add(siguienteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, -1, -1));

        comprarButton.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        comprarButton.setText("Comprar");
        comprarButton.setMaximumSize(new java.awt.Dimension(85, 70));
        comprarButton.setMinimumSize(new java.awt.Dimension(85, 70));
        comprarButton.setPreferredSize(new java.awt.Dimension(85, 70));
        comprarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarButtonActionPerformed(evt);
            }
        });
        add(comprarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, -1));

        anteriorButton.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        anteriorButton.setText("Anterior");
        anteriorButton.setMaximumSize(new java.awt.Dimension(85, 70));
        anteriorButton.setMinimumSize(new java.awt.Dimension(85, 70));
        anteriorButton.setPreferredSize(new java.awt.Dimension(85, 70));
        anteriorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anteriorButtonActionPerformed(evt);
            }
        });
        add(anteriorButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, -1, -1));

        descripcionTextArea.setEditable(false);
        descripcionTextArea.setColumns(20);
        descripcionTextArea.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        descripcionTextArea.setLineWrap(true);
        descripcionTextArea.setRows(5);
        descripcionTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(descripcionTextArea);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, 76));

        descripcionLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        descripcionLabel.setForeground(new java.awt.Color(102, 255, 204));
        descripcionLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descripcionLabel.setText("Descripción:");
        add(descripcionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 120, 31));

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Precio:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 120, 31));

        precioTextField.setEditable(false);
        precioTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        add(precioTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, 70, 31));

        tituloTextField.setEditable(false);
        tituloTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        add(tituloTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 166, 31));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 255, 204));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Título:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 120, 31));

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 255, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Vendedor:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 120, 31));

        vendedorTextField.setEditable(false);
        vendedorTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        add(vendedorTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 166, 31));

        estadoTextField.setEditable(false);
        estadoTextField.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        add(estadoTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 166, 31));

        estadoLabel.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        estadoLabel.setForeground(new java.awt.Color(102, 255, 204));
        estadoLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        estadoLabel.setText("Estado:");
        add(estadoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 120, 31));

        jLabel1.setText("FOTOGRAFIA");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 260, 140));

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 204));
        jLabel4.setText("COMPRA DE PRODUCTOS");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 230, 40));

        jLabel2.setText("AÑADIR FONDO");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 430));
    }// </editor-fold>//GEN-END:initComponents

    private void siguienteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteButtonActionPerformed

        
        if(li.hasNext()){
            Producto producto = li.next();
            rellenarInfo(producto);
            actualizar();
            this.productoActual = producto;
        }else{
            siguienteButton.setEnabled(false);
            this.revalidate();
            this.repaint();
            this.updateUI();
        }
    }//GEN-LAST:event_siguienteButtonActionPerformed

    private void anteriorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anteriorButtonActionPerformed

        if(li.hasPrevious()){
            Producto producto = li.previous();
            rellenarInfo(producto);
            actualizar();
            this.productoActual = producto;
        }else{
            anteriorButton.setEnabled(false);
            this.revalidate();
            this.repaint();
            this.updateUI();
        }
    }//GEN-LAST:event_anteriorButtonActionPerformed

    private void comprarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarButtonActionPerformed
        try{
            if(productoActual!=null){
                this.vendedor = productoActual.getVendedor();
                String botones[]={"Sí","No"};
                int eleccion = JOptionPane.showOptionDialog(this, "¿Desea vender su"
                        + "producto " + productoActual.getTitulo()+ " a "
                        +comprador.getNombre()+" por una cantidad de"+
                        productoActual.getPrecio().toString()+"€", "Venta", 0,0,null,botones,null);         
                if(eleccion == JOptionPane.YES_OPTION){
                    comprador.comprarProducto(productoActual);
                    UtilidadJavaPop.guardarProductos();
                    UtilidadJavaPop.guardarVentas();
                    comprador.guardarProductosComprados();
                    vendedor.guardarProductosEnVenta();
                    vendedor.guardarProductosVendidos();
                    ventanaPrincipal.getPanelPrincipal().remove(this);
                    ventanaPrincipal.getPanelPrincipal().add(new PanelInicial(ventanaPrincipal));
                    ventanaPrincipal.getPanelPrincipal().revalidate();
                    ventanaPrincipal.getPanelPrincipal().updateUI();
                    JOptionPane.showMessageDialog(null, "Ha comprado "+ productoActual.getTitulo()+
                        "por un precio de , "+String.valueOf(productoActual.getPrecio())+"€"
                        ,"Enhorabuena!", JOptionPane.INFORMATION_MESSAGE);    
                }
            }else{
                JOptionPane.showMessageDialog(null, "No hay productos", "Error!", JOptionPane.ERROR_MESSAGE);
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
            
        }
        
        
    }//GEN-LAST:event_comprarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anteriorButton;
    private javax.swing.JButton comprarButton;
    private javax.swing.JLabel descripcionLabel;
    private javax.swing.JTextArea descripcionTextArea;
    private javax.swing.JLabel estadoLabel;
    private javax.swing.JTextField estadoTextField;
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
    private javax.swing.JTextField vendedorTextField;
    // End of variables declaration//GEN-END:variables
}
