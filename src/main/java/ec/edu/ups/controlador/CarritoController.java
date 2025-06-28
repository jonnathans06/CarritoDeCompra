package ec.edu.ups.controlador;

import ec.edu.ups.dao.CarritoDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Carrito;
import ec.edu.ups.modelo.ItemCarrito;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.vista.carrito.*;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CarritoController {

    private final CarritoDAO carritoDAO;
    private final ProductoDAO productoDAO;
    private final CarritoAnadirView carritoAnadirView;
    private final CarritoListarView carritoListarView;
    private final CarritoActualizarView carritoActualizarView;
    private final CarritoEliminarView carritoEliminarView;
    private final CarritoMostrarDetallesView carritoMostrarDetallesView;
    private Carrito carrito;

    public CarritoController(CarritoDAO carritoDAO,
                             ProductoDAO productoDAO,
                             CarritoAnadirView carritoAnadirView,
                             CarritoListarView carritoListarView,
                             CarritoActualizarView carritoActualizarView,
                             CarritoEliminarView carritoEliminarView,
                             CarritoMostrarDetallesView carritoMostrarDetallesView) {
        this.carritoDAO = carritoDAO;
        this.productoDAO = productoDAO;
        this.carritoAnadirView = carritoAnadirView;
        this.carritoListarView = carritoListarView;
        this.carritoActualizarView = carritoActualizarView;
        this.carritoEliminarView = carritoEliminarView;
        this.carritoMostrarDetallesView = carritoMostrarDetallesView;
        this.carrito = carritoAnadirView.getCarrito();
        configurarEventosEnVistas();
        confiurarEventosDetalles();
        configurarEventosActualizar();
        configuraEventosEliminar();
    }

    private void configurarEventosEnVistas() {
        carritoAnadirView.getBtnAnadir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                anadirProducto();
            }
        });

        carritoAnadirView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProductoPorCodigo();
            }
        });

        carritoAnadirView.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carritoAnadirView.getTxtCodigo().getText().equals("")) {
                    carritoAnadirView.mostrarMensaje("Debe ingresar el codigo.");
                } else {
                    guardarCarrito();
                    System.out.println(carritoDAO.listarTodos());
                }
            }
        });

        carritoAnadirView.getBtnLimpiar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vaciarCarrito();
            }
        });

        carritoListarView.getBtnListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carritoDAO == null) {
                    carritoListarView.mostrarMensaje("No hay carritos registrados.");
                }
                else {
                    carritoListarView.cargargaDatosLista(carritoDAO.listarTodos());
                }
            }
        });

        carritoListarView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carritoDAO == null) {
                    carritoListarView.mostrarMensaje("No hay carritos registrados.");
                }
                else {
                    int codigo = Integer.parseInt(carritoListarView.getTxtCodigo().getText());
                    Carrito carrito = carritoDAO.buscarPorCodigo(codigo);
                    carritoListarView.cargargaDatosBusqueda(List.of(carrito));
                }
            }
        });
    }

    private void configuraEventosEliminar() {
        carritoEliminarView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (carritoDAO == null) {
                    carritoEliminarView.mostrarMensaje("No hay carritos registrados.");
                }
                else {
                    int codigo = Integer.parseInt(carritoEliminarView.getTxtCarrito().getText());
                    Carrito carrito = carritoDAO.buscarPorCodigo(codigo);
                    carritoEliminarView.cargargaDatosBusqueda(List.of(carrito));
                }
            }
        });
        carritoEliminarView.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo = Integer.parseInt(carritoEliminarView.getTxtCarrito().getText());
                Carrito carrito = carritoDAO.buscarPorCodigo(codigo);
                boolean confirmacion = carritoEliminarView.confirmarEliminacion();
                if (confirmacion && carrito == null) {
                    carritoEliminarView.mostrarMensaje("No existe el carrito");
                } else {
                    carritoDAO.eliminar(codigo);
                    carritoEliminarView.mostrarMensaje("Carrito eliminado correctamente");
                    carritoEliminarView.limpiarCampos();
                }
            }
        });
    }

    private void configurarEventosActualizar() {

    }

    private void confiurarEventosDetalles(){
        carritoMostrarDetallesView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigo = carritoMostrarDetallesView.getTxtCodigoCarrito().getText();
                Carrito carrito = carritoDAO.buscarPorCodigo(Integer.parseInt(codigo));
                if (carrito == null) {
                    carritoMostrarDetallesView.mostrarMensaje("No existe el carrito");
                } else {
                    carritoMostrarDetallesView.cargarDatosCarrito(List.of(carrito));
                }
            }
        });
    }

    private void buscarProductoPorCodigo() {
        int codigo = Integer.parseInt(carritoAnadirView.getTxtCodigo().getText());
        Producto producto = productoDAO.buscarPorCodigo(codigo);
        if (producto == null) {
            carritoAnadirView.mostrarMensaje("No se encontro el producto");
            carritoAnadirView.getTxtNombre().setText("");
            carritoAnadirView.getTxtPrecio().setText("");
        } else {
            carritoAnadirView.getTxtNombre().setText(producto.getNombre());
            carritoAnadirView.getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
        }

    }

    private void guardarCarrito() {
        carrito.setUsuario(carritoAnadirView.getCarrito().getUsuario());
        carritoDAO.crear(carritoAnadirView.getCarrito());
        carritoAnadirView.mostrarMensaje("Carrito creado correctamente");
        limpiarCampos();
        carritoAnadirView.setCarrito(new Carrito(carritoAnadirView.getCarrito().getUsuario()));
        System.out.println(carritoDAO.listarTodos());
    }

    private void anadirProducto() {
        int codigo = Integer.parseInt(carritoAnadirView.getTxtCodigo().getText());
        Producto producto = productoDAO.buscarPorCodigo(codigo);
        int cantidad =  Integer.parseInt(carritoAnadirView.getCbxCantidad().getSelectedItem().toString());
        carritoAnadirView.getCarrito().agregarProducto(producto, cantidad);

        cargarProductos();
        mostrarTotales();

    }

    private void cargarProductos(){

        List<ItemCarrito> items = carritoAnadirView.getCarrito().obtenerItems();
        DefaultTableModel modelo = (DefaultTableModel) carritoAnadirView.getTblProductos().getModel();
        modelo.setNumRows(0);
        for (ItemCarrito item : items) {
            modelo.addRow(new Object[]{ item.getProducto().getCodigo(),
                    item.getProducto().getNombre(),
                    item.getProducto().getPrecio(),
                    item.getCantidad(),
                    item.getProducto().getPrecio() * item.getCantidad() });
        }
    }

    private void mostrarTotales(){
        String subtotal = String.valueOf(carritoAnadirView.getCarrito().calcularSubtotal());
        String iva = String.valueOf(carritoAnadirView.getCarrito().calcularIVA());
        String total = String.valueOf(carritoAnadirView.getCarrito().calcularTotal());

        carritoAnadirView.getTxtSubtotal().setText(subtotal);
        carritoAnadirView.getTxtIva().setText(iva);
        carritoAnadirView.getTxtTotal().setText(total);
    }

    public void vaciarCarrito() {
        carrito.vaciarCarrito();
        cargarProductos();
        mostrarTotales();
    }

    public void limpiarCampos () {
        carritoAnadirView.getTxtCodigo().setText("");
        carritoAnadirView.getTxtNombre().setText("");
        carritoAnadirView.getTxtPrecio().setText("");
        carritoAnadirView.getCbxCantidad().setSelectedIndex(0);
        carritoAnadirView.getTxtSubtotal().setText("");
        carritoAnadirView.getTxtIva().setText("");
        carritoAnadirView.getTxtTotal().setText("");
        DefaultTableModel modelo = (DefaultTableModel) carritoAnadirView.getTblProductos().getModel();
        modelo.setNumRows(0);
    }
}