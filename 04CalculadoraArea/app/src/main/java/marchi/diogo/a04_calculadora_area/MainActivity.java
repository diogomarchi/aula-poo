package marchi.diogo.a04_calculadora_area;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("CALLBACK_LCA", "Método onpause da mainactivity");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("CALLBACK_LCA", "Método onresume da mainactivity");
    }

    public void onClickQUADRADO(View v){
        Intent intencaoAbrirTelaQUADRADO = new Intent(this.getApplicationContext(), QUADRADOPasso1Activity.class);
        this.startActivity(intencaoAbrirTelaQUADRADO);
    }

    public void onClickCIRCULO(View v){
        Intent intencaoAbrirTelaCIRCULO = new Intent(this.getApplicationContext(), CIRCULOPasso1Activity.class);
        this.startActivity(intencaoAbrirTelaCIRCULO);

    }

    public void onClickTRIANGULO(View v){
        Intent intencaoAbrirTelaTRIANGULO = new Intent(this.getApplicationContext(), TRIANGULOPasso1Activity.class);
        this.startActivity(intencaoAbrirTelaTRIANGULO);
    }


}