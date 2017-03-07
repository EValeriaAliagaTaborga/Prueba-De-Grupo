package titaniumstudios.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnSignIn;

    private Context context;
    private ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context=this;

        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        imgLogo=(ImageView) findViewById(R.id.imageView3);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent a=new Intent(context,LoginActivity.class);
                startActivity(a);

            }
        });


        imgLogo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent a=new Intent(context,MenuActivity.class);
                startActivity(a);
            }
        });

    }
    //hola c:

    //hola Vale xD

    //soy Diego
}
