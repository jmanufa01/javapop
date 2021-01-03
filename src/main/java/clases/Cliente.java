package clases;
import java.io.*;
import java.util.*;




/**
 * Clase referente al Cliente, quien tendra la capacidad de comprar y vender productos
 * 
 * @author Manu
 */
public class Cliente extends Usuario implements Serializable {
    
        //Propiedades del cliente
        private ArrayList <Producto> productosEnVenta;
        private ArrayList <Producto> productosVendidos;
        private ArrayList <Producto> productosComprados;
        private String dni;
        private String Nombre;
        private Ubicacion ubicacion;
        private String tarjetaCredito;
        
        
        
        //creamos el constructor
        
        
        /**
         * Constructor el cual recibe los siguientes parametros
         * 
         * 
         * 
         * @param correo del usuario
         * @param contraseña del usuario
         * @param dni del cliente
         * @param nombre del cliente
         * @param codigopostal del cliente, deberá tener 5 digitos
         * @param ciudad del cliente
         * @param tarjetaCredito con la que realizara las compras, debera tener 16 digitos
         */
        public Cliente(String correo, String contraseña, String dni,String nombre,
            String codigopostal,String ciudad,String tarjetaCredito) throws Exception {
            
            super(correo, contraseña,false);
            try{
                
                if(correo.trim().equals("") || contraseña.trim().equals("") || dni.trim().equals("") || nombre.trim().equals("") ||
                        codigopostal.trim().equals("") || ciudad.trim().equals("")){

                    throw new campoVacio();
                }    

                if(tarjetaCredito.length()!=16){
                    throw new tarjetaInvalida();
                }
                long tarjeta = Long.parseLong(tarjetaCredito);
                
                
                this.productosEnVenta = new ArrayList<>();
                this.productosVendidos=new ArrayList<>();
                this.productosComprados=new ArrayList<>();
                this.dni=dni;
                this.Nombre=nombre;
                this.tarjetaCredito=tarjetaCredito;
                this.ubicacion=new Ubicacion(codigopostal, ciudad);
            }catch(campoVacio cV){
                throw cV;
                
            }
            catch(tarjetaInvalida tI){
                throw tI;
            }catch(NumberFormatException nbe){
                throw nbe;
            }catch(Exception e ){
                throw e;
            }
        }
     
    
        //Metodos relacionados al arraylist de productos
        
        /**
         * Metodo el cual permite al cliente añadir un producto al ArrayList de todos los productos para su posterior
         * venta, también se podrá seleccionar si quiere ser o no urgente
         *
         * @param producto para su venta
         * 
         */
        public void añadirProductoCliente(Producto producto) throws Exception{
         try{  
            if(this.productosEnVenta.contains(producto) || 
               UtilidadJavaPop.getProductosTotales().contains(producto)){
                throw new productoYaAñadido();
            }
            if(!UtilidadJavaPop.getUsuarios().contains(this)){
                throw new UtilidadJavaPop.usuarioNoRegistrado();
            }
            
            
            //Le introducimos al producto el codigoPostal para poder asociarlo al cliente
            producto.setVendedor(this);
            producto.setUbicacionCliente(this.getUbicacion());
            this.productosEnVenta.add(producto);
            UtilidadJavaPop.añadirProducto(producto);

         }catch(UtilidadJavaPop.usuarioNoRegistrado uNR){
             throw uNR;
         }catch(productoYaAñadido pYA){
             throw pYA;
         }catch(Exception e){
             throw e;
         }  
        }
       

        
        
