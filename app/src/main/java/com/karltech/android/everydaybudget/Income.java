package com.karltech.android.everydaybudget;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Income extends MainActivity {

    EditText enterIncomeEditText;
    EditText enterIncomeNamesEditText;
    Button addIncomeButton;
    //TODO: show income on line after entered and leave space to enter more incomes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);


        //connect EditTexts
        enterIncomeEditText = findViewById(R.id.enter_income_edit_text);
        enterIncomeNamesEditText = findViewById(R.id.enter_expense_names_edit_text);
        addIncomeButton = findViewById(R.id.add_income_button);

        //create new TextView for later
        final TextView incomeDisplay = new TextView(this);

/*
//getting null pointer exception with this because there is no string or double still?
        addIncomeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //convert to string or double
                String income = enterIncomeEditText.getText().toString();
                String incomeName = enterIncomeNamesEditText.getText().toString();
                Double incomeDouble = Double.valueOf(income);

                //TODO: Transfer this info to line in scroll view showing incomes
                //create TextView after clicking
                incomeDisplay.setLayoutParams(new RelativeLayout.LayoutParams
                        (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                incomeDisplay.setText(incomeDouble + "   " + incomeName);
            }
        });
*/


    }
}
