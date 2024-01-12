package com.example.hearthstone;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Recycler_adapter extends FirebaseRecyclerAdapter<ModelClass, Recycler_adapter.myViewHolder> {
    Context context;
    ArrayList<ModelClass> arrayList;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Recycler_adapter(@NonNull FirebaseRecyclerOptions options) {
        super(options);
    }


    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_cardview, parent, false);
        return new myViewHolder(view);
    }


    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull ModelClass model) {
        holder.Name.setText(model.getName());
        holder.rank.setText("#" + model.getRank());
        holder.winrate.setText(String.valueOf(Math.round(model.winrate * 100.0) / 100.0) + "%");
        String string = model.getName().toLowerCase().toString();
        int player = 0;
        switch (model.getName()) {
            case "Paladin":
                holder.card.setBackgroundResource(R.drawable.paladin);
                player=R.drawable.paladin;
                break;
            case "Shaman":
                holder.card.setBackgroundResource(R.drawable.shaman);
                player=R.drawable.shaman;
                break;
            case "Mage":
                holder.card.setBackgroundResource(R.drawable.mage);
                player=R.drawable.mage;
                break;
            case "Warrior":
                holder.card.setBackgroundResource(R.drawable.warrior);
                player=R.drawable.warrior;
                break;
            case "Priest":
                holder.card.setBackgroundResource(R.drawable.piest);
                player=R.drawable.piest;
                break;
            case "Death Knight":
                holder.card.setBackgroundResource(R.drawable.knight);
                player=R.drawable.knight;
                break;
            case "Demon Hunter":
                holder.card.setBackgroundResource(R.drawable.hunter);
                player=R.drawable.hunter;
                break;
            case "Warlock":
                holder.card.setBackgroundResource(R.drawable.warlock);
                player=R.drawable.warlock;
                break;
            case "Rogue":
                holder.card.setBackgroundResource(R.drawable.rogue);
                player=R.drawable.rogue;
                break;
            case "Druid":
                holder.card.setBackgroundResource(R.drawable.druid);
                player=R.drawable.druid;
                break;
        }
        Intent i = new Intent(context, Activity2.class);
        int finalPlayer = player;
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.putExtra("Rank",position+1);
                i.putExtra("playerImage", finalPlayer);
                i.putExtra("Winrate", model.winrate);
                i.putExtra("Name",model.getName());
                context.startActivity(i);
                ((Activity)context).finish();
            }
        });

    }


    public static class myViewHolder extends RecyclerView.ViewHolder {
        TextView Name, rank, winrate;
        CardView card;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            rank = itemView.findViewById(R.id.ranking);
            winrate = itemView.findViewById(R.id.winrate);
            card = itemView.findViewById(R.id.cardView1);
        }
    }
}

