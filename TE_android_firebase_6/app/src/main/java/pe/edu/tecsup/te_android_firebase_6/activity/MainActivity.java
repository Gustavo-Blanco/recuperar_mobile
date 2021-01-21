package pe.edu.tecsup.te_android_firebase_6.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import pe.edu.tecsup.te_android_firebase_6.R;
import pe.edu.tecsup.te_android_firebase_6.model.Playa;

public class MainActivity extends AppCompatActivity {

    private MaterialTextView radiacion,velocidad;
    private Playa playa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference reference = database.getReference("Playa");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Playa value = snapshot.getValue(Playa.class);
                if (value != null){
                    playa = new Playa(value.getRadiacion(),value.getVelocidad());
                    radiacion.setText(String.valueOf(playa.getRadiacion()));
                    velocidad.setText(String.valueOf(playa.getVelocidad()));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public void initViews(){
        radiacion = findViewById(R.id.valor_radiacion);
        velocidad = findViewById(R.id.valor_velocidad);
    }
}