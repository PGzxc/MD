package com.example.az.md;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pacific.adapter.RecyclerAdapter;
import com.pacific.adapter.RecyclerAdapterHelper;

/**
 * Created by cc on 17-12-18.
 */

public class TabFragment extends Fragment {

    private RecyclerView rv;
    private RecyclerAdapter<String> mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_tab,container,false);
        rv = v.findViewById(R.id.rv);
        addData();
        return v;
    }

    private void addData(){
        rv.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        mAdapter = new RecyclerAdapter<String>(getActivity(),R.layout.item_tab) {
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
