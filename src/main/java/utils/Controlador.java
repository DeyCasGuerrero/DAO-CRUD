package utils;

import BussinesObject.PersonaBO;
import Model.Persona;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import static View.Window.tblMostrar;
import static View.Window.txtID;
import static View.Window.txtNombre;
import static View.Window.txtCorreo;
import static View.Window.txtTelefono;

public class Controlador {

    private PersonaBO personaBO;
    
    public Controlador(PersonaBO personaBO) {
        this.personaBO = personaBO;
    }

    public Controlador() {
    personaBO = new PersonaBO(); // Aquí se crea una instancia de PersonaBO
}


    public DefaultTableModel obtenerDatosParaTabla() {

        List<Persona> personas = personaBO.getAllPersons();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Correo");
        modelo.addColumn("Teléfono");

        for (Persona persona : personas) {
            Object[] fila = {
                persona.getId(),
                persona.getNombre(),
                persona.getCorreo(),
                persona.getTelefono()
            };
            modelo.addRow(fila);
        }

        return modelo;
    }

    public Long obtenerID() {
        Long id = 0L;

        int filaSeleccionada = tblMostrar.getSelectedRow();
        System.out.println("FILA " + filaSeleccionada);

        if (filaSeleccionada != -1) {
            txtID.setText(tblMostrar.getValueAt(filaSeleccionada, 0).toString());
            txtNombre.setText(tblMostrar.getValueAt(filaSeleccionada, 1).toString());
            txtCorreo.setText(tblMostrar.getValueAt(filaSeleccionada, 2).toString());
            txtTelefono.setText(tblMostrar.getValueAt(filaSeleccionada, 3).toString());

            Object valorID = tblMostrar.getValueAt(filaSeleccionada, 0);
            if (valorID != null) {
                try {
                    id = Long.parseLong(valorID.toString());
                } catch (NumberFormatException e) {
                    System.out.println("Error al convertir el valor a entero: " + e.getMessage());
                }
            } else {
                System.out.println("La celda de ID está vacía");
            }
        }

        return id;
    }
}
