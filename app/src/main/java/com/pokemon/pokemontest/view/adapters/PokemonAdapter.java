package com.pokemon.pokemontest.view.adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pokemon.pokemontest.R;
import com.pokemon.pokemontest.data.model.Pokemon;
import com.pokemon.pokemontest.view.callbacks.MyItemClickListener;
import com.pokemon.pokemontest.view.ui.MainActivity;

import java.util.List;


public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.ViewHolder> {

    Context context;

    List<Pokemon> itemList;
    private int lastPosition = -1;
    public PokemonAdapter(Context context, List<Pokemon> itemList) {
        this.context = context;
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_pokemon, parent, false);
        PokemonAdapter.ViewHolder viewHolder = new PokemonAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Pokemon model = itemList.get(position);

        Glide.with(context).load(model.getImg()).into(holder.image);
        holder.name.setText(model.getName());

        holder.setMyItemClickListener(new MyItemClickListener() {
            @Override
            public void onClick(View view, int position) {
//                    Toast.makeText(context, "clicked!  "+model.getName(), Toast.LENGTH_SHORT).show();
                if(context instanceof MainActivity){
                    ((MainActivity)context).gotoDetail(position);
                }
            }
        });
        setAnimation(holder.itemView, position);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        TextView name;

        MyItemClickListener myItemClickListener;


        public void setMyItemClickListener(MyItemClickListener myItemClickListener) {
            this.myItemClickListener = myItemClickListener;
        }

        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.name);

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            myItemClickListener.onClick(v,getAdapterPosition());
        }
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
}
