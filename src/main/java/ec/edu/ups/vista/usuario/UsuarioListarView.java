package ec.edu.ups.vista.usuario;

import ec.edu.ups.modelo.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class UsuarioListarView extends JInternalFrame {
    private JPanel panelPrincipal;
    private JTextField TxtUser;
    private JButton BtnBuscar;
    private JButton BtnListar;
    private JTable TblUser;
    private DefaultTableModel modelo;

    public UsuarioListarView() {
        setContentPane(panelPrincipal);
        setTitle("Listar Usuarios");
        setSize(500, 500);
        setClosable(true);
        setResizable(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        modelo = new DefaultTableModel();
        Object[] columnas = {"Username", "Password", "Rol"};
        modelo.setColumnIdentifiers(columnas);
        TblUser.setModel(modelo);
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

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
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
