package pe.edu.tecsup.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SegundoActivity extends AppCompatActivity {

    private TextView txtMostrarExtra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        this.txtMostrarExtra = findViewById(R.id.txtMostrarExtra);
        //Recuperar el EXTRA que se agregó al Intent
        String extra = getIntent().getStringExtra("parametro");

        //Setear el EXTRA en el textView
        this.txtMostrarExtra.setText(extra);
    }
}