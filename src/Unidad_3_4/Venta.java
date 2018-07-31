package Unidad_3_4;

public class Venta {

    private int idExistencia;
    private int idProducto;
    private int cantidad;
    private String producto;
    private double costo;

    public Venta(int idExistencia, int idProducto, int cantidad, String producto, double costo) {
        this.idExistencia = idExistencia;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.producto = producto;
        this.costo = costo;
    }

    public int getIdExistencia() {
        return idExistencia;
    }

    public void setIdExistencia(int idExistencia) {
        this.idExistencia = idExistencia;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
