package DataAccessObject;

import DataSource.DatabaseConnection;
import Model.Persona;
import interfaces.IPersonDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO implements IPersonDAO {

    @Override
    public void create(Persona persona) {
        String sql;
        if (persona.getId() == null) {
            sql = "INSERT INTO persona (nombre, correo, telefono) VALUES (?, ?, ?)";
        } else {
            sql = "INSERT INTO persona (id, nombre, correo, telefono) VALUES (?, ?, ?, ?)";
        }

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {

            if (persona.getId() != null) {
                statement.setLong(1, persona.getId());
                statement.setString(2, persona.getNombre());
                statement.setString(3, persona.getCorreo());
                statement.setString(4, persona.getTelefono());
            } else {
                statement.setString(1, persona.getNombre());
                statement.setString(2, persona.getCorreo());
                statement.setString(3, persona.getTelefono());
            }

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear una persona en la base de datos", e);
        }
    }

    @Override
    public void update(Persona persona) {
        String sql = "UPDATE persona SET nombre = ?, correo = ?, telefono = ? WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getCorreo());
            statement.setString(3, persona.getTelefono());
            statement.setLong(4, persona.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar una persona en la base de datos", e);
        }
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM persona WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar una persona de la base de datos", e);
        }
    }

    @Override
    public Persona getByID(Long id) {
        String sql = "SELECT * FROM persona WHERE id = ?";
        Persona persona = null;

        try (Connection connection = DatabaseConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                persona = new Persona(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo"),
                        resultSet.getString("telefono")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener una persona de la base de datos", e);
        }

        return persona;
    }

    @Override
    public List<Persona> getAll() {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM persona";

        try (Connection connection = DatabaseConnection.getConnection(); Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                Persona persona = new Persona(
                        resultSet.getLong("id"),
                        resultSet.getString("nombre"),
                        resultSet.getString("correo"),
                        resultSet.getString("telefono")
                );
                personas.add(persona);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener todas las personas de la base de datos", e);
        }

        return personas;

    }

}
