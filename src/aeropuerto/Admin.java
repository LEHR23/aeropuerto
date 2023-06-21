package aeropuerto;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;

public class Admin  {

    Mapa mapa;
    Grafo grafo;
    private int Coord[][];
    ImageIcon Banderas[];

    final String Paises[] = {"ESTADOS UNIDOS", "MEXICO", "ARGENTINA", 
        "ESPAÑA", "LONDRES", "ITALIA", "INDIA", "JAPON"};

    private int matriz_adyacencia[][] = {{0, 1, 1, 1, 0, 0, 0, 0},
    {1, 0, 0, 0, 1, 0, 0, 1},
    {0, 0, 0, 1, 0, 0, 1, 0},
    {1, 1, 0, 0, 1, 1, 0, 0},
    {0, 1, 0, 0, 0, 1, 0, 1},
    {0, 0, 0, 1, 1, 0, 1, 1},
    {0, 0, 0, 1, 0, 1, 0, 1},
    {0, 1, 0, 0, 0, 1, 0, 0}};

    private int matriz[][] = {{0, 1, 1, 1, 0, 0, 0, 0},
    {1, 0, 0, 0, 1, 0, 0, 1},
    {0, 0, 0, 1, 0, 0, 1, 0},
    {1, 1, 0, 0, 1, 1, 0, 0},
    {0, 1, 0, 0, 0, 1, 0, 1},
    {0, 0, 0, 1, 1, 0, 1, 1},
    {0, 0, 0, 1, 0, 1, 0, 1},
    {0, 1, 0, 0, 0, 1, 0, 0}};

    private int matriz_valores[][] = {{0, 1, 3, 4, 0, 0, 0, 0},
    {1, 0, 0, 0, 8, 0, 0, 12},
    {0, 0, 0, 5, 0, 0, 7, 0},
    {4, 3, 0, 0, 1, 2, 0, 0},
    {0, 8, 0, 0, 0, 1, 0, 3},
    {0, 0, 0, 2, 1, 0, 2, 6},
    {0, 0, 0, 1, 0, 1, 0, 1},
    {0, 1, 0, 0, 0, 1, 0, 0}};
    
    private final String sufijos[] = {"EU", "MX", "ARG", "ESP", "LON", "ITA", 
        "IND", "JPN"};
    private final Color colores[] = {Color.ORANGE, Color.GREEN, Color.CYAN, 
        Color.RED, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.PINK};
    
    private int ruta[];

    public Admin() {
        this.Coord = new int[8][2];
        this.grafo = new Grafo();
        inicBanderas();
        this.asignCoords();
    }

    private void asignCoords() {
        //ESTADOS UNIDOS
        this.Coord[0][0] = 80;
        this.Coord[0][1] = 80;
        //MEXICO
        this.Coord[1][0] = 60;
        this.Coord[1][1] = 120;
        //ARGENTINA
        this.Coord[2][0] = 140;
        this.Coord[2][1] = 230;
        //ESPAÑA
        this.Coord[3][0] = 250;
        this.Coord[3][1] = 85;
        //LONDRES
        this.Coord[4][0] = 250;
        this.Coord[4][1] = 55;
        //ITALIA
        this.Coord[5][0] = 280;
        this.Coord[5][1] = 80;
        //INDIA
        this.Coord[6][0] = 405;
        this.Coord[6][1] = 120;
        //JAPON
        this.Coord[7][0] = 505;
        this.Coord[7][1] = 79;
    }

    private void inicBanderas() {
        Banderas = new ImageIcon[8];
        Banderas[0] = new ImageIcon("src/Banderas/United-States.png");
        Banderas[1] = new ImageIcon("src/Banderas/Mexico.png");
        Banderas[2] = new ImageIcon("src/Banderas/Argentina.png");
        Banderas[3] = new ImageIcon("src/Banderas/Spain.png");
        Banderas[4] = new ImageIcon("src/Banderas/United-Kingdom.png");
        Banderas[5] = new ImageIcon("src/Banderas/Italy.png");
        Banderas[6] = new ImageIcon("src/Banderas/India.png");
        Banderas[7] = new ImageIcon("src/Banderas/Japan.png");
    }

    public void buscarVuelos() {
        this.mapa.mapMinRes();
    }
    
    public void selecVuelo(String paises){
        this.grafo.setBounds(this.mapa.getBounds());
        this.dibujarGrafo();
        this.dibujarRuta(paises);
    }
    
    public void dibujarGrafo(){
        this.dibujarRutas();
        this.dibujarNodos();
    }
    
    private void dibujarNodos(){
        this.grafo.setBounds(this.mapa.getBounds());
        this.grafo.dibujarNodo(this.Coord[0][0], this.Coord[0][1], this.colores[0], 
                false, sufijos[0]); //ESTADOS UNIDOS
        this.grafo.dibujarNodo(this.Coord[1][0], this.Coord[1][1], this.colores[1], 
                false, sufijos[1]); //MEXICO
        this.grafo.dibujarNodo(this.Coord[2][0], this.Coord[2][1], this.colores[2], 
                false, sufijos[2]); //ARGENTINA
        this.grafo.dibujarNodo(this.Coord[3][0], this.Coord[3][1], this.colores[3], 
                false, sufijos[3]); //ESPAÑA
        this.grafo.dibujarNodo(this.Coord[4][0], this.Coord[4][1], this.colores[4], 
                false, sufijos[4]); //LONDRES
        this.grafo.dibujarNodo(this.Coord[5][0], this.Coord[5][1], this.colores[5], 
                false, sufijos[5]); //ITALIA
        this.grafo.dibujarNodo(this.Coord[6][0], this.Coord[6][1], this.colores[6], 
                false, sufijos[6]); //INDIA
        this.grafo.dibujarNodo(this.Coord[7][0], this.Coord[7][1], this.colores[7], 
                false, sufijos[7]); //JAPON
        
    }
    
