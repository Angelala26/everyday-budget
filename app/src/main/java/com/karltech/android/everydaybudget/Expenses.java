package com.karltech.android.everydaybudget;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Expenses extends MainActivity {

    EditText enterExpensesEditText;
    EditText enterExpensesNamesEditText;
    Button addExpenseButton;
    ListView expenseAmountListView;
    ListView expenseNameListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);

        //connect editTexts
        enterExpensesEditText = findViewById(R.id.enter_expenses_edit_text);
        enterExpensesNamesEditText = findViewById(R.id.enter_expense_names_edit_text);
        addExpenseButton = findViewById(R.id.add_expense_button);
        expenseAmountListView = findViewById(R.id.expense_amount_list_view);
        expenseNameListView = findViewById(R.id.expense_name_list_view);

        //initialize new String Array for listview
        String[] expenses = new String[]{
                ""
        };
        // Create a List from String Array elements
        final List<String> expenses_list = new ArrayList<>(Arrays.asList(expenses));

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, expenses_list);

        //Bind ListView with ArrayAdapter items
        expenseAmountListView.setAdapter(arrayAdapter);


        //initialize new String Array for listview
        String[] expenseNames = new String[]{
                ""
        };
        // Create a List from String Array elements
        final List<String> expenses_names_list = new ArrayList<>(Arrays.asList(expenseNames));

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapterNames = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, expenses_names_list);

        //Bind ListView with ArrayAdapter items
        expenseNameListView.setAdapter(arrayAdapterNames);

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
                                        (Expenses.this, Expenses.class);
                                startActivity(expenseIntent);
                                break;
                            case R.id.nav_income:
                                Intent incomeIntent = new Intent
                                        (Expenses.this, Income.class);
                                startActivity(incomeIntent);
                                break;
                            case R.id.nav_home:
                                Intent homeIntent = new Intent
                                        (Expenses.this, MainActivity.class);
                                startActivity(homeIntent);
                                break;
                            case R.id.nav_large_purchases:
                                Intent budgetIntent = new Intent
                                        (Expenses.this, EverydayBudget.class);
                                startActivity(budgetIntent);
                                break;
                            case R.id.nav_transactions:
                                Intent transactionsIntent = new Intent
                                        (Expenses.this, Transactions.class);
                                startActivity(transactionsIntent);
                                break;
                        }
                        //not sure if i should return false or true here
                        return true;
                    }
                });


        addExpenseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (TextUtils.isEmpty(enterExpensesEditText.getText()) || TextUtils.isEmpty(enterExpensesNamesEditText.getText())) {
                    Toast.makeText(Expenses.this, "Expense Amount or Name Empty", Toast.LENGTH_SHORT).show();
                } else {
                    String expenses = enterExpensesEditText.getText().toString() + "\n";
                    String expenseName = enterExpensesNamesEditText.getText().toString() + "\n";
                    //add new expenses to list and notify data set changed
                    expenses_list.add(expenses);
                    expenses_names_list.add(expenseName);

                    arrayAdapter.notifyDataSetChanged();
                    arrayAdapterNames.notifyDataSetChanged();

                }
                enterExpensesNamesEditText.setText("");
                enterExpensesEditText.setText("");

            }
        });
    }

}
