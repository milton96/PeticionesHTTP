package main.models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.Respuesta;
import main.helpers.Global;
import main.requests.EstatusCode;
import main.requests.Peticion;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class User {
    private static final String URL = Global.BASE_URL + "users/";
    private float id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public float getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public static void ListaUsuarios() {
        System.out.println("Lista de usuarios");
        Peticion peticion = new Peticion(URL, Peticion.GET);
        Respuesta respuesta = peticion.HacerPeticion();
        if (respuesta.EstatusCode == EstatusCode.OK.Estatus) {
            ArrayList<User> users = User.JsonToArrayList(respuesta.Json);
            for (User user: users) {
                System.out.println(user.toString());
            }
        }
    }

    public static void ObtenerUsuarioPorId(int id) {
        System.out.println("Obtener un solo usuario");
        String url = URL + id;
        Peticion peticion = new Peticion(url, Peticion.GET);
        Respuesta respuesta = peticion.HacerPeticion();
        if (respuesta.EstatusCode == EstatusCode.OK.Estatus){
            User user = User.JsonToUser(respuesta.Json);
            System.out.println(user.toString());
        }
    }

    public static ArrayList<User> JsonToArrayList(String json) {
        Gson gson = new Gson();
        Type dataType = new TypeToken<ArrayList<User>>(){}.getType();
        return gson.fromJson(json, dataType);
    }

    public static User JsonToUser(String json) {
        Gson gson = new Gson();
        Type dataType = new TypeToken<User>(){}.getType();
        return gson.fromJson(json, dataType);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address.toString() +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company.toString() +
                '}';
    }
}
