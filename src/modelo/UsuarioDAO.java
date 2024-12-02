package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import conexion.DatabaseConnection;

public class UsuarioDAO {
    
    public void insertarUsuario(String correoUsuario, String passwordUsuario, String estadoUsuario, int idrolFK) {

    	String query = "INSERT INTO usuario (correoUsuario, passwordUsuario, estadoUsuario, idrolFK) VALUES (?, ?, ?, ?)";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            statement.setString(1, correoUsuario);
            statement.setString(2, passwordUsuario);
            statement.setString(3, estadoUsuario);
            statement.setInt(4, idrolFK);
            
            statement.executeUpdate();
            System.out.println("Usuario agregado correctamente");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void consultarUsuarios() {
        String query = "SELECT * FROM usuario";
        
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("idusuario") +
                                   ", Correo: " + resultSet.getString("correoUsuario") +
                                   ", Estado: " + resultSet.getString("estadoUsuario") +
                                   ", Rol ID: " + resultSet.getInt("idrolFK"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
