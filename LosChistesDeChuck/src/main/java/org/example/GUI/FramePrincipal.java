package org.example.GUI;

import org.example.API.ChukNorrisAPI;
import org.example.API.LibreTranslateAPI;
import org.example.Connections.ConexionBD;
import org.example.Module.Chiste;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.SQLException;

public class FramePrincipal extends JFrame {

    // Variables declaration - do not modify
    private JButton BotonOtroChiste;
    private JButton BotonHisotiralDeChistes;
    private JTextArea TextAreaDelChiste;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel lableElChiste;
    private JLabel labelPuntualo;
    private JLabel jLabel5;
    private JLabel labelIdioma;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JSlider sliderDePuntuacion;
    private JComboBox<String> SelectorDeIdioma;
    private JButton BotonPuntuar;


    public FramePrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        actualizarTextAreaChiste();
        traducirPagina("es");

    }

    private void initComponents() {


        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jScrollPane1 = new JScrollPane();
        TextAreaDelChiste = new JTextArea();
        lableElChiste = new JLabel();
        BotonOtroChiste = new JButton();
        BotonHisotiralDeChistes = new JButton();
        labelPuntualo = new JLabel();
        sliderDePuntuacion = new JSlider();
        jLabel5 = new JLabel();
        SelectorDeIdioma = new JComboBox<>();
        labelIdioma = new JLabel();
        BotonPuntuar = new JButton();


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 500));

        jPanel1.setBackground(new Color(11, 67, 104));
        jPanel1.setPreferredSize(new Dimension(800, 500));

        URL imgURL = FramePrincipal.class.getResource("/Images/ChuckNorris.jpg");
        if (imgURL != null) {
            ImageIcon imageIcon = new ImageIcon(imgURL);
            jLabel1.setIcon(imageIcon); // NOI18N
        }
        jLabel2.setFont(new Font("Yu Gothic", 1, 48)); // NOI18N
        jLabel2.setForeground(new Color(252, 252, 252));
        jLabel2.setText("Los Chistes De Chuck");

        TextAreaDelChiste.setColumns(20);
        TextAreaDelChiste.setRows(5);
        TextAreaDelChiste.setEditable(false);
        TextAreaDelChiste.setFont(new Font("Yu Gothic", 0, 14));
        TextAreaDelChiste.setLineWrap(true);
        TextAreaDelChiste.setWrapStyleWord(true);
        jScrollPane1.setViewportView(TextAreaDelChiste);


        lableElChiste.setFont(new Font("Yu Gothic", 1, 18)); // NOI18N
        lableElChiste.setForeground(new Color(242, 242, 242));
        lableElChiste.setText("El Chiste :");

        BotonOtroChiste.setText("Otro chiste");
        BotonOtroChiste.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                BotonOtroChisteActionPerformed(evt);
            }
        });

        BotonHisotiralDeChistes.setText("Historial de chistes");
        BotonHisotiralDeChistes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ChistesPuntutadosActionPerformed(evt);
            }
        });

        labelPuntualo.setFont(new Font("Yu Gothic", 1, 18)); // NOI18N
        labelPuntualo.setForeground(new Color(252, 252, 252));
        labelPuntualo.setText("Puntúalo");

        jLabel5.setFont(new Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel5.setForeground(new Color(242, 242, 242));
        jLabel5.setText("   Meh   |      Ja   |    jaja |  JAJAJA   | JAJAKJKF");

        SelectorDeIdioma.setModel(new DefaultComboBoxModel<>(new String[]{
                "Español",
                "Inglés",
                "Italiano",
                "Portugués"

        }));
        SelectorDeIdioma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                SelectorDeCategoriasActionPerformed(evt);
            }
        });

        labelIdioma.setFont(new Font("Yu Gothic", 1, 18)); // NOI18N
        labelIdioma.setForeground(new Color(252, 252, 252));
        labelIdioma.setText("Idioma :");

        BotonPuntuar.setText("Puntuar");
        BotonPuntuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                PuntuarActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(141, 141, 141))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(labelPuntualo)
                                                        .addContainerGap())
                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(BotonHisotiralDeChistes)
                                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                                                        .addGap(27, 27, 27))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(lableElChiste)
                                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(labelIdioma)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(SelectorDeIdioma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(53, 53, 53))
                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(254, 254, 254)
                                                                        .addComponent(BotonOtroChiste))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(6, 6, 6)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(BotonPuntuar)
                                                                                .addComponent(jLabel5))))
                                                        .addGap(36, 36, 36)))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(sliderDePuntuacion, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                                                .addGap(94, 94, 94))))
        );


        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lableElChiste)
                                                        .addComponent(SelectorDeIdioma, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(labelIdioma))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(BotonOtroChiste)
                                                .addGap(7, 7, 7)
                                                .addComponent(labelPuntualo)
                                                .addGap(20, 20, 20)
                                                .addComponent(sliderDePuntuacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(BotonPuntuar)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(BotonHisotiralDeChistes))
                                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE))
                                .addGap(91, 91, 91))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );


        // Cambiar el rango y el valor inicial del JSlider directamente
        sliderDePuntuacion.setMinimum(1);
        sliderDePuntuacion.setMaximum(5);
        sliderDePuntuacion.setValue(3);
        sliderDePuntuacion.setMajorTickSpacing(1);
        sliderDePuntuacion.setMinorTickSpacing(1);
        pack();


    }// </editor-fold>


    private void BotonOtroChisteActionPerformed(ActionEvent evt) {

        try {
            if (isChisteActualPuntuado()) {
                Chiste chiste = actualizarTextAreaChiste();
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
        try {

            guardarChisteEnBD(chiste);

            String idioma = obtenerIdiomaActual();
            TextAreaDelChiste.setText(LibreTranslateAPI.traducir(chiste.getChiste(), idioma));
            ponerScrollArriba();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return chiste;
    }


    private void guardarChisteEnBD(Chiste chiste) throws SQLException {
        ConexionBD.conectarBD();
        ConexionBD.cargarChisteBD(chiste);
        ConexionBD.desconectarBD();
    }

    private void ponerScrollArriba() {
        // Asegurarse de que el scroll esté en la parte superior
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JScrollBar verticalScrollBar = jScrollPane1.getVerticalScrollBar();
                verticalScrollBar.setValue(verticalScrollBar.getMinimum());
            }
        });
    }

    private void ChistesPuntutadosActionPerformed(ActionEvent evt) {
        this.dispose();
        HistorialDeChistes historialDeChistes = new HistorialDeChistes();
        historialDeChistes.setVisible(true);
    }


    private void PuntuarActionPerformed(ActionEvent evt) {

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

    private void lanzarNotificacion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Notifiación", JOptionPane.INFORMATION_MESSAGE);
    }

    private void SelectorDeCategoriasActionPerformed(ActionEvent evt) {
        String idiomaSeleccionado = obtenerIdiomaActual();
        traducirPagina(idiomaSeleccionado);
        traducirChiste(idiomaSeleccionado);
    }

    private String obtenerIdiomaActual() {
        String opcion = SelectorDeIdioma.getSelectedItem().toString();
        return convertirAOpcionValida(opcion);
    }

    private void traducirPagina(String idioma) {

        String[] palabrastraducidas = selectorDeIdioma(idioma);
        cambiarIdioma(palabrastraducidas);
    }

    private String[] selectorDeIdioma(String idioma) {
        String[] palabrastraducidas;

        switch (idioma) {
            case "es" -> palabrastraducidas = getPalabrasEspanol();
            case "it" -> palabrastraducidas = getPalabrasItaliano();
            case "pt" -> palabrastraducidas = getPalabrasPortugues();
            default -> palabrastraducidas = getPalabrasIngles();
        }
        return palabrastraducidas;
    }

    private String[] getPalabrasEspanol() {
        return new String[]{"Idioma", "Califícalo", "El chiste :", "Otro chiste", "Puntuar", "Hisotiral"};
    }

    private String[] getPalabrasIngles() {
        return new String[]{"Language", "Rate it", "The joke :", "Another joke", "Score", "History"};
    }

    private String[] getPalabrasItaliano() {
        return new String[]{"Lingua", "Valutalo", "La barzelletta :", "Un'altra barzelletta", "Punteggio", "Storia"};
    }

    private String[] getPalabrasPortugues() {
        return new String[]{"Idioma", "Avalie", "A piada :", "Outra piada", "Pontuar", "Histórico"};
    }

    private void cambiarIdioma(String[] palabras) {

        labelIdioma.setText(palabras[0]);
        labelPuntualo.setText(palabras[1]);
        lableElChiste.setText(palabras[2]);

        BotonOtroChiste.setText(palabras[3]);
        BotonPuntuar.setText(palabras[4]);
        BotonHisotiralDeChistes.setText(palabras[5]);
    }

    private String convertirAOpcionValida(String idioma) {

        return switch (idioma) {
            case "Español" -> "es";
            case "Italiano" -> "it";
            case "Portugués" -> "pt";
            default -> "en";
        };
    }

    private void traducirChiste(String idioma) {

        String chiste = TextAreaDelChiste.getText();
        String chisteTraducido = LibreTranslateAPI.traducir(chiste, idioma);
        TextAreaDelChiste.setText(chisteTraducido);

    }
}
