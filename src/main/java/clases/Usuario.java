package clases;

import java.io.Serializable;



/**
 * Clase referente a la creacion del usuario global, con su correo y contraseña
 * 
 * @author Manu
 */
public class Usuario implements Serializable {
    
    private String correo;
    private String contraseña;
    private boolean admin;
    
    public Usuario(String correo,String contraseña,boolean admin){     
        
        
        this.correo=correo;
        this.contraseña=contraseña;  
        this.admin=admin;
        }

        public boolean isAdmin() {
            return admin;
        }

        public void setAdmin(boolean admin) {
            this.admin = admin;
        }

        public String getContraseña() {

            return contraseña;
        }

        public void setContraseña(String contraseña) {



            this.contraseña=contraseña;    


        }
        public String getCorreo() {
            return correo;
        }

        public void setCorreo(String correo) {

            this.correo = correo;

        }


        //Metodo toString para mostrar las propiedades del objeto
        @Override
        public String toString(){
            return "Correo: "+this.correo+", "+"Contraseña: "+this.contraseña;
        }

    }
