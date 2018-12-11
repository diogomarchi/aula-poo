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
    private String postos[] = new String[]{"Ipiranga", "Petrobras", "Shell", "Texaco", "Outros"};
    EditText etQuilometragemAtual;
    EditText etLitro;
    EditText etData;
    private Spinner sPosto;
    private Float kmAntigo;
    private boolean permissaofinal;
    private Location location;
    private LocationManager locationManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, postos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        kmAntigo = this.getIntent().getFloatExtra("kmAntigo", -1);

        sPosto = (Spinner) findViewById(R.id.sPosto);
        sPosto.setAdapter(adapter);

        etQuilometragemAtual = findViewById(R.id.etQuilometragem);
        etLitro = findViewById(R.id.etLitro);
        etData = findViewById(R.id.etData);
        permissaofinal = this.getIntent().getBooleanExtra("permissao", false);
    }

    public void salvarKm(View view) {

        Abastecimento abastecimento = new Abastecimento();

        if (etQuilometragemAtual.getText().toString().equals("") || etLitro.getText().toString().equals("") || etData.getText().toString().equals("")) {

            if (etQuilometragemAtual.getText().toString().equals("")) {
                this.etQuilometragemAtual.setError(getString(R.string.campo_preenchido));
                return;
            }

            if (etLitro.getText().toString().equals("")) {
                this.etLitro.setError(getString(R.string.campo_preenchido));
                return;
            }

            if (etData.getText().toString().equals("")) {
                this.etData.setError(getString(R.string.campo_preenchido));
                return;
            }
            return;

        }

        if(Float.parseFloat(etQuilometragemAtual.getText().toString()) <= this.kmAntigo){
            this.etQuilometragemAtual.setError(getString(R.string.km_maior));
            return;
        }

        if (permissaofinal == true) {
            GPSprovider g = new GPSprovider(getApplicationContext());
            Location l = g.getLocation();
            if (l != null){
                abastecimento.setLatitude(l.getLatitude());
                abastecimento.setLongitude(l.getLongitude());
            }
        } else {
            abastecimento.setLatitude(010);
            abastecimento.setLongitude(010);
        }

        abastecimento.setQuilometragem(Float.parseFloat(etQuilometragemAtual.getText().toString()));
        abastecimento.setLitro(Float.parseFloat(etLitro.getText().toString()));
        abastecimento.setData(etData.getText().toString());
        abastecimento.setNomePosto(sPosto.getSelectedItem().toString());


        boolean salvo = AbastecimentoDao.salvar(this.getApplicationContext(), abastecimento);

        if(salvo){
            setResult(1);
            finish();//voltar activity anterior
        }else{
            Toast.makeText(this.getApplicationContext(), "Erro ao salvar", Toast.LENGTH_SHORT).show();
        }
    }


}
