package ec.edu.ups.vista.login;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.PreguntaRespondida;
import ec.edu.ups.modelo.Usuario;

import javax.swing.*;

public class RecuperacionView extends JFrame{
    private JPanel panelPrincipal;
    private JLabel LblTitulo;
    private JComboBox CbxPreguntasSeguridad;
    private JTextField TxtRespuesta;
    private JLabel LblInformativo;
    private JLabel LblRespuesta;
    private JButton BtnVerificar;
    private JButton BtnCancelar;
    private JTextField TxtUsuario;
    private JButton BtnBuscar;
    private JTextField TxtContrasenia;
    private JLabel LblNuevaContraseña;
    private JButton BtnCambiarContrasenia;
    private UsuarioDAO usuarioDAO;

    public RecuperacionView(UsuarioDAO usuarioDAO) {
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Recuperación Contraseña");
        setSize(580,400);
        setLocationRelativeTo(null);
        setResizable(false);
        this.usuarioDAO = usuarioDAO;

        cargarPreguntasSeguridad();
    }

    public JLabel getLblTitulo() {
        return LblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        LblTitulo = lblTitulo;
    }

    public JTextField getTxtUsuario() {
        return TxtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        TxtUsuario = txtUsuario;
    }

    public JButton getBtnBuscar() {
        return BtnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        BtnBuscar = btnBuscar;
    }

    public JComboBox getCbxPreguntasSeguridad() {
        return CbxPreguntasSeguridad;
    }

    public void setCbxPreguntasSeguridad(JComboBox cbxPreguntasSeguridad) {
        CbxPreguntasSeguridad = cbxPreguntasSeguridad;
    }

    public JTextField getTxtRespuesta() {
        return TxtRespuesta;
    }

    public void setTxtRespuesta(JTextField txtRespuesta) {
        TxtRespuesta = txtRespuesta;
    }

    public JLabel getLblInformativo() {
        return LblInformativo;
    }

    public void setLblInformativo(JLabel lblInformativo) {
        LblInformativo = lblInformativo;
    }

    public JLabel getLblRespuesta() {
        return LblRespuesta;
    }

    public void setLblRespuesta(JLabel lblRespuesta) {
        LblRespuesta = lblRespuesta;
    }

    public JButton getBtnVerificar() {
        return BtnVerificar;
    }

    public void setBtnVerificar(JButton btnVerificar) {
        BtnVerificar = btnVerificar;
    }

    public JButton getBtnCancelar() {
        return BtnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        BtnCancelar = btnCancelar;
    }

    public JTextField getTxtContrasenia() {
        return TxtContrasenia;
    }

    public void setTxtContrasenia(JTextField txtContraseña) {
        TxtContrasenia = txtContraseña;
    }

    public JLabel getLblNuevaContraseña() {
        return LblNuevaContraseña;
    }

    public void setLblNuevaContraseña(JLabel lblNuevaContraseña) {
        LblNuevaContraseña = lblNuevaContraseña;
    }

    public JButton getBtnCambiarContrasenia() {
        return BtnCambiarContrasenia;
    }

    public void setBtnCambiarContrasenia(JButton btnCambiarContrasenia) {
        BtnCambiarContrasenia = btnCambiarContrasenia;
    }

    public void buscarUsuario() {
        Usuario usuarioRecuperar = usuarioDAO.buscarPorUsername(TxtUsuario.getText());
        System.out.println(usuarioRecuperar);
    }

    public void cargarPreguntasSeguridad() {
        CbxPreguntasSeguridad.removeAllItems();
        Usuario usuarioRecuperar = usuarioDAO.buscarPorUsername(TxtUsuario.getText());
        for (PreguntaRespondida pr : usuarioRecuperar.getPreguntaRespondida()) {
            CbxPreguntasSeguridad.addItem(pr);
        }
    }

    public boolean validarRespuesta() {
        PreguntaRespondida enunciadoRespuesta = (PreguntaRespondida) CbxPreguntasSeguridad.getSelectedItem();
        String respuestaValida = enunciadoRespuesta.getRespuesta().getTexto();
        String respuestaIngresada = TxtRespuesta.getText();

        if (respuestaIngresada.equals(respuestaValida)) {
            TxtContrasenia.setEnabled(true);
            System.out.println("Validado");
            return true;
        } else {
            System.out.println("Mamaste");
        }
    return false;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
