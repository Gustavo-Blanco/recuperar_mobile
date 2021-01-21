package pe.edu.tecsup.notificaciones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();

    private MaterialButton btnNotiBasica, btnNotiBigText, btnNotiBigImage;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG,"SE INICIA EL ACTIVITY");

        //Instanciamos botones
        btnNotiBasica = findViewById(R.id.btnNotiBasica);
        btnNotiBigText = findViewById(R.id.btnNotiBigText);
        btnNotiBigImage = findViewById(R.id.btnNotiBigImage);
        //Instanciamos notification manager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            notificationManager = getSystemService(NotificationManager.class);
        }

        btnNotiBasica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = "Falleció el periodista y narrador deportivo Dante Mateo";
                String body = "El periodista y narrador deportivo Dante Mateo Cadillo falleció este " +
                        "viernes por la noche, informó ...";
                //Creacion de notificacion
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this,NotificacionesApp.CANAL_NOTICIAS)
                        .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                        .setContentTitle(title)
                        .setContentText(body)
                        .setPriority(NotificationCompat.PRIORITY_MAX);

                //Lanzar notificaion
                notificationManager.notify(1,builder.build());
            }
        });
        btnNotiBigText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = "Falleció el periodista y narrador deportivo Dante Mateo";
                String body = "El periodista y narrador deportivo Dante Mateo Cadillo falleció este " +
                        "viernes por la noche, informó ...";

                String bigText = "Dante Mateo formó parte del equipo de RPP Noticias por largos " +
                        "años hasta 2018, año en el que narró encuentros del Mundial de Rusia 2018. " +
                        "Fue conocido como el narrador de los mundiales pues en su haber tiene una " +
                        "cobertura de siete mundiales. \n" +
                        "\n" +
                        "\"Me gustaba imitar a Don Oscar Artacho, Augusto Ferrando y hasta a Abanto " +
                        "Morales. Incluso, a los 14 años el propio Ferrando me dió la oportunidad " +
                        "en el segmento de imitadores, finalmente la locución me ganó\", declaró " +
                        "en una entrevista al medio digital Perú Global.\n" +
                        "\n" +
                        "Los periodistas de RPP Noticias y colegas periodistas deportivos " +
                        "lamentaron, vía Twitter, el sensible fallecimiento de quien por años fue " +
                        "un colega y amigo. ";

                //Creacion de notificacion
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this,NotificacionesApp.CANAL_NOTICIAS)
                        .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                        .setContentTitle(title)
                        .setContentText(body)
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText));

                //Lanzar notificaion
                notificationManager.notify(2,builder.build());
            }
        });

        btnNotiBigImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BrowserActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(
                        MainActivity.this, 3, intent,
                        PendingIntent.FLAG_UPDATE_CURRENT);

                String title = "Falleció el periodista y narrador deportivo Dante Mateo";
                String body = "El periodista y narrador deportivo Dante Mateo Cadillo falleció este " +
                        "viernes por la noche, informó ...";
                //Creacion de notificacion
                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this,NotificacionesApp.CANAL_NOTICIAS)
                        .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                        .setContentTitle(title)
                        .setContentText(body)
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .setStyle(new NotificationCompat.BigPictureStyle()
                        .bigPicture(BitmapFactory.decodeResource(getResources(),
                                R.drawable.imagen_noticia)))
                        .setContentIntent(pendingIntent);

                //Lanzar notificaion
                notificationManager.notify(3,builder.build());

            }
        });

    }
}