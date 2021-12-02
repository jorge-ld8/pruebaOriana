package logica.usuario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Clase encargada de manejar la información de las contraseñas de los usuarios
 * @author Grupo4
 */
public class Password {
    /**
     * Unico atributo donde se almacenará las contraseñas ingresadas
     */
    private String password;
    /**
     * Constructor vacío
     */
    public Password() {
    }

    public Password(String password) {
        this.password = password;
    }

    /**
     * Getter
     * @return devuelve el atributo password
     */
    public String getPassword() {
        return password;
    }
    /**
     * Setter, modifica la información del atributo password
     * @param password contraseña
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Se encarga de buscar los caracteres correspondientes para la validación
     * @param password contraseña en la cual se buscará
     * @param buscar caracteres a buscar
     * @return true o false segun corresponda
     */
    public boolean Encontrar(String password, String buscar) {
        String regex = buscar;
        Pattern patron = Pattern.compile(regex);
        Matcher m = patron.matcher(password);
        boolean result = m.find();
        return result;
    }
    /**
     * Se encarga de validar si la contraseña cumple con todos los requisitos necesarios para que sea correcta
     * @param password contraseña a validar
     * @return true o false según corresponda
     */
    public boolean ValidarPassword(String password) {

        boolean mayuscula = false, especial = false, caracter = false, numero = false;

        numero = Encontrar(password, "[0123456789]");
        especial = Encontrar(password, "[$&+,:;=?@#|'<>.^*()%!-]");
        mayuscula = Encontrar(password, "[ABCDEFGHIJKLMNÑOPQRSTUVWXYZ]");
        caracter = Encontrar(password, "[abcdefghijklmnñopqrstuvwxyz]");

        if ((password.length() >= 8) && (mayuscula) && (especial) && (numero) && (caracter)) {
            return true;
        } else {
            return false;
        }
    }
}