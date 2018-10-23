package br.univali.marchiedu.diogo.area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class QUADRADOResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadradoresultado);

        double altura = this.getIntent().getDoubleExtra("altura", -1);
        double base = this.getIntent().getDoubleExtra("base", -1);
        double areaQ = base * altura;

        TextView tvResultado = findViewById(R.id.tvResultado);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        nf.format(areaQ);
        String total = "area do quadrado: " + areaQ;
        tvResultado.setText(total);
    }

    public void onClickVoltarQuadradoPasso1(View v){
        Intent intencaoAbrirTelaQuadradopasso1 = new Intent(this.getApplicationContext(), QUADRADOPasso1Activity.class);
        this.startActivity(intencaoAbrirTelaQuadradopasso1);
    }
}