package aeropuerto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Form extends JFrame implements ActionListener, ItemListener, MouseListener, 
        ListSelectionListener{

    Admin admin;
    JLabel LTitulo, LOrigen, LDestino, LBOrigen, LBDestino, LBuscar, LMapa,
            LBoleto, LBComprar;
    JPanel PMenu, PResultado, PVuelos, PLista, PBoleto;
    Icon MapaRed, IOrigen, IDestino;
    ImageIcon OrigenI, DestinoI;
    JComboBox CBOrigen, CBDestino;
    Border raisedbevel, loweredbevel, compound;
    Rectangle rctngl1, rctngl2, rctngl3;
    JScrollPane scrollpane;
    JList Lista;
    DefaultListModel Model;
    
    //*********************************************************************
    int seleccion1,seleccion2;
    //*********************************************************************

    public Form(Admin admin) {
        this.admin = admin;
        initComponents();
    }

    private void initComponents() {
        this.setTitle("Aeropuerto");
        this.setSize(1080, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        
        this.raisedbevel = BorderFactory.createRaisedBevelBorder();
        this.loweredbevel = BorderFactory.createLoweredBevelBorder();
        this.compound = BorderFactory.createCompoundBorder(this.raisedbevel,
                this.loweredbevel);

        this.PMenu = new JPanel();
        this.PMenu.setBounds(0, 0, 1080, 200);
        this.PMenu.setBackground(Color.WHITE);
        this.PMenu.setLayout(null);

        this.PResultado = new JPanel();
        this.PResultado.setBounds(0, 201, 1080, 519);
        this.PResultado.setBackground(new Color(97, 160, 101));
        this.PResultado.setLayout(null);
        
        this.admin.mapa = new Mapa();
        this.admin.mapa.setBounds(0, 0, 1080, 519);
        this.admin.mapa.setFont(new Font("Times New Roman", Font.BOLD, 32));
        this.admin.mapa.setHorizontalAlignment(SwingConstants.CENTER);
        this.admin.mapa.setOpaque(true);
        this.admin.mapa.setForeground(Color.WHITE);
        this.admin.mapa.setBackground(Color.BLACK);
        
        this.PResultado.add(this.admin.grafo);
        this.PResultado.add(this.admin.mapa);

        this.PVuelos = new JPanel();
        this.PVuelos.setBounds(5, 5, 472, 480);
        this.PVuelos.setBorder(this.compound);
        this.PVuelos.setBackground(new Color(204, 229, 204));
        this.PVuelos.setLayout(null);
        this.PResultado.add(this.PVuelos);
        
        this.Model = new DefaultListModel();
        
        this.Lista = new JList();
        this.Lista.setBounds(5, 5, 462, 472);
        this.Lista.setFont(new Font("Times New Roman", Font.BOLD, 16));
        this.Lista.setBackground(Color.BLACK);
        this.Lista.setForeground(new Color(204, 229, 204));
        this.Lista.setModel(this.Model);
        this.Lista.addListSelectionListener(this);
        this.Lista.addMouseListener(this);
        this.Lista.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.Lista.setLayout(null);

        this.rctngl3 = new Rectangle(10, 10, 422, 50);

        this.scrollpane = new JScrollPane(this.Lista,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.scrollpane.setBounds(5, 5, 462, 472);
        this.scrollpane.setOpaque(false);
        this.scrollpane.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.scrollpane.setBackground(new Color(29, 131, 72));
        this.PVuelos.add(this.scrollpane);

        this.PBoleto = new JPanel();
        this.PBoleto.setBounds(484, 304, 585, 181);
        this.PBoleto.setBorder(this.compound);
        this.PBoleto.setBackground(new Color(204, 229, 204));
        this.PBoleto.setLayout(null);
        this.PResultado.add(this.PBoleto);

        this.LBoleto = new JLabel("VUELO 1 : $5");
        this.LBoleto.setBounds(50, 10, 485, 81);
        this.LBoleto.setFont(new Font("Times New Roman", Font.BOLD, 32));
        this.LBoleto.setForeground(new Color(46, 110, 50));
        this.PBoleto.add(this.LBoleto);
        
        this.LBComprar = new JLabel("COMPRAR");
        this.LBComprar.setOpaque(true);
        this.LBComprar.setHorizontalAlignment(SwingConstants.CENTER);
        this.LBComprar.setBounds(370, 105, 200, 60);
        this.LBComprar.setFont(new Font("Times New Roman", Font.BOLD, 32));
        this.LBComprar.setBackground(new Color(46, 110, 50));
        this.LBComprar.setForeground(new Color(204, 229, 204));
        this.LBComprar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.LBComprar.addMouseListener(this);
        this.PBoleto.add(this.LBComprar);
        
        this.rctngl1 = new Rectangle(this.PVuelos.getBounds());
        this.rctngl2 = new Rectangle(this.PBoleto.getBounds());

        this.LTitulo = new JLabel("VUELOS INTERNACIONALES");
        this.LTitulo.setBounds(0, 0, 1080, 50);
        this.LTitulo.setFont(new Font("Times New Roman", Font.BOLD, 32));
        this.LTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        this.LTitulo.setForeground(new Color(46, 110, 50));
        this.PMenu.add(this.LTitulo);

        this.LOrigen = new JLabel("ORIGEN");
        this.LOrigen.setBounds(340, 40, 120, 50);
        this.LOrigen.setFont(new Font("Times New Roman", Font.BOLD, 22));
        this.LOrigen.setHorizontalAlignment(SwingConstants.CENTER);
        this.LOrigen.setForeground(Color.BLACK);
        this.PMenu.add(this.LOrigen);

        this.LDestino = new JLabel("DESTINO");
        this.LDestino.setFont(new Font("Times New Roman", Font.BOLD, 22));
        this.LDestino.setHorizontalAlignment(SwingConstants.CENTER);
        this.LDestino.setBounds(340, 40, 670, 50);
        this.LDestino.setForeground(Color.BLACK);
        this.PMenu.add(this.LDestino);

        this.LBOrigen = new JLabel();
        this.LBOrigen.setHorizontalAlignment(SwingConstants.CENTER);
        this.LBOrigen.setBounds(350, 90, 100, 50);
        this.LBOrigen.addMouseListener(this);
        this.LBOrigen.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.PMenu.add(this.LBOrigen);

        this.LBDestino = new JLabel();
        this.LBDestino.setBounds(625, 90, 100, 50);
        this.LBDestino.setHorizontalAlignment(SwingConstants.CENTER);
        this.LBDestino.addMouseListener(this);
        this.LBDestino.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.PMenu.add(this.LBDestino);

        this.LBuscar = new JLabel();
        this.LBuscar.setBounds(490, 90, 100, 64);
        this.LBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        this.LBuscar.setIcon(new ImageIcon("src/Iconos/airplane-shape.png"));
        this.LBuscar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.LBuscar.setToolTipText("Buscar vuelo");
        this.LBuscar.addMouseListener(this);
        this.PMenu.add(this.LBuscar);
        
        
        this.CBOrigen = new JComboBox();
        this.CBOrigen.setBounds(350, 150, 100, 20);
        this.CBOrigen.addItemListener(this);
        

        this.CBDestino = new JComboBox();
        this.CBDestino.setBounds(625, 150, 100, 20);
        this.CBDestino.addItemListener(this);
        
        for (String pais : this.admin.Paises) {
            this.CBDestino.addItem(pais);
            this.CBOrigen.addItem(pais);
        }
        
        this.PMenu.add(this.CBOrigen);
        this.PMenu.add(this.CBDestino);
        
        this.add(this.PMenu);
        this.add(this.PResultado);
        this.setVisible(true);
        
    }
    
    private void cambiarBandera(JLabel Bandera, int i) {
        Bandera.setIcon(this.admin.Banderas[i]);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        if (ie.getSource() == this.CBOrigen) {
            //****************************************
            seleccion1 = CBOrigen.getSelectedIndex();
            //****************************************
            this.cambiarBandera(this.LBOrigen, 
                    this.CBOrigen.getSelectedIndex());
        }
        if (ie.getSource() == this.CBDestino) {
            //****************************************
            seleccion2 = CBDestino.getSelectedIndex();
            //****************************************
            this.cambiarBandera(this.LBDestino, 
                    this.CBDestino.getSelectedIndex());
        }
    }

    @Override
    public void mouseClicked(MouseEvent ml) {
        if (ml.getSource() == this.LBuscar) {
            //BUSCAR VUELOS
            this.admin.buscarVuelos();
            //*******************************************************
            Model.removeAllElements();
            this.admin.buscarrutas(this.Model,seleccion1,seleccion2);
            //*******************************************************
        }
        if (ml.getSource() == this.LBComprar){
            //REINICIAR TODO
            this.admin.mapa.setBounds(0, 0, this.admin.mapa.x, this.admin.mapa.y);
            this.Model.removeAllElements();
        }
        if (ml.getSource() == this.Lista){
            //*********************************************************************
            this.LBoleto.setText("VUELO " + (Lista.getSelectedIndex()+1) 
                    + " : $" + admin.obtenercosto(Lista.getSelectedIndex(),Model));
            //*********************************************************************
            this.admin.selecVuelo(this.Lista.getSelectedValue()+"");

        }
        if(ml.getSource() == this.LBDestino){
            int i = this.Lista.getSelectedIndex();
                this.Model.remove(i);
            if(this.CBDestino.getSelectedItem().toString().contains("(NO DISPONIBLE)")){
                this.Model.add(i, this.admin.Paises[i]);
            }else{
                this.Model.add(i, this.admin.Paises[i] + "(NO DISPONIBLE)");
            }
        }
        if(ml.getSource() == this.LBOrigen){
            int i = this.Lista.getSelectedIndex();
                this.Model.remove(i);
            if(this.CBOrigen.getSelectedItem().toString().contains("(NO DISPONIBLE)")){
                this.Model.add(i, this.admin.Paises[i]);
            }else{
                this.Model.add(i, this.admin.Paises[i] + "(NO DISPONIBLE)");
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
//        if(me.getSource() == this.LBOrigen){
//            if(this.CBOrigen.getSelectedItem().toString().contains("(NO DISPONIBLE)")){
//                this.LBOrigen.setToolTipText("HABILITAR");
//            }else{
//                this.LBOrigen.setToolTipText("DESHABILITAR");
//            }
//        }
//        if(me.getSource() == this.LBDestino){
//            if(this.CBDestino.getSelectedItem().toString().contains("(NO DISPONIBLE)")){
//                this.LBDestino.setToolTipText("HABILITAR");
//            }else{
//                this.LBDestino.setToolTipText("DESHABILITAR");
//            }
//        }
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        if(lse.getSource() == this.Lista){
            //PARA DIBUJAR LAS LINEAS DE LA RUTA SEGUN SEA EL VUELO ELEGIDO
            this.LBoleto.setText("VUELO " + (Lista.getSelectedIndex()+1) 
                    + " : $" + admin.obtenercosto(Lista.getSelectedIndex(),Model));
            this.admin.selecVuelo(this.Lista.getSelectedValue()+"");
        }
    }

}
