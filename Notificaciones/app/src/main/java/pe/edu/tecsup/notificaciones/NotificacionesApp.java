package pe.edu.tecsup.notificaciones;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.util.Log;

public class NotificacionesApp extends Application {

    private final String TAG = getClass().getSimpleName();
    public static final String CANAL_NOTICIAS = "noticias";

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG,"Se inicia la aplicación!!");

        createNotificationChannel(CANAL_NOTICIAS,"Noticias",
                NotificationManager.IMPORTANCE_HIGH);
    }

    private void createNotificationChannel(String idCanal, String nombre, int importancia){
        //Se ejecuta siempre y cuando la version de android sea igual o superior a api 26
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(idCanal,nombre,importancia);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

}
