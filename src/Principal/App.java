package Principal;

import Controlador.Control;
import Modelo.Traje;
import Vista.Ventana;

public class App {
    public static void main(String[] args) throws Exception {
        // ManejadorArchivos manejo = new ManejadorArchivos();
        // Traje modelo = new Traje();
        // manejo.leerArchivo();
        // manejo.escribirArchivo(modelo.lista_trajes.get(0).MostrarDatos());
        Ventana v1 = new Ventana();
        Traje d1 = new Traje();
        Control c1 = new Control(d1, v1);
        c1.iniciarVista();
    }
}
