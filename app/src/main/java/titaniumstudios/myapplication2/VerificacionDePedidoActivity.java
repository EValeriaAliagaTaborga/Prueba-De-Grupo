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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class VerificacionDePedidoActivity extends AppCompatActivity {

    private Button btnAnadir;
    private Button btnComprar;
    private TextView lblPrecio;
    private TextView lblTextoLargo;

    private Context context = this;

    private static final int opcion1 = 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;

    private boolean conCuenta = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificacion_de_pedido);

        Intent b = getIntent();
        conCuenta = b.getBooleanExtra("con_cuenta", true);
        ArrayList<String> datosDePedido = b.getStringArrayListExtra("datos_de_pedido");
        String precio = datosDePedido.get(0);
        String producto = "";
        for(int i = 1; i < datosDePedido.size(); i++) {
                producto += datosDePedido.get(i)+"\n";
        }



        btnAnadir=(Button)findViewById(R.id.btnAnadir);
        btnComprar=(Button)findViewById(R.id.btnComprar);
        lblPrecio=(TextView) findViewById(R.id.lblPrecio);
        lblTextoLargo=(TextView) findViewById(R.id.lblTextoLargo);

        lblPrecio.setText("Bs. "+precio);
        lblTextoLargo.setText("Su pedido contiene: \n"+producto);

        btnAnadir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent s=new Intent(context,MenuActivity.class);
                s.putExtra("con_cuenta", conCuenta);
                startActivity(s);
            }
        });
        btnComprar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent s=new Intent(context,DatosYFacturacionActivity.class);
                s.putExtra("con_cuenta", conCuenta);
                startActivity(s);
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
                        VerificacionDePedidoActivity.this);

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

    //hola
}
