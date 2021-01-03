
package clases;

import java.io.Serializable;

public class Ubicacion implements Serializable{
    private String codigoPostal;
    private String ciudad;
    
    public Ubicacion(String codigoPostal,String ciudad) throws Exception{
          
        try{
            int codigopostal = Integer.parseInt(codigoPostal);
            if(codigoPostal.length()!=5){
               throw new codigoPostalIncorrecto();
            }
            this.codigoPostal=codigoPostal;
            this.ciudad=ciudad;
        }catch(Exception e){
           throw new codigoPostalIncorrecto();
        }

    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    
    class codigoPostalIncorrecto extends Exception{
        public codigoPostalIncorrecto(){
            super("ERROR: Codigo Postal introducido Incorrecto");
        }
    }
    
    
    
    @Override
    public String toString(){
        
        return "Ciudad: "+this.ciudad+", Código Postal: "+this.codigoPostal;
        
    }
    
    
    
}
