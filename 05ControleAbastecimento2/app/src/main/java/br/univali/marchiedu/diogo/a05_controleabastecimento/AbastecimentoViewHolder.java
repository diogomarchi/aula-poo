package br.univali.marchiedu.diogo.a05_controleabastecimento;

import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class AbastecimentoViewHolder extends RecyclerView.ViewHolder {

    private TextView  tvdata, tvfuel, tvkm;
    private ImageView posto;

    private  Abastecimento itemLook;

    public AbastecimentoViewHolder(@NonNull View itemView) {
        super(itemView);

        itemView.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v){
                Intent openActiviy = new Intent(v.getContext(), itemDetalhado.class);
                openActiviy.putExtra("registro", (Parcelable) AbastecimentoViewHolder.this.itemLook);
                ((listaAbastecimentos) v.getContext()).startActivity(openActiviy);
            }
        });

        this.tvkm = itemView.findViewById(R.id.distance_view);
        this.tvdata = itemView.findViewById(R.id.date_view);
        this.posto = itemView.findViewById(R.id.image_posto);
        this.tvfuel = itemView.findViewById(R.id.liters_view);
    }

    public void atualiza_ItemLista(Abastecimento item){

        itemLook= item;

        this.tvkm.setText("Km: "+item.getDistancia());
        this.tvdata.setText(item.getData());
        this.tvfuel.setText(item.getLitros()+"L");

        if(item.getPosto()==0){
            this.posto.setImageResource(R.drawable.petrobras);
        }else if(item.getPosto()==1){
            this.posto.setImageResource(R.drawable.ipiranga);
        }else if(item.getPosto()==2){
            this.posto.setImageResource(R.drawable.shell);
        }else if(item.getPosto()==3){
            this.posto.setImageResource(R.drawable.texaco);
        }else{
        }
    }
}


