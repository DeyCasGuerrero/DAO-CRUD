
package utils;

import BussinesObject.PersonaBO;
import Model.Persona;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class Controlador {
    
    private PersonaBO personaBO;

    public Controlador() {
        personaBO= new PersonaBO();
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
    
    
    
}
