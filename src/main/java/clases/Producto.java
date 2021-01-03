
package clases;

import java.io.Serializable;
import javax.swing.ImageIcon;

public class Producto implements Serializable{
    
    private Cliente vendedor;
    private Cliente comprador;
    private String titulo;
    private String descripcion;
    private Estado estado;
    private Categoria categoria;
    private Double precio;
    private ImageIcon fotografia; //Hay que poner la imagen, con formato imagen y no como  String----Acabar
    private Ubicacion ubicacionCliente;
    private boolean urgente;
    
   public Producto(String titulo, String descripcion ,
       Estado estado,Categoria categoria, Double precio){
       this.titulo=titulo;
       this.descripcion=descripcion;
       this.estado=estado;
       this.categoria=categoria;
       this.precio=precio;
   }
   
   
        public static enum Estado{
            Nuevo,
            ComoNuevo,
            Bueno,
            Aceptable,
            Regular;
        }
        public static enum Categoria{
            Moda_y_accesorios,
            Tv_audio_y_foto,
            Moviles_y_telefonia,
            Informatica_y_electronica,
            Consolas_y_videojuegos,
            Deporte_y_ocio;
        }
       
    
   
        
        
        //Getters y Setters
        public String getDescripcion() {
           
            return this.descripcion;
        }

        public void setDescripcion(String Descripcion) {
            this.descripcion = Descripcion;
        }


        public void setCategoria(Categoria categoria) {
            
            this.categoria=categoria;
                  
                  
        }

        public Cliente getVendedor() {
            return vendedor;
        }

        public void setVendedor(Cliente vendedor) {
            this.vendedor = vendedor;
        }

        public Cliente getComprador() {
            return comprador;
        }

        public void setComprador(Cliente comprador) {
            this.comprador = comprador;
        }

        


        public Categoria getCategoria() {
            return categoria;
        }

        public Estado getEstado() {
            return estado;
        }

        public void setEstado(Estado estado) {
            this.estado = estado;
        }
        public Estado getEstadoProducto() {
            return estado;
        }

        public void setEstadoProducto(Estado estado) {
            this.estado = estado;
        }

        public Double getPrecio() {
            return precio;
        }

        public void setPrecio(Double precio) {
            this.precio = precio;
        }

        public ImageIcon getFotografia() {
            return fotografia;
        }

        public void setFotografia(ImageIcon fotografia) {
            this.fotografia = fotografia;
        }

        public boolean getUrgente() {
            return urgente;
        }

        public void setUrgente(boolean urgente) {
            this.urgente = urgente;
        }


        public Ubicacion getUbicacionCliente() {
            return ubicacionCliente;
        }

        public void setUbicacionCliente(Ubicacion ubicacionCliente) {
            this.ubicacionCliente = ubicacionCliente;
        }


        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }
        
        //Metodo toString de la categoria
        public String toStringCategoria() {
          
            switch(this.categoria){
               case Consolas_y_videojuegos: return "Consolas y videojuegos";
               case Informatica_y_electronica: return "Informatica y Electronica";
               case Deporte_y_ocio: return "Deporte y ocio";
               case Moda_y_accesorios: return "Moda y Accesorios";
               case Moviles_y_telefonia: return "Moviles y telefonía";
               case Tv_audio_y_foto: return "Tv, audio y foto";
                       
           }
        return null;      
        }
        //Metodo toString para mostrar las propiedades del objeto
        @Override
        public String toString(){
            
            return "\n"+"Título: "+this.titulo+", "+"Descripción: "+this.descripcion+", "+"Categoria: "+toStringCategoria()+", "+                    
               "Estado: "+this.estado+", "+"Precio: "+this.precio+"€"+", "+"Ubicacion del cliente: "+this.ubicacionCliente;
            
            
            
        }

        
}
