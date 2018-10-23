package marchi.diogo.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class CIRCULOResultadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circuloresultado);

        double raio = this.getIntent().getDoubleExtra("raio", -1);
        double areaC =  3.14 * Math.pow(raio, 2);

        TextView tvResultado = findViewById(R.id.tvResultado);
        NumberFormat nf = DecimalFormat.getInstance();
        nf.setMaximumFractionDigits(1);
        nf.format(areaC);
        String total = "area do circulo: " + areaC;
        tvResultado.setText(total);
    }

    public void onClickFINALIZAR(View v){
        Intent intencaoVoltar = new Intent(this.getApplicationContext(), MainActivity.class);
        intencaoVoltar.addFlags(intencaoVoltar.FLAG_ACTIVITY_CLEAR_TOP);
        this.startActivity(intencaoVoltar);
    }
}