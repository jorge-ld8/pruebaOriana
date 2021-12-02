package logica.ficheros;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import logica.usuario.Empresa;
import java.util.ArrayList;
import logica.usuario.*;

public class ListaUsuariosEmpresas extends ListaUsuarios{

    private static ArrayList<Empresa> listaUsuariosEmpresas;
    private static JSONArray listaUsuariosEmpresasJSON;

    public ListaUsuariosEmpresas() {
        ListaUsuariosEmpresas.listaUsuariosEmpresas = new ArrayList<Empresa>();
        listaUsuariosEmpresasJSON = new JSONArray();
    }
    /**
     * Getter
     * @return devuelve el atributo listaUsuarios
     */
    public static ArrayList<Empresa> getListaUsuariosEmpresas() {
        return listaUsuariosEmpresas;
    }
    /**
     * Setter, modifica la información dentro del atributo listaUsuarios
     * @param listaUsuariosEmpresas parametro a modificar
     */
    public static void setListaUsuarioEmpresas(ArrayList<Empresa> listaUsuariosEmpresas) {
        ListaUsuariosEmpresas.listaUsuariosEmpresas = listaUsuariosEmpresas;
    }

    public static JSONArray getListaUsuariosEmpresasJSON() {
        return listaUsuariosEmpresasJSON;
    }
    /**
     * Setter, modifica la información dentro del atributo listaUsuariosJSON
     * @param listaUsuariosEmpresasJSON parametro a modificar
     */
    public static void setListaUsuariosEmpresasJSON(JSONArray listaUsuariosEmpresasJSON) {
        ListaUsuariosEmpresas.listaUsuariosEmpresasJSON = listaUsuariosEmpresasJSON;
    }
    /**
     * Metodo encargado de llenar los datos dentro de listaUsuarios
     */

    public static Empresa buscarUsuarioEmpresa(String email) {
        for (Empresa empresa: listaUsuariosEmpresas) {
            if (empresa.getEmail().compareTo(email)==0)
                return empresa;}
        return null;}

    public static boolean correoExisteEnEmpresasJSON(String correo)  {
        String palabra;
        for(int i=0;i<listaUsuariosEmpresasJSON.length();i++) {
            try {
                JSONObject json= (JSONObject) listaUsuariosEmpresasJSON.get(i);
                palabra=(String)json.get("correo");
                if (palabra.compareTo(correo)==0)
                    return true;
            } catch (JSONException e) {
                System.out.println("Error en verificar si el correo existe o no");
            }
        }
        return false;
    }

    public static void llenarListaEstaticaEmpresas() {
        Encrypt desencriptar = new Encrypt();
        LeerDatos leer = new LeerDatos();
        leer.leerListaEmpresas();
        JSONObject json = new JSONObject();
        for (int i = 0; i < listaUsuariosEmpresasJSON.length(); i++) {
            Empresa empresa = new Empresa();
            try {
                json = listaUsuariosEmpresasJSON.getJSONObject(i);
                empresa.setAddress((String) json.get("correo"));
                empresa.setPassword(desencriptar.getAESDecrypt((String) json.get("contraseña")));
                listaUsuariosEmpresas.add(empresa);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
