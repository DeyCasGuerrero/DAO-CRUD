package BussinesObject;

import DataAccessObject.PersonaDAO;
import Model.Persona;
import java.util.List;
import utils.Controlador;
import utils.ControladorErrores;

public class PersonaBO {



    private final PersonaDAO personDAO;
    private final ControladorErrores controlError;
    private final Controlador control;

    public PersonaBO() {
        this.personDAO = new PersonaDAO();
        this.controlError = new ControladorErrores();
        this.control = new Controlador(this);
    }

    public void createPerson(String id, String nombre, String correo, String telefono) {

        boolean retorno = controlError.EvaluarCampos(nombre, correo, telefono);

        if (retorno) {
            Persona persona = new Persona();

            if (id != null && !id.trim().isEmpty()) {
                try {
                    Long idLong = Long.parseLong(id);
                    persona.setId(idLong);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("El ID proporcionado no es un número válido", e);
                }
            }

            persona.setNombre(nombre);
            persona.setCorreo(correo);
            persona.setTelefono(telefono);
            personDAO.create(persona);
        } else {
            
        }

    }

    public void updatePerson(Long id, String nombre, String correo, String telefono, boolean option) {   
        boolean retorno = controlError.EvaluarId(id, nombre, correo, telefono);
        
        if(retorno){

            if(option){
                Persona persona = new Persona(id, nombre, correo, telefono);
                personDAO.update(persona);
            }else{
               
            }
        }else{
      
        }

    }

    public void deletePerson(Long id, boolean option) {
        if (option) {
            personDAO.delete(id);
        } else {

        }
    }

    public Persona getPersonByID(Long id) {
        return personDAO.getByID(id);
    }

    public List<Persona> getAllPersons() {
        return personDAO.getAll();
    }
}
