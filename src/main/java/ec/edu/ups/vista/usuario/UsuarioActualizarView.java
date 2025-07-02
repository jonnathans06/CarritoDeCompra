package ec.edu.ups.vista.usuario;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;

public class UsuarioActualizarView extends JInternalFrame {
    private JTextField TxtUsernameBusqueda;
    private JButton BtnBuscar;
    private JButton BtnEditar;
    private JTextField TxtUsername;
    private JTextField TxtPassword;
    private JComboBox CbxRol;
    private JButton BtnGuardar;
    private JPanel panelPrincipal;
    private JLabel LblTitulo;
    private JLabel LblUsuarioBusqueda;
    private JLabel LblUsuario;
    private JLabel LblContraseña;
    private JLabel LblRol;
    private JTextField TxtNombre;
    private JTextField TxtApellido;
    private JTextField TxtCorreo;
    private JTextField TxtTelefono;
    private UsuarioDAO usuarioDAO;
    private Usuario usuarioSeleccionado;
    MensajeInternacionalizacionHandler mI;

    public UsuarioActualizarView(UsuarioDAO usuarioDAO, MensajeInternacionalizacionHandler mI) {
        setContentPane(panelPrincipal);
        setTitle("Actualizar Usuario");
        setSize(500, 500);
        setClosable(true);
        setResizable(true);
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.usuarioDAO = usuarioDAO;
        this.mI = mI;
        cargarDatosRol();
        cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
    }

    public JButton getBtnBuscar() {
        return BtnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        BtnBuscar = btnBuscar;
    }

    public JButton getBtnEditar() {
        return BtnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        BtnEditar = btnEditar;
    }

    public JTextField getTxtUsernameBusqueda() {
        return TxtUsernameBusqueda;
    }

    public void setTxtUsernameBusqueda(JTextField txtUsernameBusqueda) {
        TxtUsernameBusqueda = txtUsernameBusqueda;
    }

    public JTextField getTxtUsername() {
        return TxtUsername;
    }

    public void setTxtUsername(JTextField txtUsername) {
        TxtUsername = txtUsername;
    }

    public JTextField getTxtPassword() {
        return TxtPassword;
    }

    public void setTxtPassword(JTextField txtPassword) {
        TxtPassword = txtPassword;
    }

    public JComboBox getCbxRol() {
        return CbxRol;
    }

    public void setCbxRol(JComboBox cbxRol) {
        CbxRol = cbxRol;
    }

    public JButton getBtnGuardar() {
        return BtnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        BtnGuardar = btnGuardar;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
        this.usuarioSeleccionado = usuarioSeleccionado;
    }

    public JLabel getLblTitulo() {
        return LblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        LblTitulo = lblTitulo;
    }

    public JLabel getLblUsuarioBusqueda() {
        return LblUsuarioBusqueda;
    }

    public void setLblUsuarioBusqueda(JLabel lblUsuarioBusqueda) {
        LblUsuarioBusqueda = lblUsuarioBusqueda;
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

    public JTextField getTxtNombre() {
        return TxtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        TxtNombre = txtNombre;
    }

    public JTextField getTxtApellido() {
        return TxtApellido;
    }

    public void setTxtApellido(JTextField txtApellido) {
        TxtApellido = txtApellido;
    }

    public JTextField getTxtCorreo() {
        return TxtCorreo;
    }

    public void setTxtCorreo(JTextField txtCorreo) {
        TxtCorreo = txtCorreo;
    }

    public JTextField getTxtTelefono() {
        return TxtTelefono;
    }

    public void setTxtTelefono(JTextField txtTelefono) {
        TxtTelefono = txtTelefono;
    }

    public void cambiarIdioma(String lenguaje, String pais) {
        setTitle(mI.get("ventana.usuario.actualizar.titulo"));

        LblTitulo.setText(mI.get("ventana.usuario.actualizar.titulo"));
        LblUsuarioBusqueda.setText(mI.get("ventana.usuario.actualizar.usuario.busqueda"));
        LblUsuario.setText(mI.get("ventana.usuario.actualizar.usuario"));
        LblContraseña.setText(mI.get("ventana.usuario.actualizar.contrasena"));
        LblRol.setText(mI.get("ventana.usuario.actualizar.rol"));

        BtnBuscar.setText(mI.get("ventana.usuario.actualizar.buscar"));
        BtnEditar.setText(mI.get("ventana.usuario.actualizar.editar"));
        BtnGuardar.setText(mI.get("ventana.usuario.actualizar.guardar"));

        // Actualizar ítems del combo Rol
        CbxRol.removeAllItems();
        CbxRol.addItem(mI.get("rol.administrador"));
        CbxRol.addItem(mI.get("rol.usuario"));
    }


    public void cargarDatosRol () {
        CbxRol.removeAllItems();
        CbxRol.addItem("ADMINISTRADOR");
        CbxRol.addItem("USUARIO");
    }

    public void buscarUsuario() {
        String username = TxtUsernameBusqueda.getText();
        Usuario usuario = usuarioDAO.buscarPorUsername(username);
        if (usuario == null) {
            mostrarMensaje("Usuario no encontrado");
            return;
        }

        TxtNombre.setText(usuario.getNombre());
        TxtApellido.setText(usuario.getApellido());
        TxtCorreo.setText(usuario.getCorreo());
        TxtTelefono.setText(usuario.getTelefono());
        TxtUsername.setText(usuario.getUsername());
        TxtPassword.setText(usuario.getContrasenia());
        CbxRol.setSelectedItem(usuario.getRol());
    }

    public void editarValoresActualizarTrue() {
        TxtNombre.setEnabled(true);
        TxtApellido.setEnabled(true);
        TxtCorreo.setEnabled(true);
        TxtTelefono.setEnabled(true);
        TxtPassword.setEnabled(true);
    }

    public void editarValoresActualizarFalse() {
        TxtNombre.setEnabled(false);
        TxtApellido.setEnabled(false);
        TxtCorreo.setEnabled(false);
        TxtTelefono.setEnabled(false);
        TxtUsername.setEnabled(false);
        TxtPassword.setEnabled(false);
        CbxRol.setEnabled(false);
    }

    public void limpiarCampos() {
        TxtUsername.setText("");
        TxtPassword.setText("");
        TxtUsernameBusqueda.setText("");
    }

    public boolean confirmarEliminacion() {
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de actualizar el usuario?",
                "Confirmación", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
