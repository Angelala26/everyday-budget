package com.karltech.android.everydaybudget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EverydayBudget extends AppCompatActivity {

    TextView amountPerDayTextView;
    AmountPerDay amountPerDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everyday_budget);

        //connect amountPerDayTextView with TextView
        amountPerDayTextView = findViewById(R.id.amount_per_day_text_view);

        //get the amount per day and set it in the text view
        amountPerDayTextView.setText(getAmountPerDay(amountPerDay));

    }

    //get the amount per day of everything
    private int getAmountPerDay(AmountPerDay amountPerDay) {
        //TODO: call calculateAmountPerDay before getAmountPerDay
        //TODO: call get savings, income, etc before I calculate the amount per day
        return amountPerDay.getAmountPerDay();
    }
}
