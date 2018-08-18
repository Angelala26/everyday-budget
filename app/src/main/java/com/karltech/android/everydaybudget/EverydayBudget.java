package com.karltech.android.everydaybudget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.DecimalFormat;

public class EverydayBudget extends AppCompatActivity {

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