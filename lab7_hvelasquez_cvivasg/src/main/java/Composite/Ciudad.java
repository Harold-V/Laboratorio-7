package Composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Mario Vivas, Harold Velasquez
 */
public class Ciudad implements PaqueteComponente {

    private String nombreCiudad, checkIn, checkOut, vuelo, hotel, planComida;
    private CityTour cityTour;

    public Ciudad(String nombreCiudad, String checkIn, String checkOut, String vuelo, String hotel, String planComida, CityTour cityTour) {
        this.nombreCiudad = nombreCiudad;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.vuelo = vuelo;
        this.hotel = hotel;
        this.planComida = planComida;
        this.cityTour = cityTour;
    }

    @Override
    public void añadir(PaqueteComponente componente) {
        //
    }

    @Override
    public String mostrar() {
        return "Ciudad: " + nombreCiudad + "\n"
                + "  Vuelo: " + vuelo + "\n"
                + "  Hotel: " + hotel + "\n"
                + "  Plan de Comida: " + planComida + "\n"
                + "  Check In Date: " + checkIn + "\n"
                + "  Check Out Date: " + checkOut + "\n"
                + "  City Tour: " + cityTour.toString() + "\n";
    }

    @Override
    public List<PaqueteComponente> getSubcomponents() {
        return new ArrayList<>();
    }

}
