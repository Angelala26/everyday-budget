package com.karltech.android.everydaybudget;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Income extends MainActivity {

    EditText enterIncomeEditText;
    EditText enterIncomeNamesEditText;
    Button addIncomeButton;
    private LinearLayout mLayout;


    //TODO: show income on line after entered and leave space to enter more incomes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);


        //connect EditTexts, button, and layout
        enterIncomeEditText = findViewById(R.id.enter_income_edit_text);
        enterIncomeNamesEditText = findViewById(R.id.enter_income_names_edit_text);
        addIncomeButton = findViewById(R.id.add_income_button);
        mLayout = findViewById(R.id.linearLayout);


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
                        //TODO: Transfer this info to line in scroll view showing incomes
                        if (TextUtils.isEmpty(enterIncomeEditText.getText())) {
                            Toast.makeText(Income.this, "Income Empty", Toast.LENGTH_SHORT).show();
                        } else {
                            String income = enterIncomeEditText.getText().toString();
                            //Double incomeDouble = Double.valueOf(income);
                            mLayout.addView( createNewTextView(income));
                        }
                        if (TextUtils.isEmpty(enterIncomeNamesEditText.getText())) {
                            Toast.makeText(Income.this, "Name Empty", Toast.LENGTH_SHORT).show();
                        } else {
                            String incomeName = enterIncomeNamesEditText.getText().toString();
                            mLayout.addView(createNewTextView(incomeName));
                        }
                    }
                });


    }

    private TextView createNewTextView(String incomeName) {
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setText(incomeName);
        return textView;
    }
}
