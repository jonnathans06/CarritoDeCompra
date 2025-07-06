package ec.edu.ups.vista.login;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import java.net.URL;

public class LoginView extends JFrame {
    private JPanel panelPrincipal;
    private JPanel panelSecundario;
    private JTextField TxtUsername;
    private JPasswordField TxtContrasenia;
    private JButton btnIniciarSesion;
    private JButton btnRegistrarse;
    private JButton BtnRecuperar;
    private JLabel LblTitulo;
    private JLabel LblUsuario;
    private JLabel LblContraseña;
    private JComboBox CbxIdioma;
    private JLabel LblIdioma;
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

        cargarIdiomas();
        cambiarIdioma(mI.getLocale().getCountry(), mI.getLocale().getLanguage());


        CbxIdioma.addActionListener(e -> {
            String seleccionado = (String) CbxIdioma.getSelectedItem();

            if (seleccionado.equalsIgnoreCase("Español")) {
                cambiarIdioma("EC", "es");
            } else if (seleccionado.equalsIgnoreCase("Ingles")) {
                cambiarIdioma("US", "en");
            } else if (seleccionado.equalsIgnoreCase("Frances")) {
                cambiarIdioma("FR", "fr");
            }
        });
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

    public JTextField getTxtUsername() {
        return TxtUsername;
    }

    public void setTxtUsername(JTextField txtUsername) {
        this.TxtUsername = TxtUsername;
    }

    public JComboBox getCbxIdioma() {
        return CbxIdioma;
    }

    public void setCbxIdioma(JComboBox cbxIdioma) {
        CbxIdioma = cbxIdioma;
    }

    public JLabel getLblIdioma() {
        return LblIdioma;
    }

    public void setLblIdioma(JLabel lblIdioma) {
        LblIdioma = lblIdioma;
    }

    public MensajeInternacionalizacionHandler getmI() {
        return mI;
    }

    public void setmI(MensajeInternacionalizacionHandler mI) {
        this.mI = mI;
    }

    public JPasswordField getTxtContrasenia() {
        return TxtContrasenia;
    }

    public void setTxtContrasenia(JPasswordField txtContrasenia) {
        this.TxtContrasenia = txtContrasenia;
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

    public void cambiarIdioma(String pais, String idioma) {
        mI.setLenguaje(idioma, pais);

        setTitle(mI.get("ventana.login.titulo"));
        LblTitulo.setText(mI.get("ventana.login.titulo"));

        LblUsuario.setText(mI.get("ventana.login.usuario"));
        LblContraseña.setText(mI.get("ventana.login.contrasenia"));

        btnIniciarSesion.setText(mI.get("ventana.login.iniciarSesion"));
        btnRegistrarse.setText(mI.get("ventana.login.registrar"));
        BtnRecuperar.setText(mI.get("ventana.login.btnRecuperar"));
        LblIdioma.setText("Idioma:");
    }

    public void cargarIdiomas() {
        CbxIdioma.removeAllItems();
        CbxIdioma.addItem("Español");
        CbxIdioma.addItem("Ingles");
        CbxIdioma.addItem("Frances");
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
