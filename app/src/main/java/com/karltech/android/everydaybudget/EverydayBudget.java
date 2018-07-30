package com.karltech.android.everydaybudget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

public class EverydayBudget extends AppCompatActivity {

    TextView amountPerDayTextView;

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

//        //get user inputs and convert them to string
//        String incomeString = incomeEditText.getText().toString();
//        String expenseString = expensesEditText.getText().toString();
//        String savingsString = savingsEditText.getText().toString();
//
//        //input a number so it isn't empty when trying to parse
//        incomeString = "0";
//        expenseString = "0";
//        savingsString = "0";
//
//        //convert String to int
//        int incomeInt = Integer.parseInt(incomeString);
//        int expensesInt = Integer.parseInt(expenseString);
//        int savingsInt = Integer.parseInt(savingsString);

        //TODO: have users write in their amounts, connect them with income, expenses, and savings
        //TODO: and then calculate the amounts
        //get the amount per day and set it in the text view
//        amountPerDayTextView.setText(calculateAmountPerDay(incomeInt, expensesInt, savingsInt));

    }

    //Calculate the amount per day
    public int calculateAmountPerDay(int income, int expenses, int savings){
        return income - expenses - savings;
    }

}
