package main;

import main.models.User;
import main.requests.EstatusCode;
import main.requests.Peticion;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Peticiones HTTP");

        System.out.println("URL Usuarios");
        String url_usuarios = "https://jsonplaceholder.typicode.com/users";
        Peticion<ArrayList<User>> peticion_usuarios = new Peticion<>(url_usuarios, Peticion.GET);
        Respuesta respuesta_usuarios = peticion_usuarios.HacerPeticion();
        if (respuesta_usuarios.EstatusCode == EstatusCode.OK.Estatus) {
            ArrayList<User> users = User.JsonToArrayList(respuesta_usuarios.Json);
            for (User user: users) {
                System.out.println(user.getId());
                System.out.println(user.getName());
                System.out.println(user.getUsername());
            }
        }
    }
}
