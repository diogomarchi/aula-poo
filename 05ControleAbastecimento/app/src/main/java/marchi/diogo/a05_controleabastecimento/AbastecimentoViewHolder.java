package marchi.diogo.a05_controleabastecimento;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AbastecimentoViewHolder extends RecyclerView.ViewHolder {

    //esta classe representa cada gaveta que será apresentada na lista

    private TextView tvQuilometragem;
    private TextView tvLitro;
    private TextView tvNomePosto;

    public AbastecimentoViewHolder(View itemView) {
        super(itemView);
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(view.getContext(), tvConteudo.getText().toString(), Toast.LENGTH_LONG).show();
//            }
//        });

        this.tvQuilometragem = itemView.findViewById(R.id.tvQuilometragem);
        this.tvLitro = itemView.findViewById(R.id.tvLitro);
        this.tvNomePosto = itemView.findViewById(R.id.tvNomePosto);
    }

    public void atualizaGaveta(Abastecimento objetoAbastecimento){
        this.tvQuilometragem.setText( objetoAbastecimento.getQuilometragem() );
        this.tvLitro.setText( objetoAbastecimento.getLitro() );
        this.tvNomePosto.setText( objetoAbastecimento.getNomePosto() );

        if(objetoAbastecimento.getMedia().equals("M1")){
            this.tvMedia.setTextColor(Color.BLUE);
        }else{
            this.tvMedia.setTextColor(Color.GRAY);
        }
    }

}
