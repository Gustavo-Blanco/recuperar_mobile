package pe.edu.tecsup.fragmentos.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransitionImpl;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.button.MaterialButton;

import pe.edu.tecsup.fragmentos.R;
import pe.edu.tecsup.fragmentos.fragment.CuartoFragment;
import pe.edu.tecsup.fragmentos.fragment.PrimeroFragment;
import pe.edu.tecsup.fragmentos.fragment.SegundoFragment;
import pe.edu.tecsup.fragmentos.fragment.TerceroFragment;

public class MainActivity extends AppCompatActivity {
    private MaterialButton btnPrimero,btnSegundo,btnTercero, btnCuarto;
    private FrameLayout frmContenedorFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.btnPrimero = findViewById(R.id.btnPrimero);
        this.btnSegundo = findViewById(R.id.btnSegundo);
        this.btnTercero = findViewById(R.id.btnTercero);
        this.btnCuarto = findViewById(R.id.btnCuarto);
        this.frmContenedorFragment = findViewById(R.id.frmContenedorFragment);

        this.btnPrimero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //1. fragmentManager
//                2. fragmentTransaction
//                3. replace->commit

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                PrimeroFragment primeroFragment = new PrimeroFragment();
//                fragmentTransaction.add(R.id.frmContenedorFragment, primeroFragment);
                fragmentTransaction.replace(R.id.frmContenedorFragment, primeroFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        this.btnSegundo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                SegundoFragment segundoFragment = new SegundoFragment();
//                fragmentTransaction.add(R.id.frmContenedorFragment, segundoFragment);
                fragmentTransaction.replace(R.id.frmContenedorFragment, segundoFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        this.btnTercero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                TerceroFragment terceroFragment = new TerceroFragment();
//                fragmentTransaction.add(R.id.frmContenedorFragment, terceroFragment);
                fragmentTransaction.replace(R.id.frmContenedorFragment, terceroFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        this.btnCuarto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                CuartoFragment cuartoFragment = new CuartoFragment();
//                fragmentTransaction.add(R.id.frmContenedorFragment, cuartoFragment);
                fragmentTransaction.replace(R.id.frmContenedorFragment, cuartoFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
}