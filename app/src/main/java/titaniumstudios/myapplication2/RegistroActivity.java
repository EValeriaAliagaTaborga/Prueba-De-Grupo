package titaniumstudios.myapplication2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private MenuDeArriba menuDeArriba = new MenuDeArriba();

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

    private static final int opcion1 = 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;


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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menuDeArriba.menuDeArriba(menu);
        /*if (conCuenta) {
            menu.add(Menu.NONE, opcion1, Menu.NONE, "Perfil")
                    .setIcon(android.R.drawable.ic_menu_add);
            menu.add(Menu.NONE, opcion2, Menu.NONE, "Historial")
                    .setIcon(android.R.drawable.stat_notify_sdcard_prepare);
        }
        menu.add(Menu.NONE, opcion3, Menu.NONE, "Detalles de la app")
                .setIcon(android.R.drawable.ic_dialog_info);

        if (conCuenta) {
            menu.add(Menu.NONE, opcion4, Menu.NONE, "Cerrar Sesión")
                    .setIcon(android.R.drawable.ic_dialog_info);
        } else {
            menu.add(Menu.NONE, opcion5, Menu.NONE, "Login")
                    //cambiar esto creo xD
                    .setIcon(android.R.drawable.ic_dialog_info);
        }*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case opcion4:
                AlertDialog.Builder Dialogo = new AlertDialog.Builder(
                        RegistroActivity.this);

                Dialogo.setTitle("Atención!");
                Dialogo.setMessage("¿Seguro que desea cerrar sesión?");

                Dialogo.setPositiveButton("Si",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //cambiar los datos de MisPreferencias como pa q se borre

                                //Abrimos el archivo de preferencias
                                SharedPreferences prefs =
                                        getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);

                                //Editamos los campos existentes y en este caso borramos la cuenta existente
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putString("usuario", "no");
                                editor.putString("password", "no");
                                menuDeArriba.setConCuenta(false);
                                //Concretamos la edicion
                                editor.commit(); //pa guardar


                                Intent intent = new Intent(context, MainActivity.class);
                                finish();
                                startActivity(intent);
                            }
                        });
                Dialogo.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Ten mas cuidado con lo que presionas", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        });
                Dialogo.show();

                break;
            case opcion5:
                Intent intent = new Intent(context, LoginActivity.class);
                intent.putExtra("datos_de_cliente", new String[]{"","","","","","",""});
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }



}


