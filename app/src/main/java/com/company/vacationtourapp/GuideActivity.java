package com.company.vacationtourapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.company.vacationtourapp.adapter.GuideAdapter;
import com.company.vacationtourapp.model.GuideData;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
    RecyclerView GuideRecycler;
    GuideAdapter GuideAdapter;

    private Button main;
    private Button guide;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide);

        guide=(Button) findViewById(R.id.guide);
        guide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGuide();
            }
        });

        main=(Button) findViewById(R.id.main);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMain();
            }

        });


        List<GuideData> guideDataList = new ArrayList<>();
        guideDataList.add(new GuideData("Vedant Chaskar", "9988776655", "United States"));
        guideDataList.add(new GuideData("Suyash Shelar", "9136326286", "Australia"));
        guideDataList.add(new GuideData("Archa Jadhav", "9112931702", "France"));

        setGuideRecycler(guideDataList);
    }

    private void openGuide() {
        Intent intent = new Intent(this,GuideActivity.class);
        startActivity(intent);
    }

    private void openMain() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    private  void setGuideRecycler(List<GuideData> guideDataList){

        GuideRecycler = findViewById(R.id.guide_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        GuideRecycler.setLayoutManager(layoutManager);
        GuideAdapter = new GuideAdapter(this, guideDataList);
        GuideRecycler.setAdapter(GuideAdapter);

    }

}
