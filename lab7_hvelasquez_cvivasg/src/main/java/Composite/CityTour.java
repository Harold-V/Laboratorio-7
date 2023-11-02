package Composite;

/**
 *
 * @author Carlos Mario Vivas, Harold Velasquez
 */
public class CityTour {

    private String Id, nombreCityTour, descripcion, recomendaciones;
    private int duracion;

    public CityTour(String Id, String nombreCityTour, String descripcion, String recomendaciones, int duracion) {
        this.Id = Id;
        this.nombreCityTour = nombreCityTour;
        this.descripcion = descripcion;
        this.recomendaciones = recomendaciones;
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "CityTour ("
                + " id= " + Id
                + ", Nombre= " + nombreCityTour
                + ", Descripcion= " + descripcion
                + ", Recomendaciones= " + recomendaciones
                + ", Duracion= " + duracion
                + " horas )";
    }

}
