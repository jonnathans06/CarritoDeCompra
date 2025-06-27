package ec.edu.ups.vista.carrito;

import ec.edu.ups.dao.CarritoDAO;
import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.List;

public class CarritoEliminarView extends JInternalFrame{
    private JPanel panelPrincipal;
    private JTextField TxtCarrito;
    private JButton BtnBuscar;
    private JButton BtnListar;
    private JButton BtnEliminar;
    private JTable TblCarritos;
    private CarritoDAO carritoDAO;
    DefaultTableModel TblCarritosModel = new DefaultTableModel();

    public CarritoEliminarView() {
        setContentPane(panelPrincipal);
        setTitle("Eliminar Carrito");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMaximizable(true);
        setClosable(true);
        setResizable(true);
        setIconifiable(true);

        DefaultTableModel modelo = new DefaultTableModel();
        Object[] columnas = {"Código", "Fecha", "Productos", "Total"};
        modelo.setColumnIdentifiers(columnas);
        TblCarritos.setModel(modelo);

    }

    public JTextField getTxtCarrito() {
        return TxtCarrito;
    }

    public void setTxtCarrito(JTextField txtCarrito) {
        TxtCarrito = txtCarrito;
    }

    public JButton getBtnBuscar() {
        return BtnBuscar;
    }

    public void setBtnBuscar(JButton btnBuscar) {
        BtnBuscar = btnBuscar;
    }

    public JButton getBtnListar() {
        return BtnListar;
    }

    public void setBtnListar(JButton btnListar) {
        BtnListar = btnListar;
    }

    public JButton getBtnEliminar() {
        return BtnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        BtnEliminar = btnEliminar;
    }

    public JTable getTblCarritos() {
        return TblCarritos;
    }

    public void setTblCarritos(JTable tblCarritos) {
        TblCarritos = tblCarritos;
    }

    public DefaultTableModel getTblCarritosModel() {
        return TblCarritosModel;
    }

    public void setTblCarritosModel(DefaultTableModel tblCarritosModel) {
        TblCarritosModel = tblCarritosModel;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void cargarDatosTabla(List<Carrito> carritos) {
        TblCarritosModel.setRowCount(0);
        for (Carrito carrito : carritos) {
            Object[] fila = {
                carrito.getCodigo(),
                carrito.getFechaFormateada(),
                carrito.obtenerItems().size(),
                carrito.calcularTotal()
            };
            TblCarritosModel.addRow(fila);
        }
    }

    public void buscarPorCodigoCarrito(int codigo) {
        codigo = Integer.parseInt(TxtCarrito.getText());
        Carrito carrito = carritoDAO.buscarPorCodigo(codigo);
        if (carrito == null && getTxtCarrito().getText().isEmpty()) {
            mostrarMensaje("No existe el carrito");
        } else  {
            cargarDatosTabla(List.of(carrito));
        }
    }
}
