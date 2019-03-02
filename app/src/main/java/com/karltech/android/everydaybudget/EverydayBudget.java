package com.karltech.android.everydaybudget;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.widget.TextView;

import java.text.DecimalFormat;

public class EverydayBudget extends MainActivity {

    TextView amountPerDayTextView;
    TextView regularIncomeTextView;
    TextView recurringExpensesTextView;
    TextView bigExpensesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everyday_budget);

        //connect TextViews with TextView from xml
        amountPerDayTextView = findViewById(R.id.amount_per_day_text_view);
        regularIncomeTextView = findViewById(R.id.regular_income_text_view);
        recurringExpensesTextView = findViewById(R.id.recurring_expenses_text_view);
        bigExpensesTextView = findViewById(R.id.big_expenses_text_view);

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
                                        (EverydayBudget.this, Expenses.class);
                                startActivity(expenseIntent);
                                break;
                            case R.id.nav_income:
                                Intent incomeIntent = new Intent
                                        (EverydayBudget.this, Income.class);
                                startActivity(incomeIntent);
                                break;
                            case R.id.nav_home:
                                Intent homeIntent = new Intent
                                        (EverydayBudget.this, MainActivity.class);
                                startActivity(homeIntent);
                                break;
                            case R.id.nav_large_purchases:
                                Intent budgetIntent = new Intent
                                        (EverydayBudget.this, EverydayBudget.class);
                                startActivity(budgetIntent);
                                break;
                            case R.id.nav_transactions:
                                Intent transactionsIntent = new Intent
                                        (EverydayBudget.this, Transactions.class);
                                startActivity(transactionsIntent);
                                break;
                        }
                        //not sure if i should return false or true here
                        return true;
                    }
                });

        }

    //Calculate the amount per day
    public double calculateAmountPerDay(double income, double expenses, double savings) {
        double monthlyAmount = income - expenses - savings;
        double dailyAmountDouble = monthlyAmount / 30.0;
        DecimalFormat df = new DecimalFormat("#.##");
        dailyAmountDouble = Double.valueOf(df.format(dailyAmountDouble));
        return dailyAmountDouble;

    }
}