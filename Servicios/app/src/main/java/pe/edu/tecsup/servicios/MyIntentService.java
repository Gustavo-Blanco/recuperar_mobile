package pe.edu.tecsup.servicios;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;


public class MyIntentService extends IntentService {

    private final String TAG = getClass().getSimpleName();

    private static final String ACTION_TIMER = "pe.edu.tecsup.servicios.action.TIMER";

    private static final String EXTRA_PARAM1 = "pe.edu.tecsup.servicios.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "pe.edu.tecsup.servicios.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }

    public static void startActionTimer(Context context, int param1, int param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_TIMER);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG,"onHandleIntent()");
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_TIMER.equals(action)) {
                final int param1 = intent.getIntExtra(EXTRA_PARAM1, 5);
                final int param2 = intent.getIntExtra(EXTRA_PARAM2, 1000);
                handleActionTimer(param1, param2);
            }
        }
    }

    private void handleActionTimer(int param1, int param2) {
        for (int i = 0; i<param1; i++){
            Log.i(TAG,"Contador: "+(i+1));
            try {
                Thread.sleep(param2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
