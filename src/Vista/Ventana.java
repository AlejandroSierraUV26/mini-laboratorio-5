package Vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventana extends JFrame {
    public JPanel panelPrincipal, panelPrincipal2, panelPrincipal3, panelEspacioDerecha, panelEspacioIzquierda, panelEspacioAbajo, panelInsertar, panelInsertarEtiquetas, panelActualizar, panelActualizarDatos, panelActualizarOpciones, panelEliminar, panelBuscar, panelBuscarSuperior, panelBuscarInferior, panelBuscarInferiorCentro, panelListar, panelComprar, panelListarComprar;
    ImageIcon imagenIcono;
    public JLabel logoRinconDulce, etiquetaActualizar, etiquetaActualizarDatos, etiquetaRelleno1, etiquetaRelleno2, etiquetaEliminar, etiquetaBuscar, etiquetaBuscarNombre, etiquetaBuscarCategoria, etiquetaBuscarCantidad, etiquetaBuscarPrecio, etiquetaComprar;
    public JButton[] botonesPanelPrincipal = new JButton[7];
    JLabel[] etiquetasPanelInsertar = new JLabel[4];
    String opcionesPanelPrincipal[] = {"Insertar Traje", "Actualizar Traje", "Eliminar Traje", "Buscar Traje", "Listar Traje", "Comprar Traje","Listar Comprados"};
    String opcionesPanelEtiquetas[] = {"Nombre", "Material","Precio", "Pais"};
    public JButton botonEnviarInsertar, botonEnviarActualizar, botonEnviarActualizarOpciones, botonEliminar, botonBuscar, botonRegresar, botonRegresarListar, botonComprar, botonRegresarListarComprar;
    public JTextArea areaTextoNombre, areaTextoPrecio, areaTextoCantidad, areaTextoActualizar, areaTextoActualizarNombre, areaTextoActualizarPrecio, areaTextoActualizarCantidad, areaTextoEliminar, areaTextoBuscar, areaTextoListar, areaTextoComprar, areaTextoListarComprar;
    String[] opciones = {"Lana","Lino","Algodón"};
    public JComboBox<String> categorias;
    public String contenido, contenido2, contenido3, contenido4, contenido5, contenido6, contenido7, contenido8, contenido9, contenido10, categoriaSeleccionada;
    JScrollPane scroll, scroll2, scroll3, scroll4, scroll5, scroll6, scroll7, scroll8;
    public JCheckBox checkBox1, checkBox2, checkBox3;
    public Ventana(){
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarComponentes(){
        panelPrincipal = new JPanel();
        this.getContentPane().add(panelPrincipal);
        imagenIcono = new ImageIcon(getClass().getResource("/imagen/Moda_Estilo.jpg"));
        logoRinconDulce = new JLabel(imagenIcono);
        panelPrincipal.setLayout(new GridLayout(2,1));
        panelPrincipal.add(logoRinconDulce);  
        panelPrincipal.setBackground(Color.decode("#171717"));
        panelPrincipal2 = new JPanel();
        panelPrincipal2.setLayout(new BorderLayout());
        panelPrincipal3 = new JPanel();
        panelPrincipal3.setLayout(new GridLayout(7,1));
        
        for(int i = 0; i<botonesPanelPrincipal.length; i++){
            botonesPanelPrincipal[i] = new JButton();
            botonesPanelPrincipal[i].setFont(new Font("Arial",Font.BOLD,15));
            botonesPanelPrincipal[i].setText(opcionesPanelPrincipal[i]);
            botonesPanelPrincipal[i].setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),5));
            
            panelPrincipal3.add(botonesPanelPrincipal[i]);
        }

        panelEspacioDerecha = new JPanel();
        panelEspacioIzquierda = new JPanel();
        panelEspacioAbajo = new JPanel();

        panelEspacioDerecha.setPreferredSize(new Dimension(160, 0));
        panelEspacioIzquierda.setPreferredSize(new Dimension(160, 0));
        panelEspacioAbajo.setPreferredSize(new Dimension(0, 20));

        panelEspacioDerecha.setBackground(Color.decode("#171717"));
        panelEspacioIzquierda.setBackground(Color.decode("#171717"));
        panelEspacioAbajo.setBackground(Color.decode("#171717"));

        panelPrincipal2.add(panelEspacioDerecha, BorderLayout.EAST);
        panelPrincipal2.add(panelEspacioIzquierda, BorderLayout.WEST);
        panelPrincipal2.add(panelEspacioAbajo, BorderLayout.SOUTH);
        
        panelPrincipal2.add(panelPrincipal3, BorderLayout.CENTER);
        panelPrincipal.add(panelPrincipal2);

        panelInsertar = new JPanel(new BorderLayout());
        panelInsertarEtiquetas = new JPanel(new GridLayout(4,2));
        panelInsertarEtiquetas.setBackground(Color.decode("#171717"));
        
        areaTextoNombre = new JTextArea();
        areaTextoPrecio = new JTextArea();
        areaTextoCantidad = new JTextArea();

        areaTextoNombre.setFont(new Font("Arial", Font.BOLD, 25));
        areaTextoPrecio.setFont(new Font("Arial", Font.BOLD, 25));
        areaTextoCantidad.setFont(new Font("Arial", Font.BOLD, 25));

        scroll = new JScrollPane(areaTextoNombre, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll2 = new JScrollPane(areaTextoPrecio, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll3 = new JScrollPane(areaTextoCantidad, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        scroll.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),30));
        scroll2.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),30));
        scroll3.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),30));

        categorias = new JComboBox<>(opciones);
        categorias.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),30));
        categorias.setFont(new Font("Arial", Font.BOLD,25));
        for(int i = 0; i<etiquetasPanelInsertar.length; i++){
            etiquetasPanelInsertar[i] = new JLabel();
            etiquetasPanelInsertar[i].setText(opcionesPanelEtiquetas[i]);
            etiquetasPanelInsertar[i].setFont(new Font("Arial", Font.BOLD, 40));
            etiquetasPanelInsertar[i].setHorizontalAlignment(SwingConstants.CENTER);
            etiquetasPanelInsertar[i].setForeground(Color.WHITE);
            if(i==0){
                panelInsertarEtiquetas.add(etiquetasPanelInsertar[0]);
                panelInsertarEtiquetas.add(scroll);
            }
            else if(i == 1){
                panelInsertarEtiquetas.add(etiquetasPanelInsertar[1]);
                panelInsertarEtiquetas.add(categorias);
            }
            else if(i == 2){
                panelInsertarEtiquetas.add(etiquetasPanelInsertar[2]);
                panelInsertarEtiquetas.add(scroll2);
            }
            else{
                panelInsertarEtiquetas.add(etiquetasPanelInsertar[3]);
                panelInsertarEtiquetas.add(scroll3);
            }
        }        
        botonEnviarInsertar = new JButton("Enviar");
        
        panelInsertar.add(panelInsertarEtiquetas, BorderLayout.CENTER);
        panelInsertar.add(botonEnviarInsertar, BorderLayout.SOUTH);

        panelActualizar = new JPanel(new GridLayout(3,1));
        panelActualizarDatos = new JPanel(new GridLayout(2,1));
        panelActualizarOpciones = new JPanel(new GridLayout(3,3));


        panelActualizar.setBackground(Color.decode("#171717"));
        panelActualizarDatos.setBackground(Color.decode("#171717"));
        panelActualizarOpciones.setBackground(Color.decode("#171717"));

        etiquetaActualizar = new JLabel("Ingrese el codigo");
        etiquetaActualizar.setFont(new Font("Arial", Font.BOLD, 40));
        etiquetaActualizar.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaActualizar.setForeground(Color.WHITE);

        areaTextoActualizar = new JTextArea();
        areaTextoActualizar.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),45));
        areaTextoActualizar.setFont(new Font("Arial", Font.BOLD, 50));
        areaTextoActualizar.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                if(areaTextoActualizar.getText().length() >= 6){
                    e.consume();
                }
            }
        });

        botonEnviarActualizar = new JButton("Enviar");
        botonEnviarActualizar.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),50));
        botonEnviarActualizar.setFont(new Font("Arial", Font.BOLD, 30));
        panelActualizar.add(etiquetaActualizar);
        panelActualizar.add(areaTextoActualizar);
        panelActualizar.add(botonEnviarActualizar);

        etiquetaActualizarDatos = new JLabel("CODIGO");
        etiquetaActualizarDatos.setFont(new Font("Arial", Font.BOLD, 40));
        etiquetaActualizarDatos.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaActualizarDatos.setForeground(Color.WHITE);

        checkBox1 = new JCheckBox("Nombre");
        checkBox2 = new JCheckBox("Pais");
        checkBox3 = new JCheckBox("Precio");

        checkBox1.setBackground(Color.decode("#171717"));
        checkBox2.setBackground(Color.decode("#171717"));
        checkBox3.setBackground(Color.decode("#171717"));

        checkBox1.setFont(new Font("Arial", Font.BOLD, 20));
        checkBox2.setFont(new Font("Arial", Font.BOLD, 20));
        checkBox3.setFont(new Font("Arial", Font.BOLD, 20));

        checkBox1.setForeground(Color.WHITE);
        checkBox2.setForeground(Color.WHITE);
        checkBox3.setForeground(Color.WHITE);

        checkBox1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    scroll4.setVisible(true);
                }
                else{
                    scroll4.setVisible(false);
                }
            }
        });
        checkBox2.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    scroll5.setVisible(true);
                }
                else{
                    scroll5.setVisible(false);
                }
            }
        });
        checkBox3.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    scroll6.setVisible(true);
                }
                else{
                    scroll6.setVisible(false);
                }
            }
        });

        etiquetaRelleno1 = new JLabel();
        etiquetaRelleno1.setBackground(Color.decode("#171717"));
        etiquetaRelleno2 = new JLabel();
        etiquetaRelleno2.setBackground(Color.decode("#171717"));

        areaTextoActualizarNombre = new JTextArea();
        areaTextoActualizarPrecio = new JTextArea();
        areaTextoActualizarCantidad = new JTextArea();

        areaTextoActualizarNombre.setFont(new Font("Arial", Font.BOLD, 25));
        areaTextoActualizarPrecio.setFont(new Font("Arial", Font.BOLD, 25));
        areaTextoActualizarCantidad.setFont(new Font("Arial", Font.BOLD, 25));

        scroll4 = new JScrollPane(areaTextoActualizarNombre, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll5 = new JScrollPane(areaTextoActualizarPrecio, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll6 = new JScrollPane(areaTextoActualizarCantidad, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        scroll4.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),15));
        scroll5.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),15));
        scroll6.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),15));

        botonEnviarActualizarOpciones = new JButton("Enviar");
        botonEnviarActualizarOpciones.setFont(new Font("Arial", Font.BOLD, 20));
        botonEnviarActualizarOpciones.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),15));

        scroll4.setVisible(false);
        scroll5.setVisible(false);
        scroll6.setVisible(false);

        panelActualizarOpciones.add(checkBox1);
        panelActualizarOpciones.add(scroll4);
        panelActualizarOpciones.add(etiquetaRelleno1);
        panelActualizarOpciones.add(checkBox2);
        panelActualizarOpciones.add(scroll5);
        panelActualizarOpciones.add(etiquetaRelleno2);
        panelActualizarOpciones.add(checkBox3);
        panelActualizarOpciones.add(scroll6);
        panelActualizarOpciones.add(botonEnviarActualizarOpciones);

        panelActualizarDatos.add(etiquetaActualizarDatos);
        panelActualizarDatos.add(panelActualizarOpciones);

        panelEliminar = new JPanel(new BorderLayout());
        panelEliminar.setBackground(Color.decode("#171717"));

        etiquetaEliminar = new JLabel("Ingrese el codigo");
        etiquetaEliminar.setFont(new Font("Arial", Font.BOLD, 40));
        etiquetaEliminar.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaEliminar.setForeground(Color.WHITE);

        areaTextoEliminar = new JTextArea();
        areaTextoEliminar.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),45));
        areaTextoEliminar.setFont(new Font("Arial", Font.BOLD, 50));
        areaTextoEliminar.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                if(areaTextoEliminar.getText().length() >= 6){
                    e.consume();
                }
            }
        });

        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),110));
        botonEliminar.setFont(new Font("Arial", Font.BOLD, 30));

        panelEliminar.add(etiquetaEliminar, BorderLayout.NORTH);
        panelEliminar.add(areaTextoEliminar, BorderLayout.CENTER);
        panelEliminar.add(botonEliminar, BorderLayout.SOUTH);

        panelBuscar = new JPanel(new GridLayout(2,1));
        panelBuscarSuperior = new JPanel(new GridLayout(3,1));
        panelBuscarInferior = new JPanel(new GridLayout(5,1));
        

        panelBuscarSuperior.setBackground(Color.decode("#171717"));

        etiquetaBuscar = new JLabel("Ingrese el codigo");
        etiquetaBuscar.setFont(new Font("Arial", Font.BOLD, 40));
        etiquetaBuscar.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaBuscar.setForeground(Color.WHITE);

        areaTextoBuscar = new JTextArea();
        areaTextoBuscar.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),5));
        areaTextoBuscar.setFont(new Font("Arial", Font.BOLD, 50));
        areaTextoBuscar.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                if(areaTextoBuscar.getText().length() >= 6){
                    e.consume();
                }
            }
        });

        botonBuscar = new JButton("Buscar");
        botonBuscar.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),5));
        botonBuscar.setFont(new Font("Arial", Font.BOLD, 30));

        panelBuscarSuperior.add(etiquetaBuscar);
        panelBuscarSuperior.add(areaTextoBuscar);
        panelBuscarSuperior.add(botonBuscar);

        etiquetaBuscarNombre = new JLabel();
        etiquetaBuscarNombre.setFont(new Font("Arial", Font.BOLD, 20));
        etiquetaBuscarNombre.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaBuscarNombre.setForeground(Color.WHITE);

        etiquetaBuscarCategoria = new JLabel();
        etiquetaBuscarCategoria.setFont(new Font("Arial", Font.BOLD, 20));
        etiquetaBuscarCategoria.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaBuscarCategoria.setForeground(Color.WHITE);

        etiquetaBuscarCantidad = new JLabel();
        etiquetaBuscarCantidad.setFont(new Font("Arial", Font.BOLD, 20));
        etiquetaBuscarCantidad.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaBuscarCantidad.setForeground(Color.WHITE);

        etiquetaBuscarPrecio = new JLabel();
        etiquetaBuscarPrecio.setFont(new Font("Arial", Font.BOLD, 20));
        etiquetaBuscarPrecio.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaBuscarPrecio.setForeground(Color.WHITE);

        botonRegresar = new JButton("Regresar");

        panelBuscarInferior.setBackground(Color.decode("#171717"));

        panelBuscarInferior.add(etiquetaBuscarNombre);
        panelBuscarInferior.add(etiquetaBuscarCategoria);
        panelBuscarInferior.add(etiquetaBuscarCantidad);
        panelBuscarInferior.add(etiquetaBuscarPrecio);
        panelBuscarInferior.add(botonRegresar);

        panelBuscar.add(panelBuscarSuperior);
        panelBuscar.add(panelBuscarInferior);

        panelListar = new JPanel(new BorderLayout());

        areaTextoListar = new JTextArea();
        areaTextoListar.setEditable(false);
        areaTextoListar.setBackground(Color.decode("#171717"));
        areaTextoListar.setFont(new Font("Arial", Font.BOLD, 20));
        areaTextoListar.setForeground(Color.WHITE);

        scroll7 = new JScrollPane();
        scroll7 = new JScrollPane(areaTextoListar, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        botonRegresarListar = new JButton("Regresar");

        panelListar.add(scroll7, BorderLayout.CENTER);
        panelListar.add(botonRegresarListar, BorderLayout.SOUTH);

        panelComprar = new JPanel(new BorderLayout());
        panelComprar.setBackground(Color.decode("#171717"));

        etiquetaComprar = new JLabel("Ingrese el codigo");
        etiquetaComprar.setFont(new Font("Arial", Font.BOLD, 40));
        etiquetaComprar.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaComprar.setForeground(Color.WHITE);

        areaTextoComprar = new JTextArea();
        areaTextoComprar.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),45));
        areaTextoComprar.setFont(new Font("Arial", Font.BOLD, 50));
        areaTextoComprar.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e){
                if(areaTextoComprar.getText().length() >= 6){
                    e.consume();
                }
            }
        });

        botonComprar = new JButton("Comprar");
        botonComprar.setBorder(BorderFactory.createLineBorder(Color.decode("#171717"),110));
        botonComprar.setFont(new Font("Arial", Font.BOLD, 30));

        panelComprar.add(etiquetaComprar, BorderLayout.NORTH);
        panelComprar.add(areaTextoComprar, BorderLayout.CENTER);
        panelComprar.add(botonComprar, BorderLayout.SOUTH);
        panelListarComprar = new JPanel(new BorderLayout());

        areaTextoListarComprar = new JTextArea();
        areaTextoListarComprar.setEditable(false);
        areaTextoListarComprar.setBackground(Color.decode("#171717"));
        areaTextoListarComprar.setFont(new Font("Arial", Font.BOLD, 20));
        areaTextoListarComprar.setForeground(Color.WHITE);

        scroll8 = new JScrollPane();
        scroll8 = new JScrollPane(areaTextoListarComprar, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        botonRegresarListarComprar = new JButton("Regresar");

        panelListarComprar.add(scroll8, BorderLayout.CENTER);
        panelListarComprar.add(botonRegresarListarComprar, BorderLayout.SOUTH);
    }
}