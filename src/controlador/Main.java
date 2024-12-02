package controlador;

import modelo.UsuarioDAO;

public class Main {
    public static void main(String[] args) {

    	UsuarioDAO usuarioDAO = new UsuarioDAO();

        usuarioDAO.insertarUsuario("juan.perez@example.com", "12345", "activo", 9001);

        usuarioDAO.consultarUsuarios();
    }
}
