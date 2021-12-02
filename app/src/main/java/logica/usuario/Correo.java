package logica.usuario;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Clase encargada de manejar la información de los correos
 *
 */
public class Correo {
    /**
     * Unico atributo tipo string donde se almacena el correo ingresado
     */
    private String address;
    /**
     * Constructor donde se incializa el atributo en vacio
     */
    public Correo() {
        address = "";
    }
    /**
     * Constructor donde se inicializa el atributo address
     * @param address valor a pasarle al atributo address
     */
    public Correo(String address) {
        this.address = address;
    }
    /**
     * Setter, se encarga de modificar el parametro address
     * @param address valor a pasarle al atributo address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * Getter
     * @return devuelve el atributo address
     */
    public String getAddress() {
        return address;
    }
    /**
     * Valida que sea un correo sintacticamente correcto
     * @param correo correo a validar
     * @return true o false segun corresponda
     */
    public boolean read(String correo) {
        // Establece un patrón
        Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        // Verifica si ese patrón coincide
        Matcher mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }
}
