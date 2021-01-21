package pe.edu.tecsup.servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private MaterialButton btnIniciarStartedService,
            btnIniciarIntentService, btnDetenerStartedService;

    private ServiceReceiver serviceReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciarStartedService = findViewById(R.id.btnIniciarStartedService);
        btnIniciarIntentService = findViewById(R.id.btnIniciarIntentService);
        btnDetenerStartedService = findViewById(R.id.btnDetenerStartedService);

        //Instanciamos el service receiver
        serviceReceiver = new ServiceReceiver();

        //Registramos el service receiver
        registerReceiver(serviceReceiver,new IntentFilter(ServiceReceiver.SERVICE_RECEIVER_ACTION));


        btnIniciarStartedService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StartedService.class);
                startService(intent);
            }
        });

        btnIniciarIntentService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyIntentService.startActionTimer(MainActivity.this, 20,500);
            }
        });

        btnDetenerStartedService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(MainActivity.this, StartedService.class);
                stopService(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(serviceReceiver);
        super.onDestroy();
    }

    public class ServiceReceiver extends BroadcastReceiver {
        private final String TAG = getClass().getSimpleName();

        public static final String SERVICE_RECEIVER_ACTION = "pe.edu.tecsup.ServiceReceiver.ACTION";

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.i(TAG, "He sido invocado");

        }
    }
}