        /**
         * Metodo relativo a la baja de un producto, el cual lo eliminara de los productos en venta del cliente
         * y de los productos totales
         * 
         * @param producto 
     * @throws java.lang.Exception 
         */
        public void eliminarProductoCliente(Producto producto) throws Exception{
         try{
            if(!productosEnVenta.contains(producto)){
                throw new productoNoRegistrado();
            }
            productosEnVenta.remove(producto);
            UtilidadJavaPop.eliminarProducto(producto);
            
            
          }catch(productoNoRegistrado pNR){
             throw pNR;
          }catch(NullPointerException npe){
              throw npe;
          }catch(Exception e){
             throw e;
         }
         
        }
        public Producto getProducto(int indice){
            return productosEnVenta.get(indice);

        }
        
        
        /**
         * Metdodo de busqueda por categoria, que queda ordenado por proximidad+urgencia
         * 
         * 
         * @param categoria del producto
         * @return retorna un ArrayList de Productos, los devolvera ordenados por urgencia+proximidad
         */
        public ArrayList<Producto> busquedaProductos(Producto.Categoria categoria){
            ArrayList <Producto> productosEncontrados = new ArrayList<>();
            for(Producto cadaProducto : UtilidadJavaPop.getProductosTotales()){
                if(cadaProducto.getCategoria().equals(categoria) && !productosEncontrados.contains(cadaProducto)
                        && !cadaProducto.getVendedor().getCorreo().equals(this.getCorreo())){
                    productosEncontrados.add(cadaProducto);
                }
            }
            ArrayList<Producto>productosEncontradosOrdenado = getProductosOrdenados(productosEncontrados, this);
            return productosEncontradosOrdenado;
  
        }
        
        
        /**
         * Metodo de busqueda de productos por categoria y palabras clave
         * 
         * 
         * 
         * @param categoria 
         * @param palabrasClave 
         * @return retorna un ArrayList con los productos que tengan dichas palabras clave y dicha categoria
         * ordenados por proximidad+urgencia
         */
        public ArrayList<Producto> busquedaProductos(Producto.Categoria categoria,String palabrasClave){
            try{
                ArrayList<Producto>productosFiltrados = new ArrayList<>();
                ArrayList<Producto>productosEncontrados = busquedaProductos(categoria);
                ArrayList<String>palabras = new ArrayList<>();
                StringTokenizer tokens = new StringTokenizer(palabrasClave);

                while(tokens.hasMoreTokens()){
                    palabras.add(tokens.nextToken()); 
                }
                
                if(palabras.size()>1){
                    for(String cadaPalabra : palabras){
                        for(Producto cadaProducto : productosEncontrados){
                            String titulo=cadaProducto.getTitulo().toLowerCase();
                            if(titulo.contains(cadaPalabra.toLowerCase()) && !productosFiltrados.contains(cadaProducto)){
                                productosFiltrados.add(cadaProducto);
                            }
                        }
                    }
                }else{
                        for(Producto cadaProducto : productosEncontrados){
                            String titulo=cadaProducto.getTitulo().toLowerCase();
                            if(titulo.contains(palabrasClave.toLowerCase()) && !productosFiltrados.contains(cadaProducto)){
                                productosFiltrados.add(cadaProducto);
                            }
                        }
                }
                ArrayList <Producto> productosFiltradosOrdenado=getProductosOrdenados(productosFiltrados, this);
                return productosFiltradosOrdenado;
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
          return null;
        }
        
        /**
         * Metodo el cual devuelve un producto mediante un indice 
         * 
         * 
         * 
         * @param busqueda
         * @return retorna un producto
         */
      
        public Producto getProductoBusqueda(ArrayList<Producto>busqueda){
            try{
                BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
                System.out.println(busqueda.toString());
                System.out.println("Introduzca el inidice del producto a comprar, 1 para el primero");
                int indice =Integer.parseInt(read.readLine());
                Producto resultado=busqueda.get(indice-1);


                return resultado;
            
            }catch(IOException ioe){
                System.out.println("ERROR: "+ioe.getMessage());
            }catch(Exception e){
                System.out.println("ERROR: "+e.getMessage());
            }
        return null;   
        }
        
        
        /**
         * Metodo el cual ordena los productos por Urgencia+proximidad
         * 
         * 
         * 
         * @param productosEncontrados ArrayList de los productos que se han buscado
         * @param comprador para averiguar la proximidad al cliente actual
         * @return retorna un Array de los productos ordenados
         */
        public ArrayList<Producto> getProductosOrdenados(ArrayList<Producto> productosEncontrados,Cliente comprador) {
        
            //Comparador para ordenar los productos por su urgencia y proximidad

            ArrayList <Producto> productosOrdenados=new ArrayList<>();
            ArrayList <Producto> muyCerca = new ArrayList<>();
            ArrayList <Producto> cerca = new ArrayList<>();
            ArrayList <Producto> lejos = new ArrayList<>();
            String codigoPostalComprador = comprador.getUbicacion().getCodigoPostal();
            String codigoPostalProducto;
                Comparator porUrgencia = new Comparator() {        
                    public int compare(Object o1, Object o2) {


                        Producto p1 = (Producto)o1;
                        Producto p2 = (Producto)o2;

                        String bool1;
                        String bool2;
                        if(p1.getUrgente()){
                            bool1="0";
                        }else{
                            bool1="1";
                        }
                        if(p2.getUrgente()){
                            bool2="0";
                        }else{
                            bool2="1";
                        }

                        String b1 =  bool1;
                        String b2 = bool2;    
                        return b1.compareTo(b2);
                    }
                };

                for(Producto cadaProducto : productosEncontrados){
                   codigoPostalProducto=cadaProducto.getUbicacionCliente().getCodigoPostal();
                   if(codigoPostalComprador.substring(0, 3).equalsIgnoreCase(codigoPostalProducto.substring(0, 3))){
                       muyCerca.add(cadaProducto);
                   }else{
                       if(codigoPostalComprador.substring(0, 2).equalsIgnoreCase(codigoPostalProducto.substring(0, 2))){
                           cerca.add(cadaProducto);
                       }else{
                           lejos.add(cadaProducto);
                       }
                   }

                }
                if(muyCerca.size()>0){     
                    Collections.sort(muyCerca,porUrgencia);
                    productosOrdenados.addAll(muyCerca);
                   }
                if(cerca.size()>0){
                    Collections.sort(cerca,porUrgencia);
                    productosOrdenados.addAll(cerca);
                }   
                if(lejos.size()>0){
                    Collections.sort(lejos,porUrgencia);
                    productosOrdenados.addAll(lejos);
                }
                return productosOrdenados;
            
        
    }

        
        /**
         * Metodo relativo a la venta del producto, en la cual el cliente decidirá o no si acepta la venta
         * 
         * 
         * 
         * @param producto el cual un comprador ha solicitado
         * @param comprador obtiene los datos del comprador
         */
        public void venderProducto(Producto producto,Cliente comprador) throws Exception{
            try{
                   this.productosVendidos.add(producto);
                   UtilidadJavaPop.VentaProducto(producto,comprador,this);
                   this.productosEnVenta.remove(producto);
            }catch(Exception e){
                throw e;      
            }      
        }
        
        
        /**
         * 
         * Metodo relativo a la compra de un producto, el cual si ese producto se encuentra en venta lanzara activara 
         * al vendedor la decision de si esta o no conforme con la venta
         * 
         * 
         * 
         * @param producto el cual se vendera
         */
        public void comprarProducto(Producto producto) throws Exception{
            try{
                if(this.productosEnVenta.contains(producto)){
                    throw new suProducto();
                }
                producto.getVendedor().venderProducto(producto, this);
                producto.setComprador(this);
                this.productosComprados.add(producto);
            
            }catch(Exception e){
                throw e;
            } 
        }

  
        
                /** Carga los datos de personas del fichero */
    public void cargarProductosEnVenta() {
        try {
            //Lectura de los objetos de tipo producto Vendido
            FileInputStream archivo= new FileInputStream("productosVentaCliente"+this.getCorreo()+".dat");
            ObjectInputStream ruta = new ObjectInputStream(archivo);
            this.productosEnVenta = (ArrayList) ruta.readObject();
            archivo.close();
            
            
        } catch (IOException ioe) {
            System.out.println("ERROR: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("ERROR: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }//fin cargarDatos

    /** Guarda los datos de usuarios en el fichero */
    public void guardarProductosEnVenta() {
        try {
            //Si hay datos los guardamos...
           
                /****** Serialización de los objetos ******/
                //Serialización de las productosEnVenta
                FileOutputStream archivo = new FileOutputStream("productosVentaCliente"+this.getCorreo()+".dat");
                ObjectOutputStream guardar= new ObjectOutputStream(archivo);
                //guardamos el array de productosEnVenta
                guardar.writeObject(productosEnVenta);
                archivo.close();
            

        } catch (IOException ioe) {
            System.out.println("ERROR: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
            /** Carga los datos de personas del fichero */
    public void cargarProductosVendidos() {
        try {
            //Lectura de los objetos de tipo productosVendidos
            FileInputStream archivo= new FileInputStream("productosVendidos"+this.getCorreo()+".dat");
            ObjectInputStream ruta = new ObjectInputStream(archivo);
            productosVendidos = (ArrayList) ruta.readObject();
            archivo.close();
            
            
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos

    /** Guarda los datos de usuarios en el fichero */
    public void guardarProductosVendidos() {
        try {
            //Si hay datos los guardamos...
            if (!productosVendidos.isEmpty()) {
                /****** Serialización de los objetos ******/
                //Serialización de los productosVendidos
                FileOutputStream archivo = new FileOutputStream("productosVendidos"+this.getCorreo()+".dat");
                ObjectOutputStream guardar= new ObjectOutputStream(archivo);
                //guardamos el array de personas
                guardar.writeObject(productosVendidos);
                archivo.close();
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("ERROR: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
            /** Carga los datos de personas del fichero */
    public void cargarProductosComprados() {
        try {
            //Lectura de los objetos de tipo productoComprado
            FileInputStream archivo= new FileInputStream("productosComprados"+this.getCorreo()+".dat");
            ObjectInputStream ruta = new ObjectInputStream(archivo);
            productosComprados = (ArrayList) ruta.readObject();
            archivo.close();
            
            
        } catch (IOException ioe) {
            System.out.println("Error de IO: " + ioe.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error de clase no encontrada: " + cnfe.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }//fin cargarDatos

    /** Guarda los datos de usuarios en el fichero */
        public void guardarProductosComprados() {
        try {
            //Si hay datos los guardamos...
            if (!productosComprados.isEmpty()) {
                /****** Serialización de los objetos ******/
                //Serialización de los productosComprados
                FileOutputStream archivo = new FileOutputStream("productosComprados"+this.getCorreo()+".dat");
                ObjectOutputStream guardar= new ObjectOutputStream(archivo);
                //guardamos el array de productosComprados
                guardar.writeObject(productosComprados);
                archivo.close();
            } else {
                System.out.println("Error: No hay datos...");
            }

        } catch (IOException ioe) {
            System.out.println("ERROR: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

        //Setters y Getters
      

        public ArrayList<Producto> getProductosUsuario() {
            return productosEnVenta;
        }

        public ArrayList<Producto> getProductosEnVenta() {
            return productosEnVenta;
        }

        public void setProductosEnVenta(ArrayList<Producto> productosEnVenta) {
            this.productosEnVenta = productosEnVenta;
        }

        public ArrayList<Producto> getProductosVendidos() {
            return productosVendidos;
        }

        public void setProductosVendidos(ArrayList<Producto> productosVendidos) {
            this.productosVendidos = productosVendidos;
        }

        public ArrayList<Producto> getProductosComprados() {
            return productosComprados;
        }

        public void setProductosComprados(ArrayList<Producto> productosComprados) {
            this.productosComprados = productosComprados;
        }


        public String getTarjetaCredito() {
            return tarjetaCredito;
        }

        public void setTarjetaCredito(String tarjetaCredito) {
            this.tarjetaCredito=tarjetaCredito;
        }

        public Ubicacion getUbicacion() {
            return ubicacion;
        }

        public void setUbicacion(Ubicacion ubicacion) {
            this.ubicacion = ubicacion;
        }
        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String Nombre) {
            this.Nombre = Nombre;
        }


        public String getDni() {
            return dni;
        }

        public void setDni(String dni) {
            this.dni = dni;
        }
       
        
       //Errores posibles en la clase
        
       class campoVacio extends Exception{
           public campoVacio(){
               super("ERROR: algún campo se encuentra vacío");
           }
       }      
       class productoYaAñadido extends Exception{
           public productoYaAñadido(){
               
               super("ERROR: Dicho producto ya lo ha creado anteriormente");
           }   
       }
       class productoNoRegistrado extends Exception{
           public productoNoRegistrado(){
               
               super("ERROR: Dicho producto no se encuentra registrado");
           }
       }
        class tarjetaInvalida extends Exception{
            public tarjetaInvalida(){
                super("ERROR: La tarjeta introducida no es valida");
            }
         }
        class UbicacionErronea extends Exception{
            public UbicacionErronea(){
                super("ERROR: La ubicacion asociada al producto no concuerda con la del usuario");
            }
            
        }
        class suProducto extends Exception{
            public suProducto(){
                
                super("ERROR: No puede comprar su propio producto");
            }
             
        }
        class ventaCancelada extends Exception{
            public ventaCancelada(){      
                super("ERROR: El vendedor no ha aprobado la venta");
            }
        }
    
        
       
       
       
       
        //Metodo toString para mostrar las propiedades del objeto
        @Override
        public String toString(){

           return "\n\n"+super.toString()+"," + "Dni: "+ this.dni +","+ " Nombre: "+this.Nombre+","+" ciudad: "
                   +", "+"Ubicacion: "+this.ubicacion+", "+"Tarjeta de Crédito: "+this.tarjetaCredito+", "+
                   "\nProductos en Venta{"+this.productosEnVenta+"}"+", " + "\nProductos Vendidos{"+this.productosVendidos+"}"+
                   ", "+"\nProductos Comprados{"+this.productosComprados+"}";
        }



    
}
