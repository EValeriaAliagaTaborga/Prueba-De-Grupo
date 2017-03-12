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
import android.widget.TextView;

public class ArmaloActivity extends AppCompatActivity {

    private ImageView imgPan;
    private ImageView imgCarneDeRes;
    private ImageView imgCarneDePollo;
    private ImageView imgCarneVegetariana;
    private ImageView imgQueso;
    private ImageView imgVegetales;
    private ImageView imgAdherezos;
    private ImageView imgOtrasCarnes;
    private ImageView imgHuevo;
    private ImageView imgIngredienteElegido;

    ListView lista;
    String[] ingredientes;
    ArrayAdapter<String> adaptador;

    LinearLayout lyVertical;
    LinearLayout lyHorizontalPrincipal;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_armalo);

        imgPan = (ImageView) findViewById(R.id.imgPan);
        imgCarneDeRes = (ImageView) findViewById(R.id.imgCarneRes);
        imgCarneDePollo = (ImageView) findViewById(R.id.imgCarnePollo);
        imgCarneVegetariana = (ImageView) findViewById(R.id.imgCarneVegetariana);
        imgQueso = (ImageView) findViewById(R.id.imgQueso);
        imgVegetales = (ImageView) findViewById(R.id.imgVegetales);
        imgAdherezos = (ImageView) findViewById(R.id.imgAdherezo);
        imgOtrasCarnes = (ImageView) findViewById(R.id.imgOtrasCarnes);
        imgHuevo = (ImageView) findViewById(R.id.imgHuevo);

        //son pa aniadir las imagenes a medida q se arma
        lyVertical = (LinearLayout) findViewById(R.id.lyVertical);
        lyHorizontalPrincipal = (LinearLayout) findViewById(R.id.lyHorizontalPrincipal);


        lista=(ListView)findViewById(R.id.lista);

        //pa q no este vacio
        ingredientes=new String[] {""};
        adaptador = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
        lista.setAdapter(adaptador);


        final LinearLayout.LayoutParams layoutImagenes = new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.WRAP_CONTENT, 30
        );


        imgPan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ingredientes=getResources().getStringArray(R.array.array_tipos_de_pan);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {
                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        Log.e("Item seleccionado", contenido);

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);
                        //guardar contenido como si fuera el nombre de la imagen
                        int imagen = R.drawable.cajita_feliz;
                        switch (contenido) {
                            case "Tradicional":  imagen  = R.drawable.ham_doble; break;
                            case "Sin Semillas":  imagen  = R.drawable.ham_integral; break;
                            case "Croissant":  imagen  = R.drawable.ham_queso; break;
                            case "Integral":  imagen  = R.drawable.ham_sin_pan; break;
                            case "Tostadas":   imagen  = R.drawable.ham_tocino; break;
                            case "Marraqueta":   imagen  = R.drawable.ham_vegetariana; break;
                        }
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);

                    }
                });

            }
        });

        imgCarneDeRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes=getResources().getStringArray(R.array.array_tamanios_de_carne_de_res);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {

                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        Log.e("Item seleccionado", contenido);

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);

                        int imagen = R.drawable.cajita_feliz;
                        switch (contenido) {
                            case "8 oz":  imagen  = R.drawable.ham_doble; break;
                            case "10 oz":  imagen  = R.drawable.ham_integral; break;
                            case "12 oz":  imagen  = R.drawable.ham_queso; break;
                            case "15 oz":  imagen  = R.drawable.ham_sin_pan; break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);

                    }
                });

            }
        });

        imgQueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes=getResources().getStringArray(R.array.array_tipos_de_quesos);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {

                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        Log.e("Item seleccionado", contenido);

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);

                        int imagen = R.drawable.cajita_feliz;
                        switch (contenido) {
                            case "Criollo":  imagen  = R.drawable.ham_doble; break;
                            case "Americano Tradicional":  imagen  = R.drawable.ham_integral; break;
                            case "Mozarella":  imagen  = R.drawable.ham_queso; break;
                            case "Cheddar":  imagen  = R.drawable.ham_sin_pan; break;
                            case "Gouda":   imagen  = R.drawable.ham_tocino; break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);

                    }
                });

            }
        });

        imgCarneDePollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes=getResources().getStringArray(R.array.array_tamanios_de_carne_de_pollo);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {

                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        Log.e("Item seleccionado", contenido);

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);

                        int imagen = R.drawable.cajita_feliz;
                        switch (contenido) {
                            case "8 oz":  imagen  = R.drawable.ham_doble; break;
                            case "10 oz":  imagen  = R.drawable.ham_integral; break;
                            case "12 oz":  imagen  = R.drawable.ham_queso; break;
                            case "15 oz":  imagen  = R.drawable.ham_sin_pan; break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);

                    }
                });

            }
        });

        imgCarneVegetariana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes=getResources().getStringArray(R.array.array_tamanios_de_carne_vegetariana);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {

                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        Log.e("Item seleccionado", contenido);

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);

                        int imagen = R.drawable.cajita_feliz;
                        switch (contenido) {
                            case "8 oz":  imagen  = R.drawable.ham_doble; break;
                            case "10 oz":  imagen  = R.drawable.ham_integral; break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);

                    }
                });

            }
        });

        imgVegetales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes=getResources().getStringArray(R.array.array_tipos_de_vegetales);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {

                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        Log.e("Item seleccionado", contenido);

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);

                        int imagen = R.drawable.cajita_feliz;
                        switch (contenido) {
                            case "Tomate":  imagen  = R.drawable.ham_doble; break;
                            case "Lechuga":  imagen  = R.drawable.ham_integral; break;
                            case "Cebolla":  imagen  = R.drawable.ham_queso; break;
                            case "Pepinillos":  imagen  = R.drawable.ham_sin_pan; break;
                            case "Rabanos":   imagen  = R.drawable.ham_tocino; break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);

                    }
                });

            }
        });

        imgAdherezos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes=getResources().getStringArray(R.array.array_tipos_de_adherezos);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {

                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        Log.e("Item seleccionado", contenido);

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);

                        int imagen = R.drawable.cajita_feliz;
                        switch (contenido) {
                            case "Mayonesa":  imagen  = R.drawable.ham_doble; break;
                            case "Ketchup":  imagen  = R.drawable.ham_integral; break;
                            case "Mostaza":  imagen  = R.drawable.ham_queso; break;
                            case "Salsa golf":  imagen  = R.drawable.ham_sin_pan; break;
                            case "Barbacoa":   imagen  = R.drawable.ham_tocino; break;
                            case "Miel y mostaza":   imagen  = R.drawable.ham_vegetariana; break;
                            case "Hot mustard":   imagen  = R.drawable.ham_vegetariana; break;
                            case "Salsa picante":   imagen  = R.drawable.ham_vegetariana; break;
                            case "Llajua tradicional":   imagen  = R.drawable.ham_vegetariana; break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);

                    }
                });

            }
        });

        imgHuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //se cierra D: T_T
                ingredientes=getResources().getStringArray(R.array.array_tipos_de_huevos);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {

                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        Log.e("Item seleccionado", contenido);

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);

                        int imagen = R.drawable.cajita_feliz;
                        switch (contenido) {
                            case "Frito":  imagen  = R.drawable.ham_doble; break;
                            case "Revuelto":  imagen  = R.drawable.ham_integral; break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);

                    }
                });

            }
        });

        imgOtrasCarnes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingredientes=getResources().getStringArray(R.array.array_tipos_de_otras_carnes);
                ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, ingredientes);
                lista.setAdapter(adaptador1);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> array, View vista, int posicion, long id) {

                        TextView texto = (TextView) vista.findViewById(android.R.id.text1);
                        String contenido = texto.getText().toString();
                        Log.e("Item seleccionado", contenido);

                        imgIngredienteElegido = new ImageView(context);
                        //primero va width y luego height
                        imgIngredienteElegido.setLayoutParams(layoutImagenes);

                        int imagen = R.drawable.cajita_feliz;
                        switch (contenido) {
                            case "Tocino":  imagen  = R.drawable.ham_doble; break;
                            case "Jamon":  imagen  = R.drawable.ham_integral; break;
                            case "Salami":  imagen  = R.drawable.ham_queso; break;
                            case "Pepperoni":  imagen  = R.drawable.ham_sin_pan; break;
                            case "Salchicha":  imagen  = R.drawable.ham_sin_pan; break;
                            case "Chorizo":  imagen  = R.drawable.ham_sin_pan; break;
                        }
                        //guardar contenido como si fuera el nombre de la imagen
                        imgIngredienteElegido.setImageDrawable(getDrawable(imagen));
                        lyVertical.addView(imgIngredienteElegido);
                        setContentView(lyHorizontalPrincipal);

                    }
                });

            }
        });


    }
}
