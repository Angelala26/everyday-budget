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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Income extends MainActivity {

    EditText enterIncomeEditText;
    EditText enterIncomeNamesEditText;
    Button addIncomeButton;
    TextView incomeAmountTextView;
    TextView incomeNameTextView;
    //TODO: show income on line after entered and leave space to enter more incomes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);


        //connect EditTexts
        enterIncomeEditText = findViewById(R.id.enter_income_edit_text);
        enterIncomeNamesEditText = findViewById(R.id.enter_income_names_edit_text);
        addIncomeButton = findViewById(R.id.add_income_button);
        incomeAmountTextView = findViewById(R.id.income_amount_text_view);
        incomeNameTextView = findViewById(R.id.income_name_text_view);

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
                        //get input and add to TextView
                        if (TextUtils.isEmpty(enterIncomeEditText.getText()) ||
                                TextUtils.isEmpty(enterIncomeNamesEditText.getText())) {
                            Toast.makeText(Income.this, "Income Name or Amount Empty", Toast.LENGTH_SHORT).show();
                        } else {
                            String income = enterIncomeEditText.getText().toString() + "\n";
                            String incomeName = enterIncomeNamesEditText.getText().toString() + "\n";
                            incomeAmountTextView.append(income);
                            incomeNameTextView.append(incomeName);
                        }
                        enterIncomeNamesEditText.setText("");
                        enterIncomeEditText.setText("");                        }
                });


    }
}
