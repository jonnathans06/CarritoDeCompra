package ec.edu.ups.vista.login;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import java.util.GregorianCalendar;

public class RegistroView extends JFrame{
    private JPanel panelPrincipal;
    private JTextField TxtNombre;
    private JTextField TxtUsuario;
    private JComboBox CbxDia;
    private JComboBox CbxMes;
    private JTextField TxtApellido;
    private JPasswordField TxtContrasenia;
    private JTextField TxtCorreo;
    private JTextField TxtTelefono;
    private JButton BtnRegistrarse;
    private JButton BtnCancelar;
    private JLabel LblTitulo;
    private JLabel LblDatosPersonales;
    private JLabel LblNombre;
    private JLabel LblApellido;
    private JLabel LblCorreo;
    private JLabel LblTelefono;
    private JLabel LblDia;
    private JLabel LblMes;
    private JLabel LblUsuario;
    private JLabel LblContrasenia;
    private JLabel LblPerfilUsuario;
    private JLabel LblAnio;
    private JTextField TxtAño;
    private JComboBox CbxAnio;
    private GregorianCalendar fechaCreacion;
    private MensajeInternacionalizacionHandler mI;

    public RegistroView(MensajeInternacionalizacionHandler mI) {
        setContentPane(panelPrincipal);
        setTitle("Registro de Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(470, 500);
        setLocationRelativeTo(null);
        this.mI = mI;

        cargarDias();
        cargarMeses();
        cargarAnios();
        cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
    }

    public JTextField getTxtNombre() {
        return TxtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        TxtNombre = txtNombre;
    }

    public JTextField getTxtUsuario() {
        return TxtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        TxtUsuario = txtUsuario;
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

    public JTextField getTxtApellido() {
        return TxtApellido;
    }

    public void setTxtApellido(JTextField txtApellido) {
        TxtApellido = txtApellido;
    }

    public JPasswordField getTxtContrasenia() {
        return TxtContrasenia;
    }

    public void setTxtContrasenia(JPasswordField txtContrasenia) {
        TxtContrasenia = txtContrasenia;
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

    public JButton getBtnRegistrarse() {
        return BtnRegistrarse;
    }

    public void setBtnRegistrarse(JButton btnRegistrarse) {
        BtnRegistrarse = btnRegistrarse;
    }

    public JButton getBtnCancelar() {
        return BtnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        BtnCancelar = btnCancelar;
    }

    public JLabel getLblTitulo() {
        return LblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        LblTitulo = lblTitulo;
    }

    public JLabel getLblDatosPersonales() {
        return LblDatosPersonales;
    }

    public void setLblDatosPersonales(JLabel lblDatosPersonales) {
        LblDatosPersonales = lblDatosPersonales;
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

    public JLabel getLblUsuario() {
        return LblUsuario;
    }

    public void setLblUsuario(JLabel lblUsuario) {
        LblUsuario = lblUsuario;
    }

    public JLabel getLblContrasenia() {
        return LblContrasenia;
    }

    public void setLblContrasenia(JLabel lblContrasenia) {
        LblContrasenia = lblContrasenia;
    }

    public JLabel getLblPerfilUsuario() {
        return LblPerfilUsuario;
    }

    public void setLblPerfilUsuario(JLabel lblPerfilUsuario) {
        LblPerfilUsuario = lblPerfilUsuario;
    }

    public JLabel getLblAnio() {
        return LblAnio;
    }

    public void setLblAnio(JLabel lblAnio) {
        LblAnio = lblAnio;
    }

    public JTextField getTxtAño() {
        return TxtAño;
    }

    public void setTxtAño(JTextField txtAño) {
        TxtAño = txtAño;
    }

    public GregorianCalendar getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(GregorianCalendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public JComboBox getCbxAnio() {
        return CbxAnio;
    }

    public void setCbxAnio(JComboBox cbxAnio) {
        CbxAnio = cbxAnio;
    }


    public void cargarDias() {
        CbxDia.removeAllItems();
        for (int i = 1; i <= 31; i++) {
            CbxDia.addItem(i);
        }
    }

    public void cargarMeses() {
        CbxMes.removeAllItems();
        for (int i = 1; i <= 12; i++) {
            CbxMes.addItem(i);
        }
    }

    public void cargarAnios() {
        CbxAnio.removeAllItems();
        int anioActual = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        for (int i = 1960; i <= anioActual; i++) {
            CbxAnio.addItem(i);
        }
    }

    public void cambiarIdioma(String idioma, String pais) {
        mI.setLenguaje(idioma, pais);

        setTitle(mI.get("ventana.registro.titulo"));

        LblTitulo.setText(mI.get("ventana.registro.titulo"));
        LblDatosPersonales.setText(mI.get("ventana.registro.datosPersonales"));
        LblNombre.setText(mI.get("ventana.registro.nombre"));
        LblApellido.setText(mI.get("ventana.registro.apellido"));
        LblCorreo.setText(mI.get("ventana.registro.correo"));
        LblTelefono.setText(mI.get("ventana.registro.telefono"));
        LblDia.setText(mI.get("ventana.registro.dia"));
        LblMes.setText(mI.get("ventana.registro.mes"));
        LblAnio.setText(mI.get("ventana.registro.anio"));
        LblUsuario.setText(mI.get("ventana.registro.usuario"));
        LblContrasenia.setText(mI.get("ventana.registro.contrasenia"));
        LblPerfilUsuario.setText(mI.get("ventana.registro.perfilUsuario"));

        BtnRegistrarse.setText(mI.get("ventana.registro.btnRegistrarse"));
        BtnCancelar.setText(mI.get("ventana.registro.btnCancelar"));
    }

}