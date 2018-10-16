package br.univali.marchiedu.diogo.area;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class QUADRADOResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcresultado);

        double altura = this.getIntent().getDoubleExtra("altura", -1);
        double largura = this.getIntent().getDoubleExtra("largura", -1);
        double areaQ = largura * Math.pow(altura, 2);

        TextView tvResultado = findViewById(R.id.tvResultado);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        tvResultado.setText(nf.format(areaQ));



    }
}