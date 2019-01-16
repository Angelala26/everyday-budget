package com.karltech.android.everydaybudget;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    TextView amountTextView;
    TextView todayTextView;
    TextView tomorrowTextView;
    TextView dayAfterTextView;
    Button addButton;
    Button subtractButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect TextViews
        amountTextView = findViewById(R.id.amount_text_view);
        todayTextView = findViewById(R.id.today_text_view);
        tomorrowTextView = findViewById(R.id.tomorrow_text_view);
        dayAfterTextView = findViewById(R.id.day_after_text_view);
        // Connect Buttons
        addButton = findViewById(R.id.add_button);
        subtractButton = findViewById(R.id.subtract_button);

        //add toolbar
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        //add everything for navigation drawer
        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        int id = menuItem.getItemId();
                        switch (id) {
                            case R.id.nav_expenses:
                                Intent i = new Intent(MainActivity.this, EverydayBudget.class);
                                startActivity(i);
                                break;
                            case R.id.nav_income:
                                //Do some thing here
                                // add navigation drawer item onclick method here
                                break;
                            case R.id.nav_home:
                                //Do some thing here
                                // add navigation drawer item onclick method here
                                break;
                            case R.id.nav_large_purchases:
                                //Do some thing here
                                // add navigation drawer item onclick method here
                                break;
                            case R.id.nav_transactions:
                                //Do some thing here
                                // add navigation drawer item onclick method here
                                break;
                        }
                        //not sure if i should return false or true here
                        return true;
                        }
                });

        //connect addButton and make it add income
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: add random income to daily budget amount
            }
        });

        //connect subtractButton and make it add income
        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: add random expense to daily budget amount
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getAmounts() {
        //TODO: create method to get amounts for today, tomorrow, and day after
    }
}
