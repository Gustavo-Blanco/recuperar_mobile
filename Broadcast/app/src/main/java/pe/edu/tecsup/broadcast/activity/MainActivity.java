package pe.edu.tecsup.broadcast.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

import pe.edu.tecsup.broadcast.R;
import pe.edu.tecsup.broadcast.receiver.DynamicReceiver;

public class MainActivity extends AppCompatActivity {

    public static final String CUSTOM_BROADCAST_ACTION = "pe.edu.tecsup.broadcast.CUSTOM_BROADCAST";

    private MaterialButton btnCustomBroadcast;
    private TextView textView;
    private DynamicReceiver dynamicReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtMensaje);
        btnCustomBroadcast = findViewById(R.id.btnCustomBroadcast);

        dynamicReceiver = new DynamicReceiver(new DynamicReceiver.DynamicReceiverListener() {
            @Override
            public void onFired(String mensaje) {
                textView.setText(mensaje);

            }
        });

        //Registramos el dynamic para que escuche los action del sistema
        registerReceiver(dynamicReceiver, new IntentFilter(Intent.ACTION_POWER_CONNECTED));
        registerReceiver(dynamicReceiver, new IntentFilter(Intent.ACTION_POWER_DISCONNECTED));
        registerReceiver(dynamicReceiver, new IntentFilter(Intent.ACTION_BATTERY_LOW));
        registerReceiver(dynamicReceiver, new IntentFilter(Intent.ACTION_BATTERY_OKAY));

        //Registramos el dynamic para que escuche el action Personalizado
        registerReceiver(dynamicReceiver, new IntentFilter(CUSTOM_BROADCAST_ACTION));
        btnCustomBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(CUSTOM_BROADCAST_ACTION);
                sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dynamicReceiver);
    }
}