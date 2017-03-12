package titaniumstudios.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GraciasActivity extends AppCompatActivity {

    private Button btnHecho;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gracias);

        context=this;

        btnHecho=(Button)findViewById(R.id.btnHecho);

        btnHecho.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent s=new Intent(context,ClienteFrecuenteActivity.class);
                startActivity(s);
            }
        });
    }
}
