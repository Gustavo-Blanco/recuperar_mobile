package pe.edu.tecsup.firebaseandroid;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private final String TAG = getClass().getSimpleName();

    private NotificationManager notificationManager;

    public MyFirebaseMessagingService() {
    }

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
//        super.onMessageReceived(remoteMessage);
        Log.d(TAG,"Nuevo mensaje recibido!!");

        if(remoteMessage.getData().size() > 0){
            Log.d(TAG,"Mensaje data payload: "+remoteMessage.getData());
        }
        if(remoteMessage.getNotification() != null){
            Log.d(TAG,"Message notification title: "+remoteMessage.getNotification().getTitle());
            Log.d(TAG,"Message notification title: "+remoteMessage.getNotification().getBody());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                notificationManager = getSystemService(NotificationManager.class);

                String title = remoteMessage.getNotification().getTitle();
                String body = remoteMessage.getNotification().getBody();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                    MyFirebaseMessagingService.this,NotificacionAndroid.CANAL)
                        .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                        .setContentTitle(title)
                        .setContentText(body)
                        .setPriority(NotificationCompat.PRIORITY_MAX);
                    notificationManager.notify(1,builder.build());
            }
        }

    }
}
