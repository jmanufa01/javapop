
package clases;
import java.time.*;


/**
 * 
 * 
 * @author Manu
 */
public class ClienteProfesional extends Cliente {
    

        private String descripion;
        private String horario;
        private int telefono;
        private String web;



    public ClienteProfesional(String correo, String contraseña, String dni, String nombre, 
            String codigopostal, String ciudad, String tarjetacredito, String descripcion, 
            int telefono,String horario ,String web) throws Exception {
        super(correo, contraseña, dni, nombre, codigopostal, ciudad, tarjetacredito);
        
        
            this.descripion=descripcion;
            this.horario=horario;
            this.telefono=telefono;
            this.web=web;
            

       }
    
  
       public String getDescripion() {
           return descripion;
       }

       public void setDescripion(String descripion) {
           this.descripion = descripion;
       }

       public String getHorario() {
           return horario;
       }

       public void setHorario(String horario) {
           this.horario = horario;
       }

       public int getTelefono() {
           return telefono;
       }

       public void setTelefono(int telefono) {
           this.telefono = telefono;
          
       }

       public String getWeb() {
           return web;
       }

       public void setWeb(String web) {
           this.web = web;
       }
       
       
       @Override
       public String toString(){
           return "\n"+super.toString()+","+"Telefono: "+this.telefono+", "+"Horario: "+this.horario+", "+"Web: "+this.web;
     
       }
       
 

       
       
 

}

  