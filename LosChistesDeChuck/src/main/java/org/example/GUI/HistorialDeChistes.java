package org.example.GUI;

import org.example.Connections.ConexionBD;
import org.example.Main;
import org.example.Module.Chiste;

import javax.swing.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;

public class HistorialDeChistes extends javax.swing.JFrame {

    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> ComboBoxPuntuacion;
    private javax.swing.JButton IrAtrasButton;
    private javax.swing.JTextArea TextAreaChistes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration

    public HistorialDeChistes() {
        try {
            initComponents();
            setLocationRelativeTo(null);
            cambiarIconoAPP();
            cargarTextAreaChistes("Todos");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaChistes = new javax.swing.JTextArea();
        IrAtrasButton = new javax.swing.JButton();
        ComboBoxPuntuacion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);


        // Cargar el icono
        URL logoURL = Main.class.getResource("/chuck-norris.png");
        if(logoURL != null) {
            ImageIcon icon = new ImageIcon(logoURL);
            setIconImage(icon.getImage());
        }

        jPanel1.setBackground(new java.awt.Color(11, 67, 104));

        URL imgURL = FramePrincipal.class.getResource("/Images/ChuckNorris.jpg");
        if (imgURL != null) {
            ImageIcon imageIcon = new ImageIcon(imgURL);
            jLabel1.setIcon(imageIcon); // NOI18N
        }
        jLabel2.setFont(new java.awt.Font("Yu Gothic", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 252, 252));
        jLabel2.setText("Los Chistes De Chuck");

        TextAreaChistes.setColumns(20);
        TextAreaChistes.setRows(5);
        TextAreaChistes.setEditable(false);
        TextAreaChistes.setLineWrap(true);
        TextAreaChistes.setWrapStyleWord(true);
        TextAreaChistes.setFont(new java.awt.Font("Yu Gothic", 1, 14));

        jScrollPane1.setViewportView(TextAreaChistes);


        IrAtrasButton.setText("Ir atras");
        IrAtrasButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IrAtrasButtonActionPerformed(evt);
            }
        });

        ComboBoxPuntuacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Todos", "Meh", "Ja", "jaja", "JAJAJA", "JAJAKJKF"}));
        ComboBoxPuntuacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxPuntuacionActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(252, 252, 252));
        jLabel3.setText("Puntuación : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(117, 117, 117)
                                                .addComponent(jLabel2))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(48, 48, 48)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(IrAtrasButton)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(jLabel3)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(ComboBoxPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(ComboBoxPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(IrAtrasButton)
                                .addGap(14, 14, 14))
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
    }

    private void ComboBoxPuntuacionActionPerformed(java.awt.event.ActionEvent evt) {

        String opcion = ComboBoxPuntuacion.getSelectedItem().toString();

        try {
            if (opcionEsValida(opcion)) {
                cargarTextAreaChistes(opcion);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean opcionEsValida(String opcion) {
        boolean rta = false;
        String[] opciones = {"Todos", "Meh", "Ja", "jaja", "JAJAJA", "JAJAKJKF"};

        for (String o : opciones) {
            if (opcion.equals(o)) {
                rta = true;
            }
        }
        return rta;
    }

    private void cargarTextAreaChistes(String opcion) throws SQLException {

        String todosLoschistes = "";
        ArrayList<Chiste> chistes = obtenerArraylistDeChistes(opcion);
        for (Chiste c : chistes) {
            todosLoschistes = todosLoschistes.concat(formatearChiste(c));
        }
        TextAreaChistes.setText(todosLoschistes);
        ponerScrollArriba();
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

    private String formatearChiste(Chiste chiste) {
        String chisteActual;

        chisteActual = "Puntuación : " + chiste.getPuntuacion() + "\nChiste: " + chiste.getChiste() + "\n\n";

        return chisteActual;
    }

    private ArrayList<Chiste> obtenerArraylistDeChistes(String opcion) throws SQLException {
        ArrayList<Chiste> chistes;

        ConexionBD.conectarBD();
        if (opcion.equals("Todos")) {
            chistes = ConexionBD.pedirTodosLosChistes();
        } else {
            chistes = ConexionBD.pedirChistesPorPuntuacion(opcion);
        }
        ConexionBD.desconectarBD();


        return chistes;
    }

    private void IrAtrasButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        FramePrincipal frame = new FramePrincipal();
        frame.setVisible(true);

    }

    private void cambiarIconoAPP() {
        URL imgURL = FramePrincipal.class.getResource("/Images/chuck-noris.png");
        if (imgURL != null) {
            ImageIcon imageIcon = new ImageIcon(imgURL);
            setIconImage(imageIcon.getImage());
        }
    }


}
