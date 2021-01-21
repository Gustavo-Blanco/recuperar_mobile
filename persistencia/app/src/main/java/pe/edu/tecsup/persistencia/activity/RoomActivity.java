package pe.edu.tecsup.persistencia.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import pe.edu.tecsup.persistencia.R;
import pe.edu.tecsup.persistencia.RoomDatabase;
import pe.edu.tecsup.persistencia.entity.PersonaEntity;

public class RoomActivity extends AppCompatActivity {

    private TextInputEditText edtNombre, edtApellido, edtEdad;
    private MaterialButton btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        edtNombre = findViewById(R.id.edtNombre);
        edtApellido = findViewById(R.id.edtApellido);
        edtEdad = findViewById(R.id.edtEdad);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNombre.getText().toString().isEmpty() ||
                    edtApellido.getText().toString().isEmpty() ||
                        edtEdad.getText().toString().isEmpty()){
                    Toast.makeText(RoomActivity.this, "Por favor complete los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //Obtenemos la instancia Singleton de RoomDatabase
                        RoomDatabase roomDatabase = RoomDatabase.getInstance(RoomActivity.this);

                        //Instanciamos un objeto Entity y se le setea los valores deseados
                        PersonaEntity personaEntity = new PersonaEntity();

                        personaEntity.setNombre(edtNombre.getText().toString());
                        personaEntity.setApellido(edtApellido.getText().toString());
                        personaEntity.setEdad(Integer.parseInt(edtEdad.getText().toString()));
                        personaEntity.setInnecesario("Hola mundo");

                        //LLamamos al DAO para insertar en la BD
                        roomDatabase.personaDao().insert(personaEntity);
                    }
                }).start();

            }
        });
    }
}