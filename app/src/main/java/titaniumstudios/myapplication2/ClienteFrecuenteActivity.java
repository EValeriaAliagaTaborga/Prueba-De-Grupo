package titaniumstudios.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ClienteFrecuenteActivity extends AppCompatActivity {

    private Button btnRegMenu;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_frecuente);

        context=this;

        btnRegMenu=(Button)findViewById(R.id.btnRegMenu);

        btnRegMenu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent s=new Intent(context,MenuActivity.class);
                startActivity(s);
            }
        });
    }
}
