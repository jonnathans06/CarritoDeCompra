package ec.edu.ups.vista.usuario;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class UsuarioEliminarView extends JInternalFrame {
    private JPanel panelPrincipal;
    private JTextField txtUsername;
    private JButton BtnBuscar;
    private JButton BtnGuardar;
    private JTable TblUsuario;
    private JLabel LblTitulo;
    private JLabel LblUsuario;
    private DefaultTableModel modelo;
    private UsuarioDAO usuarioDAO;
    MensajeInternacionalizacionHandler mI;

    public UsuarioEliminarView(MensajeInternacionalizacionHandler mI) {
        setContentPane(panelPrincipal);
        setTitle("Eliminar Usuario");
        setSize(500, 500);
        setResizable(true);
        setClosable(true);
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.mI = mI;

        modelo = new DefaultTableModel();
        Object[] columnas = {"Username", "Password", "Rol"};
        modelo.setColumnIdentifiers(columnas);
        TblUsuario.setModel(modelo);
        cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
    }

    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(JTextField txtUsername) {
        this.txtUsername = txtUsername;
    }

    public JButton getBtnBuscar() {
        return BtnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        BtnBuscar = btnBuscar;
    }

    public JButton getBtnGuardar() {
        return BtnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        BtnGuardar = btnGuardar;
    }

    public JTable getTblUsuario() {
        return TblUsuario;
    }

    public void setTblUsuario(JTable tblUsuario) {
        TblUsuario = tblUsuario;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public JLabel getLblTitulo() {
        return LblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        LblTitulo = lblTitulo;
    }

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public JLabel getLblUsuario() {
        return LblUsuario;
    }

    public void setLblUsuario(JLabel lblUsuario) {
        LblUsuario = lblUsuario;
    }

    public void cargarUsuario(List<Usuario> usuarios) {
        modelo.setRowCount(0);

        for (Usuario usuario : usuarios) {
            Object[] fila = {
                    usuario.getUsername(),
                    usuario.getContrasenia(),
                    usuario.getRol()
            };
            modelo.addRow(fila);
        }
    }

    public boolean confirmarEliminacion() {
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el usuario?",
                "Confirmación", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    public void cambiarIdioma(String language, String country) {
        setTitle(mI.get("ventana.usuario.eliminar.titulo"));

        LblTitulo.setText(mI.get("ventana.usuario.eliminar.titulo"));
        LblUsuario.setText(mI.get("ventana.usuario.eliminar.usuario"));
        BtnBuscar.setText(mI.get("ventana.usuario.eliminar.buscar"));
        BtnGuardar.setText(mI.get("ventana.usuario.eliminar.eliminar"));

        // Actualizar encabezados tabla
        modelo.setColumnIdentifiers(new Object[]{
                mI.get("ventana.usuario.eliminar.tabla.username"),
                mI.get("ventana.usuario.eliminar.tabla.password"),
                mI.get("ventana.usuario.eliminar.tabla.rol")
        });
    }

    public void limpiarCampos() {
        txtUsername.setText("");
        modelo.setRowCount(0);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}