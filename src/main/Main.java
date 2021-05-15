package main;

import main.models.User;

public class Main {
    public static void main(String[] args) {
        System.out.println("Peticiones HTTP");

        User.ListaUsuarios();
        User.ObtenerUsuarioPorId(1);

    }
}
