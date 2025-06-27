package ec.edu.ups.vista.carrito;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CarritoEliminarView extends JInternalFrame{
    private JPanel panelPrincipal;
    private JTextField TxtCarrito;
    private JButton BtnBuscar;
    private JButton BtnListar;
    private JButton BtnEliminar;
    private JTable TblCarritos;
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
        Object[] columnas = {"Código", "Fecha", "Productos", "Usuario", "Total"};
        modelo.setColumnIdentifiers(columnas);
        TblCarritos.setModel(modelo);
    }


}
