package pe.edu.tecsup.te_android_firebase_6.model;

public class Playa {

    private Double radiacion;
    private Double velocidad;

    public Playa(Double radiacion, Double velocidad) {
        this.radiacion = radiacion;
        this.velocidad = velocidad;
    }

    public Playa() {
    }

    public Double getRadiacion() {
        return radiacion;
    }

    public void setRadiacion(Double radiacion) {
        this.radiacion = radiacion;
    }

    public Double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }
}
