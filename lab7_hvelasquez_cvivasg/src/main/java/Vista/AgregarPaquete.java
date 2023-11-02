package Vista;

import Composite.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Mario Vivas, Harold Velasquez
 */
public class AgregarPaquete extends javax.swing.JFrame {

    /**
     * Creates new form AgenciaViajes
     */
    private JButton selectedButton;
    private AgenciaViajes agenciaViajes = AgenciaViajes.getInstance();

    public AgregarPaquete() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                agenciaViajes.setVisible(true);
            }
        });
        configurarBotones();
    }

    private void configurarBotones() {
        JButton[] buttons = {btnAsia, btnAfrica, btnN_America, btnS_America, btnEuropa, btnOceania, btnAntartida};

        for (JButton button : buttons) {
            button.addActionListener(new ContinenteButtonListener(button));
        }
    }

    private class ContinenteButtonListener implements ActionListener {

        private JButton button;

        public ContinenteButtonListener(JButton button) {
            this.button = button;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (selectedButton != null) {
                selectedButton.setSelected(false);
            }

            selectedButton = button;
            String continenteNombre = button.getText().toString();
            agregarPaisCiudad(continenteNombre);
        }
    }

    private String obtenerEntradaValida(String mensaje) {
        String entrada;
        do {
            entrada = JOptionPane.showInputDialog(this, mensaje);
            if (entrada == null) {
                return entrada;
            }
        } while (entrada.isEmpty());
        return entrada;
    }

    private void agregarPaisCiudad(String nombreContinente) {
        Continente continente = new Continente(nombreContinente);
        int numPaises = obtenerEntero("¿Cuántos países desea agregar para " + nombreContinente + "?");
        if (numPaises == 0) {
            JOptionPane.showMessageDialog(this, "No se agregarán países ni ciudades.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for (int i = 1; i <= numPaises; i++) {
            String nombrePais = obtenerEntradaValida("Nombre del país #" + i + " en " + nombreContinente);
            if (nombrePais == null) {
                continue;
            } else {
                Pais pais = new Pais(nombrePais);
                int numCiudades = obtenerEntero("¿Cuántas ciudades desea agregar para " + nombrePais + "?");

                if (numCiudades == 0) {
                    JOptionPane.showMessageDialog(this, "No se agregarán ciudades para " + nombrePais + ".", "Información", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    for (int j = 1; j <= numCiudades; j++) {
                        String nombreCiudad = obtenerEntradaValida("Nombre de la ciudad #" + j + " en " + nombrePais);
                        if (nombreCiudad == null) {
                            continue;
                        }
                        String checkIn = obtenerEntradaValida("Fecha de check-in en " + nombreCiudad);
                        if (checkIn == null) {
                            continue;
                        }
                        String checkOut = obtenerEntradaValida("Fecha de check-out en " + nombreCiudad);
                        if (checkOut == null) {
                            continue;
                        }
                        String vuelo = obtenerEntradaValida("Vuelo a " + nombreCiudad);
                        if (vuelo == null) {
                            continue;
                        }
                        String hotel = obtenerEntradaValida("Hotel en " + nombreCiudad);
                        if (hotel == null) {
                            continue;
                        }
                        String planComida = obtenerEntradaValida("Plan de comida en " + nombreCiudad);
                        if (planComida == null) {
                            continue;
                        }
                        String id = obtenerEntradaValida("Id del CityTour");
                        if (id == null) {
                            continue;
                        }
                        String nombre = obtenerEntradaValida("Nombre del CityTour");
                        if (nombre == null) {
                            continue;
                        }
                        String descripcion = obtenerEntradaValida("Descripción del CityTour");
                        if (descripcion == null) {
                            continue;
                        }
                        String recomendaciones = obtenerEntradaValida("Recomendaciones del CityTour");
                        if (recomendaciones == null) {
                            continue;
                        }
                        int duracion = obtenerEntero("Duración del CityTour (en horas)");
                        if (duracion == -1) {
                            continue;
                        }
                        CityTour cityTour = new CityTour(id, nombre, descripcion, recomendaciones, duracion);
                        Ciudad ciudad = new Ciudad(nombreCiudad, checkIn, checkOut, vuelo, hotel, planComida, cityTour);
                        pais.añadir(ciudad);
                    }
                }
                continente.añadir(pais);
            }
        }
        if (continente.getSubcomponents().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se creo el Paquete.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(this, "Se creo el Paquete.", "Información", JOptionPane.INFORMATION_MESSAGE);
        agenciaViajes.añadirContinentes(continente);
    }

    // Función para obtener un número entero válido
    private int obtenerEntero(String mensaje) {
        while (true) {
            String input = JOptionPane.showInputDialog(this, mensaje, "Ingresar número", JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                return -1;
            }

            try {
                int numero = Integer.parseInt(input);
                if (numero >= 0) {
                    return numero;
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrese un número válido (mayor o igual a 0).", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Ingrese un valor numérico válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnAsia = new javax.swing.JButton();
        btnAfrica = new javax.swing.JButton();
        btnN_America = new javax.swing.JButton();
        btnS_America = new javax.swing.JButton();
        btnEuropa = new javax.swing.JButton();
        btnOceania = new javax.swing.JButton();
        btnAntartida = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnAsia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAsia.setText("Asia");

        btnAfrica.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAfrica.setText("África");

        btnN_America.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnN_America.setText("América del Norte");

        btnS_America.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnS_America.setText("América del Sur");

        btnEuropa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEuropa.setText("Europa");

        btnOceania.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOceania.setText("Oceanía");

        btnAntartida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAntartida.setText("Antártida");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Agregar Paquete de Viaje");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAfrica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnN_America, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnS_America, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEuropa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOceania, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAntartida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAsia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnAsia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAfrica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnN_America)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnS_America)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEuropa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOceania)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAntartida)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfrica;
    private javax.swing.JButton btnAntartida;
    private javax.swing.JButton btnAsia;
    private javax.swing.JButton btnEuropa;
    private javax.swing.JButton btnN_America;
    private javax.swing.JButton btnOceania;
    private javax.swing.JButton btnS_America;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
