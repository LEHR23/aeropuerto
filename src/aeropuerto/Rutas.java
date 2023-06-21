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
public class Rutas {
    String ruta;
    int costo;
    Rutas siguiente;
    
    public Rutas(String r, int c, Rutas s){
        ruta = r;
        costo = c;
        siguiente = s;
    }
}
