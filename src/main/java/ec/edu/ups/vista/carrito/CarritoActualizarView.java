package ec.edu.ups.vista.carrito;

import ec.edu.ups.dao.CarritoDAO;
import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.ItemCarrito;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CarritoActualizarView extends JInternalFrame {
    private JTextField TxtCodigo;
    private JButton BtnBuscar;
    private JTable TblProductos;
    private JComboBox CbxCantiadad;
    private JScrollPane TblProducto;
    private JPanel panelPrincipal;
    private JButton BtnGuardar;
    private JLabel LblTitulo;
    private JLabel LblCodCarrito;
    private JLabel LblCantidad;
    private Carrito carritoActual;
    private CarritoDAO carritoDAO;
    DefaultTableModel modelo;
    private MensajeInternacionalizacionHandler mI;

    public CarritoActualizarView(CarritoDAO carritoDAO, MensajeInternacionalizacionHandler mI) {
        setContentPane(panelPrincipal);
        setTitle("Actualizar Carrito");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setClosable(true);
        setResizable(true);
        this.carritoDAO = carritoDAO;
        this.mI = mI;
        modelo = new DefaultTableModel();
        Object[] columnas = {"Código", "Producto", "Cantidad", "Total"};
        modelo.setColumnIdentifiers(columnas);
        TblProductos.setModel(modelo);

        cargarDatosProductos();int cantidad = Integer.parseInt((String) CbxCantiadad.getSelectedItem());
        cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
    }

    public JTextField getTxtCodigo() {
        return TxtCodigo;
    }

    public void setTxtCodigo(JTextField txtCodigo) {
        TxtCodigo = txtCodigo;
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

    public JTable getTblProductos() {
        return TblProductos;
    }

    public void setTblProductos(JTable tblProductos) {
        TblProductos = tblProductos;
    }

    public JComboBox getCbxCantiadad() {
        return CbxCantiadad;
    }

    public void setCbxCantiadad(JComboBox cbxCantiadad) {
        CbxCantiadad = cbxCantiadad;
    }

    public JScrollPane getTblProducto() {
        return TblProducto;
    }

    public void setTblProducto(JScrollPane tblProducto) {
        TblProducto = tblProducto;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public void setCarritoActual(Carrito carrito) {
        this.carritoActual = carrito;
    }

    public Carrito getCarritoActual() {
        return this.carritoActual;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public JLabel getLblTitulo() {
        return LblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        LblTitulo = lblTitulo;
    }

    public JLabel getLblCodCarrito() {
        return LblCodCarrito;
    }

    public void setLblCodCarrito(JLabel lblCodCarrito) {
        LblCodCarrito = lblCodCarrito;
    }

    public JLabel getLblCantidad() {
        return LblCantidad;
    }

    public void setLblCantidad(JLabel lblCantidad) {
        LblCantidad = lblCantidad;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public void obtenerCarritoSeleccionado() {
        int codigo = Integer.parseInt(getTxtCodigo().getText());
        Carrito carrito = carritoDAO.buscarPorCodigo(codigo);
        setCarritoActual(carrito);
        System.out.println("Carrito seleccionado: " + carrito);
    }

    private void cargarDatosProductos(){
        CbxCantiadad.removeAllItems();
        for(int i = 0; i < 20; i++){
            CbxCantiadad.addItem(String.valueOf(i + 1));
        }
    }

    public void cargarDatosCarrito(List<Carrito> carritos) {
        modelo.setRowCount(0);
        for (Carrito carrito : carritos) {
            for (ItemCarrito itemCarrito : carrito.obtenerItems()) {
                Producto producto = itemCarrito.getProducto();
                Object[] fila = {
                        producto.getCodigo(),
                        producto.getNombre(),
                        itemCarrito.getCantidad(),
                        producto.getPrecio() * itemCarrito.getCantidad()
                };
                modelo.addRow(fila);
            }
        }
    }

    public Producto itemSeleccionado(int fila) {
        if (fila >= 0 && fila < modelo.getRowCount()) {
            int codigoProducto = (int) modelo.getValueAt(fila, 0);
            String nombreProducto = (String) modelo.getValueAt(fila, 1);
            int cantidad = (int) modelo.getValueAt(fila, 2);
            double total = (double) modelo.getValueAt(fila, 3);

            return new Producto(codigoProducto, nombreProducto, total / cantidad);
        }
        return null;
    }

    public void actualizaCantidadProductoSeleccionado(Producto producto){
        int filaSeleccionada = TblProductos.getSelectedRow();

        if (filaSeleccionada >= 0) {
            int nuevaCantidad = Integer.parseInt(CbxCantiadad.getSelectedItem().toString());
            double total = producto.getPrecio() * nuevaCantidad;

            modelo.setValueAt(producto.getCodigo(), filaSeleccionada, 0);
            modelo.setValueAt(producto.getNombre(), filaSeleccionada, 1);
            modelo.setValueAt(nuevaCantidad, filaSeleccionada, 2);
            modelo.setValueAt(total, filaSeleccionada, 3);

            if (carritoActual != null) {
                for (ItemCarrito item : carritoActual.obtenerItems()) {
                    if (item.getProducto().getCodigo() == producto.getCodigo()) {
                        item.setCantidad(nuevaCantidad);
                        break;
                    }
                }
            }
        } else {
            mostrarMensaje("Seleccione un producto para actualizar la cantidad.");
        }
    }

    public void cambiarIdioma(String lenguaje, String pais) {
        mI.setLenguaje(lenguaje, pais);
        setTitle(mI.get("ventana.carrito.actualizar.titulo"));
        LblTitulo.setText(mI.get("ventana.carrito.actualizar.titulo"));
        LblCodCarrito.setText(mI.get("ventana.carrito.codigo"));
        LblCantidad.setText(mI.get("ventana.carrito.cantidad"));
        BtnBuscar.setText(mI.get("ventana.buscar"));
        BtnGuardar.setText(mI.get("ventana.guardar"));

        Object[] columnas = {
            mI.get("ventana.producto.codigo"),
            mI.get("ventana.producto.nombre"),
            mI.get("ventana.carrito.cantidad"),
            mI.get("ventana.carrito.total")
        };
        modelo.setColumnIdentifiers(columnas);
    }


    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}
