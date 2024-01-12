package com.example.hearthstone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class Activity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    CardView banner2;
    ImageView banner1;
    TextView pname,winrate;
    RecyclerAdapter2nd adapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recyc);
        banner1 = findViewById(R.id.banner1);
        banner2 = findViewById(R.id.banner2);
        pname=findViewById(R.id.LastName);
        winrate=findViewById(R.id.winrates);
        Intent i = getIntent();
        String name= i.getStringExtra("Name");
        int rank = i.getIntExtra("Rank", 1);
        pname.setText(name);
        winrate.setText(String.valueOf(Math.round(i.getFloatExtra("Winrate",71) * 100.0) / 100.0) + "%");
        int Playerimage = i.getIntExtra("playerImage", 1);
        String p = "Pl"+rank;
        switch (rank) {
            case 1:
                banner2.setBackgroundResource(R.drawable.player_1);
                break;
            case 2:
                banner2.setBackgroundResource(R.drawable.player2);
                break;
            case 3:
                banner2.setBackgroundResource(R.drawable.player3);
                break;
            case 4:
                banner2.setBackgroundResource(R.drawable.player4);
                break;
            case 5:
                banner2.setBackgroundResource(R.drawable.player5);
                break;
            case 6:
                banner2.setBackgroundResource(R.drawable.player6);
                break;
            case 7:
                banner2.setBackgroundResource(R.drawable.player7);
                break;
            case 8:
                banner2.setBackgroundResource(R.drawable.player8);
                break;
            case 9:
                banner2.setBackgroundResource(R.drawable.player9);
                break;
            case 10:
                banner2.setBackgroundResource(R.drawable.player10);
                break;

        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Model2> options =
                new FirebaseRecyclerOptions.Builder<Model2>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Pl2"), Model2.class)
                        .build();
        adapter = new RecyclerAdapter2nd(options);
        recyclerView.setAdapter(adapter);

        Picasso.get().load(Playerimage).into(banner1);
        getSupportActionBar().hide();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}