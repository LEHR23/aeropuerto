package aeropuerto;

public class ListaPaises {
    Pais inicio;
    
    public ListaPaises(){
        inicio = null;
    }
    
    public void add(Pais pais){
        if(inicio == null){
            inicio = pais;
        }else{
            Pais aux = inicio;
            while(aux.siguiente != null){
                aux = aux.siguiente;
            }
            aux.siguiente = pais;
        }
    }
}
