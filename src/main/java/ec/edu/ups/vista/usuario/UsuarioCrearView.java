package ec.edu.ups.vista.usuario;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;

public class UsuarioCrearView extends JInternalFrame {
    private JPanel panelPrincipal;
    private JTextField TxtUsername;
    private JPasswordField TxtPassword;
    private JComboBox CbxRol;
    private JButton BtnCancelar;
    private JButton BtnRegistrar;
    private JLabel LblTitulo;
    private JLabel LblUsuario;
    private JLabel LblContraseña;
    private JLabel LblRol;
    private UsuarioDAO usuarioDAO;
    MensajeInternacionalizacionHandler mI;

    public UsuarioCrearView (UsuarioDAO usuarioDAO, MensajeInternacionalizacionHandler mI) {
        setContentPane(panelPrincipal);
        setTitle("Crear Usuario");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setSize(500, 400);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        this.usuarioDAO = usuarioDAO;
        this.mI = mI;
        cargarRoles();
        cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
    }

    public JTextField getTxtUsername() {
        return TxtUsername;
    }

    public void setTxtUsername(JTextField txtUsername) {
        TxtUsername = txtUsername;
    }

    public JPasswordField getTxtPassword() {
        return TxtPassword;
    }

    public void setTxtPassword(JPasswordField txtPassword) {
        TxtPassword = txtPassword;
    }

    public JComboBox getCbxRol() {
        return CbxRol;
    }

    public void setCbxRol(JComboBox cbxRol) {
        CbxRol = cbxRol;
    }

    public JButton getBtnCancelar() {
        return BtnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        BtnCancelar = btnCancelar;
    }

    public JButton getBtnRegistrar() {
        return BtnRegistrar;
    }

    public void setBtnRegistrar(JButton btnRegistrar) {
        BtnRegistrar = btnRegistrar;
    }

    public JLabel getLblTitulo() {
        return LblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        LblTitulo = lblTitulo;
    }

    public JLabel getLblUsuario() {
        return LblUsuario;
    }

    public void setLblUsuario(JLabel lblUsuario) {
        LblUsuario = lblUsuario;
    }

    public JLabel getLblContraseña() {
        return LblContraseña;
    }

    public void setLblContraseña(JLabel lblContraseña) {
        LblContraseña = lblContraseña;
    }

    public JLabel getLblRol() {
        return LblRol;
    }

    public void setLblRol(JLabel lblRol) {
        LblRol = lblRol;
    }

    public void cambiarIdioma(String lenguaje, String pais) {
        setTitle(mI.get("ventana.usuario.crear.titulo"));

        LblTitulo.setText(mI.get("ventana.usuario.crear.titulo"));
        LblUsuario.setText(mI.get("ventana.usuario.crear.usuario"));
        LblContraseña.setText(mI.get("ventana.usuario.crear.contrasena"));
        LblRol.setText(mI.get("ventana.usuario.crear.rol"));

        BtnCancelar.setText(mI.get("ventana.usuario.crear.cancelar"));
        BtnRegistrar.setText(mI.get("ventana.usuario.crear.registrar"));

        // Actualizar ítems del combo Rol
        CbxRol.removeAllItems();
        CbxRol.addItem(mI.get("rol.administrador"));
        CbxRol.addItem(mI.get("rol.usuario"));
    }

    public void crearUsuario() {
        String username = TxtUsername.getText();
        String password = TxtPassword.getText();
        Rol rol = Rol.valueOf(CbxRol.getSelectedItem().toString());

        if (TxtUsername.getText().isEmpty() || TxtPassword.getText().isEmpty() || rol == null) {
            mostrarMensaje("Todos los campos son obligatorios.");
            return;
        }

        if (usuarioDAO.buscarPorUsername(username) != null) {
            mostrarMensaje("Ese nombre de usuario ya está en uso.");
            return;
        }

        Usuario usuario = new Usuario(username, password, rol);
        usuarioDAO.crear(usuario);

        mostrarMensaje("Usuario creado exitosamente: " + username);
    }

    public void limpiarCampos() {
        TxtUsername.setText("");
        TxtPassword.setText("");
        CbxRol.setSelectedIndex(0);
    }

    public void cargarRoles() {
        CbxRol.removeAllItems();
        CbxRol.addItem("ADMINISTRADOR");
        CbxRol.addItem("USUARIO");
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}