package br.univali.marchiedu.diogo.area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class TRIANGULOPasso1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadradopasso1);
    }

    public void onClickAvancar(View v){
        EditText etBase = findViewById(R.id.etBase);
        EditText etAltura = findViewById(R.id.etAltura);

        double base = Double.parseDouble(etBase.getText().toString());
        double altura = Double.parseDouble(etAltura.getText().toString());


        Intent intencaoAbrirTRIANGULOResultado = new Intent(this.getApplicationContext(), TRIANGULOResultadoActivity.class);

        intencaoAbrirTRIANGULOResultado.putExtra("base", base);
        intencaoAbrirTRIANGULOResultado.putExtra("altura", altura);

        this.startActivity(intencaoAbrirTRIANGULOResultado);
    }

    public void onClickVoltarMainActivity(View v){
        Intent intencaoAbrirTelaInicio = new Intent(this.getApplicationContext(), MainActivity.class);
        this.startActivity(intencaoAbrirTelaInicio);
    }

}