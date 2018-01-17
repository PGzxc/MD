package com.example.az.md;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.lang.reflect.Method;

/**
 * Created by cc on 17-12-15.
 */

public class SearchActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private SearchView mSearchView;
    SearchView.SearchAutoComplete mSearchAutoComplete;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_search);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSearchAutoComplete.isShown()) {
                    try {
                        mSearchAutoComplete.setText("");//清除文本
                        //利用反射调用收起SearchView的onCloseClicked()方法
                        Method method = mSearchView.getClass().getDeclaredMethod("onCloseClicked");
                        method.setAccessible(true);
                        method.invoke(mSearchView);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    finish();
                }

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search_view,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        mSearchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        //mSearchView.setIconified(false);
        //mSearchView.onActionViewExpanded();
        mSearchView.setQueryHint("请输入内容");
        //mSearchView.setSubmitButtonEnabled(true);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(SearchActivity.this,query,Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        mSearchAutoComplete = (SearchView.SearchAutoComplete) mSearchView.findViewById(R.id.search_src_text);

        //设置输入框提示文字样式
        mSearchAutoComplete.setHintTextColor(getResources().getColor(android.R.color.white));//设置提示文字颜色
        mSearchAutoComplete.setTextColor(getResources().getColor(android.R.color.white));//设置内容文字颜色



        return true;

    }
}
