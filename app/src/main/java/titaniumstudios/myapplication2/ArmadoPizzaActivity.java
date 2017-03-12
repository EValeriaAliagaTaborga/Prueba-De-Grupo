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
import android.widget.Toast;

import java.util.ArrayList;

public class ArmadoPizzaActivity extends AppCompatActivity {

    private ImageView imgPizzaCarnivora;
    private ImageView imgPizzaHawaiana;
    private ImageView imgPizzaQueso;
    private ImageView imgPizzaAceitunas;
    private ImageView imgPizzaSetas;
    private ImageView imgPizzaVegetariana;

    private static final int opcion1 = 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;
    private static final int opcion5 = 5;

    private Context context;

    private boolean conCuenta = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armado_pizza);

        context=this;

        Intent d=getIntent();
        conCuenta = d.getBooleanExtra("con_cuenta", true);

        imgPizzaCarnivora=(ImageView)findViewById(R.id.imgPizzaCarnivora);
        imgPizzaHawaiana=(ImageView)findViewById(R.id.imgPizzaHawaiana);
        imgPizzaQueso=(ImageView)findViewById(R.id.imgPizzaQueso);
        imgPizzaAceitunas=(ImageView)findViewById(R.id.imgPizzaAceitunas);
        imgPizzaSetas=(ImageView)findViewById(R.id.imgPizzaSetas);
        imgPizzaVegetariana=(ImageView)findViewById(R.id.imgPizzaVegetariana);

        imgPizzaCarnivora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                ArrayList<String> datosDePedido = new ArrayList<String>();
                datosDePedido.add(0, "77");
                datosDePedido.add("Oregano");
                datosDePedido.add("Carne molida");
                datosDePedido.add("Pepperoni");
                datosDePedido.add("Jamon");
                datosDePedido.add("Mozarella");
                datosDePedido.add("Salsa de Tomate Tradicional");
                intent.putStringArrayListExtra("datos_de_pedido",datosDePedido);
                intent.putExtra("con_cuenta", conCuenta);
                startActivity(intent);
            }
        });
        imgPizzaHawaiana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                ArrayList<String> datosDePedido = new ArrayList<String>();
                datosDePedido.add(0, "66");
                datosDePedido.add("Piña");
                datosDePedido.add("Cereza Cherry");
                datosDePedido.add("Jamon");
                datosDePedido.add("Mozarella");
                datosDePedido.add("Salsa de Tomate Tradicional");
                intent.putStringArrayListExtra("datos_de_pedido",datosDePedido);
                intent.putExtra("con_cuenta", conCuenta);
                startActivity(intent);
            }
        });
        imgPizzaQueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                ArrayList<String> datosDePedido = new ArrayList<String>();
                datosDePedido.add(0, "110");
                datosDePedido.add("Mozarella");
                datosDePedido.add("Cheddar");
                datosDePedido.add("Gouda");
                datosDePedido.add("Gruyere");
                datosDePedido.add("Oregano");
                datosDePedido.add("Salsa de Tomate Tradicional");
                intent.putStringArrayListExtra("datos_de_pedido",datosDePedido);
                intent.putExtra("con_cuenta", conCuenta);
                startActivity(intent);
            }
        });
        imgPizzaAceitunas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                ArrayList<String> datosDePedido = new ArrayList<String>();
                datosDePedido.add(0, "77");
                datosDePedido.add("Pimientos");
                datosDePedido.add("Oregano");
                datosDePedido.add("Pepperoni");
                datosDePedido.add("Jamon");
                datosDePedido.add("Chorizo");
                datosDePedido.add("Cheddar");
                datosDePedido.add("Salsa de Tomate Tradicional");
                datosDePedido.add("Salsa de Tomate Picante");
                datosDePedido.add("Aceitunas");
                intent.putStringArrayListExtra("datos_de_pedido",datosDePedido);
                intent.putExtra("con_cuenta", conCuenta);
                startActivity(intent);
            }
        });
        imgPizzaSetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                ArrayList<String> datosDePedido = new ArrayList<String>();
                datosDePedido.add(0, "60");
                datosDePedido.add("Champiñones");
                datosDePedido.add("Locoto en polvo");
                datosDePedido.add("Jamon");
                datosDePedido.add("Gouda");
                datosDePedido.add("Salsa de Tomate Tradicional");
                intent.putStringArrayListExtra("datos_de_pedido",datosDePedido);
                intent.putExtra("con_cuenta", conCuenta);
                startActivity(intent);
            }
        });
        imgPizzaVegetariana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                ArrayList<String> datosDePedido = new ArrayList<String>();
                datosDePedido.add(0, "52");
                datosDePedido.add("Pimientos");
                datosDePedido.add("Tomate");
                datosDePedido.add("Brocoli");
                datosDePedido.add("Champiñones");
                datosDePedido.add("Gruyere");
                datosDePedido.add("Salsa de Tomate Tradicional");
                intent.putStringArrayListExtra("datos_de_pedido",datosDePedido);
                intent.putExtra("con_cuenta", conCuenta);
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
                        ArmadoPizzaActivity.this);

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
