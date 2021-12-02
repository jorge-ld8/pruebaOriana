package edu.example.pruebadosproyectoandres;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import logica.ficheros.GuardarDatos;
import logica.ficheros.ListaUsuariosClientes;
import logica.ficheros.ListaUsuariosEmpresas;
import logica.usuario.*;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class InterfazRegistro extends AppCompatActivity {

    Empresa empresa;
    Cliente cliente;
    RadioButton userEmpresa, userCliente;

    public boolean validarDatosRegistro(String password1, String password2,
                                        String correo, RadioButton cliente,
                                        RadioButton empresa) {

        Password contrasena1 = new Password(password1);
        Password contrasena2 = new Password(password2);
        Correo email = new Correo(correo);

        if (email.read(email.getAddress())) {
            if (contrasena1.ValidarPassword(contrasena1.getPassword())) {
                if (contrasena1.getPassword().compareTo(contrasena2.getPassword()) == 0) {
                    if ((empresa.isChecked()) || (cliente.isChecked())) {
                        return true;
                    } else {
                        TextView advertencia = findViewById(R.id.advertencia2);
                        advertencia.setText("Debe seleccionar un tipo de usuario");
                    }
                } else {
                    TextView advertencia = findViewById(R.id.advertencia2);
                    advertencia.setText("Las contraseñas no coinciden");
                }
            } else {
                TextView advertencia = findViewById(R.id.advertencia2);
                advertencia.setText("La contraseña debe cumplir con las indicaciones");
            }
        } else {
            TextView advertencia = findViewById(R.id.advertencia2);
            advertencia.setText("Correo no valido");
        }
        return false;
    }

    public void buttonPress(View view) {
        EditText correoIngresado = findViewById(R.id.editTextTextEmailAddress2);
        EditText passwordIngresado = findViewById(R.id.editTextTextPassword2);
        EditText passwordIngresado2 = findViewById(R.id.editTextTextPassword3);
        String correo, password, passwordConfirmacion;
        correo = correoIngresado.getText().toString();
        password = passwordIngresado.getText().toString();
        passwordConfirmacion = passwordIngresado2.getText().toString();

        userEmpresa = findViewById(R.id.radioButton);
        userCliente = findViewById(R.id.radioButton2);

        if (validarDatosRegistro(password, passwordConfirmacion, correo, userCliente, userEmpresa)) {
            if (userEmpresa.isChecked()) {
                empresa = new Empresa(correo, password, 'e');
                ListaUsuariosEmpresas.getListaUsuariosEmpresas().add(empresa);
                GuardarDatos.procesoGuardadoEmpresas();
                //Toast.makeText(getApplicationContext(), "¡usuario empresa registrado existosamente!", Toast.LENGTH_SHORT).show();
            }
            if (userCliente.isChecked()) {
                cliente = new Cliente(password, correo, 'c');
                ListaUsuariosClientes.getListaUsuariosClientes().add(cliente);
                GuardarDatos.procesoGuardadoClientes();
                //Toast.makeText(getApplicationContext(), "¡usuario cliente registrado existosamente!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interfaz_registro);
        EditText correoIngresado = findViewById(R.id.editTextTextEmailAddress2);
        EditText passwordIngresado = findViewById(R.id.editTextTextPassword2);
        EditText passwordIngresado2 = findViewById(R.id.editTextTextPassword3);
        String correo, password, passwordConfirmacion;
        userEmpresa = findViewById(R.id.radioButton);
        userCliente = findViewById(R.id.radioButton2);
        Button button=findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarDatosRegistro(passwordIngresado.getText().toString(),
                        passwordIngresado2.getText().toString(),correoIngresado.getText().toString(),
                        userCliente,userEmpresa)){
                    Intent intent= new Intent(InterfazRegistro.this, EnvioDelCorreo.class);
                    EditText correoIngresado = findViewById(R.id.editTextTextEmailAddress2);
                    String correo= correoIngresado.getText().toString();
                    intent.putExtra("correo",correo);
                    startActivity(intent);
                }
                else{
                    TextView advertencia = findViewById(R.id.advertencia2);
                    advertencia.setText("Debe llenar los campos correctamente");
                }
            }
        });
    }
}