package br.univali.marchiedu.diogo.a05_controleabastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class itemDetalhado extends AppCompatActivity {

    private Abastecimento objeto;
    private TextView nome_posto, kiloInd, litersInd, kiloView,litersView, dataView, latd,longt ;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detalhado);

        logo = findViewById(R.id.posto_imagem);
        nome_posto = findViewById(R.id.textnome);
        kiloInd = findViewById(R.id.textquilo);
        kiloView = findViewById(R.id.textviewquilo);
        litersInd = findViewById(R.id.textlitros);
        litersView = findViewById(R.id.textviewlitros);
        dataView = findViewById(R.id.textdata);

        latd = findViewById(R.id.latitude);
        longt = findViewById(R.id.longitude);

        this.objeto = (Abastecimento) getIntent().getSerializableExtra("registro");

        if(objeto.getNomePosto().equals(0)){
            this.logo.setImageResource(R.drawable.petrobras);
            nome_posto.setText("Petrobras");
        }else if(objeto.getNomePosto().equals(1)){
            this.logo.setImageResource(R.drawable.ipiranga);
            nome_posto.setText("Ipiranga");
        }else if(objeto.getNomePosto().equals(2)){
            this.logo.setImageResource(R.drawable.shell);
            nome_posto.setText("shell");
        }else if(objeto.getNomePosto().equals(3)){
            this.logo.setImageResource(R.drawable.texaco);
            nome_posto.setText("Texaco");
        }

        dataView.setText(objeto.getData());
        kiloInd.setText("Quilometragem");
        litersInd.setText("Litros");
        kiloView.setText(""+objeto.getQuilometragem());
        litersView.setText(""+objeto.getLitro());

        latd.setText(""+objeto.getLatitude());
        longt.setText(""+objeto.getLongitude());

    }
}
