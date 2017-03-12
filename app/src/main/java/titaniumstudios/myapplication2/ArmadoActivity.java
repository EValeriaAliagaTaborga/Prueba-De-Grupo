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


public class ArmadoActivity extends AppCompatActivity {

    private ImageView imgHambQueso;
    private ImageView imgHambDoble;
    private ImageView imgHambSinPan;
    private ImageView imgHambTocino;
    private ImageView imgHambIntegral;
    private ImageView imgHambVegetariana;

    private static final int opcion1 = 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;

    private Context context;

    private boolean conCuenta = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armado);

        context=this;

        imgHambQueso=(ImageView)findViewById(R.id.imgHambQueso);
        imgHambDoble=(ImageView)findViewById(R.id.imgHambDoble);
        imgHambSinPan=(ImageView)findViewById(R.id.imgHambSinPan);
        imgHambTocino=(ImageView)findViewById(R.id.imgHambTocino);
        imgHambIntegral=(ImageView)findViewById(R.id.imgHambIntegral);
        imgHambVegetariana=(ImageView)findViewById(R.id.imgHambVegetariana);


        imgHambQueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                ArrayList<String> datosDePedido = new ArrayList<>();
                datosDePedido.add(0, "30");
                datosDePedido.add("Pan Tradicional");
                datosDePedido.add("Lechuga");
                datosDePedido.add("Tomate");
                datosDePedido.add("Queso Criollo");
                datosDePedido.add("Carne de res de 12 oz");
                datosDePedido.add("Queso Mozarella");
                datosDePedido.add("Pan Tradicional");
                intent.putExtra("datos_de_pedido", datosDePedido);
                startActivity(intent);
            }
        });
        imgHambDoble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                ArrayList<String> datosDePedido = new ArrayList<>();
                datosDePedido.add(0, "38");
                datosDePedido.add("Pan Tradicional");
                datosDePedido.add("Cebolla");
                datosDePedido.add("Tomate");
                datosDePedido.add("Lechuga");
                datosDePedido.add("Pepinillos");
                datosDePedido.add("Carne de res de 10 oz");
                datosDePedido.add("Queso Criollo");
                datosDePedido.add("Carne de res de 10 oz");
                datosDePedido.add("Pan Tradicional");
                intent.putExtra("datos_de_pedido", datosDePedido);
                startActivity(intent);
            }
        });
        imgHambSinPan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                ArrayList<String> datosDePedido = new ArrayList<>();
                datosDePedido.add(0, "29");
                datosDePedido.add("Lechuga");
                datosDePedido.add("Queso Cheddar");
                datosDePedido.add("Carne de res de 12 oz");
                datosDePedido.add("Tomate");
                datosDePedido.add("Pepinillos");
                datosDePedido.add("Lechuga");
                intent.putExtra("datos_de_pedido", datosDePedido);
                startActivity(intent);
            }
        });
        imgHambTocino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                ArrayList<String> datosDePedido = new ArrayList<>();
                datosDePedido.add(0, "32");
                datosDePedido.add("Pan Sin Semillas");
                datosDePedido.add("Queso Cheddar");
                datosDePedido.add("Huevo Frito");
                datosDePedido.add("Queso Gouda");
                datosDePedido.add("Tocino");
                datosDePedido.add("Carne de res de 8 oz");
                datosDePedido.add("Tomate");
                datosDePedido.add("Cebolla");
                datosDePedido.add("Lechuga");
                datosDePedido.add("Pan Sin Semillas");
                intent.putExtra("datos_de_pedido", datosDePedido);
                startActivity(intent);
            }
        });
        imgHambIntegral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                ArrayList<String> datosDePedido = new ArrayList<>();
                datosDePedido.add(0, "21");
                datosDePedido.add("Pan Integral");
                datosDePedido.add("Tomate");
                datosDePedido.add("Cebolla");
                datosDePedido.add("Lechuga");
                datosDePedido.add("Pepinillos");
                datosDePedido.add("Carne de pollo d 10 oz");
                datosDePedido.add("Pan Integral");
                intent.putExtra("datos_de_pedido", datosDePedido);
                startActivity(intent);
            }
        });
        imgHambVegetariana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,VerificacionDePedidoActivity.class);
                ArrayList<String> datosDePedido = new ArrayList<>();
                datosDePedido.add(0,"22");
                datosDePedido.add("Pan Integral");
                datosDePedido.add("Carne vegetariana de 10 oz");
                datosDePedido.add("Tomate");
                datosDePedido.add("Lechuga");
                datosDePedido.add("Pan Integral");
                intent.putExtra("datos_de_pedido", datosDePedido);
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
                        ArmadoActivity.this);

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
