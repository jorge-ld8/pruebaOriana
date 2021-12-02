package logica.producto;

public class Producto {
    private String descripcion, nombre, ubicImg, userID;
    private int cantidad;
    private float precio;
    private boolean precioVisible;

    public Producto(int disponibilidad) {
        this.cantidad= disponibilidad;
    }

    public Producto(String descripcion, String nombre, boolean precioVisible, float precio, int cantidad, String ubicImg, String userID) {
        this.descripcion = descripcion;
        this.precio= precio;
        this.cantidad=cantidad;
        this.nombre= nombre;
        this.precioVisible=precioVisible;
        this.ubicImg = ubicImg;
        this.userID = userID;
    }

    public Producto() {
        nombre="n/a";
        cantidad=1;
        precio=1;
        descripcion="n/a";
        ubicImg="n/a";
        precioVisible=false;
        userID="n/a";
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDisponibilidad() {
        return cantidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.cantidad = disponibilidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isPrecioVisible() {
        return precioVisible;
    }

    public void setPrecioVisible(boolean precioVisible) {
        this.precioVisible = precioVisible;
    }

    public String getUbicImg() {
        return ubicImg;
    }

    public void setUbicImg(String ubicImg) {
        this.ubicImg = ubicImg;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
