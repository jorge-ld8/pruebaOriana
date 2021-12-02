package logica.ficheros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * Clase encargada de leer los datos dentro del archivo JSON
 */
public class LeerDatos {
    /**
     * Metodo encargado de realizar la correspondiente lectuta de la información
     * almacenada dentro del archivo JSON
     */
    public void leerListaClientes() {
        org.json.JSONArray jsonLista;
        JSONParser lectura = new JSONParser();
        //La ruta del archivo no debe ser específico.
        try (FileReader reader = new FileReader("files/usuariosClientes.json")) {
            Object objeto = lectura.parse(reader);
            jsonLista = (org.json.JSONArray) objeto;
            ListaUsuariosClientes.setListaUsuariosClientesJSON(jsonLista);
        }catch (FileNotFoundException e) {
        }
        catch (IOException e) {
        }
        catch (ParseException e) {
        }
    }

       public void leerListaEmpresas() {
        org.json.JSONArray jsonLista;
        JSONParser lectura = new JSONParser();
        //La ruta del archivo no debe ser específico.
        try (FileReader reader = new FileReader("files/usuariosEmpresas.json")) {
            Object objeto = lectura.parse(reader);
            jsonLista = (org.json.JSONArray) objeto;
            ListaUsuariosEmpresas.setListaUsuariosEmpresasJSON(jsonLista);
        }catch (FileNotFoundException e) {
        }
        catch (IOException e) {
        }
        catch (ParseException e) {
        }

    }
}
