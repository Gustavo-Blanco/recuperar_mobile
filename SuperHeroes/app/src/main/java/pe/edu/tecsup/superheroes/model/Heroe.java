package pe.edu.tecsup.superheroes.model;

public class Heroe {
    private int idImagen;
    private String heroe;
    private String empresa;
    private String nombre;

    public Heroe( String heroe, String nombre,String empresa, int idImagen) {
        this.heroe = heroe;
        this.empresa = empresa;
        this.nombre = nombre;
        this.idImagen = idImagen;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getHeroe() {
        return heroe;
    }

    public void setHeroe(String heroe) {
        this.heroe = heroe;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Heroe{" +
                "idImagen=" + idImagen +
                ", heroe='" + heroe + '\'' +
                ", empresa='" + empresa + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
