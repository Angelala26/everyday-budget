package com.karltech.android.everydaybudget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EverydayBudget extends AppCompatActivity {

    TextView amountPerDayTextView;
    private int income;
    private int expenses;
    private int savings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everyday_budget);

        //connect amountPerDayTextView with TextView
        amountPerDayTextView = findViewById(R.id.amount_per_day_text_view);

        //get the amount per day and set it in the text view
        amountPerDayTextView.setText(calculateAmountPerDay(income, expenses, savings));

    }

    //Calculate the amount per day
    public int calculateAmountPerDay(int income, int expenses, int savings){
        this.income = income;
        this.expenses = expenses;
        this.savings = savings;
        return income - expenses - savings;
    }

}
