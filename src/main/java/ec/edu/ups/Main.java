package ec.edu.ups;

import ec.edu.ups.controlador.CarritoController;
import ec.edu.ups.controlador.ProductoController;
import ec.edu.ups.controlador.UsuarioController;
import ec.edu.ups.dao.CarritoDAO;
import ec.edu.ups.dao.PreguntasDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.dao.impl.CarritoDAOMemoria;
import ec.edu.ups.dao.impl.PreguntasDAOMemoria;
import ec.edu.ups.dao.impl.ProductoDAOMemoria;
import ec.edu.ups.dao.impl.UsuarioDAOMemoria;
import ec.edu.ups.modelo.Rol;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.util.MensajeInternacionalizacionHandler;
import ec.edu.ups.vista.*;
import ec.edu.ups.vista.carrito.*;
import ec.edu.ups.vista.login.LoginView;
import ec.edu.ups.vista.login.RecuperacionView;
import ec.edu.ups.vista.login.RegistroPreguntasView;
import ec.edu.ups.vista.login.RegistroView;
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

        MensajeInternacionalizacionHandler mI = new MensajeInternacionalizacionHandler("es", "EC");
        UsuarioDAO usuarioDAO = new UsuarioDAOMemoria();
        LoginView loginView = new LoginView(mI);
        ProductoDAO productoDAO = new ProductoDAOMemoria();
        CarritoDAO carritoDAO = new CarritoDAOMemoria();
        PreguntasDAO preguntasDAO = new PreguntasDAOMemoria();


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                UsuarioCrearView usuarioCrearView = new UsuarioCrearView(usuarioDAO, mI);
                UsuarioListarView usuarioListarView = new UsuarioListarView(mI);
                UsuarioActualizarView usuarioActualizarView = new UsuarioActualizarView(usuarioDAO, mI);
                UsuarioEliminarView  usuarioEliminarView = new UsuarioEliminarView(mI);
                RegistroView registroView = new RegistroView(mI);
                RegistroPreguntasView registroPreguntasView = new RegistroPreguntasView(preguntasDAO, mI);
                RecuperacionView recuperacionView = new RecuperacionView(usuarioDAO, mI);
                loginView.setVisible(true);
                registroView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                registroPreguntasView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                registroView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());

                UsuarioController usuarioController = new UsuarioController(usuarioDAO, loginView,
                                                                            usuarioCrearView, usuarioListarView,
                                                                            usuarioActualizarView, usuarioEliminarView,
                                                                            registroView, preguntasDAO,
                                                                            registroPreguntasView, recuperacionView, mI);

                loginView.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {

                        Usuario usuarioAuntenticado = usuarioController.getUsuarioAutenticado();
                        if (usuarioAuntenticado != null) {

                            //Instancia Vistas
                            MenuPrincipalView principalView = new MenuPrincipalView(mI);
                            ProductoAnadirView productoAnadirView = new ProductoAnadirView(mI);
                            ProductoListaView productoListaView = new ProductoListaView(mI);
                            ProductoActualizarView productoActualizarView = new ProductoActualizarView(mI);
                            ProductoEliminarView productoEliminarView = new ProductoEliminarView(mI);

                            CarritoAnadirView carritoAnadirView = new CarritoAnadirView(usuarioAuntenticado, mI);
                            CarritoListarView carritoListarView = new CarritoListarView(mI);
                            CarritoActualizarView carritoActualizarView = new CarritoActualizarView(carritoDAO, mI);
                            CarritoEliminarView carritoEliminarView = new CarritoEliminarView(mI);
                            CarritoMostrarDetallesView carritoMostrarDetallesView = new CarritoMostrarDetallesView(mI);

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
                                        principalView.getMiDesktopPane().add(productoAnadirView);
                                    }
                                }
                            });

                            principalView.getMenuItemBuscarProducto().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if(!productoListaView.isVisible()){
                                        productoListaView.setVisible(true);
                                        principalView.getMiDesktopPane().add(productoListaView);
                                    }
                                }
                            });

                            principalView.getMenuItemEliminarProducto().addActionListener(new ActionListener() {

                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!productoEliminarView.isVisible()) {
                                        productoEliminarView.setVisible(true);
                                        principalView.getMiDesktopPane().add(productoEliminarView);
                                    }
                                }
                            });

                            principalView.getMenuItemActualizarProducto().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!productoActualizarView.isVisible()) {
                                        productoActualizarView.setVisible(true);
                                        principalView.getMiDesktopPane().add(productoActualizarView);
                                    }
                                }
                            });

                            principalView.getMenuItemCrearCarrito().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if(!carritoAnadirView.isVisible()){
                                        carritoAnadirView.setVisible(true);
                                        principalView.getMiDesktopPane().add(carritoAnadirView);
                                    }
                                }
                            });

                            principalView.getMenuItemActualizarCarrito().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if(!carritoListarView.isVisible()){
                                        carritoActualizarView.setVisible(true);
                                        principalView.getMiDesktopPane().add(carritoActualizarView);
                                    }
                                }
                            });

                            principalView.getMenuItemListarCarritos().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if(!productoListaView.isVisible()){
                                        carritoListarView.setVisible(true);
                                        principalView.getMiDesktopPane().add(carritoListarView);
                                    }
                                }
                            });

                            principalView.getMenuItemDetalleCarrito().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!carritoMostrarDetallesView.isVisible()) {
                                        carritoMostrarDetallesView.setVisible(true);
                                        principalView.getMiDesktopPane().add(carritoMostrarDetallesView);
                                    }
                                }
                            });

                            principalView.getMenuItemCrearUsuario().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!usuarioCrearView.isVisible()) {
                                        usuarioCrearView.setVisible(true);
                                        principalView.getMiDesktopPane().add(usuarioCrearView);
                                    }
                                }
                            });

                            principalView.getMenuItemListarUsuario().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!usuarioListarView.isVisible()) {
                                        usuarioListarView.setVisible(true);
                                        principalView.getMiDesktopPane().add(usuarioListarView);
                                    }
                                }
                            });

                            principalView.getMenuItemActualizarUsuario().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!usuarioActualizarView.isVisible()) {
                                        usuarioActualizarView.setVisible(true);
                                        principalView.getMiDesktopPane().add(usuarioActualizarView);
                                    }
                                }
                            });

                            principalView.getMenuItemEliminarUsuario().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    if (!usuarioEliminarView.isVisible()) {
                                        usuarioEliminarView.setVisible(true);
                                        principalView.getMiDesktopPane().add(usuarioEliminarView);
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
                                        principalView.getMiDesktopPane().add(carritoEliminarView);
                                    }
                                }
                            });

                            principalView.getMenuItemEspanol().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    principalView.cambiarIdiomaEspanol("es", "EC");
                                    carritoAnadirView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    carritoActualizarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    carritoListarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    carritoMostrarDetallesView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    carritoEliminarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    productoAnadirView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    productoActualizarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    productoListaView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    productoEliminarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    usuarioCrearView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    usuarioActualizarView.cambiarIdioma(principalView.getLocale().getLanguage(), mI.getLocale().getCountry());
                                }
                            });

                            principalView.getMenuItemIngles().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    principalView.cambiarIdiomaIngles("en", "US");
                                    carritoAnadirView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    carritoActualizarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    carritoListarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    carritoMostrarDetallesView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    carritoEliminarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    productoAnadirView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    productoActualizarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    productoListaView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    productoEliminarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    usuarioCrearView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    usuarioActualizarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    usuarioListarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    usuarioEliminarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                }
                            });

                            principalView.getMenuItemFrances().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    principalView.cambiarIdiomaFrances("fr", "FR");
                                    carritoAnadirView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    carritoActualizarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    carritoListarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    carritoMostrarDetallesView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    carritoEliminarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    productoAnadirView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    productoActualizarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    productoListaView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    productoEliminarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    usuarioCrearView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    usuarioActualizarView.cambiarIdioma(principalView.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    usuarioListarView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                    usuarioCrearView.cambiarIdioma(mI.getLocale().getLanguage(), mI.getLocale().getCountry());
                                }
                            });

                        }
                    }
                });
            }
        });
    }
}
