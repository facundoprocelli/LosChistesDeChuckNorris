package org.example.API;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

/*
* Esta es una clase la cual se encarga de hacer una petición a un servidor local de libreTranslate
* Trabaja con peticiones y clientes HTTP para poder conectarse e interecatuar con libreTranslate
* */

public class LibreTranslateAPI {

    public LibreTranslateAPI() {
    }

    public static String traducir(String texto, String idiomaDestino) {
        String respuesta;
        //Crea un cliente HTTP default
        try (CloseableHttpClient cliente = HttpClients.createDefault()) {

            JSONObject formularioATraducir = preparaFormulario(texto, idiomaDestino);
            HttpPost peticion = prepararPeticion(formularioATraducir);

            //Ejecuto la peticion
            try (CloseableHttpResponse rta = cliente.execute(peticion)) {
                respuesta = obtenerRespuestaTraducida(rta);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return respuesta;
    }


    //Prepara el formulario necesario para conectarse con libreTransalte
    private static JSONObject preparaFormulario(String texto,  String idiomaDestino) {

        JSONObject cuerpoDeLaPeticion = new JSONObject();
            cuerpoDeLaPeticion.put("q", texto);
            cuerpoDeLaPeticion.put("source", "auto");
            cuerpoDeLaPeticion.put("target", idiomaDestino);
            cuerpoDeLaPeticion.put("format", "text");

        return cuerpoDeLaPeticion;
    }

    //Prepara la petición y para poder enviar el formualrio
    private static HttpPost prepararPeticion(JSONObject formularioATraducir) {

        HttpPost peticion = new HttpPost("http://localhost:5000/translate");
            peticion.setHeader("Content-Type", "application/json");
            peticion.setEntity(new StringEntity(formularioATraducir.toString(), "UTF-8"));

        return peticion;
    }

    //Traduce el JSON a un String
    private static String obtenerRespuestaTraducida(CloseableHttpResponse respuesta) throws IOException {
        //Obtiene el contendio de una respuesta HTTP en texto
        String respuestaJSON = EntityUtils.toString(respuesta.getEntity());
        JSONObject jo = new JSONObject(respuestaJSON);

        return jo.getString("translatedText");
    }
}


