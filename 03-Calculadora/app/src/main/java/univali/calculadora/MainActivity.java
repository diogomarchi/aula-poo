package univali.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calcularSalario(View elementoClicado){
        EditText salarioParcial = findViewById(R.id.etSalario);
        EditText dias = findViewById(R.id.etDia);
        TextView salario = findViewById(R.id.tvSalario);

        String salarioDigitado = salarioParcial.getText().toString();
        String diasDigitado = dias.getText().toString();

        if(salarioDigitado.equals("")  || diasDigitado.equals("")){
            salarioParcial.setError("Informe a altura");
            dias.setError("Informe o peso");
            return;
        }

        try{
            double salarioParcialEmDouble = Double.parseDouble(salarioDigitado);
            double diasEmDouble = Double.parseDouble(diasDigitado);

            double resultadoSalario = salarioParcialEmDouble*diasEmDouble;

            salario.setText( "Salario: "+resultadoSalario );
            salario.setVisibility(View.VISIBLE);
        }catch (Exception e){
            Toast mensagemErro = Toast.makeText(this, "Algo errado aconteceu", Toast.LENGTH_LONG);
            mensagemErro.show();
        }



    }
}
