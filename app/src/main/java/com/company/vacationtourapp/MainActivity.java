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
        recentsDataList.add(new RecentsData("Machu Picchu","Peru","Rs.75,000/person",R.drawable.machu_picchu));
        recentsDataList.add(new RecentsData("Bora Bora","France","Rs.1,20,000/person",R.drawable.bora_bora));
        recentsDataList.add(new RecentsData("Angkor Wat","Cambodia","Rs.50,000/person",R.drawable.ankor_wat));
        recentsDataList.add(new RecentsData("Great Barrier Reef","Australia","Rs.85,000/person",R.drawable.great_barrier_reef));
        recentsDataList.add(new RecentsData("Taj Mahal","India","Rs.10,000/person",R.drawable.taj_mahal));
        recentsDataList.add(new RecentsData("Colosseum","Rome","Rs.80,000/person",R.drawable.colosseum));
        recentsDataList.add(new RecentsData("Eiffel Tower","France","Rs.1,60,000/person",R.drawable.eiffel_tower));
        recentsDataList.add(new RecentsData("Grand Canyon","United States","Rs.1,30,000/person",R.drawable.grand_canyon));
        recentsDataList.add(new RecentsData("Great Wall Of China","China","Rs.70,000/person",R.drawable.the_great_wall_of_china));
        recentsDataList.add(new RecentsData("Stonehenge","England","Rs.1,80,000/person",R.drawable.stonehenge));
        recentsDataList.add(new RecentsData("Mount Fuji","Japan","Rs.1,50,000/person",R.drawable.mount_fuji));
        recentsDataList.add(new RecentsData("Great Pyramid of Giza","Egypt","Rs.1,00,000/person", R.drawable.the_great_pyramid_of_giza));
        recentsDataList.add(new RecentsData("Victoria Falls","South Africa","Rs.1,15,000/person",R.drawable.victoria_falls));
        recentsDataList.add(new RecentsData("Glacier-National Park","United States","Rs.1,40,000/person",R.drawable.glacier));
        recentsDataList.add(new RecentsData("Great Blue Hole","New Mexico","Rs.1,25,000/person",R.drawable.great_blue_hole));


        setRecentRecycler(recentsDataList);

        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Taj Mahal","India","Rs.10,000/person",R.drawable.taj_mahal));
        topPlacesDataList.add(new TopPlacesData("Mount Fuji","Japan","Rs.1,50,000/person",R.drawable.mount_fuji));
        topPlacesDataList.add(new TopPlacesData("Eiffel Tower","France","Rs.1,60,000/person",R.drawable.eiffel_tower));
        topPlacesDataList.add(new TopPlacesData("Machu Picchu","Peru","Rs.75,000/person",R.drawable.machu_picchu));
        topPlacesDataList.add(new TopPlacesData("Great Wall Of China","China","Rs.70,000/person",R.drawable.the_great_wall_of_china));

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
