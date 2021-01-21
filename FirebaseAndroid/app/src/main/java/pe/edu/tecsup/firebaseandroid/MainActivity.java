package pe.edu.tecsup.firebaseandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();

    private TextInputEditText edtToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtToken = findViewById(R.id.edtToken);

        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()){
                            Log.i(TAG,"Error al obtener el token", task.getException());
                        }
                        String token  = task.getResult();
                        Log.d(TAG,token);
                        edtToken.setText(token);
                        Toast.makeText(getApplicationContext(),"Nuevo token: "+token,
                                Toast.LENGTH_SHORT).show();
                    }
                });

    }
}