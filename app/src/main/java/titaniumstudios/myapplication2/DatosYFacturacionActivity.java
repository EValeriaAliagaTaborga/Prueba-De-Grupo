package titaniumstudios.myapplication2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatosYFacturacionActivity extends AppCompatActivity {

    private Button btnEnviar;
    private EditText txtNombreOApellido;
    private EditText txtNombreFac;
    private EditText txtCelularOTel;
    private EditText txtDireccion;
    private EditText txtEmail;
    private EditText txtNIT;

    private Context context;

    private static final int opcion1 = 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;

    private boolean conCuenta = true;
    private String precioTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_y_facturacion);

        Intent d=getIntent();
        conCuenta = d.getBooleanExtra("con_cuenta", true);
        precioTotal = d.getStringExtra("dato_precio");

        context = this;

        btnEnviar=(Button)findViewById(R.id.btnEnviar);
        txtNombreOApellido=(EditText) findViewById(R.id.txtNombreOApellido);
        txtNombreFac=(EditText) findViewById(R.id.txtNombreFac);
        txtCelularOTel=(EditText) findViewById(R.id.txtCelularOTel);
        txtDireccion=(EditText) findViewById(R.id.txtDireccion);
        txtEmail=(EditText) findViewById(R.id.txtEmail);
        txtNIT=(EditText) findViewById(R.id.txtNIT);



        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String[] datosDeCliente = new String[7];

                datosDeCliente[0] = txtNombreOApellido.getText().toString();
                datosDeCliente[1] = txtNombreFac.getText().toString();
                datosDeCliente[2] = txtCelularOTel.getText().toString();
                datosDeCliente[3] = txtDireccion.getText().toString();
                datosDeCliente[4] = txtEmail.getText().toString();
                datosDeCliente[5] = txtNIT.getText().toString();
                datosDeCliente[6] = precioTotal;

                if((datosDeCliente[2].length() == 7 || datosDeCliente[2].length() == 8 ) && !datosDeCliente[3].equals("")) {
                    Intent intent = new Intent(context, VerificarFacturaActivity.class);
                    intent.putExtra("con_cuenta", conCuenta);
                    intent.putExtra("datos_de_cliente", datosDeCliente);
                    startActivity(intent);
                } else {
                    Toast.makeText(context, "El campo de telefono y direccion son obligatorios, por favor llenar los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (conCuenta) {
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
        }else {
            menu.add(Menu.NONE, opcion5, Menu.NONE, "Login")
                    //cambiar esto creo xD
                    .setIcon(android.R.drawable.ic_dialog_info);
        }
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case opcion4:
                AlertDialog.Builder Dialogo = new AlertDialog.Builder(
                        DatosYFacturacionActivity.this);

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
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
