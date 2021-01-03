
package clases;
import java.util.*;
import java.io.*;
import javax.swing.JOptionPane;



public class UtilidadJavaPop{
    
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Producto> productosTotales = new ArrayList<>();
    private static ArrayList <Venta> ventas = new ArrayList<>();
    private static final Administrador admin = new Administrador("admin@javapop.com", "admin");
    
    //Getters
    public static Producto getProducto(int indice){
        return productosTotales.get(indice); 
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        UtilidadJavaPop.usuarios = usuarios;
    }

 

    public static ArrayList<Producto> getProductosTotales() {
        //Comparador para ordenar las personas por su urgencia
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
        //Ordenamos el array
        Collections.sort(productosTotales, porUrgencia);
        return productosTotales;

    }
    public static ArrayList<Usuario> getUsuarios() {
        //Comparador para ordenar a los usuarios por correo
        Comparator porCorreo = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Usuario u1 = (Usuario) o1;
                Usuario u2 = (Usuario) o2;
                return u1.getCorreo().compareTo(u2.getCorreo());
            }
        };
        

        //Ordenamos el array
        Collections.sort(usuarios, porCorreo);
        return usuarios;
    }

    public static ArrayList<Venta> getVentas() {
        
            //Comparador para ordenar las ventas por fecha de compra
            Comparator porFecha = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Venta v1 = (Venta) o1;
                Venta v2 = (Venta) o2;
                return v1.getFechaCompra().compareTo(v2.getFechaCompra());
            }
        };


        //Ordenamos el array
        Collections.sort(ventas, porFecha);  
        return ventas;
    }

        public static void setVentas(ArrayList<Venta> ventas) {
            UtilidadJavaPop.ventas = ventas;
        }

    
    
    /**
     * //Metodo el cual añade el usuario al ArrayList de todos los usuarios de la aplicacion
     * 
     * 
     * @param usuario
     * @throws Exception 
     */
    
    //Metodo para añadir usuarios al arraylist de usuarios
    private static void añadirUsuario(Usuario usuario) throws Exception{
      try{
          
          
        //Comprobamos que el objeto usuario no se encuentra ya creado
        if(UtilidadJavaPop.usuarios.contains(usuario)){
            throw new yaRegistrado();
        }
        
        /*Recorremos el arraylist para ver si el correo ya se encuentra registrado, ya que un correo solo se puede
        registrar una vez*/
        for(Usuario cadaUsuario : UtilidadJavaPop.usuarios){
            if(cadaUsuario.getCorreo().equals(usuario.getCorreo())){
                throw new correoRegistrado();
            }
        }
        //Si no ha habido ningun error anteriormente, añadimos al usuario al arraylist
        UtilidadJavaPop.usuarios.add(usuario);
        
      }catch(yaRegistrado yaR){
          throw yaR;
      }catch(correoRegistrado cR){
          throw cR;
      }catch(Exception e){
          throw e;
      }
    }
    
    /**
     * Metodo el cual elimina un usuario del ArrayList de todos los usuarios
     * 
     * 
     * @param usuario
     * @throws Exception 
     */
    public static void eliminarUsuario(Usuario usuario) throws Exception{
       try{
        if(!usuarios.contains(usuario)){
            throw new usuarioNoRegistrado();
        }
        usuarios.remove(usuario);
       }catch(usuarioNoRegistrado uNR){
           throw uNR;
       }
       catch(Exception e){
           throw e;
       }
    }
    public static void añadirVenta(Venta venta){
        if(!ventas.contains(venta)){    
            ventas.add(venta); 
        }
    }
    
    /**
     * 
     * Metodo para añadir productos al arraylist de todos los productos
     * 
     * 
     * @param producto
     * @throws Exception 
     */
    public static void añadirProducto(Producto producto) throws Exception{
        try{
            if(productosTotales.contains(producto)){
                throw new productoYaCreado();
            }
            productosTotales.add(producto);

        }catch(productoYaCreado pYC){
            throw pYC;
        }catch(Exception e){
            throw e;
        }    
    }
    
    //Metodo para eliminar productos del arraylist de todos los productos
    public static void eliminarProducto(Producto producto){
        if(productosTotales.contains(producto)){
            productosTotales.remove(producto);
        }else{
            System.out.println("El producto no se encuentra registrado");
        }
    }
    
    
    /**
     * Metodo para Añadir al Administrador definido en la clase Utilidad
     * 
     * 
     * 
     */
    //Introduciremos al administrador en el programa
    public static void añadirAdmin(){
        if(!usuarios.contains(admin)){
                usuarios.add(admin);
        }
    }
    
    /**
     * 
     * Metodo para registrar usuarios(validarlos y posteriormente añadirlos al arraylist)
     * 
     * 
     * 
     * 
     * @param usuario
     * @throws Exception 
     */
    public static void registrarCliente(Usuario usuario) throws Exception{
      try{
       //Validamos si el correo contiene @javapop.com
       int longitudCorreo = usuario.getCorreo().length();
       if(!usuario.getCorreo().substring(longitudCorreo-12, longitudCorreo).equals("@javapop.com")){
           throw new CorreoInvalido();
       }
       //Validamos si el usuario se esta intentando registrar como administrador
       if(usuario.getCorreo().equals("admin@javapop.com") || 
               usuario.getClass().getSimpleName().equals(Administrador.class.getSimpleName())){
           throw new RegistrarseAdmin();
       }
       
       //Si no ha habido ningun error al validarlo, se añade al arraylist
       UtilidadJavaPop.añadirUsuario(usuario);
      }
      catch(CorreoInvalido ci){
          throw ci;
      }
      catch(RegistrarseAdmin ra){
          throw ra;
      }
      catch(Exception e){  
          throw e;
      }  
    }
    
    /**
     * 
     * Metodo el cual recibe un cliente normal, crea un cliente Profesional y elimina el cliente anterior
     * pasándole toda la información(incluidos  los productos) al cliente Profesional nuevo
     * 
     * 
     * 
     * 
     * @param cliente
     * @param descripcion
     * @param telefono
     * @param horario
     * @param web
     * @return
     * @throws Exception 
     */
    public static ClienteProfesional hacerseProfesional(Cliente cliente,String descripcion,int telefono,String horario,String web)
            throws Exception{
        try{
            if(cliente.getClass().equals(Cliente.class)){
                ClienteProfesional clienteProf = new ClienteProfesional(cliente.getCorreo()
                        ,cliente.getContraseña(),cliente.getDni(),cliente.getNombre(),
                        cliente.getUbicacion().getCodigoPostal(),cliente.getUbicacion().getCiudad()
                        , cliente.getTarjetaCredito(), descripcion, telefono, horario, web);
                
                admin.bajaCliente(cliente.getCorreo());
                UtilidadJavaPop.registrarCliente(clienteProf);
                if(cliente.getProductosEnVenta()!=null &&
                        cliente.getProductosEnVenta().size()>0){
                    for(Producto cadaProducto : cliente.getProductosEnVenta()){
                        clienteProf.añadirProductoCliente(cadaProducto);
                    }
                    
                }                
                if(cliente.getProductosComprados()!=null &&
                        cliente.getProductosComprados().size()>0){
                    for(Producto cadaProducto : cliente.getProductosComprados()){
                        clienteProf.añadirProductoCliente(cadaProducto);
                    }
                }
                if(cliente.getProductosVendidos()!=null &&
                        cliente.getProductosVendidos().size()>0){
                    for(Producto cadaProducto : cliente.getProductosVendidos()){
                        clienteProf.añadirProductoCliente(cadaProducto);
                    }
                    
                }
              return clienteProf;
            }
        }catch(Exception e){
            throw e;
        }
        return null;
    }
    
    
    
    
    /**
     * Metodo para buscar un usuario por su correo en el ArrayList de todos los usuarios
     * 
     * 
     * 
     * @param correo
     * @return 
     */
    public static Usuario busquedaUsuario(String correo){
        
        for(Usuario cadaUsuario : usuarios){
            if(cadaUsuario.getCorreo().equals(correo)){
               return cadaUsuario; 
            }   
        }
        return null;
    }
    
    /**
     * 
     * Metodo el cual crea un 'recibo' en el que se plasman los datos del producto vendido, del comprador y
     * del vendedor
     * 
     * 
     * @param producto
     * @param comprador
     * @param vendedor
     * @throws IOException 
     */
    
    public static void VentaProducto(Producto producto,Cliente comprador, Cliente vendedor) throws IOException{
        
        Venta venta = new Venta(producto, comprador,vendedor);
        añadirVenta(venta);
        File archivo = new File("venta+"+venta.getFechaCompra()+"-"+venta.getProducto().getTitulo()+".txt");
        BufferedWriter salida = new BufferedWriter(new FileWriter(archivo));
        salida.write("************Recibo*************");
        salida.write("\nDatos del producto vendido: "+producto);
        salida.write("\nDNI del vendedor: "+vendedor.getDni()+"\nDNI del comprador: "+comprador.getDni());
        salida.write("\nNombre del vendedor: "+vendedor.getNombre()+"\nNombre del Comprador: "+comprador.getNombre());
        salida.write("\nFecha de la compra: "+venta.getFechaCompra().toString());
        salida.write("\n*****************************");
        salida.close();
        productosTotales.remove(producto);
              
    }
    
        /** Carga los datos de personas del fichero */
    public static void cargarUsuarios() {
        try {
            //Lectura de los objetos de tipo usuario
            FileInputStream archivo= new FileInputStream("usuarios.dat");
            ObjectInputStream ruta = new ObjectInputStream(archivo);
            usuarios = (ArrayList) ruta.readObject();
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
    public static void guardarUsuarios() {
        try {
            //Si hay datos los guardamos...
            if (!usuarios.isEmpty()) {
                /****** Serialización de los objetos ******/
                //Serialización de los usuarios
                FileOutputStream archivo = new FileOutputStream("usuarios.dat");
                ObjectOutputStream guardar= new ObjectOutputStream(archivo);
                //guardamos el array de usuarios
                guardar.writeObject(usuarios);
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
    public static void cargarProductos() {
        try {
            //Lectura de los objetos de tipo producto
            FileInputStream archivo= new FileInputStream("productos.dat");
            ObjectInputStream ruta = new ObjectInputStream(archivo);
            productosTotales = (ArrayList) ruta.readObject();
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
    public static void guardarProductos() {
        try {
            //Si hay datos los guardamos...
            if (!productosTotales.isEmpty()) {
                /****** Serialización de los objetos ******/
                //Serialización de los productos
                FileOutputStream archivo = new FileOutputStream("productos.dat");
                ObjectOutputStream guardar= new ObjectOutputStream(archivo);
                //guardamos el array de productos
                guardar.writeObject(productosTotales);
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
    public static void cargarVentas() {
        try {
            //Lectura de los objetos de tipo venta
            FileInputStream archivo= new FileInputStream("ventas.dat");
            ObjectInputStream ruta = new ObjectInputStream(archivo);
            ventas = (ArrayList) ruta.readObject();
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
    public static void guardarVentas() {
        try {
            //Si hay datos los guardamos...
            if (!ventas.isEmpty()) {
                /****** Serialización de los objetos ******/
                //Serialización de las ventas
                FileOutputStream archivo = new FileOutputStream("ventas.dat");
                ObjectOutputStream guardar= new ObjectOutputStream(archivo);
                //guardamos el array de ventas
                guardar.writeObject(ventas);
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

    //Metodo para mostrar todos los usuarios registrados
    public static String mostrarUsuarios(){
        return usuarios.toString();
    }
    
    //Metodo para mostrar todos los productos creados
    public static String mostrarProductos(){
        return productosTotales.toString();    
    }
    //Metodo para mostrar las ventas producidas
    public static String mostrarVentas(){
        return ventas.toString();
    }
  
  
    /*****Clases para posibles errores en la clase Utilidad*****/
    //Error asociado a la introduccion incorrecta del correo electronico
    static class  CorreoInvalido extends Exception{
      private CorreoInvalido(){
        super("ERROR: El correo introducido no es valido ");
        }
    }
    //Error asociado al intento de registro de tipo Administrador por un usuario tipo cliente
    static class RegistrarseAdmin extends Exception{
        private RegistrarseAdmin(){
            super("ERROR: Usted se esta intentando registrar como administrador, no tiene derechos para ello");    
        }         
    }
    //Error asociado al ya registro de un usuario
    static class yaRegistrado extends Exception{
        private yaRegistrado(){    
            super("ERROR: Usted ya se encuentra registrado");
        }
    }
    static class correoRegistrado extends Exception{
        private correoRegistrado(){
            super("ERROR: El correo ya está en uso");
        }
        
    }
    
    //Error asociado al intento de añadir un producto ya existente
    static class productoYaCreado extends Exception{
        private productoYaCreado(){
            super("ERROR: Dicho producto ya se encuentra añadido");
            
        }   
    }
    static class correoNoRegistrado extends Exception{
        private correoNoRegistrado(){
            super("ERROR: El correo que ha introducido no se encuentra registrado");
        }
    }
    static class usuarioNoRegistrado extends Exception{
        public usuarioNoRegistrado(){
            super("ERROR: El usuario no se encuentra registrado");
        }
    }
}






    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

