package titaniumstudios.myapplication2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MenuActivity extends AppCompatActivity {

    private ImageView imgHamburguesa;
    private ImageView imgPizza;
    private ImageView imgExtras;

    private Context context;

    private boolean conCuenta = true;
    private String producto ="";

    //Variables del menu
    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        context=this;

        imgHamburguesa=(ImageView)findViewById(R.id.imgHamburguesa);
        imgPizza=(ImageView)findViewById(R.id.imgPizza);
        imgExtras=(ImageView)findViewById(R.id.imgExtras);


        Intent d=getIntent();
        conCuenta = d.getBooleanExtra("con_cuenta", true);

        // debemos mandar un parametro q especifique el alimento para saber a qué layout nos van a mandar después
        imgHamburguesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                producto="hamburguesa";
                Intent intent=new Intent(context,MenuHamburguesaActivity.class);
                intent.putExtra("producto", producto);
                intent.putExtra("con_cuenta", false);
                startActivity(intent);
            }
        });

        imgPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                producto = "pizza";
                Intent intent=new Intent(context,MenuHamburguesaActivity.class);
                intent.putExtra("con_cuenta", false);
                intent.putExtra("producto", producto);
                startActivity(intent);
            }
        });

        imgExtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ExtrasActivity.class);
                intent.putExtra("con_cuenta", false);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(conCuenta) {
            menu.add(Menu.NONE, opcion1, Menu.NONE, "Perfil")
                    .setIcon(android.R.drawable.ic_menu_add);
            menu.add(Menu.NONE, opcion2, Menu.NONE, "Historial")
                    .setIcon(android.R.drawable.stat_notify_sdcard_prepare);
        }
            menu.add(Menu.NONE, opcion3, Menu.NONE, "Detalles de la app")
                    .setIcon(android.R.drawable.ic_dialog_info);
        if(conCuenta) {
            menu.add(Menu.NONE, opcion4, Menu.NONE, "Cerrar Sesión")
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
                        MenuActivity.this);

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

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
