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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class ExtrasActivity extends AppCompatActivity {

    private static final int opcion1 = 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;

    private Context context;
    private boolean conCuenta = true;

    private ArrayList<String> datosDePedido = new ArrayList<>();

    private LinearLayout lyPapasFritas;
    private LinearLayout lyCocaCola;
    private LinearLayout lyFanta;
    private LinearLayout lySprite;
    private LinearLayout lyArroz;
    private LinearLayout lyFideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extras);

        context = this;

        Intent d = getIntent();
        conCuenta = d.getBooleanExtra("con_cuenta", true);

        lyPapasFritas = (LinearLayout) findViewById(R.id.lyPapasFritas);
        lyCocaCola = (LinearLayout) findViewById(R.id.lyCocaCola);
        lyFanta = (LinearLayout) findViewById(R.id.lyFanta);
        lySprite = (LinearLayout) findViewById(R.id.lySprite);
        lyArroz = (LinearLayout) findViewById(R.id.lyArroz);
        lyFideo = (LinearLayout) findViewById(R.id.lyFideo);

        lyPapasFritas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                intent.putExtra("con_cuenta", conCuenta);
                datosDePedido.add(0, "10");
                datosDePedido.add("Papas fritas");
                intent.putStringArrayListExtra("datos_de_pedido", datosDePedido);
                startActivity(intent);
            }
        });

        lyCocaCola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                intent.putExtra("con_cuenta", conCuenta);
                datosDePedido.add(0, "8");
                datosDePedido.add("Coca Cola");
                intent.putStringArrayListExtra("datos_de_pedido", datosDePedido);
                startActivity(intent);
            }
        });

        lySprite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                intent.putExtra("con_cuenta", conCuenta);
                datosDePedido.add(0, "8");
                datosDePedido.add("Sprite");
                intent.putStringArrayListExtra("datos_de_pedido", datosDePedido);
                startActivity(intent);
            }
        });

        lyFanta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                intent.putExtra("con_cuenta", conCuenta);
                datosDePedido.add(0, "8");
                datosDePedido.add("Fanta");
                intent.putStringArrayListExtra("datos_de_pedido", datosDePedido);
                startActivity(intent);
            }
        });

        lyArroz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                intent.putExtra("con_cuenta", conCuenta);
                datosDePedido.add(0, "10");
                datosDePedido.add("Arroz");
                intent.putStringArrayListExtra("datos_de_pedido", datosDePedido);
                startActivity(intent);
            }
        });

        lyFideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                intent.putExtra("con_cuenta", conCuenta);
                datosDePedido.add(0, "10");
                datosDePedido.add("Fideo");
                intent.putStringArrayListExtra("datos_de_pedido", datosDePedido);
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
                        ExtrasActivity.this);

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
                intent.putExtra("datos_de_cliente", new String[]{"","","","","","",""});
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }
}
