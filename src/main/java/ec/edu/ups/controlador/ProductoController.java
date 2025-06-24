package ec.edu.ups.controlador;

import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.vista.CarritoAnadirView;
import ec.edu.ups.vista.ProductoAnadirView;
import ec.edu.ups.vista.ProductoEliminarView;
import ec.edu.ups.vista.ProductoListaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductoController {

    private final ProductoAnadirView productoAnadirView;
    private final ProductoListaView productoListaView;
    private final ProductoEliminarView productoEliminarView;
    private final CarritoAnadirView carritoAnadirView;

    private final ProductoDAO productoDAO;

    public ProductoController(ProductoDAO productoDAO,
                              ProductoAnadirView productoAnadirView,
                              ProductoListaView productoListaView,
                              ProductoEliminarView productoEliminarView,
                              CarritoAnadirView carritoAnadirView) {

        this.productoDAO = productoDAO;
        this.productoAnadirView = productoAnadirView;
        this.productoListaView = productoListaView;
        this.productoEliminarView = productoEliminarView;
        this.carritoAnadirView = carritoAnadirView;
        this.configurarEventosEnVistas();
    }

    private void configurarEventosEnVistas() {
        productoAnadirView.getBtnAceptar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarProducto();
            }
        });

        productoEliminarView.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });

        productoEliminarView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProductoPorCodigoEliminar();
            }
        });

        productoListaView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProductoListar();
            }
        });

        productoListaView.getBtnListar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProductos();
            }
        });

        carritoAnadirView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProductoPorCodigo();
            }
        });
    }

    private void guardarProducto() {
        int codigo = Integer.parseInt(productoAnadirView.getTxtCodigo().getText());
        String nombre = productoAnadirView.getTxtNombre().getText();
        double precio = Double.parseDouble(productoAnadirView.getTxtPrecio().getText());

        productoDAO.crear(new Producto(codigo, nombre, precio));
        productoAnadirView.mostrarMensaje("Producto guardado correctamente");
        productoAnadirView.limpiarCampos();
        productoAnadirView.mostrarProductos(productoDAO.listarTodos());
    }

    private void buscarProductoListar() {
        int codigo = Integer.parseInt(productoListaView.getTxtBuscar().getText());
        Producto producto = productoDAO.buscarPorCodigo(codigo);
        if (producto == null) {
            productoListaView.mostrarMensaje("No se encontro el producto");
        } else {
            productoListaView.cargarDatos(List.of(producto));
        }
    }

    private void listarProductos() {
        List<Producto> productos = productoDAO.listarTodos();
        productoListaView.cargarDatos(productos);
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

    private void buscarProductoPorCodigoEliminar() {
        int codigo = Integer.parseInt(productoEliminarView.getTxtCodigo().getText());
        Producto producto = productoDAO.buscarPorCodigo(codigo);
        if (producto == null) {
            productoEliminarView.mostrarMensaje("No se encontro el producto");
        } else {
            productoEliminarView.cargarDatos(List.of(producto));
        }
    }

    private void eliminarProducto() {
        int codigo = Integer.parseInt(productoEliminarView.getTxtCodigo().getText());
        Producto producto = productoDAO.buscarPorCodigo(codigo);
        boolean confirmacion =  productoEliminarView.confirmarEliminacion();

        if (confirmacion && producto != null) {
            productoDAO.eliminar(codigo);
            productoEliminarView.mostrarMensaje("Producto eliminado correctamente");
            productoEliminarView.limpiarCampos();
        } else {
            productoEliminarView.mostrarMensaje("Producto no encontrado");
        }
    }
}