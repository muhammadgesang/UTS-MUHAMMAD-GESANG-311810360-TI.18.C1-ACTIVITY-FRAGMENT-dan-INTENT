package com.example.a4fragment;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMove = findViewById(R.id.btnMove);
        Button btnShare = findViewById(R.id.btnShare);

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, DetailActivity.class));

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentPertama fragmentPertama = new FragmentPertama();
                fragmentTransaction.add(R.id.frame_content, fragmentPertama);
                fragmentTransaction.addToBackStack("fragmentPertama");
                fragmentTransaction.commit();
            }
        });

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(intent.EXTRA_TEXT,"Hallo saya Share yaa :)");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"Share to : "));
            }
        });

    }

}