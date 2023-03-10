package benicio.solucoes.castanhalnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import benicio.solucoes.castanhalnews.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding vb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        vb = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(vb.getRoot());

        vb.btnEntrar.setOnClickListener( entrarView ->{
            Toast.makeText(this, "Quer entrar aonde?", Toast.LENGTH_LONG).show();
        });

        vb.btnCriarConta.setOnClickListener( entrarView ->{
            Toast.makeText(this, "não", Toast.LENGTH_LONG).show();
        });
    }
}