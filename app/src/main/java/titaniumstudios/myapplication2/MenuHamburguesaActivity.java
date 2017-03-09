package titaniumstudios.myapplication2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MenuHamburguesaActivity extends AppCompatActivity {

    //creo q esta clase su puede llamar DecisionActivty (ya q es donde decides armar o usar predefinida)
    //para saber a que layout mandar podemos guardar en una variable y utilizar en condiciones

    private ImageView imgArmalo;
    private ImageView imgArmado;

    private Context context;

    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_hamburguesa);
        context=this;

        imgArmalo=(ImageView)findViewById(R.id.imgArmalo);
        imgArmado=(ImageView)findViewById(R.id.imgArmado);

        imgArmado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,ArmadoActivity.class);
                startActivity(intent);
            }
        });

        imgArmalo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder Dialogo = new AlertDialog.Builder(
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
                Dialogo.show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, opcion1, Menu.NONE, "Perfil")
                .setIcon(android.R.drawable.ic_menu_add);
        menu.add(Menu.NONE, opcion2, Menu.NONE, "Historial")
                .setIcon(android.R.drawable.stat_notify_sdcard_prepare);
        menu.add(Menu.NONE, opcion3, Menu.NONE, "Detalles de la app")
                .setIcon(android.R.drawable.ic_dialog_info);
        return true;
    }
}
