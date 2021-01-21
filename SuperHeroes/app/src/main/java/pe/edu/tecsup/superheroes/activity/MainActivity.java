package pe.edu.tecsup.superheroes.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pe.edu.tecsup.superheroes.R;
import pe.edu.tecsup.superheroes.adapter.HeroeAdapter;
import pe.edu.tecsup.superheroes.model.Heroe;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvHeroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvHeroes = findViewById(R.id.rcvHeroes);

        //Definimos el layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);

        //Definimos el adapter
        HeroeAdapter.OnHeroeClickListener OnHeroeClickListener = new HeroeAdapter.OnHeroeClickListener() {
            @Override
            public void onClick(int posicion) {
//                Toast.makeText(MainActivity.this,"Hiciste click en el "+posicion, Toast.LENGTH_SHORT).show();
                HeroeAdapter heroeAdapter = (HeroeAdapter) rcvHeroes.getAdapter();
                Heroe heroe = heroeAdapter.getListaHeroes().get(posicion);

                Toast.makeText(MainActivity.this,heroe.toString(), Toast.LENGTH_LONG).show();
            }
        };
        HeroeAdapter heroeAdapter = new HeroeAdapter(obtenerDataHeroes(), OnHeroeClickListener);

        //Configuración del recyclerView;
        rcvHeroes.setAdapter(heroeAdapter);
        rcvHeroes.setLayoutManager(linearLayoutManager);
    }

    private List<Heroe> obtenerDataHeroes() {
        List<Heroe> dataHeroes = new ArrayList<>();
        dataHeroes.add(new Heroe("Antman", "Scott Lang", "Marvel", R.drawable.ic_antman));
        dataHeroes.add(new Heroe("Black Panther", "T'Challa", "Marvel", R.drawable.ic_blackpanther));
        dataHeroes.add(new Heroe("Blackwidow", "Natasha Romanoff", "Marvel", R.drawable.ic_blackwidow));
        dataHeroes.add(new Heroe("Capitán América", "Steve Rogers", "Marvel", R.drawable.ic_captainamerica));
        dataHeroes.add(new Heroe("Deadpool", "Wade Wilson", "Marvel", R.drawable.ic_deadpool));
        dataHeroes.add(new Heroe("Dr Strange", "Stephen Strange", "Marvel", R.drawable.ic_drstrange));
        dataHeroes.add(new Heroe("Ironman", "Tony Stark", "Marvel", R.drawable.ic_ironman));
        dataHeroes.add(new Heroe("Spiderman", "Peter Parker", "Marvel", R.drawable.ic_spiderman));
        dataHeroes.add(new Heroe("Thor", "Hijo de Odín", "Marvel", R.drawable.ic_thor));
        return dataHeroes;
    }
}