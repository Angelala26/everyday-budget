package com.karltech.android.everydaybudget;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.stream.IntStream;

public class EverydayBudget extends MainActivity {

    TextView amountPerDayTextView;
    TextView regularIncomeTextView;
    TextView recurringExpensesTextView;
    TextView bigExpensesTextView;

    Double incomeSum;
    Double expensesSum;
    Double amountPerDay;


    @RequiresApi(api = Build.VERSION_CODES.N)
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


        //get the income array from Income.java
        Income newIncomeObject = new Income();
        String[] incomeArray = newIncomeObject.getIncomeArray();

        //Get the expenses array from Expenses.java
        Expenses newExpensesObject = new Expenses();
        String[] expensesArray = newExpensesObject.getExpensesArray();

        //convert String array to int
        Double [] incomeArrayDouble = new Double [incomeArray.length];
        for(int i=0; i<incomeArray.length; i++) {
            incomeArrayDouble[i] = Double.parseDouble(incomeArray[i]);
        }

        Double [] expensesArrayDouble = new Double [expensesArray.length];
        for(int i=0; i<expensesArray.length; i++) {
            expensesArrayDouble[i] = Double.parseDouble(expensesArray[i]);
        }

        //get sum of income
        incomeSum = 0.00;
        int iI = 0;
        while (iI < 10) {
            incomeSum += incomeArrayDouble[iI];
            iI++;
        }

        expensesSum = 0.00;
        int iE = 0;
        while (iE<10) {
            expensesSum += expensesArrayDouble[iE];
            iE++;
        }

        amountPerDay = calculateAmountPerDay(incomeSum, expensesSum);
        String amountPerDayString = amountPerDay.toString();
        amountPerDayTextView.setText(amountPerDayString);
    }




    //Calculate the amount per day
    //add savings later
    public double calculateAmountPerDay(double income, double expenses) {
        double monthlyAmount = income - expenses;
        double dailyAmountDouble = monthlyAmount / 30.0;
        DecimalFormat df = new DecimalFormat("#.##");
        dailyAmountDouble = Double.parseDouble(df.format(dailyAmountDouble));
        String dailyAmountString = Double.toString(dailyAmountDouble);
        Toast.makeText(this, dailyAmountString, Toast.LENGTH_LONG).show();
        return dailyAmountDouble;

    }
}