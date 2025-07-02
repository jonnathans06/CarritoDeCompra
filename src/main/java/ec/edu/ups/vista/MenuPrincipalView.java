package ec.edu.ups.vista;

import ec.edu.ups.util.MensajeInternacionalizacionHandler;

import javax.swing.*;

public class MenuPrincipalView extends JFrame {
    private MensajeInternacionalizacionHandler mensajeInternacionalizacionHandler;

    private JMenuBar menuBar;

    private JMenu menuProducto;
    private JMenu menuCarrito;
    private JMenu menuUsuario;
    private JMenu menuSalir;
    private JMenu menuIdioma;

    private JMenuItem menuItemCrearProducto;
    private JMenuItem menuItemEliminarProducto;
    private JMenuItem menuItemActualizarProducto;
    private JMenuItem menuItemBuscarProducto;

    private JMenuItem menuItemCrearUsuario;
    private JMenuItem menuItemListarUsuario;
    private JMenuItem menuItemEliminarUsuario;
    private JMenuItem menuItemActualizarUsuario;

    private JMenuItem menuItemCrearCarrito;
    private JMenuItem menuItemActualizarCarrito;
    private JMenuItem menuItemListarCarritos;
    private JMenuItem menuItemDetalleCarrito;
    private JMenuItem menuItemEliminarCarrito;

    private JMenuItem menuItemCerrarSesion;

    private JMenuItem menuItemEspanol;
    private JMenuItem menuItemIngles;
    private JMenuItem menuItemFrances;

    private JDesktopPane jDesktopPane;

    public MenuPrincipalView(MensajeInternacionalizacionHandler mensajeInternacionalizacionHandler) {
        this.mensajeInternacionalizacionHandler = mensajeInternacionalizacionHandler;
        initComponents();
    }

