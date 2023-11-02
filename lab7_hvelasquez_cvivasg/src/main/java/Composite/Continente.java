package Composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Mario Vivas, Harold Velasquez
 */
public class Continente implements PaqueteComponente {

    private String nombreContinente;
    private List<PaqueteComponente> paises;

    @Override
    public List<PaqueteComponente> getSubcomponents() {
        return paises;
    }

    public Continente(String nombreContinente) {
        this.nombreContinente = nombreContinente;
        paises = new ArrayList<>();
    }

    @Override
    public void añadir(PaqueteComponente componente) {
        paises.add(componente);
    }

    @Override
    public String mostrar() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nContinente: ").append(nombreContinente).append("\n");
        return sb.toString();
    }

}
