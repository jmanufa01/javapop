/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import clases.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Manu
 */
public class PanelBusqueda extends javax.swing.JPanel {

    private VentanaPrincipal ventanaPrincipal;
    private ArrayList <Producto> busqueda = new ArrayList<>();
    
    
    /**
     * Creates new form PanelBusqueda
     * @param ventanaPrincipal
     */
    public PanelBusqueda(VentanaPrincipal ventanaPrincipal) {
        initComponents();
        this.ventanaPrincipal = ventanaPrincipal;
        
        Image fondo = new ImageIcon("fondoJavapop.png").getImage();
        ImageIcon imgRedim = new ImageIcon(fondo.getScaledInstance(742, 431, Image.SCALE_SMOOTH));
        jLabel2.setIcon(imgRedim);
        this.repaint();
        this.revalidate();
        this.updateUI();
        ImageIcon imagenBoton = new ImageIcon("lupa.png");
        ImageIcon imgRedimBoton = new ImageIcon(imagenBoton.getImage().getScaledInstance(80
                ,40, Image.SCALE_SMOOTH));
        
        buscarButton.setIcon(imgRedimBoton);
       
    }

    public VentanaPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
        this.ventanaPrincipal = ventanaPrincipal;
    }

    public ArrayList<Producto> getBusqueda() {
        return busqueda;
    }

    public void setBusqueda(ArrayList<Producto> busqueda) {
        this.busqueda = busqueda;
    }
    
    
    
    
    
    
    
    public Producto.Categoria getCategoria(int posicion){
        switch(posicion){
            case 0:return Producto.Categoria.Moda_y_accesorios;
            case 1:return Producto.Categoria.Tv_audio_y_foto;
            case 2:return Producto.Categoria.Moviles_y_telefonia;
            case 3:return Producto.Categoria.Informatica_y_electronica;
            case 4:return Producto.Categoria.Consolas_y_videojuegos;
            case 5:return Producto.Categoria.Deporte_y_ocio;
    
        }

        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        busquedaTextField = new javax.swing.JTextField();
        categoriaToolBox = new javax.swing.JComboBox<>();
        buscarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(742, 431));
        setPreferredSize(new java.awt.Dimension(742, 431));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        busquedaTextField.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        add(busquedaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 197, 39));

        categoriaToolBox.setFont(new java.awt.Font("Comic Sans MS", 0, 11)); // NOI18N
        categoriaToolBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Moda y Accesorios", "TV Audio y foto", "Moviles y telefonía", "Informática y Electrónica", "Consolas y Videojuegos", "Deporte y Ocio" }));
        categoriaToolBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaToolBoxActionPerformed(evt);
            }
        });
        add(categoriaToolBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 131, 40));

        buscarButton.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        buscarButton.setText("Buscar");
        buscarButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });
        add(buscarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 80, 40));

        jLabel1.setText("jLabel1");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 430, 110));

        jLabel2.setText("jLabel2");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 742, 431));
    }// </editor-fold>//GEN-END:initComponents

    private void categoriaToolBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoriaToolBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_categoriaToolBoxActionPerformed

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarButtonActionPerformed
        Cliente cliente = (Cliente) ventanaPrincipal.getUsuarioLoggeado();
        cliente.cargarProductosEnVenta();
        if(busquedaTextField.getText().trim().equals("")){
            ArrayList <Producto> busquedaExt = cliente.busquedaProductos(getCategoria(categoriaToolBox.getSelectedIndex()));
            if(busquedaExt.size()>0){
                setBusqueda(busquedaExt);
                ventanaPrincipal.getPanelPrincipal().removeAll();
                ventanaPrincipal.getPanelPrincipal().add(new PanelCompra(ventanaPrincipal, this));
                ventanaPrincipal.getPanelPrincipal().revalidate();
                ventanaPrincipal.getPanelPrincipal().repaint();
                ventanaPrincipal.getPanelPrincipal().updateUI(); 
            }else{
                JOptionPane.showMessageDialog(ventanaPrincipal,"No se ha encontrado ningún resultado", "Info", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            ArrayList <Producto> busquedaExt = cliente.busquedaProductos(getCategoria(categoriaToolBox.getSelectedIndex())
                    ,busquedaTextField.getText());
            if(busquedaExt.size()>0){
            setBusqueda(busquedaExt);
                ventanaPrincipal.getPanelPrincipal().removeAll();
                ventanaPrincipal.getPanelPrincipal().add(new PanelCompra(ventanaPrincipal, this));
                ventanaPrincipal.getPanelPrincipal().revalidate();
                ventanaPrincipal.getPanelPrincipal().repaint();
                ventanaPrincipal.getPanelPrincipal().updateUI(); 
            }else{
                JOptionPane.showMessageDialog(ventanaPrincipal,"No se ha encontrado ningún resultado", "Info", 
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_buscarButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarButton;
    private javax.swing.JTextField busquedaTextField;
    private javax.swing.JComboBox<String> categoriaToolBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
