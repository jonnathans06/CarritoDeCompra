package ec.edu.ups.vista.carrito;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.ItemCarrito;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CarritoAnadirView extends JInternalFrame {
    private JButton btnBuscar;
    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtPrecio;
    private JButton btnAnadir;
    private JTable tblProductos;
    private JTextField txtSubtotal;
    private JTextField txtIva;
    private JTextField txtTotal;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JComboBox cbxCantidad;
    private JPanel panelPrincipal;
    private JLabel LblTitulo;
    private JLabel LblCodBusqueda;
    private JLabel LblNombre;
    private JLabel LblPrecio;
    private JLabel LblCantidad;
    private JLabel LblSubtotal;
    private JLabel LblIva;
    private JLabel LblTotal;
    private JPanel panel;
    private Carrito carrito;
    private Usuario usuario;
    MensajeInternacionalizacionHandler mI;
    DefaultTableModel modelo;

    public CarritoAnadirView(Usuario usuario, MensajeInternacionalizacionHandler mI) {

        super("carrito de Compras", true, true, false, true);
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        this.carrito = new Carrito(usuario);
        this.mI = mI;

        modelo = new DefaultTableModel();
        Object[] columnas = {"Codigo", "Nombre", "Precio", "Cantidad", "Subtotal"};
        modelo.setColumnIdentifiers(columnas);
        tblProductos.setModel(modelo);

        cargarDatosProductos();
        cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());

    }


    private void cargarDatosProductos(){
        cbxCantidad.removeAllItems();
        for(int i = 0; i < 20; i++){
            cbxCantidad.addItem(String.valueOf(i + 1));
        }
    }

    public void cargarDatosProductos(Carrito carrito) {
        modelo.setRowCount(0);
        for(ItemCarrito item : carrito.obtenerItems()) {
            Object[] fila = {
                    item.getProducto().getCodigo(),
                    item.getProducto().getNombre(),
                    item.getProducto().getPrecio(),
                    item.getCantidad()
            };
            modelo.addRow(fila);
        }

    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        this.btnBuscar = btnBuscar;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        this.txtCodigo = txtCodigo;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    public void setTxtPrecio(JTextField txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    public JButton getBtnAnadir() {
        return btnAnadir;
    }

    public void setBtnAnadir(JButton btnAnadir) {
        this.btnAnadir = btnAnadir;
    }

    public JTable getTblProductos() {
        return tblProductos;
    }

    public void setTblProductos(JTable tblProductos) {
        this.tblProductos = tblProductos;
    }

    public JTextField getTxtSubtotal() {
        return txtSubtotal;
    }

    public void setTxtSubtotal(JTextField txtSubtotal) {
        this.txtSubtotal = txtSubtotal;
    }

    public JTextField getTxtIva() {
        return txtIva;
    }

    public void setTxtIva(JTextField txtIva) {
        this.txtIva = txtIva;
    }

    public JTextField getTxtTotal() {
        return txtTotal;
    }

    public void setTxtTotal(JTextField txtTotal) {
        this.txtTotal = txtTotal;
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void setBtnGuardar(JButton btnGuardar) {
        this.btnGuardar = btnGuardar;
    }

    public JButton getBtnLimpiar() {
        return btnLimpiar;
    }

    public void setBtnLimpiar(JButton btnLimpiar) {
        this.btnLimpiar = btnLimpiar;
    }

    public JComboBox getCbxCantidad() {
        return cbxCantidad;
    }

    public void setCbxCantidad(JComboBox cbxCantidad) {
        this.cbxCantidad = cbxCantidad;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JLabel getLblTitulo() {
        return LblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        LblTitulo = lblTitulo;
    }

    public JLabel getLblCodBusqueda() {
        return LblCodBusqueda;
    }

    public void setLblCodBusqueda(JLabel lblCodBusqueda) {
        LblCodBusqueda = lblCodBusqueda;
    }

    public JLabel getLblPrecio() {
        return LblPrecio;
    }

    public void setLblPrecio(JLabel lblPrecio) {
        LblPrecio = lblPrecio;
    }

    public JLabel getLblCantidad() {
        return LblCantidad;
    }

    public void setLblCantidad(JLabel lblCantidad) {
        LblCantidad = lblCantidad;
    }

    public JLabel getLblSubtotal() {
        return LblSubtotal;
    }

    public void setLblSubtotal(JLabel lblSubtotal) {
        LblSubtotal = lblSubtotal;
    }

    public JLabel getLblIva() {
        return LblIva;
    }

    public void setLblIva(JLabel lblIva) {
        LblIva = lblIva;
    }

    public JLabel getLblTotal() {
        return LblTotal;
    }

    public void setLblTotal(JLabel lblTotal) {
        LblTotal = lblTotal;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public JLabel getLblNombre() {
        return LblNombre;
    }

    public void setLblNombre(JLabel lblNombre) {
        LblNombre = lblNombre;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public void cambiarIdioma(String lenguaje, String pais) {
        mI.setLenguaje(lenguaje, pais);
        setTitle(mI.get("ventana.carrito.anadir.titulo"));

        LblTitulo.setText(mI.get("ventana.carrito.anadir.titulo"));
        LblCodBusqueda.setText(mI.get("ventana.carrito.anadir.codigo"));
        LblNombre.setText(mI.get("ventana.carrito.anadir.nombre"));
        LblPrecio.setText(mI.get("ventana.carrito.anadir.precio"));
        LblCantidad.setText(mI.get("ventana.carrito.anadir.cantidad"));
        LblSubtotal.setText(mI.get("ventana.carrito.anadir.subtotal"));
        LblIva.setText(mI.get("ventana.carrito.anadir.iva"));
        LblTotal.setText(mI.get("ventana.carrito.anadir.total"));

        btnBuscar.setText(mI.get("ventana.carrito.anadir.buscar"));
        btnAnadir.setText(mI.get("ventana.carrito.anadir.anadir"));
        btnGuardar.setText(mI.get("ventana.carrito.anadir.guardar"));
        btnLimpiar.setText(mI.get("ventana.carrito.anadir.cancelar"));

        Object[] columnas = {
                mI.get("ventana.carrito.anadir.tabla.codigo"),
                mI.get("ventana.carrito.anadir.tabla.nombre"),
                mI.get("ventana.carrito.anadir.tabla.precio"),
                mI.get("ventana.carrito.anadir.tabla.cantidad"),
                mI.get("ventana.carrito.anadir.tabla.subtotal")
        };
        modelo.setColumnIdentifiers(columnas);
        tblProductos.getTableHeader().repaint();
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
