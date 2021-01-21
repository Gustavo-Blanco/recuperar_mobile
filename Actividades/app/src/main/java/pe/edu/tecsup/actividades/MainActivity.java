package pe.edu.tecsup.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnIntentSegundoActivity, btnIntentNavegador, btnIntentLlamada, btnIntentMapa, btnIntentBusquedaMapa, btnIntentCamara;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnIntentSegundoActivity = findViewById(R.id.btnIntentSegundoActivity);
        this.btnIntentNavegador = findViewById(R.id.btnIntentNavegador);
        this.btnIntentLlamada = findViewById(R.id.btnIntentLlamada);
        this.btnIntentMapa = findViewById(R.id.btnIntentMapa);
        this.btnIntentBusquedaMapa = findViewById(R.id.btnIntentBusquedaMapa);
        this.btnIntentCamara = findViewById(R.id.btnIntentCamara);

        this.btnIntentSegundoActivity.setOnClickListener(new View.OnClickListener(){
            @Override
            //Intent explícito
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, SegundoActivity.class);
                intent.putExtra("parametro", "Tecsup Lab A");

                startActivity(intent);
            }
        });
        this.btnIntentNavegador.setOnClickListener(new View.OnClickListener(){
            @Override
            //Intent implícito
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"));
                startActivity(intent);
            }
        });
        this.btnIntentLlamada.setOnClickListener(new View.OnClickListener(){
            @Override
            //Intent implícito
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+51)995968778"));
                startActivity(intent);
            }
        });
        this.btnIntentMapa.setOnClickListener(new View.OnClickListener(){
            @Override
            //Intent implícito
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-12.044007,-76.952817?z=17"));
                startActivity(intent);
            }
        });
        this.btnIntentBusquedaMapa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:-12.079207,-77.067464?q=Naruto"));
                startActivity(intent);
            }
        });
        this.btnIntentCamara.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                startActivity(intent);
            }
        });
    }
}