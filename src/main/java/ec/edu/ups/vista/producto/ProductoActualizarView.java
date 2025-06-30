package ec.edu.ups.vista.producto;

import javax.swing.*;

public class ProductoActualizarView extends JInternalFrame {
    private JPanel panelPrincipal;
    private JTextField TxtCodigoBusqueda;
    private JButton BtnBuscar;
    private JButton BtnGuardar;
    private JTextField TxtCodigo;
    private JTextField TxtNombre;
    private JTextField TxtPrecio;
    private JButton BtnEditar;
    private JLabel LblCodigoBusqueda;
    private JLabel LblCodigo;
    private JLabel LblNombre;
    private JLabel LblPrecio;

    public ProductoActualizarView() {
        setContentPane(panelPrincipal); 
        setTitle("Actualizar Producto");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JTextField getTxtCodigoBusqueda() {
        return TxtCodigoBusqueda;
    }

    public void setTxtCodigoBusqueda(JTextField txtCodigoBusqueda) {
        TxtCodigoBusqueda = txtCodigoBusqueda;
    }

    public JButton getBtnBuscar() {
        return BtnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        BtnBuscar = btnBuscar;
    }

    public JButton getBtnGuardar() {
        return BtnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        BtnGuardar = btnGuardar;
    }

    public JTextField getTxtCodigo() {
        return TxtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        TxtCodigo = txtCodigo;
    }

    public JTextField getTxtNombre() {
        return TxtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        TxtNombre = txtNombre;
    }

    public JTextField getTxtPrecio() {
        return TxtPrecio;
    }

    public void setTxtPrecio(JTextField txtPrecio) {
        TxtPrecio = txtPrecio;
    }

    public JButton getBtnEditar() {
        return BtnEditar;
    }

    public void setBtnEditar(JButton btnEditar) {
        BtnEditar = btnEditar;
    }

    public JLabel getLblCodigoBusqueda() {
        return LblCodigoBusqueda;
    }

    public void setLblCodigoBusqueda(JLabel lblCodigoBusqueda) {
        LblCodigoBusqueda = lblCodigoBusqueda;
    }

    public JLabel getLblCodigo() {
        return LblCodigo;
    }

    public void setLblCodigo(JLabel lblCodigo) {
        LblCodigo = lblCodigo;
    }

    public JLabel getLblNombre() {
        return LblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        LblNombre = lblNombre;
    }

    public JLabel getLblPrecio() {
        return LblPrecio;
    }

    public void setLblPrecio(JLabel lblPrecio) {
        LblPrecio = lblPrecio;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public boolean confirmarEliminacion() {
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de actualizar el producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    public void limpiarCampos() {
        TxtCodigoBusqueda.setText("");
        TxtCodigo.setText("");
        TxtNombre.setText("");
        TxtPrecio.setText("");
    }
}
