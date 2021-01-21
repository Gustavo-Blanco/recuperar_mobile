package pe.edu.tecsup.persistencia.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import pe.edu.tecsup.persistencia.R;

public class MainActivity extends AppCompatActivity {

    private final static String NOMBRE_SHARED_PREFERENCES = "pe.edu.tecsup.persistencia";

    private TextInputEditText edtNombre;
    private MaterialButton btnGuardar, btnLimpiar;

    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        edtNombre = findViewById(R.id.edtNombre);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnLimpiar = findViewById(R.id.btnLimpiar);

        sharedPreferences = getSharedPreferences(NOMBRE_SHARED_PREFERENCES, MODE_PRIVATE);

        //Leer data en el SharedPreferences
        String nombrePreferences = sharedPreferences.getString("nombre",null);
        if (nombrePreferences != null){
            edtNombre.setText(nombrePreferences);
        }else{
            Toast.makeText(MainActivity.this,"No encontré shared preferences",Toast.LENGTH_SHORT).show();
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtNombre.getText().toString().isEmpty()){
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("nombre",edtNombre.getText().toString());
                    editor.apply();

                    Toast.makeText(MainActivity.this,"Se guardó correctamente",Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(MainActivity.this,"Por favor ingere un nombre",Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               SharedPreferences.Editor editor = sharedPreferences.edit();
               editor.clear();
               editor.apply();

               edtNombre.setText("");
               Toast.makeText(MainActivity.this,"Se limpió el nombre correctamente",Toast.LENGTH_SHORT).show();

            }
        });
    }
}