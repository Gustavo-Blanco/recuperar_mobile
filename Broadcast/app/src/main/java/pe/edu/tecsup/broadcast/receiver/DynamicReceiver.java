package pe.edu.tecsup.broadcast.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import pe.edu.tecsup.broadcast.activity.MainActivity;

public class DynamicReceiver extends BroadcastReceiver {


    public final String TAG = getClass().getSimpleName();

    //Paso 1: Crear interface de comunicacion entre broadcast y activity
    public interface DynamicReceiverListener{
        public void onFired(String mensaje);
    }

    //Paso 2: Crear variable global para esta interface
    private DynamicReceiverListener dynamicReceiverListener;

    //Paso 3: Crear un constructor para que el broadcast reciber reciba el argumento interface
    public DynamicReceiver(DynamicReceiverListener dynamicReceiverListener) {
        this.dynamicReceiverListener = dynamicReceiverListener;
    }

    @Override
    public void onReceive(Context context, Intent broadcastIntent) {
        Log.d(TAG, "--- Static Receiver Inicio ----");
//        Intent intent = new Intent(context, MainActivity.class);
//        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        context.startActivity(intent);
        String mensaje = new String();

        switch (broadcastIntent.getAction()){
            case Intent.ACTION_POWER_CONNECTED:
                mensaje = "El cargador a sido conectado";
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                mensaje = "El cargador a sido desconectado";
                break;
            case Intent.ACTION_BATTERY_LOW:
                mensaje = "La batería se está acabando";
                break;
            case Intent.ACTION_BATTERY_OKAY:
                mensaje = "La batería está okay";
                break;
            case MainActivity.CUSTOM_BROADCAST_ACTION:
                mensaje="custom Broadcast recibido";
                break;
        }

        Log.d(TAG, mensaje);

        //Paso 4: Enviar el mensaje al activity
        dynamicReceiverListener.onFired(mensaje);


        //        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
        Log.d(TAG, "--- Static Receiver Fin ----");
    }
}
