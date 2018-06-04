/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantbd;

public class altaExpedientes {
    
    private int id;
    private String fecha;
    private int tipo;
   
    
    

    /**
     * Constructor.
     * @param clave_ingred clave del ingrediente
     * @param nombre Nombre del Ingrediente
     */
    public altaExpedientes(int id, String fecha, int tipo) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        
    }
    
    

    
    
    
    /**
     * Retorna el id.
     *
     * @return Valor del id
     */
    public int getClaveExpediente() {
        return id;
    }
    
   
    /**
     * Retorna el nombre.
     *
     * @return El valor del nombre
     */
    public String getFecha() {
        return fecha;
    }
    
   public int getTipo(){
       return tipo;
   }
   
   
   
    @Override
    public String toString() {
        return fecha;
    }

}
