package pe.edu.tecsup.appfirebase2a.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pe.edu.tecsup.appfirebase2a.R;
import pe.edu.tecsup.appfirebase2a.model.Led;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private ImageView foco1,foco2,foco3;
    private Button led1On,led1Off,led2On,led2Off,led3On,led3Off;
    private boolean state1,state2,state3;
    private Led led;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        final DatabaseReference myRef = database.getReference("Leds");
        reference = myRef;
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Led snapshotValue = snapshot.getValue(Led.class);
//                saludo.setText(value);
                state1 = Boolean.parseBoolean(snapshotValue.getLed1());
                state2 = Boolean.parseBoolean(snapshotValue.getLed2());
                state3 = Boolean.parseBoolean(snapshotValue.getLed3());

                led = snapshotValue;
//                Log.i("LEDS",""+state1+state2+state3);
                metodosClick();

                if(snapshotValue.getLed1().equals("1")){
                    foco1.setImageResource(R.drawable.led_on_blue);
                }else{
                    foco1.setImageResource(R.drawable.led_off);
                }
                if(snapshotValue.getLed2().equals("1")){
                    foco2.setImageResource(R.drawable.led_on_orange);
                }else{
                    foco2.setImageResource(R.drawable.led_off);
                }
                if(snapshotValue.getLed3().equals("1")){
                    foco3.setImageResource(R.drawable.led_on_yellow);
                }else{
                    foco3.setImageResource(R.drawable.led_off);
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    private void initViews() {
        foco1 = findViewById(R.id.img_foco1);
        foco2 = findViewById(R.id.img_foco2);
        foco3 = findViewById(R.id.img_foco3);

        led1On = findViewById(R.id.led1_on);
        led2On = findViewById(R.id.led2_on);
        led3On = findViewById(R.id.led3_on);

        led1Off = findViewById(R.id.led1_off);
        led2Off = findViewById(R.id.led2_off);
        led3Off = findViewById(R.id.led3_off);

        state1 = false;
        state2 = false;
        state3 = false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.led1_on:
                state1 = true;
                led.setLed1(String.valueOf(state1 ? 1 : 0));
                break;
            case R.id.led2_on:
                state2 = true;
                led.setLed2(String.valueOf(state2 ? 1 : 0));
                break;
            case R.id.led3_on:
                state3 = true;
                led.setLed3(String.valueOf(state3 ? 1 : 0));
                break;
            case R.id.led1_off:
                state1 = false;
                led.setLed1(String.valueOf(state1 ? 1 : 0));
                break;
            case R.id.led2_off:
                state2 = false;
                led.setLed2(String.valueOf(state1 ? 1 : 0));
                break;
            case R.id.led3_off:
                state3 = false;
                led.setLed3(String.valueOf(state1 ? 1 : 0));
                break;
        }
        reference.setValue(led);
        Toast.makeText(this,String.valueOf(v.getId()),Toast.LENGTH_SHORT).show();
    }

//    public void verifyState(View v, DatabaseReference reference, ImageView foco, int ledFoco,
//                            Led led, boolean value){
//        state = true;
//        reference.setValue(led);
//        foco.setImageResource(ledFoco);
//    }

    public void metodosClick(){
        led1On.setOnClickListener(this);
        led2On.setOnClickListener(this);
        led3On.setOnClickListener(this);

        led1Off.setOnClickListener(this);
        led2Off.setOnClickListener(this);
        led3Off.setOnClickListener(this);
    }

}