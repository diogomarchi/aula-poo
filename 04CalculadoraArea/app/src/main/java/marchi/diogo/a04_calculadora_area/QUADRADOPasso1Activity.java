package marchi.diogo.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class QUADRADOPasso1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadradopasso1);
    }

    public void onClickAvancar(View v){
        EditText etAltura = findViewById(R.id.etAltura);
        EditText etBase = findViewById(R.id.etBase);

        double altura = Double.parseDouble(etAltura.getText().toString());
        double base = Double.parseDouble(etBase.getText().toString());


        Intent intencaoAbrirQUADRADOResultado = new Intent(this.getApplicationContext(), QUADRADOResultadoActivity.class);

        intencaoAbrirQUADRADOResultado.putExtra("altura", altura);
        intencaoAbrirQUADRADOResultado.putExtra("base", base);

        this.startActivity(intencaoAbrirQUADRADOResultado);
    }

    public void onClickVoltarMainActivity(View v){
        Intent intencaoAbrirTelaInicio = new Intent(this.getApplicationContext(), MainActivity.class);
        this.startActivity(intencaoAbrirTelaInicio);
    }

}