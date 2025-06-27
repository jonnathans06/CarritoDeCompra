package ec.edu.ups.controlador;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.LoginView;
import ec.edu.ups.vista.MenuPrincipalView;
import ec.edu.ups.vista.usuario.UsuarioActualizarView;
import ec.edu.ups.vista.usuario.UsuarioCrearView;
import ec.edu.ups.vista.usuario.UsuarioListarView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsuarioController {

    private Usuario usuario;
    private final UsuarioDAO usuarioDAO;
    private final LoginView loginView;
    private final UsuarioCrearView usuarioCrearView;
    private final UsuarioListarView usuarioListarView;
    private final UsuarioActualizarView usuarioActualizarView;

    public UsuarioController(UsuarioDAO usuarioDAO,LoginView loginView,
                             UsuarioCrearView usuarioCrearView, UsuarioListarView usuarioListarView,
                             UsuarioActualizarView usuarioActualizarView) {
        this.usuarioDAO = usuarioDAO;
        this.loginView = loginView;
        this.usuarioCrearView = usuarioCrearView;
        this.usuarioListarView = usuarioListarView;
        this.usuarioActualizarView = usuarioActualizarView;
        this.usuario = null;
        configurarEventosEnVistas();
        configurarEventosUsuarios();
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

    private void configurarEventosUsuarios() {
        usuarioCrearView.getBtnRegistrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuarioCrearView.crearUsuario();
                usuarioCrearView.limpiarCampos();
                System.out.println(usuarioDAO.listarTodos());
            }
        });

        usuarioListarView.getBtnListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuarioListarView.listarUsuarios(usuarioDAO.listarTodos());
            }
        });

        usuarioListarView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuarioListarView.getTxtUser().getText().isEmpty()) {
                    usuarioListarView.mostrarMensaje("Ingrese un nombre de usuario para buscar.");
                    return;
                }
                String username = usuarioListarView.getTxtUser().getText();
                usuarioListarView.listarUsuariosPorUsername(usuarioDAO.listarTodos(), username);
            }
        });

        usuarioActualizarView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuarioActualizarView.getTxtUsernameBusqueda().getText().isEmpty()) {
                    usuarioActualizarView.mostrarMensaje("Ingrese un nombre de usuario para buscar.");
                } else {
                    usuarioActualizarView.buscarUsuario();
                }

            }
        });

        usuarioActualizarView.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuarioActualizarView.getTxtUsernameBusqueda().getText().isEmpty()) {
                    usuarioActualizarView.mostrarMensaje("Ingrese un nombre de usuario para buscar.");
                } else {
                    usuarioActualizarView.editarValoresActualizarTrue();
                }

            }
        });

        usuarioActualizarView.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username = usuarioActualizarView.getTxtUsername().getText();
                String password = usuarioActualizarView.getTxtPassword().getText();
                Rol rol = Rol.valueOf(usuarioActualizarView.getCbxRol().getSelectedItem().toString());
                boolean confirmar = usuarioActualizarView.confirmarEliminacion();

                if (confirmar) {
                    Usuario usuarioNuevo = new Usuario(username, password, rol);
                    usuarioDAO.actualizar(usuarioNuevo);
                    usuarioActualizarView.limpiarCampos();
                    usuarioActualizarView.editarValoresActualizarFalse();
                    usuarioActualizarView.mostrarMensaje("Usuario actualizado correctamente.");
                } else {
                    usuarioActualizarView.mostrarMensaje("Actualización cancelada.");
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

    public void cerrarSesion() {
        usuario = null;
        loginView.setVisible(true);
    }

    public Usuario getUsuarioAutenticado(){
        return usuario;
    }
}
