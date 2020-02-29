package com.aa.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcy;
    Button ba, bb, bc, delete;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new Adapter();
        rcy = findViewById(R.id.rcy);
        rcy.setLayoutManager(new LinearLayoutManager(this));
        rcy.setAdapter(adapter);
        ba = findViewById(R.id.pa);
        bb = findViewById(R.id.pb);
        bc = findViewById(R.id.pc);
        delete = findViewById(R.id.delete);
        ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItem(new AData());
                adapter.notifyDataSetChanged();
            }
        });
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItem(new BData());
                adapter.notifyDataSetChanged();
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItem(new CData());
                adapter.notifyDataSetChanged();
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int index = random.nextInt(adapter.getData().size());
                Log.d("Random", index + "");
                if(adapter.getData().size()>0){
                    adapter.getData().remove(index);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}
