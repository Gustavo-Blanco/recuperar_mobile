package pe.edu.tecsup.navegacion.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import pe.edu.tecsup.navegacion.R;

public class HijaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hija);
        setTitle("Hija activity");
    }
}