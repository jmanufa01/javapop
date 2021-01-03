package clases;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * Clase Administrador, este tipo de usuario puede manejar toda la informacion de la aplicacion
 * 
 * 
 * @author Manu
 */
public final class Administrador extends Usuario implements Serializable{


    
    public Administrador(String correo, String contraseña){
      
        super(correo,contraseña,true);
   
    } 
    
    
    /**
     * Método relativo a la baja de un usuario, el cual buscara en todos los usuarios y si no es el
     * administrador lo eliminara
     * 
     * @param correo elimina un usuario por su correo
     */
    public void bajaCliente(String correo) throws Exception{
        try{
            Usuario usuario = UtilidadJavaPop.busquedaUsuario(correo);

            //Si es de clase Cliente o ClienteProfesional elimina todos los productos guardados en los productos totales
            if(!usuario.isAdmin()){
                Cliente cliente = (Cliente) usuario;
                for(Producto cadaProducto : cliente.getProductosUsuario()){
                    UtilidadJavaPop.eliminarProducto(cadaProducto);
                }
                
                //Eliminamos el usuario del ArrayList de usuarios totales en la clase Utilidad
                UtilidadJavaPop.eliminarUsuario(usuario);
                
                
                
                //Eliminamos sus archivos
                File archivoProductosComprados = new File("productosComprados"+cliente.getCorreo()+".dat");
                if(archivoProductosComprados.exists()){
                    archivoProductosComprados.delete();
                }
                File archivoProductosVendidos = new File("productosVendidos"+cliente.getCorreo()+".dat");
                if(archivoProductosVendidos.exists()){
                    archivoProductosVendidos.delete();
                }
                File archivoProductosEnVenta = new File("productosVentaCliente"+cliente.getCorreo()+".dat");
                if(archivoProductosEnVenta.exists()){
                    archivoProductosEnVenta.delete();
                }
                
            }
        }catch(Exception e){
            throw e;
        }
    }
    
    
    /**
     * Método relativo a la baja global de cualquier producto si así lo
     * desea
     * 
     * 
     * @param producto
     */
    public void bajaProducto(Producto producto) throws Exception{
        try{
            Cliente cliente = producto.getVendedor();
            if(!cliente.isAdmin()){
                if(cliente.getProductosUsuario().contains(producto)){
                    cliente.eliminarProductoCliente(producto);
                    cliente.guardarProductosEnVenta();
                }
            }
        }catch(Exception e){
            throw e;
        }  
    }
    
    
    /**
     * Metodo relativo a la consulta global de ventas, o consulta de las mismas por la fecha de venta
     * 
     * @param fecha
     */
    //Busca las ventas por fecha en el ArrayList de todas las fechas y si lo encuentra lo añade a un ArrayList externo
    public ArrayList<Venta> consultaVentas(LocalDate fecha){
        ArrayList<Venta> ventasFecha = new ArrayList<>();
              for(Venta cadaVenta : UtilidadJavaPop.getVentas()){
                  if(cadaVenta.getFechaCompra().equals(fecha)){
                      ventasFecha.add(cadaVenta);
                  }
              }
        return ventasFecha;
    }
        
    
    
   
}

      
  
    
    

