package ec.edu.ups.modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class Usuario {
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String username;
    private String contrasenia;
    private Rol rol;
    private GregorianCalendar fechaCreacion;
    private List<PreguntaRespondida> preguntaRespondida;

    public Usuario(String nombreDeUsuario, String contrasenia, Rol rol) {
        this.username = nombreDeUsuario;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    public Usuario(String nombre, String apellido, String telefono, String correo, String username,
                   String contrasenia, Rol rol, GregorianCalendar fechaCreacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.username = username;
        this.contrasenia = contrasenia;
        this.rol = rol;
        this.fechaCreacion = fechaCreacion;
        this.preguntaRespondida = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public GregorianCalendar getFechaCreacion() {
        return fechaCreacion;
    }

    public List<PreguntaRespondida> getPreguntaRespondida() {
        return preguntaRespondida;
    }

    public void setPreguntaRespondida(List<PreguntaRespondida> preguntaRespondida) {
        this.preguntaRespondida = preguntaRespondida;
    }

    public String getFechaFormateada() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fechaCreacion.getTime());
    }

    public void setFechaCreacion(GregorianCalendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void agregarPreguntasRespondidas(List<PreguntaRespondida> preguntasConRespuesta) {
        preguntaRespondida.addAll(preguntasConRespuesta);
    }

    @Override
    public String toString() {
        return "[" + "Nombre: " + nombre + ", "
                + "Apellido: " + apellido + ", "
                + "Fecha de Nacimiento: " + getFechaFormateada() + ", "
                + "Telefono: " + telefono + ", "
                + "Correo: " + correo + ", "
                + "Username: " + username + ", "
                + "Contrasenia: " + contrasenia + ", "
                + "Rol: " + rol + ", " + "\nPreguntas: " + "\n" + preguntaRespondida
                + "]";
    }
}
