package ec.edu.ups.controlador;

import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;
import ec.edu.ups.vista.producto.ProductoActualizarView;
import ec.edu.ups.vista.producto.ProductoAnadirView;
import ec.edu.ups.vista.producto.ProductoEliminarView;
import ec.edu.ups.vista.producto.ProductoListaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProductoController {

    private final ProductoAnadirView productoAnadirView;
    private final ProductoListaView productoListaView;
    private final ProductoActualizarView productoActualizarView;
    private final ProductoEliminarView productoEliminarView;
    MensajeInternacionalizacionHandler mI;

    private final ProductoDAO productoDAO;

    public ProductoController(ProductoDAO productoDAO,
                              ProductoAnadirView productoAnadirView,
                              ProductoListaView productoListaView,
                              ProductoActualizarView productoActualizarView,
                              ProductoEliminarView productoEliminarView) {

        this.productoDAO = productoDAO;
        this.productoAnadirView = productoAnadirView;
        this.productoListaView = productoListaView;
        this.productoActualizarView = productoActualizarView;
        this.productoEliminarView = productoEliminarView;
        //this.carritoAnadirView = carritoAnadirView;
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


        productoActualizarView.getBtnBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarProductoPorCodigoActualizar();
            }
        });

        productoActualizarView.getBtnEditar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editarValoresActualizar();
            }
        });

        productoActualizarView.getBtnGuardar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();
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

    public void buscarProductoPorCodigoActualizar() {
        int codigo = Integer.parseInt(productoActualizarView.getTxtCodigoBusqueda().getText());
        Producto producto = productoDAO.buscarPorCodigo(codigo);
        if (producto == null) {
            productoActualizarView.mostrarMensaje("No se encontro el producto");
            productoActualizarView.getTxtNombre().setText("");
            productoActualizarView.getTxtPrecio().setText("");
        } else {
            productoActualizarView.getTxtCodigo().setText(String.valueOf(producto.getCodigo()));
            productoActualizarView.getTxtNombre().setText(producto.getNombre());
            productoActualizarView.getTxtPrecio().setText(String.valueOf(producto.getPrecio()));
        }
    }

    public void actualizarProducto() {
        int codigo = Integer.parseInt(productoActualizarView.getTxtCodigo().getText());
        String nombre = productoActualizarView.getTxtNombre().getText();
        double precio = Double.parseDouble(productoActualizarView.getTxtPrecio().getText());
        boolean confirmacion = productoActualizarView.confirmarEliminacion(mI);

        if (confirmacion) {
            Producto producto = new Producto(codigo, nombre, precio);
            productoDAO.actualizar(producto);
            productoActualizarView.mostrarMensaje("Producto actualizado correctamente");
            productoActualizarView.limpiarCampos();
        } else  {
            productoActualizarView.mostrarMensaje("No se actualizó el producto");
        }

    }

    public void editarValoresActualizar() {
        productoActualizarView.getTxtNombre().setEnabled(true);
        productoActualizarView.getTxtPrecio().setEnabled(true);
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