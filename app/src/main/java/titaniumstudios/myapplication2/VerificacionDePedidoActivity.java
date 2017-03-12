package titaniumstudios.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class VerificacionDePedidoActivity extends AppCompatActivity {

    private Button btnAnadir;
    private Button btnComprar;

    private Context context = this;

    private static final int opcion1 = 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;
    private static final int opcion4 = 4;

    private boolean conCuenta = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificacion_de_pedido);

        btnAnadir=(Button)findViewById(R.id.btnAnadir);
        btnComprar=(Button)findViewById(R.id.btnComprar);

        btnAnadir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent s=new Intent(context,MenuActivity.class);
                startActivity(s);
            }
        });
        btnComprar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent s=new Intent(context,DatosYFacturacionActivity.class);
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
        }
        return true;
    }
}
