package marchi.diogo.a05_controleabastecimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class AdicionarAbastecimentoActivity extends AppCompatActivity {

    public void onClickAcao1(View v){
        EditText etQuilometragem = findViewById(R.id.etQuilometragem);
        EditText etLitro = findViewById(R.id.etLitro);
        EditText etNomePosto = findViewById(R.id.etNomePosto);
        RadioGroup rgMedia = findViewById(R.id.rgMedia);

        //criando avaliação com dados aleatórios
        Abastecimento ab = new Abastecimento();

        ab.setQuilometragem( etQuilometragem.getText().toString() );
        ab.setLitro(etLitro.getText().toString());
        ab.setNomePosto(etNomePosto.getText().toString());

        RadioButton rbSelecionado = findViewById( rgMedia.getCheckedRadioButtonId() );
        ab.setMedia(rbSelecionado.getText().toString());


        //salvando a avaliação através do DAO
        boolean sucessoAoSalvar = AbastecimentoDao.salvar(this.getApplicationContext(), ab);

        if(sucessoAoSalvar){
            setResult(1);
            finish();
        }else{
            Toast.makeText(this.getApplicationContext(), "Erro ao salvar", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_abastecimento);
    }

}
