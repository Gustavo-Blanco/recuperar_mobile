package pe.edu.tecsup.broadcast.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import pe.edu.tecsup.broadcast.activity.MainActivity;

public class StaticReceiver extends BroadcastReceiver {

    public final String TAG = getClass().getSimpleName();

    @Override
    public void onReceive(Context context, Intent broadcastIntent) {
        Log.d(TAG, "--- Static Receiver Inicio ----");
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        Log.d(TAG, "--- Static Receiver Fin ----");
    }
}
