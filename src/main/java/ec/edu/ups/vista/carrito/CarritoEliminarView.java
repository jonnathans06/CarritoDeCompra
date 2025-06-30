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
    private JLabel LblTitulo;
    private JLabel LblCodCarrito;
    private CarritoDAO carritoDAO;
    DefaultTableModel  modelo;

    public CarritoEliminarView() {
        setContentPane(panelPrincipal);
        setTitle("Eliminar Carrito");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMaximizable(true);
        setClosable(true);
        setResizable(true);
        setIconifiable(true);

        modelo = new DefaultTableModel();
        Object[] columnas = {"Código","Fecha","Usuario","Subtotal","Total"};
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

    public JLabel getLblCodCarrito() {
        return LblCodCarrito;
    }

    public void setLblCodCarrito(JLabel lblCodCarrito) {
        LblCodCarrito = lblCodCarrito;
    }

    public CarritoDAO getCarritoDAO() {
        return carritoDAO;
    }

    public void setCarritoDAO(CarritoDAO carritoDAO) {
        this.carritoDAO = carritoDAO;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void cargargaDatosBusqueda(List<Carrito> carritos) {
        modelo.setNumRows(0);
        for (Carrito carrito : carritos) {
            Object[] fila = {
                    carrito.getCodigo(),
                    carrito.getFechaFormateada(),
                    carrito.getUsuario().getUsername(),
                    carrito.calcularSubtotal(),
                    carrito.calcularTotal()
            };
            modelo.addRow(fila);
        }
    }

    public void buscarPorCodigoCarrito(int codigo) {
        codigo = Integer.parseInt(TxtCarrito.getText());
        Carrito carrito = carritoDAO.buscarPorCodigo(codigo);
        if (carrito == null && getTxtCarrito().getText().isEmpty()) {
            mostrarMensaje("No existe el carrito");
        } else  {
            cargargaDatosBusqueda(List.of(carrito));
        }
    }

    public boolean confirmarEliminacion() {
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar el carrito?",
                "Confirmación", JOptionPane.YES_NO_OPTION);
        return respuesta == JOptionPane.YES_OPTION;
    }

    public void limpiarCampos() {
        TxtCarrito.setText("");
        modelo.setRowCount(0);
    }
}
