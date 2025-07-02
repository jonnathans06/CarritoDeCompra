package ec.edu.ups.vista.usuario;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import java.util.GregorianCalendar;

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
    private JTextField TxtNombre;
    private JTextField TxtApellido;
    private JTextField TxtCorreo;
    private JTextField TxtTelefono;
    private JComboBox CbxDia;
    private JComboBox CbxMes;
    private JComboBox CbxAnio;
    private JLabel LblNombre;
    private JLabel LblApellido;
    private JLabel LblCorreo;
    private JLabel LblTelefono;
    private JLabel LblFechaNacimiento;
    private JLabel LblDia;
    private JLabel LblMes;
    private JLabel LblAnio;
    private JLabel LblDatosUsuario;
    private JLabel LblCredencialesUsuariuo;
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
        cargarDias();
        cargarMeses();
        cargarAnios();
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

    public JComboBox getCbxDia() {
        return CbxDia;
    }

    public void setCbxDia(JComboBox cbxDia) {
        CbxDia = cbxDia;
    }

    public JComboBox getCbxMes() {
        return CbxMes;
    }

    public void setCbxMes(JComboBox cbxMes) {
        CbxMes = cbxMes;
    }

    public JComboBox getCbxAnio() {
        return CbxAnio;
    }

    public void setCbxAnio(JComboBox cbxAnio) {
        CbxAnio = cbxAnio;
    }

    public JLabel getLblNombre() {
        return LblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        LblNombre = lblNombre;
    }

    public JLabel getLblApellido() {
        return LblApellido;
    }

    public void setLblApellido(JLabel lblApellido) {
        LblApellido = lblApellido;
    }

    public JLabel getLblCorreo() {
        return LblCorreo;
    }

    public void setLblCorreo(JLabel lblCorreo) {
        LblCorreo = lblCorreo;
    }

    public JLabel getLblTelefono() {
        return LblTelefono;
    }

    public void setLblTelefono(JLabel lblTelefono) {
        LblTelefono = lblTelefono;
    }

    public JLabel getLblFechaNacimiento() {
        return LblFechaNacimiento;
    }

    public void setLblFechaNacimiento(JLabel lblFechaNacimiento) {
        LblFechaNacimiento = lblFechaNacimiento;
    }

    public JLabel getLblDia() {
        return LblDia;
    }

    public void setLblDia(JLabel lblDia) {
        LblDia = lblDia;
    }

    public JLabel getLblMes() {
        return LblMes;
    }

    public void setLblMes(JLabel lblMes) {
        LblMes = lblMes;
    }

    public JLabel getLblAnio() {
        return LblAnio;
    }

    public void setLblAnio(JLabel lblAnio) {
        LblAnio = lblAnio;
    }

    public JLabel getLblDatosUsuario() {
        return LblDatosUsuario;
    }

    public void setLblDatosUsuario(JLabel lblDatosUsuario) {
        LblDatosUsuario = lblDatosUsuario;
    }

    public JLabel getLblCredencialesUsuariuo() {
        return LblCredencialesUsuariuo;
    }

    public void setLblCredencialesUsuariuo(JLabel lblCredencialesUsuariuo) {
        LblCredencialesUsuariuo = lblCredencialesUsuariuo;
    }

    public void cambiarIdioma(String lenguaje, String pais) {
        setTitle(mI.get("ventana.usuario.crear.titulo"));

        LblTitulo.setText(mI.get("ventana.usuario.crear.titulo"));
        LblCredencialesUsuariuo.setText(mI.get("ventana.usuario.crear.credenciales.usuario"));
        LblUsuario.setText(mI.get("ventana.usuario.crear.usuario"));
        LblContraseña.setText(mI.get("ventana.usuario.crear.contrasena"));
        LblRol.setText(mI.get("ventana.usuario.crear.rol"));

        LblDatosUsuario.setText(mI.get("ventana.usuario.crear.datos.usuario"));
        LblNombre.setText(mI.get("ventana.usuario.crear.nombre"));
        LblApellido.setText(mI.get("ventana.usuario.crear.apellido"));
        LblCorreo.setText(mI.get("ventana.usuario.crear.correo"));
        LblTelefono.setText(mI.get("ventana.usuario.crear.telefono"));
        LblFechaNacimiento.setText(mI.get("ventana.usuario.crear.fecha.nacimiento"));
        LblDia.setText(mI.get("ventana.usuario.crear.dia"));
        LblMes.setText(mI.get("ventana.usuario.crear.mes"));
        LblAnio.setText(mI.get("ventana.usuario.crear.anio"));

        BtnCancelar.setText(mI.get("ventana.usuario.crear.cancelar"));
        BtnRegistrar.setText(mI.get("ventana.usuario.crear.registrar"));

        // Actualizar ítems del combo Rol
        CbxRol.removeAllItems();
        CbxRol.addItem(mI.get("rol.administrador"));
        CbxRol.addItem(mI.get("rol.usuario"));
    }

    public void crearUsuario() {
        String nombre = getTxtNombre().getText();
        String apellido = getTxtApellido().getText();
        String telefono = getTxtTelefono().getText();
        String correo = getTxtCorreo().getText();
        String username = getTxtUsername().getText();
        String contrasenia = new String(getTxtPassword().getPassword());
        Rol rol = Rol.USUARIO;

        int dia = Integer.parseInt(getCbxDia().getSelectedItem().toString());
        int mes = Integer.parseInt(getCbxMes().getSelectedItem().toString()) - 1;
        int anio = Integer.parseInt(getCbxAnio().getSelectedItem().toString());

        GregorianCalendar fechaCreacion = new GregorianCalendar(anio, mes, dia);

        if (TxtUsername.getText().isEmpty() || TxtPassword.getText().isEmpty() || rol == null) {
            mostrarMensaje("Todos los campos son obligatorios.");
            return;
        }

        if (usuarioDAO.buscarPorUsername(username) != null) {
            mostrarMensaje("Ese nombre de usuario ya está en uso.");
            return;
        }

        Usuario usuario = new Usuario(nombre, apellido, telefono, correo, username, contrasenia, rol, fechaCreacion);;
        usuarioDAO.crear(usuario);

        mostrarMensaje("Usuario creado exitosamente: " + username);
    }

    public void limpiarCampos() {
        TxtUsername.setText("");
        TxtPassword.setText("");
        TxtNombre.setText("");
        TxtApellido.setText("");
        TxtCorreo.setText("");
        TxtTelefono.setText("");
        CbxDia.setSelectedIndex(0);
        CbxMes.setSelectedIndex(0);
        CbxRol.setSelectedIndex(0);
    }

    public void cargarDias() {
        CbxDia.removeAllItems();
        for (int i = 1; i <= 31; i++) {
            CbxDia.addItem(String.valueOf(i));
        }
    }

    public void cargarMeses() {
        CbxMes.removeAllItems();
        for (int i = 1; i <= 12; i++) {
            CbxMes.addItem(String.valueOf(i));
        }
    }

    public void cargarAnios() {
        CbxAnio.removeAllItems();
        int anioActual = GregorianCalendar.getInstance().get(GregorianCalendar.YEAR);
        for (int i = anioActual; i >= 1900; i--) {
            CbxAnio.addItem(String.valueOf(i));
        }
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