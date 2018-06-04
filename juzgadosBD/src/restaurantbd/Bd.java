package restaurantbd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public final class Bd {

    /**
     * Iniciamos la conexión hacia la base de datos, como primer paso,
     * introducimos las variables que contienen la información sobre la ruta de
     * conexión, el usuario de la base de datos, el driver para llevar la
     * conexión y la contraseña para acceder.
     */
    private final String CONTROLADOR = "com.mysql.jdbc.Driver";
    private final String URL_BASEDATOS = "jdbc:mysql://localhost:3306/juzgados";
    private final String USUARIO = "root";
    private final String PWD = "dw44";

    /**
     * En este paso se intenta realizar la conexión a la base de datos, por
     * medio del controlador.
     */
    public Bd() {
        try {
            Class.forName(CONTROLADOR);
        } catch (ClassNotFoundException ex) {
            System.out.println("No fue posible cargar el controlador de la base de datos");
        }
    }
    /*
     Cuando se detecta el controlador,  se intenta realizar la conexión a la base de datos, 
     cargando las variables anteriores de los datos para acceder a la base de datos.
     */

    public Connection conectar() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL_BASEDATOS, USUARIO, PWD);
        } catch (Exception ex) {
            /*
             Si falla la conexión,  se regresa un valor vacío y no se permite el acceso a la base de datos.
             */
            System.err.println("No fue posible conectar con el servidor");
        } finally {
            return conn;
        }
    }
    
       public static Bd verificarUsuarioParametrizada(String usuario, String pwd) {
        Bd bd = new Bd();
        /*
         se realiza la consulta hacia la base de datos.
         */
        try (Connection conexion = bd.conectar()) {
            String consulta = "SELECT * FROM tusuariosistema WHERE CnomUsuSist = ? AND CcontraseñaUsuSist = ?";
            /*
             Se preprara un sttement para los datos recibidos del formulario.
             */
            try (PreparedStatement instruccion = conexion.prepareStatement(consulta)) {
                instruccion.setString(1, usuario);
                instruccion.setString(2, pwd);
                /*
                 Regresa el resultado obtenido de la base de datos. 
                 */
                try (ResultSet conjuntoResultados = instruccion.executeQuery()) {
                    if (conjuntoResultados.next()) {
                        return bd;
                    }
                }
            }
            /*
             Si el resultado no coincide, se regresa un registro 0 de la base de datos. 
             */
        } catch (Exception ex) {
            System.err.println("Sucedió un error al intentar verificar el usuario");
        }

        return null;
    }
    
    public List<altaExpedientes> getExpedientes() {
        List<altaExpedientes> listaExpedientes = new ArrayList();
        /*
         se realiza la consulta hacia la base de datos.
         */
        try (Connection conexion = this.conectar()) {
            String consulta = "SELECT * FROM tinfexpediente";
            /*
             Se preprara un statement para los datos recibidos del formulario.
             */
            try (Statement instruccion = conexion.createStatement()) {

                try (ResultSet conjuntoResultados = instruccion.executeQuery(consulta)) {
                    while (conjuntoResultados.next()) {
                        int id = conjuntoResultados.getInt("CnumExp");
                        String fecha = conjuntoResultados.getString("CfechaExp");
                        int tipoCaso = conjuntoResultados.getInt("CtipoCaso_idCaso");
                        
                        
                        /*
                         Se regresan los datos obtenidos dentro de una lista
                         */
                        altaExpedientes expedientes = new altaExpedientes(id, fecha, tipoCaso);

                        listaExpedientes.add(expedientes);
                    }
                }
            }
            /*
             Si ocurre un error en la consulta, se regresa una notificación de error.
             */
        } catch (Exception ex) {
            System.err.println("Sucedió un error al intentar obtener los expedientes");
        }
        /*
         Se regresa la lista de datos obtenidos al formulario.
         */
        return listaExpedientes;
    }
    
    
//    public int eliminarIngredientes(List<altaIngredientes> listaIngredientes) {
//        int cantidadEliminados = 0;
//        /*
//         se realiza la consulta hacia la base de datos.
//         */
//        try (Connection conexion = conectar()) {
//            String consulta = "DELETE FROM ingredientes_p WHERE clave_Ingred = ?";
//            /*
//             Se preprara un statement para los datos recibidos del formulario.
//             */
//            try (PreparedStatement instruccion = conexion.prepareStatement(consulta)) {
//                for (altaIngredientes ingrediente : listaIngredientes) {
//                    instruccion.setInt(1, ingrediente.getClaveIngrediente());
//                    instruccion.addBatch();
//                }
//                /*
//                 Dentro del arreglo, se introducen la cantidad de elementos seleccionados por cambiar en la base de datos.  
//                 */
//                int[] cantidades = instruccion.executeBatch();
//
//                for (int cantidad : cantidades) {
//                    cantidadEliminados += cantidad;
//                }
//            }
//            /*
//             Si ocurre un error en la consulta, se regresa una notificación de error.
//             */
//        } catch (Exception ex) {
//            System.err.println("Sucedió un error al intentar eliminar el ingrediente");
//        }
//        /*
//         Se regresa los datos obtenidos al formulario.
//         */
//        return cantidadEliminados;
//    }
    
//     public int agregarIngrediente(altaIngredientes ingrediente) {
//        int cantidadAgregados = 0;
//        /*
//         se realiza la consulta hacia la base de datos.
//         */
//        try (Connection conexion = conectar()) {
//            String consulta = "INSERT INTO ingredientes_p VALUES (DEFAULT, ?, ?, ?)";
//            /*
//             Se preprara un statement para los datos recibidos del formulario.
//             */
//            try (PreparedStatement instruccion = conexion.prepareStatement(consulta)) {
//                instruccion.setString(1, ingrediente.getNombre());
//                instruccion.setInt(2, ingrediente.getCantidad());
//                instruccion.setString(3, ingrediente.getMedida());
//               
//                cantidadAgregados = instruccion.executeUpdate();
//
//            }
//            /*
//             Si ocurre un error en la consulta, se regresa una notificación de error.
//             */
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Ya existe el ingredientre", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//        /*
//         Se regresa los datos obtenidos al formulario.
//         */
//        return cantidadAgregados;
//    }
     
//     public int modificarIngrediente(altaIngredientes ingrediente) {
//        int cantidadModificados = 0;
//        /*
//         se realiza la consulta hacia la base de datos.
//         */
//        try (Connection conexion = conectar()) {
//            String consulta = "UPDATE ingredientes_p SET nombre=?, cantidad=?, u_medida=? WHERE clave_Ingred=?";
//
//            try (PreparedStatement instruccion = conexion.prepareStatement(consulta)) {
//                /*
//                 Se preprara un statement para los datos recibidos del formulario.
//                 */
//                
//                
//                instruccion.setString(1, ingrediente.getNombre());
//                instruccion.setInt(2, ingrediente.getCantidad());
//                instruccion.setString(3, ingrediente.getMedida());
//                instruccion.setInt(4, ingrediente.getClaveIngrediente());
//                
//
//                cantidadModificados = instruccion.executeUpdate();
//
//            }
//            /*
//             Si ocurre un error en la consulta, se regresa una notificación de error.
//             */
//        } catch (Exception ex) {
//            System.err.println(ex);
//            JOptionPane.showMessageDialog(null, "Sucedió un error al modficar el ingrediente", "Error", JOptionPane.ERROR_MESSAGE);
//
//        }
//        /*
//         Se regresa los datos obtenidos al formulario.
//         */
//        return cantidadModificados;
//    }
//    
 

   
  
}
