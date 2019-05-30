package com.pokemon.pokemontest.view.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.chip.Chip;
import com.pokemon.pokemontest.R;
import com.pokemon.pokemontest.view.callbacks.MyItemClickListener;

import java.util.List;


public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> {

    Context context;

    List<String> itemList;

    public TypeAdapter(Context context, List<String> itemList) {
        this.context = context;
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_chip, parent, false);
        TypeAdapter.ViewHolder viewHolder = new TypeAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.chip_item.setText(itemList.get(position));
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        Chip chip_item;

        MyItemClickListener myItemClickListener;


        public void setMyItemClickListener(MyItemClickListener myItemClickListener) {
            this.myItemClickListener = myItemClickListener;
        }

        public ViewHolder(View itemView) {
            super(itemView);

            chip_item = itemView.findViewById(R.id.chip_item);

        }


    }
}
