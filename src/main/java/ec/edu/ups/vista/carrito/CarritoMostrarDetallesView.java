package ec.edu.ups.vista.carrito;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.ItemCarrito;
import ec.edu.ups.modelo.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CarritoMostrarDetallesView extends JInternalFrame {
    private JPanel panelPrincipal;
    private JTextField TxtCodigoCarrito;
    private JTable TblDetalleCarrito;
    private JButton BtnBuscar;
    private Carrito carrito;
    DefaultTableModel modelo;

    public CarritoMostrarDetallesView() {
        setContentPane(panelPrincipal);
        setTitle("Detalles del Carrito");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 350);
        setClosable(true);
        setResizable(true);
        setIconifiable(true);


        modelo = new DefaultTableModel(new Object[]{"Código","Producto","Cantidad","Total"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TblDetalleCarrito.setModel(modelo);
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
