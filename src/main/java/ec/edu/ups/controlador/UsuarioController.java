package ec.edu.ups.controlador;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.login.LoginView;
import ec.edu.ups.vista.login.RegistroView;
import ec.edu.ups.vista.usuario.UsuarioCrearView;
import ec.edu.ups.vista.usuario.UsuarioListarView;
import ec.edu.ups.vista.usuario.UsuarioActualizarView;
import ec.edu.ups.vista.usuario.UsuarioEliminarView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.List;

public class UsuarioController {

    private Usuario usuario;
    private final UsuarioDAO usuarioDAO;
    private final LoginView loginView;
    private final UsuarioCrearView usuarioCrearView;
    private final UsuarioListarView usuarioListarView;
    private final UsuarioActualizarView usuarioActualizarView;
    private final UsuarioEliminarView usuarioEliminarView;
    private final RegistroView registroView;

    public UsuarioController(UsuarioDAO usuarioDAO, LoginView loginView,
                             UsuarioCrearView usuarioCrearView, UsuarioListarView usuarioListarView,
                             UsuarioActualizarView usuarioActualizarView, UsuarioEliminarView usuarioEliminarView,
                             RegistroView registroView) {
        this.usuarioDAO = usuarioDAO;
        this.loginView = loginView;
        this.usuarioCrearView = usuarioCrearView;
        this.usuarioListarView = usuarioListarView;
        this.usuarioActualizarView = usuarioActualizarView;
        this.usuarioEliminarView = usuarioEliminarView;
        this.registroView = registroView;
        this.usuario = null;
        configurarEventosEnVistas();
        configurarEventosUsuarios();
        configurarEventosEliminar();
    }

    private void configurarEventosEnVistas() {
        loginView.getBtnIniciarSesion().addActionListener(e -> autenticar());

        loginView.getBtnRegistrarse().addActionListener(e -> {
            loginView.setVisible(false);
            registroView.setVisible(true);
        });

        registroView.getBtnRegistrarse().addActionListener(e -> {
            crearUsuario();
            registroView.setVisible(false);
            loginView.setVisible(true);
        });
    }

    private void configurarEventosUsuarios() {
        usuarioCrearView.getBtnRegistrar().addActionListener(e -> {
            usuarioCrearView.crearUsuario();
            usuarioCrearView.limpiarCampos();
        });

        usuarioListarView.getBtnListar().addActionListener(e ->
                usuarioListarView.listarUsuarios(usuarioDAO.listarTodos())
        );

        usuarioListarView.getBtnBuscar().addActionListener(e -> {
            String username = usuarioListarView.getTxtUser().getText();
            if (username.isEmpty()) {
                usuarioListarView.mostrarMensaje("Ingrese un nombre de usuario para buscar.");
            } else {
                usuarioListarView.listarUsuariosPorUsername(usuarioDAO.listarTodos(), username);
            }
        });

        usuarioActualizarView.getBtnBuscar().addActionListener(e -> {
            if (usuarioActualizarView.getTxtUsernameBusqueda().getText().isEmpty()) {
                usuarioActualizarView.mostrarMensaje("Ingrese un nombre de usuario para buscar.");
            } else {
                usuarioActualizarView.buscarUsuario();
            }
        });

        usuarioActualizarView.getBtnEditar().addActionListener(e -> {
            if (usuarioActualizarView.getTxtUsernameBusqueda().getText().isEmpty()) {
                usuarioActualizarView.mostrarMensaje("Ingrese un nombre de usuario para buscar.");
            } else {
                usuarioActualizarView.editarValoresActualizarTrue();
            }
        });

        usuarioActualizarView.getBtnGuardar().addActionListener(e -> {
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
        });
    }

    private void configurarEventosEliminar() {
        usuarioEliminarView.getBtnBuscar().addActionListener(e -> {
            String codigo = usuarioEliminarView.getTxtUsername().getText();
            Usuario usuario = usuarioDAO.buscarPorUsername(codigo);
            if (usuario != null) {
                usuarioEliminarView.cargarUsuario(List.of(usuario));
            }
        });

        usuarioEliminarView.getBtnGuardar().addActionListener(e -> {
            String codigo = usuarioEliminarView.getTxtUsername().getText();
            Usuario usuario = usuarioDAO.buscarPorUsername(codigo);
            boolean confirmacion = usuarioEliminarView.confirmarEliminacion();

            if (confirmacion && usuario != null) {
                usuarioDAO.eliminar(codigo);
                usuarioEliminarView.mostrarMensaje("Usuario eliminado correctamente.");
                usuarioEliminarView.limpiarCampos();
            } else {
                usuarioEliminarView.mostrarMensaje("El usuario no existe o la eliminación fue cancelada.");
            }
        });
    }

    private void autenticar() {
        String username = loginView.getTxtUsername().getText();
        String contrasenia = loginView.getTxtContrasenia().getText();

        usuario = usuarioDAO.autenticar(username, contrasenia);
        if (usuario == null) {
            loginView.mostrarMensaje("Usuario o contraseña incorrectos.");
        } else {
            loginView.dispose();
        }
    }

    public void crearUsuario() {
        String nombre = registroView.getTxtNombre().getText();
        String apellido = registroView.getTxtApellido().getText();
        String telefono = registroView.getTxtTelefono().getText();
        String correo = registroView.getTxtCorreo().getText();
        String username = registroView.getTxtUsuario().getText();
        String contrasenia = new String(registroView.getTxtContrasenia().getPassword());
        Rol rol = Rol.USUARIO;

        int dia = Integer.parseInt(registroView.getCbxDia().getSelectedItem().toString());
        int mes = Integer.parseInt(registroView.getCbxMes().getSelectedItem().toString()) - 1;
        int anio = Integer.parseInt(registroView.getTxtAño().getText());

        GregorianCalendar fechaCreacion = new GregorianCalendar(anio, mes, dia);

        Usuario usuario = new Usuario(nombre, apellido, telefono, correo, username, contrasenia, rol, fechaCreacion);

        usuarioDAO.crear(usuario);
        System.out.println(usuario);
    }

    public void cerrarSesion() {
        usuario = null;
        loginView.setVisible(true);
    }

    public Usuario getUsuarioAutenticado() {
        return usuario;
    }
}
