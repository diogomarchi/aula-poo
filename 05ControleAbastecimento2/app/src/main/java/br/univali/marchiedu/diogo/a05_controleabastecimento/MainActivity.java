package br.univali.marchiedu.diogo.a05_controleabastecimento;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.Toast;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import android.content.pm.PackageManager;
import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;


import static br.univali.marchiedu.diogo.a05_controleabastecimento.R.id.tvMedia;

public class MainActivity extends AppCompatActivity {

    private boolean permissao;
    int codigo = 2409;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = MainActivity.this.getSupportFragmentManager();
        for(int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
        setContentView(R.layout.activity_main);

        //verifica se ja tem permissao de gps
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //pede permissao ao usuario
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        else{
            permissao = true;
        }

    }

    @Override//verifica se o usuario deu acesso ou nao ao utilizar o gps
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    permissao = true;
                } else {
                    Toast.makeText(this, "Não vai funcionar!!!", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    public void verAbastecimento(View view) {
        Intent intent = new Intent(this.getApplicationContext(), listaAbastecimentos.class);
        intent.putExtra("permissao", permissao);
        startActivity(intent);
    }


    @Override
    public void onResume (){
        super.onResume();

        ArrayList<Abastecimento> abastecimentos =  new ArrayList<Abastecimento>();

        abastecimentos = AbastecimentoDao.getLista(this.getApplicationContext());

        if(abastecimentos.size()>1){
            double autonomia;
            double kmPercorridos;
            double litros = 0;

            kmPercorridos = abastecimentos.get(abastecimentos.size()-1).getQuilometragem() - abastecimentos.get(0).getQuilometragem();
            for (int i = 0; i < abastecimentos.size()-1; i++) {
                litros = litros + abastecimentos.get(i).getLitro();
            }

            autonomia = kmPercorridos/litros;

            TextView tvResult = findViewById(tvMedia);
            NumberFormat nf = DecimalFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            tvResult.setText(nf.format(autonomia));
        }
    }
}
