package titaniumstudios.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class ArmadoActivity extends AppCompatActivity {

    private static final int opcion1= 1;
    private static final int opcion2 = 2;
    private static final int opcion3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armado);
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
