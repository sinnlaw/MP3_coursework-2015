package com.sinnlaw.ching.muccoursework;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by ching on 2015/11/23.
 */
public class RestScreen extends Activity implements View.OnClickListener{

    ListView restListView;
    Button homeBtn;

    ListAdapter adapter;
    saveRest saveRestInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest_screen_layout);

        //setup ListView
        restListView = (ListView) findViewById(R.id.restList);
        //setup Button
        homeBtn = (Button) findViewById(R.id.homeButton);
        homeBtn.setOnClickListener(this);

        saveRestInfo = new saveRest();

        //rest info
        int[] restImg = {R.drawable.foodimg_1, R.drawable.foodimg_2, R.drawable.foodimg_3, R.drawable.foodimg_4, R.drawable.foodimg_5,
                R.drawable.foodimg_6, R.drawable.foodimg_7, R.drawable.foodimg_8, R.drawable.foodimg_9, R.drawable.foodimg_10};

        final String[] restName = {"Tiffneys Steakhouse", "Gamba Seafood Restaurant", "Black Sheep Bistro","Sapori D'Italia","111 by Nico",
        "Number 16","Cail Bruich","Riverhill Restaurant & Bar","Bella Vita","Two Fat Ladies at the Buttery"};

        String[] restPrice = {"£12 - £42", "£7 - £36", " £9 - £22","£6 - £12","-","£3 - £17","£15 - £90","-", "£19","-"};

        //setup array
        int i = 0;
        adapter = new ListAdapter(getApplicationContext(), R.layout.listview_layout);
        //Assign adapter to ListView
        restListView.setAdapter(adapter);

        for (String title : restName) {
            ListData dataProvider = new ListData(restImg[i],
                    title, restPrice[i]);
            adapter.add(dataProvider);
            i++;
        }

        //when ListView press
        restListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int itemPosition = position;
                String itemValue = restName[itemPosition];
                saveRestInfo.setRestName(itemValue);

//                //Show resuit
//                Toast.makeText(getApplicationContext(),"Position : "+itemPosition+" ListItem : "+itemValue +" " + saveRestInfo.getRestName(), Toast.LENGTH_LONG).show();

                Intent map_Screen = new Intent(getApplicationContext(), mapScreen.class);
                map_Screen.putExtra("mapScreenTitle", saveRestInfo.getRestName());
                startActivity(map_Screen);
            }
        });
    }


    @Override
    public void onClick(View view) {

        Intent home_Screen = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(home_Screen);

    }

}
