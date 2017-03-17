package titaniumstudios.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnSignIn;

    private Context context;
    private ImageView imgLogo;

    private MenuDeArriba menuDeArriba = new MenuDeArriba();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

        //si existe una cuenta guardada no entra a la pantalla del logo, directo al menu
        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        String usuario_almacenado = prefs.getString("usuario","no");
        String password_almacenado = prefs.getString("password","no");

        if(usuario_almacenado.compareTo("no")!=0 && password_almacenado.compareTo("no")!=0)
        {
            Intent a=new Intent(getApplicationContext(),MenuActivity.class);
            menuDeArriba.setConCuenta(true);
            finish();
            startActivity(a);
        }



        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        imgLogo=(ImageView) findViewById(R.id.imageView3);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent a=new Intent(context,LoginActivity.class);
                a.putExtra("datos_de_cliente", new String[]{"","","","","","",""});
                startActivity(a);

            }
        });


        imgLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent a=new Intent(context,MenuActivity.class);
                //a.putExtra("con_cuenta", false);
                startActivity(a);
            }
        });

    }
    //hola c:

    //hola Vale xD

    //soy Diego
}
