package main.requests;

import main.Respuesta;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Locale;

public class Peticion {
    public static final String GET  = "GET";
    public static final String POST  = "POST";
    public static final String PUT  = "PUT";
    public static final String DELETE  = "DELETE";

    public static final String FormUrlEncoded = "application/x-www-form-urlencoded";
    public static final String JSON = "application/json";

    private static String Url;
    private static String Metodo;
    private static String ContentType = JSON;
    private static Object Body = null;

    public Peticion(String url, String metodo, String contentType, Object body) {
        Url = url;
        Metodo = metodo;
        ContentType = contentType;
        Body = body;
    }

    public Peticion(String url, String metodo, String contentType) {
        Url = url;
        Metodo = metodo;
        ContentType = contentType;
    }

    public Peticion(String url, String metodo, Object body) {
        Url = url;
        Metodo = metodo;
        Body = body;
    }

    public Peticion(String url, String metodo) {
        Url = url;
        Metodo = metodo;
    }

    public Respuesta HacerPeticion() {
        Respuesta respuesta = new Respuesta();

        switch (Metodo.toUpperCase(Locale.ROOT)) {
            case POST -> respuesta = POST();
            case GET -> respuesta = GET();
            case PUT -> respuesta = PUT();
            case DELETE -> respuesta = DELETE();
            default -> {
                respuesta.Mensaje = "Metodo no soportado";
                respuesta.Json = null;
                respuesta.EstatusCode = EstatusCode.METHOD_NOT_ALLOWED.Estatus;
            }
        }
        return respuesta;
    }

    private Respuesta POST() {
        Respuesta respuesta = new Respuesta();
        respuesta.Mensaje = "Metodo POST";
        return respuesta;
    }

    private Respuesta GET() {
        Respuesta respuesta = new Respuesta();
        HttpURLConnection con = null;
        int status = 0;

        try {
            URL url = new URL(Url);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod(GET);
            con.setRequestProperty("content-type", ContentType);
            con.setDoOutput(true);

            status = con.getResponseCode();
            if (status == EstatusCode.OK.Estatus) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                respuesta.Json = content.toString();
                respuesta.EstatusCode = EstatusCode.OK.Estatus;
                respuesta.Mensaje = EstatusCode.OK.Mensaje;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            respuesta.Json = null;
            respuesta.EstatusCode = status;
            respuesta.Mensaje = ex.getMessage();
        } finally {
            if (con != null)
                con.disconnect();
        }
        return respuesta;
    }

    private Respuesta PUT() {
        Respuesta respuesta = new Respuesta();
        respuesta.Mensaje = "Metodo PUT";
        return respuesta;
    }

    private Respuesta DELETE() {
        Respuesta respuesta = new Respuesta();
        respuesta.Mensaje = "Metodo DELETE";
        return respuesta;
    }
}
