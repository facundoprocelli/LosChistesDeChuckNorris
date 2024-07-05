package org.example.API;

import org.example.*;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.example.Module.Chiste;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class ChukNorrisAPI {

    private static CloseableHttpClient httpClient = null;
    private static CloseableHttpResponse response = null;

    public ChukNorrisAPI() {

    }


    public static Chiste pedirChisteAlaAPI( ) {

        // URL de la API de Chuck Norris
        String apiUrl = "https://api.chucknorris.io/jokes/random";
        Chiste chiste = null;

        try {

            httpClient = HttpClients.createDefault();

            HttpGet request = crearSolicitudGET(apiUrl);

            chiste = ejecutarSolicitudDelChiste(request);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return chiste;
    }

    private static Chiste parsearJSON(StringBuilder result) {
        JSONObject jsonObject = new JSONObject(result.toString());
        Chiste chiste = new Chiste(jsonObject.getString("id"), jsonObject.getString("value")," " );
        return chiste;
    }

    private static  Chiste ejecutarSolicitudDelChiste(HttpGet solicitud) throws IOException {

        Chiste chiste = null;
        response = httpClient.execute(solicitud);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            StringBuilder resultado = leerRespuestaAPI(entity);
            chiste = parsearJSON(resultado);
        }
        return chiste;
    }


    private static StringBuilder leerRespuestaAPI(HttpEntity entity) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }
        reader.close();

        return result;
    }

    private static HttpGet crearSolicitudGET(String APIurl) {
        return new HttpGet(APIurl);
    }
}


