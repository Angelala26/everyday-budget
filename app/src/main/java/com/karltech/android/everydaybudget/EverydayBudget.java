package com.karltech.android.everydaybudget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class EverydayBudget extends AppCompatActivity {

    TextView amountPerDayTextView;
    Button getBudgetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_everyday_budget);

        //connect amountPerDayTextView with TextView
        amountPerDayTextView = findViewById(R.id.amount_per_day_text_view);
        //connect to button
        getBudgetButton = findViewById(R.id.get_budget_button);

        //set onClickListener with getBudgetButton
        getBudgetButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //connect user inputs to the EditText
                        EditText incomeEditText = findViewById(R.id.income_edit_text);
                        EditText expensesEditText = findViewById(R.id.expenses_edit_text);
                        EditText savingsEditText = findViewById(R.id.savings_edit_text);

                        //get user inputs and convert them to string
                        String incomeString = incomeEditText.getText().toString();
                        String expenseString = expensesEditText.getText().toString();
                        String savingsString = savingsEditText.getText().toString();

                        //convert String to int
                        double incomeDouble = Double.parseDouble(incomeString);
                        double expensesDouble = Double.parseDouble(expenseString);
                        double savingsDouble = Double.parseDouble(savingsString);

//                    //    get the amount per day and set it in the text view
                        amountPerDayTextView.setText
                                (String.valueOf(calculateAmountPerDay
                                        (incomeDouble, expensesDouble, savingsDouble)));


                    }
                }
        );
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