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


//        // Creamos una nueva persona
//        personBO.createPerson("Juan", "juan@example.com", "123456789");

        // Obtenemos todas las personas y las imprimimos
//        System.out.println("Lista de todas las personas:");
//        List<Persona> personas = personBO.getAllPersons();
//        for (Persona persona : personas) {
//            System.out.println(persona.getId() + ": " + persona.getNombre() + " - " + persona.getCorreo() + " - " + persona.getTelefono());
//        }

//        // Actualizamos la información de una persona
//        Persona personaActualizar = personBO.getPersonByID(1L); // Suponiendo que el ID 1 corresponde a una persona existente
//        if (personaActualizar != null) {
//            personaActualizar.setNombre("Pedro");
//            personaActualizar.setCorreo("pedro@example.com");
//            personBO.updatePerson(personaActualizar.getId(), personaActualizar.getNombre(), personaActualizar.getCorreo(), personaActualizar.getTelefono());
//            System.out.println("Información de la persona actualizada con éxito.");
//        } else {
//            System.out.println("No se encontró ninguna persona con el ID proporcionado.");
//        }
//
//        // Eliminamos una persona
//        Long idAEliminar = 2L; // Suponiendo que el ID 2 corresponde a una persona existente
//        personBO.deletePerson(idAEliminar);
//        System.out.println("Persona eliminada con éxito.");
//
//        // Obtenemos nuevamente todas las personas y las imprimimos
//        System.out.println("Lista de todas las personas después de la eliminación:");
//        personas = personBO.getAllPersons();
//        for (Persona persona : personas) {
//            System.out.println(persona.getId() + ": " + persona.getNombre() + " - " + persona.getCorreo() + " - " + persona.getTelefono());
//        }
    }

    

}
