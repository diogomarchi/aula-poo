package br.univali.marchiedu.diogo.a05_controleabastecimento;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class AdicionarAbastecimentoActivity extends AppCompatActivity {
    private EditText km, data, fuel;
    private Spinner posto;
    private double kmOld;
    private boolean permissaofinal;
    private Location location;
    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento);

        posto = findViewById(R.id.spinPosto);
        km = findViewById(R.id.editkm);
        data = findViewById(R.id.editdate);
        fuel = findViewById(R.id.editfuel);

        //dapta o vetor de opções para usar no spinner
        ArrayAdapter<CharSequence> adapterSpin = ArrayAdapter.createFromResource(this.getApplicationContext(), R.array.PostosGasolina, android.R.layout.simple_spinner_item);
        //como vai ser visto o vetor
        adapterSpin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        posto.setAdapter(adapterSpin);

        kmOld = this.getIntent().getDoubleExtra("kmAntigo", -1);
        permissaofinal = this.getIntent().getBooleanExtra("permissao", false);
    }


    public void onclickdado(View v) {

        //Cria um item sem nada
        Abastecimento item = new Abastecimento();


        if (km.getText().toString().equals("")) {
            this.km.setError("insira valor correto");
        }
        if (fuel.getText().toString().equals("")) {
            this.fuel.setError("insira valor correto");
            return;
        }
        if (data.getText().toString().equals("")) {
            this.data.setError("insira valor correto");
            return;
        }
        if (Double.parseDouble(km.getText().toString()) <= this.kmOld) {
            this.km.setError("Insira valor correto");
            return;
        }

        if (permissaofinal == true) {
            GPSprovider g = new GPSprovider(getApplicationContext());
            Location l = g.getLocation();
            if (l != null) {
                item.setLatitude(l.getLatitude());
                item.setLongitude(l.getLongitude());
            }
        } else {
            item.setLatitude(010);
            item.setLongitude(010);
        }

        item.setData(data.getText().toString());
        item.setDistancia(Double.parseDouble(km.getText().toString()));
        item.setLitros(Double.parseDouble(fuel.getText().toString()));
        item.setPosto(posto.getSelectedItemPosition());

        //salvando
        boolean sucesso = AbastecimentoDao.salvar(this.getApplicationContext(), item);

        if (sucesso) {
            setResult(1);
            finish();
        } else {
            Toast.makeText(this.getApplicationContext(), "Erro ao salvar", Toast.LENGTH_LONG).show();
        }
    }
}

