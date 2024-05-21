
package interfaces;

import Model.Persona;
import java.util.List;


public interface IPersonDAO {
    void create(Persona persona);
    void update(Persona persona);
    void delete(Long id);
    Persona getByID(Long id);
    List<Persona> getAll();
}
