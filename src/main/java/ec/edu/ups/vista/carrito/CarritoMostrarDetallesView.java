package ec.edu.ups.vista.carrito;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.ItemCarrito;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CarritoMostrarDetallesView extends JInternalFrame {
    private JPanel panelPrincipal;
    private JTextField TxtCodigoCarrito;
    private JTable TblDetalleCarrito;
    private JButton BtnBuscar;
    private JLabel LblTitulo;
    private JLabel LblCodigoCarrito;
    private JLabel LblDetalleCarrito;
    private Carrito carrito;
    DefaultTableModel modelo;
    MensajeInternacionalizacionHandler mI;

    public CarritoMostrarDetallesView(MensajeInternacionalizacionHandler mI) {
        setContentPane(panelPrincipal);
        setTitle("Detalles del Carrito");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 350);
        setClosable(true);
        setResizable(true);
        setIconifiable(true);
        this.mI = mI;

        modelo = new DefaultTableModel(new Object[]{"Código","Producto","Cantidad","Total"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TblDetalleCarrito.setModel(modelo);
        cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
    }

    public JTextField getTxtCodigoCarrito() {
        return TxtCodigoCarrito;
    }

    public void setTxtCodigoCarrito(JTextField txtCodigoCarrito) {
        TxtCodigoCarrito = txtCodigoCarrito;
    }

    public JTable getTblDetalleCarrito() {
        return TblDetalleCarrito;
    }

    public void setTblDetalleCarrito(JTable tblDetalleCarrito) {
        TblDetalleCarrito = tblDetalleCarrito;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public DefaultTableModel getModelo() {
        return modelo;
    }

    public void setModelo(DefaultTableModel modelo) {
        this.modelo = modelo;
    }

    public JButton getBtnBuscar() {
        return BtnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        BtnBuscar = btnBuscar;
    }

    public JLabel getLblTitulo() {
        return LblTitulo;
    }

    public void setLblTitulo(JLabel lblTitulo) {
        LblTitulo = lblTitulo;
    }

    public JLabel getLblCodigoCarrito() {
        return LblCodigoCarrito;
    }

    public void setLblCodigoCarrito(JLabel lblCodigoCarrito) {
        LblCodigoCarrito = lblCodigoCarrito;
    }

    public JLabel getLblDetalleCarrito() {
        return LblDetalleCarrito;
    }

    public void setLblDetalleCarrito(JLabel lblDetalleCarrito) {
        LblDetalleCarrito = lblDetalleCarrito;
    }

    public void cambiarIdioma(String lenguaje, String pais) {
        mI.setLenguaje(lenguaje, pais);
        setTitle(mI.get("ventana.carrito.detalles.titulo"));

        LblTitulo.setText(mI.get("ventana.carrito.detalles.titulo"));
        LblCodigoCarrito.setText(mI.get("ventana.carrito.detalles.codigo"));
        LblDetalleCarrito.setText(mI.get("ventana.carrito.detalles.detalle"));

        BtnBuscar.setText(mI.get("ventana.carrito.detalles.buscar"));

        Object[] columnas = {
                mI.get("ventana.carrito.detalles.tabla.codigo"),
                mI.get("ventana.carrito.detalles.tabla.producto"),
                mI.get("ventana.carrito.detalles.tabla.cantidad"),
                mI.get("ventana.carrito.detalles.tabla.total")
        };
        modelo.setColumnIdentifiers(columnas);
        TblDetalleCarrito.getTableHeader().repaint();
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

    public void mostrarMensaje(String s) {
        JOptionPane.showMessageDialog(this, s, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}
