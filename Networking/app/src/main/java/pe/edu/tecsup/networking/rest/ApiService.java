package pe.edu.tecsup.networking.rest;

import java.util.List;

import pe.edu.tecsup.networking.model.Producto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    String API_BASE_URL = "https://0e99a7506835.ngrok.io/api/";

    @GET("producto")
    Call<List<Producto>> obtenerProductos();
}
