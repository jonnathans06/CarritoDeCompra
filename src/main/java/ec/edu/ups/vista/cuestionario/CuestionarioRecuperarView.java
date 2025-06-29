package ec.edu.ups.vista.cuestionario;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;

public class CuestionarioRecuperarView extends JFrame {
    private JPanel panelPrincipal;
    private JComboBox CbxPreguntas;
    private JButton BtnGuardar;
    private JButton BtnFinalizar;
    private JLabel LblSeleccionPreguntas;
    private JTextField TxtRespuesta;
    private JLabel LblPregunta;
    private MensajeInternacionalizacionHandler mi;

    public CuestionarioRecuperarView(MensajeInternacionalizacionHandler mi) {
        this.mi = mi;
        setTitle(mi.get("cuestionario.recuperar.titulo"));
        setSize(600, 400);
        setContentPane(panelPrincipal);
        setLocationRelativeTo(null);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JComboBox getCbxPreguntas() {
        return CbxPreguntas;
    }

    public void setCbxPreguntas(JComboBox cbxPreguntas) {
        CbxPreguntas = cbxPreguntas;
    }

    public JButton getBtnGuardar() {
        return BtnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        BtnGuardar = btnGuardar;
    }

    public JButton getBtnFinalizar() {
        return BtnFinalizar;
    }

    public void setBtnFinalizar(JButton btnFinalizar) {
        BtnFinalizar = btnFinalizar;
    }

    public JLabel getLblSeleccionPreguntas() {
        return LblSeleccionPreguntas;
    }

    public void setLblSeleccionPreguntas(JLabel lblSeleccionPreguntas) {
        LblSeleccionPreguntas = lblSeleccionPreguntas;
    }

    public JTextField getTxtRespuesta() {
        return TxtRespuesta;
    }

    public void setTxtRespuesta(JTextField txtRespuesta) {
        TxtRespuesta = txtRespuesta;
    }

    public MensajeInternacionalizacionHandler getMi() {
        return mi;
    }

    public void setMi(MensajeInternacionalizacionHandler mi) {
        this.mi = mi;
    }

    public JLabel getLblPregunta() {
        return LblPregunta;
    }

    public void setLblPregunta(JLabel lblPregunta) {
        LblPregunta = lblPregunta;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, mi.get("cuestionario.recuperar.titulo"), JOptionPane.INFORMATION_MESSAGE);
    }
}
