package pe.edu.tecsup.networking.rest;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiServiceGenerator {

    //Cliente HTTP interno que realiza la conexión mediante protocolo

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    //Permite construir una instancia de Retrofit a partir de una URL base y de un cliente HTTP

    private static Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl(ApiService.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    //Objeto Retrofit para conexiones a los servicios web
    // es static porque solo se creará una única instancia de este objeto

    private static Retrofit retrofit;

    public ApiServiceGenerator() {
    }

    // Método que permite la generación de un cliente a un servicio a partir del objeto único Retrofit
    public static <S> S createService(Class<S> serviceClass) {
        // Se valida si el objeto Retrofit ya ha sido instanciado, caso contrario lo instancia
        if (retrofit == null) {
            // Se instancia un interceptador de la llamada al servicio que mostrará en consola
            // los parámetros y valores de la petición/respuesta
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            // Se agrega el interceptador
            httpClient.addInterceptor(httpLoggingInterceptor);

            retrofit = builder.client(httpClient.build()).build();
        }
        return retrofit.create(serviceClass);
    }
}
