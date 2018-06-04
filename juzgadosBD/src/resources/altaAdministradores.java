/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

public class altaAdministradores
{
    
private int id;
    
    private String usuarioAdministrador;
    private String contraseñaAdministrador;
   
    

    /**
     * Constructor.
     * @param id Id del usuario
     * @param nombreAdministrador
     * @param usuarioAdministrador
     * @param contraseñaAdministrador
     */
   
    
    public altaAdministradores(int id, String nombreAdministrador, String usuarioAdministrador, String contraseñaAdministrador) {
        this.id = id;
        this.usuarioAdministrador = usuarioAdministrador;
        this.contraseñaAdministrador = contraseñaAdministrador;  
        
        
    }
    
     public altaAdministradores(String nombreAdministrador, String usuarioAdministrador, String contraseñaAdministrador) {
       
        this.usuarioAdministrador = usuarioAdministrador;
        this.contraseñaAdministrador = contraseñaAdministrador;
        
        
        
    }
        /**
     * Retorna el id.
     *
     * @return El valor del id
     */
     public int getId() {
        return id;
    }
    /**
     * Retorna el nombre.
     *
     * @return El valor del nombre
     */
   
    @Override
    public String toString() {
        return usuarioAdministrador;
    }
    
    /**
     * Retorna el usuario.
     *
     * @return Valor del usuario
     */
    public String getUsuario() {
        return usuarioAdministrador;
    }
       /**
     * Retorna el password.
     *
     * @return El valor del password
     */
    public String getPass() {
        return contraseñaAdministrador;
    }
    
    
    
     
    
   

}
