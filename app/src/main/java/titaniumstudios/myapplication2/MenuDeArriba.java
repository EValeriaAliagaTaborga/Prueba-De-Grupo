package titaniumstudios.myapplication2;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by DTIC-123 on 16/03/2017.
 */

 //TODO cambiar la inicializacion de MenuDeArriba en cada clase por un getMenuDeArriba para q se utilice el mismo menu y el atributo sea el mismo
public class MenuDeArriba {

   // private MenuActivity menuActivity = new MenuActivity();

    private boolean conCuenta=false;


    int opcion1 = 1;
    int opcion2 = 2;
    int opcion3 = 3;
    int opcion4 = 4;
    int opcion5 = 5;

    public void menuDeArriba(Menu menu) {
        if (conCuenta) {
            menu.add(Menu.NONE, opcion1, Menu.NONE, "Perfil")
                    .setIcon(android.R.drawable.ic_menu_add);
            menu.add(Menu.NONE, opcion2, Menu.NONE, "Historial")
                    .setIcon(android.R.drawable.stat_notify_sdcard_prepare);
        }
        menu.add(Menu.NONE, opcion3, Menu.NONE, "Detalles de la app")
                .setIcon(android.R.drawable.ic_dialog_info);

        if (conCuenta) {
            menu.add(Menu.NONE, opcion4, Menu.NONE, "Cerrar Sesión")
                    .setIcon(android.R.drawable.ic_dialog_info);
        } else {
            menu.add(Menu.NONE, opcion5, Menu.NONE, "Login")
                    //cambiar esto creo xD
                    .setIcon(android.R.drawable.ic_dialog_info);
        }
    }

    public void accionesDeMenuDeArriba(MenuItem item) {
       // menuActivity.onOptionsItemSelected(item);
      /*  switch (item.getItemId()) {
            case opcion3:
                //Layout inflater será el método para agregar un mayout
                LayoutInflater inflater = getLayoutInflater();
                //Utilizaremos el layout llamado layout_toast que contiene el id específico layout_vista
                View layouttoast = inflater.inflate(R.layout.layout_toast, (ViewGroup)findViewById(R.id.layout_vista));
                //Llenamos el TextView con id=texto con el mensaje
                ((TextView) layouttoast.findViewById(R.id.texto)).setText("Comer un hamburguesa es un placer irresistible para muchos y es por eso que los restaurantes de comida rápida proliferan. El exquisito sabor de la carne al pan es una de las cosas en que muchas personas coinciden. Aunque para los más saludables sea una comida rápida que daña el cuerpo, es bueno conocer su trayectoria. Una hamburguesa es un alimento en forma de bocadillo de carne picada aglutinada en forma de filete, cocinado a la parrilla o a la plancha, aunque también puede freírse u hornearse. Fuera del ámbito de habla hispana es más común encontrar la denominación inglesa burger. Se presenta en un pan ligero partido en dos que posee una forma de óvalo. Suele estar acompañada de aros de cebolla, hojas de lechuga, alguna rodaja de tomate, láminas de encurtidos, papas fritas etc.");

                //Declaramos el context
                Toast mensaje = new Toast(getBaseContext());

                //Declaramos la ubicación en pantalla
                mensaje.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

                //Declaramos el contenido
                mensaje.setView(layouttoast);
                mensaje.setDuration(Toast.LENGTH_LONG);
                mensaje.show();
                break;
            case opcion4:
                AlertDialog.Builder Dialogo = new AlertDialog.Builder(
                        MenuActivity.this);

                Dialogo.setTitle("Atención!");
                Dialogo.setMessage("¿Seguro que desea cerrar sesión?");

                Dialogo.setPositiveButton("Si",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                //cambiar los datos de MisPreferencias como pa q se borre

                                //Abrimos el archivo de preferencias
                                SharedPreferences prefs =
                                        getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);

                                //Editamos los campos existentes y en este caso borramos la cuenta existente
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putString("usuario", "no");
                                editor.putString("password", "no");
                                //Concretamos la edicion
                                editor.commit(); //pa guardar


                                Intent intent = new Intent(context, MainActivity.class);
                                finish();
                                startActivity(intent);
                            }
                        });
                Dialogo.setNegativeButton("No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "Ten mas cuidado con lo que presionas", Toast.LENGTH_SHORT).show();
                                dialog.cancel();
                            }
                        });
                Dialogo.show();
                break;
            case opcion5:
                Intent intent = new Intent(context, LoginActivity.class);
                intent.putExtra("datos_de_cliente", new String[]{"","","","","","",""});
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }*/
    }

    public boolean getConCuenta() {
        return conCuenta;
    }

    public void setConCuenta(boolean conCuenta) {

        this.conCuenta = conCuenta;
    }
}


