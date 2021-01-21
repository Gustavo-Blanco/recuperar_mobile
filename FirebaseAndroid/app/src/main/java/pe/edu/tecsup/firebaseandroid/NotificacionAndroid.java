package pe.edu.tecsup.firebaseandroid;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class NotificacionAndroid extends Application {

    private final String TAG = getClass().getSimpleName();
    public static final String CANAL = "Noticias";

    @Override
    public void onCreate() {
        super.onCreate();

        createNotificationChannel(CANAL,"Noticias", NotificationManager.IMPORTANCE_HIGH);
    }

    private void createNotificationChannel(String canal, String noticias, int importanceHigh) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(canal,noticias,importanceHigh);

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }
}