    public void initComponents() {
        jDesktopPane = new JDesktopPane();
        menuBar = new JMenuBar();

        menuProducto = new JMenu(mensajeInternacionalizacionHandler.get("menu.producto"));
        menuCarrito = new JMenu(mensajeInternacionalizacionHandler.get("menu.carrito"));
        menuUsuario = new JMenu(mensajeInternacionalizacionHandler.get("menu.usuario"));
        menuIdioma = new JMenu(mensajeInternacionalizacionHandler.get("menu.idioma"));
        menuSalir = new JMenu(mensajeInternacionalizacionHandler.get("menu.salir"));

        menuItemCrearProducto = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.crear.producto"));
        menuItemActualizarProducto = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.actualizar.producto"));
        menuItemEliminarProducto = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.eliminar.producto"));
        menuItemBuscarProducto = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.buscar.producto"));

        menuItemCrearCarrito = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.crear.carrito"));
        menuItemListarCarritos = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.listar.carritos"));
        menuItemDetalleCarrito = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.detalle.carrito"));
        menuItemActualizarCarrito = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.actualizar.carrito"));
        menuItemEliminarCarrito = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.eliminar.carrito"));

        menuItemCrearUsuario = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.crear.usuario"));
        menuItemActualizarUsuario = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.actualizar.usuario"));
        menuItemListarUsuario = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.listar.usuario"));
        menuItemEliminarUsuario = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.eliminar.usuario"));

        menuItemCerrarSesion = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.cerrar.sesion"));

        menuItemEspanol = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.espanol"));
        menuItemIngles = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.ingles"));
        menuItemFrances = new JMenuItem(mensajeInternacionalizacionHandler.get("menu.frances"));

        menuBar.add(menuProducto);
        menuBar.add(menuCarrito);
        menuBar.add(menuUsuario);
        menuBar.add(menuIdioma);
        menuBar.add(menuSalir);

        menuProducto.add(menuItemCrearProducto);
        menuProducto.add(menuItemActualizarProducto);
        menuProducto.add(menuItemEliminarProducto);
        menuProducto.add(menuItemBuscarProducto);

        menuCarrito.add(menuItemCrearCarrito);
        menuCarrito.add(menuItemActualizarCarrito);
        menuCarrito.add(menuItemListarCarritos);
        menuCarrito.add(menuItemDetalleCarrito);
        menuCarrito.add(menuItemEliminarCarrito);

        menuUsuario.add(menuItemCrearUsuario);
        menuUsuario.add(menuItemActualizarUsuario);
        menuUsuario.add(menuItemListarUsuario);
        menuUsuario.add(menuItemEliminarUsuario);

        menuSalir.add(menuItemCerrarSesion);

        menuIdioma.add(menuItemEspanol);
        menuIdioma.add(menuItemIngles);
        menuIdioma.add(menuItemFrances);

        setJMenuBar(menuBar);
        jDesktopPane.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
        setContentPane(jDesktopPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(mensajeInternacionalizacionHandler.get("menu.titulo"));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public JMenu getMenuProducto() {
        return menuProducto;
    }

    public void setMenuProducto(JMenu menuProducto) {
        this.menuProducto = menuProducto;
    }

    public JMenu getMenuCarrito() {
        return menuCarrito;
    }

    public void setMenuCarrito(JMenu menuCarrito) {
        this.menuCarrito = menuCarrito;
    }

    public JMenu getMenuUsuario() {
        return menuUsuario;
    }

    public void setMenuUsuario(JMenu menuUsuario) {
        this.menuUsuario = menuUsuario;
    }

    public JMenuItem getMenuSalir() {
        return menuSalir;
    }

    public void setMenuSalir(JMenu menuSalir) {
        this.menuSalir = menuSalir;
    }

    public JMenuItem getMenuItemCrearProducto() {
        return menuItemCrearProducto;
    }

    public void setMenuItemCrearProducto(JMenuItem menuItemCrearProducto) {
        this.menuItemCrearProducto = menuItemCrearProducto;
    }

    public JMenuItem getMenuItemEliminarProducto() {
        return menuItemEliminarProducto;
    }

    public void setMenuItemEliminarProducto(JMenuItem menuItemEliminarProducto) {
        this.menuItemEliminarProducto = menuItemEliminarProducto;
    }

    public JMenuItem getMenuItemActualizarProducto() {
        return menuItemActualizarProducto;
    }

    public void setMenuItemActualizarProducto(JMenuItem menuItemActualizarProducto) {
        this.menuItemActualizarProducto = menuItemActualizarProducto;
    }

    public JMenuItem getMenuItemBuscarProducto() {
        return menuItemBuscarProducto;
    }

    public void setMenuItemBuscarProducto(JMenuItem menuItemBuscarProducto) {
        this.menuItemBuscarProducto = menuItemBuscarProducto;
    }

    public JMenuItem getMenuItemCrearUsuario() {
        return menuItemCrearUsuario;
    }

    public void setMenuItemCrearUsuario(JMenuItem menuItemCrearUsuario) {
        this.menuItemCrearUsuario = menuItemCrearUsuario;
    }

    public JMenuItem getMenuItemListarUsuario() {
        return menuItemListarUsuario;
    }

    public void setMenuItemListarUsuario(JMenuItem menuItemListarUsuario) {
        this.menuItemListarUsuario = menuItemListarUsuario;
    }

    public JMenuItem getMenuItemEliminarUsuario() {
        return menuItemEliminarUsuario;
    }

    public void setMenuItemEliminarUsuario(JMenuItem menuItemEliminarUsuario) {
        this.menuItemEliminarUsuario = menuItemEliminarUsuario;
    }

    public JMenuItem getMenuItemActualizarUsuario() {
        return menuItemActualizarUsuario;
    }

    public void setMenuItemActualizarUsuario(JMenuItem menuItemActualizarUsuario) {
        this.menuItemActualizarUsuario = menuItemActualizarUsuario;
    }

    public JMenuItem getMenuItemCrearCarrito() {
        return menuItemCrearCarrito;
    }

    public void setMenuItemCrearCarrito(JMenuItem menuItemCrearCarrito) {
        this.menuItemCrearCarrito = menuItemCrearCarrito;
    }

    public JMenuItem getMenuItemActualizarCarrito() {
        return menuItemActualizarCarrito;
    }

    public void setMenuItemActualizarCarrito(JMenuItem menuItemActualizarCarrito) {
        this.menuItemActualizarCarrito = menuItemActualizarCarrito;
    }

    public JMenuItem getMenuItemDetalleCarrito() {
        return menuItemDetalleCarrito;
    }

    public void setMenuItemDetalleCarrito(JMenuItem menuItemDetalleCarrito) {
        this.menuItemDetalleCarrito = menuItemDetalleCarrito;
    }

    public JMenuItem getMenuItemListarCarritos() {
        return menuItemListarCarritos;
    }

    public void setMenuItemListarCarritos(JMenuItem menuItemListarCarritos) {
        this.menuItemListarCarritos = menuItemListarCarritos;
    }

    public JMenuItem getMenuItemEliminarCarrito() {
        return menuItemEliminarCarrito;
    }

    public void setMenuItemEliminarCarrito(JMenuItem menuItemEliminarCarrito) {
        this.menuItemEliminarCarrito = menuItemEliminarCarrito;
    }

    public JMenuItem getMenuItemCerrarSesion() {
        return menuItemCerrarSesion;
    }

    public void setMenuItemCerrarSesion(JMenuItem menuItemCerrarSesion) {
        this.menuItemCerrarSesion = menuItemCerrarSesion;
    }

    public JMenu getMenuIdioma() {
        return menuIdioma;
    }

    public void setMenuIdioma(JMenu menuIdioma) {
        this.menuIdioma = menuIdioma;
    }

    public JMenuItem getMenuItemEspanol() {
        return menuItemEspanol;
    }

    public void setMenuItemEspanol(JMenuItem menuItemEspanol) {
        this.menuItemEspanol = menuItemEspanol;
    }

    public JMenuItem getMenuItemIngles() {
        return menuItemIngles;
    }

    public void setMenuItemIngles(JMenuItem menuItemIngles) {
        this.menuItemIngles = menuItemIngles;
    }

    public JMenuItem getMenuItemFrances() {
        return menuItemFrances;
    }

    public void setMenuItemFrances(JMenuItem menuItemFrances) {
        this.menuItemFrances = menuItemFrances;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public JDesktopPane getjDesktopPane() {
        return jDesktopPane;
    }

    public void setjDesktopPane(JDesktopPane jDesktopPane) {
        this.jDesktopPane = jDesktopPane;
    }

    public void deshabilitarMenusAdministrador() {
        getMenuItemCrearProducto().setEnabled(false);
        getMenuItemBuscarProducto().setEnabled(false);
        getMenuItemActualizarProducto().setEnabled(false);
        getMenuItemEliminarProducto().setEnabled(false);
        getMenuItemListarCarritos().setEnabled(false);
        getMenuItemCrearUsuario().setEnabled(false);
        getMenuItemListarUsuario().setEnabled(false);
        getMenuItemActualizarUsuario().setEnabled(false);
        getMenuItemEliminarUsuario().setEnabled(false);
    }

    public void cambiarIdiomaEspanol(String lenguaje,String pais) {
        mensajeInternacionalizacionHandler.setLenguaje(lenguaje, pais);

        menuProducto.setText(mensajeInternacionalizacionHandler.get("menu.producto"));
        menuCarrito.setText(mensajeInternacionalizacionHandler.get("menu.carrito"));
        menuUsuario.setText(mensajeInternacionalizacionHandler.get("menu.usuario"));
        menuIdioma.setText(mensajeInternacionalizacionHandler.get("menu.idioma"));
        menuSalir.setText(mensajeInternacionalizacionHandler.get("menu.salir"));

        menuItemCrearProducto.setText(mensajeInternacionalizacionHandler.get("menu.crear.producto"));
        menuItemActualizarProducto.setText(mensajeInternacionalizacionHandler.get("menu.actualizar.producto"));
        menuItemEliminarProducto.setText(mensajeInternacionalizacionHandler.get("menu.eliminar.producto"));
        menuItemBuscarProducto.setText(mensajeInternacionalizacionHandler.get("menu.buscar.producto"));

        menuItemCrearCarrito.setText(mensajeInternacionalizacionHandler.get("menu.crear.carrito"));
        menuItemActualizarCarrito.setText(mensajeInternacionalizacionHandler.get("menu.actualizar.carrito"));
        menuItemListarCarritos.setText(mensajeInternacionalizacionHandler.get("menu.listar.carritos"));
        menuItemDetalleCarrito.setText(mensajeInternacionalizacionHandler.get("menu.detalle.carrito"));
        menuItemEliminarCarrito.setText(mensajeInternacionalizacionHandler.get("menu.eliminar.carrito"));

        menuItemCrearUsuario.setText(mensajeInternacionalizacionHandler.get("menu.crear.usuario"));
        menuItemActualizarUsuario.setText(mensajeInternacionalizacionHandler.get("menu.actualizar.usuario"));
        menuItemListarUsuario.setText(mensajeInternacionalizacionHandler.get("menu.listar.usuario"));
        menuItemEliminarUsuario.setText(mensajeInternacionalizacionHandler.get("menu.eliminar.usuario"));
        menuItemCerrarSesion.setText(mensajeInternacionalizacionHandler.get("menu.cerrar.sesion"));

        menuItemEspanol.setText(mensajeInternacionalizacionHandler.get("menu.espanol"));
        menuItemIngles.setText(mensajeInternacionalizacionHandler.get("menu.ingles"));
        menuItemFrances.setText(mensajeInternacionalizacionHandler.get("menu.frances"));
    }

    public void cambiarIdiomaIngles(String lenguaje,String pais) {
        mensajeInternacionalizacionHandler.setLenguaje(lenguaje, pais);

        menuProducto.setText(mensajeInternacionalizacionHandler.get("menu.producto"));
        menuCarrito.setText(mensajeInternacionalizacionHandler.get("menu.carrito"));
        menuUsuario.setText(mensajeInternacionalizacionHandler.get("menu.usuario"));
        menuIdioma.setText(mensajeInternacionalizacionHandler.get("menu.idioma"));
        menuSalir.setText(mensajeInternacionalizacionHandler.get("menu.salir"));

        menuItemCrearProducto.setText(mensajeInternacionalizacionHandler.get("menu.crear.producto"));
        menuItemActualizarProducto.setText(mensajeInternacionalizacionHandler.get("menu.actualizar.producto"));
        menuItemEliminarProducto.setText(mensajeInternacionalizacionHandler.get("menu.eliminar.producto"));
        menuItemBuscarProducto.setText(mensajeInternacionalizacionHandler.get("menu.buscar.producto"));

        menuItemCrearCarrito.setText(mensajeInternacionalizacionHandler.get("menu.crear.carrito"));
        menuItemActualizarCarrito.setText(mensajeInternacionalizacionHandler.get("menu.actualizar.carrito"));
        menuItemListarCarritos.setText(mensajeInternacionalizacionHandler.get("menu.listar.carritos"));
        menuItemDetalleCarrito.setText(mensajeInternacionalizacionHandler.get("menu.detalle.carrito"));
        menuItemEliminarCarrito.setText(mensajeInternacionalizacionHandler.get("menu.eliminar.carrito"));

        menuItemCrearUsuario.setText(mensajeInternacionalizacionHandler.get("menu.crear.usuario"));
        menuItemActualizarUsuario.setText(mensajeInternacionalizacionHandler.get("menu.actualizar.usuario"));
        menuItemListarUsuario.setText(mensajeInternacionalizacionHandler.get("menu.listar.usuario"));
        menuItemEliminarUsuario.setText(mensajeInternacionalizacionHandler.get("menu.eliminar.usuario"));
        menuItemCerrarSesion.setText(mensajeInternacionalizacionHandler.get("menu.cerrar.sesion"));

        menuItemEspanol.setText(mensajeInternacionalizacionHandler.get("menu.espanol"));
        menuItemIngles.setText(mensajeInternacionalizacionHandler.get("menu.ingles"));
        menuItemFrances.setText(mensajeInternacionalizacionHandler.get("menu.frances"));
    }

    public void cambiarIdiomaFrances(String lenguaje,String pais) {
        mensajeInternacionalizacionHandler.setLenguaje(lenguaje, pais);

        menuProducto.setText(mensajeInternacionalizacionHandler.get("menu.producto"));
        menuCarrito.setText(mensajeInternacionalizacionHandler.get("menu.carrito"));
        menuUsuario.setText(mensajeInternacionalizacionHandler.get("menu.usuario"));
        menuIdioma.setText(mensajeInternacionalizacionHandler.get("menu.idioma"));
        menuSalir.setText(mensajeInternacionalizacionHandler.get("menu.salir"));

        menuItemCrearProducto.setText(mensajeInternacionalizacionHandler.get("menu.crear.producto"));
        menuItemActualizarProducto.setText(mensajeInternacionalizacionHandler.get("menu.actualizar.producto"));
        menuItemEliminarProducto.setText(mensajeInternacionalizacionHandler.get("menu.eliminar.producto"));
        menuItemBuscarProducto.setText(mensajeInternacionalizacionHandler.get("menu.buscar.producto"));

        menuItemCrearCarrito.setText(mensajeInternacionalizacionHandler.get("menu.crear.carrito"));
        menuItemActualizarCarrito.setText(mensajeInternacionalizacionHandler.get("menu.actualizar.carrito"));
        menuItemListarCarritos.setText(mensajeInternacionalizacionHandler.get("menu.listar.carritos"));
        menuItemDetalleCarrito.setText(mensajeInternacionalizacionHandler.get("menu.detalle.carrito"));
        menuItemEliminarCarrito.setText(mensajeInternacionalizacionHandler.get("menu.eliminar.carrito"));

        menuItemCrearUsuario.setText(mensajeInternacionalizacionHandler.get("menu.crear.usuario"));
        menuItemActualizarUsuario.setText(mensajeInternacionalizacionHandler.get("menu.actualizar.usuario"));
        menuItemListarUsuario.setText(mensajeInternacionalizacionHandler.get("menu.listar.usuario"));
        menuItemEliminarUsuario.setText(mensajeInternacionalizacionHandler.get("menu.eliminar.usuario"));
        menuItemCerrarSesion.setText(mensajeInternacionalizacionHandler.get("menu.cerrar.sesion"));

        menuItemEspanol.setText(mensajeInternacionalizacionHandler.get("menu.espanol"));
        menuItemIngles.setText(mensajeInternacionalizacionHandler.get("menu.ingles"));
        menuItemFrances.setText(mensajeInternacionalizacionHandler.get("menu.frances"));
    }




}
