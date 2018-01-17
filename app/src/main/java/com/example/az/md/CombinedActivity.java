package com.example.az.md;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by cc on 17-12-17.
 */

public class CombinedActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private FloatingActionButton mFloatingActionButton;
    private CoordinatorLayout mCoordinatorLayout;
    private NavigationView mNavigationView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_combined);

        mToolbar = findViewById(R.id.toolbar);
        mDrawerLayout = findViewById(R.id.drawerlayout);
        mFloatingActionButton = findViewById(R.id.fab);
        mCoordinatorLayout = findViewById(R.id.coordinatorLayout);
        mNavigationView = findViewById(R.id.nav);
        setSupportActionBar(mToolbar);


        MenuItem menuNightMode = mNavigationView.getMenu().findItem(R.id.nav_share);
        SwitchCompat switchCompat = (SwitchCompat) MenuItemCompat.getActionView(menuNightMode);
        switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CombinedActivity.this,"isChecked:"+isChecked,Toast.LENGTH_SHORT).show();
            }
        });

        View headerLayout = mNavigationView.getHeaderView(0);
        //View headerLayout = mNavigationView.inflateHeaderView(R.layout.nav_header);
        ImageView iv = headerLayout.findViewById(R.id.head);
        iv.setImageResource(R.mipmap.ic_launcher);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.app_name, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(mCoordinatorLayout,"fab onClick",2000)
                        .setAction("确定", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(CombinedActivity.this,"确定",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.share:
                        Toast.makeText(CombinedActivity.this,"share",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bluetooth:
                        Toast.makeText(CombinedActivity.this,"bluetooth",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.headset:
                        Toast.makeText(CombinedActivity.this,"headset",Toast.LENGTH_SHORT).show();
                        break;
                }

                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}
