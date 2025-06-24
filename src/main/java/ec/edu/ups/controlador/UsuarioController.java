package ec.edu.ups.controlador;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.LoginView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioController {

    private Usuario usuario;
    private final UsuarioDAO usuarioDAO;
    private final LoginView loginView;

    public UsuarioController(UsuarioDAO usuarioDAO, LoginView loginView) {
        this.usuarioDAO = usuarioDAO;
        this.loginView = loginView;
        this.usuario = null;
        configurarEventosEnVistas();
    }

    private void configurarEventosEnVistas(){
        loginView.getBtnIniciarSesion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autenticar();
            }
     });

        loginView.getBtnRegistrarse().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginView.getTxtUsername().getText().isEmpty() || loginView.getTxtContrasenia().getText().isEmpty()) {
                    loginView.mostrarMensaje("Funcionalidad de registro no implementada.");
                } else {
                    crearUsuario();
                    loginView.mostrarMensaje("Usuario creado exitosamente.");
                }
            }
        });
    }

    private void autenticar(){
        String username = loginView.getTxtUsername().getText();
        String contrasenia = loginView.getTxtContrasenia().getText();

        usuario = usuarioDAO.autenticar(username, contrasenia);
        if(usuario == null){
            loginView.mostrarMensaje("Usuario o contraseña incorrectos.");
        }else{
            loginView.dispose();
        }
    }

    public void crearUsuario() {
        String username = loginView.getTxtUsername().getText();
        String contrasenia = loginView.getTxtContrasenia().getText();
        Usuario usuario = new Usuario(username, contrasenia, Rol.USUARIO);
        usuarioDAO.crear(usuario);
    }

    public Usuario getUsuarioAutenticado(){
        return usuario;
    }
}
