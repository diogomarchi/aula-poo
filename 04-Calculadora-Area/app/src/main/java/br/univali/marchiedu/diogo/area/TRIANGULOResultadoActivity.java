package br.univali.marchiedu.diogo.area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class TRIANGULOResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trianguloresultado);

        double base = this.getIntent().getDoubleExtra("base", -1);
        double altura = this.getIntent().getDoubleExtra("altura", -1);
        double areaT =  (base * altura)/2;

        TextView tvResultado = findViewById(R.id.tvResultado);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        nf.format(areaT);
        String total = "area triangulo: " + areaT;
        tvResultado.setText(total);
    }

    public void onClickVoltarTrianguloPasso1(View v){
        Intent intencaoAbrirTelaTriangulopasso1 = new Intent(this.getApplicationContext(), TRIANGULOPasso1Activity.class);
        this.startActivity(intencaoAbrirTelaTriangulopasso1);
    }

}