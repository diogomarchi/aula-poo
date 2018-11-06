package br.univali.marchiedu.diogo.a05_controleabastecimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;


public class listaAbastecimentos extends AppCompatActivity {

    private AbastecimentoAdapter adaptador;

    private final int RC_ADICIONAR_ABASTECIMENTO = 1312;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_abastecimentos);

        RecyclerView rvListaAbastecimento = findViewById(R.id.rvListaAbastecimentos);

        this.adaptador = new AbastecimentoAdapter();

        this.adaptador.listaAbastecimento = AbastecimentoDao.getLista(this.getApplicationContext());

        rvListaAbastecimento.setAdapter(this.adaptador);

        rvListaAbastecimento.setLayoutManager( new LinearLayoutManager(this.getApplicationContext()));
    }

    public void telaAdicionarAbastecimento(View v){

        Intent intencao = new Intent(this.getApplicationContext(), AdicionarAbastecimentoActivity.class);
        if(this.adaptador.listaAbastecimento.size()>0) {
            intencao.putExtra("kmAntigo", this.adaptador.listaAbastecimento.get(this.adaptador.listaAbastecimento.size() - 1).getQuilometragem());
        }
        startActivityForResult(intencao, RC_ADICIONAR_ABASTECIMENTO);

//        this.adaptador.notifyDataSetChanged();
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_ADICIONAR_ABASTECIMENTO) {
            //estou tratando o fechamento da activity AdicionarAvaliacaoActivity
            if (resultCode == 1) {
                Toast.makeText(this.getApplicationContext(), "Abastecimento Salvo!!!!!", Toast.LENGTH_LONG).show();
            }
            this.adaptador.notifyDataSetChanged();
        }else {
                Toast.makeText(this.getApplicationContext(), "BACK BUTTON (PROVÁVEL)...", Toast.LENGTH_LONG).show();
            }
    }
}
