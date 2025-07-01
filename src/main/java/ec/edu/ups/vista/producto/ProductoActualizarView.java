package ec.edu.ups.vista.producto;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;

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
    private JLabel LblTitulo;
    MensajeInternacionalizacionHandler mI;

    public ProductoActualizarView(MensajeInternacionalizacionHandler mI) {
        setContentPane(panelPrincipal); 
        setTitle("Actualizar Producto");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        this.mI = mI;
        cambiarIdioma(mI.getLocale().getCountry(), mI.getLocale().getLanguage());
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

    public JLabel getLblTitulo() {
        return LblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        LblTitulo = lblTitulo;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public boolean confirmarEliminacion(MensajeInternacionalizacionHandler mI) {
        int respuesta = JOptionPane.showConfirmDialog(this,
                mI.get("ventana.producto.actualizar.confirmar"),
                "Confirmación", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    public void cambiarIdioma(String idioma, String pais) {
        mI.setLenguaje(idioma, pais);

        setTitle(mI.get("ventana.producto.actualizar.titulo"));

        LblTitulo.setText(mI.get("ventana.producto.actualizar.titulo"));

        LblCodigoBusqueda.setText(mI.get("ventana.producto.actualizar.codigo.busqueda"));
        LblCodigo.setText(mI.get("ventana.producto.actualizar.codigo"));
        LblNombre.setText(mI.get("ventana.producto.actualizar.nombre"));
        LblPrecio.setText(mI.get("ventana.producto.actualizar.precio"));

        BtnBuscar.setText(mI.get("ventana.producto.actualizar.buscar"));
        BtnEditar.setText(mI.get("ventana.producto.actualizar.editar"));
        BtnGuardar.setText(mI.get("ventana.producto.actualizar.guardar"));
    }



    public void limpiarCampos() {
        TxtCodigoBusqueda.setText("");
        TxtCodigo.setText("");
        TxtNombre.setText("");
        TxtPrecio.setText("");
    }
}
