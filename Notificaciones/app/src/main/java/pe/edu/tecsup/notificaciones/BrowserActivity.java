package pe.edu.tecsup.notificaciones;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BrowserActivity extends AppCompatActivity {

    private WebView navegador;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        navegador = findViewById(R.id.navegador);
        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.loadUrl("https://elcomercio.pe/lima/sucesos/covid-19-minsa-reporta-96-decesos-por-coronavirus-en-las-ultimas-24-horas-segunda-ola-nndc-noticia/");

    }
}
