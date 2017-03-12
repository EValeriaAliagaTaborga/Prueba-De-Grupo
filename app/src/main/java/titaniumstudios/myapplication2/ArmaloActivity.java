package titaniumstudios.myapplication2;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class ArmaloActivity extends AppCompatActivity {

    private ImageView imgPan;

    ListView lista;
    ArrayAdapter<String> adaptador;
    String[] ingredientes;

    LinearLayout lyVertical;
    LinearLayout lyHorizontalPrincipal;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armalo);

        imgPan = (ImageView) findViewById(R.id.imgPan);

        //son pa aniadir las imagenes a medida q se arma
        lyVertical = (LinearLayout) findViewById(R.id.lyVertical);
        lyHorizontalPrincipal = (LinearLayout) findViewById(R.id.lyHorizontalPrincipal);


        lista=(ListView)findViewById(R.id.lista);

        //pa q no este vacio
        ingredientes=new String[1];


        imgPan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //se cierra D: T_T
                ingredientes=getResources().getStringArray(R.array.array_tiposDePan);
                adaptador = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador);

                /*lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {
                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        Log.e("Item seleccionado", contenido);
                    }
                });*/

               /* va creando imagenes de lo que se elija, hay q moverlo una vez q sirva la lista
               imgPanElegido = new ImageView(context);

                //primero va width y luego height
                //LinearLayout.LayoutParams layoutUsuario = ;
                imgPanElegido.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT, 30
                ));
                imgPanElegido.setImageDrawable(getDrawable(R.drawable.ham_doble));

                lyVertical.addView(imgPanElegido);

                setContentView(lyHorizontalPrincipal);*/

            }
        });

    }
}
