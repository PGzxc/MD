package com.example.az.md;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

/**
 * Created by az on 2017/12/19.
 */

public class CollapsingActivity extends AppCompatActivity{

    private Toolbar mToolbar;
    private RecyclerView rv;
    private RecyclerAdapter<String> mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_collapsing);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rv = findViewById(R.id.rv);
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
