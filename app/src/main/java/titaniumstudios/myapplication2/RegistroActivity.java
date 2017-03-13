package titaniumstudios.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private EditText txtNombre;
    private EditText txtUsuario;
    private EditText txtCelular;
    private EditText txtDomicilio;
    private EditText txtEmail;
    private EditText txtContrasenia;
    private EditText txtRepContrasenia;
    private EditText txtNombreFactura;
    private EditText txtNIT;
    private Button btnRegistrarse;

    Context context;

    String[] datosDeCliente = new String[8];
    private String contrasenia = "no";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        context = this;

        txtNombre = (EditText) findViewById(R.id.txtNombreyApellido);
        txtUsuario = (EditText) findViewById(R.id.txtNombreUsuario);
        txtCelular = (EditText) findViewById(R.id.txtCelularTelefono);
        txtContrasenia = (EditText) findViewById(R.id.txtContrasenia);
        txtRepContrasenia = (EditText) findViewById(R.id.txtRepContrasenia);
        txtDomicilio = (EditText) findViewById(R.id.txtDomicilio);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtNombreFactura = (EditText) findViewById(R.id.txtNomFac);
        txtNIT = (EditText) findViewById(R.id.txtNIT);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);



        /*if(txtContrasenia.getText().toString().compareTo(txtRepContrasenia.getText().toString()) == 0) {
           contrasenia = txtContrasenia.getText().toString();
        } else {
            contrasenia = "no";
        }*/

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                datosDeCliente[0] = txtNombre.getText().toString();
                datosDeCliente[1] = txtUsuario.getText().toString();
                datosDeCliente[2] = txtCelular.getText().toString();
                datosDeCliente[3] = txtDomicilio.getText().toString();
                datosDeCliente[4] = txtEmail.getText().toString();
                datosDeCliente[5] = txtNombreFactura.getText().toString();
                datosDeCliente[7] = txtNIT.getText().toString();

                if(txtContrasenia.getText().toString().compareTo(txtRepContrasenia.getText().toString()) == 0 && datosDeCliente[1].compareTo("") != 0 &&
                        datosDeCliente[0].compareTo("") != 0 && (datosDeCliente[2].length() == 7 || datosDeCliente[2].length() == 8) &&
                        datosDeCliente[4].contains("@") && datosDeCliente[4].contains(".")) {
                    datosDeCliente[6] = txtContrasenia.getText().toString();
                    Intent intent = new Intent(context, LoginActivity.class);
                    intent.putExtra("datos_de_cliente", datosDeCliente);
                    startActivity(intent);

                } else {
                        Toast.makeText(context, "Debe llenar los campos obligatoios (*) correctamente", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}


