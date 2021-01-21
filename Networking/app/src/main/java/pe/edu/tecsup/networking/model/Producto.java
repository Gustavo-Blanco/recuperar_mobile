package pe.edu.tecsup.networking.model;

public class Producto {
    private Integer id;
    private String nombre;
    private Double precio;
    private String imagen;
    private String detalles;

    /**
     * No args constructor for use in serialization
     *
     */
    public Producto() {
    }

    /**
     *
     * @param precio
     * @param imagen
     * @param detalles
     * @param id
     * @param nombre
     */
    public Producto(Integer id, String nombre, Double precio, String imagen, String detalles) {
        super();
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.detalles = detalles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", imagen='" + imagen + '\'' +
                ", detalles='" + detalles + '\'' +
                '}';
    }
}
