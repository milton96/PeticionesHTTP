package main;

public class Peticion<T> {
    public static final String GET  = "GET";
    public static final String POST  = "POST";
    public static final String PUT  = "PUT";
    public static final String DELETE  = "DELETE";

    public static final String FormUrlEncoded = "application/x-www-form-urlencoded";
    public static final String JSON = "application/json";

    private static String URL;
    private static String Metodo;
    private static String ContentType = FormUrlEncoded;
    private static Object Body = null;

    public Peticion(String url, String metodo, String contentType, Object body) {
        URL = url;
        Metodo = metodo;
        ContentType = contentType;
        Body = body;
    }

    public Peticion(String url, String metodo, String contentType) {
        URL = url;
        Metodo = metodo;
        ContentType = contentType;
    }

    public Peticion(String url, String metodo, Object body) {
        URL = url;
        Metodo = metodo;
        Body = body;
    }

    public Respuesta<T> HacerPeticion() {
        Respuesta<T> respuesta = new Respuesta<>();

        switch (Metodo) {
            case POST -> respuesta = POST();
            case GET -> respuesta = GET();
            case PUT -> respuesta = PUT();
            case DELETE -> respuesta = DELETE();
            default -> {
                respuesta.Mensaje = "Metodo no soportado";
                respuesta.Datos = null;
                respuesta.EstatusCode = EstatusCode.METHOD_NOT_ALLOWED.Estatus;
            }
        }
        return respuesta;
    }

    private Respuesta<T> POST() {
        Respuesta<T> respuesta = new Respuesta<>();
        respuesta.Mensaje = "Metodo POST";
        return respuesta;
    }

    private Respuesta<T> GET() {
        Respuesta<T> respuesta = new Respuesta<>();
        respuesta.Mensaje = "Metodo GET";
        return respuesta;
    }

    private Respuesta<T> PUT() {
        Respuesta<T> respuesta = new Respuesta<>();
        respuesta.Mensaje = "Metodo PUT";
        return respuesta;
    }

    private Respuesta<T> DELETE() {
        Respuesta<T> respuesta = new Respuesta<>();
        respuesta.Mensaje = "Metodo DELETE";
        return respuesta;
    }
}
