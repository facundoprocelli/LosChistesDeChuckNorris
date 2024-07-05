package org.example.Connections;

import org.example.Module.Chiste;

import java.sql.*;
import java.util.ArrayList;

public class ConexionBD {

    private static String url = "jdbc:mysql://127.0.0.1:3306/loschistesdechuck";
    private static String contrasena = "";
    private static String usuario = "root";
    private static Connection connection;

    public ConexionBD() {

    }

    public static void conectarBD() throws SQLException {

        connection = DriverManager.getConnection(url, usuario, contrasena);
    }

    public static void desconectarBD() throws SQLException {

        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

    public static ArrayList<Chiste> pedirTodosLosChistes() throws SQLException {
        ArrayList<Chiste> chistes;

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM chistes");
        ResultSet resultSet = statement.executeQuery();

        chistes = procesarResultadosDeBD(resultSet);

        return chistes;

    }


    public static ArrayList<Chiste> pedirChistesPorPuntuacion(String puntuacion) throws SQLException {

        ArrayList<Chiste> chistes;

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM chistes WHERE puntuacion = '" + puntuacion + "'");
        ResultSet resultSet = statement.executeQuery();

        chistes = procesarResultadosDeBD(resultSet);
        return  chistes;
    }

    public static Chiste pedirChisteActual() throws SQLException {

        Chiste chiste;

        PreparedStatement statement = connection.prepareStatement("SELECT * FROM chistes ORDER BY pos_entrada DESC LIMIT 1");
        ResultSet resultSet = statement.executeQuery();

        chiste = procesarResultadosDeBD(resultSet).getFirst();

        return chiste;
    }
    private static ArrayList<Chiste> procesarResultadosDeBD(ResultSet resultSet) throws SQLException {
        ArrayList<Chiste> chistes = new ArrayList<>();

        while (resultSet.next()) {
            Chiste chiste = new Chiste(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3));

            chistes.add(chiste);
        }
        resultSet.close();
        return chistes;
    }

    public static void cargarChisteBD(Chiste chiste) throws SQLException {

        PreparedStatement statement = preparaPeticionCarga(chiste);
        statement.executeUpdate();
        statement.close();

    }

    private static PreparedStatement preparaPeticionCarga(Chiste chiste) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO chistes(id_chiste, value, puntuacion) VALUES(?,?,?)");

        statement.setString(1, chiste.getId());
        statement.setString(2, chiste.getChiste());
        statement.setString(3, chiste.getPuntuacion());

        return statement;
    }

    public  static void actualizarChisteEnBD(Chiste chiste) throws SQLException {

        int posEntrada = posicionDeEntradaActual();
        PreparedStatement statement = connection.prepareStatement("UPDATE chistes SET puntuacion = ? WHERE pos_entrada = ?");
        statement.setString(1, chiste.getPuntuacion());
        statement.setInt(2, posEntrada);
        statement.executeUpdate();

    }

    private static int posicionDeEntradaActual() throws SQLException {

        PreparedStatement statement = connection.prepareStatement("SELECT pos_entrada FROM chistes ORDER BY pos_entrada DESC LIMIT 1");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        return resultSet.getInt(1) ;
    }
}
