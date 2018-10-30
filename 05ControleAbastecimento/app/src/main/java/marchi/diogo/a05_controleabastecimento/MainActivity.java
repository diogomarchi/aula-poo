package marchi.diogo.a05_controleabastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("CALLBACK_LCA", "Método onpause da mainactivity");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("CALLBACK_LCA", "Método onresume da mainactivity");
    }

    public void verAbastecimento(View v){
        Intent intencaoAbrirTelaAbastecimentos = new Intent(this.getApplicationContext(), listaAbastecimentos.class);
        this.startActivity(intencaoAbrirTelaAbastecimentos);
    }
}