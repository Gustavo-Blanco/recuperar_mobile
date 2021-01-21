package pe.edu.tecsup.navegacion.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;

import pe.edu.tecsup.navegacion.R;

public class HijoActivity extends AppCompatActivity {
    private MaterialButton hija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hijo);
        setTitle("Hijo activity");

        hija = findViewById(R.id.hija);

        hija.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HijoActivity.this, HijaActivity.class);
                startActivity(intent);
            }
        });
    }
}