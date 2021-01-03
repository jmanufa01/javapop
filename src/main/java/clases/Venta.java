
package clases;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Venta implements Serializable{
    private Producto producto;
    private Cliente comprador;
    private Cliente vendedor;
    private LocalDate fechaCompra;
    //private usaurio vendedor y comprador
    
    
        public Venta(Producto producto,Cliente comprador,Cliente vendedor){
            this.fechaCompra=fechaCompra.now();
            this.comprador=comprador;
            this.vendedor=vendedor;
            this.producto=producto;
            
        }

        public Producto getProducto() {
            return producto;
        }

        public void setProducto(Producto producto) {
            this.producto = producto;
        }

        public Cliente getComprador() {
            return comprador;
        }

        public void setComprador(Cliente comprador) {
            this.comprador = comprador;
        }

        public Cliente getVendedor() {
            return vendedor;
        }

        public void setVendedor(Cliente vendedor) {
            this.vendedor = vendedor;
        }

        public LocalDate getFechaCompra() {
            return fechaCompra;
        }

        public void setFechaCompra(LocalDate fechaCompra) {
            this.fechaCompra = fechaCompra;
        }

        

        @Override
        public String toString(){
            
            return "Venta{ "+"Producto: "+this.producto+", DNI Comprador: "+this.comprador.getDni()+", DNI Vendedor: "+this.vendedor.getDni()+
                    ", Nombre del Vendedor: "+this.vendedor.getNombre()+", Nombre del Comprador: "+this.comprador.getNombre()+", Fecha de la Venta: "
                    +this.fechaCompra+" }";
            
        }



    
    
    
    
}
