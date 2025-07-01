package ec.edu.ups.vista.producto;

import ec.edu.ups.modelo.Producto;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ProductoEliminarView extends JInternalFrame {
    private JPanel panelPrincipal;
    private JTextField TxtCodigo;
    private JButton BtnBuscar;
    private JButton BtnEliminar;
    private JTable table1;
    private JScrollPane TblProducto;
    private JLabel LblTitulo;
    private JLabel LblCodigo;
    private DefaultTableModel modelo;
    MensajeInternacionalizacionHandler mI;

    public ProductoEliminarView(MensajeInternacionalizacionHandler mI) {
        setContentPane(panelPrincipal);
        setTitle("Eliminar Producto");
        setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        this.mI = mI;

        modelo = new DefaultTableModel();
        Object[] columnas = {"Código", "Nombre", "Precio"};
        modelo.setColumnIdentifiers(columnas);
        table1.setModel(modelo);
        cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
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

    public JButton getBtnEliminar() {
        return BtnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        BtnEliminar = btnEliminar;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JScrollPane getTblProducto() {
        return TblProducto;
    }

    public void setTblProducto(JScrollPane tblProducto) {
        TblProducto = tblProducto;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public JLabel getLblTitulo() {
        return LblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        LblTitulo = lblTitulo;
    }

    public JLabel getLblCodigo() {
        return LblCodigo;
    }

    public void setLblCodigo(JLabel lblCodigo) {
        LblCodigo = lblCodigo;
    }

    public void cambiarIdioma(String idioma, String pais) {
        mI.setLenguaje(idioma, pais);

        setTitle(mI.get("ventana.producto.eliminar.titulo"));
        LblTitulo.setText(mI.get("ventana.producto.eliminar.titulo"));
        LblCodigo.setText(mI.get("ventana.producto.eliminar.codigo"));
        BtnBuscar.setText(mI.get("ventana.producto.eliminar.buscar"));
        BtnEliminar.setText(mI.get("ventana.producto.eliminar.eliminar"));

        Object[] columnas = {
                mI.get("ventana.producto.eliminar.tabla.codigo"),
                mI.get("ventana.producto.eliminar.tabla.nombre"),
                mI.get("ventana.producto.eliminar.tabla.precio")
        };
        modelo.setColumnIdentifiers(columnas);
        table1.getTableHeader().repaint();
    }


    public void cargarDatos(List<Producto> listaProductos) {
        modelo.setNumRows(0);

        for (Producto producto : listaProductos) {
            Object[] fila = {
                    producto.getCodigo(),
                    producto.getNombre(),
                    producto.getPrecio()
            };
            modelo.addRow(fila);
        }


    }

    public boolean confirmarEliminacion() {
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarCampos() {
        TxtCodigo.setText("");
    }
}
