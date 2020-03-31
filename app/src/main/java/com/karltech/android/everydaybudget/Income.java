package com.karltech.android.everydaybudget;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Income extends MainActivity {

    EditText enterIncomeEditText;
    EditText enterIncomeNamesEditText;
    Button addIncomeButton;
    ListView incomeAmountListView;
    ListView incomeNameListView;

    //for listview synced scrolling
    boolean isLeftListEnabled = true;
    boolean isRightListEnabled = true;

    // new String Array for listview
    private String[] incomeArray;
    //create getters
    public String[] getIncomeArray() {
        return  incomeArray;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        //initialize new String array
        incomeArray = new String[]{
                ""
        };

        //connect EditTexts
        enterIncomeEditText = findViewById(R.id.enter_income_edit_text);
        enterIncomeNamesEditText = findViewById(R.id.enter_income_names_edit_text);
        addIncomeButton = findViewById(R.id.add_income_button);
        incomeAmountListView = findViewById(R.id.income_amount_list_view);
        incomeNameListView = findViewById(R.id.income_name_list_view);

        // Create a List from String Array elements
        final List<String> income_list = new ArrayList<>(Arrays.asList(incomeArray));

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, income_list);

        //Bind ListView with ArrayAdapter items
        incomeAmountListView.setAdapter(arrayAdapter);


        //initialize new String Array for listview
        String[] incomeNames = new String[]{
                ""
        };
        // Create a List from String Array elements
        final List<String> income_names_list = new ArrayList<>(Arrays.asList(incomeNames));

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapterNames = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, income_names_list);

        //Bind ListView with ArrayAdapter items
        incomeNameListView.setAdapter(arrayAdapterNames);

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

                        int id = menuItem.getItemId();
                        switch (id) {
                            case R.id.nav_expenses:
                                Intent expenseIntent = new Intent
                                        (Income.this, Expenses.class);
                                startActivity(expenseIntent);
                                break;
                            case R.id.nav_income:
                                Intent incomeIntent = new Intent
                                        (Income.this, Income.class);
                                startActivity(incomeIntent);
                                break;
                            case R.id.nav_home:
                                Intent homeIntent = new Intent
                                        (Income.this, MainActivity.class);
                                startActivity(homeIntent);
                                break;
                            case R.id.nav_large_purchases:
                                Intent budgetIntent = new Intent
                                        (Income.this, EverydayBudget.class);
                                startActivity(budgetIntent);
                                break;
                            case R.id.nav_transactions:
                                Intent transactionsIntent = new Intent
                                        (Income.this, Transactions.class);
                                startActivity(transactionsIntent);
                                break;
                        }
                        //not sure if i should return false or true here
                        return true;
                    }
                });


        addIncomeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TextUtils.isEmpty(enterIncomeEditText.getText()) ||
                        TextUtils.isEmpty(enterIncomeNamesEditText.getText())) {
                    Toast.makeText(Income.this, "Income Name or Amount Empty", Toast.LENGTH_SHORT).show();
                } else {
                    String income = enterIncomeEditText.getText().toString() + "\n";
                    String incomeName = enterIncomeNamesEditText.getText().toString() + "\n";
                    //add new expenses to list and notify data set changed
                    income_list.add(income);
                    income_names_list.add(incomeName);

                    arrayAdapter.notifyDataSetChanged();
                    arrayAdapterNames.notifyDataSetChanged();
                }
                enterIncomeNamesEditText.setText("");
                enterIncomeEditText.setText("");



                //all methods to sync scrolling of listviews

                // IF YOU DO NOT OVERRIDE THIS
                // ONLY THE ONE THAT IS TOUCHED WILL SCROLL OVER
                incomeNameListView.setOverScrollMode(ListView.OVER_SCROLL_NEVER);
                incomeAmountListView.setOverScrollMode(ListView.OVER_SCROLL_NEVER);

                incomeNameListView.setOnScrollListener(new AbsListView.OnScrollListener() {

                    @Override
                    public void onScrollStateChanged(AbsListView view, int scrollState) {
                        // onScroll will be called and there will be an infinite loop.
                        // That's why i set a boolean value
                        if (scrollState == SCROLL_STATE_TOUCH_SCROLL) {
                            isRightListEnabled = false;
                        } else if (scrollState == SCROLL_STATE_IDLE) {
                            isRightListEnabled = true;
                        }
                    }

                    @Override
                    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                                         int totalItemCount) {
                        View c = view.getChildAt(0);
                        if (c != null && isLeftListEnabled) {
                            incomeAmountListView.setSelectionFromTop(firstVisibleItem, c.getTop());
                        }
                    }
                });

                incomeAmountListView.setOnScrollListener(new AbsListView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(AbsListView view, int scrollState) {
                        if (scrollState == SCROLL_STATE_TOUCH_SCROLL) {
                            isLeftListEnabled = false;
                        } else if (scrollState == SCROLL_STATE_IDLE) {
                            isLeftListEnabled = true;
                        }
                    }

                    @Override
                    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                                         int totalItemCount) {
                        View c = view.getChildAt(0);
                        if (c != null && isRightListEnabled) {
                            incomeNameListView.setSelectionFromTop(firstVisibleItem, c.getTop());
                        }
                    }
                });
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);
    }

}