    private void dibujarRutas(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(this.matriz_adyacencia[i][j] == 1){
                    this.grafo.dibujarLinea(this.Coord[i][0], this.Coord[i][1], 
                            this.Coord[j][0], this.Coord[j][1], Color.WHITE);
                }
            }
        }
    }
    
    
    public int getIndex(String pais){
        switch(pais){
            case "ESTADOS UNIDOS": return 0;
            case "MEXICO": return 1;
            case "ARGENTINA": return 2;
            case "ESPAÑA": return 3;
            case "LONDRES": return 4;
            case "ITALIA": return 5;
            case "INDIA": return 6;
            case "JAPON": return 7;
        }
        return -1;
    }
    
    private void dibujarRuta(String ruta){
        ListaPaises listapaises = new ListaPaises();
        String pais = "";
        
        for (int i = 0; i < ruta.length(); i++) {
            if(ruta.charAt(i) != '-'){
                pais = pais + ruta.charAt(i);
            }else{
                listapaises.add(new Pais(getIndex(pais)));
                pais = "";
            }
        }
        listapaises.add(new Pais(getIndex(pais)));
        
        Pais p = listapaises.inicio;
        
        while(p.siguiente != null){
            this.grafo.dibujarLinea(this.Coord[p.index][0], 
                    this.Coord[p.index][1], this.Coord[p.siguiente.index][0], 
                    this.Coord[p.siguiente.index][1], Color.RED);
            p = p.siguiente;
        }
    }
    
    private void warshall() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                if (matriz_adyacencia[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        if (matriz_adyacencia[k][i] == 1) {
                            matriz_adyacencia[k][j] = 1;
                        }
                    }
                }
            }
        }
    }
    
    //**************************************************************************
    public void rellenarmatriz(){
        int matrizaux [][] =   {{0, 1, 1, 1, 0, 0, 0, 0},
                    {1, 0, 0, 0, 1, 0, 0, 1},
                    {0, 0, 0, 1, 0, 0, 1, 0},
                    {1, 1, 0, 0, 1, 1, 0, 0},
                    {0, 1, 0, 0, 0, 1, 0, 1},
                    {0, 0, 0, 1, 1, 0, 1, 1},
                    {0, 0, 0, 1, 0, 1, 0, 1},
                    {0, 1, 0, 0, 0, 1, 0, 0}};
        matriz = matrizaux;
    }
    
    ListaRutas rutas = new ListaRutas();
    public ListaRutas rutas(int origen, int desitno){
        rellenarmatriz();
        for (int i = 0; i < 8; i++) {
            matriz[i][origen] = 0;
        }
        int cont = 1;
        int visitados[] = {-1,-1,-1,-1,-1,-1,-1,-1};
        visitados[0] = origen;
        String ruta = "";
        int costo = 0;
        rutas = new ListaRutas();
        for (int i = 0; i < 8; i++) {
            if(matriz[visitados[cont-1]][i] == 1){
                visitados[cont] = i;
                cont++;
                if(i == desitno){
                    for (int j = 0; j < 8; j++) {
                        if(visitados[j] != -1){
                            if (j == 0 ) ruta = Paises[visitados[j]];
                            else ruta = ruta + "-" + Paises[visitados[j]];
                            if(j<7){
                                if(visitados[j+1] != -1){
                                    costo = costo + matriz_valores[visitados[j]][visitados[j+1]];
                                }
                            }
                        }else{
                            rutas.add(ruta, costo);
                            costo = 0;
                            ruta = "";
                            cont--;
                            visitados[cont] = -1;
                            j = 8;
                        }
                        if(cont == 8 && j == 7){
                            rutas.add(ruta, costo);
                            costo = 0;
                            ruta = "";
                            cont--;
                            visitados[cont] = -1;
                        }
                    }
                }else{
                    boolean visi = true;
                    for (int j = 0; j < cont-1; j++) {
                        if(i == visitados[j]){
                            visi = false;
                            cont--;
                            visitados[cont] = -1;
                        }
                    }
                    if(visi){
                        i = -1;
                    }
                }
            }
            while(i == 7 && cont != 1){
                cont--;
                i = visitados[cont];
                visitados[cont] = -1;
            }
        }
        return rutas;
    }

    public void buscarrutas(DefaultListModel Model, int seleccion1, int seleccion2) {
        ListaRutas listaderutas = this.rutas(seleccion1, seleccion2);
        Rutas rutas = listaderutas.ruta;
        while(rutas.siguiente != null){
            Model.add(Model.getSize(), rutas.ruta);
            rutas = rutas.siguiente;
        }
        Model.add(Model.getSize(), rutas.ruta);
    }

    int obtenercosto(int selectedIndex, DefaultListModel Model) {
        ListaRutas r = rutas;
        Rutas ru = rutas.ruta;
        for (int i = 0; i < selectedIndex; i++) {
            ru = ru.siguiente;
        }
        int cos = ru.costo;
        return cos;
    }
    //**************************************************************************

}
