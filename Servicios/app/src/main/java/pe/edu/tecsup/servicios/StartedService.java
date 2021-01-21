package pe.edu.tecsup.servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class StartedService extends Service {

    private final String TAG = getClass().getSimpleName();
    private Timer timer;
    private TimerTask timerTask;

    private final String[] food = {
            "Salchipapa Casera a lo Pobre",
            "Salchipapa La Casera",
            "Salchipapa La Avezada",
            "Salchipapa La Solterona",
            "Salchipapa La Plebeya",
            "Salchipapa La Cajamarquina",
            "Salchipapa La de Antaño"
    };

    private final String[] address = {
            "Av. La Marina 2650 - San Miguel",
            "Jr. Pedro Conde 445 - Lince",
            "Av. Rafael Escardó 670 - San Miguel",
            "Av. Arequipa 2322 - Lince",
            "Av. Larco 1942 - Miraflores",
            "Av. Alameda El Corregidor 748 - La Molina",
            "Av. Petit Thours 2641 - Lince",
            "Av. Parque de las Leyendas 184 - San Miguel",
            "Av. Brasil 1427 - Magdalena",
            "Av. San Felipe 2796 - Jesús María"
    };

    public StartedService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG, "onCreate()");
    }

    @Override
    public int onStartCommand(final Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand()");
//        for (int i = 0;i<5; i++){
//            Log.i(TAG, "Contador: "+(i+1));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        timerTask = new TimerTask() {
            @Override
            public void run() {
                // Implementacion de tarea que se ejecutara varias veces
                Calendar calendar =  Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mmm:ss a dd/MM/yyyy");
                String fechaPedido = sdf.format(calendar.getTime());

                Log.i(TAG, "Nueva orden generada a las "+fechaPedido);

                Pedido nuevoPedido = createRandomPedido();
                Log.i(TAG, nuevoPedido.toString());

                Intent intent1 = new Intent();
                intent1.setAction(MainActivity.ServiceReceiver.SERVICE_RECEIVER_ACTION);
                sendBroadcast(intent1);

                Log.i(TAG, "--------");
            }
        };
        timer = new Timer();


        timer.schedule(timerTask, 2000,2000);

//        stopSelf();
        return super.onStartCommand(intent, flags, startId);
    }

    //Metodos auxiliares
    private Pedido createRandomPedido() {
        return new Pedido(food[randomFood()], address[randomAddress()]);
    }

    private int randomFood() {
        Random random = new Random();
        int newInt = random.nextInt((6 - 1) + 1) + 1;
        Log.i(TAG, "Se generó el valor: " + newInt);
        return newInt;
    }

    private int randomAddress() {
        Random random = new Random();
        int newInt = random.nextInt((9 - 1) + 1) + 1;
        Log.i(TAG, "Se generó el valor: " + newInt);
        return newInt;
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null){
            timer.cancel();
            timer = null;
        }

        Log.i(TAG, "onDestroy()");

    }
}
