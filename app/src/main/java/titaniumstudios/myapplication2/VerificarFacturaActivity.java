package titaniumstudios.myapplication2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class VerificarFacturaActivity extends AppCompatActivity {

    private Button btnEditar;
    private Button btnCancelar;

    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificar_factura);

        context=this;

        btnEditar=(Button)findViewById(R.id.btnEditar);
        btnCancelar=(Button)findViewById(R.id.btnCancelar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,DatosYFacturacionActivity.class);
                startActivity(intent);
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder Dialogo = new AlertDialog.Builder(
                        VerificarFacturaActivity.this);

                Dialogo.setTitle("¿Está seguro de cancelar su pedido?");
                Dialogo.setMessage("Los datos de su pedido se perderán si cancela la orden.");
                Dialogo.setIcon(R.drawable.cubo);

                Dialogo.setPositiveButton("Si",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Orden cancelada. Tenga un buen día.", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(context,MenuActivity.class);
                                startActivity(intent);
                            }
                        });
                Dialogo.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                Dialogo.show();
            }
        });
    }
}
