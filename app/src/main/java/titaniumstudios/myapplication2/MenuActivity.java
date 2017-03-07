package titaniumstudios.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    private ImageView imgHamburguesa;
    private ImageView imgPizza;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        context=this;

        imgHamburguesa=(ImageView)findViewById(R.id.imgHamburguesa);
        imgPizza=(ImageView)findViewById(R.id.imgPizza);


        Intent d=getIntent();
        String[] datos_recibidos=new String[2];
        datos_recibidos=d.getStringArrayExtra("datos_usuario");

        // debemos mandar un parametro q especifique el alimento para saber a qué layout nos van a mandar después
        imgHamburguesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,MenuHamburguesaActivity.class);
                startActivity(intent);
            }
        });

        imgPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,MenuHamburguesaActivity.class);
                startActivity(intent);
            }
        });
    }
}
