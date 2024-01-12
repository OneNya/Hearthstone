package com.example.hearthstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Activity3 extends AppCompatActivity {
ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        imageView=findViewById(R.id.clickImage);
        int Playerimage = getIntent().getIntExtra("Click", 1);
        Picasso.get().load((Playerimage)).into(imageView);
    }

}