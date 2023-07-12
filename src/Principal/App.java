package Principal;

import Controlador.Control;
import Modelo.Traje;
import Vista.Ventana;

public class App {
    public static void main(String[] args) throws Exception {
        Ventana v1 = new Ventana();
        Traje d1 = new Traje();
        Control c1 = new Control(d1, v1);
        c1.iniciarVista();
    }
}
