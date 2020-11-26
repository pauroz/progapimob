package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView myList;
    String[] items;
    String[] sizes;
    String[] descriptions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myList= (ListView) findViewById(R.id.myList);
        items = res.getStringArray(R.array.items);
        sizes = res.getStringArray(R.array.size);
        descriptions = res.getStringArray(R.array.description);

        itemAdapter itemAdapter = new itemAdapter(this, items, sizes, descriptions);
        myList.setAdapter(itemAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showactivity_main2 = new Intent(getApplicationContext(), MainActivity2.class);
                showactivity_main2.putExtra("com.example.myapplication.ITEM_POS", position);
                startActivity(showactivity_main2);
            }
        });
    }
}