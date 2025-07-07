package ec.edu.ups.vista.carrito;

import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class CarritoListarView extends JInternalFrame {
    private JPanel panelPrincipal;
    private JTextField TxtCodigo;
    private JButton BtnBuscar;
    private JButton BtnListar;
    private JLabel LblCodigo;
    private JTable TblCarritos;
    private JLabel LblTitulo;
    private DefaultTableModel modelo;
    private MensajeInternacionalizacionHandler mI;

    public CarritoListarView(MensajeInternacionalizacionHandler mI) {
        setContentPane(panelPrincipal);
        setTitle("Listar Carritos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setClosable(true);
        setResizable(true);
        this.mI = mI;
        modelo = new DefaultTableModel();
        Object[] columnas = {"Código","Fecha","Usuario","Subtotal","Total"};
        modelo.setColumnIdentifiers(columnas);
        TblCarritos.setModel(modelo);
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

    public JButton getBtnListar() {
        return BtnListar;
    }

    public void setBtnListar(JButton btnListar) {
        BtnListar = btnListar;
    }

    public JLabel getLblCodigo() {
        return LblCodigo;
    }

    public void setLblCodigo(JLabel lblCodigo) {
        LblCodigo = lblCodigo;
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

    public void cargargaDatosLista(List<Carrito> carritos) {
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

    public void cambiarIdioma(String lenguaje, String pais) {
        mI.setLenguaje(lenguaje, pais);

        setTitle(mI.get("ventana.carrito.listar.titulo"));
        LblTitulo.setText(mI.get("ventana.carrito.listar.titulo"));
        LblCodigo.setText(mI.get("ventana.carrito.listar.codigo"));

        BtnBuscar.setText(mI.get("ventana.carrito.listar.buscar"));
        BtnListar.setText(mI.get("ventana.carrito.listar.listar"));

        Object[] columnas = {
                mI.get("ventana.carrito.listar.tabla.codigo"),
                mI.get("ventana.carrito.listar.tabla.fecha"),
                mI.get("ventana.carrito.listar.tabla.usuario"),
                mI.get("ventana.carrito.listar.tabla.subtotal"),
                mI.get("ventana.carrito.listar.tabla.total")
        };
        modelo.setColumnIdentifiers(columnas);
        TblCarritos.getTableHeader().repaint();
    }


    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}