package Unidad_3_4;

public class Existencia {
    private int idExistecia;
    private int idProducto;
    private int cantidad;
    private double costo;

    public Existencia(int idExistecia, int idProducto, int cantidad, double costo) {
        this.idExistecia = idExistecia;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public int getIdExistecia() {
        return idExistecia;
    }

    public void setIdExistecia(int idExistecia) {
        this.idExistecia = idExistecia;
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

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
