/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aeropuerto;

/**
 *
 * @author ernesto
 */
public class ListaRutas {
    
    Rutas ruta;
    
    public ListaRutas(){
        ruta = null;
    }
    
    public void add(String r, int c){
        ruta = new Rutas(r,c,ruta);
    }
}
