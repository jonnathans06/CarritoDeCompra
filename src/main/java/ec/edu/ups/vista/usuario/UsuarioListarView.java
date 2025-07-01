package ec.edu.ups.vista.usuario;

import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class UsuarioListarView extends JInternalFrame {
    private JPanel panelPrincipal;
    private JTextField TxtUser;
    private JButton BtnBuscar;
    private JButton BtnListar;
    private JTable TblUser;
    private JLabel LblTitulo;
    private JLabel LblUsuario;
    private DefaultTableModel modelo;
    MensajeInternacionalizacionHandler mI;

    public UsuarioListarView(MensajeInternacionalizacionHandler mI) {
        setContentPane(panelPrincipal);
        setTitle("Listar Usuarios");
        setSize(500, 500);
        setClosable(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.mI = mI;

        modelo = new DefaultTableModel();
        Object[] columnas = {"Username", "Password", "Rol"};
        modelo.setColumnIdentifiers(columnas);
        TblUser.setModel(modelo);

        cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
    }

    public JTextField getTxtUser() {
        return TxtUser;
    }

    public void setTxtUser(JTextField txtUser) {
        TxtUser = txtUser;
    }

    public JButton getBtnBuscar() {
        return BtnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        BtnBuscar = btnBuscar;
    }

    public JButton getBtnListar() {
        return BtnListar;
    }

    public void setBtnListar(JButton btnListar) {
        BtnListar = btnListar;
    }

    public JTable getTblUser() {
        return TblUser;
    }

    public void setTblUser(JTable tblUser) {
        TblUser = tblUser;
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

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }


    public void cambiarIdioma(String language, String country) {
        setTitle(mI.get("ventana.usuario.listar.titulo"));
        LblTitulo.setText(mI.get("ventana.usuario.listar.titulo"));
        LblUsuario.setText(mI.get("ventana.usuario.listar.usuario"));
        BtnBuscar.setText(mI.get("ventana.usuario.listar.buscar"));
        BtnListar.setText(mI.get("ventana.usuario.listar.listar"));

        String[] columnas = {
                mI.get("ventana.usuario.listar.tabla.username"),
                mI.get("ventana.usuario.listar.tabla.password"),
                mI.get("ventana.usuario.listar.tabla.rol")
        };
        modelo.setColumnIdentifiers(columnas);
    }


    public void listarUsuarios(List<Usuario> listaUsuarios) {
        modelo.setRowCount(0);

        for (Usuario usuario : listaUsuarios) {
            Object[] fila = new Object[3];
            fila[0] = usuario.getUsername();
            fila[1] = usuario.getContrasenia();
            fila[2] = usuario.getRol().toString();
            modelo.addRow(fila);
        }

    }

    public void listarUsuariosPorUsername(List<Usuario> listaUsuarios, String username) {
        modelo.setRowCount(0);

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getUsername().equalsIgnoreCase(username)) {
                Object[] fila = new Object[3];
                fila[0] = usuario.getUsername();
                fila[1] = usuario.getContrasenia();
                fila[2] = usuario.getRol().toString();
                modelo.addRow(fila);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
