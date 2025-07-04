package ec.edu.ups.vista.login;

import ec.edu.ups.dao.PreguntasDAO;
import ec.edu.ups.dao.impl.PreguntasDAOMemoria;
import ec.edu.ups.modelo.Preguntas;

import javax.swing.*;

public class RegistroPreguntasView extends JFrame {
    private JPanel panelPrincipal;
    private JLabel LblTitulo;
    private JComboBox CbxPreguntas;
    private JTextField TxtRespuesta;
    private JLabel LblRespuesta;
    private JButton BtnGuardar;
    private JButton BtnFinalizar;
    private Preguntas preguntas;
    private PreguntasDAOMemoria preguntasDAO;
    private PreguntasDAO preguntasDAOMemoria;

    public RegistroPreguntasView(PreguntasDAO preguntasDAOMemoria) {
        setContentPane(panelPrincipal);
        setTitle("Registro Preguntas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 360);
        setLocationRelativeTo(null);
        setResizable(false);
        preguntasDAO = new PreguntasDAOMemoria();
        this.preguntasDAOMemoria = preguntasDAOMemoria;

        cargarPreguntas();
    }

    public JLabel getLblTitulo() {
        return LblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        LblTitulo = lblTitulo;
    }

    public JComboBox getCbxPreguntas() {
        return CbxPreguntas;
    }

    public void setCbxPreguntas(JComboBox cbxPreguntas) {
        CbxPreguntas = cbxPreguntas;
    }

    public JTextField getTxtRespuesta() {
        return TxtRespuesta;
    }

    public void setTxtRespuesta(JTextField txtRespuesta) {
        TxtRespuesta = txtRespuesta;
    }

    public JLabel getLblRespuesta() {
        return LblRespuesta;
    }

    public void setLblRespuesta(JLabel lblRespuesta) {
        LblRespuesta = lblRespuesta;
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

    public void cargarPreguntas() {
        CbxPreguntas.removeAllItems();
        for (Preguntas pregunta : preguntasDAOMemoria.listarPreguntas()) {
            CbxPreguntas.addItem(pregunta);
        }
    }
}
