package titaniumstudios.myapplication2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText txtUsuario;
    private EditText txtPassword;
    private TextView txtResultado;


    String nombre_ingresado;
    String password_ingresado;

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context=this;

        SharedPreferences prefs =
                getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

        String usuario_almacenado = prefs.getString("usuario","no");
        String password_almacenado = prefs.getString("password","no");

        if(usuario_almacenado.compareTo("no")==0 && password_almacenado.compareTo("no")==0)
        {
            Intent a=new Intent(getApplicationContext(),MenuActivity.class);
            finish();
            startActivity(a);
        }

        Intent b=getIntent();

        btnLogin=(Button)findViewById(R.id.btnLogin);
        txtUsuario=(EditText)findViewById(R.id.txtUsuario);
        txtPassword=(EditText)findViewById(R.id.txtPassword);
        txtResultado=(TextView)findViewById(R.id.txtResultado);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                nombre_ingresado=txtUsuario.getText().toString();
                password_ingresado=txtPassword.getText().toString();

                SharedPreferences prefs =
                        getSharedPreferences("MisPreferencias",Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("usuario", nombre_ingresado);
                editor.putString("password", password_ingresado);

                editor.commit();

                Toast.makeText(getApplicationContext(), "Usuario: " + nombre_ingresado + ", Password: " + password_ingresado, Toast.LENGTH_SHORT).show();

                Intent a=new Intent(getApplicationContext(),MenuActivity.class);
                startActivity(a);
                finish();

                /*String campo_usuario = txtUsuario.getText().toString();
                String campo_password = txtPassword.getText().toString();

                if ((campo_usuario.compareTo("Rosa") == 0 && campo_password.compareTo("i3915") == 0)||(campo_usuario.compareTo("Vale S") == 0 && campo_password.compareTo("valexd") == 0)||(campo_usuario.compareTo("Vale A") == 0 && campo_password.compareTo("vale05") == 0)||(campo_usuario.compareTo("Diego") == 0 && campo_password.compareTo("diego") == 0))
                {
                    Intent c=new Intent(context,MenuActivity.class);
                    String[] datos=new String[2];
                    datos[0]=txtUsuario.getText().toString();
                    datos[1]=txtPassword.getText().toString();
                    c.putExtra("datos_usuario", datos);
                    startActivity(c);

                    Toast mensaje=Toast.makeText(getApplicationContext(), "Bienvenido "+datos[0], Toast.LENGTH_LONG);
                    mensaje.show();

                }
                else
                    txtResultado.setText("Login fallido");
            }*/
        };
    });

    }
}
