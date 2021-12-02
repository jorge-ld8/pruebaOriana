package logica.ficheros;

import java.io.*;
import logica.usuario.*;
import org.json.*;

public class GuardarDatos {

    public static void procesoGuardadoClientes() {
        Cliente cliente;
        GuardarDatos guardar= new GuardarDatos();
        for (Cliente usuarioCliente: ListaUsuariosClientes.getListaUsuariosClientes()) {
            if(!ListaUsuariosClientes.correoExisteEnClientesJSON(usuarioCliente.getEmail())) {
                cliente = (Cliente) ListaUsuariosClientes.buscarUsuarioClientes(usuarioCliente.getEmail());
                cliente.llenarObjetoClienteJson(cliente);
                ListaUsuariosClientes.agregarUsuarioAListaJSON(cliente.getUsuarioJSON(), ListaUsuariosClientes.getListaUsuariosClientesJSON());}
        }
        guardar.agregarAJsonClientes(ListaUsuariosClientes.getListaUsuariosClientesJSON());
    }

    public static void procesoGuardadoEmpresas() {
        Empresa empresa;
        GuardarDatos guardar= new GuardarDatos();
        for (Empresa usuarioEmpresa: ListaUsuariosEmpresas.getListaUsuariosEmpresas()) {
            if(!ListaUsuariosEmpresas.correoExisteEnEmpresasJSON(usuarioEmpresa.getEmail())) {
                empresa= (Empresa) ListaUsuariosEmpresas.buscarUsuarioEmpresa(usuarioEmpresa.getEmail());
                empresa.llenarObjetoEmpresaJson(empresa);
                ListaUsuariosEmpresas.agregarUsuarioAListaJSON(empresa.getUsuarioJSON(),ListaUsuariosEmpresas.getListaUsuariosEmpresasJSON());}
        }
        guardar.agregarAJsonEmpresas(ListaUsuariosEmpresas.getListaUsuariosEmpresasJSON());
    }

    public void agregarAJsonEmpresas(JSONArray ListaJson) {
        try(FileWriter archivo= new FileWriter (" C:\\Users\\Andres\\AndroidStudioProjects\\pruebaDosProyectoAndres\\app\\files\\usuariosEmpresas.json")){
            BufferedWriter buffer= new BufferedWriter (archivo);
            buffer.write(ListaJson.toString());
            buffer.close();
        }

        catch (IOException e){
            System.out.println("Problemas al ingresar un dato al archivo");
        }
    }

    public void agregarAJsonClientes(JSONArray ListaJson) {
        try(FileWriter archivo= new FileWriter ("C:\\Users\\Andres\\AndroidStudioProjects\\pruebaDosProyectoAndres\\app\\files\\\\usuariosClientes.json\"")){
            BufferedWriter buffer= new BufferedWriter (archivo);
            buffer.write(ListaJson.toString());
            buffer.close();
        }
        catch (IOException e){
            System.out.println("Problemas al ingresar un dato al archivo");
        }
    }

}
