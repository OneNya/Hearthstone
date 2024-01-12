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

public class RecyclerAdapter2nd extends FirebaseRecyclerAdapter<Model2, RecyclerAdapter2nd.viewHolder> {
    Context context;

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public RecyclerAdapter2nd(@NonNull FirebaseRecyclerOptions options) {
        super(options);
    }


    @NotNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview2, parent, false);
        return new viewHolder(view);
    }


    @Override
    protected void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull Model2 model) {
        holder.names.setText(model.getName());
        holder.rank.setText("#" + model.getRank());
        String string = model.getName().toLowerCase().toString();
        int player = 0;
        switch (position) {
            case 0:
                holder.card.setBackgroundResource(R.drawable.p1);
                break;
            case 1:
                holder.card.setBackgroundResource(R.drawable.p2);
                break;
            case 2:
                holder.card.setBackgroundResource(R.drawable.p3);
                break;
            case 3:
                holder.card.setBackgroundResource(R.drawable.p4);
                break;
        }

        Intent i = new Intent(context, Activity3.class);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int draw=0;
                switch (position+1){
                    case 1: draw=R.drawable.click1; break;
                    case 2: draw=R.drawable.click2; break;
                    case 3: draw=R.drawable.click3; break;
                    case 4: draw=R.drawable.click4; break;

                }
                i.putExtra("Click",draw);
                 context.startActivity(i);
                ((Activity)context).finish();

            }
        });

    }


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView names, rank, last;
        CardView card;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            names = itemView.findViewById(R.id.nameing);
            rank = itemView.findViewById(R.id.rankings);
            last = itemView.findViewById(R.id.lastrec);
            card = itemView.findViewById(R.id.cardView2);
        }
    }
}

