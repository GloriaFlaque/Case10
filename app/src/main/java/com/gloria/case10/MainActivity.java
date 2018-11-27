package com.gloria.case10;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText nickName;
    private Spinner spinner;
    private FortniteAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private FloatingActionButton btnGo;
    private JobsViewModel forniteViewModel;
    private String plattaform;
    private String epic_nickname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nickName = findViewById(R.id.nickname);
        spinner = findViewById(R.id.spinner);
        btnGo = findViewById(R.id.btnGo);

        changeData("","");

        ckickbuttongo();

        setTitle("Fortnite");
    }

    private void changeData(String plattaform,String epic_nickname){
        forniteViewModel = ViewModelProviders.of(this).get(JobsViewModel.class);
        forniteViewModel.dataFornite.observe(this, statsData -> {
            if(statsData!=null){
                Log.d("ServicioFornite","Cambios: "+statsData);
                generateForniteList(statsData);
            }
        });
        forniteViewModel.getData(plattaform, epic_nickname);
    }

    private void generateForniteList(List<StatsData> listFornite) {
        recyclerView = findViewById(R.id.recycleview);
        adapter = new FortniteAdapter(listFornite);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void ckickbuttongo(){
        btnGo.setOnClickListener(v -> {
            plattaform = spinner.getSelectedItem().toString();
            epic_nickname = nickName.getText().toString();
            Log.d("Cambio","plataforma "+plattaform+" epic_name "+epic_nickname);
            forniteViewModel.getData(plattaform, epic_nickname);
            setTitle(epic_nickname);
        });

    }
}
