package logica.ficheros;

import java.util.*;
import org.json.*;
import logica.usuario.Cliente;
import logica.usuario.Encrypt;


import java.lang.*;

public class ListaUsuariosClientes extends ListaUsuarios {

    private static ArrayList<Cliente> listaUsuariosClientes;
    private static JSONArray listaUsuariosClientesJSON;

    /**
     * Constructor donde se declaran los atributos
     */
    public ListaUsuariosClientes() {
        ListaUsuariosClientes.listaUsuariosClientes=new ArrayList<>();
        listaUsuariosClientesJSON= new JSONArray();
    }
    /**
     * Getter
     * @return devuelve el atributo listaUsuarios
     */
    public static ArrayList<Cliente> getListaUsuariosClientes() {
        return listaUsuariosClientes;
    }
    /**
     * Setter, modifica la información dentro del atributo listaUsuarios
     * @param listaUsuariosClientes parametro a modificar
     */
    public static void setListaUsuariosClientes(ArrayList<Cliente> listaUsuariosClientes) {
        ListaUsuariosClientes.listaUsuariosClientes = listaUsuariosClientes;
    }
    /**
     * Getter
     * @return devuelve el atributo listaUsuariosJSON
     */
    public static JSONArray getListaUsuariosClientesJSON() {
        return listaUsuariosClientesJSON;
    }
    /**
     * Setter, modifica la información dentro del atributo listaUsuariosJSON
     * @param listaUsuariosJSON parametro a modificar
     */
    public static void setListaUsuariosClientesJSON(JSONArray listaUsuariosJSON) {
        ListaUsuariosClientes.listaUsuariosClientesJSON = listaUsuariosClientesJSON;
    }
    /**
     * Metodo encargado de llenar los datos dentro de listaUsuarios
     */

    public static Cliente buscarUsuarioClientes(String email) {
        for (Cliente cliente: listaUsuariosClientes) {
            if (cliente.getEmail().compareTo(email)==0)
                return cliente;}
        return null;}

    public static boolean correoExisteEnClientesJSON(String correo)  {
        String palabra;
        for(int i=0;i<listaUsuariosClientesJSON.length();i++) {
            try {
                JSONObject json= (JSONObject) listaUsuariosClientesJSON.get(i);
                palabra=(String)json.get("correo");
                if (palabra.compareTo(correo)==0)
                    return true;
            } catch (JSONException e) {
                System.out.println("Error en verificar si el correo existe o no");
            }
        }
        return false;
    }

    public static void llenarListaEstaticaClientes() {
        Encrypt desencriptar=new Encrypt();
        LeerDatos leer=new LeerDatos();
        leer.leerListaClientes();
        JSONObject json;
        for(int i=0;i<listaUsuariosClientesJSON.length();i++){
            Cliente cliente=new Cliente();
            try {
                json = (JSONObject) listaUsuariosClientesJSON.get(i);
                cliente.setAddress((String) json.get("correo"));
                cliente.setPassword(desencriptar.getAESDecrypt((String) json.get("contraseña")));
                listaUsuariosClientes.add(cliente);
            } catch (JSONException e) {
                System.out.println("Error al guardar datos del json en lista de clientes");
            }
           }
     }

}