package br.univali.marchiedu.diogo.a05_controleabastecimento;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class AbastecimentoAdapter extends RecyclerView.Adapter {

    public ArrayList<Abastecimento> lista;

    //infla o item
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View elementoPai = LayoutInflater.from(parent.getContext()).inflate(R.layout.abastecimento_item_lista,parent,false);
        AbastecimentoViewHolder minhaGaveta = new AbastecimentoViewHolder(elementoPai);
        return minhaGaveta;
    }

    //manda atualizar os itens da lista
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {

        AbastecimentoViewHolder minhaGaveta = (AbastecimentoViewHolder) holder;
        Abastecimento daVez = lista.get(i);
        minhaGaveta.atualiza_ItemLista( daVez );

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }
}