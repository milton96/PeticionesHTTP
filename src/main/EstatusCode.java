package main;

public class EstatusCode {

    // 2XX success
    public record OK() {
        public static final int Estatus = 200;
        public static final String Mensaje = "OK";
    }

    // 4XX client errors
    public record METHOD_NOT_ALLOWED() {
        public static final int Estatus = 405;
        public static final String Mensaje = "METHOD_NOT_ALLOWED";
    }
}
