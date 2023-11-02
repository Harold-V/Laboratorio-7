package Vista;

import Composite.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Carlos Mario Vivas, Harold Velasquez
 */
public class AgenciaViajes extends javax.swing.JFrame {

    private static AgenciaViajes instance;
    private AgregarPaquete agregarPaquete;
    private List<Continente> continentes = new ArrayList<>();
    private StringBuilder sb;

    /**
     * Creates new form AgenciaViajes
     */
    public AgenciaViajes() {
        initComponents();
        txpMostrar.setEditable(false);
        txpMostrar.setCursor(null);
        txpMostrar.setFocusable(false);
        setLocationRelativeTo(null);
        ejemplos();
        mostrarInformacionPaquetes();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Cierra la ventana principal y todas las ventanas secundarias
                dispose();
                if (agregarPaquete != null) {
                    agregarPaquete.dispose();
                }
                System.exit(0);
            }
        });
    }

    public static AgenciaViajes getInstance() {
        if (instance == null) {
            instance = new AgenciaViajes();
        }
        return instance;
    }

    public void añadirContinentes(Continente continente) {
        continentes.add(continente);
    }

    private void mostrarInformacionPaquetes() {
        sb = new StringBuilder();
        for (Continente continente : continentes) {
            mostrarInformacion(continente, sb);
        }
        if (sb.toString().isEmpty()) {
            txpMostrar.setText("No hay Paquetes de Viajes\n");
        } else {
            txpMostrar.setText("Paquetes de Viajes: \n" + sb.toString());
        }
    }

    private void mostrarInformacion(PaqueteComponente componente, StringBuilder sb) {
        sb.append(componente.mostrar());

        if (componente instanceof Continente) {
            for (PaqueteComponente subComponent : ((Continente) componente).getSubcomponents()) {
                mostrarInformacion(subComponent, sb);
            }
        } else if (componente instanceof Pais) {
            for (PaqueteComponente subComponent : ((Pais) componente).getSubcomponents()) {
                mostrarInformacion(subComponent, sb);
            }
        }
    }

    private void agregarPaqueteCompleto(String nombreContinente, String nombrePais, String nombreCiudad,
            String checkIn, String checkOut, String vuelo, String hotel, String planComida,
            String idCityTour, String nombreCityTour, String descripcionCityTour,
            String recomendacionesCityTour, int duracionCityTour) {

        CityTour cityTour = new CityTour(idCityTour, nombreCityTour, descripcionCityTour, recomendacionesCityTour, duracionCityTour);

        Ciudad ciudad = new Ciudad(nombreCiudad, checkIn, checkOut, vuelo, hotel, planComida, cityTour);

        Pais pais = new Pais(nombrePais);
        pais.añadir(ciudad);

        Continente continenteExistente = null;
        for (Continente continente : continentes) {
            if (continente.mostrar().equalsIgnoreCase(nombreContinente)) {
                continenteExistente = continente;
                break;
            }
        }

        if (continenteExistente == null) {
            continenteExistente = new Continente(nombreContinente);
            continentes.add(continenteExistente);
        }

        continenteExistente.añadir(pais);
    }

    private void ejemplos() {
        agregarPaqueteCompleto("Europa", "España", "Barcelona", "2023-11-01", "2023-11-07",
                "Vuelo123", "Hotel Barcelona", "Plan Todo Incluido", "CT001", "CityTour Barcelona",
                "Descubre los encantos de Barcelona", "No olvides visitar La Sagrada Familia", 5);
        agregarPaqueteCompleto("África", "Egipto", "El Cairo", "2023-12-01", "2023-12-07",
                "Vuelo456", "Hotel Nile", "Plan de Comida Egipcia", "CT002", "CityTour El Cairo",
                "Explora las pirámides egipcias", "Visita el Museo Egipcio", 4);
        agregarPaqueteCompleto("América del Norte", "Estados Unidos", "Nueva York", "2023-10-15", "2023-10-20",
                "Vuelo789", "Hotel Manhattan", "Plan de Comida Variada", "CT003", "CityTour Nueva York",
                "Descubre la Gran Manzana", "Pasea por Central Park", 6);
        agregarPaqueteCompleto("América del Sur", "Brasil", "Río de Janeiro", "2023-09-05", "2023-09-10",
                "Vuelo101", "Hotel Copacabana", "Plan de Comida Brasileña", "CT004", "CityTour Río de Janeiro",
                "Disfruta de las playas de Copacabana", "Visita el Cristo Redentor", 5);
        agregarPaqueteCompleto("Oceanía", "Australia", "Sídney", "2023-07-20", "2023-07-25",
                "Vuelo303", "Hotel Harbour", "Plan de Comida Australiana", "CT005", "CityTour Sídney",
                "Explora la Ópera de Sídney", "Navega por la Bahía de Sídney", 7);
        agregarPaqueteCompleto("Antártida", "Antártida", "Base de Investigación", "2023-12-15", "2023-12-30",
                "Vuelo123", "Alojamiento en Base", "Plan de Comida Científica", "CT006", "CityTour en la Base",
                "Investiga la vida en la Antártida", "Participa en investigaciones científicas", 16);
        agregarPaqueteCompleto("Asia", "Japón", "Tokio", "2023-11-01", "2023-11-07",
                "Vuelo789", "Hotel Tokyo", "Plan de Comida Tradicional", "CT002", "CityTour Tokio",
                "Descubre la cultura japonesa", "Prueba el sushi auténtico", 6);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txpMostrar = new javax.swing.JTextPane();
        btnAgregarPaquete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMostrarPaquete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txpMostrar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jScrollPane1.setViewportView(txpMostrar);

        btnAgregarPaquete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAgregarPaquete.setText("Nuevo Paquete");
        btnAgregarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPaqueteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Agencia de Viajes");

        btnMostrarPaquete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnMostrarPaquete.setText("Mostrar Paquetes");
        btnMostrarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarPaqueteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(jLabel1)
                .addContainerGap(137, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnAgregarPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMostrarPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarPaquete)
                    .addComponent(btnAgregarPaquete))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPaqueteActionPerformed
        if (agregarPaquete == null) {
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            agregarPaquete = new AgregarPaquete();
        }
        agregarPaquete.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAgregarPaqueteActionPerformed

    private void btnMostrarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarPaqueteActionPerformed
        mostrarInformacionPaquetes();
    }//GEN-LAST:event_btnMostrarPaqueteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgenciaViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgenciaViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgenciaViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgenciaViajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgenciaViajes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPaquete;
    private javax.swing.JButton btnMostrarPaquete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane txpMostrar;
    // End of variables declaration//GEN-END:variables
}
