package ec.edu.ups.vista.carrito;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CarritoActualizarView extends JInternalFrame {
    private JPanel panelPrincipal;
    private JTextField TxtCodigo;
    private JButton BtnBuscar;
    private JTable TblProductos;
    private JComboBox CbxCantidad;
    private JButton BtnGuardar;
    private JButton BtnCancelar;
    DefaultTableModel modelo;

    public CarritoActualizarView() {
        setContentPane(panelPrincipal);
        setTitle("Actualizar Carrito");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 350);
        setClosable(true);
        setResizable(true);
        setIconifiable(true);

        modelo = new DefaultTableModel(new Object[]{"Código", "Producto", "Cantidad", "Total"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        TblProductos.setModel(modelo);
    }

}
