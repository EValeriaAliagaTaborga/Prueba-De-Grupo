package titaniumstudios.myapplication2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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
    private String producto = "";

    //Variables del menu
    private static final int opcion1 = 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        context = this;

        imgHamburguesa = (ImageView) findViewById(R.id.imgHamburguesa);
        imgPizza = (ImageView) findViewById(R.id.imgPizza);
        imgExtras = (ImageView) findViewById(R.id.imgExtras);


        Intent d = getIntent();
        conCuenta = d.getBooleanExtra("con_cuenta", true);

        // debemos mandar un parametro q especifique el alimento para saber a qué layout nos van a mandar después
        imgHamburguesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                producto = "hamburguesa";
                Intent intent = new Intent(context, MenuEleccionActivity.class);
                intent.putExtra("producto", producto);
                intent.putExtra("con_cuenta", conCuenta);
                startActivity(intent);
            }
        });

        imgPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                producto = "pizza";
                Intent intent = new Intent(context, MenuEleccionActivity.class);
                intent.putExtra("con_cuenta", conCuenta);
                intent.putExtra("producto", producto);
                startActivity(intent);
            }
        });

        imgExtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ExtrasActivity.class);
                intent.putExtra("con_cuenta", conCuenta);
                startActivity(intent);
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
        } else {
            menu.add(Menu.NONE, opcion5, Menu.NONE, "Login")
                    //cambiar esto creo xD
                    .setIcon(android.R.drawable.ic_dialog_info);
        }
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case opcion3:
                //Layout inflater será el método para agregar un mayout
                LayoutInflater inflater = getLayoutInflater();
                //Utilizaremos el layout llamado layout_toast que contiene el id específico layout_vista
                View layouttoast = inflater.inflate(R.layout.layout_toast, (ViewGroup)findViewById(R.id.layout_vista));
                //Llenamos el TextView con id=texto con el mensaje
                ((TextView) layouttoast.findViewById(R.id.texto)).setText("Comer un hamburguesa es un placer irresistible para muchos y es por eso que los restaurantes de comida rápida proliferan. El exquisito sabor de la carne al pan es una de las cosas en que muchas personas coinciden. Aunque para los más saludables sea una comida rápida que daña el cuerpo, es bueno conocer su trayectoria. Una hamburguesa es un alimento en forma de bocadillo de carne picada aglutinada en forma de filete, cocinado a la parrilla o a la plancha, aunque también puede freírse u hornearse. Fuera del ámbito de habla hispana es más común encontrar la denominación inglesa burger. Se presenta en un pan ligero partido en dos que posee una forma de óvalo. Suele estar acompañada de aros de cebolla, hojas de lechuga, alguna rodaja de tomate, láminas de encurtidos, papas fritas etc.");

                //Declaramos el context
                Toast mensaje = new Toast(getBaseContext());

                //Declaramos la ubicación en pantalla
                mensaje.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //Declaramos el contenido
                mensaje.setView(layouttoast);
                mensaje.setDuration(Toast.LENGTH_LONG);
                mensaje.show();
             break;
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
                                        getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

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


