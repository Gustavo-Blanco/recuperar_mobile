package pe.edu.tecsup.menus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imgAndroid, imgPuntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgAndroid = findViewById(R.id.imgAndroid);
        imgPuntos = findViewById(R.id.imgPuntos);

        //Asignar menu contextual
        registerForContextMenu(imgAndroid);

        //Menu popup
        imgPuntos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this, imgPuntos);
                popupMenu.getMenuInflater().inflate(R.menu.menu_main_popup,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        optionMenuSelected(item.getItemId());
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }


    /*
    * Menú en AppBar
    * */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        optionMenuSelected(item.getItemId());
        return true;
    }

    /*
    * Menú contextual
    * */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        getMenuInflater().inflate(R.menu.menu_main_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        optionMenuSelected(item.getItemId());
        return true;
    }

    private void optionMenuSelected(int idOptionMenu){
        switch (idOptionMenu){
            case R.id.menu_buscar:
                Toast.makeText(this, "Buscar",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_nuevo:
                Toast.makeText(this, "Nuevo",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_informacion:
                Toast.makeText(this, "Información",Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_ayuda:
                Toast.makeText(this, "Ayuda",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }


}