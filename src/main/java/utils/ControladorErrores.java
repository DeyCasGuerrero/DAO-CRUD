package utils;

import utils.Evaluar;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

public class ControladorErrores implements Evaluar{

    private JRootPane rootPane;

    public boolean EvaluarCampos( String nombre, String correo, String telefono) {
        if ((nombre == null || nombre.isEmpty()) || (correo == null || correo.isEmpty()) || (telefono == null || telefono.isEmpty())) {
            JOptionPane.showMessageDialog(rootPane, "HAY CAMPOS QUE NECESITA LLENAR");
            return false;
        } else {
            
            return true;
        }

    }

    @Override
    public boolean evaluar(boolean opcion) {
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Deseas seleccionar y eliminar esta fila?", "Confirmar selección", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }

}
