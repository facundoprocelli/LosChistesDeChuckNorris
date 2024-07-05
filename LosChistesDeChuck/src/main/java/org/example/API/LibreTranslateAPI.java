package org.example.API;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;


public class LibreTranslateAPI {
/*
    private static final OkHttpClient cliente = new OkHttpClient();

    public LibreTranslateAPI() {
    }

    public static String traducir(String texto, String idiomaDestino)   {

        HttpRequest peticion;
        String respuesta = "";
        try {
            JSONObject formularioATraducir = preparaFormulario(texto, idiomaDestino);
             peticion = prepararPeticion(formularioATraducir);
             HttpResponse<String> rta = cliente.send(peticion);
            //respuesta = obetenerRespuestaTraducida(peticion);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return respuesta;
    }

    private static JSONObject preparaFormulario(String texto, String idiomaDestino) {
        JSONObject cuerpoDeLaPeticion = new JSONObject();
        cuerpoDeLaPeticion.put("q", texto);
        cuerpoDeLaPeticion.put("source", "auto");
        cuerpoDeLaPeticion.put("target", idiomaDestino);
        cuerpoDeLaPeticion.put("format", "text");
        cuerpoDeLaPeticion.put("alternatives", 3);
        cuerpoDeLaPeticion.put("api_key", "");

        return cuerpoDeLaPeticion;
    }

    private static HttpRequest prepararPeticion(JSONObject formularioATraducir) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://libretranslate.com/translate"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(formularioATraducir.toString()))
                .build();

        return request;
    }

    private static  String obetenerRespuestaTraducida(HttpRequest peticion) throws IOException {

        String mensajeTraducido = "";
        Response respuesta = cliente.newCall(peticion).execute();


        //todo: borrar en caso de que ya funcione bien el traductor.

        if (!respuesta.isSuccessful()) {
            throw new IOException("Unexpected code " + respuesta);
        }

        if (respuesta.body() != null) {
            mensajeTraducido = convertirRespuestaJSONaString(obtenerRespuestaJSON(respuesta));
        }

        respuesta.close();
        return mensajeTraducido;
    }

    private static  String obtenerRespuestaJSON(Response respuesta) throws IOException {
        return respuesta.body().string();
    }

    private static String convertirRespuestaJSONaString(String JSONTraducido) {
        JSONObject jo = new JSONObject(JSONTraducido);
        return jo.getString("translatedText");
    }
*/


    public static String traducir(String texto) {
        try {
            // Crear el cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Crear el cuerpo de la solicitud
            JSONObject requestBody = new JSONObject();
            requestBody.put("q", texto);
            requestBody.put("source", "auto");
            requestBody.put("target", "es");
            requestBody.put("format", "text");
            requestBody.put("alternatives", 3);
            requestBody.put("api_key", "");

            // Crear la solicitud HTTP
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://libretranslate.com/translate"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody.toString()))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Imprimir la respuesta JSON
            JSONObject responseObject = new JSONObject(response.body());
            System.out.println(responseObject.toString(4)); // Imprimir con sangría para legibilidad

        } catch (Exception e) {
            e.printStackTrace();
        }
        return texto;
    }
}


