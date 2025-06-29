package ec.edu.ups.vista.login;

import javax.swing.*;
import java.awt.*;

public class PreguntasUsuarioView extends JInternalFrame{
    private JPanel panelPrincipal;
    private JComboBox CbxNumeroPreguntas;
    private JTextField TxtRespuesta;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JLabel LblPregunta;

    public  PreguntasUsuarioView() {
        setContentPane(panelPrincipal);
        setTitle("Preguntas Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        CbxNumeroPreguntas.setPreferredSize(new Dimension(220, 15));
    }
}