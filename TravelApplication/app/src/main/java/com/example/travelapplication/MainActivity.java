package com.example.travelapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView;
        ArrayList<Destination> arrayList;
        DestinationAdapter adapter;

        listView = findViewById(R.id.listviewDestination);
        arrayList = new ArrayList<>();
        arrayList.add(new Destination("Ba Na Hills", "1000000", "Da Nang", R.drawable.banahill));
        arrayList.add(new Destination("Hoi An", "1000000", "Quang Nam", R.drawable.hoian));
        arrayList.add(new Destination("Cau rong", "1000000", "Da Nang", R.drawable.caurong));
        arrayList.add(new Destination("Ba Na Hills", "1000000", "Da Nang", R.drawable.banahill));
        arrayList.add(new Destination("Hoi An", "1000000", "Quang Nam", R.drawable.hoian));
        arrayList.add(new Destination("Cau rong", "1000000", "Da Nang", R.drawable.caurong));

        adapter = new DestinationAdapter(MainActivity.this, R.layout.list_destination, arrayList);
        listView.setAdapter(adapter);
    }
}