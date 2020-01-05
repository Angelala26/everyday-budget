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

public class Expenses extends MainActivity {

    EditText enterExpensesEditText;
    EditText enterExpensesNamesEditText;
    Button addExpenseButton;
    TextView expenseAmountTextView;
    TextView expenseNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses);


        //connect editTexts
        enterExpensesEditText = findViewById(R.id.enter_expenses_edit_text);
        enterExpensesNamesEditText = findViewById(R.id.enter_expense_names_edit_text);
        addExpenseButton = findViewById(R.id.add_expense_button);
        expenseAmountTextView = findViewById(R.id.expense_amount_text_view);
        expenseNameTextView = findViewById(R.id.expense_name_text_view);


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
                //TODO: Transfer this info to line in scroll view showing incomes
                if (TextUtils.isEmpty(enterExpensesEditText.getText()) || TextUtils.isEmpty(enterExpensesNamesEditText.getText())) {
                    Toast.makeText(Expenses.this, "Expense Amount or Name Empty", Toast.LENGTH_SHORT).show();
                } else {
                    String income = enterExpensesEditText.getText().toString() + "\n";
                    String incomeName = enterExpensesNamesEditText.getText().toString() + "\n";
                    expenseAmountTextView.append(income);
                    expenseNameTextView.append(incomeName);
                }
                enterExpensesNamesEditText.setText("");
                enterExpensesEditText.setText("");

            }
        });
    }

}
