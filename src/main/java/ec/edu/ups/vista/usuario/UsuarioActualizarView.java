package ec.edu.ups.vista.usuario;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;

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
    private UsuarioDAO usuarioDAO;

    public UsuarioActualizarView(UsuarioDAO usuarioDAO) {
        setContentPane(panelPrincipal);
        setTitle("Actualizar Usuario");
        setSize(500, 500);
        setClosable(true);
        setResizable(true);
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.usuarioDAO = usuarioDAO;
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

    public void actualizarUsuario() {
        String username = getTxtUsername().getText();
        String password = getTxtPassword().getText();
        Usuario usuario = usuarioDAO.buscarPorUsername(username);
        usuario.setUsername(username);
        usuario.setContrasenia(password);
        mostrarMensaje("Usuario modificado exitosamente");
    }

    public void buscarUsuario() {
        String username = TxtUsernameBusqueda.getText();
        Usuario usuario = usuarioDAO.buscarPorUsername(username);
        if (usuario == null) {
            mostrarMensaje("Usuario no encontrado");
            return;
        }

        TxtUsername.setText(usuario.getUsername());
        TxtPassword.setText(usuario.getContrasenia());
        CbxRol.setSelectedItem(usuario.getRol());
    }

    public void editarValoresActualizarTrue() {
        TxtUsername.setEnabled(true);
        TxtPassword.setEnabled(true);
        CbxRol.setEnabled(true);
    }

    public void editarValoresActualizarFalse() {
        TxtUsername.setEnabled(true);
        TxtPassword.setEnabled(true);
        CbxRol.setEnabled(true);
    }

    public void limpiarCampos() {
        TxtUsername.setText("");
        TxtPassword.setText("");
        CbxRol.setSelectedIndex(0);
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
