package utils;

import static View.Window.txtCorreo;
import static View.Window.txtID;
import static View.Window.txtNombre;
import static View.Window.txtTelefono;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

public class ControladorErrores {

    private JRootPane rootPane;

    public boolean EvaluarCampos(String id, String nombre, String correo, String telefono) {
        if ((nombre == null || nombre.isEmpty()) || (correo == null || correo.isEmpty()) || (telefono == null || telefono.isEmpty())) {
            JOptionPane.showMessageDialog(rootPane, "HAY CAMPOS QUE NECESITA LLENAR");
            return false;
        } else {
            try {
                Integer idInt = null;
                if (id != null && !id.isEmpty()) {
                    idInt = Integer.parseInt(id);
                }
                if (idInt == null) {
                    System.out.println("LA ID ES NULA");
                } else {
                    System.out.println("ID: " + idInt);
                }
                return true;
            } catch (NumberFormatException e) {
                System.out.println("ERROR al convertir la ID a entero: " + e.getMessage());
                return false;
            }
        }

    }

}
