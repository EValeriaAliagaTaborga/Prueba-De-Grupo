package titaniumstudios.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuHamburguesaActivity extends AppCompatActivity {

    //creo q esta clase su puede llamar DecisionActivty (ya q es donde decides armar o usar predefinida)
    //para saber a que layout mandar podemos guardar en una variable y utilizar en condiciones

    private ImageView imgArmalo;
    private ImageView imgArmado;

    private Context context;

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
    }
}
