package ec.edu.ups.vista.login;

import ec.edu.ups.dao.PreguntasDAO;
import ec.edu.ups.dao.impl.PreguntasDAOMemoria;
import ec.edu.ups.modelo.Preguntas;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

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
    private MensajeInternacionalizacionHandler mI;

    public RegistroPreguntasView(PreguntasDAO preguntasDAOMemoria, MensajeInternacionalizacionHandler mI) {
        setContentPane(panelPrincipal);
        setTitle("Registro Preguntas");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(550, 360);
        setLocationRelativeTo(null);
        setResizable(false);
        preguntasDAO = new PreguntasDAOMemoria();
        this.preguntasDAOMemoria = preguntasDAOMemoria;
        this.mI = mI;

        cargarPreguntas();
        cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
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

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        int selectedIndex = CbxPreguntas.getSelectedIndex();
        if (selectedIndex != -1) {
            CbxPreguntas.removeItemAt(selectedIndex);
        }
        TxtRespuesta.setText("");
    }

    public void cargarPreguntas() {
        CbxPreguntas.removeAllItems();
        for (Preguntas pregunta : preguntasDAOMemoria.listarPreguntas()) {
            CbxPreguntas.addItem(pregunta);
        }
    }

    public void cambiarIdioma(String idioma, String pais) {
        mI.setLenguaje(idioma, pais);

        setTitle(mI.get("ventana.registroPreguntas.titulo"));
        LblTitulo.setText(mI.get("ventana.registroPreguntas.titulo"));
        LblRespuesta.setText(mI.get("ventana.registroPreguntas.respuesta"));
        BtnGuardar.setText(mI.get("ventana.registroPreguntas.guardar"));
        BtnFinalizar.setText(mI.get("ventana.registroPreguntas.finalizar"));
    }

}
