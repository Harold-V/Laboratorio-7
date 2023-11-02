package Composite;

import java.util.List;

/**
 *
 * @author Carlos Mario Vivas, Harold Velasquez
 */
public interface PaqueteComponente {

    public void añadir(PaqueteComponente componente);

    public String mostrar();
    
    public List<PaqueteComponente> getSubcomponents();

}
