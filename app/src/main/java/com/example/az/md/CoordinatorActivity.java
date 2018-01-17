package com.example.az.md;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

/**
 * Created by az on 2017/12/21.
 */

public class CoordinatorActivity extends AppCompatActivity {
    private RecyclerAdapter<String> mAdapter;
    private RecyclerView rv;
    //private Toolbar mToolbar;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_coordinator);

        //mToolbar = findViewById(R.id.toolbar);
        fab = findViewById(R.id.fab);
        rv = findViewById(R.id.rv);
        //setSupportActionBar(mToolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);
        addData();
    }

    private void addData(){
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mAdapter = new RecyclerAdapter<String>(this,R.layout.item_tab) {
            @Override
            protected void convert(RecyclerAdapterHelper helper, String item) {
                helper.setText(R.id.text,item);
            }
        };
        rv.setAdapter(mAdapter);

        for(int i = 'a';i<='z';i++){
            mAdapter.add((char)i+"");
        }
    }




}
