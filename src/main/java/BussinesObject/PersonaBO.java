package BussinesObject;

import DataAccessObject.PersonaDAO;
import Model.Persona;
import java.util.List;
import utils.ControladorErrores;

public class PersonaBO {

    private final PersonaDAO personDAO;
    private final ControladorErrores controlError;

    public PersonaBO() {
        this.personDAO = new PersonaDAO();
        this.controlError = new ControladorErrores();
    }

    public void createPerson(String id, String nombre, String correo, String telefono) {

        boolean retorno = controlError.EvaluarCampos(id, nombre, correo, telefono);

        if (retorno) {
            Persona persona = new Persona();
            persona.setNombre(nombre);
            persona.setCorreo(correo);
            persona.setTelefono(telefono);
            personDAO.create(persona);
        } else {
            
        }

    }

    public void updatePerson(Long id, String nombre, String correo, String telefono) {
        Persona persona = new Persona(id, nombre, correo, telefono);

        personDAO.update(persona);
    }

    public void deletePerson(Long id) {
        personDAO.delete(id);
    }

    public Persona getPersonByID(Long id) {
        return personDAO.getByID(id);
    }

    public List<Persona> getAllPersons() {
        return personDAO.getAll();
    }
}
