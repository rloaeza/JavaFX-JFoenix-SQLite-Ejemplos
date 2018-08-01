package proyectoFinal;

public class TODOModel {
    private int id;
    private String titulo;
    private String descripcion; 
    private boolean hecho;

    public TODOModel(int id, String titulo, String descripcion, boolean hecho) {
        this.id = id;
        this.titulo = titulo;
        descripcion = descripcion;
        this.hecho = hecho;
    }
    public int getId() {
        return id;

    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        descripcion = descripcion;
    }

    public boolean isHecho() {
        return hecho;
    }

    public void setHecho(boolean hecho) {
        this.hecho = hecho;
    }
}
