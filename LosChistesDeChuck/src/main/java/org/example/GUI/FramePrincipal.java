package org.example.GUI;

import org.example.API.ChukNorrisAPI;
import org.example.API.LibreTranslateAPI;
import org.example.Connections.ConexionBD;
import org.example.Module.Chiste;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;

public class FramePrincipal extends javax.swing.JFrame {

    // Variables declaration - do not modify
    private javax.swing.JButton BotonOtroChiste;
    private javax.swing.JButton ChistesPuntutados;
    private javax.swing.JTextArea TextAreaDelChiste;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider sliderDePuntuacion;
    private javax.swing.JButton Puntuar;


    public FramePrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        actualizarTextAreaChiste();
    }

    private void initComponents() {


        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaDelChiste = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        BotonOtroChiste = new javax.swing.JButton();
        ChistesPuntutados = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        sliderDePuntuacion = new javax.swing.JSlider();
        jLabel5 = new javax.swing.JLabel();
        JLabel jLabel6 = new JLabel();
        Puntuar = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(11, 67, 104));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));

        URL imgURL = FramePrincipal.class.getResource("/Images/ChuckNorris.jpg");
        if (imgURL != null) {
            ImageIcon imageIcon = new ImageIcon(imgURL);
            jLabel1.setIcon(imageIcon); // NOI18N
        }
        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 252, 252));
        jLabel2.setText("Los Chistes De Chuck");

        TextAreaDelChiste.setColumns(20);
        TextAreaDelChiste.setRows(5);
        TextAreaDelChiste.setEditable(false);
        TextAreaDelChiste.setFont(new java.awt.Font("Yu Gothic", 0, 14));
        TextAreaDelChiste.setLineWrap(true);
        TextAreaDelChiste.setWrapStyleWord(true);
        jScrollPane1.setViewportView(TextAreaDelChiste);



        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(242, 242, 242));
        jLabel3.setText("El Chiste :");

        BotonOtroChiste.setText("Otro chiste");
        BotonOtroChiste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonOtroChisteActionPerformed(evt);
            }
        });

        ChistesPuntutados.setText("Historial de chistes");
        ChistesPuntutados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChistesPuntutadosActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(252, 252, 252));
        jLabel4.setText("Puntúalo");

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(242, 242, 242));
        jLabel5.setText("   Meh   |      Ja   |    jaja |  JAJAJA   | JAJAKJKF");


        Puntuar.setText("Puntuar");
        Puntuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PuntuarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(141, 141, 141))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addContainerGap())
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(ChistesPuntutados)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(27, 27, 27))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel3)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel6)
                                                        .addGap(18, 18, 18)
                                                        .addGap(53, 53, 53))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(254, 254, 254)
                                                                        .addComponent(BotonOtroChiste))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(6, 6, 6)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(Puntuar)
                                                                                .addComponent(jLabel5))))
                                                        .addGap(36, 36, 36)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(sliderDePuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(94, 94, 94))))
        );


        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(BotonOtroChiste)
                                                .addGap(7, 7, 7)
                                                .addComponent(jLabel4)
                                                .addGap(20, 20, 20)
                                                .addComponent(sliderDePuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Puntuar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ChistesPuntutados))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );


        // Cambiar el rango y el valor inicial del JSlider directamente
        sliderDePuntuacion.setMinimum(1);
        sliderDePuntuacion.setMaximum(5);
        sliderDePuntuacion.setValue(3);
        sliderDePuntuacion.setMajorTickSpacing(1);
        sliderDePuntuacion.setMinorTickSpacing(1);
        pack();


    }// </editor-fold>


    private void BotonOtroChisteActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            if (isChisteActualPuntuado()) {
               Chiste chiste = actualizarTextAreaChiste();
                guardarChisteEnBD(chiste);

            } else {
                lanzarNotificacion("¡El chiste no fue puntuado!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isChisteActualPuntuado() throws SQLException {
        boolean rta = false;

        if (!pedirChisteActualBD().getPuntuacion().isBlank()) {
            rta = true;
            ;
        }
        return rta;
    }

    private Chiste actualizarTextAreaChiste() {
        Chiste chiste = ChukNorrisAPI.pedirChisteAlaAPI();
        TextAreaDelChiste.setText(chiste.getChiste());
        ponerScrollArriba();
        return chiste;
    }



    private void guardarChisteEnBD(Chiste chiste) throws SQLException {
        ConexionBD.conectarBD();
        ConexionBD.cargarChisteBD(chiste);
        ConexionBD.desconectarBD();
    }

    private void ponerScrollArriba(){
        // Asegurarse de que el scroll esté en la parte superior
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JScrollBar verticalScrollBar = jScrollPane1.getVerticalScrollBar();
                verticalScrollBar.setValue(verticalScrollBar.getMinimum());
            }
        });
    }

    private void ChistesPuntutadosActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        HistorialDeChistes historialDeChistes = new HistorialDeChistes();
        historialDeChistes.setVisible(true);
    }


    private void PuntuarActionPerformed(java.awt.event.ActionEvent evt) {

        if (!TextAreaDelChiste.getText().isBlank()) {
            try {
                Chiste chiste = pedirChisteActualBD();
                chiste.setPuntuacion(getPuntaje());
                actualizarChisteEnBD(chiste);
                lanzarNotificacion("¡Puntuación Actualizada!");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            lanzarNotificacion("No hay ningun chiste");

        }

    }


    private Chiste pedirChisteActualBD() throws SQLException {

        ConexionBD.conectarBD();
        Chiste chiste = ConexionBD.pedirChisteActual();
        ConexionBD.desconectarBD();

        return chiste;
    }

    private void actualizarChisteEnBD(Chiste chiste) throws SQLException {
        ConexionBD.conectarBD();
        ConexionBD.actualizarChisteEnBD(chiste);
        ConexionBD.desconectarBD();
    }


    private String getPuntaje() {
        return evaluarResultadoSlider(sliderDePuntuacion.getValue());
    }

    private String evaluarResultadoSlider(int valor) {
        String rta = switch (valor) {
            case 1 -> "Meh";
            case 2 -> "Ja";
            case 3 -> "jaja";
            case 4 -> "JAJAJA";
            case 5 -> "JAJAKJKF";
            default -> "";
        };

        return rta;

    }

    private void lanzarNotificacion(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje, "Notifiación", JOptionPane.INFORMATION_MESSAGE);
    }


}
