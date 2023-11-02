package Composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Mario Vivas, Harold Velasquez
 */
public class Pais implements PaqueteComponente {

    private String nombrePais;
    private List<PaqueteComponente> ciudades;

    @Override
    public List<PaqueteComponente> getSubcomponents() {
        return ciudades;
    }

    public Pais(String nombrePais) {
        this.nombrePais = nombrePais;
        ciudades = new ArrayList<>();
    }

    @Override
    public void añadir(PaqueteComponente componente) {
        ciudades.add(componente);
    }

    @Override
    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pais: ").append(nombrePais).append("\n");
        return sb.toString();
    }

}
