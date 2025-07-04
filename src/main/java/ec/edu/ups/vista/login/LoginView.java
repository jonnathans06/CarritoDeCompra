package ec.edu.ups.vista.login;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import java.net.URL;

public class LoginView extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelSecundario;
    private JTextField txtUsername;
    private JPasswordField txtContrasenia;
    private JButton btnIniciarSesion;
    private JButton btnRegistrarse;
    private JButton BtnRecuperar;
    private JLabel LblTitulo;
    private JLabel LblUsuario;
    private JLabel LblContraseña;
    private MensajeInternacionalizacionHandler mI;

    public LoginView(MensajeInternacionalizacionHandler mI) {
        setContentPane(panelPrincipal);
        setTitle("Iniciar Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        this.mI = mI;

        URL loginURL = LoginView.class.getClassLoader().getResource("imagenes/login.png");
        ImageIcon iconoBtnIniciarSesion = new ImageIcon(loginURL);
        btnIniciarSesion.setIcon(iconoBtnIniciarSesion);

        URL registrarURL = LoginView.class.getClassLoader().getResource("imagenes/registrar.png");
        ImageIcon iconoBtnRegistrar = new ImageIcon(registrarURL);
        btnRegistrarse.setIcon(iconoBtnRegistrar);

        cambiarIdioma(mI.getLocale().getCountry(), mI.getLocale().getLanguage());
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JPanel getPanelSecundario() {
        return panelSecundario;
    }

    public void setPanelSecundario(JPanel panelSecundario) {
        this.panelSecundario = panelSecundario;
    }

    public JLabel getLblTitulo() {
        return LblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        LblTitulo = lblTitulo;
    }

    public JTextField getTxtUsername() {
        return txtUsername;
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

    public void setTxtUsername(JTextField txtUsername) {
        this.txtUsername = txtUsername;
    }

    public JPasswordField getTxtContrasenia() {
        return txtContrasenia;
    }

    public void setTxtContrasenia(JPasswordField txtContrasenia) {
        this.txtContrasenia = txtContrasenia;
    }

    public JButton getBtnIniciarSesion() {
        return btnIniciarSesion;
    }

    public void setBtnIniciarSesion(JButton btnIniciarSesion) {
        this.btnIniciarSesion = btnIniciarSesion;
    }

    public JButton getBtnRegistrarse() {
        return btnRegistrarse;
    }

    public void setBtnRegistrarse(JButton btnRegistrarse) {
        this.btnRegistrarse = btnRegistrarse;
    }

    public JButton getBtnRecuperar() {
        return BtnRecuperar;
    }

    public void setBtnRecuperar(JButton btnRecuperar) {
        BtnRecuperar = btnRecuperar;
    }

    public void cambiarIdioma(String idioma, String pais){
        mI.setLenguaje(idioma, pais);

        setTitle(mI.get("ventana.login.titulo"));
        LblTitulo.setText(mI.get("ventana.login.titulo"));

        LblUsuario.setText(mI.get("ventana.login.usuario"));
        LblContraseña.setText(mI.get("ventana.login.contrasenia"));

        btnIniciarSesion.setText(mI.get("ventana.login.iniciarSesion"));
        btnRegistrarse.setText(mI.get("ventana.login.registrar"));
        BtnRecuperar.setText(mI.get("ventana.login.btnRecuperar"));

    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
