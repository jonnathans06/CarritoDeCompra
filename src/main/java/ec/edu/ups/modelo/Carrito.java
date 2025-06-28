package ec.edu.ups.modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

public class Carrito {

    private int codigo;
    private final double IVA = 0.14;
    private static int contador = 1;
    private GregorianCalendar fechaCreacion;
    private List<ItemCarrito> items;
    private Usuario usuario;

    public Carrito() {
        codigo = contador++;
        items = new ArrayList<>();
        fechaCreacion = new GregorianCalendar();
        this.usuario = usuario;
    }

    public Carrito(Usuario usuario) {
        codigo = contador++;
        items = new ArrayList<>();
        fechaCreacion = new GregorianCalendar();
        this.usuario = usuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public GregorianCalendar getFechaCreacion() {
        return fechaCreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        items.add(new ItemCarrito(producto, cantidad));
    }

    public void eliminarProducto(int codigoProducto) {
        Iterator<ItemCarrito> it = items.iterator();
        while (it.hasNext()) {
            if (it.next().getProducto().getCodigo() == codigoProducto) {
                it.remove();
                break;
            }
        }
    }

    public void vaciarCarrito() {
        items.clear();
    }

    public List<ItemCarrito> obtenerItems() {
        return items;
    }

    public boolean estaVacio() {
        return items.isEmpty();
    }

    public double calcularSubtotal() {
        double subtotal = 0;
        for (ItemCarrito item : items) {
            subtotal += item.getProducto().getPrecio() * item.getCantidad();
        }
        return subtotal;
    }

    public double calcularIVA() {
        double subtotal = calcularSubtotal();
        return subtotal * IVA;
    }

    public double calcularTotal() {
        return calcularSubtotal() + calcularIVA();
    }

    public String getFechaFormateada() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fechaCreacion.getTime());
    }

    @Override
    public String toString() {
        return  "Cod. Carrito= " + codigo +
                ", Fecha= " + getFechaFormateada() +
                ", items= " + items +
                ", Total= " + calcularTotal() +
                ", Usuario= " + usuario.getUsername();
    }
}

