package logica.usuario;

import org.json.JSONException;
import org.json.JSONObject;

public class Cliente extends Usuario{

    public Cliente(){ }

    public Cliente (String password, String email,char tipoDeCuenta) {
        super(password, email,tipoDeCuenta);
        usuarioJSON=new JSONObject();
    }

    public void llenarObjetoClienteJson(Cliente cliente) {
        Encrypt encriptar=new Encrypt();
        cliente.setPassword(encriptar.getAES(cliente.getPassword()));
        try {
            getUsuarioJSON().put("contraseña",cliente.getPassword());
            getUsuarioJSON().put("correo",cliente.getEmail());
        } catch (JSONException e) {
            System.out.println("Error al insertar datos en JSON de Clientes");
        }
    }
}
