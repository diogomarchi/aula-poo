package br.univali.marchiedu.diogo.a05_controleabastecimento;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AbastecimentoViewHolder extends RecyclerView.ViewHolder {

    //esta classe representa cada gaveta que será apresentada na lista

    private TextView tvQuilometragem;
    private TextView tvLitro;
    private ImageView ivNomePosto;
    private TextView tvData;

    public AbastecimentoViewHolder(View itemView) {
        super(itemView);
        this.tvQuilometragem = itemView.findViewById(R.id.tvQuilometragem);
        this.tvLitro = itemView.findViewById(R.id.tvLitro);
        this.ivNomePosto = itemView.findViewById(R.id.ivNomePosto);
        this.tvData = itemView.findViewById(R.id.tvData);
    }

    public void atualizaGaveta(Abastecimento objetoAbastecimento){
        String quilometros = "Km: " + String.valueOf(objetoAbastecimento.getQuilometragem());
        String litros = String.valueOf(objetoAbastecimento.getLitro()) + " L";
        String posto = objetoAbastecimento.getNomePosto();




        this.tvQuilometragem.setText( quilometros);
        this.tvLitro.setText( litros );
        this.tvData.setText( objetoAbastecimento.getData() );

        if(objetoAbastecimento.getNomePosto().equals("Texaco"))
        {
            ivNomePosto.setImageResource(R.drawable.texaco);
        }
        else if(objetoAbastecimento.getNomePosto().equals("Shell"))
        {
            ivNomePosto.setImageResource(R.drawable.shell);
        }
        else if(objetoAbastecimento.getNomePosto().equals("Petrobras"))
        {
            ivNomePosto.setImageResource(R.drawable.petrobras);
        }
        else if(objetoAbastecimento.getNomePosto().equals("Ipiranga"))
        {
            ivNomePosto.setImageResource(R.drawable.ipiranga);
        }
        else{
            ivNomePosto.setImageResource(R.drawable.posto_de_gasolina);
        }
    }

}

