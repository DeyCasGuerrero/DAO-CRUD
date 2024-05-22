package Model;

import BussinesObject.PersonaBO;
import View.Window;
import java.util.List;
import javax.swing.JFrame;
import utils.Controlador;


public class main {
    public static void main(String[] args) {
        PersonaBO personBO = new PersonaBO();
        
        Controlador control = new Controlador();
        control.obtenerDatosParaTabla();

        Window vista = new Window();
        vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vista.setVisible(true);
    }
}
