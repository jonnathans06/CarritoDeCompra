package ec.edu.ups;

import ec.edu.ups.controlador.CarritoController;
import ec.edu.ups.controlador.ProductoController;
import ec.edu.ups.controlador.UsuarioController;
import ec.edu.ups.dao.CarritoDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.dao.impl.CarritoDAOMemoria;
import ec.edu.ups.dao.impl.ProductoDAOMemoria;
import ec.edu.ups.dao.impl.UsuarioDAOMemoria;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;
import ec.edu.ups.vista.*;
import ec.edu.ups.vista.carrito.*;
import ec.edu.ups.vista.login.LoginView;
import ec.edu.ups.vista.producto.ProductoActualizarView;
import ec.edu.ups.vista.producto.ProductoAnadirView;
import ec.edu.ups.vista.producto.ProductoEliminarView;
import ec.edu.ups.vista.producto.ProductoListaView;
import ec.edu.ups.vista.usuario.UsuarioActualizarView;
import ec.edu.ups.vista.usuario.UsuarioCrearView;
import ec.edu.ups.vista.usuario.UsuarioEliminarView;
import ec.edu.ups.vista.usuario.UsuarioListarView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAOMemoria();
        LoginView loginView = new LoginView();
        ProductoDAO productoDAO = new ProductoDAOMemoria();
        CarritoDAO carritoDAO = new CarritoDAOMemoria();

        MensajeInternacionalizacionHandler mI = new MensajeInternacionalizacionHandler("es", "EC");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                UsuarioCrearView usuarioCrearView = new UsuarioCrearView(usuarioDAO);
                UsuarioListarView usuarioListarView = new UsuarioListarView();
                UsuarioActualizarView usuarioActualizarView = new UsuarioActualizarView(usuarioDAO);
                UsuarioEliminarView  usuarioEliminarView = new UsuarioEliminarView();
                loginView.setVisible(true);

                UsuarioController usuarioController = new UsuarioController(usuarioDAO, loginView,
                                                                            usuarioCrearView, usuarioListarView,
                                                                            usuarioActualizarView, usuarioEliminarView);

                loginView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {

                        Usuario usuarioAuntenticado = usuarioController.getUsuarioAutenticado();
                        if (usuarioAuntenticado != null) {
                            //instanciamos DAO (Singleton)

                            //instancio Vistas
                            MenuPrincipalView principalView = new MenuPrincipalView(mI);
                            ProductoAnadirView productoAnadirView = new ProductoAnadirView();
                            ProductoListaView productoListaView = new ProductoListaView();
                            ProductoActualizarView productoActualizarView = new ProductoActualizarView();
                            ProductoEliminarView productoEliminarView = new ProductoEliminarView();

                            CarritoAnadirView carritoAnadirView = new CarritoAnadirView(usuarioAuntenticado);
                            CarritoListarView carritoListarView = new CarritoListarView();
                            CarritoActualizarView carritoActualizarView = new CarritoActualizarView(carritoDAO);
                            CarritoEliminarView carritoEliminarView = new CarritoEliminarView();
                            CarritoMostrarDetallesView carritoMostrarDetallesView = new CarritoMostrarDetallesView();

                            //instanciamos Controladores
                            ProductoController productoController = new ProductoController(productoDAO, productoAnadirView,
                                    productoListaView, productoActualizarView, productoEliminarView);
                            CarritoController carritoController = new CarritoController(carritoDAO, productoDAO,
                                                                                        carritoAnadirView,
                                                                                        carritoListarView,
                                                                                        carritoActualizarView,
                                                                                        carritoEliminarView,
                                                                                        carritoMostrarDetallesView);

                            principalView.mostrarMensaje("Bienvenido: " + usuarioAuntenticado.getUsername());
                            if (usuarioAuntenticado.getRol().equals(Rol.USUARIO)) {
                                principalView.deshabilitarMenusAdministrador();
                            }

                            principalView.getMenuItemCrearProducto().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if(!productoAnadirView.isVisible()){
                                        productoAnadirView.setVisible(true);
                                        principalView.getjDesktopPane().add(productoAnadirView);
                                    }
                                }
                            });

                            principalView.getMenuItemBuscarProducto().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if(!productoListaView.isVisible()){
                                        productoListaView.setVisible(true);
                                        principalView.getjDesktopPane().add(productoListaView);
                                    }
                                }
                            });

                            principalView.getMenuItemEliminarProducto().addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!productoEliminarView.isVisible()) {
                                        productoEliminarView.setVisible(true);
                                        principalView.getjDesktopPane().add(productoEliminarView);
                                    }
                                }
                            });

                            principalView.getMenuItemActualizarProducto().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!productoActualizarView.isVisible()) {
                                        productoActualizarView.setVisible(true);
                                        principalView.getjDesktopPane().add(productoActualizarView);
                                    }
                                }
                            });

                            principalView.getMenuItemCrearCarrito().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if(!carritoAnadirView.isVisible()){
                                        carritoAnadirView.setVisible(true);
                                        principalView.getjDesktopPane().add(carritoAnadirView);
                                    }
                                }
                            });

                            principalView.getMenuItemActualizarCarrito().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if(!carritoListarView.isVisible()){
                                        carritoActualizarView.setVisible(true);
                                        principalView.getjDesktopPane().add(carritoActualizarView);
                                    }
                                }
                            });

                            principalView.getMenuItemListarCarritos().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if(!productoListaView.isVisible()){
                                        carritoListarView.setVisible(true);
                                        principalView.getjDesktopPane().add(carritoListarView);
                                    }
                                }
                            });

                            principalView.getMenuItemDetalleCarrito().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!carritoMostrarDetallesView.isVisible()) {
                                        carritoMostrarDetallesView.setVisible(true);
                                        principalView.getjDesktopPane().add(carritoMostrarDetallesView);
                                    }
                                }
                            });

                            principalView.getMenuItemCrearUsuario().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!usuarioCrearView.isVisible()) {
                                        usuarioCrearView.setVisible(true);
                                        principalView.getjDesktopPane().add(usuarioCrearView);
                                    }
                                }
                            });

                            principalView.getMenuItemListarUsuario().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!usuarioListarView.isVisible()) {
                                        usuarioListarView.setVisible(true);
                                        principalView.getjDesktopPane().add(usuarioListarView);
                                    }
                                }
                            });

                            principalView.getMenuItemActualizarUsuario().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!usuarioActualizarView.isVisible()) {
                                        usuarioActualizarView.setVisible(true);
                                        principalView.getjDesktopPane().add(usuarioActualizarView);
                                    }
                                }
                            });

                            principalView.getMenuItemEliminarUsuario().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!usuarioEliminarView.isVisible()) {
                                        usuarioEliminarView.setVisible(true);
                                        principalView.getjDesktopPane().add(usuarioEliminarView);
                                        System.out.println("Se activó");
                                    }
                                }
                            });

                            principalView.getMenuItemCerrarSesion().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    principalView.dispose();
                                    usuarioController.cerrarSesion();
                                }
                            });

                            principalView.getMenuItemEliminarCarrito().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!carritoAnadirView.isVisible()) {
                                        carritoEliminarView.setVisible(true);
                                        principalView.getjDesktopPane().add(carritoEliminarView);
                                    }
                                }
                            });

                        }
                    }
                });
            }
        });
    }
}
