package com.karltech.android.everydaybudget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
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

        //connect user inputs to the EditText
        EditText incomeEditText = findViewById(R.id.income_edit_text);
        EditText expensesEditText = findViewById(R.id.expenses_edit_text);
        EditText savingsEditText = findViewById(R.id.savings_edit_text);

        //get user inputs and convert them to string
        String incomeString = incomeEditText.getText().toString();
        String expenseString = expensesEditText.getText().toString();
        String savingsString = savingsEditText.getText().toString();

        //convert String to int
        int incomeInt = ;

        //TODO: have users write in their amounts, connect them with income, expenses, and savings
        //TODO: and then calculate the amounts
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
