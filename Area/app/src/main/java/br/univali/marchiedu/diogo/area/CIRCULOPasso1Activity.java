package br.univali.marchiedu.diogo.area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CIRCULOPasso1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulopasso1);
    }

    public void onClickAvancar(View v){
        EditText etRaio = findViewById(R.id.etRaio);

        double raio = Double.parseDouble(etRaio.getText().toString());


        Intent intencaoAbrirCIRCULOResultado = new Intent(this.getApplicationContext(), CIRCULOResultadoActivity.class);

        intencaoAbrirCIRCULOResultado.putExtra("raio", raio);

        this.startActivity(intencaoAbrirCIRCULOResultado);

    }
}