package ec.edu.ups.vista.cuestionario;

import javax.swing.*;

public class CuestionarioView extends JInternalFrame{
    private JTextField TxtRespuesta;
    private JComboBox CbxPreguntas;
    private JButton BtnGuardar;
    private JButton BtnFinalizar;
    private JPanel panelPrincipal;
    private JLabel LblPregunta;

    public CuestionarioView() {
        setContentPane(panelPrincipal);
        setTitle("Cuestionario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 300);
    }

    public JTextField getTxtRespuesta() {
        return TxtRespuesta;
    }

    public void setTxtRespuesta(JTextField txtRespuesta) {
        TxtRespuesta = txtRespuesta;
    }

    public JTextField getTextField1() {
        return TxtRespuesta;
    }

    public void setTextField1(JTextField textField1) {
        this.TxtRespuesta = textField1;
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

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JLabel getLblPregunta() {
        return LblPregunta;
    }

    public void setLblPregunta(JLabel lblPregunta) {
        LblPregunta = lblPregunta;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}