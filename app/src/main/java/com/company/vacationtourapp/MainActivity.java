package com.company.vacationtourapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.company.vacationtourapp.adapter.RecentsAdapter;
import com.company.vacationtourapp.adapter.TopPlacesAdapter;
import com.company.vacationtourapp.model.RecentsData;
import com.company.vacationtourapp.model.TopPlacesData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recentRecycler, topPlacesRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;

    private Button guide;
    private Button main;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        List<RecentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new RecentsData("AM Lake","India","From $200",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills","India","From $300",R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("AM Lake","India","From $200",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills","India","From $300",R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("AM Lake","India","From $200",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("Nilgiri Hills","India","From $300",R.drawable.recentimage2));

        setRecentRecycler(recentsDataList);

        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Kashmir Hill","India","$200 - $500",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Kashmir Hill","India","$200 - $500",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Kashmir Hill","India","$200 - $500",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Kashmir Hill","India","$200 - $500",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Kashmir Hill","India","$200 - $500",R.drawable.topplaces));

        setTopPlacesRecycler(topPlacesDataList);
    }

    private void openGuide() {
        Intent intent = new Intent(this,GuideActivity.class);
        startActivity(intent);
    }

    private void openMain() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }




    private  void setRecentRecycler(List<RecentsData> recentsDataList){

        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }

    private  void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList){

        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this, topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);



    }

}
