package pe.edu.tecsup.networking.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.List;

import pe.edu.tecsup.networking.R;
import pe.edu.tecsup.networking.model.Producto;
import pe.edu.tecsup.networking.rest.ApiService;
import pe.edu.tecsup.networking.rest.ApiServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MaterialButton btnObtenerProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnObtenerProductos = findViewById(R.id.btnObtenerProductos);
        btnObtenerProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llamarObtenerProductos();
            }
        });
    }

    private void llamarObtenerProductos(){
        ApiService apiService = ApiServiceGenerator.createService(ApiService.class);
        Call<List<Producto>> llamada = apiService.obtenerProductos();
        llamada.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (response.isSuccessful()){
                    List<Producto> listaProductos = response.body();
                    Toast.makeText(MainActivity.this, "Se encontraron"+listaProductos.size()+" registro de servicios",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
