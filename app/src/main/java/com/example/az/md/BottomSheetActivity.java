package com.example.az.md;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

/**
 * Created by az on 2018/1/3.
 */

public class BottomSheetActivity extends AppCompatActivity{
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private FloatingActionButton mFloatingActionButton;
    private CoordinatorLayout mCoordinatorLayout;
    private NavigationView mNavigationView;

    private Button mShowBottomSheet;
    private Button mBtn2;
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

        View bottomSheet = findViewById(R.id.design_bottom_sheet);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        //默认设置为隐藏
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        mShowBottomSheet = findViewById(R.id.btn1);
        mShowBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheet(behavior);
            }
        });

        mBtn2 = findViewById(R.id.btn2);

        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });

    }


    private void showBottomSheet(BottomSheetBehavior behavior) {
        if (behavior.getState() == BottomSheetBehavior.STATE_HIDDEN) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            mShowBottomSheet.setText("隐藏");
        } else {
            behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            mShowBottomSheet.setText("显示");
        }
    }

    private void showBottomSheetDialog() {
        BottomSheetFragment fragment = BottomSheetFragment.newInstance();
        fragment.show(getSupportFragmentManager(),BottomSheetFragment.class.getSimpleName());
    }


}
