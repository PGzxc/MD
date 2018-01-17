package com.example.az.md;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;
    private ActionMenuView menuView;
    private Button mbtn,mbtn2,mbtn3,mbtn4;
    private Button mbtn5,mbtn6,mbtn7,mbtn8,mbtn9,mbtn10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        menuView = findViewById(R.id.actionmenu);
        mbtn = findViewById(R.id.btn1);
        mbtn2 = findViewById(R.id.btn2);
        mbtn3 = findViewById(R.id.btn3);
        mbtn4 = findViewById(R.id.btn4);
        mbtn5 = findViewById(R.id.btn5);
        mbtn6 = findViewById(R.id.btn6);
        mbtn7 = findViewById(R.id.btn7);
        mbtn8 = findViewById(R.id.btn8);
        mbtn9 = findViewById(R.id.btn9);
        mbtn10 = findViewById(R.id.btn10);
        menuView.setOnMenuItemClickListener(new ActionMenuView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return onOptionsItemSelected(item);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ToolBarActivity.class);
                startActivity(intent);
            }
        });

        mbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });
        mbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CardActivity.class);
                startActivity(intent);
            }
        });
        mbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CombinedActivity.class);
                startActivity(intent);
            }
        });
        mbtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TabActivity.class);
                startActivity(intent);
            }
        });

        mbtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CollapsingActivity.class);
                startActivity(intent);
            }
        });
        mbtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CoordinatorActivity.class);
                startActivity(intent);
            }
        });
        mbtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ImmersiveActivity.class);
                startActivity(intent);
            }
        });
        mbtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StatusActivity.class);
                startActivity(intent);
            }
        });

        mbtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,BottomSheetActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search,menuView.getMenu());
        View v = menuView.getMenu().findItem(R.id.et).getActionView();
        final EditText et = v.findViewById(R.id.etsearch);
        et.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
                    Toast.makeText(MainActivity.this,et.getText().toString(),Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.share:
//                Toast.makeText(this,"share",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.bluetooth:
//                Toast.makeText(this,"bluetooth",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.headset:
//                Toast.makeText(this,"headset",Toast.LENGTH_SHORT).show();
//                break;
//        }
        return true;
    }
}
