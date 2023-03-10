package benicio.solucoes.castanhalnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import benicio.solucoes.castanhalnews.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding vb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        vb = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(vb.getRoot());

        vb.btnEntrar.setOnClickListener( entrarView ->{
            startActivity(new Intent(getApplicationContext(), ActivitySite.class));
        });

    }
}