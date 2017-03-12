package titaniumstudios.myapplication2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MenuHamburguesaActivity extends AppCompatActivity {

    //creo q esta clase su puede llamar DecisionActivty (ya q es donde decides armar o usar predefinida)
    //para saber a que layout mandar podemos guardar en una variable y utilizar en condiciones

    private ImageView imgArmalo;
    private ImageView imgArmado;

    private Context context;

    private static final int opcion1 = 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;

    private boolean conCuenta = true;
    private String producto = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_hamburguesa);

        context = this;

        Intent d=getIntent();
        conCuenta = d.getBooleanExtra("con_cuenta", true);
        producto = d.getStringExtra("producto");

        imgArmalo = (ImageView) findViewById(R.id.imgArmalo);
        imgArmado = (ImageView) findViewById(R.id.imgArmado);

        imgArmado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ArmadoActivity.class);
                intent.putExtra("con_cuenta", conCuenta);
                startActivity(intent);
            }
        });


        imgArmalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* AlertDialog.Builder Dialogo = new AlertDialog.Builder(
                        MenuHamburguesaActivity.this);

                Dialogo.setTitle("Estimado Cliente:");
                Dialogo.setMessage("Muchas gracias por usar nuestros servicios. ¿Esta seguro de desear proseguir con su elección?");
                Dialogo.setIcon(R.drawable.cubo);

                Dialogo.setPositiveButton("Si",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Prontamente pondremos a su disposición el Layout correspondiente para eso.", Toast.LENGTH_SHORT).show();
                            }
                        });
                Dialogo.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Tenga un buen día.", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        });
                Dialogo.show();*/
               if(producto.compareTo("hamburguesa") == 0) {
                   Intent intent = new Intent(context, ArmaloActivity.class);
                   intent.putExtra("con_cuenta", conCuenta);
                   startActivity(intent);
               } else if(producto.compareTo("pizza") == 0) {
                   Intent intent = new Intent(context, ArmaloPizzaActivity.class);
                   intent.putExtra("con_cuenta", conCuenta);
                   startActivity(intent);
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
        } else {
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
                        MenuHamburguesaActivity.this);

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


