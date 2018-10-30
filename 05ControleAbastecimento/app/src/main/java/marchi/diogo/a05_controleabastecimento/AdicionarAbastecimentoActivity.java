package marchi.diogo.a05_controleabastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AdicionarAbastecimentoActivity extends AppCompatActivity {

    public void onClick(View v){
        EditText etQuilometragem = findViewById(R.id.etQuilometragem);
        EditText etLitro = findViewById(R.id.etLitro);
        EditText etData = findViewById(R.id.etData);
        RadioGroup rgPosto = findViewById(R.id.rgPosto);

        //criando avaliação com dados aleatórios
        Abastecimento ab = new Abastecimento();

        ab.setQuilometragem( etQuilometragem.getText().toString() );
        ab.setLitro(etLitro.getText().toString());
        ab.setData(etData.getText().toString());

        RadioButton rbSelecionado = findViewById( rgPosto.getCheckedRadioButtonId() );
        ab.setNomePosto(rbSelecionado.getText().toString());


        //salvando a avaliação através do DAO
        boolean sucessoAoSalvar = AbastecimentoDao.salvar(this.getApplicationContext(), ab);

        if(sucessoAoSalvar){
            setResult(1);
            finish();
        }else{
            Toast.makeText(this.getApplicationContext(), "Erro ao salvar", Toast.LENGTH_SHORT).show();
        }

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento);
    }
}
