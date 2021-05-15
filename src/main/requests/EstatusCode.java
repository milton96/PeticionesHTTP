package main.requests;

public class EstatusCode {

    // 2XX success
    public record OK() {
        public static final int Estatus = 200;
        public static final String Mensaje = "OK";
    }

    // 4XX client errors
    public record BAD_REQUEST() {
        public static final int Estatus = 400;
        public static final String Mensaje = "BAD_REQUEST";
    }
    public record METHOD_NOT_ALLOWED() {
        public static final int Estatus = 405;
        public static final String Mensaje = "METHOD_NOT_ALLOWED";
    }
}
