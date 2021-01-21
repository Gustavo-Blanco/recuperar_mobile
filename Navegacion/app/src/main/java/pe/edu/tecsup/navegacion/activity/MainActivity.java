package pe.edu.tecsup.navegacion.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import pe.edu.tecsup.navegacion.R;

public class MainActivity extends AppCompatActivity {

    private int cont = 5;
    private MaterialButton hijo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main activity");

        hijo = findViewById(R.id.hijo);

        hijo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HijoActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        //si eliminamos el super, no se podrá retroceder
        if(cont == 0){
            super.onBackPressed();
        }else{
            Toast.makeText(this,"Presiona "+cont+" veces para salir",Toast.LENGTH_SHORT).show();
            cont--;
        }
    }
}