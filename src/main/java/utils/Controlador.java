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
import javax.swing.JOptionPane;
import javax.swing.JRootPane;

public class Controlador {

    private PersonaBO personaBO;
    private JRootPane rootPane;

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
        Long id = null;

        int filaSeleccionada = tblMostrar.getSelectedRow();
        System.out.println("FILA " + filaSeleccionada);

        if (filaSeleccionada != -1) {
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
        } else {
            System.out.println("No hay fila seleccionada");
        }

        return id;
    }

    public void llenarDetalles() {
        int filaSeleccionada = tblMostrar.getSelectedRow();

        if (filaSeleccionada != -1) {
            txtID.setText(tblMostrar.getValueAt(filaSeleccionada, 0).toString());
            txtNombre.setText(tblMostrar.getValueAt(filaSeleccionada, 1).toString());
            txtCorreo.setText(tblMostrar.getValueAt(filaSeleccionada, 2).toString());
            txtTelefono.setText(tblMostrar.getValueAt(filaSeleccionada, 3).toString());
        } else {
            txtID.setText("");
            txtNombre.setText("");
            txtCorreo.setText("");
            txtTelefono.setText("");
        }
    }

    public void buscarYMostrarPersonaPorID(String idStr) {
//        JOptionPane.showMessageDialog(rootPane, "Para buscar en la base de datos solo necesitas colocar la ID");
        txtID.setText("");
        txtNombre.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");

        Long id = null;

        if (idStr != null && !idStr.isEmpty()) {
            try {
                id = Long.parseLong(idStr);
                System.out.println(" HDP DSADSADAS "+ id);
                Persona persona = personaBO.getPersonByID(id);
                if (persona != null) {
                    txtID.setText(persona.getId().toString());
                    txtNombre.setText(persona.getNombre());
                    txtCorreo.setText(persona.getCorreo());
                    txtTelefono.setText(persona.getTelefono());
                } else {
                    JOptionPane.showMessageDialog(rootPane, "No se encontró ninguna persona con la ID proporcionada");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir el valor a Long: " + e.getMessage());
                JOptionPane.showMessageDialog(rootPane, "El ID ingresado no es válido. Debe ser un número.");
            }
        } else {
            System.out.println("El campo de ID está vacío");
            JOptionPane.showMessageDialog(rootPane, "Por favor, ingrese un ID válido.");
        }

    }

}
