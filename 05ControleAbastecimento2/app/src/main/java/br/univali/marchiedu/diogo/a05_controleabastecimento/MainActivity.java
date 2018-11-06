package br.univali.marchiedu.diogo.a05_controleabastecimento;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }

        setContentView(R.layout.activity_main);

        ArrayList<Abastecimento> abastecimentos =  new ArrayList<Abastecimento>();

        abastecimentos = AbastecimentoDao.getLista(this.getApplicationContext());

        if(abastecimentos.size()>1){
            double autonomia;
            double kmPercorridos;
            double litros = 0;

            kmPercorridos = abastecimentos.get(abastecimentos.size()-1).getQuilometragem() - abastecimentos.get(0).getQuilometragem();
            for (int i = 0; i < abastecimentos.size()-1; i++) {
                litros += abastecimentos.get(i).getLitro();
            }

            autonomia = kmPercorridos/litros;

            TextView tvResult = findViewById(R.id.tvMedia);

            tvResult.setText(String.valueOf(autonomia));
        }
    }



    public void verAbastecimento(View view) {
        Intent intent = new Intent(this.getApplicationContext(), listaAbastecimentos.class);
        startActivity(intent);
    }
}
